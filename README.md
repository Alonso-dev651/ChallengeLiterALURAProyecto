# ChallengeLiterALURAProyecto
![Static Badge](https://img.shields.io/badge/proyecto-spring-green)
![Static Badge](https://img.shields.io/badge/status-finish-blue)

## Objetivo

Desarrollar un Catálogo de Libros que ofrezca interacción textual (vía consola) con los usuarios, proporcionando al menos 5 opciones de interacción. Los libros se buscarán a través de una API específica. La información sobre la API y las opciones de interacción con el usuario se detallará en la columna "Backlog"/"Listo para iniciar".

- Configuración del Ambiente Java;
- Creación del Proyecto;
- Consumo de la API;
- Análisis de la Respuesta JSON;
- Inserción y consulta en la base de datos;
- Exibición de resultados a los usuarios;

## Funcionalidad

### 1. Menú

El sistema cuenta con un menú interactivo que ofrece 5 opciones principales:

![Menú](https://github.com/user-attachments/assets/7ffdeecd-6fd6-45fc-b32f-225794f55d56)

### 2. Búsqueda de libros por título

- Permite buscar un libro ingresando su título.
- Realiza una consulta a la API **Gutendex** para obtener información del libro.

![Búsqueda](https://github.com/user-attachments/assets/2a436ad1-82f0-401f-9965-eb3bacf1668a)
![image](https://github.com/user-attachments/assets/42d37412-8a91-40de-89af-c5bfe820b5ef)

- Si el libro es encontrado, se muestra un mensaje confirmando su disponibilidad.
- En caso de que el autor no esté registrado, se permite añadir el autor y el libro.

![Libro encontrado](https://github.com/user-attachments/assets/f5b5b7a2-45cc-4106-9cac-e77c8fe477f3)

- Finalmente, se presenta la información del libro:

![image](https://github.com/user-attachments/assets/5c652d39-67f9-4d39-ad6c-fed3a5120f6f)

### 3. Listado de libros

- Muestra todos los libros almacenados en la base de datos:

![Listado de libros](https://github.com/user-attachments/assets/7e652e19-2640-438d-b2d6-791f16d4bf67)

![Detalle de libros](https://github.com/user-attachments/assets/8bdfdb43-7b9f-451b-b52e-de9927731b71)

### 4. Listado de autores y libros

- Presenta un listado de autores registrados junto con los libros asociados a cada uno:

![Autores](https://github.com/user-attachments/assets/4e095758-c8b5-4158-b837-a1af682c3727)

![Libros por autor](https://github.com/user-attachments/assets/062f0d70-3f85-4d44-aa4d-136ab4b2865f)

### 5. Consulta por año

- Solicita al usuario ingresar un año:

![Ingreso de año](https://github.com/user-attachments/assets/7b89882a-fcdc-4584-a105-2dbaca8f28c7)

- Luego, muestra los resultados correspondientes:

![Resultado por año](https://github.com/user-attachments/assets/6f55661e-8830-4eb3-9d0c-2dc483c6ee93)

### 6. Consulta por idioma

- Presenta un menú para seleccionar un idioma:

![Menú de idiomas](https://github.com/user-attachments/assets/002b1c49-c590-4b06-bca4-eaa67cb0766f)

- Muestra los libros disponibles en el idioma seleccionado:

![Libros por idioma](https://github.com/user-attachments/assets/b84bc618-4b46-4774-8852-e23e3436898e)

- Si no hay libros en el idioma seleccionado, se muestra un mensaje de error:

![Error por idioma](https://github.com/user-attachments/assets/b57a7345-6325-4b90-aa9a-c5ee8b954c58)

### 7. Salida (CASE 0)

- Muestra un mensaje de despedida cuando se selecciona la opción para salir:

![Despedida](https://github.com/user-attachments/assets/2a980828-4410-4da9-be6b-87cde32fb57a)

## Tecnologias utilizadas

- [Spring](https://start.spring.io)
- [IntelliJ](https://www.jetbrains.com/es-es/idea/)
- [jackson - databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [PostgreSQL](https://www.postgresql.org/download/)


