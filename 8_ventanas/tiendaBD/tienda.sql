-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.19-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.7.0.6859
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
  `id` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla tienda.productos: ~3 rows (aproximadamente)
INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `color`) VALUES
	(1, 'Monitor', '4K Full HD', 'Negro'),
	(2, 'Teclado', 'Inalámbrico', 'Negro'),
	(3, 'Ratón', 'Conexión bluetooth', 'Blanco');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
