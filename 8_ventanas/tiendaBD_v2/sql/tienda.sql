-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.24-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para tienda
CREATE DATABASE IF NOT EXISTS `tienda` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `tienda`;

-- Volcando estructura para tabla tienda.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `descuento` tinyint(4) DEFAULT NULL,
  `valor_dto` int(11) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla tienda.productos: ~9 rows (aproximadamente)
INSERT INTO `productos` (`id`, `nombre`, `precio`, `descuento`, `valor_dto`, `categoria`, `descripcion`, `color`, `estado`) VALUES
	(1, 'Monitor', 200, 0, 0, 'Informática', '4K Full HD', 'Negro', 'Nuevo'),
	(2, 'Teclado', 60, 0, 0, 'Informática', 'Inalámbrico', 'Negro', 'Nuevo'),
	(3, 'Ratón', 45, 1, 10, 'Informática', 'Conexión bluetooth', 'Blanco', 'Reacondiconado'),
	(5, 'Auriculares', 39.99, 0, 0, 'Audio', 'Bluetooth', 'Blanco', 'Nuevo'),
	(6, 'Altavoz', 210, 1, 15, 'Audio', 'Inalámbrico', 'Azul', 'Reacondicionado'),
	(7, 'ipad', 480, 0, 0, 'electrónica', 'wifi 3G 128GB', 'negro', 'nuevo'),
	(13, 'Monitor HD', 135, 1, 25, 'Informática', 'Full HD ', 'Negro', 'Reacondicionado'),
	(14, 'iphone', 999, 0, 0, 'Electrónica', '256GB', 'Blanco', 'Nuevo'),
	(15, 'Portátil', 760, 0, 0, 'Informática', '15,6"', 'Gris', 'Nuevo');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
