# 2019-1-PROYCVDS-NUNEZ_CHIRIVI_RODRIGUEZ_SANCHEZ

## Profesores 
	- Julian Velasco (Product Owner)
	- Santiago Alzate (Product Owner)
	- Claudia Santiago (Costumer)
	
## Integrantes:
	- Daniel Felipe Rodriguez Villalba 
	- Jimmy Armando Chirivi Nivia 
	- Jeisson Geovanny Sanchez Ramos 
	- Sergio Alejandro Nuñez Mendivelso 

## Descripción del producto:

### Descripción general:
	
	Es una plataforma diseñada para el control de los laboratorios, equipos y elementos de un computador 
	que estan en estos, con el fin de tener un mayor seguimiento de las reformas, arreglos y cambios que se 
	realizan a cada uno de estos. Ademas tener una base de datos donde se tiene almacenado cada laboratorio, 
	Equipo y elemento con sus respectivas novedades.
		
### Manual de usuario:
	 
	Para ingresar a la plataforma entre al link de Heroku (https://proyecto-test-cdvs.herokuapp.com/), 
	esto lo dirigira a la pagina principal, en la cual debe ingresar con sus credenciales, esto lo enviara a 
	la pagina principal de la aplicacion, en la cual se encontraran menus por Elementos, Equipos, 
	Laboratorios y Novedades, cada uno de estos con sus respectivos registrar, dar de baja, historial y 
	visualizacion.
	
### Pagina de Inicio:
![Imagenes](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Imagenes/Inicio.PNG)
#### Descripcion:
	En esta pagina de inicio podra iniciar sesión si lo desea con su respectivo usuario y contraseña.
		
### Registrar Laboratorio:
![Imagenes](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Imagenes/RegistrarElemento.PNG)
### Registrar Equipo:
![Imagenes](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Imagenes/RegistrarEquipo.PNG)
### Registrar Elemento:
![Imagenes](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Imagenes/RegistrarNovedad.PNG)
### Registrar Novedad:
![Imagenes](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Imagenes/RegistrarLaboratorio.PNG)	
#### Descripción:
	En cada uno de los diferentes registrar usted podra ingresar un laboratorio con sus respectivos equipos, sus 
	equipos con los diferentes elementos sin que el equipo quede incompleto de cada equipo y el elemento con sus 
	especificaciones.
	
### Asociar Equipo:
	
![Imagenes](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Imagenes/AsociarElem.PNG)
### Asociar Elemento:

![Imagenes](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Imagenes/AsociarEqui.PNG)
#### Descripcion:
	En cada uno de los diferentes asociar se podra asociar cada diferente elemento a cada equipo sin que 
	un equipo quede incompleto y cada equipo a cada laboratorio.

## Arquitectura y Diseño detallado:
### Modelo E-R.
![Base de datos](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Base%20de%20datos/BD1.PNG)
### Diagrama de clases
![Imagenes](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Imagenes/DiagramaClase.PNG)	

### Enlace a la aplicación en Heroku:
Heroku APP : https://proyecto-test-cdvs.herokuapp.com/

## Descripción del proceso:

### Integrantes:
	- Daniel Felipe Rodriguez Villalba (Front)
	- Jimmy Armando Chirivi Nivia (UX)
	- Jeisson Geovanny Sanchez Ramos (Design)
	- Sergio Alejandro Nuñez Mendivelso (Back)
	
### Metodologia: 
	
	Nos reuniamos un dia apenas iniciado el Sprint para saber que tareas iba a relizar cada uno y detallar la
	estimacion de cada tarea para asi saber cuantas horas trabajar y repartirnos el trabajo, nos comunicabamos 
	por medio de las redes sociales para reportar los errores que se nos presentaban para darle solucion 
	apoyandonos entre todos.
	
### Taiga enlace:
[Taiga](https://tree.taiga.io/project/jeisonsr43-historial-de-equipos-labinfo/backlog)

### Para cada Sprint:
[Retrospectiva](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Retrospectiva/Retrospectiva.md)

-----------------------------------------------------------------------------------


BASE DE DATOS: 

Host:  ec2-50-17-246-114.compute-1.amazonaws.com

Database:  ddsmooluvgl305

User:  mimoxudozjwujd

Port:  5432

Password:  15d8f7b361d043657ce55a3f5a42fdca7e6a2901db11dee4a89ede4969a47320



-----------------------------------------------------------------------------------


URI:  postgres://mimoxudozjwujd:15d8f7b361d043657ce55a3f5a42fdca7e6a2901db11dee4a89ede4969a47320@ec2-50-17-246-114.compute-1.amazonaws.com:5432/ddsmooluvgl305


Heroku CLI:  heroku pg:psql postgresql-colorful-25022 --app proyecto-test-cdvs


Heroku APP : https://proyecto-test-cdvs.herokuapp.com/


-----------------------------------------------------------------------------------


Para iniciar sesión en la app:

Email: jeisson.sanchez@mail.escuelaing.edu.co

Password:pw

Email: claudia.santiago@escuelaing.edu.co

Password: claudia

Email: julian.velasco-b@escuelaing.edu.co

Password: julian

Email:santiago.alzate-s@escuelaing.edu.co

Password: santiago

-----------------------------------------------------------------------------------


![Base de datos](https://github.com/checho1998/2019-1-PROYCVDS-NU-EZ_CHIRIVI_RODRIGUEZ/blob/master/Base%20de%20datos/BD1.PNG)

