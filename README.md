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

GET 

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

GET 

http://localhost:8080/PizzApp/rest/productoService/todosLosProductos

### COLABORACIONES

### BUENAS PRACTICAS PARA REALIZAR COMMITs
##### Commit Messages
Estructura del Mensaje
El mensaje de un commit consistirá en 2 diferentes partes separadas por una línea en
blanco:
*  Título: asunto
* Cuerpo
* 
El título consiste en el tipo y asunto del mensaje.
##### Type / Tipo
El tipo es contenido en el título y puede ser de alguno de los siguientes casos:
* feat: Una nueva característica.
* fix: Se soluciono un bug.
* docs: Se realizaron cambios en la documentación.
* style: Se aplicó formato, comas y puntos faltantes, etc; Sin cambios en el código.
* refactor: Refactorización del código en producción.
* test: Se añadieron pruebas, refactorización de pruebas; Sin cambios en el código.
* chore: Actualización de tareas de build, configuración del admin. de paquetes; Sin
cambios en el código.
##### Subject / Asunto
El asunto no debe contener más de 50 caracteres, debe iniciar con una letra mayúscula y
no terminar con un punto. Debemos ser objetivos al momento de redactar nuestro commit.
Body / Cuerpo
No todos los commits son lo suficientemente complejos como para necesitar de un cuerpo,
sin embargo es opcional y se usan en caso de que el commit requiera una explicación y
contexto. Utilizamos el cuerpo para explicar el ¿Qué y Por qué? de un commit y no el
¿Cómo? Al escribir el cuerpo, requerimos de una línea en blanco entre el título y el cuerpo,
además debemos limitar la longitud de cada línea a no más de 72 caracteres.

##### Algo para tener en cuenta.
###### Arreglar un commit con amend
Llevas un rato trabajando, has cambiado unos cuantos archivos. Terminas de desarrollar un
feature o resolver un bug. Haces el commit con los archivos modificados y, de repente, te
das cuenta de que te has dejado algo. Ya sea un test unitario, algo de documentación, CSS
o cualquier otra cosa.
Con suerte, no afecta mucho, con algo menos de suerte rompes todo el build con ese
commit incompleto. No pasa nada, haces otro commit justo después y todo arreglado.
Sin embargo, es una mala filosofía tener commits incoherentes, incompletos o incluso que
rompan el build, ya que si alguien elige retroceder a algún estado anterior del proyecto, no
debería encontrarse con un commit que haga que las cosas no funcionen como deberían.
Si en vez de hacer un nuevo commit, ejecutas:
```sh
git commit –ammend –no-edit
````
actualizas el último commit que hayas hecho con los cambios que hayas añadido a Git. Así
lo dejas todo empaquetado en un solo commit y mantienes el Git limpio.


### 30/5 Sprint 0

### 06/6 Sprint 1

### 13/6 Sprint 2
 
