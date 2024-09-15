# HeroesApp

## Descripción

HeroesApp es una aplicación Android que permite a los usuarios iniciar sesión, explorar una lista de personajes de Marvel y DC, y ver detalles específicos de cada héroe. La aplicación está diseñada para proporcionar una experiencia intuitiva y funcional, con una interfaz moderna utilizando ConstraintLayout.

## Desarrollador

- **Nombre:** UrieL

## Requerimientos del Proyecto

### 1. MainActivity
- **Funcionalidad de Login:**
  - Implementar una actividad de login.
  - Crear una clase `User` con los parámetros `email` y `password`.
  - Tener una lista estática de usuarios válidos para la autenticación.
  - Validar el email introducido por el usuario. Si no es válido, se muestra un `Snackbar` con el mensaje de error.
  - Si la autenticación es exitosa, navegar a `PublisherActivity` y guardar una bandera `isLogged` en `SharedPreferences`.
  - Si la aplicación se cierra y se vuelve a abrir, debe respetar el estado de `isLogged` del usuario.

### 2. PublisherActivity
- **Lista de Publishers:**
  - Mostrar una lista de los publishers **Marvel** y **DC** utilizando un `RecyclerView` y su adaptador correspondiente.
  - Crear una clase `Publisher` con las propiedades `id`, `name` e `image` (URL como String para cargar la imagen utilizando la librería Picasso).
  - Al seleccionar **Marvel** o **DC**, navegar a `HeroesActivity` pasando el `id` del publisher seleccionado.
  - Botón para cerrar sesión.

### 3. HeroesActivity
- **Lista de Héroes:**
  - Mostrar una lista de héroes del publisher seleccionado (**Marvel** o **DC**), utilizando un `RecyclerView`.
  - Al seleccionar un héroe, navegar a `HeroDetailActivity` con el `id` del héroe seleccionado.

### 4. HeroDetailActivity
- **Detalles del Héroe:**
  - Mostrar el detalle del héroe seleccionado, incluyendo nombre, descripción e imagen (cargar imagen con Picasso).
  - Filtrar el héroe seleccionado por su `id` de una lista estática de héroes.

## Diseño y Funcionalidad
- Todos los componentes deben estar implementados utilizando **ConstraintLayout** para asegurar una interfaz fluida y adaptable.
- El diseño será evaluado según la creatividad y la usabilidad de la interfaz de usuario.
- La funcionalidad debe ser completa y sin errores.

## Librerías Utilizadas
- **Picasso:** Para la carga de imágenes desde URLs en las vistas de los héroes y publishers.

## Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/heroesapp.git

