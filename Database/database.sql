/*
base de datos
CREATE DATABASE usuarios;
*/

/*
tablas de la base de datos
*/
CREATE TABLE `usuario` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`password` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`fecha` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;

CREATE TABLE `clientes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`direccion` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`telefono` INT(11) NULL DEFAULT NULL,
	`run` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
