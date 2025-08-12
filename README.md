# 🎁 Spring Gift Order

> **카카오테크캠퍼스** 백엔드 과정에서 학습용으로 개발한 선물 주문 시스템입니다.

## 📋 프로젝트 개요

이 프로젝트는 카카오테크캠퍼스의 백엔드 개발 과정에서 Spring Boot와 JPA를 활용한 웹 애플리케이션 개발을 학습하기 위해 제작되었습니다. 카카오 로그인 API와 카카오 메시지 API를 연동하여 실제 서비스와 유사한 기능을 구현했습니다.

## 🛠 기술 스택

- **Backend**: Java 21, Spring Boot 3.3.1
- **Database**: H2 Database (인메모리)
- **ORM**: Spring Data JPA
- **Security**: JWT Token, Spring Security Crypto
- **API Documentation**: SpringDoc OpenAPI (Swagger UI)
- **Template Engine**: Thymeleaf
- **External API**: 카카오 로그인, 카카오 메시지

## 🌟 주요 기능

### 인증 및 회원관리
- 카카오 소셜 로그인
- JWT 토큰 기반 인증
- 회원 정보 관리

### 상품 관리
- 상품 목록 조회 및 검색
- 카테고리별 상품 분류
- 관리자 상품 등록/수정/삭제
- 상품 옵션 관리

### 위시리스트
- 관심 상품 등록/삭제
- 개인별 위시리스트 관리

### 주문 시스템
- 상품 옵션 선택 및 수량 지정
- 주문 시 재고 차감
- 위시리스트에서 자동 삭제
- 주문 완료 시 카카오 메시지 발송

### API 문서화
- Swagger UI를 통한 API 문서 자동 생성
- RESTful API 설계

## 🏗 프로젝트 구조

```
src/main/java/gift/
├── config/          # 설정 파일
├── controller/      # 컨트롤러 (웹 & REST API)
├── dto/            # 데이터 전송 객체
├── entity/         # JPA 엔티티
├── exception/      # 커스텀 예외
├── filter/         # 필터 (JWT)
├── handler/        # 예외 핸들러
├── repository/     # 데이터 접근 계층
├── service/        # 비즈니스 로직
└── util/           # 유틸리티 클래스
```

## 🚀 실행 방법

### 1. 필수 요구사항
- Java 21
- Gradle

### 2. 환경 설정
`src/main/resources/application-secret.properties` 파일에 카카오 API 정보를 설정해주세요:
```properties
kakao.client-id=YOUR_KAKAO_CLIENT_ID
kakao.redirect-url=YOUR_KAKAO_REDIRECT_URL
kakao.url=YOUR_KAKAO_API_URL
```

### 3. 실행
```bash
./gradlew bootRun
```

### 4. 접속
- 애플리케이션: http://localhost:8000
- H2 콘솔: http://localhost:8000/h2-console
- API 문서: http://localhost:8000/swagger-ui/index.html

## 📚 학습 내용

이 프로젝트를 통해 다음과 같은 내용을 학습했습니다:

- Spring Boot 기반 웹 애플리케이션 개발
- JPA를 활용한 데이터베이스 연동
- RESTful API 설계 및 구현
- 외부 API (카카오) 연동
- JWT 토큰 기반 인증 구현
- 예외 처리 및 글로벌 예외 핸들러
- 단위 테스트 작성
- API 문서화 (Swagger)

## 📝 개발 히스토리

### 0단계
- import.sql에 ID 명시적 작성
- 예외처리 메시지 추가 및 테스트 코드 적용
- 코드 정리 (Code Pruning)

### 1단계
- 카카오 로그인 API 적용
- RestTemplateTest 클래스 추가

### 2단계
- 주문 시 수령인에게 보낼 메시지 작성 기능
- 상품 옵션과 수량 선택하여 주문 시 재고 차감
- 주문한 상품이 위시리스트에 있는 경우 자동 삭제
- 주문 후 카카오 메시지 발송

### 3단계
- Map 객체 사용 최소화
- Swagger UI 적용
- API 문서 자동 생성

---

> ⚠️ **주의사항**: 이 프로젝트는 학습 목적으로 제작되었으며, 실제 운영 환경에서 사용하기에는 보안 및 성능 최적화가 필요합니다.
