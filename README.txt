DROPBOX BOOKS


FUNCIONAMIENTO DE LA APLICACIÓN

Al iniciar la aplicación, aparece un botón para acceder al formlario de autenticación de Dropbox. Tras pulsar el botón 
se muestra en pantalla el formulario para introducir la cuenta de usuario de Dropbox y la contraseña. Una vez introducidos 
dichos datos, al pulsar el botón 'Sign in' la aplicación muestra una lista con los archivos .ebup contenidos en la 
carpeta 'Aplicaciones/Simple Example'. Es importante que los e-books se encuentren en la citada carpeta para poder 
visualizarlos con la aplicación, si no se tiene esa carpeta, la aplicación te pide autorización para crearla tras la 
pantalla de autenticación. Además, la aplicación crea un archivo .ebup de muestra (book.ebup) si no existe ya un archivo 
con ese nombre.


PUNTOS IMPLEMENTADOS DEL CASO

Punto 1. Pantalla inicial de login --> OK.

Punto 2. Mostrar los libros .ebup --> OK (la única condición es que se encuentren en la carpeta 
'Aplicaciones/Simple Example', esto viene condicionado por la dificulatd descrita abajo en DIFICULTADES ENCONTRADAS).

Punto 3. Menú desplegable --> No implementado por falta de tiempo.

Punto 4. Mostrar portada con doble click --> No implementado por falta de tiempo.


PASOS SEGUIDOS

1. Descarga e instalación del SDK de Android y del entorno de desarrollo Eclipse.

2. Creación de emulador para testear la aplicación.

3. Descarga e instalación del SDK de la API que proporciona Dropbox para que una aplicación Android se conecte a Dropbox 
con facilidad.

4. Creación de la página de inicio con el botón para entrar al formulario.

5. Conexión a Dropbox haciendo uso de la API.

6. Ejecutar las funciones de la API necesarias para la autenticación y la creación de la carpeta de muestra.

7. Cargar el sistema de archivos del usuario autenticado (el path usado como raíz es: 'Aplicaciones/Simple Example').

8. Mostrar en pantalla el nombre y fecha de modificación de los archivos que tengan extensión .ebup.


DIFICULTADES ENCONTRADAS

-A la hora de usar la API para poder acceder a cualquier archivo existente en la cuenta de Dropbox y no sólo a la 
mencionada carpeta.
