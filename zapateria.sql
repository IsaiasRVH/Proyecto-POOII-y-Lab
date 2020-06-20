-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2020 a las 19:32:45
-- Versión del servidor: 5.7.17
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `zapateria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(25) COLLATE utf8_bin NOT NULL,
  `calleYNumero` varchar(40) COLLATE utf8_bin NOT NULL,
  `colonia` varchar(25) COLLATE utf8_bin NOT NULL,
  `ciudad` varchar(25) COLLATE utf8_bin NOT NULL,
  `codigoPostal` varchar(5) COLLATE utf8_bin NOT NULL,
  `estado` varchar(20) COLLATE utf8_bin NOT NULL,
  `pais` varchar(20) COLLATE utf8_bin NOT NULL,
  `telefono` varchar(13) COLLATE utf8_bin NOT NULL,
  `email` varchar(30) COLLATE utf8_bin NOT NULL,
  `adeudo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre`, `apellidos`, `calleYNumero`, `colonia`, `ciudad`, `codigoPostal`, `estado`, `pais`, `telefono`, `email`, `adeudo`) VALUES
(1, 'Cliente', 'General', '*****', '*****', '*****', '*****', '*****', '*****', '*****', '*****', 12396),
(2, 'Carlos', 'Mora López', 'Delicias #1309', 'Centro', 'Jalpa', '99600', 'Zacatecas', 'México', '4631014381', 'carlosmora25@live.com', 0),
(3, 'Laura', 'Suárez Guerrero', 'Profa. Hermelinda Estrada #220', 'Martínez', 'Calvillo', '20805', 'Aguascalientes', 'México', '4951038937', 'lau.suarez@gmail.com', 0),
(4, 'Juan', 'García Saldaña', 'J. Mota Padilla #1024', 'San Antonio', 'Jalpa', '99600', 'Zacatecas', 'México', '4631078365', 'juangarcia13@gmail.com', 0),
(5, 'María', 'Cabrera Vázquez', '21 de septiembre #1203', 'El Rosario', 'Jalpa', '99600', 'Zacatecas', 'México', '4639533472', 'mariacv205@gmail.com', 1299);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `idVenta` int(11) NOT NULL,
  `codigo` varchar(25) COLLATE utf8_bin NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `importe` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`idVenta`, `codigo`, `cantidad`, `precio`, `importe`) VALUES
(1, '2', 3, 2400, 7200),
(1, '3', 1, 1800, 1800),
(2, '2', 1, 2400, 2400),
(3, '1', 3, 1200, 3600),
(3, '2', 2, 2400, 4800),
(3, '3', 2, 1800, 3600),
(3, '5', 1, 1100, 1100),
(5, '2', 2, 2400, 4800),
(5, '3', 1, 1800, 1800),
(5, '4', 1, 999, 999),
(6, '1', 1, 1200, 1200),
(6, '2', 2, 2400, 4800),
(6, '3', 1, 1800, 1800),
(6, '5', 1, 1100, 1100),
(7, '2', 1, 2400, 2400),
(7, '3', 2, 1800, 3600),
(7, '4', 1, 999, 999),
(7, '5', 1, 1100, 1100),
(9, '1', 1, 1200, 1200),
(9, '2', 2, 2400, 4800),
(9, '3', 1, 1800, 1800),
(10, '1', 1, 1200, 1200),
(10, '2', 1, 2400, 2400),
(10, '3', 3, 1800, 5400),
(10, '4', 1, 999, 999),
(10, '5', 1, 1100, 1100),
(11, '1', 1, 1200, 1200),
(12, '1', 1, 1200, 1200),
(12, '2', 1, 2400, 2400),
(12, '3', 1, 1800, 1800),
(12, '4', 1, 999, 999),
(12, '5', 1, 1100, 1100),
(18, '1', 1, 1200, 1200),
(18, '5', 1, 1100, 1100),
(19, '11', 1, 1099, 1099),
(19, '8', 1, 1200, 1200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigo` varchar(25) COLLATE utf8_bin NOT NULL,
  `modelo` varchar(40) COLLATE utf8_bin NOT NULL,
  `marca` varchar(20) COLLATE utf8_bin NOT NULL,
  `color` varchar(30) COLLATE utf8_bin NOT NULL,
  `estilo` varchar(15) COLLATE utf8_bin NOT NULL,
  `existencias` double NOT NULL,
  `precio` double NOT NULL,
  `idProveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo`, `modelo`, `marca`, `color`, `estilo`, `existencias`, `precio`, `idProveedor`) VALUES
('1', 'Chuck Taylor', 'Converse', 'Blanco', 'Tenis', 10, 1200, 1),
('10', 'Coast Star', 'Adidas', 'Blanco', 'Tenis', 20, 1600, 4),
('11', '811004', 'Levi\'s', 'Cafe', 'Botas', 10, 1099, 5),
('2', 'AirMax Verona', 'Nike', 'Blanco', 'Tenis', 20, 2400, 1),
('3', 'Metcon 5', 'Nike', 'Gris', 'Tenis', 20, 1800, 1),
('4', '0153', 'Jeep', 'Cafe', 'Botas', 7, 999, 1),
('5', '0351', 'Jeep', 'Cafe', 'Botas', 4, 1100, 1),
('6', '403304', 'Flexi', 'Negro', 'Zapatos', 10, 999, 3),
('7', '402301', 'Flexi', 'Negro', 'Zapatos', 10, 899, 3),
('8', 'Yacht Club Old Skool', 'Vans', 'Verde', 'Tenis', 15, 1200, 2),
('9', 'OTW Sidewall Old Skool', 'Vans', 'Rojo', 'Tenis', 5, 1200, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `calleYNumero` varchar(40) COLLATE utf8_bin NOT NULL,
  `colonia` varchar(25) COLLATE utf8_bin NOT NULL,
  `ciudad` varchar(25) COLLATE utf8_bin NOT NULL,
  `codigoPostal` varchar(5) COLLATE utf8_bin NOT NULL,
  `estado` varchar(25) COLLATE utf8_bin NOT NULL,
  `pais` varchar(25) COLLATE utf8_bin NOT NULL,
  `telefono` varchar(13) COLLATE utf8_bin NOT NULL,
  `email` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombre`, `calleYNumero`, `colonia`, `ciudad`, `codigoPostal`, `estado`, `pais`, `telefono`, `email`) VALUES
(1, 'Calzados Del Centro', 'Porfirio Diaz #1209', 'Industria', 'Leon', '98342', 'Guanajuato', 'Mexico', '4872302233', 'calzadosdelcentro@cdc.org'),
(2, 'La Piedad Calzados', 'Juarez #3049, Int. 7', 'Guadalupe', 'Monterrey', '64104', 'Nuevo León', 'México', '8004735961', 'lapiedadmty@piedad.org'),
(3, 'Textiles Los Rodríguez', 'Hidalgo #1311', 'Morelos', 'León', '34728', 'Guanajuato', 'México', '9673291092', 'losrodrigueztextiles@yahoo.com'),
(4, 'TecShoes Sportline', '20 de Noviembre #9370', 'Industria', 'León', '98342', 'Guanajuato', 'México', '4871032378', 'tecshoesmex@tecshoes.com'),
(5, 'Marianas Calzados', '20 de Noviembre #5309', 'Industria', 'León', '98342', 'Guanajuato', 'México', '4871024051', 'contactus@marianas.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(25) COLLATE utf8mb4_bin NOT NULL,
  `telefono` varchar(13) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `calleYNumero` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `colonia` varchar(15) COLLATE utf8mb4_bin NOT NULL,
  `codigoPostal` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ciudad` varchar(15) COLLATE utf8mb4_bin NOT NULL,
  `estado` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pais` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `salario` double NOT NULL,
  `contrasenia` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellidos`, `telefono`, `email`, `calleYNumero`, `colonia`, `codigoPostal`, `ciudad`, `estado`, `pais`, `salario`, `contrasenia`) VALUES
(1, 'Administrador', '', '*****', '*****', '*****', '*****', '*****', '*****', '*****', '*****', 0, 'admin'),
(2, 'Luis', 'Escobedo Romero', '4632394385', 'luis123@gmail.com', 'Iturbide #1089', 'Centro', '99600', 'Jalpa', 'Zacatecas', 'Mexico', 2500, '12345'),
(3, 'Isaías Ricardo', 'Valdivia Hernández', '4921438738', 'isaias.valdivia147@gmail.com', 'Zaragoza #18', 'Reforma', '99607', 'Jalpa', 'Zacatecas', 'Mexico', 3000, '12345678'),
(7, 'Diego', 'Roque Velazco', '4631092386', 'diegoroque23@gmail.com', 'Pizarro #1274', 'Rosario', '99600', 'Jalpa', 'Zacatecas', 'Mexico', 1600, '12345678');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `tipoVenta` varchar(10) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `idUsuario`, `idCliente`, `fecha`, `total`, `tipoVenta`) VALUES
(1, 3, 1, '2020-06-05', 15800, 'Contado'),
(2, 3, 1, '2020-06-15', 2400, 'Contado'),
(3, 3, 1, '2020-06-15', 13100, 'Contado'),
(5, 3, 1, '2020-06-15', 7599, 'Contado'),
(6, 3, 1, '2020-06-15', 8900, 'Contado'),
(7, 3, 1, '2020-06-15', 8099, 'Contado'),
(9, 1, 1, '2020-06-16', 7800, 'Contado'),
(10, 2, 1, '2020-06-16', 11099, 'Contado'),
(11, 3, 1, '2020-06-16', 4600, 'Contado'),
(12, 3, 1, '2020-06-16', 7499, 'Contado'),
(18, 2, 1, '2020-06-16', 2300, 'Contado'),
(19, 2, 5, '2020-06-16', 2299, 'Credito');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`idVenta`,`codigo`),
  ADD KEY `codigo` (`codigo`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `idProveedor` (`idProveedor`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idCliente` (`idCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `producto` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
