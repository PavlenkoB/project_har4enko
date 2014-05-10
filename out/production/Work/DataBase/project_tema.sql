SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `project_tema`
--

-- --------------------------------------------------------

--
-- Table structure for table `frame`
--

CREATE TABLE IF NOT EXISTS `frame` (
  `ID` int(10) NOT NULL,
  `Name` text NOT NULL,
  `UseType` int(10) NOT NULL,
  `Character` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Use Type` (`UseType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `layer`
--

CREATE TABLE IF NOT EXISTS `layer` (
  `Id` int(10) NOT NULL,
  `Name` text NOT NULL,
  `frame` int(11) NOT NULL,
  `Character` text NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `frame` (`frame`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `patern`
--

CREATE TABLE IF NOT EXISTS `patern` (
  `ID` int(10) NOT NULL,
  `Name` char(50) NOT NULL,
  `Layer` int(10) NOT NULL,
  `Sequrity` char(50) NOT NULL,
  `Capasity` char(50) NOT NULL,
  `Character` text,
  PRIMARY KEY (`ID`),
  KEY `Layer` (`Layer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `usetype`
--

CREATE TABLE IF NOT EXISTS `usetype` (
  `ID` int(10) NOT NULL,
  `Name` int(10) NOT NULL,
  `Character` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `frame`
--
ALTER TABLE `frame`
  ADD CONSTRAINT `FK_frame_use type` FOREIGN KEY (`UseType`) REFERENCES `usetype` (`ID`);

--
-- Constraints for table `layer`
--
ALTER TABLE `layer`
  ADD CONSTRAINT `FK_layer_frame` FOREIGN KEY (`frame`) REFERENCES `frame` (`ID`),
  ADD CONSTRAINT `FK_layer_patern` FOREIGN KEY (`Id`) REFERENCES `patern` (`Layer`);

--
-- Constraints for table `patern`
--
ALTER TABLE `patern`
  ADD CONSTRAINT `FK_patern_layer` FOREIGN KEY (`Layer`) REFERENCES `layer` (`Id`);

--
-- Constraints for table `usetype`
--
ALTER TABLE `usetype`
  ADD CONSTRAINT `FK_use type_frame` FOREIGN KEY (`ID`) REFERENCES `frame` (`UseType`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
