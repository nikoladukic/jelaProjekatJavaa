/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dostava` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `dostava`;



DROP TABLE IF EXISTS `MenadzerRestorana`;

CREATE TABLE `MenadzerRestorana` (
  `MenadzerID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(30) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`MenadzerID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `MenadzerRestorana` VALUES 
(1,'Ana','Cvetkovic','ana','ana123');



DROP TABLE IF EXISTS `Klijent`;

CREATE TABLE `Klijent` (
  `KlijentID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeKlijenta` VARCHAR(30) NOT NULL,
  `PrezimeKlijenta` VARCHAR(30) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `Telefon` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`KlijentID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Klijent` VALUES 
(1,'Katarina', 'Tanaskovic', 'kaca@gmail.com', '0631231111'),
(2,'Tamara', 'Mrvosevic', 'tamara@gmail.com', '0654642334'),
(3,'Milica', 'Maslarevic', 'milica@gmail.com', '0644343253');



DROP TABLE IF EXISTS `Kurir`;

CREATE TABLE `Kurir` (
  `KurirID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeKurira` VARCHAR(30) NOT NULL,
  `PrezimeKurira` VARCHAR(30) NOT NULL,
  `Kontakt` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`KurirID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Kurir` VALUES 
(1,'Ilija', 'Mantovic', '0631231234'),
(2,'Jovan', 'Ilic', '0654645434'),
(3,'Branko', 'Copic', '0641235153');


DROP TABLE IF EXISTS `Jelo`;

CREATE TABLE `Jelo` (
  `JeloID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivJela` VARCHAR(30) NOT NULL,
  `Cena` DECIMAL(10,2) NOT NULL,
  `Opis` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`JeloID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Jelo` VALUES 
(1,'Pesto pasta sa piletinom', 800, 'Izuzetno ukusna pesto pasta sa piletinom.'),
(2,'Becka snicla', 1000, 'Domaca becka.'),
(3,'Pasulj sa kobasicom', 750, 'Tetovski pasulj sa domacom kobasicom iz mesare Jokic.');


DROP TABLE IF EXISTS `Narudzbina`;

CREATE TABLE `Narudzbina` (
  `NarudzbinaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DatumVreme` DATETIME NOT NULL,
  `UkupnaCena` DECIMAL(10,2) NOT NULL,
  `KlijentID` BIGINT(10) UNSIGNED NOT NULL,
  `KurirID` BIGINT(10) UNSIGNED NOT NULL,
  `MenadzerID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`NarudzbinaID`),
  CONSTRAINT `fk_kl_id` FOREIGN KEY (`KlijentID`) REFERENCES `Klijent` (`KlijentID`),
  CONSTRAINT `fk_kurir_id` FOREIGN KEY (`KurirID`) REFERENCES `Kurir` (`KurirID`),
  CONSTRAINT `fk_men_id` FOREIGN KEY (`MenadzerID`) REFERENCES `MenadzerRestorana` (`MenadzerID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `Narudzbina` VALUES 
(1,'2023-08-05 10:00:33', 3850, 1, 1, 1);



DROP TABLE IF EXISTS `StavkaNarudzbine`;

CREATE TABLE `StavkaNarudzbine` (
  `NarudzbinaID` BIGINT(10) UNSIGNED NOT NULL,
  `RbStavke` INT(7) NOT NULL,
  `Kolicina` INT(7) NOT NULL,
  `CenaStavke` DECIMAL(10,2) NOT NULL,
  `JeloID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`NarudzbinaID`,`RbStavke`),
  CONSTRAINT `fk_narudzbina_id` FOREIGN KEY (`NarudzbinaID`) REFERENCES `Narudzbina` (`NarudzbinaID`) ON DELETE CASCADE,
  CONSTRAINT `fk_jelo_id` FOREIGN KEY (`JeloID`) REFERENCES `Jelo` (`JeloID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `StavkaNarudzbine` VALUES 
(1,1,2,1600,1),
(1,2,3,2250,3);




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
