# Spring Boot Java Assignments — Plantilla de laboratorio

Proyecto base con **Spring Boot 3** y **Gradle** para realizar ejercicios/retos en Java. Incluye un endpoint de salud, pruebas con JUnit 5 y una tarea para **enviar** el laboratorio con el cliente de ADA.

> **Nota:** Este repositorio **NO incluye** directorios generados (`build/`) ni artefactos del IDE y no debería incluirlos. Usa `./gradlew` para reconstruir. Si migras este proyecto a un nuevo repo, **borra la carpeta `.git/` incluida en el ZIP** y crea tu propio repo limpio.

---

## 🚀 Requisitos

- **Java 17** (JDK 17)
- **Gradle Wrapper** (incluido: `./gradlew` / `gradlew.bat`)
- (Opcional) **IntelliJ IDEA** / VS Code + Extensión Java

Verifica Java:
```bash
java -version
```

---

## 📦 Instalación rápida

```bash
# 1) Descomprimir y entrar al proyecto
unzip spring-boot-java-assignments.zip
cd spring-boot-java-assignments

# 2) Construir
./gradlew clean build     # Windows: gradlew.bat clean build

# 3) Ejecutar la app
./gradlew bootRun         # Windows: gradlew.bat bootRun
```
La aplicación queda en **http://localhost:8080** (puerto por defecto de Spring Boot).

> Si deseas cambiar el puerto, añade en `src/main/resources/application.properties`:
> ```properties
> server.port=8081
> ```

---

## 🔌 Endpoints incluidos

- `GET /health` → devuelve texto **"API working OK!"**

Archivo: `src/main/java/org/adaschool/api/controller/HealthController.java`

---

## 🧪 Pruebas

Ejecuta los tests con JUnit 5:
```bash
./gradlew test     # Windows: gradlew.bat test
```
El test de ejemplo verifica que `GET /health` responde **200 OK** y el texto esperado.

---

## 📁 Estructura del proyecto

```
spring-boot-java-assignments/
├─ src/
│  ├─ main/
│  │  ├─ java/org/adaschool/api/            # Código fuente
│  │  └─ resources/application.properties   # Configuración
│  └─ test/java/org/adaschool/api/          # Pruebas
├─ build.gradle                             # Configuración Gradle (Spring Boot 3.0.2)
├─ settings.gradle                          # Nombre del proyecto (ver nota)
├─ gradlew / gradlew.bat                    # Gradle Wrapper
└─ .gitignore                               # Ignora build/, .gradle/, etc.
```

> **Nota**: el archivo `settings.gradle` tiene el nombre `spring-boot-java-assignemnts` (con un error tipográfico). Puedes corregirlo a:
> ```gradle
> rootProject.name = 'spring-boot-java-assignments'
> ```

---

## 📨 Envío del laboratorio (ADA)

El proyecto incluye una tarea Gradle para enviar el laboratorio con **ada-client**:

```bash
# Linux / macOS
chmod +x ./ada-client             # si aplica
./gradlew adaSubmit

# Windows (PowerShell o CMD)
gradlew.bat adaSubmit
```

> La tarea `adaSubmit` detecta el sistema operativo y usa el ejecutable apropiado (`./ada-client` o `ada-client.exe`). Si tu antivirus bloquea el cliente, ejecútalo como administrador o añade una excepción.

---

## 🧹 `.gitignore` recomendado

Asegúrate de ignorar archivos generados/IDE (incluido ya en el proyecto). Si necesitas uno base:

```
# Gradle
.gradle/
build/

# IDEs
.idea/
*.iml
.vscode/

# SO / temporales
.DS_Store
Thumbs.db

# Logs
*.log
```

---

## 🛠️ Comandos útiles

```bash
./gradlew tasks          # Lista tareas disponibles
./gradlew bootRun        # Ejecuta la app
./gradlew test           # Ejecuta pruebas
./gradlew clean build    # Limpia y construye
```

---

## ❓Solución de problemas

- **"command not found: ./gradlew"** → otorga permisos: `chmod +x gradlew` o usa `gradlew.bat` en Windows.
- **Puerto ocupado** → cambia `server.port` en `application.properties` o libera el puerto.
- **Error de JDK** → asegúrate de tener **Java 17** en el `PATH` y como JDK del proyecto en tu IDE.
- **Nombre del proyecto raro en el IDE** → corrige `settings.gradle` (ver nota arriba).

---

## 📄 Licencia

Este proyecto se distribuye bajo **LICENCIA** incluida (revisa `LICENSE`).

---

¿Necesitas que te genere también un `.gitignore` listo para descargar? Puedo anexarlo.
