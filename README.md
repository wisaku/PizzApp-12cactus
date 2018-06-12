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


#### Respositorio Github:

https://github.com/Salgadoema/PizzApp-12cactus/

#### Visual Story mapping:

https://trello.com/b/ruHHduMr/ingenieria-pizzapp

#### Estimaciones:

https://www.planitpoker.com/board/#/room/ad41df737b2a40e0b86f5d45fec5265e

#### BASE DE DATOS

Para que ejecute ok el HibernateTestCase deben crear la base en sus maquinas antes, para ello deben ejecutar:

1.-
CREATE DATABASE pizzappdb;

2.-
USE pizzappdb;

3.-
Listo, solo ejecutar el test

#### Maven

mvn clean install

1.-
Para hacer build y ejecutar los test local

ir a /PizzApp-12cactus/PizzApp

Ejecutar "mvn clean install"
 
2.-
Para levantar el jetty local

ir a /PizzApp-12cactus/

Ejecutar "mvn jetty:run"

#### SERVICIOS

#### DESARROLLO

GET
http://localhost:8080/PizzApp/rest/testRest/get/{parametro}

POST

http://localhost:8080/PizzApp/rest/testRest/put

Ejemplo Json

{"uno": 1}


#### PEDIDO

POST
http://localhost:8080/PizzApp/rest/pedidoService/crearPedido

{"productos": []}


#### CLIENTE

POST
http://localhost:8080/PizzApp/rest/clienteService/crearCliente

Ejemplo Json

{

"telefono": 12345678,

"nombre": "Macri",

"apellido": "Gato",

"direccion": "Casa Rosada"

}

GET 

http://localhost:8080/PizzApp/rest/clienteService/buscarCliente/12345678

http://localhost:8080/PizzApp/rest/clienteService/todosLosClientes

### PRODUCTO

POST

http://localhost:8080/PizzApp/rest/productoService/crearProducto

Ejemplo Json

{
"nombre": "pizza",

"precio": 130
}

GET
http://localhost:8080/PizzApp/rest/productoService/buscarProducto/1



### 30/5 Sprint 0

### 06/6 Sprint 1

### 13/6 Sprint 2
 
