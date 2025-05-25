# 🏋️‍♂️ Club Deportivo - Sistema de Gestión

Bienvenido al sistema de gestión para el **Club Deportivo**.  
Esta aplicación permite gestionar de manera sencilla y eficiente las actividades, socios, entrenadores, pagos e instalaciones del club.  

---

## 🧭 Funcionalidades principales

### 🔑 0. Inicio de Sesión
- Permite iniciar sesión como usuario autorizado.
- Redirige automáticamente a la pantalla principal tras un inicio exitoso.

---

### 👥 1. Socios
- ➕ Añadir nuevo socio.
- 🔎 Buscar o ver el listado de socios.
- ✏️ Editar información de un socio.
- 🗑️ Dar de baja (desactivar) un socio.

---

### 🏃‍♂️ 2. Actividades
- ➕ Crear una nueva actividad.
- 📅 Ver el calendario de actividades.
- ✏️ Modificar una actividad existente.
- 🗑️ Eliminar una actividad.

---

### 🧑‍🏫 3. Entrenadores
- ➕ Registrar un nuevo entrenador.
- 📋 Ver listado de entrenadores.
- 📆 Consultar horarios asignados a cada entrenador.
- ✏️ Editar información de un entrenador.

---

### 🏟️ 5. Instalaciones
- 🛠️ Marcar una instalación como **en mantenimiento**.
- 🔍 Ver la disponibilidad de una instalación.
- 📅 Consultar el calendario de uso de las instalaciones.

---

## 🗂️ Estructura de la Base de Datos

### 📄 Socio
| Campo        | Tipo         | Descripción                  |
|--------------|--------------|-----------------------------|
| ID_Socio (PK) | INT          | Identificador único         |
| Nombre       | VARCHAR      | Nombre del socio            |
| Apellidos    | VARCHAR      | Apellidos del socio         |
| DNI          | VARCHAR      | Documento de identidad      |
| Dirección    | VARCHAR      | Dirección del socio         |
| Teléfono     | VARCHAR      | Número de contacto          |
| Email        | VARCHAR      | Correo electrónico          |
| FechaAlta    | DATE         | Fecha de alta en el club    |
| Estado       | ENUM         | Activo / Inactivo           |

---

### 📄 Actividad
| Campo            | Tipo         | Descripción                          |
|------------------|--------------|-------------------------------------|
| ID_Actividad (PK) | INT          | Identificador único                 |
| Nombre           | VARCHAR      | Nombre de la actividad              |
| Descripción      | TEXT         | Breve descripción                   |
| FechaInicio      | DATE         | Fecha de inicio                     |
| FechaFin         | DATE         | Fecha de finalización               |
| CupoMáximo       | INT          | Capacidad máxima                    |
| ID_Entrenador (FK) | INT        | Entrenador responsable (relación)   |
| ID_Instalación (FK) | INT      | Instalación asignada (relación)     |

---

### 📄 Entrenador
| Campo           | Tipo         | Descripción                  |
|-----------------|--------------|-----------------------------|
| ID_Entrenador (PK) | INT        | Identificador único         |
| Nombre          | VARCHAR      | Nombre del entrenador       |
| Apellidos       | VARCHAR      | Apellidos del entrenador    |
| Especialidad    | VARCHAR      | Área de especialidad        |
| Teléfono        | VARCHAR      | Número de contacto          |
| Email           | VARCHAR      | Correo electrónico          |

---

### 📄 Pago
| Campo         | Tipo         | Descripción                  |
|---------------|--------------|-----------------------------|
| ID_Pago (PK)  | INT          | Identificador único         |
| ID_Socio (FK) | INT          | Socio relacionado           |
| Fecha         | DATE         | Fecha del pago              |
| Monto         | DECIMAL      | Monto del pago              |
| Estado        | ENUM         | Pagado / Pendiente          |
| Concepto      | VARCHAR      | Descripción del pago        |

---

### 📄 Cuota
| Campo         | Tipo         | Descripción                  |
|---------------|--------------|-----------------------------|
| ID_Cuota (PK) | INT          | Identificador único         |
| Mes           | INT          | Mes correspondiente         |
| Año           | INT          | Año correspondiente         |
| Monto         | DECIMAL      | Monto de la cuota           |

---

### 📄 Inscripción
| Campo            | Tipo         | Descripción                  |
|------------------|--------------|-----------------------------|
| ID_Socio (FK)    | INT          | Socio inscrito              |
| ID_Actividad (FK)| INT          | Actividad inscrita          |
| FechaInscripción | DATE         | Fecha de inscripción        |

---

### 📄 Instalación
| Campo              | Tipo         | Descripción                        |
|--------------------|--------------|-----------------------------------|
| ID_Instalación (PK) | INT         | Identificador único               |
| Nombre             | VARCHAR      | Nombre de la instalación          |
| Ubicación          | VARCHAR      | Ubicación de la instalación       |
| Estado             | ENUM         | Disponible / Mantenimiento        |

---

## ✅ Pruebas Unitarias (JUnit)

📌 Se han creado pruebas unitarias **básicas** para la clase `VerInstalacion` que permiten validar:

- La correcta creación del modelo de tabla (`DefaultTableModel`) y sus columnas.
- La inicialización de la tabla (`JTable`).
- La ejecución del constructor sin errores.
- La ejecución de la carga de datos (`cargarDatos()`) sin excepciones.
- La consistencia de los nombres de las columnas esperadas.

📌 Estas pruebas **NO** requieren modificar el código original, y se centran en verificar el correcto funcionamiento de la interfaz y estructura básica.

---

