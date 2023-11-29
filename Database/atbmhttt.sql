-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 29, 2023 lúc 11:49 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `atbmhttt`
--
CREATE DATABASE IF NOT EXISTS `atbmhttt` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `atbmhttt`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `Account_ID` char(8) NOT NULL,
  `UserName` char(30) NOT NULL,
  `Password` char(255) NOT NULL,
  `decentralize_id` char(50) DEFAULT NULL,
  `Staff_ID` char(8) NOT NULL,
  `IsDeleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`Account_ID`, `UserName`, `Password`, `decentralize_id`, `Staff_ID`, `IsDeleted`) VALUES
('A1', '1', '1', 'DC01', 'AA01', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `Bill_ID` char(11) NOT NULL,
  `Date` varchar(255) NOT NULL,
  `TotalValue` varchar(255) NOT NULL,
  `ReceivedMoney` varchar(255) NOT NULL,
  `ExcessMoney` varchar(255) NOT NULL,
  `Staff_id` char(8) NOT NULL,
  `Customer_id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`Bill_ID`, `Date`, `TotalValue`, `ReceivedMoney`, `ExcessMoney`, `Staff_id`, `Customer_id`) VALUES
('B1', 'AmPhBJoWbWaORBjU6IcslAm/QoK9FtETYIzfZ6ADJhg=', 'K4BzguQuWL+rCYYI/sobtA==', 'WMqMa/YNb5rkIeI7GO2umw==', 'pgrrgwMzGUb5l3R2ZFctDQ==', 'AA01', 'C1'),
('B2', '7xoseWQjgoje4doGqjKe2stYEL0xRFhjAMpNo4IiXXo=', 'K4BzguQuWL+rCYYI/sobtA==', 'WMqMa/YNb5rkIeI7GO2umw==', 'pgrrgwMzGUb5l3R2ZFctDQ==', 'AA01', 'C1'),
('B3', 'boZJGdaE3rvzMgOPDNmyS19hck3SHWCeQ2z0W1e4CHM=', 'K4BzguQuWL+rCYYI/sobtA==', 'WMqMa/YNb5rkIeI7GO2umw==', 'pgrrgwMzGUb5l3R2ZFctDQ==', 'AA01', 'C1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill_detail`
--

CREATE TABLE `bill_detail` (
  `Bill_id` char(8) NOT NULL,
  `Product_id` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `Quantity` varchar(255) NOT NULL,
  `TotalValue` varchar(255) NOT NULL,
  `percent` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bill_detail`
--

INSERT INTO `bill_detail` (`Bill_id`, `Product_id`, `Size`, `Quantity`, `TotalValue`, `percent`) VALUES
('B1', 'P02', '1 con', 'GXB6A7qxBcYDwvO6/D42ww==', 'K4BzguQuWL+rCYYI/sobtA==', 'VyttXX9O/Qp9ugZH+NUQEw=='),
('B2', 'P02', '1 con', 'GXB6A7qxBcYDwvO6/D42ww==', 'K4BzguQuWL+rCYYI/sobtA==', 'VyttXX9O/Qp9ugZH+NUQEw=='),
('B3', 'P02', '1 con', 'GXB6A7qxBcYDwvO6/D42ww==', 'K4BzguQuWL+rCYYI/sobtA==', 'VyttXX9O/Qp9ugZH+NUQEw==');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `Category_ID` char(8) NOT NULL,
  `Category_Name` char(40) NOT NULL,
  `Business_Status` char(8) NOT NULL,
  `IsDeleted` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`Category_ID`, `Category_Name`, `Business_Status`, `IsDeleted`) VALUES
('CT0', 'Hamburger', 'On', 0),
('CT1', 'Gà', 'On', 0),
('CT2', 'Cơm', 'On', 0),
('CT3', 'pizza', 'On', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `Customer_id` char(8) NOT NULL,
  `Customer_name` varchar(255) DEFAULT NULL,
  `YearOfBirth` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(255) DEFAULT NULL,
  `Purchase_Time` varchar(255) DEFAULT '0',
  `IsDeleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`Customer_id`, `Customer_name`, `YearOfBirth`, `phoneNum`, `Purchase_Time`, `IsDeleted`) VALUES
('C1', 'w6Cfy19ejrOSkW3NkazDfOeduDNzhrmgTdpglJOLc9M=', 'Dw+Wz+37wxCQ5qRBhlAatA==', 'w4jvzmZN4UBBu676baD0ug==', '5B4iGXdx+qTpSHSKcw75wA==', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `decentralization`
--

CREATE TABLE `decentralization` (
  `decentralize_id` varchar(10) NOT NULL,
  `decentralize_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `decentralization`
--

INSERT INTO `decentralization` (`decentralize_id`, `decentralize_name`) VALUES
('DC01', 'Manager');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `decentralization_detail`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `decentralization_detail`
--

INSERT INTO `decentralization_detail` (`decentralize_id`, `isSale`, `isRecept`, `isProduct`, `isCategory`, `isBill`, `isDiscount`, `isCustomer`, `isStaff`, `isAccount`, `isDecentralize`) VALUES
('DC01', 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `discount`
--

CREATE TABLE `discount` (
  `discount_Id` char(8) NOT NULL,
  `discount_Percent` int(3) NOT NULL,
  `start_Time` varchar(255) NOT NULL,
  `end_Time` varchar(255) NOT NULL,
  `status` int(1) NOT NULL,
  `isDeleted` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `discount_detail`
--

CREATE TABLE `discount_detail` (
  `discount_Id` char(8) NOT NULL,
  `product_Id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`Product_ID`, `Size`, `Product_Name`, `UnitPrice`, `Quantity`, `Image`, `Category_ID`, `IsDeleted`, `BusinessStatus`) VALUES
('P01', '3.5 oz', 'Hamburger gà sốt BBQ', 31000, 'RdSMNtZPAxwi27XhWL7i4w==', 'src/Img/HBG.jpg', 'CT0', 0, 1),
('P01', '4 oz', 'Hamburger gà sốt BBQ', 40000, 'E5YLfQ1qB26OIhZVfrBVKQ==', 'src/Img/HBG.jpg', 'CT0', 0, 1),
('P02', '1 con', 'Gà nướng muối ớt', 130000, 'XmzSJKIhVY0TQKvKbSyaIg==', 'src/Img/chicken_chilliSalt.jpg', 'CT1', 0, 1),
('P02', '1/2 con', 'Gà nướng muối ớt', 70000, 'OEU0DWn9bPxRj0NV5sQ73Q==', 'src/Img/chicken_chilliSalt.jpg', 'CT1', 0, 1),
('P03', 'Lớn', 'Cơm xèo gà mắm tỏi', 50000, 'Wh4LrmIzCPPA2jQQVhXPZQ==', 'src/Img/comXeo_garlicChicken.jpeg', 'CT2', 0, 1),
('P03', 'Vừa', 'Cơm xèo gà mắm tỏi', 40000, 'Wh4LrmIzCPPA2jQQVhXPZQ==', 'src/Img/comXeo_garlicChicken.jpeg', 'CT2', 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `received_note`
--

CREATE TABLE `received_note` (
  `Received_Note_ID` char(8) NOT NULL,
  `Date` varchar(255) NOT NULL,
  `Total_Value` varchar(255) NOT NULL,
  `Tax_Value` varchar(255) NOT NULL,
  `Final_Value` varchar(255) NOT NULL,
  `Supplier` char(40) NOT NULL,
  `Staff_ID` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `received_note`
--

INSERT INTO `received_note` (`Received_Note_ID`, `Date`, `Total_Value`, `Tax_Value`, `Final_Value`, `Supplier`, `Staff_ID`) VALUES
('RN1', 'O7pn1RXN1x0vW4yb0lxTth3uuIclL0ij4TciYtgLuGQ=', '+KuYOZdFZa1Q9OpTuAM7fA==', 'w9PONKp1cpIEyXtbpvgIiQ==', '5KwRbpIybXevgwC+cAVFNg==', '1E1DCn6rDfVkzxQrzk2Zrg==', 'AA01'),
('RN2', '7c/Y7EdwG61oS/WghoKDE9Ii400nksv6TlGYTdIhYD8=', '+KuYOZdFZa1Q9OpTuAM7fA==', 'w9PONKp1cpIEyXtbpvgIiQ==', '5KwRbpIybXevgwC+cAVFNg==', '1E1DCn6rDfVkzxQrzk2Zrg==', 'AA01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `received_note_detail`
--

CREATE TABLE `received_note_detail` (
  `Received_Note_ID` char(8) NOT NULL,
  `Product_ID` char(8) NOT NULL,
  `Size` char(8) NOT NULL,
  `UnitPrice` varchar(255) NOT NULL,
  `Quantity` varchar(255) NOT NULL,
  `Price` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `received_note_detail`
--

INSERT INTO `received_note_detail` (`Received_Note_ID`, `Product_ID`, `Size`, `UnitPrice`, `Quantity`, `Price`) VALUES
('RN1', 'P02', '1/2 con', '5MtMm0aDTu5fOrHdF2NXSA==', 'Wh4LrmIzCPPA2jQQVhXPZQ==', '+KuYOZdFZa1Q9OpTuAM7fA=='),
('RN2', 'P02', '1/2 con', '5MtMm0aDTu5fOrHdF2NXSA==', 'Wh4LrmIzCPPA2jQQVhXPZQ==', '+KuYOZdFZa1Q9OpTuAM7fA==');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`Staff_id`, `Full_Name`, `Year_Of_Birth`, `Gender`, `HomeTown`, `Phone_Num`, `Salary`, `IsDeleted`) VALUES
('AA01', 'Nguyễn Ngọc Trường Chinh', '2001', 'Nam', 'yLyvcJJp73VjOZUiNu2iFw==', 'w4jvzmZN4UBBu676baD0ug==', 'hlfUjcTYajeuaGsZv+qgsQ==', 0),
('AA02', 'Nguyễn Test', '2001', 'tp.hcm', 'CRCwe/XAOiDctGKIi9Wx2A==', 'g8eOGRZT3JjN99ecH42ZIw==', 'hlfUjcTYajeuaGsZv+qgsQ==', 1),
('AA03', 'Nguyễn Ngọc', '2001', 'tp.hcm', '7SPwotpNjX5DhZSfw39BGQ==', 'xfJuysl0NkPDnQGTxDQyWA==', 'avWyLo9Za2rgxH02TqS8Cg==', 1),
('AA04', 'Nguyễn', '2001', 'lsjdkgld', 'CRCwe/XAOiDctGKIi9Wx2A==', 'vItqyOU0b6u2OoufWCVWIg==', 'avWyLo9Za2rgxH02TqS8Cg==', 1),
('AA05', 'Nguyễn', '2004', 'Nam', 'iCV67kTo2f2Cfe98jvtunA==', 'vItqyOU0b6u2OoufWCVWIg==', 'E5YLfQ1qB26OIhZVfrBVKQ==', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Account_ID`),
  ADD KEY `Account_FK_1` (`Staff_ID`),
  ADD KEY `Account_FK_2` (`decentralize_id`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Bill_ID`),
  ADD KEY `Bill_FK_1` (`Staff_id`),
  ADD KEY `Bill_FK_2` (`Customer_id`);

--
-- Chỉ mục cho bảng `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`Bill_id`,`Product_id`,`Size`),
  ADD KEY `BillDetail_FK_2` (`Product_id`,`Size`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`Category_ID`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Chỉ mục cho bảng `decentralization`
--
ALTER TABLE `decentralization`
  ADD PRIMARY KEY (`decentralize_id`);

--
-- Chỉ mục cho bảng `decentralization_detail`
--
ALTER TABLE `decentralization_detail`
  ADD PRIMARY KEY (`decentralize_id`),
  ADD KEY `decentralize_id` (`decentralize_id`);

--
-- Chỉ mục cho bảng `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_Id`);

--
-- Chỉ mục cho bảng `discount_detail`
--
ALTER TABLE `discount_detail`
  ADD PRIMARY KEY (`discount_Id`,`product_Id`),
  ADD KEY `product_Id` (`product_Id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_ID`,`Size`),
  ADD KEY `Catagory_FK_1` (`Category_ID`);

--
-- Chỉ mục cho bảng `received_note`
--
ALTER TABLE `received_note`
  ADD PRIMARY KEY (`Received_Note_ID`),
  ADD KEY `Staff_ID` (`Staff_ID`);

--
-- Chỉ mục cho bảng `received_note_detail`
--
ALTER TABLE `received_note_detail`
  ADD PRIMARY KEY (`Received_Note_ID`,`Product_ID`,`Size`),
  ADD KEY `ReceivedNote_Detail_FK_2` (`Product_ID`,`Size`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Staff_id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `Account_FK_1` FOREIGN KEY (`Staff_ID`) REFERENCES `staff` (`Staff_id`),
  ADD CONSTRAINT `Account_FK_2` FOREIGN KEY (`decentralize_id`) REFERENCES `decentralization` (`decentralize_id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `Bill_FK_1` FOREIGN KEY (`Staff_id`) REFERENCES `staff` (`Staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Bill_FK_2` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD CONSTRAINT `BillDetail_FK_1` FOREIGN KEY (`Bill_id`) REFERENCES `bill` (`Bill_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BillDetail_FK_2` FOREIGN KEY (`Product_id`,`Size`) REFERENCES `product` (`Product_ID`, `Size`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `decentralization_detail`
--
ALTER TABLE `decentralization_detail`
  ADD CONSTRAINT `decentralize_FK_1` FOREIGN KEY (`decentralize_id`) REFERENCES `decentralization` (`decentralize_id`);

--
-- Các ràng buộc cho bảng `discount_detail`
--
ALTER TABLE `discount_detail`
  ADD CONSTRAINT `discount_detail_ibfk_1` FOREIGN KEY (`discount_Id`) REFERENCES `discount` (`discount_Id`),
  ADD CONSTRAINT `discount_detail_ibfk_2` FOREIGN KEY (`product_Id`) REFERENCES `product` (`Product_ID`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `Catagory_FK_1` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`Category_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `received_note`
--
ALTER TABLE `received_note`
  ADD CONSTRAINT `Product_FK_1` FOREIGN KEY (`Staff_ID`) REFERENCES `staff` (`Staff_id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `received_note_detail`
--
ALTER TABLE `received_note_detail`
  ADD CONSTRAINT `ReceivedNote_Detail_FK_2` FOREIGN KEY (`Product_ID`,`Size`) REFERENCES `product` (`Product_ID`, `Size`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Received_Note_FK_1` FOREIGN KEY (`Received_Note_ID`) REFERENCES `received_note` (`Received_Note_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
