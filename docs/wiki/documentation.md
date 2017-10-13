# Introducción
> Gestión de usuarios de deportes.
>
>Esta aplicación permitirá crear y habilitar a usuarios vinculados a deportes y categorías deportivas.

## Entities
Diagrama de la entidad:  
![api-architecture-simulation-theme-entities](https://github.com/DavidBlasVazquez/APAW-ECP2-DavidBlas/blob/master/docs/api-architecture-simulation-theme-entities.png)

# API Rest
## Crear un nuevo usuario `POST /user`  
> Admite varias veces al usuario. Devuelve un mensaje de error el nombre está vacío.
> Por defecto al ser creado el usuario queda active.

Ejemplo: `POST /user  {Informática}`

 Entrada | Respuesta | Respuesta si <br> usermame no es pasado 
--|--|-- 
 `username: String` <br> Nombre de usuario  | `CREATED (201)` | `BAD_REQUEST(400)` <br> `{"error":"UserNameInvalidException"}`

## Crear un nuevo deporte `POST /sport` 
> Admite varias veces el sport. Devuelve un mensaje de error si el nombre de sport está vacio.

Ejemplo: `POST /sport  {Informática}`

 Entrada | Respuesta | Respuesta sin <br> sportname no es pasado
--|--|-- 
 `title: String` <br> Nombre del deporte <br> `category: String` <br> Nombre de la categoria <br> | `CREATED (201)` | `BAD_REQUEST(400) {"error":"SportNameInvalidException"}`


## Modficar category a un sport `PATCH /sport/{id}/category` 

> Modifica una categoría a un sport existente.

Ejemplo: `PATCH /sport/1/category  {Informática}`

 Entrada | Respuesta | Respuesta si <br> el sport no existe <br> formato de datos inválido
--|--|-- 
`category: String` <br> la categoría a añadir | `OK (200)` | `BAD_REQUEST(400)`<br> `{"error":"SportIdNotFoundException"}` `{"error":"RequestInvalidException"}`

## Muestra un usuario `GET /user/{id}` 
> Muestra la información de un usuario por su id.

Ejemplo: `GET /user/1  {Informática}`

Parámetros | Respuesta | Respuesta si <br> id no existe <br> id no es entero
--|--|--
--|`OK (200) { "id":1, "name":"David", "birthdate":"", "active":"true" , "sport":[{"title":"tennis","category":"junior"]}`|`BAD_REQUEST(400)`<br>`{"error":"UserIdNotFoundNoException"}`<br>`{"error":"RequestInvalidException"}`

## Asocia un sport a un user `PUT /user/sport` 
> Asocia un sport existente a un user existente.

Ejemplo: `PUT /user/sport  {Informática}`

Entrada | Respuesta | Respuesta si <br> user no existe <br> sport existe <br> dato no valido 
--|--|--
`userId: string` <br> id del user <br> `sportId: string` <br> id del sport | `OK (200)` | `BAD_REQUEST(400)` <br>`{"error":"UserIdNotFoundNoException"}` <br>`{"error":"SportIdNotFoundNoException"}` <br>`{"error":"RequestInvalidException"}`

## Modifica el campo active de un usuario `PATCH /user/{id}/active` 
> Deja activo o desativo a un user.

Ejemplo: `PATCH /user/1/active  {Informática}`

Entrada | Respuesta | Respuesta si <br> User no existe <br> id no es entero.
--|--|--
`active: boolean` <br> estado del active | `OK (200)` | `BAD_REQUEST(400) {"error":"UserNotExistsInvalidException"}` <br>`{"error":"RequestInvalidException"}`
