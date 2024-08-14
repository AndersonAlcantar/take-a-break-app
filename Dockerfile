FROM eclipse-temurin:17.0.11_9-jre-alpine
LABEL authors="Anderson Alcantar"
RUN mkdir /app
WORKDIR /app
COPY ./target/demo-1.0.jar /app/app.jar
EXPOSE 8084
CMD ["java", "-jar", "app.jar"]