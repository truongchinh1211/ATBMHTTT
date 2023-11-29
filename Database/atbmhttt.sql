-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2023 at 03:34 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atbmhttt`
--
CREATE DATABASE IF NOT EXISTS `atbmhttt` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `atbmhttt`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Account_ID` char(8) NOT NULL,
  `UserName` char(30) NOT NULL,
  `Password` char(255) NOT NULL,
  `decentralize_id` char(50) DEFAULT NULL,
  `Staff_ID` char(8) NOT NULL,
  `IsDeleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Account_ID`, `UserName`, `Password`, `decentralize_id`, `Staff_ID`, `IsDeleted`) VALUES
('A1', '1', '1', 'DC01', 'AA01', 0);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `Bill_ID` char(11) NOT NULL,
  `Date` datetime NOT NULL,
  `TotalValue` double NOT NULL,
  `PurchasePoint` int(11) NOT NULL,
  `ReceivedMoney` double NOT NULL,
  `ExcessMoney` double NOT NULL,
  `Staff_id` char(8) NOT NULL,
  `Customer_id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `Bill_id` char(8) NOT NULL,
  `Product_id` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `TotalValue` double NOT NULL,
  `percent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `Category_ID` char(8) NOT NULL,
  `Category_Name` char(40) NOT NULL,
  `Business_Status` char(8) NOT NULL,
  `IsDeleted` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_id` char(8) NOT NULL,
  `Customer_name` char(40) DEFAULT NULL,
  `YearOfBirth` year(4) DEFAULT NULL,
  `phoneNum` char(10) DEFAULT NULL,
  `Purchase_Time` int(11) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `decentralization`
--

CREATE TABLE `decentralization` (
  `decentralize_id` varchar(10) NOT NULL,
  `decentralize_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `decentralization`
--

INSERT INTO `decentralization` (`decentralize_id`, `decentralize_name`) VALUES
('DC01', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `decentralization_detail`
--

CREATE TABLE `decentralization_detail` (
  `decentralize_id` varchar(10) NOT NULL,
  `isSale` int(11) NOT NULL,
  `isRecept` int(11) NOT NULL,
  `isProduct` int(11) NOT NULL,
  `isCategory` int(11) NOT NULL,
  `isBill` int(11) NOT NULL,
  `isDiscount` int(11) NOT NULL,
  `isCustomer` int(11) NOT NULL,
  `isStaff` int(11) NOT NULL,
  `isAccount` int(11) NOT NULL,
  `isDecentralize` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `decentralization_detail`
--

INSERT INTO `decentralization_detail` (`decentralize_id`, `isSale`, `isRecept`, `isProduct`, `isCategory`, `isBill`, `isDiscount`, `isCustomer`, `isStaff`, `isAccount`, `isDecentralize`) VALUES
('DC01', 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

CREATE TABLE `discount` (
  `discount_Id` char(8) NOT NULL,
  `discount_Percent` int(3) NOT NULL,
  `start_Time` varchar(255) NOT NULL,
  `end_Time` varchar(255) NOT NULL,
  `status` int(1) NOT NULL,
  `isDeleted` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `discount_detail`
--

CREATE TABLE `discount_detail` (
  `discount_Id` char(8) NOT NULL,
  `product_Id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_ID` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Product_Name` char(40) NOT NULL,
  `UnitPrice` double NOT NULL,
  `Quantity` varchar(30) NOT NULL,
  `Image` varchar(100) NOT NULL,
  `Category_ID` char(8) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  `BusinessStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `received_note`
--

CREATE TABLE `received_note` (
  `Received_Note_ID` char(8) NOT NULL,
  `Date` datetime NOT NULL DEFAULT current_timestamp(),
  `Total_Value` double NOT NULL,
  `Tax_Value` double NOT NULL,
  `Final_Value` double NOT NULL,
  `Supplier` char(40) NOT NULL,
  `Staff_ID` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `received_note_detail`
--

CREATE TABLE `received_note_detail` (
  `Received_Note_ID` char(8) NOT NULL,
  `Product_ID` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `UnitPrice` double NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `Staff_id` char(12) NOT NULL,
  `Full_Name` char(40) NOT NULL,
  `Year_Of_Birth` year(4) NOT NULL,
  `Gender` char(8) NOT NULL,
  `HomeTown` varchar(255) NOT NULL,
  `Phone_Num` varchar(255) NOT NULL,
  `Salary` varchar(255) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`Staff_id`, `Full_Name`, `Year_Of_Birth`, `Gender`, `HomeTown`, `Phone_Num`, `Salary`, `IsDeleted`) VALUES
('AA01', 'Nguyễn Ngọc Trường Chinh', 2001, 'Nam', 'yLyvcJJp73VjOZUiNu2iFw==', 'w4jvzmZN4UBBu676baD0ug==', 'hlfUjcTYajeuaGsZv+qgsQ==', 0),
('AA02', 'Nguyễn Test', 2001, 'tp.hcm', 'CRCwe/XAOiDctGKIi9Wx2A==', 'g8eOGRZT3JjN99ecH42ZIw==', 'hlfUjcTYajeuaGsZv+qgsQ==', 1),
('AA03', 'Nguyễn Ngọc', 2001, 'tp.hcm', '7SPwotpNjX5DhZSfw39BGQ==', 'xfJuysl0NkPDnQGTxDQyWA==', 'avWyLo9Za2rgxH02TqS8Cg==', 1),
('AA04', 'Nguyễn', 2001, 'lsjdkgld', 'CRCwe/XAOiDctGKIi9Wx2A==', 'vItqyOU0b6u2OoufWCVWIg==', 'avWyLo9Za2rgxH02TqS8Cg==', 1),
('AA05', 'Nguyễn', 2004, 'Nam', 'iCV67kTo2f2Cfe98jvtunA==', 'vItqyOU0b6u2OoufWCVWIg==', 'E5YLfQ1qB26OIhZVfrBVKQ==', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Account_ID`),
  ADD KEY `Account_FK_1` (`Staff_ID`),
  ADD KEY `Account_FK_2` (`decentralize_id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Bill_ID`),
  ADD KEY `Bill_FK_1` (`Staff_id`),
  ADD KEY `Bill_FK_2` (`Customer_id`);

--
-- Indexes for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`Bill_id`,`Product_id`,`Size`),
  ADD KEY `BillDetail_FK_2` (`Product_id`,`Size`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`Category_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `decentralization`
--
ALTER TABLE `decentralization`
  ADD PRIMARY KEY (`decentralize_id`);

--
-- Indexes for table `decentralization_detail`
--
ALTER TABLE `decentralization_detail`
  ADD PRIMARY KEY (`decentralize_id`),
  ADD KEY `decentralize_id` (`decentralize_id`);

--
-- Indexes for table `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_Id`);

--
-- Indexes for table `discount_detail`
--
ALTER TABLE `discount_detail`
  ADD PRIMARY KEY (`discount_Id`,`product_Id`),
  ADD KEY `product_Id` (`product_Id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_ID`,`Size`),
  ADD KEY `Catagory_FK_1` (`Category_ID`);

--
-- Indexes for table `received_note`
--
ALTER TABLE `received_note`
  ADD PRIMARY KEY (`Received_Note_ID`),
  ADD KEY `Staff_ID` (`Staff_ID`);

--
-- Indexes for table `received_note_detail`
--
ALTER TABLE `received_note_detail`
  ADD PRIMARY KEY (`Received_Note_ID`,`Product_ID`,`Size`),
  ADD KEY `ReceivedNote_Detail_FK_2` (`Product_ID`,`Size`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Staff_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `Account_FK_1` FOREIGN KEY (`Staff_ID`) REFERENCES `staff` (`Staff_id`),
  ADD CONSTRAINT `Account_FK_2` FOREIGN KEY (`decentralize_id`) REFERENCES `decentralization` (`decentralize_id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `Bill_FK_1` FOREIGN KEY (`Staff_id`) REFERENCES `staff` (`Staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Bill_FK_2` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD CONSTRAINT `BillDetail_FK_1` FOREIGN KEY (`Bill_id`) REFERENCES `bill` (`Bill_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BillDetail_FK_2` FOREIGN KEY (`Product_id`,`Size`) REFERENCES `product` (`Product_ID`, `Size`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `decentralization_detail`
--
ALTER TABLE `decentralization_detail`
  ADD CONSTRAINT `decentralize_FK_1` FOREIGN KEY (`decentralize_id`) REFERENCES `decentralization` (`decentralize_id`);

--
-- Constraints for table `discount_detail`
--
ALTER TABLE `discount_detail`
  ADD CONSTRAINT `discount_detail_ibfk_1` FOREIGN KEY (`discount_Id`) REFERENCES `discount` (`discount_Id`),
  ADD CONSTRAINT `discount_detail_ibfk_2` FOREIGN KEY (`product_Id`) REFERENCES `product` (`Product_ID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `Catagory_FK_1` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`Category_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `received_note`
--
ALTER TABLE `received_note`
  ADD CONSTRAINT `Product_FK_1` FOREIGN KEY (`Staff_ID`) REFERENCES `staff` (`Staff_id`) ON UPDATE CASCADE;

--
-- Constraints for table `received_note_detail`
--
ALTER TABLE `received_note_detail`
  ADD CONSTRAINT `ReceivedNote_Detail_FK_2` FOREIGN KEY (`Product_ID`,`Size`) REFERENCES `product` (`Product_ID`, `Size`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Received_Note_FK_1` FOREIGN KEY (`Received_Note_ID`) REFERENCES `received_note` (`Received_Note_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
