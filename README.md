# pruebaAutomatizacion

Considerar los siguientes puntos para poder ejeutar el proyecto:
# Prerequisitos
 * Tener instalado Maven -> apache-maven-3.9.3 en la siguiente ruta :
   C:\Programas\apache-maven-3.9.3
 * Tener configurado las variables de entorno JAVA_HOME y MAVEN_HOME
 * Tener instalado el JDK 23
 * Tener instalado el IDE IntelliJ IDEA
 * Agregar los plugins Gherkin y Cucumber a IntelliJ IDEA
 * Configurar la ruta de maven en IntelliJ IDEA:
   - File -> Settings -> Build, Execution, Deployment -> Build Tools -> Maven
   - En "Maven home directory" seleccionar la ruta donde se instaló Maven (C:\Programas\apache-maven-3.9.3)
   - En "User settings file" seleccionar el archivo settings.xml que se encuentra en la carpeta .m2 del usuario
 * Seleccionar la version de java en IntelliJ IDEA:
   - File -> Project Structure -> Project
   - En "Project SDK" seleccionar el JDK 23
   - En "Project language level" seleccionar 23 - "SDK DEFAULT"
 * Al montar el proyecto asegurarte de actualizar las dependencias del archivo pom.xml
 * Para ejecutarlo puedes hacerlo desde la consola o terminal de IntelliJ IDEA con el siguiente comando:
   mvn clean install
 * Se genera el reporte en un archivo html el cual lo encentras en la ruta:
   target\site\serenity\index.html
   - En el archivo index.html puedes ver el reporte de las pruebas ejecutadas el paso a paso y las capturas de pantalla