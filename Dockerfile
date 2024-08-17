FROM eclipse-temurin:17.0.11_9-jre-alpine
LABEL authors="Anderson Alcantar"
RUN mkdir /app
WORKDIR /app
COPY ./target/demo-1.0.jar /app/app.jar
# environment variables
#ENV DB_HOST=${DB_HOST}
ENV DB_PORT=19305
#ENV DB_NAME=${DB_NAME}
#ENV DB_USER=${DB_USER}
ENV DB_PASSWORD=bntWKkZCCBLJIIspOBwbzBPkvDZYsdyM
EXPOSE 8084
CMD ["java", "-jar", "app.jar"]