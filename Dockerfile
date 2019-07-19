FROM openjdk:8-jdk-alpine

COPY . /app

RUN cd /app && ./gradlew clean build

EXPOSE 8080

CMD ["java","-jar","/app/build/libs/prueba-tecnica-1.0.0-SNAPSHOT.jar"]