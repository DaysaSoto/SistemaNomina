-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 28-11-2024 a las 00:03:28
-- Versión del servidor: 8.0.30
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemanomina`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleadoasalariado`
--

CREATE TABLE `empleadoasalariado` (
  `id` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nosegurosocial` varchar(50) NOT NULL,
  `salariosemanal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleadocomision`
--

CREATE TABLE `empleadocomision` (
  `id` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nosegurosocial` varchar(50) NOT NULL,
  `ventabruta` float NOT NULL,
  `tarifa` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleadocomisionsalario`
--

CREATE TABLE `empleadocomisionsalario` (
  `id` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nosegurosocial` varchar(50) NOT NULL,
  `ventabruta` float NOT NULL,
  `tarifa` float NOT NULL,
  `salariobase` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleadohora`
--

CREATE TABLE `empleadohora` (
  `id` int NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nosegurosocial` varchar(50) NOT NULL,
  `sueldoporhora` float NOT NULL,
  `horastrabajadas` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleadoasalariado`
--
ALTER TABLE `empleadoasalariado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleadocomision`
--
ALTER TABLE `empleadocomision`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleadocomisionsalario`
--
ALTER TABLE `empleadocomisionsalario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleadohora`
--
ALTER TABLE `empleadohora`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleadoasalariado`
--
ALTER TABLE `empleadoasalariado`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleadocomision`
--
ALTER TABLE `empleadocomision`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleadocomisionsalario`
--
ALTER TABLE `empleadocomisionsalario`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleadohora`
--
ALTER TABLE `empleadohora`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
