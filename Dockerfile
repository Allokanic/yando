FROM eclipse-temurin:18-jre-alpine
ARG JAR=target/*.jar
COPY $JAR /yando.jar
ENTRYPOINT ["java", "-jar", "/yando.jar"]