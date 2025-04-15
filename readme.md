# Attentions Microservice

## Descripción

Este proyecto es un microservicio basado en Spring Boot para la gestión de atenciones. Proporciona endpoints para crear, recuperar y filtrar atenciones utilizando parámetros opcionales.

---

## Prerrequisitos

- Java: 21
- Maven: 3.9+
- Docker y Docker Compose
- PostgreSQL

---

## Instrucciones de Configuración

1. Clona el repositorio:
   ```bash
   git clone <repository-url>
   cd attentions-microservice
   ```

2. Construye el proyecto:
   ```bash
   mvn clean package
   ```

3. Ejecuta la aplicación con Docker Compose:
   ```bash
   docker-compose up --build
   ```

4. La aplicación estará disponible en `http://localhost:8084` (o el puerto configurado en `.env`).

---

## Endpoints de la API

### 1. Crear Atención

- **URL:** `/api/v1/atentions/create`
- **Método:** `POST`
- **Descripción:** Crea un nuevo registro de atención.
- **Cuerpo de la Solicitud:**
  ```json
  {
    "year": 2023,
    "month": 10,
    "region": "Lima",
    "province": "Lima",
    "districtUbigeo": "150101",
    "executingUnitCode": 123,
    "ipressCode": "IP123"
  }
  ```
- **Respuesta:**
  ```json
  {
    "id": 1,
    "year": 2023,
    "month": 10,
    "region": "Lima",
    "province": "Lima",
    "districtUbigeo": "150101",
    "executingUnitCode": 123,
    "ipressCode": "IP123"
  }
  ```

---

### 2. Obtener Atención por ID

- **URL:** `/api/v1/atentions/{id}`
- **Método:** `GET`
- **Descripción:** Recupera un registro de atención por su ID.
- **Parámetro de Ruta:**
    - `id` (Long): ID del registro de atención.
- **Respuesta:**
  ```json
  {
    "id": 1,
    "year": 2023,
    "month": 10,
    "region": "Lima",
    "province": "Lima",
    "districtUbigeo": "150101",
    "executingUnitCode": 123,
    "ipressCode": "IP123"
  }
  ```

---

### 3. Filtrar Atenciones

- **URL:** `/api/v1/atentions/filter`
- **Método:** `GET`
- **Descripción:** Filtra registros de atención basados en parámetros opcionales.
- **Parámetros de Consulta:**
    - `year` (Integer, opcional)
    - `month` (Integer, opcional)
    - `region` (String, opcional)
    - `province` (String, opcional)
    - `districtUbigeo` (String, opcional)
    - `executingUnitCode` (Integer, opcional)
    - `ipressCode` (String, opcional)
- **Parámetros de paginación:** `page`, `size`, `sort`
- **Respuesta:**
  ```json
  {
    "content": [
      {
        "id": 1,
        "year": 2023,
        "month": 10,
        "region": "Lima",
        "province": "Lima",
        "districtUbigeo": "150101",
        "executingUnitCode": 123,
        "ipressCode": "IP123"
      }
    ],
    "pageable": {
      "pageNumber": 0,
      "pageSize": 10
    },
    "totalElements": 1,
    "totalPages": 1
  }
  ```
---
## Variables de Entorno

El archivo `.env` define las siguientes variables de entorno:

```env
# Application Configuration
SERVER_PORT=8084
SPRING_PROFILES_ACTIVE=prod

# Database Configuration
DB_HOST=localhost
DB_PORT=5432
DB_NAME=attentions_db
DB_USERNAME=admin
DB_PASSWORD=securepassword
```
---
## Docker Compose

El archivo `docker-compose.yml` configura los servicios necesarios para ejecutar el microservicio y la base de datos PostgreSQL.

```yaml
version: '3.8'

services:
  app:
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - "${SERVER_PORT}:${SERVER_PORT}"
    env_file:
      - .env
    depends_on:
      - db

  db:
    image: postgres:15
    container_name: postgres-db
    environment:
      POSTGRES_DB: ${DB_NAME}
      POSTGRES_USER: ${DB_USERNAME}
      POSTGRES_PASSWORD: ${DB_PASSWORD}
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
  ```
---

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.