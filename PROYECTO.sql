-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2025 a las 20:44:54
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clubdeportivo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `idAct` int(11) NOT NULL,
  `nomAct` varchar(255) DEFAULT NULL,
  `idEntre` int(11) DEFAULT NULL,
  `idZona` int(11) DEFAULT NULL,
  `horario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `actividades`
--

INSERT INTO `actividades` (`idAct`, `nomAct`, `idEntre`, `idZona`, `horario`) VALUES
(6, 'Yoga', 1, 1, 'Lunes 10:00-11:00'),
(7, 'Spinning', 2, 2, 'Martes 18:00-19:00'),
(8, 'Pilates', 3, 3, 'Miércoles 09:00-10:00'),
(9, 'Prueba', 2, 1, 'prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias`
--

CREATE TABLE `asistencias` (
  `id_asistencia` int(11) NOT NULL,
  `id_socio` int(11) NOT NULL,
  `id_actividad` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuotas`
--

CREATE TABLE `cuotas` (
  `idCuota` int(11) NOT NULL,
  `nomCuota` varchar(255) DEFAULT NULL,
  `tipoCuota` varchar(255) DEFAULT NULL,
  `diasCuota` int(11) DEFAULT NULL,
  `precio` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuotas`
--

INSERT INTO `cuotas` (`idCuota`, `nomCuota`, `tipoCuota`, `diasCuota`, `precio`) VALUES
(1, 'Cuota Básica Semanal', 'Semanal', 7, 15),
(2, 'Cuota Estándar Mensual', 'Mensual', 30, 50),
(3, 'Cuota Premium Anual', 'Anual', 365, 500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenadores`
--

CREATE TABLE `entrenadores` (
  `nombre` varchar(30) NOT NULL,
  `apellido_1` varchar(30) NOT NULL,
  `apellido_2` varchar(30) NOT NULL,
  `id_entrenador` int(11) NOT NULL,
  `especialidad` varchar(30) NOT NULL,
  `estado` varchar(15) DEFAULT 'activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrenadores`
--

INSERT INTO `entrenadores` (`nombre`, `apellido_1`, `apellido_2`, `id_entrenador`, `especialidad`, `estado`) VALUES
('Mario', 'González', 'López', 1, 'Yoga', 'activo'),
('Laura', 'Fernández', 'Ruiz', 2, 'Spinning', 'activo'),
('Carlos', 'Martínez', 'Sánchez', 3, 'Pilates', 'activo'),
('Ana', 'Torres', 'Moreno', 4, 'CrossFit', 'activo'),
('Javier', 'Díaz', 'Gómez', 5, 'Zumba', 'activo');

--
-- Disparadores `entrenadores`
--
DELIMITER $$
CREATE TRIGGER `bloquear_delete_entrenadores` BEFORE DELETE ON `entrenadores` FOR EACH ROW BEGIN
  SIGNAL SQLSTATE '45000'
  SET MESSAGE_TEXT = 'No se permite eliminar el entrenador. Usa estado = inactivo.';
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `entrenadores_estado_activo` BEFORE INSERT ON `entrenadores` FOR EACH ROW BEGIN
  IF NEW.estado IS NULL THEN
    SET NEW.estado = 'activo';
  END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios_entrenador`
--

CREATE TABLE `horarios_entrenador` (
  `id_horario` int(11) NOT NULL,
  `id_entrenador` int(11) NOT NULL,
  `id_actividad` int(11) NOT NULL,
  `dia` varchar(10) NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `id_inscripcion` int(11) NOT NULL,
  `id_socio` int(11) NOT NULL,
  `id_actividad` int(11) NOT NULL,
  `fecha_inscripcion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `id_socio` int(11) DEFAULT NULL,
  `id_cuota` int(11) DEFAULT NULL,
  `pagado` varchar(255) DEFAULT 'No Pagao',
  `sigPago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`id_socio`, `id_cuota`, `pagado`, `sigPago`) VALUES
(101, 1, 'No pagao', '2025-01-17'),
(102, 2, 'No pagao', '2025-03-15'),
(103, 3, 'No pagao', '2026-03-01'),
(104, 1, 'No pagao', '2025-04-12'),
(105, 2, 'No pagao', '2025-06-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `nombre` varchar(30) NOT NULL,
  `edad` int(3) NOT NULL,
  `apellido_1` varchar(30) NOT NULL,
  `apellido_2` varchar(30) NOT NULL,
  `id_socio` int(11) NOT NULL,
  `estado` varchar(15) DEFAULT 'activo',
  `inscripcion` date DEFAULT NULL,
  `id_cuota` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`nombre`, `edad`, `apellido_1`, `apellido_2`, `id_socio`, `estado`, `inscripcion`, `id_cuota`) VALUES
('Ana', 25, 'García', 'Pérez', 101, 'activo', '2025-01-10', 1),
('Luis', 32, 'Martínez', 'Ruiz', 102, 'activo', '2025-02-15', 2),
('Carmen', 40, 'López', 'Gómez', 103, 'activo', '2025-03-01', 3),
('Pedro', 29, 'Sánchez', 'Moreno', 104, 'activo', '2025-04-05', 1),
('Lucía', 37, 'Díaz', 'Torres', 105, 'activo', '2025-05-20', 2);

--
-- Disparadores `socios`
--
DELIMITER $$
CREATE TRIGGER `T_sigPago` AFTER INSERT ON `socios` FOR EACH ROW BEGIN
    DECLARE tipo VARCHAR(20);

    SELECT tipoCuota INTO tipo 
    FROM cuotas 
    WHERE idCuota = NEW.id_cuota;

    IF tipo = 'Semanal' THEN
        INSERT INTO pagos (id_socio, id_cuota, pagado, sigPago)
        VALUES (NEW.id_socio, NEW.id_cuota, 'No pagao', DATE_ADD(NEW.inscripcion, INTERVAL 7 DAY));

    ELSEIF tipo = 'Mensual' THEN
        INSERT INTO pagos (id_socio, id_cuota, pagado, sigPago)
        VALUES (NEW.id_socio, NEW.id_cuota, 'No pagao', DATE_ADD(NEW.inscripcion, INTERVAL 1 MONTH));

    ELSEIF tipo = 'Anual' THEN
        INSERT INTO pagos (id_socio, id_cuota, pagado, sigPago)
        VALUES (NEW.id_socio, NEW.id_cuota, 'No pagao', DATE_ADD(NEW.inscripcion, INTERVAL 1 YEAR));
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(30) NOT NULL,
  `nombre_usuario` varchar(30) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `rol` varchar(30) NOT NULL,
  `fecha_creacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas`
--

CREATE TABLE `zonas` (
  `idZona` int(11) NOT NULL,
  `nomZona` varchar(255) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `zonas`
--

INSERT INTO `zonas` (`idZona`, `nomZona`, `capacidad`, `estado`) VALUES
(1, 'Sala Yoga', 20, 'Libre'),
(2, 'Sala Spinning', 25, 'Libre'),
(3, 'Sala Pilates', 15, 'Ocupado'),
(4, 'Sala CrossFit', 30, 'Libre'),
(5, 'Sala Zumba', 18, 'Ocupado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`idAct`),
  ADD UNIQUE KEY `UC_Actividad` (`nomAct`,`idEntre`,`horario`),
  ADD UNIQUE KEY `UC_Entrenador` (`idEntre`,`horario`);

--
-- Indices de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD PRIMARY KEY (`id_asistencia`);

--
-- Indices de la tabla `cuotas`
--
ALTER TABLE `cuotas`
  ADD PRIMARY KEY (`idCuota`);

--
-- Indices de la tabla `entrenadores`
--
ALTER TABLE `entrenadores`
  ADD PRIMARY KEY (`id_entrenador`);

--
-- Indices de la tabla `horarios_entrenador`
--
ALTER TABLE `horarios_entrenador`
  ADD PRIMARY KEY (`id_horario`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`id_inscripcion`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `zonas`
--
ALTER TABLE `zonas`
  ADD PRIMARY KEY (`idZona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `idAct` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `cuotas`
--
ALTER TABLE `cuotas`
  MODIFY `idCuota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `zonas`
--
ALTER TABLE `zonas`
  MODIFY `idZona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
