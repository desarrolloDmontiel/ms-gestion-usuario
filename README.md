# ms-gestion-usuarios



Este es un microservicio que permite el manejo de datos en relacion al registro de una encuesta.

## Requisitos

- Java 17
- Maven

## Construcción

Para levantar el proyecto se debe realizar como cualquier proyecto maven.
Por defecto para construir el proyecto, ejecute el siguiente comando en la raíz del proyecto:

```sh
mvn clean install
```
 
Este deberia iniciar en el puerto 8080.

EL proyecto utiliza una BD H2 por lo que no es necesario hacer nada mas.

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
