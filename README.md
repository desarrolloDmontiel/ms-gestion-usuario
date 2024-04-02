# ms-gestion-usuarios



Este es un microservicio que permite el registro e incio de sesión, asi como el listado de los usuarios existentes.
Para poder acceder a listado de usuarios, es necesario en primera instancia registrarse como usuario. El registro otorgara un token
de acceso que permitira acceder al endpoint protegido, la solución se explica en el siguiente diagrama:

![image](https://github.com/desarrolloDmontiel/ms-gestion-usuario/assets/165534025/4026a6c6-7981-4608-9ab6-c7a27ae734a8)



## Requisitos

- Java 17
- Maven
- Lombok

## Construcción

Para levantar el proyecto se debe realizar como cualquier proyecto maven.
Por defecto para construir el proyecto, ejecute el siguiente comando en la raíz del proyecto:

```sh
mvn clean install
```
 
Este deberia iniciar en el puerto 8080.

EL proyecto utiliza una BD H2 por lo que no es necesario hacer nada mas.

## H2 Console
Luego de inciar el componente es posible ingresar a la interfaz de H2 para poder monitorear el registro de los datos,
para ingresar debemos dirigirnos a la siguiente ruta e ingresar con las credenciales expuestas:

```sh
http://localhost:8080/h2-console/
username=user
password=pass
```
![image](https://github.com/desarrolloDmontiel/ms-gestion-usuario/assets/165534025/446db5e1-f4c5-4374-9209-9bd6ef77ca15)



## Swagger
Este componente tiene configurado un Swagger que permitira la ejecución de los endpoints disponibles,
para acceder debemos diriginos a la siguiente ruta:

```sh
http://localhost:8080/swagger-ui/index.html
```
![image](https://github.com/desarrolloDmontiel/ms-gestion-usuario/assets/165534025/74844156-b968-4fc3-8118-12bb02e12ac9)


## Endpoints

Para registrar un nuevo usuario:

[POST] localhost:8080/auth/

Request:

```sh
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}

```
Response:

```sh
 positivo --> Status 200


 error --> 

{
    "mensaje": "Este correo ya se encuentra registrado"
}

```

Para listar todos los usuarios:

[GET] localhost:8080/users/

Response:

```sh
[
    {
        "name": "Juan Perez",
        "email": "juan@Perez.org",
        "password": null,
        "phones": [
            {
                "number": "1234567",
                "contryCode": "57",
                "cityCode": "1"
            }
        ]
    },
    {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": null,
        "phones": [
            {
                "number": "1234567",
                "contryCode": "57",
                "cityCode": "1"
            }
        ]
    }
]

```


## Autor.

-Darío Montiel
