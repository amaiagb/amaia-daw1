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


-- Volcando estructura de base de datos para escaperoom
CREATE DATABASE IF NOT EXISTS `escaperoom` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `escaperoom`;

-- Volcando estructura para tabla escaperoom.mensajes
CREATE TABLE IF NOT EXISTS `mensajes` (
  `id` int(11) DEFAULT NULL,
  `locutor` varchar(50) DEFAULT NULL,
  `texto_ES` varchar(300) DEFAULT NULL,
  `texto_EN` varchar(300) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla escaperoom.mensajes: ~4 rows (aproximadamente)
INSERT INTO `mensajes` (`id`, `locutor`, `texto_ES`, `texto_EN`, `nivel`) VALUES
	(1, 'Narrador', '¡Bienvenido al nivel 2!', 'Welcome to level 2!', 2),
	(3, 'Bruno', '¡Hola, soy Bruno!', 'Hey! I\', Bruno!', 2),
	(4, 'Aitor', '¡Hola Bruno! Yo soy Aitor', 'Hi Bruno! I\'m Aitor', 2),
	(2, 'Narrador', 'Genial, ya has llegado a la escuela', 'Great! You arrived to the school', 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
