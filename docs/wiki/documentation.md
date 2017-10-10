# Introducción
> Gestión de usuarios de deportes.
>
>Esta aplicación permitirá crear y habilitar a usuarios vinculados a deportes y categorías deportivas.

## Entities
Diagrama de la entidad:  
![api-architecture-simulation-theme-entities](https://github.com/DavidBlasVazquez/APAW-ECP2-DavidBlas/blob/master/docs/api-architecture-simulation-theme-entities.png)

# API Rest
## Crear un nuevo usuario `POST /user`  
> Si añade al usuario con éxito devuelve el propio recurso, pero si ya existe devuelve un mensaje error.
> Por defecto al ser creado el usuario queda active.

Ejemplo: `POST /user  {Informática}`

 Entrada | Respuesta | Respuesta si <br> user no es creado 
--|--|--
`username: String` <br> Nombre de usuario  | `CREATED (201)` | `BAD_REQUEST(400) {"error":""} {"error":"UserIdExistsException"}`


## Crear un nuevo deporte `POST /sport`  
> Si añade un deporte con éxito devuelve el recurso, pero si ya existe devuelve un error.

Ejemplo: `POST /sport  {Informática}`

 Entrada | Respuesta | Respuesta sin <br> sport no es creado
--|--|--
`sportname: String` <br> Nombre del deporte <br> `category: String` <br> Categoría del deporte | `CREATED (201)` | `BAD_REQUEST(400) {"error":"SportIdExistsException"}`

## Asocia un nuevo usuario con un deporte `PUT /user/{id}/sport/{id}`  
> Asocia a un usuario ya existente con un deporte ya existente. Si se asocia devuelve el recurso, de lo contrario devuelve un mensaje de error.

Ejemplo: `PUT /user/1/sport/1  {Informática}`

 Entrada | Respuesta | Respuesta si <br> la asociacion no es creada <br> algún id no es entero
--|--|--
`username: String` <br> ID del user <br> `sportid: String` <br> Id del sport | `CREATED (201)` | `BAD_REQUEST(400) {"error":"NotAssociationException"} <br> {"error":"RequestInvalidException"}` 

## Muestra un usuario `GET /user/{id}`  
> Muestra la información de un usuario por su id. Si no existe o formato invalido, devuelve un mensaje de error.

Ejemplo: `POST /user/1  {Informática}`

 Parámetros | Respuesta | Respuesta si <br> id no existe <br> id no es entero <br> resultado correcto
--|--|--
| `CREATED (201)` | `BAD_REQUEST(400)` | `{"error":"UserIdNotFoundNoException" <br> {"error":"RequestInvalidException"} <br> { "id":1, "name":"David", "active":"true", "sport":"tennis", "category":"junior" }`

## Muestra un sport `GET /sport/{id}`  
> Muestra la información de un sport por su id. Si no existe o formato invalido, devuelve un mensaje de error.

Ejemplo: `POST /sport/1  {Informática}`

 Parámetros | Respuesta | Respuesta si <br> id no existe <br> id no es entero <br> resultado correcto
--|--|--
| `CREATED (201)` | `BAD_REQUEST(400)` | `{"error":"UserIdNotFoundNoException" <br> {"error":"RequestInvalidException"} <br> { "id":1, "sport":"tennis", "category":"junior" }`

## Desactiva un usuario `PUT /user/{id}/deactivate`  
> Deja inactivo a un user. Si lo cambia o ya estaba desactivo, devuelve el recurso.  Si no existe, devuelve un mensaje de error.

Ejemplo: `POST /user/1/deactive  {Informática}`

 Entrada | Respuesta | Respuesta sin tema
--|--|--
`id: String` <br> Id del user | `CREATED (201)` | `BAD_REQUEST(400) {"error":"UserNotExistsInvalidException"}`
