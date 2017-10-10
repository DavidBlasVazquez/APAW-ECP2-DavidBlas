# Introducción
> Gestión de usuarios de deportes.
>
>Esta aplicación permitirá crear y habilitar a usuarios vinculados a deportes y categorías deportivas.

## Entities
Diagrama de la entidad:  
![api-architecture-simulation-theme-entities](https://github.com/DavidBlasVazquez/APAW-ECP2-DavidBlas/blob/master/docs/api-architecture-simulation-theme-entities.png)

# API Rest
## Crear un usuario `POST /user`  
> Si añade al usuario con éxito devuelve el propio recurso, pero si ya existe devuelve un error.
> Por defecto al ser creado el usuario queda active.

Ejemplo: `POST /user  {Informática}`

 Entrada | Respuesta | Respuesta sin tema
--|--|--
`username: String` <br> Nombre de usuario  | `CREATED (201)` | `BAD_REQUEST(400) {"error":"UserExistsInvalidException"}`


## Crear un nuevo deporte `POST /sport`  
> Si añade un deporte con éxito devuelve el recurso, pero si ya existe devuelve un error.

Ejemplo: `POST /sport  {Informática}`

 Entrada | Respuesta | Respuesta sin tema
--|--|--
`sportname: String` <br> Nombre del deporte <br> `category: String` <br> Categoría del deporte | `CREATED (201)` | `BAD_REQUEST(400) {"error":"SportExistsInvalidException"}`

## Crear un usuario asociado a un deporte `POST /user/sport/{id}`  
> Añade un susario asociándolo a un deporte ya existe. Si se crea devuelve el recurso, pero si ya existe devuelve un error. Por defecto al ser creado el usuario queda active.

Ejemplo: `POST /user/sport/1  {Informática}`

 Entrada | Respuesta | Respuesta sin tema
--|--|--
`username: String` <br> Nombre de usuario <br> `sportid: String` <br> id del sport | `CREATED (201)` | `BAD_REQUEST(400) {"error":"UserNotCreatedInvalidException"}`

## Eliminar usuario `DELETE /user/{id}`  
> Elimina un usuario mediante su id. Si lo hace, devuelve el recurso. Si no existe, devuelve un mensaje de error.

Ejemplo: `POST /user/1  {Informática}`

 Entrada | Respuesta | Respuesta sin tema
--|--|--
`id: String` <br> Id del usuario | `CREATED (201)` | `BAD_REQUEST(400) {"error":"UserNotExistsInvalidException"}`

## Eliminar sport `DELETE /sport/{id}`  
> Elimina un sport mediante su id. Si lo hace, devuelve el recurso. Si no existe, devuelve un mensaje de error.

Ejemplo: `POST /sport/1  {Informática}`

 Entrada | Respuesta | Respuesta sin tema
--|--|--
`id: String` <br> Id del sport | `CREATED (201)` | `BAD_REQUEST(400) {"error":"SportNotExistsInvalidException"}`

