FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/bff-agendador-tarefa-0.0.1-SNAPSHOT.jar bff-agendador-tarefa.jar

EXPOSE 8083
CMD ["java", "-jar", "/app/bff-agendador-tarefa.jar"]
