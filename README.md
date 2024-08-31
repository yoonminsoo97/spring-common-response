<div align="center">
    <h1>API 요청 성공 및 예외 발생 시 공통 응답 처리</h1>
</div>

### 프로젝트 환경

- Java 17.0.10
- Spring Boot 3.3.3
  - Spring Web MVC 6.1.12
  - Spring Data JPA 3.3.3 (hibernate 6.5.2)
- Lombok 1.18,34
- Jakarta Validation API 3.0.2

## 공통 응답 포맷

응답 포맷에 공통 속성은 `status`로 API 요청 성공/실패 여부를 나타낸다.

- **success:** 요청 성공
- **fail:** 요청 실패

### 요청 성공

#### 응답 데이터가 없는 경우

```json
{
  "status": "success"
}
```

- 응답할 데이터가 없을 경우 `data` 속성이 응답 포맷에 포함되지 않는다.

#### 응답 데이터가 있는 경우

```json
{
  "status": "success",
  "data": {
    "nickname": "yoonKun",
    "username": "yoon1234"
  }
}
```

### 요청 실패

#### 입력값 유효성 예외가 없는 경우

```json
{
  "status": "fail",
  "error": {
    "code": "E409001",
    "message": "사용 중인 닉네임입니다."
  }
}
```

- 입력값 유효성 예외가 발생하지 않았을 경우 `fields` 속성이 응답 포맷에 포함되지 않는다.

#### 입력값 유효성 예외가 있는 경우

```json
{
  "status": "fail",
  "error": {
    "code": "E400001",
    "message": "입력값이 잘못되었습니다.",
    "fields": [
      {
        "field": "nickname",
        "input": "",
        "message": "닉네임을 입력해 주세요."
      },
      {
        "field": "username",
        "input": "",
        "message": "아이디를 입력해 주세요."
      }
    ]
  }
}
```