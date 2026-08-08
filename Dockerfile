FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/Vehicle-Service-Management-System-0.0.1-SNAPSHOT.jar"]