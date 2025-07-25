# 📚 Foro-Hub API

API para el sistema de foros de Alura Latam que permite la gestión completa de tópicos, cursos, respuestas y usuarios con autenticación JWT.

## 🔍 Funcionalidades Principales

### 👥 Gestión de Usuarios
- Registro de nuevos usuarios (estudiantes y moderadores)
- Autenticación con JWT
- Perfiles de usuario

### 📝 Gestión de Tópicos
- Creación de nuevos tópicos de discusión
- Listado paginado de tópicos
- Edición y eliminación
- Búsqueda por categoría/curso

### 🎓 Gestión de Cursos
- Creación de cursos relacionados
- Asignación de tópicos a cursos

### 💬 Gestión de Respuestas
- Respuestas a tópicos
- Moderación de contenido

## 🌐 Endpoints

### 🔐 Autenticación
| Método | Endpoint       | Descripción                          |
|--------|----------------|--------------------------------------|
| POST   | `/auth/registro` | Registra nuevo usuario               |
| POST   | `/auth/login`    | Genera token JWT                     |

### 👤 Usuarios
| Método | Endpoint          | Descripción                          |
|--------|-------------------|--------------------------------------|
| GET    | `/usuarios/{id}`  | Obtiene perfil de usuario            |
| PUT    | `/usuarios/{id}`  | Actualiza información                |

### 📚 Tópicos
| Método | Endpoint              | Descripción                          |
|--------|-----------------------|--------------------------------------|
| POST   | `/topicos`            | Crea nuevo tópico                    |
| GET    | `/topicos?page=0`     | Lista 10 tópicos (paginado)          |
| GET    | `/topicos/{id}`       | Obtiene tópico específico            |
| PUT    | `/topicos/{id}`       | Edita tópico                         |
| DELETE | `/topicos/{id}`       | Elimina tópico                       |

### 🎓 Cursos
| Método | Endpoint              | Descripción                          |
|--------|-----------------------|--------------------------------------|
| POST   | `/cursos`             | Crea nuevo curso                     |
| GET    | `/cursos/{id}/topicos`| Lista tópicos del curso              |

### 💬 Respuestas
| Método | Endpoint                     | Descripción                          |
|--------|------------------------------|--------------------------------------|
| POST   | `/topicos/{id}/respuestas`    | Añade respuesta a tópico             |
| PUT    | `/respuestas/{id}`            | Edita respuesta                      |
| DELETE | `/respuestas/{id}`            | Elimina respuesta                    |

## 📝 Ejemplos de Uso

### 1. Registrar Usuario
```http
POST /auth/registro
Content-Type: application/json

{
  "nombre": "María García",
  "email": "maria@alura.com",
  "password": "contraseñaSegura123",
  "rol": "ESTUDIANTE"
}
```

### 2. Crear Tópico
```http
POST /topicos
Authorization: Bearer <token>
Content-Type: application/json

{
  "titulo": "Dudas sobre Spring Security",
  "mensaje": "¿Cómo implementar JWT correctamente?",
  "cursoId": 5,
  "tags": ["java", "spring", "security"]
}
```

### 3. Listar Tópicos (Paginado)
```http
GET /topicos?page=0&size=10
Authorization: Bearer <token>
```

### 4. Añadir Respuesta
```http
POST /topicos/8/respuestas
Authorization: Bearer <token>
Content-Type: application/json

{
  "contenido": "Debes configurar el SecurityFilter correctamente",
  "solucion": true
}
```

## 🔧 Estructura de Datos

### Tópico
```json
{
  "id": 1,
  "titulo": "Dudas sobre Spring",
  "mensaje": "¿Cómo funciona...?",
  "fechaCreacion": "2023-11-20",
  "estado": "NO_RESPONDIDO",
  "autor": {
    "id": 3,
    "nombre": "Carlos Méndez"
  },
  "curso": {
    "id": 5,
    "nombre": "Spring Boot Avanzado"
  },
  "tags": ["java", "spring"],
  "respuestas": []
}
```

### Respuesta
```json
{
  "id": 15,
  "mensaje": "Debes inyectar el servicio...",
  "fechaCreacion": "2023-11-21",
  "solucion": true,
  "autor": {
    "id": 2,
    "nombre": "Ana López"
  }
}
```

Este diseño permite una gestión completa del foro educativo con relaciones claras entre usuarios, tópicos, cursos y respuestas.
