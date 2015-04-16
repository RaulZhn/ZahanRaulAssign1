-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Gazda: 127.0.0.1
-- Timp de generare: 09 Apr 2015 la 19:50
-- Versiune server: 5.5.32
-- Versiune PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Bază de date: `bank`
--
CREATE DATABASE IF NOT EXISTS `bank` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bank`;

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `aid` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `amount` int(11) NOT NULL,
  `creationDate` date NOT NULL,
  `uid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `account`
--

INSERT INTO `account` (`aid`, `type`, `amount`, `creationDate`, `uid`, `cid`) VALUES
(1, 'deposit', 250, '2015-04-09', 1, 1),
(2, 'deposit', 50, '2015-04-09', 1, 1),
(3, 'credit', 2000, '2015-04-02', 2, 2);

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `cid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `BI` varchar(8) NOT NULL,
  `CNP` int(13) NOT NULL,
  `adresa` varchar(30) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `client`
--

INSERT INTO `client` (`cid`, `name`, `BI`, `CNP`, `adresa`) VALUES
(1, 'Ionut Ion', 'kx721712', 31231, 'turda'),
(2, 'Andrei Andrei', 'kx812232', 12312, 'Tureada'),
(3, 'Indrei Andrei', 'kx129321', 12312, 'Ceva'),
(4, 'Ion Ionut', 'kx83423', 13213, 'Turda'),
(5, 'Valer', 'kx832821', 12312, 'Turda'),
(6, 'adsadas', 'kx123432', 12312, 'dasdas');

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(11) NOT NULL,
  `uuser` varchar(20) NOT NULL,
  `upassword` varchar(10) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `uaddres` varchar(20) NOT NULL,
  `ucnp` int(13) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Salvarea datelor din tabel `user`
--

INSERT INTO `user` (`uid`, `uuser`, `upassword`, `uname`, `uaddres`, `ucnp`) VALUES
(1, 'raul', 'raul', 'zahan raul', 'Turda', 1993),
(2, 'Ion', 'feri', 'Moldovan', 'Buda Mare', 12311),
(3, 'hshshshsh', 'dasdasd', 'dasdasdas', 'dasdasd', 123212);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
