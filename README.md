# PizzApp-12cactus


####Base de datos

Para que ejecute ok el HibernateTestCase deben crear la base en sus maquinas antes, para ello deben ejecutar:

1.-
CREATE DATABASE pizzappdb;

2.-
USE pizzappdb;

3.-
Listo, solo ejecutar el test

####Maven

1.-
Para hacer build y ejecutar los test local

ir a /PizzApp-12cactus/PizzApp

Ejecutar "mvn clean install"
 
2.-
Para levantar el jetty local

ir a /PizzApp-12cactus/

Ejecutar "mvn jetty:run"

#### Servicios

Desarrollo

GET
http://localhost:8080/PizzApp/rest/testRest/get/{parametro}

POST

http://localhost:8080/PizzApp/rest/testRest/put

Body para pruebas:

{"uno": 1}