## Para Contruir el proyecto

Descargar el projecto o clonarlo.

Abrir androidStudio dar los permisos necesarios que android requiere y correr la App

## Descripcion del Proyecto

La app fue construida de la siguente manera: 
MVVM
Injeccion de Dependencia DaggerHilt
Retrofit y Gson
JetpackCompose
Arquitectura CleanCode

En la Capa Data
En la carpeta Di, se encuentra la injeccion de Dependecia para Retrofit y el Proveedor del repositorio
En la carpeta Remote, se encuentra los dto del api y la interface para realizar los requests
En la carpeta repository, se encuentra la implementacion de cada funcion para poder realizar los requests

En La Capa Domain
En la carpeta model, se encuentra modelo que se usara en la app, con respeto al dto de la capa Data, ademas se realizar el mapper para poder realizarlo
En la carpeta repository, se encuentra la interface sobre las funciones que fueron implementadas en la capa data, esto lo usara los use_case
En la carpeta use_case, se encuentra los casos de uso

En la Capa Ui
Se encuentran todos los components realizados con jetpack compose, ademas de todos la configuracion para poder realizar la navegacion de la App

Por ultimo,
En la carpeta screenshots, se encuentan la visualizaciones del listado de paises, la busqueda y el detalle





