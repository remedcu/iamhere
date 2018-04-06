-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 01, 2017 at 06:29 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `iamhere`
--

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE IF NOT EXISTS `registration` (
  `Username` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `latitude` varchar(50) DEFAULT NULL,
  `longitude` varchar(50) DEFAULT NULL,
  `key` int(50) NOT NULL DEFAULT '0' COMMENT 'Active or Not',
  `sandr` varchar(50) DEFAULT NULL COMMENT 'Sender or Receiver Name',
  PRIMARY KEY (`Username`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`Username`, `Email`, `Password`, `latitude`, `longitude`, `key`, `sandr`) VALUES
('aaa', 'aaa@aaa.com', 'aaa', '9.74384256', '76.56291336', 1, 'qaz'),
('asd', 'asd@asd.com', 'asd', '9.7439883', '76.56336597', 1, 'ggg'),
('dghk', 'dgjkl@gmail.com', 'dgjkll', NULL, NULL, 0, NULL),
('dhkk', 'sghk@gmail.com', 'hsfkk', NULL, NULL, 0, NULL),
('ggg', 'ggg@asd.com', 'asd', NULL, NULL, 1, 'asd'),
('qaz', 'qaz@qaz.com', 'qaz', '11.0', '78.0', 1, 'aaa'),
('qwe', 'qwe@qwe.com', 'qwe', NULL, NULL, 0, NULL);
