
# Etapa 1: Construcción
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app

# Copiar el archivo de configuración de Maven y las dependencias
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=builder /app/target/attentions-api.jar ./app.jar

# Copiar el archivo .env
COPY .env .env

# Exponer el puerto definido dinámicamente
ARG SERVER_PORT
ENV SERVER_PORT=${SERVER_PORT}
EXPOSE ${SERVER_PORT}

# Comando para ejecutar la aplicación
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]