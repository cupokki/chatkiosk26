# 커밋 컨벤션

형식:

```text
<type>: <summary>
```

- `summary`는 소문자 영어로, 50자 이내의 명령형으로 작성한다.
- 한 커밋에는 하나의 목적만 담는다.
- 작업 중인 코드나 불필요한 포맷 변경은 섞지 않는다.

| Type | 용도 |
| --- | --- |
| `feat` | 기능 추가 |
| `fix` | 버그 수정 |
| `refactor` | 동작 변경 없는 구조 개선 |
| `style` | 포맷·스타일 변경 |
| `docs` | 문서 변경 |
| `test` | 테스트 추가·수정 |
| `chore` | 설정·의존성 등 기타 작업 |

예시:

```text
feat: add menu category filter
fix: prevent duplicate order requests
docs: add code convention
```
