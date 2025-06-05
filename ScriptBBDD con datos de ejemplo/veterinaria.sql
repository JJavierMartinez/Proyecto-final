-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.5.2-MariaDB - mariadb.org binary distribution
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


-- Volcando estructura de base de datos para veterinaria
CREATE DATABASE IF NOT EXISTS `veterinaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `veterinaria`;

-- Volcando estructura para tabla veterinaria.citas
CREATE TABLE IF NOT EXISTS `citas` (
  `id_cita` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `id_paciente` bigint(20) DEFAULT NULL,
  `id_pago` bigint(20) DEFAULT NULL,
  `id_veterinario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `FKa6jbqxi4v5ij2jdlgrmwnt94o` (`id_paciente`),
  KEY `FK9v7f3yogq3ik63qp9adb552g4` (`id_pago`),
  KEY `FKg5i7jfrign48aep0uxtml2h2u` (`id_veterinario`),
  CONSTRAINT `FK9v7f3yogq3ik63qp9adb552g4` FOREIGN KEY (`id_pago`) REFERENCES `pagos` (`id_pago`),
  CONSTRAINT `FKa6jbqxi4v5ij2jdlgrmwnt94o` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`),
  CONSTRAINT `FKg5i7jfrign48aep0uxtml2h2u` FOREIGN KEY (`id_veterinario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria.citas: ~5 rows (aproximadamente)
INSERT INTO `citas` (`id_cita`, `fecha`, `motivo`, `id_paciente`, `id_pago`, `id_veterinario`) VALUES
	(1, '2025-05-31 17:03:13.000000', 'Consulta de rutina', 1, 1, 3),
	(2, '2025-06-01 17:03:13.000000', 'Vacunación anual', 2, 2, 4),
	(3, '2025-06-02 17:03:13.000000', 'Revisión de dermatitis', 3, 3, 3),
	(4, '2025-06-03 17:03:13.000000', 'Chequeo postoperatorio', 5, 4, 5),
	(5, '2025-06-04 17:03:13.000000', 'Desparasitación', 4, 5, 4);

-- Volcando estructura para tabla veterinaria.enfermedades
CREATE TABLE IF NOT EXISTS `enfermedades` (
  `id_enfermedad` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_enfermedad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria.enfermedades: ~5 rows (aproximadamente)
INSERT INTO `enfermedades` (`id_enfermedad`, `descripcion`, `nombre`) VALUES
	(1, 'Enfermedad viral canina altamente contagiosa', 'Moquillo'),
	(2, 'Infección viral grave en perros', 'Parvovirus'),
	(3, 'Enfermedad viral en gatos que afecta el sistema inmunológico', 'Leucemia felina'),
	(4, 'Inflamación del oído', 'Otitis'),
	(5, 'Inflamación de la piel', 'Dermatitis');

-- Volcando estructura para tabla veterinaria.historiales
CREATE TABLE IF NOT EXISTS `historiales` (
  `id_historial` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_evento` datetime(6) DEFAULT NULL,
  `notas` varchar(255) DEFAULT NULL,
  `tipo_evento` varchar(255) DEFAULT NULL,
  `id_paciente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_historial`),
  KEY `FK8hnhwlkyhkyyaxkdn56axstpj` (`id_paciente`),
  CONSTRAINT `FK8hnhwlkyhkyyaxkdn56axstpj` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria.historiales: ~5 rows (aproximadamente)
INSERT INTO `historiales` (`id_historial`, `fecha_evento`, `notas`, `tipo_evento`, `id_paciente`) VALUES
	(1, '2025-05-30 17:03:13.000000', 'Primera consulta de rutina', 'Consulta', 1),
	(2, '2025-05-30 17:03:13.000000', 'Vacunación anual', 'Vacunación', 1),
	(3, '2025-05-30 17:03:13.000000', 'Revisión postoperatoria', 'Revisión', 3),
	(4, '2025-05-30 17:03:13.000000', 'Desparasitación', 'Tratamiento', 2),
	(5, '2025-05-30 17:03:13.000000', 'Chequeo general', 'Consulta', 4);

-- Volcando estructura para tabla veterinaria.historial_enfermedad
CREATE TABLE IF NOT EXISTS `historial_enfermedad` (
  `id_enfermedad` bigint(20) NOT NULL,
  `id_historial` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_diagnostico` datetime(6) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `tratamiento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_enfermedad`,`id_historial`),
  KEY `FKapi73duqotmy2awkt8n9cwrg4` (`id_historial`),
  CONSTRAINT `FKapi73duqotmy2awkt8n9cwrg4` FOREIGN KEY (`id_historial`) REFERENCES `historiales` (`id_historial`),
  CONSTRAINT `FKlpv5k3uqivftc84aatc9priyp` FOREIGN KEY (`id_enfermedad`) REFERENCES `enfermedades` (`id_enfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria.historial_enfermedad: ~2 rows (aproximadamente)
INSERT INTO `historial_enfermedad` (`id_enfermedad`, `id_historial`, `estado`, `fecha_diagnostico`, `observaciones`, `tratamiento`) VALUES
	(4, 1, 'Tratado', '2025-05-30 17:03:13.000000', 'Leve inflamación en oído derecho', 'Gotas óticas cada 12 horas por 7 días'),
	(5, 3, 'Crónico', '2025-05-30 17:03:13.000000', 'Dermatitis alérgica estacional', 'Antihistamínicos y champú especial');

-- Volcando estructura para tabla veterinaria.pacientes
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id_paciente` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni_mascota` varchar(255) DEFAULT NULL,
  `especie` varchar(255) DEFAULT NULL,
  `fecha_nac` datetime(6) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `raza` varchar(255) DEFAULT NULL,
  `seguro` bit(1) DEFAULT NULL,
  `id_dueno` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `FKlawxt4o6spky0f0ymeiu48lni` (`id_dueno`),
  CONSTRAINT `FKlawxt4o6spky0f0ymeiu48lni` FOREIGN KEY (`id_dueno`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria.pacientes: ~5 rows (aproximadamente)
INSERT INTO `pacientes` (`id_paciente`, `apellidos`, `dni_mascota`, `especie`, `fecha_nac`, `fecha_registro`, `nombre`, `raza`, `seguro`, `id_dueno`) VALUES
	(1, NULL, 'M001', 'Perro', '2020-04-15 00:00:00.000000', '2025-05-30 17:03:13.000000', 'Max', 'Labrador', b'1', 6),
	(2, NULL, 'M002', 'Gato', '2021-01-20 00:00:00.000000', '2025-05-30 17:03:13.000000', 'Luna', 'Siamés', b'0', 6),
	(3, NULL, 'M003', 'Perro', '2019-07-10 00:00:00.000000', '2025-05-30 17:03:13.000000', 'Rocky', 'Bulldog', b'1', 7),
	(4, NULL, 'M004', 'Gato', '2022-03-05 00:00:00.000000', '2025-05-30 17:03:13.000000', 'Milo', 'Persa', b'1', 8),
	(5, NULL, 'M005', 'Perro', '2018-11-12 00:00:00.000000', '2025-05-30 17:03:13.000000', 'Bella', 'Golden Retriever', b'0', 8);

-- Volcando estructura para tabla veterinaria.pagos
CREATE TABLE IF NOT EXISTS `pagos` (
  `id_pago` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `metodo_pago` varchar(255) DEFAULT NULL,
  `monto` float DEFAULT NULL,
  PRIMARY KEY (`id_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria.pagos: ~5 rows (aproximadamente)
INSERT INTO `pagos` (`id_pago`, `fecha`, `metodo_pago`, `monto`) VALUES
	(1, '2025-05-30 17:03:13.000000', 'Tarjeta', 50),
	(2, '2025-05-30 17:03:13.000000', 'Efectivo', 30),
	(3, '2025-05-30 17:03:13.000000', 'Transferencia', 75),
	(4, '2025-05-30 17:03:13.000000', 'Tarjeta', 45),
	(5, '2025-05-30 17:03:13.000000', 'Efectivo', 60);

-- Volcando estructura para tabla veterinaria.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria.rol: ~3 rows (aproximadamente)
INSERT INTO `rol` (`id_rol`, `descripcion`, `rol`) VALUES
	(1, 'Administrador del sistema con todos los permisos', 'ADMINISTRADOR'),
	(2, 'Personal veterinario que atiende a los pacientes', 'VETERINARIO'),
	(3, 'Dueños de mascotas con permisos limitados', 'USUARIO');

-- Volcando estructura para tabla veterinaria.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `dni` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `fecha_alta` datetime(6) DEFAULT NULL,
  `fecha_nac` datetime(6) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `id_rol` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FK5ubh1vhgk6g42j7twprjlvmpu` (`id_rol`),
  CONSTRAINT `FK5ubh1vhgk6g42j7twprjlvmpu` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria.usuarios: ~12 rows (aproximadamente)
INSERT INTO `usuarios` (`id_usuario`, `dni`, `apellidos`, `contrasena`, `correo`, `fecha_alta`, `fecha_nac`, `telefono`, `user`, `id_rol`) VALUES
	(2, '87654321B', 'Martínez Sánchez', '1234', 'admin2@veterinaria.com', '2025-05-30 17:03:13.000000', '1985-05-20 00:00:00.000000', '600222333', 'admin2', 1),
	(3, '11223344C', 'Rodríguez Pérez', '1234', 'vet1@veterinaria.com', '2025-05-30 17:03:13.000000', '1990-07-10 00:00:00.000000', '600333444', 'vet1', 2),
	(4, '44332211D', 'Fernández Gómez', '1234', 'vet2@veterinaria.com', '2025-05-30 17:03:13.000000', '1988-03-25 00:00:00.000000', '600444555', 'vet2', 2),
	(5, '55667788E', 'López Ruiz', '1234', 'vet3@veterinaria.com', '2025-05-30 17:03:13.000000', '1992-11-30 00:00:00.000000', '600555666', 'vet3', 2),
	(6, '99887766F', 'González Martínez', '1234', 'cliente1@gmail.com', '2025-05-30 17:03:13.000000', '1995-02-14 00:00:00.000000', '600666777', 'cliente1', 3),
	(7, '66778899G', 'Sánchez Jiménez', '1234', 'cliente2@gmail.com', '2025-05-30 17:03:13.000000', '1987-09-18 00:00:00.000000', '600777888', 'cliente2', 3),
	(8, '33445566H', 'Pérez García', '1234', 'cliente3@gmail.com', '2025-05-30 17:03:13.000000', '1993-12-05 00:00:00.000000', '600888999', 'cliente3', 3),
	(9, '12345678A', 'Barragan Cortes', '1234', 'sdasdasd@gmail.com', '2025-05-30 17:03:13.000000', '1980-01-15 00:00:00.000000', '600111222', 'barros', 1),
	(10, '12345678A', 'pRUEBA', '1234', 'sdasdasd@gmail.com', '2025-05-30 17:03:13.000000', '1980-01-15 00:00:00.000000', '600111222', 'barros', 2),
	(11, '12345678A', 'pRUEBA', '1234', 'sdasdasd@gmail.com', '2025-05-30 17:03:13.000000', '1980-01-15 00:00:00.000000', '600111222', 'barros', 2),
	(12, '12345678A', 'García López 2', '1234', 'admin@veterinaria.com', '2025-05-30 17:03:13.000000', '1980-01-15 00:00:00.000000', '600111222', 'admin', 1),
	(13, '12345678A', 'García López2', '1234', 'admin@veterinaria.com', '2025-05-30 17:03:13.000000', '1980-01-15 00:00:00.000000', '600111222', 'admin', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
