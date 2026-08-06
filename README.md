# ChatKiosk26

AI 기반 메뉴 추천, 주문, 관리자 메뉴·판매 통계를 제공하는 키오스크 MVP입니다.

## 디렉터리 구조

```text
.
├── backend/                  # Spring Boot 애플리케이션
├── frontend/                 # React 애플리케이션
├── .github/                  # PR 템플릿 등 협업 설정
├── PLAN.md                   # 프로젝트 범위와 실행 계획
├── CODE_CONVENTION.md        # 코드 컨벤션
└── COMMIT_CONVENTION.md      # 커밋 컨벤션
```

<details>
<summary>Frontend 구조 (React · React Router)</summary>

```text
frontend/
└── chatkiosk26/
    └── src/
        ├── api/                 # Axios 인스턴스·공통 API 설정
        ├── components/          # 여러 화면에서 재사용하는 UI
        ├── contexts/            # CartContext 등 전역 상태
        ├── features/            # 기능별 UI·API 연결
        │   ├── cart/
        │   ├── menu/
        │   ├── order/
        │   ├── recommendation/
        │   └── admin/
        ├── layouts/             # CustomerLayout, AdminLayout
        ├── pages/               # 라우트 단위 화면
        │   ├── customer/
        │   └── admin/
        ├── routes/              # React Router 경로 정의
        ├── hooks/               # 재사용 커스텀 훅
        ├── utils/               # 금액·날짜 포맷 등 순수 유틸
        ├── App.jsx
        └── main.jsx
```

- `pages`는 URL 단위 화면, `features`는 기능 단위 코드로 구성한다.
- 특정 기능에서만 쓰는 코드는 해당 `features` 디렉터리에 두고, 공통 코드만 최상위 디렉터리에 둔다.

</details>

<details>
<summary>Backend 구조 (Spring Boot)</summary>

```text
backend/
└── src/
    ├── main/
    │   ├── java/com/chatkiosk/
    │   │   ├── common/
    │   │   │   ├── config/
    │   │   │   ├── exception/
    │   │   │   └── response/
    │   │   ├── menu/
    │   │   │   ├── controller/
    │   │   │   ├── service/
    │   │   │   ├── repository/
    │   │   │   ├── domain/
    │   │   │   └── dto/
    │   │   ├── order/
    │   │   │   ├── controller/
    │   │   │   ├── service/
    │   │   │   ├── repository/
    │   │   │   ├── domain/
    │   │   │   └── dto/
    │   │   ├── recommendation/
    │   │   │   ├── controller/
    │   │   │   ├── service/
    │   │   │   └── dto/
    │   │   └── statistics/
    │   │       ├── controller/
    │   │       ├── service/
    │   │       ├── repository/
    │   │       └── dto/
    │   └── resources/
    │       ├── application.yml
    │       └── db/migration/    # Flyway 마이그레이션
    └── test/
```

- 업무 기능은 `menu`, `order`처럼 최상위 패키지로 분리한다.
- `common`에는 실제로 여러 기능이 공유하는 설정·예외·응답 코드만 둔다.

</details>
