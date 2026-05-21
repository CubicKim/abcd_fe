# 1단계: 빌드 환경 (가상 공간에서 자바 코드를 빌드합니다)
FROM amazoncorretto:17-alpine AS builder
WORKDIR /app

# 빌드에 필요한 그레이들 파일과 소스코드를 가상 공간으로 복사합니다.
COPY gradlew .
├── COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# gradlew 실행 권한 부여 후 빌드 (테스트는 속도를 위해 생략)
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# 2단계: 실행 환경 (용량을 낮추기 위해 결과물만 쏙 빼옵니다)
FROM amazoncorretto:17-alpine
WORKDIR /app

# 1단계 builder 공간에서 구워진 패키지(.jar)를 실행 공간으로 복사
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

# 외부 노출 포트 및 서버 실행 명령어
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]