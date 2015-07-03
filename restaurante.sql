/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.17 : Database - restaurante
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`restaurante` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `restaurante`;

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_id` int(11) DEFAULT NULL,
  `waiter_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_table_id_x` (`table_id`),
  KEY `fx_waiter_id_x` (`waiter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `orders` */

insert  into `orders`(`id`,`table_id`,`waiter_id`,`created_at`,`updated_at`) values (1,1,1,'2015-07-03 18:03:27','2015-07-03 18:03:27');

/*Table structure for table `orders_product` */

DROP TABLE IF EXISTS `orders_product`;

CREATE TABLE `orders_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fx_orders_id_x` (`orders_id`),
  KEY `fx_product_id_x` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `orders_product` */

insert  into `orders_product`(`id`,`orders_id`,`product_id`,`created_at`) values (1,1,1,'2015-07-03 18:03:28');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `product` */

insert  into `product`(`id`,`code`,`name`,`price`,`created_at`,`updated_at`) values (1,1,'Produto #12',100.00,'2015-07-03 10:42:45','2015-07-03 11:08:44'),(2,2,'Produto #2',100.00,'2015-07-03 11:09:05',NULL);

/*Table structure for table `table` */

DROP TABLE IF EXISTS `table`;

CREATE TABLE `table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table` */

insert  into `table`(`id`,`number`,`capacity`,`status`,`created_at`,`updated_at`) values (1,1,2,0,'2015-07-02 23:59:48','2015-07-03 18:11:05'),(2,2,5,0,'2015-07-02 23:59:56','2015-07-03 17:55:41');

/*Table structure for table `waiter` */

DROP TABLE IF EXISTS `waiter`;

CREATE TABLE `waiter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpf` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salary` double(10,2) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `waiter` */

insert  into `waiter`(`id`,`name`,`cpf`,`salary`,`created_at`,`updated_at`) values (1,'Felipe Pieretti Umpierre','02651417025',250.00,'2015-07-03 00:32:42','2015-07-03 10:24:28');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
