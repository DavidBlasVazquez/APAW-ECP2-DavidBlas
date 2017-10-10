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
 `title: String` <br> Nombre del deporte <br> | `CREATED (201)` | `BAD_REQUEST(400) {"error":"SportNameInvalidException"}`


## Añadir category a un sport `PUT /sport/{id}` 

> Añade una categoría a un sport existente.

Ejemplo: `PUT /user/1/  {Informática}`

 Parámetros | Entrada | Respuesta | Respuesta si <br> el user no existe <br> el sport no existe <br> formato de datos inválido
--|--|--|-- 
`id: String` <br> el id del deporte | `category: String` <br> la categoría a añadir | `OK (200)` | `BAD_REQUEST(400)`<br> `{"error":"UserIdNotFoundException"}`<br>`{"error":"SportIdNotFoundException"}` `{"error":"RequestInvalidException"}`

## Muestra un usuario `GET /user/{id}` 
> Muestra la información de un usuario por su id.

Ejemplo: `GET /user/1  {Informática}`

Parámetros | Respuesta | Respuesta si <br> id no existe <br> id no es entero
--|--|--
--|`OK (200) { "id":1, "name":"David", "active":"true", "sport":"tennis", "category":"junior" }`|`BAD_REQUEST(400)`<br>`{"error":"UserIdNotFoundNoException"}`<br>`{"error":"RequestInvalidException"}`

## Muestra un sport `GET /sport/{id}` 
> Muestra la información de un sport por su id.

Ejemplo: `GET /sport/1  {Informática}`

Parámetros | Respuesta | Respuesta si <br> id no existe <br> id no es entero 
--|--|--
-- | `OK (200) { "id":1, "sport":"tennis", "category":"junior"}` | `BAD_REQUEST(400)` <br>`{"error":"SportIdNotFoundNoException"}` <br>`{"error":"RequestInvalidException"}`


## Desactiva un usuario `PUT /user/{id}/deactivate` 

> Deja inactivo a un user.

Ejemplo: `PUT /user/1/deactive  {Informática}`

Entrada | Respuesta | Respuesta si <br> User no existe <br> id no es entero.
--|--|--
`id: String` <br> Id del user | `OK (200)` | `BAD_REQUEST(400) {"error":"UserNotExistsInvalidException"}` <br>`{"error":"RequestInvalidException"}`
