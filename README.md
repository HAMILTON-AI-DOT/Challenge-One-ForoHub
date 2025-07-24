
# 📚 ForoHub API - Documentación

## Descripción del Proyecto
ForoHub es una API REST desarrollada con **Spring Boot** que permite la gestión de un foro de discusión, incluyendo autenticación JWT, publicación de temas, comentarios y más.

## 🛠 Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.2**
- **Spring Security**
- **JWT (Auth0)**
- **MySQL**
- **Hibernate/JPA**
- **Maven**

## 🔐 Autenticación JWT
La API utiliza tokens JWT para autenticación. Ejemplo de flujo:

1. **Login** (`POST /login`):
```json
{
  "email": "usuario@ejemplo.com",
  "password": "contraseña"
}
```

2. **Respuesta**:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

3. **Uso del token**:
```
Authorization: Bearer <token>
```

## 📦 Estructura del Proyecto
```
src/
├── main/
│   ├── java/
│   │   └── com/foroHub/
│   │       ├── config/       # Configuraciones
│   │       ├── controller/   # Controladores
│   │       ├── dto/          # Objetos de transferencia
│   │       ├── exceptions/   # Manejo de errores
│   │       ├── model/        # Entidades
│   │       ├── repository/   # Repositorios
│   │       ├── security/     # Configuración de seguridad
│   │       └── service/      # Lógica de negocio
│   └── resources/
│       ├── application.properties
│       └── ...
└── test/                     # Pruebas
```

## ⚙️ Configuración
1. **application.properties**:
```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=root
spring.datasource.password=password

# JWT
jwt.secret=TuClaveSecretaDe32Caracteres123456!!
jwt.expiration=7200 # 2 horas en segundos
```

2. **Variables de entorno**:
```bash
export JWT_SECRET="TuClaveSecreta"
export DB_PASSWORD="password"
```

## 🚀 Instalación y Ejecución
1. Clonar repositorio:
```bash
git clone https://github.com/tu-usuario/forohub-api.git
```

2. Configurar base de datos:
```sql
CREATE DATABASE forohub;
```

3. Ejecutar aplicación:
```bash
mvn spring-boot:run
```

## 📌 Endpoints Principales
| Método | Endpoint            | Descripción               |
|--------|---------------------|---------------------------|
| POST   | /api/auth/login     | Autenticación de usuarios |
| GET    | /api/temas          | Obtener todos los temas   |
| POST   | /api/temas          | Crear nuevo tema          |
| GET    | /api/temas/{id}     | Obtener tema por ID       |

## 🌐 Swagger UI
Accede a la documentación interactiva en:
```
http://localhost:8080/swagger-ui.html
```

## 🧪 Pruebas
Ejecutar pruebas unitarias:
```bash
mvn test
```

## 🤝 Contribución
1. Haz fork del proyecto
2. Crea tu rama (`git checkout -b feature/nueva-funcionalidad`)
3. Haz commit de tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## 📄 Licencia
MIT License - Ver [LICENSE](LICENSE) para más detalles.
