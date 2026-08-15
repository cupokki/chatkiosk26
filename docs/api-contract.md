# API 계약 명세서 (API Contract Specification)

## 1. 개요 및 환경 설정

본 문서는 **AI 키오스크 기반 스마트 주문 및 관리 시스템**의 RESTful API 명세서임.
고객용 메뉴 탐색, AI 대화형 장바구니 조작, 주문/결제 스텁 및 관리자용 메뉴 CRUD, QueryDSL 동적 검색, 판매 통계 API를 포함함.

Postman에 직접 임포트하여 테스트할 수 있도록 동일 디렉터리에 [`docs/postman-collection.json`](file:///home/cupokki/project/chatkiosk26/docs/postman-collection.json) 및 [`docs/openapi.json`](file:///home/cupokki/project/chatkiosk26/docs/openapi.json) 파일이 함께 제공됨.

### Base URL 및 공통 헤더

- **Base URL**: `http://localhost:8080` (Postman 변수 `{{baseUrl}}`)
- **Content-Type**: `application/json;charset=UTF-8`

### 공통 응답 구조 (Standard Response Envelope)

#### 성공 응답 (200 OK, 201 Created)
```json
{
  "success": true,
  "data": { ... },
  "message": "요청이 성공적으로 처리되었습니다."
}
```

#### 에러 응답 (4xx, 5xx)
```json
{
  "success": false,
  "code": "INVALID_INPUT_VALUE",
  "message": "입력값이 유효하지 않습니다.",
  "errors": [
    {
      "field": "price",
      "value": "-1000",
      "reason": "가격은 0원 이상이어야 합니다."
    }
  ]
}
```

---

## 2. API Endpoint 요약표

| 구분 | 메서드 | URI 경로 | 기능 설명 | 유즈케이스 |
| --- | --- | --- | --- | --- |
| **공통** | GET | `/api/v1/stores` | 전체 활성 매장 목록 조회 | UC-C01 |
| **공통** | POST | `/api/v1/stores` | 신규 매장 등록 | UC-A01 |
| **고객** | GET | `/api/v1/stores/{storeId}/categories` | 매장별 카테고리 목록 조회 | UC-C01 |
| **고객** | GET | `/api/v1/stores/{storeId}/menus` | 매장별 판매 가능 메뉴 목록 조회 | UC-C01 |
| **고객** | POST | `/api/v1/stores/{storeId}/ai/cart-actions` | LangChain 대화형 장바구니 액션 파싱 | UC-C02 |
| **고객** | POST | `/api/v1/stores/{storeId}/orders` | 장바구니 기반 주문 생성 및 결제 스텁 | UC-C04 |
| **관리자** | POST | `/api/v1/admin/stores/{storeId}/menus` | 신규 메뉴 등록 | UC-A01 |
| **관리자** | GET | `/api/v1/admin/stores/{storeId}/menus` | QueryDSL 동적 메뉴 검색 (페이징) | UC-A04 |
| **관리자** | PATCH | `/api/v1/admin/stores/{storeId}/menus/{menuId}` | 메뉴 정보 및 판매 상태(`available`) 수정 | UC-A02 |
| **관리자** | DELETE | `/api/v1/admin/stores/{storeId}/menus/{menuId}` | 메뉴 소프트 딜리트 | UC-A03 |
| **관리자** | GET | `/api/v1/admin/stores/{storeId}/statistics/sales` | 기간/카테고리별 매출 통계 조회 | UC-A05 |
| **관리자** | GET | `/api/v1/admin/tags` | 전체 태그 목록 조회 | UC-A01 |
| **관리자** | POST | `/api/v1/admin/tags` | 신규 태그 등록 | UC-A01 |

---

## 3. 상세 API 명세

---

### 3.1 [고객] 매장 카테고리 목록 조회
* **HTTP Method**: `GET`
* **URI**: `/api/v1/stores/{storeId}/categories`
* **설명**: 고객 키오스크 화면에 표시할 판매 가능한 카테고리 목록을 정렬 순서대로 반환함.

#### 응답 예시 (200 OK)
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "name": "메인요리",
      "displayOrder": 1
    },
    {
      "id": 2,
      "name": "사이드/음료",
      "displayOrder": 2
    }
  ],
  "message": "카테고리 목록 조회가 완료되었습니다."
}
```

---

### 3.2 [고객] 메뉴 목록 조회
* **HTTP Method**: `GET`
* **URI**: `/api/v1/stores/{storeId}/menus`
* **Query Parameters**:
  * `categoryId` (BIGINT, Optional): 카테고리 필터링

#### 응답 예시 (200 OK)
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "name": "김치찌개",
      "price": 9000,
      "description": "얼큰하고 칼칼한 돼지고기 김치찌개",
      "available": true,
      "categoryId": 1,
      "categoryName": "메인요리",
      "tags": [
        { "id": 1, "name": "인기" },
        { "id": 2, "name": "매콤" }
      ]
    },
    {
      "id": 2,
      "name": "콜라",
      "price": 2000,
      "description": "시원한 캔콜라 355ml",
      "available": true,
      "categoryId": 2,
      "categoryName": "사이드/음료",
      "tags": []
    }
  ],
  "message": "메뉴 목록 조회가 완료되었습니다."
}
```

---

### 3.3 [고객] AI 대화형 장바구니 조작
* **HTTP Method**: `POST`
* **URI**: `/api/v1/stores/{storeId}/ai/cart-actions`
* **설명**: 고객의 자연어 입력과 현재 장바구니 상태를 LangChain(LLM)에 전달하여 해석된 작업(`ADD`, `REMOVE`, `CHANGE_QUANTITY`)을 검증 반영함.

#### 요청 예시
```json
{
  "userMessage": "김치찌개 하나 담아주고 콜라는 빼줘",
  "currentCart": [
    {
      "menuId": 2,
      "menuName": "콜라",
      "quantity": 1,
      "unitPrice": 2000
    }
  ]
}
```

#### 응답 예시 (200 OK - 성공)
```json
{
  "success": true,
  "data": {
    "replyMessage": "김치찌개 1개를 장바구니에 담았고, 콜라를 제외했습니다.",
    "actions": [
      {
        "type": "ADD",
        "menuId": 1,
        "menuName": "김치찌개",
        "quantity": 1,
        "unitPrice": 9000,
        "applied": true,
        "reason": null
      },
      {
        "type": "REMOVE",
        "menuId": 2,
        "menuName": "콜라",
        "quantity": 0,
        "unitPrice": 2000,
        "applied": true,
        "reason": null
      }
    ],
    "updatedCart": [
      {
        "menuId": 1,
        "menuName": "김치찌개",
        "quantity": 1,
        "unitPrice": 9000,
        "subtotal": 9000
      }
    ],
    "totalAmount": 9000
  },
  "message": "장바구니 조작이 반영되었습니다."
}
```

#### 응답 예시 (200 OK - LLM/검증 예외 isolation)
```json
{
  "success": true,
  "data": {
    "replyMessage": "현재 '갈비탕' 메뉴는 판매가 중지되어 주문할 수 없습니다.",
    "actions": [
      {
        "type": "ADD",
        "menuId": 5,
        "menuName": "갈비탕",
        "quantity": 1,
        "unitPrice": 12000,
        "applied": false,
        "reason": "품절/판매 중지된 메뉴입니다."
      }
    ],
    "updatedCart": [],
    "totalAmount": 0
  },
  "message": "일부 액션이 거부되었습니다."
}
```

---

### 3.4 [고객] 주문 완료 및 결제 스텁
* **HTTP Method**: `POST`
* **URI**: `/api/v1/stores/{storeId}/orders`
* **설명**: 장바구니 항목으로 주문(`Orders`) 및 단가 스냅샷(`OrderItem`)을 생성하고 승인 처리함.

#### 요청 예시
```json
{
  "items": [
    {
      "menuId": 1,
      "quantity": 2
    },
    {
      "menuId": 2,
      "quantity": 1
    }
  ]
}
```

#### 응답 예시 (201 Created)
```json
{
  "success": true,
  "data": {
    "orderId": 1001,
    "storeId": 1,
    "totalAmount": 20000,
    "status": "COMPLETED",
    "orderedAt": "2026-08-14T14:47:00Z",
    "items": [
      {
        "orderItemId": 1,
        "menuId": 1,
        "menuName": "김치찌개",
        "unitPrice": 9000,
        "quantity": 2,
        "subtotal": 18000
      },
      {
        "orderItemId": 2,
        "menuId": 2,
        "menuName": "콜라",
        "unitPrice": 2000,
        "quantity": 1,
        "subtotal": 2000
      }
    ]
  },
  "message": "주문이 완료되었습니다."
}
```

---

### 3.5 [관리자] 신규 메뉴 등록
* **HTTP Method**: `POST`
* **URI**: `/api/v1/admin/stores/{storeId}/menus`

#### 요청 예시
```json
{
  "categoryId": 1,
  "name": "돈까스",
  "price": 10000,
  "description": "바삭하고 촉촉한 등심 돈까스",
  "available": true,
  "tagIds": [1, 3]
}
```

#### 응답 예시 (201 Created)
```json
{
  "success": true,
  "data": {
    "id": 3,
    "storeId": 1,
    "categoryId": 1,
    "name": "돈까스",
    "price": 10000,
    "description": "바삭하고 촉촉한 등심 돈까스",
    "available": true,
    "tags": [
      { "id": 1, "name": "인기" },
      { "id": 3, "name": "추천" }
    ],
    "createdAt": "2026-08-14T14:47:00Z"
  },
  "message": "메뉴가 성공적으로 등록되었습니다."
}
```

---

### 3.6 [관리자] 동적 메뉴 검색 (QueryDSL)
* **HTTP Method**: `GET`
* **URI**: `/api/v1/admin/stores/{storeId}/menus`
* **Query Parameters**:
  * `keyword` (String): 메뉴명 또는 설명 검색 키워드
  * `categoryId` (BIGINT): 카테고리 ID
  * `tagId` (BIGINT): 태그 ID
  * `available` (Boolean): 판매 가능 여부
  * `minPrice` (Integer): 최소 가격
  * `maxPrice` (Integer): 최대 가격
  * `page` (Integer, Default: 0): 페이지 번호
  * `size` (Integer, Default: 10): 페이지 크기

#### 응답 예시 (200 OK)
```json
{
  "success": true,
  "data": {
    "content": [
      {
        "id": 1,
        "name": "김치찌개",
        "price": 9000,
        "description": "얼큰한 김치찌개",
        "available": true,
        "categoryName": "메인요리",
        "tags": ["인기", "매콤"]
      }
    ],
    "pageNumber": 0,
    "pageSize": 10,
    "totalElements": 1,
    "totalPages": 1,
    "isLast": true
  },
  "message": "동적 메뉴 검색 결과입니다."
}
```

---

### 3.7 [관리자] 메뉴 수정 및 상태 변경
* **HTTP Method**: `PATCH`
* **URI**: `/api/v1/admin/stores/{storeId}/menus/{menuId}`

#### 요청 예시
```json
{
  "name": "특제 김치찌개",
  "price": 9500,
  "available": false,
  "tagIds": [1, 2]
}
```

#### 응답 예시 (200 OK)
```json
{
  "success": true,
  "data": {
    "id": 1,
    "name": "특제 김치찌개",
    "price": 9500,
    "available": false,
    "updatedAt": "2026-08-14T14:47:00Z"
  },
  "message": "메뉴 정보가 수정되었습니다."
}
```

---

### 3.8 [관리자] 메뉴 소프트 딜리트
* **HTTP Method**: `DELETE`
* **URI**: `/api/v1/admin/stores/{storeId}/menus/{menuId}`

#### 응답 예시 (200 OK)
```json
{
  "success": true,
  "data": {
    "menuId": 1,
    "deletedAt": "2026-08-14T14:47:00Z"
  },
  "message": "메뉴가 소프트 딜리트 처리되었습니다."
}
```

---

### 3.9 [관리자] 판매 통계 조회
* **HTTP Method**: `GET`
* **URI**: `/api/v1/admin/stores/{storeId}/statistics/sales`
* **Query Parameters**:
  * `startDate` (String, Format: YYYY-MM-DD): 조회 시작일
  * `endDate` (String, Format: YYYY-MM-DD): 조회 종료일
  * `categoryId` (BIGINT, Optional): 특정 카테고리 필터

#### 응답 예시 (200 OK)
```json
{
  "success": true,
  "data": {
    "storeId": 1,
    "startDate": "2026-08-01",
    "endDate": "2026-08-14",
    "totalRevenue": 2500000,
    "totalQuantity": 280,
    "topMenus": [
      {
        "menuId": 1,
        "menuName": "김치찌개",
        "totalQuantity": 110,
        "totalRevenue": 990000
      },
      {
        "menuId": 3,
        "menuName": "돈까스",
        "totalQuantity": 90,
        "totalRevenue": 900000
      }
    ]
  },
  "message": "판매 통계 조회가 완료되었습니다."
}
```

---
