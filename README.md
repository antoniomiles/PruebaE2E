# PruebaE2E
Prueba funcional automatizada Serenity BDD

Instrucciones para ejecutar el código desde el "run" de la clase TestRunner:
Requisitos previos:

Asegúrate de tener Java JDK 11 instalado en tu sistema.
Asegúrate de tener Maven instalado en tu sistema (si deseas ejecutar las pruebas desde la terminal).

 ![image](https://github.com/antoniomiles/PruebaE2E/assets/31042668/92a9cf83-8dd3-4de9-b06d-bd2c3903bbfa)

1. Descargar la infraestructura:
   - Descarga la infraestructura "saucedemo" desde el repositorio git (o extrae el código fuente si lo tienes en un archivo ZIP).

2. Estructura de directorios:
   - Asegúrate de que la estructura de directorios de la infraestructura sea la siguiente:
saucedemo
├── features
│ └── interactions
│ └── questions
├── stepdefinitions
│ └── tasks
├── userinterface
├── chromedriver.exe
├── log4j2.xml
└── TestRunner.java

php
Copy code
- El archivo `TestRunner.java` debe estar en el directorio raíz junto con el `chromedriver.exe` y `log4j2.xml`.

3. Configuración de dependencias:
- Asegúrate de tener las dependencias necesarias para ejecutar tu código. Puedes usar Maven o Gradle para gestionar las dependencias. Si estás utilizando Maven, asegúrate de tener las dependencias de Karate y Selenium WebDriver, por ejemplo:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>untitled</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- Serenity BDD -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>3.9.7</version>
        </dependency>

        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay</artifactId>
            <version>3.9.7</version>
        </dependency>

        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay-webdriver</artifactId>
            <version>3.9.7</version>
        </dependency>

        <!-- Cucumber -->

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.13.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.13.0</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.7</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-jdk14</artifactId>
            <version>2.0.7</version>
            <scope>runtime</scope>
        </dependency>

        <!-- WebDriver -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.4.1</version>
        </dependency>

        <!-- Add other dependencies as needed -->

        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-junit5</artifactId>
            <version>3.9.7</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.github.fabianlinz</groupId>
            <artifactId>serenity-junit5</artifactId>
            <version>1.2.1</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>3.9.7</version>
            <scope>test</scope>
        </dependency>


    </dependencies>

    <build>



        <plugins>

                <!-- Otros plugins de tu proyecto -->

                <!-- Plugin de compilación para habilitar @FindBy -->
                <plugin>
                    <groupId>net.serenity-bdd.maven.plugins</groupId>
                    <artifactId>serenity-maven-plugin</artifactId>
                    <version>2.5.5</version>
                </plugin>


            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.0</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>2.8.0</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>CucumberWebGui</projectName>
                            <outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
                            <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
Descargar el archivo chromedriver.exe:

Asegúrate de tener el archivo chromedriver.exe descargado y colocado en el directorio raíz del proyecto (junto con TestRunner.java y log4j2.xml).
Puedes descargar el archivo chromedriver.exe desde el sitio web oficial de ChromeDriver: https://sites.google.com/a/chromium.org/chromedriver/downloads
Configuración del TestRunner:

Asegúrate de que la clase TestRunner esté en el directorio raíz de la infraestructura y que esté configurada correctamente para ejecutar las pruebas.
Ejecutar desde el "run" de la clase TestRunner:

Abre el archivo TestRunner.java en tu IDE (por ejemplo, IntelliJ IDEA, Eclipse u otro).
Haz clic derecho en la clase TestRunner y selecciona "Run 'TestRunner'" (o similar, según el IDE que estés usando).
El IDE ejecutará el código y mostrará los resultados de las pruebas en la consola.
Verificación de resultados:

Después de ejecutar las pruebas, verifica los resultados en la consola de tu IDE.
Si todo funciona correctamente, deberías ver los resultados de las pruebas de acuerdo con lo que hayas configurado en tu clase TestRunner.
