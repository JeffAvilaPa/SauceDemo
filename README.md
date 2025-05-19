Perfecto. Aquí tenés un `README.md` detallado para tu proyecto de automatización de pruebas con **Selenium + Java + Cucumber + TestNG + Maven + Jenkins** para la web de SauceDemo.

---

```markdown
# 🧪 SauceDemo Automated Testing Framework

Este proyecto es un framework de automatización de pruebas end-to-end desarrollado en **Java**, utilizando **Selenium WebDriver**, **Cucumber**, **TestNG**, **Maven** y ejecutado desde **Jenkins en Docker**.

---

## 📁 Estructura del Proyecto



SauceDemo/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           ├── login/
│   │           │   └── LoginPage.java
│   │           └── dashboard/
│   │               ├── DashboardPage.java
│   │               └── DashboardValidator.java
│   └── test/
│       ├── java/
│       │   ├── drivers/
│       │   │   └── DriverManager.java
│       │   ├── hooks/
│       │   │   └── Hooks.java
│       │   ├── steps/
│       │   │   ├── login/
│       │   │   │   └── LoginSteps.java
│       │   │   └── dashboard/
│       │   │       └── DashboardSteps.java
│       │   └── runners/
│       │       └── TestRunner.java
│       └── resources/
│           └── features/
│               ├── login/
│               │   └── login.feature
│               └── dashboard/
│                   └── dashboard.feature
├── Jenkinsfile
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md
```
````

---

## 🛠️ Tecnologías

- **Lenguaje:** Java 17
- **Automatización Web:** Selenium WebDriver
- **BDD:** Cucumber + Gherkin
- **Runner:** TestNG
- **Build Tool:** Maven
- **CI/CD:** Jenkins (con Docker)
- **Browser:** Chromium headless en contenedor
- **Reporte:** HTML y JSON (Cucumber Reports)

---

## 🧪 Ejecución de pruebas

### 🖥️ Local

1. Cloná el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/SauceDemo.git
   cd SauceDemo
````

2. Ejecutá las pruebas:

   ```bash
   mvn clean test
   ```

3. Los reportes estarán en `target/cucumber-report.html` y `target/cucumber-report.json`.

---

### 🐳 Jenkins con Docker

1. Levantar Jenkins con soporte para Selenium:

   ```bash
   docker-compose down -v
   docker-compose build --no-cache
   docker-compose up -d
   ```

2. Acceder a Jenkins:

   ```
   http://localhost:8080
   ```

3. Crear un pipeline y apuntar al `Jenkinsfile`.

---

## ✅ Escenarios cubiertos

### `login.feature`

* Login exitoso
* Login con credenciales inválidas
* Login con campos vacíos

### `dashboard.feature`

* Validación de elementos tras login
* Validación del título de la página
* Validación de cantidad de productos
* Ordenar productos por:

    * Nombre (Z-A)
    * Precio (Low-High)
    * Precio (High-Low)

---

## ✨ Buenas prácticas

* Uso de **Page Object Model (POM)**.
* Separación clara de lógica de negocio, validaciones y definiciones de steps.
* Evita duplicación: los pasos de login son reutilizados por otros features como dashboard, payment, etc.
* Variables de localización están encapsuladas en `Page` classes.

---

## 📦 Dependencias clave (`pom.xml`)

```xml
<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.8.3</version>
  </dependency>
  <dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.14.0</version>
  </dependency>
  <dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-testng</artifactId>
    <version>7.14.0</version>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

---

## 📌 Notas adicionales

* Si ves errores como `step undefined`, asegurate que los métodos coincidan **exactamente** con los pasos del `.feature` (ortografía, comillas, casing).
* Si Jenkins no encuentra `publishHTML`, instalá el plugin **HTML Publisher** manualmente o con:

  ```bash
  curl -L -o htmlpublisher.hpi https://updates.jenkins.io/latest/htmlpublisher.hpi
  mv htmlpublisher.hpi /var/jenkins_home/plugins/
  chown -R jenkins:jenkins /var/jenkins_home/plugins/
  ```

---

