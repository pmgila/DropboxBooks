DROPBOX BOOKS


FUNCIONAMIENTO DE LA APLICACI�N

Al iniciar la aplicaci�n, aparece un bot�n para acceder al formlario de autenticaci�n de Dropbox. Tras pulsar el bot�n 
se muestra en pantalla el formulario para introducir la cuenta de usuario de Dropbox y la contrase�a. Una vez introducidos 
dichos datos, al pulsar el bot�n 'Sign in' la aplicaci�n muestra una lista con los archivos .ebup contenidos en la 
carpeta 'Aplicaciones/Simple Example'. Es importante que los e-books se encuentren en la citada carpeta para poder 
visualizarlos con la aplicaci�n, si no se tiene esa carpeta, la aplicaci�n te pide autorizaci�n para crearla tras la 
pantalla de autenticaci�n. Adem�s, la aplicaci�n crea un archivo .ebup de muestra (book.ebup) si no existe ya un archivo 
con ese nombre.


PUNTOS IMPLEMENTADOS DEL CASO

Punto 1. Pantalla inicial de login --> OK.

Punto 2. Mostrar los libros .ebup --> OK (la �nica condici�n es que se encuentren en la carpeta 
'Aplicaciones/Simple Example', esto viene condicionado por la dificulatd descrita abajo en DIFICULTADES ENCONTRADAS).

Punto 3. Men� desplegable --> No implementado por falta de tiempo.

Punto 4. Mostrar portada con doble click --> No implementado por falta de tiempo.


PASOS SEGUIDOS

1. Descarga e instalaci�n del SDK de Android y del entorno de desarrollo Eclipse.

2. Creaci�n de emulador para testear la aplicaci�n.

3. Descarga e instalaci�n del SDK de la API que proporciona Dropbox para que una aplicaci�n Android se conecte a Dropbox 
con facilidad.

4. Creaci�n de la p�gina de inicio con el bot�n para entrar al formulario.

5. Conexi�n a Dropbox haciendo uso de la API.

6. Ejecutar las funciones de la API necesarias para la autenticaci�n y la creaci�n de la carpeta de muestra.

7. Cargar el sistema de archivos del usuario autenticado (el path usado como ra�z es: 'Aplicaciones/Simple Example').

8. Mostrar en pantalla el nombre y fecha de modificaci�n de los archivos que tengan extensi�n .ebup.


DIFICULTADES ENCONTRADAS

-A la hora de usar la API para poder acceder a cualquier archivo existente en la cuenta de Dropbox y no s�lo a la 
mencionada carpeta.
