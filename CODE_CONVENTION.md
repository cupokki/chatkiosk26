# 코드 컨벤션

## 공통

- 이름만으로 의미가 드러나게 작성하고, `data`, `temp` 같은 모호한 이름은 피한다.
- 한 함수는 하나의 역할만 수행한다. 불필요하게 깊은 조건문은 early return으로 줄인다.
- 자명한 주석은 쓰지 않고, 판단 이유나 제약만 기록한다.
- 미사용 코드, 주석 처리한 코드, 디버그 로그는 커밋 전에 제거한다.

## 디렉터리 구조

```text
.
├── backend/                 # Spring Boot 애플리케이션
├── frontend/                # React 애플리케이션
├── .github/                 # PR 템플릿 등 협업 설정
├── PLAN.md                  # 프로젝트 범위와 실행 계획
└── *_CONVENTION.md          # 협업 규칙 문서
```

- 최상위 디렉터리는 역할이 분명할 때만 추가한다.
- Frontend는 화면·기능 단위로 구성하고, 공통 UI와 API 모듈만 별도로 분리한다.
- Backend는 기능 단위 패키지를 우선하며, 여러 기능이 공유하는 코드만 `common`에 둔다.

## Frontend (React · JavaScript)

- 파일·폴더는 `kebab-case`를 사용한다.
- 컴포넌트는 `PascalCase`, 변수·함수는 `camelCase`, 상수는 `UPPER_SNAKE_CASE`를 사용한다.
- 컴포넌트는 화면 구성에 집중하고, API 호출은 별도 API 모듈로 분리한다.
- 기능별 코드는 해당 화면 또는 기능 디렉터리 안에 함께 둔다.
- 상태 관리는 `useState`, `useContext`만 사용한다.
- 서버 통신은 Axios, 스타일은 Tailwind CSS로 통일한다.
- ESLint와 포맷터 결과를 코드 스타일의 기준으로 삼는다.

## Backend (Spring Boot)

- 패키지는 기능 중심으로 구성한다. 예: `order`, `menu`, `common`.
- 각 기능 내부에는 필요에 따라 `controller`, `service`, `repository`, `domain`, `dto`를 둔다.
- 클래스는 `PascalCase`, 필드·메서드는 `camelCase`, 상수는 `UPPER_SNAKE_CASE`를 사용한다.
- API 경로는 복수형 명사와 소문자·하이픈을 사용한다. 예: `/api/v1/menu-items`.
- Controller는 요청 검증과 응답 처리만 하고, 비즈니스 로직은 Service에 둔다.
- Entity는 API에 직접 노출하지 않고 요청·응답 DTO를 사용한다.
- DTO에서 Bean Validation으로 입력값을 검증한다.
- 예외는 `@RestControllerAdvice`에서 공통 처리하며, 오류 응답 형식은 `code`, `message`, `timestamp`로 통일한다.
- 트랜잭션은 Service 계층에서 선언하고, 조회 메서드에는 `@Transactional(readOnly = true)`를 사용한다.
- 의존성 주입은 생성자 주입만 사용한다. `@RequiredArgsConstructor` 사용은 허용한다.
- 비밀값은 환경 변수로 관리하고 커밋하지 않는다. DB 변경은 마이그레이션으로 관리한다.
