-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema javaweb-netgifx
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `javaweb-netgifx` ;

-- -----------------------------------------------------
-- Schema javaweb-netgifx
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `javaweb-netgifx` DEFAULT CHARACTER SET latin1 ;
USE `javaweb-netgifx` ;

-- -----------------------------------------------------
-- Table `javaweb-netgifx`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javaweb-netgifx`.`categoria` ;

CREATE TABLE IF NOT EXISTS `javaweb-netgifx`.`categoria` (
  `IDCATEGORIA` INT(11) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`IDCATEGORIA`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `javaweb-netgifx`.`gif`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javaweb-netgifx`.`gif` ;

CREATE TABLE IF NOT EXISTS `javaweb-netgifx`.`gif` (
  `IDGIF` INT(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` VARCHAR(100) NOT NULL,
  `IDCATEGORIA` INT(11) NOT NULL,
  `CLASS_ETARIA` INT(11) NOT NULL,
  `URL` VARCHAR(255) NOT NULL,
  `IDIOMA` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`IDGIF`),
  INDEX `IDCATEGORIA` (`IDCATEGORIA` ASC),
  CONSTRAINT `IDCATEGORIA`
    FOREIGN KEY (`IDCATEGORIA`)
    REFERENCES `javaweb-netgifx`.`categoria` (`IDCATEGORIA`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `javaweb-netgifx`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javaweb-netgifx`.`usuario` ;

CREATE TABLE IF NOT EXISTS `javaweb-netgifx`.`usuario` (
  `IDUSUARIO` INT(11) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(100) NOT NULL,
  `LOGIN` VARCHAR(100) NOT NULL,
  `SENHA` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`IDUSUARIO`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;

INSERT INTO `usuario` (`IDUSUARIO`,`NOME`,`LOGIN`,`SENHA`) VALUES (1,'Administrador','admin','admin');
INSERT INTO `usuario` (`IDUSUARIO`,`NOME`,`LOGIN`,`SENHA`) VALUES (2,'Fiap','fiap','fiap');

INSERT INTO `categoria` (`IDCATEGORIA`,`NOME`) VALUES (1,'Humor');
INSERT INTO `categoria` (`IDCATEGORIA`,`NOME`) VALUES (2,'Terror');
INSERT INTO `categoria` (`IDCATEGORIA`,`NOME`) VALUES (3,'Meme');
INSERT INTO `categoria` (`IDCATEGORIA`,`NOME`) VALUES (4,'Famosos');
INSERT INTO `categoria` (`IDCATEGORIA`,`NOME`) VALUES (5,'Reações Engraçadas');
INSERT INTO `categoria` (`IDCATEGORIA`,`NOME`) VALUES (6,'Dança');
INSERT INTO `categoria` (`IDCATEGORIA`,`NOME`) VALUES (7,'Susto');
INSERT INTO `categoria` (`IDCATEGORIA`,`NOME`) VALUES (8,'Entretenimento');

INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (1,'Patrik Chorão',1,8,'https://giphy.com/embed/OPU6wzx8JrHna','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (2,'Guess What',8,10,'https://giphy.com/embed/xUOxeZmRNvUPHIpVrW','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (3,'Happy Birthday',8,10,'https://giphy.com/embed/3ohs80Zbt7mWiPi3NS','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (4,'Trump Bolado',4,12,'https://giphy.com/embed/xUOxfit4XTZRh37HMs','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (5,'Neto Bolado',4,18,'https://giphy.com/embed/3oxHQo2gzl8z59Rf7a','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (6,'Sponge Bob Strong',2,16,'https://giphy.com/embed/D7z8JfNANqahW','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (7,'Meryl Streep',6,10,'https://giphy.com/embed/14hWUIZK0rKFS8','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (8,'React',5,8,'https://giphy.com/embed/xUOxf9Xl3DBZf3I8lq','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (9,'Happy Dance',6,8,'https://giphy.com/embed/3o7bu5LMqvPLGX0WTm','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (10,'What a Day',4,14,'https://giphy.com/embed/3o7aCPJG89x9YBV70s','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (11,'Lonzo Ball',4,14,'https://giphy.com/embed/xT9IgskzA2SK3i9Emk','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (12,'Stephen Curry',4,18,'https://giphy.com/embed/3oEjHZKRgiZXYmVVbq','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (13,'Steph Dance',6,18,'https://giphy.com/embed/DiMnfScJ4ZjoI','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (14,'Samanta Terror',2,8,'https://giphy.com/embed/28aGE5xerXkbK','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (15,'Freddy',2,12,'https://giphy.com/embed/VXUpjaExrrsMU','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (16,'Here\'s Johnny',2,18,'https://giphy.com/embed/QSToNb4xXf51m','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (17,'Scared',2,16,'https://giphy.com/embed/3ohhwyZXlxFqccKi3K','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (18,'Spack Jarrow',4,14,'https://giphy.com/embed/1bYaHhGtueIqQ','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (19,'Jack Bolado',5,12,'https://giphy.com/embed/kaAe7C4ANnLH2','Inglês');
INSERT INTO `gif` (`IDGIF`,`DESCRICAO`,`IDCATEGORIA`,`CLASS_ETARIA`,`URL`,`IDIOMA`) VALUES (20,'Dracarys',3,18,'https://giphy.com/embed/ajyUbP3kOChRS','Inglês');
