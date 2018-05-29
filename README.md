# PizzApp-12cactus
[![Build Status](https://travis-ci.org/Salgadoema/PizzApp-12cactus.svg?branch=master)](https://travis-ci.org/Salgadoema/PizzApp-12cactus)

PizzApp es una aplicación web para pizzerías.
Integra los pedidos desde la mesa a la cocina.




### Integrantes


Nro | Nombre                    | Legajo | Mail
----|---------------------------|--------|------
1   | Emanuel Salgado           | 16659  | salgadoema@gmail.com
2   | Rigazio Damian            | 28621  | sirdemian@gmail.com
3   | Paula Schab               | 28688  | schabpaula@gmail.com
4   | Pablo Nicolas Sabaliauskas| 28662  | sabaliauskaspablo@gmail.com
5   | Maricruz Gil              | 27206  | gil.maricruz@gmail.com

###


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