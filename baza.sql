/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - projekat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projekat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `projekat`;

/*Table structure for table `clanstvo` */

DROP TABLE IF EXISTS `clanstvo`;

CREATE TABLE `clanstvo` (
  `IDTeretane` int(11) NOT NULL,
  `IDKorisnika` int(11) NOT NULL,
  `datumOd` date NOT NULL,
  `datumDo` date NOT NULL,
  `cena` int(11) NOT NULL,
  PRIMARY KEY (`IDTeretane`,`IDKorisnika`),
  KEY `clanstvo_ibfk_2` (`IDKorisnika`),
  CONSTRAINT `clanstvo_ibfk_1` FOREIGN KEY (`IDTeretane`) REFERENCES `teretana` (`IDTeretane`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `clanstvo_ibfk_2` FOREIGN KEY (`IDKorisnika`) REFERENCES `korisnik` (`IDKorisnika`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `clanstvo` */

insert  into `clanstvo`(`IDTeretane`,`IDKorisnika`,`datumOd`,`datumDo`,`cena`) values 
(1,1,'2024-01-08','2024-02-08',2500),
(2,1,'2024-06-05','2024-06-06',5879),
(2,3,'2024-01-02','2024-02-02',3000);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `IDKorisnika` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `mejl` varchar(40) NOT NULL,
  `lozinka` varchar(30) NOT NULL,
  PRIMARY KEY (`IDKorisnika`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`IDKorisnika`,`ime`,`prezime`,`mejl`,`lozinka`) values 
(1,'Filip','Trifunovic','filip@gmail.com','filip'),
(2,'Admin','Admin','admin@gmail.com','admin'),
(3,'Marko','Markovic','marko@gmail.com','marko'),
(6,'Petar','Petrovic','petar@gmail.com','petar');

/*Table structure for table `sprava` */

DROP TABLE IF EXISTS `sprava`;

CREATE TABLE `sprava` (
  `IDSprave` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  `maxTezina` double NOT NULL,
  PRIMARY KEY (`IDSprave`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `sprava` */

insert  into `sprava`(`IDSprave`,`naziv`,`maxTezina`) values 
(6,'lat masina',100),
(7,'leg press',400),
(8,'bench klupa',300);

/*Table structure for table `teretana` */

DROP TABLE IF EXISTS `teretana`;

CREATE TABLE `teretana` (
  `IDTeretane` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  `kontakt` varchar(30) NOT NULL,
  `mesto` varchar(30) NOT NULL,
  `adresa` varchar(100) NOT NULL,
  PRIMARY KEY (`IDTeretane`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `teretana` */

insert  into `teretana`(`IDTeretane`,`naziv`,`kontakt`,`mesto`,`adresa`) values 
(1,'Ahilej','0635587433','Beograd','Gostivarska 30'),
(2,'Kocovic','0642365872','Beograd','Visegradska 12'),
(3,'Mega gym','0667783566','Beograd','Cara Dusana 65');

/*Table structure for table `trening` */

DROP TABLE IF EXISTS `trening`;

CREATE TABLE `trening` (
  `IDTreninga` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  `trajanje` int(11) NOT NULL,
  `beleska` varchar(100) NOT NULL,
  `IDKorisnika` int(11) NOT NULL,
  PRIMARY KEY (`IDTreninga`),
  KEY `IDKorisnika` (`IDKorisnika`),
  CONSTRAINT `trening_ibfk_1` FOREIGN KEY (`IDKorisnika`) REFERENCES `korisnik` (`IDKorisnika`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `trening` */

insert  into `trening`(`IDTreninga`,`naziv`,`trajanje`,`beleska`,`IDKorisnika`) values 
(3,'Pull',65,'ledja i biceps',1),
(4,'Push',70,'gudi i triceps',3),
(6,'Legsss',155,'noge++',1);

/*Table structure for table `vezba` */

DROP TABLE IF EXISTS `vezba`;

CREATE TABLE `vezba` (
  `IDVezbe` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) DEFAULT NULL,
  `ponavljanja` int(11) DEFAULT NULL,
  `tezina` int(11) DEFAULT NULL,
  `IDSprave` int(11) DEFAULT NULL,
  `IDTreninga` int(11) NOT NULL,
  PRIMARY KEY (`IDVezbe`,`IDTreninga`),
  KEY `vezba_ibfk_1` (`IDSprave`),
  KEY `vezba_ibfk_2` (`IDTreninga`),
  CONSTRAINT `vezba_ibfk_1` FOREIGN KEY (`IDSprave`) REFERENCES `sprava` (`IDSprave`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vezba_ibfk_2` FOREIGN KEY (`IDTreninga`) REFERENCES `trening` (`IDTreninga`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `vezba` */

insert  into `vezba`(`IDVezbe`,`naziv`,`ponavljanja`,`tezina`,`IDSprave`,`IDTreninga`) values 
(3,'Lat pulldown',12,85,6,3),
(5,'bbbaaa',22,22,6,3),
(6,'lll',5,5,8,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
