# Biblioteca Municipal

<h1 align="center"> PLANTEAMIENTO </h1>

<p>
Diseñar una aplicación en Java, que permita llevar el registro del préstamo de libros realizados 
en la Biblioteca Municipal. Se requiere registrar la información de todos los libros disponibles 
en la biblioteca para préstamos. Cada libro tendrá un código que lo identifica (ISBN), así se sabrá 
cuál es el nombre del libro, su autor(es), la editorial y el año de publicación. Es importante saber 
de cada libro, a que categoría pertenece, para esto la biblioteca cuenta con libros especializados 
en las siguientes categorías: Historia, Arte, Tecnología y Entretenimiento. La información de los 
libros se guarda en un archivo llamado libros.
</p>

<p>
Además de tener el registro de todos los libros, se debe llevar el historial con todas las veces 
que un libro es prestado en la biblioteca para su consulta. En este sentido; cada vez que se 
presta un libro, se requiere registrar en el historial de préstamos la siguiente información: el 
código del libro prestado para saber de qué ejemplar se trata (ISBN); la fecha del préstamo con 
el siguiente formato (día – mes – año); la identificación y nombre del usuario que realiza el 
préstamo. La información con el histórico de los préstamos se guardará en un archivo de 
nombre historial_prestamos.
</p>

<p>
Se recomienda para la implementación de la aplicación que se manejen dos ficheros planos, 
uno para guardar la información de cada libro, y otro para ir guardando el registro histórico de 
todos los préstamos que se realicen. Como la Biblioteca Municipal es concurrida y atiende en 
promedio 100 usuarios al día, para brindar una mejor atención a los usuarios; la persona 
encargada de hacer los préstamos debe registrar en una cola de turnos, la información de las 
personas que llegan a prestar los libros; esto con el propósito de tener el orden en que serán 
atendidos. La información registrada en la cola de turnos corresponde a la identificación y 
nombre del usuario. Después que se registre el préstamo del usuario en el historial de 
préstamos, se debe retirar la información del usuario de la cola de turnos, para que el 
encargado(a) de hacer los prestamos tenga en lista, al siguiente usuario en turno. La aplicación 
debe contar con una opción para reiniciar las colas de turnos cada día y visualizar en todo 
momento el orden de atención.
</p>

## REQUIRIMIENTOS

La directora de la Biblioteca Municipal, solicita las siguientes funcionalidades o requerimientos 
para la aplicación:

### Requerimientos de Estructuras de Datos 

La implementación de la aplicación en Java debe funcionar utilizando las estructuras estudiadas durante 
el curso: Listas Enlazadas, Colas, Archivos, entre otras que sean requeridas.

### Requerimientos Funcionales 

* La aplicación debe permitir registrar y consultar de los archivos la información del historial de 
préstamos y libros disponibles.
* Generar un informe con el historial de préstamos de un determinado libro, pasando como parámetro 
de búsqueda el código del libro (ISBN). El informe debe tener el nombre del libro y el listado con su 
historial de préstamos.

### Requerimientos de Reportes

Se requiere que la aplicación cuente con opciones para realizar las operaciones descritas anteriormente 
y para generar los siguientes informes: 

* Generar un listado con los nombres de los libros existentes por cada categoría.
* Indicar el número de libros existentes de cada categoría; y el número total de libros existentes

## FUNCIONAMIENTO DE LA APLICACIÓN

<img align="center" src="https://user-images.githubusercontent.com/81385175/180320812-ff0f44cc-b91a-4229-9d35-e08a7af73d99.png">
<img align="center" src="https://user-images.githubusercontent.com/81385175/180321014-4ecbbc63-5503-494f-af9e-2672d56852e6.png">
<img align="center" src="https://user-images.githubusercontent.com/81385175/180321181-8f126fca-cd16-42df-a0fb-4b2b942dac28.png">
<img align="center" src="https://user-images.githubusercontent.com/81385175/180321299-89f940b6-e0bc-49d4-bc13-b0b483419b86.png">


