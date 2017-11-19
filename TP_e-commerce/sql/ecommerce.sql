-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 19 nov. 2017 à 16:33
-- Version du serveur :  5.7.19-log
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecommerce`
--

-- --------------------------------------------------------

--
-- Structure de la table `caddy`
--

DROP TABLE IF EXISTS `caddy`;
CREATE TABLE IF NOT EXISTS `caddy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `total_price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `cp` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `caddy_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK35ama8adn81ftd0ih4pj8wals` (`caddy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dead` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Structure de la table `product_caddy`
--

DROP TABLE IF EXISTS `product_caddy`;
CREATE TABLE IF NOT EXISTS `product_caddy` (
  `product_id` bigint(20) NOT NULL,
  `caddy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`product_id`,`caddy_id`),
  KEY `FKomyw7t0586pg54boe8vtdlvvp` (`caddy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FK_Customer_Caddy` FOREIGN KEY (`caddy_id`) REFERENCES `caddy` (`id`);

--
-- Contraintes pour la table `product_caddy`
--
ALTER TABLE `product_caddy`
  ADD CONSTRAINT `FK_ProductCaddy_Product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FK_ProductCaddy_Caddy` FOREIGN KEY (`caddy_id`) REFERENCES `caddy` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
