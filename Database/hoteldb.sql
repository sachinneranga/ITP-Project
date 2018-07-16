-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2018 at 08:09 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoteldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `amount`
--

CREATE TABLE `amount` (
  `CusID` varchar(50) NOT NULL,
  `CusName` varchar(50) NOT NULL,
  `Amount` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `applyleave`
--

CREATE TABLE `applyleave` (
  `Empno` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Date` varchar(10) NOT NULL,
  `Numofleave` int(11) NOT NULL,
  `SDate` varchar(10) NOT NULL,
  `EDate` varchar(10) NOT NULL,
  `Reason` char(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `applyleave`
--

INSERT INTO `applyleave` (`Empno`, `Name`, `Date`, `Numofleave`, `SDate`, `EDate`, `Reason`) VALUES
(12, 'Kalana', '2018-04-01', 3, '2018-04-03', '2018-04-05', 'Medical'),
(13, 'Krishan', '2018-04-26', 1, '2018-04-30', '2018-04-30', 'Wedding'),
(14, 'Madhuni', '2018-04-04', 1, '2018-04-12', '2018-04-12', 'hgyft'),
(14, 'Madhuni', '2018-04-06', 2, '2018-04-18', '2018-04-19', 'Medical'),
(14, 'Madhuni', '2018-05-17', 1, '2018-05-23', '2018-05-23', 'Medical'),
(15, 'Charindi', '2018-04-26', 1, '2018-04-30', '2018-04-30', 'Wedding'),
(16, 'Umesha', '2018-04-24', 1, '2018-04-26', '2018-04-26', 'Funeral'),
(16, 'Umesha', '2018-05-17', 2, '2018-05-24', '2018-05-26', 'Trip'),
(17, 'Vithusha', '2018-05-10', 2, '2018-05-10', '2018-05-12', 'medical');

-- --------------------------------------------------------

--
-- Table structure for table `atendance`
--

CREATE TABLE `atendance` (
  `Empno` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Date` date NOT NULL,
  `Month` varchar(10) NOT NULL,
  `EnterTime` time NOT NULL,
  `LeaveTime` time DEFAULT NULL,
  `OThours` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atendance`
--

INSERT INTO `atendance` (`Empno`, `Name`, `Date`, `Month`, `EnterTime`, `LeaveTime`, `OThours`) VALUES
(12, 'Kalana', '2018-04-24', 'April', '08:27:00', '17:34:00', 2),
(12, 'Kalana', '2018-04-25', 'April', '08:27:00', '18:33:00', 3),
(12, 'Kalana', '2018-04-26', 'April', '08:25:00', '16:32:00', 0),
(12, 'Kalana', '2018-04-27', 'April', '00:00:00', NULL, NULL),
(12, 'Kalana', '2018-05-11', 'May', '00:00:00', NULL, NULL),
(13, 'Krishan', '2018-04-24', 'April', '08:25:00', '18:33:00', 3),
(13, 'Krishan', '2018-04-25', 'April', '09:26:00', '18:33:00', 1),
(13, 'Krishan', '2018-04-26', 'April', '08:21:00', '17:25:00', 1),
(13, 'Krishan', '2018-05-17', 'July', '11:32:00', '11:32:00', 2),
(14, 'Madhuni', '2018-04-24', 'April', '08:21:00', '17:00:00', 1),
(14, 'Madhuni', '2018-04-25', 'April', '08:24:00', '17:32:00', 1),
(14, 'Maduni', '2018-04-26', 'April', '08:25:00', '18:31:00', 2),
(15, 'Charindi', '2018-04-24', 'April', '07:27:00', '17:48:00', 2),
(15, 'Charindi', '2018-04-25', 'April', '08:24:00', '16:31:00', 0),
(15, 'Charindi', '2018-04-26', 'April', '08:23:00', '17:32:00', 1),
(15, 'Charindi', '2018-05-11', 'April', '04:14:00', '04:14:00', 1),
(16, 'Umesha', '2018-04-24', 'April', '08:29:00', '18:31:00', 3),
(16, 'Umesha', '2018-04-25', 'April', '08:29:00', '18:32:00', 2),
(16, 'Umesha', '2018-04-26', 'April', '08:22:00', '17:37:00', 1),
(17, 'Vithusha', '2018-04-26', 'April', '01:03:00', '08:46:00', 2),
(17, 'Vithusha', '2018-05-17', 'January', '11:41:00', '11:41:00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bid` int(11) NOT NULL,
  `supnname` varchar(20) NOT NULL,
  `amount` double NOT NULL,
  `date` varchar(15) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bid`, `supnname`, `amount`, `date`, `status`) VALUES
(1, 'table', 30000, '2018-05-17', 1),
(2, 'bed sheets', 6750, '2018-05-18', 1),
(3, 'vegetables', 450, '2018-05-24', 1),
(4, 'news papers', 1000, '2018-05-24', 1),
(5, 'chair', 60000, '2018-05-17', 1);

-- --------------------------------------------------------

--
-- Table structure for table `billpayments`
--

CREATE TABLE `billpayments` (
  `paymentID` varchar(50) NOT NULL,
  `invoiceID` varchar(50) NOT NULL,
  `total` int(11) NOT NULL,
  `cash` int(11) NOT NULL,
  `card` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billpayments`
--

INSERT INTO `billpayments` (`paymentID`, `invoiceID`, `total`, `cash`, `card`) VALUES
('CP1001', 'IN1001', 1500, 2000, 0),
('CP1002', 'IN1002', 10000, 15000, 0),
('CP1003', 'IN1003', 1350, 1500, 0);

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `RecID` int(11) NOT NULL,
  `PayID` varchar(50) NOT NULL,
  `CardNo` varchar(50) NOT NULL,
  `Bank` varchar(50) NOT NULL,
  `ExDate` varchar(50) NOT NULL,
  `CardType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`RecID`, `PayID`, `CardNo`, `Bank`, `ExDate`, `CardType`) VALUES
(1, '003', '1243568796453413', 'Sampath', '2019-04-27', 'Credit'),
(2, '004', '9878675854377', 'HNB', '2020-04-21', 'Debit'),
(3, '008', '098765432112', 'American Express', '2019-05-31', 'Credit');

-- --------------------------------------------------------

--
-- Table structure for table `catogary`
--

CREATE TABLE `catogary` (
  `catID` int(11) NOT NULL,
  `catName` varchar(50) NOT NULL,
  `store` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catogary`
--

INSERT INTO `catogary` (`catID`, `catName`, `store`) VALUES
(1, 'Cosmetics', 'Shop'),
(2, 'Snacks', 'Shop'),
(3, 'Clothing', 'Shop'),
(4, 'Machines', 'Asset'),
(5, 'Furniture', 'Asset'),
(6, 'Beach Accessories', 'Shop');

-- --------------------------------------------------------

--
-- Table structure for table `cheque`
--

CREATE TABLE `cheque` (
  `chqid` int(11) NOT NULL,
  `stockID` varchar(50) NOT NULL,
  `supID` varchar(50) NOT NULL,
  `supName` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `bank` varchar(50) NOT NULL,
  `chqdate` varchar(50) NOT NULL,
  `chqno` varchar(50) NOT NULL,
  `amount` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CusID` varchar(50) NOT NULL,
  `CusName` varchar(50) NOT NULL,
  `NIC_Passport` varchar(50) NOT NULL,
  `TelNo` varchar(50) NOT NULL,
  `CusType` varchar(50) NOT NULL,
  `PackageType` varchar(50) NOT NULL,
  `Adults` varchar(50) NOT NULL,
  `Children` varchar(50) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CusID`, `CusName`, `NIC_Passport`, `TelNo`, `CusType`, `PackageType`, `Adults`, `Children`, `Date`) VALUES
('001', 'Kalana Ramesh', '967856453v', '0764523765', 'Local', 'Full-Board', '2', '0', '2018-01-12'),
('002', 'Charindi Dulmini', '963426123v', '0765645345', 'Local', 'Half-Board', '2', '0', '2018-02-13'),
('003', 'Krishan Bandara', '945678564v', '0786754345', 'Local', 'Full-Board', '2', '1', '2018-04-23'),
('004', 'Madhuni Prashadini', '964536765v', '0713435367', 'Local', 'Half-Board', '2', '2', '2018-02-25'),
('005', 'Umesha Silva', '05485876', '0787656432', 'Foreign', 'Full-Board', '2', '4', '2018-04-27'),
('006', 'Dilshan', '963491107V', '0776420859', 'Local', 'Full-Board', '2', '0', '2018-05-11'),
('007', 'Harshitha Ramesh', '967656876V', '0765456876', 'Local', 'Half-Board', '2', '0', '2018-05-17'),
('008', 'Madhuni Widhushani', '9876786756765432', '0787665456', 'Foreign', 'Full-Board', '2', '2', '2018-05-17');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Empno` int(11) NOT NULL,
  `FName` varchar(30) NOT NULL,
  `LName` varchar(30) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  `PhoneNumber` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `JobTitel` varchar(50) NOT NULL,
  `BasicSalary` double NOT NULL,
  `JoinDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Empno`, `FName`, `LName`, `NIC`, `PhoneNumber`, `Address`, `DOB`, `Gender`, `JobTitel`, `BasicSalary`, `JoinDate`) VALUES
(12, 'Kalana', 'Ramesh', '967489635V', '0774856932', 'Dankotuwa', '2017-04-01', 'Male', 'Admin', 80000, '2017-04-01'),
(13, 'Krishan', 'Bandara', '945632147V', '0774863512', 'Kurunegala', '2018-01-09', 'Male', 'Cashier', 50000, '2018-01-09'),
(14, 'Madhuni', 'Prasadini', '962548756V', '0774123658', 'Borella', '2018-02-14', 'Female', 'Reciptionist', 60000, '2018-02-14'),
(15, 'Charindi', 'Dulmini', '965482149V', '0774569823', 'Kesbewa', '2018-01-30', 'Female', 'Reciptionist', 60000, '2018-01-30'),
(16, 'Umesha', 'Silva', '947521345V', '0776360754', 'Galle', '2016-02-04', 'Female', 'HR Manager', 80000, '2016-02-04'),
(17, 'Vithusha', 'Vithu', '958742136V', '0714569875', 'Colombo', '2018-02-01', 'Female', 'Accountant', 60000, '2018-02-01'),
(18, ' khh', 'fdfd', '987654334V', '0778965432', 'GALLE', '2018-04-27', 'Male', 'HR Manager', 30000, '2018-04-27'),
(19, ' Manuka', 'perera', '948765234V', '0774586932', 'Thalawathugoda', '2017-11-21', 'Male', 'HR Manager', 50000, '2017-11-21'),
(20, ' Kasun', 'Shan', '949087654V', '0775869321', 'Kaluthara', '2017-05-04', 'Male', 'HR Manager', 60000, '2017-05-04');

-- --------------------------------------------------------

--
-- Table structure for table `expences`
--

CREATE TABLE `expences` (
  `expenceddatid` int(11) NOT NULL,
  `electicitybill` double NOT NULL,
  `waterbill` double NOT NULL,
  `telephonebill` double NOT NULL,
  `insurance` double NOT NULL,
  `smallexpences` double NOT NULL,
  `bankloaninterest` double NOT NULL,
  `overdraft` double NOT NULL,
  `advertisement` double NOT NULL,
  `date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expences`
--

INSERT INTO `expences` (`expenceddatid`, `electicitybill`, `waterbill`, `telephonebill`, `insurance`, `smallexpences`, `bankloaninterest`, `overdraft`, `advertisement`, `date`) VALUES
(1, 2, 2, 2, 2, 2, 2, 2, 2, '22'),
(2, 55, 2, 22, 22, 2, 2, 2, 2, '25'),
(3, 3, 45, 35, 3, 4, 4, 4, 4, ''),
(4, 34, 345, 767, 456, 807, 807, 677, 56, '');

-- --------------------------------------------------------

--
-- Table structure for table `fullboard`
--

CREATE TABLE `fullboard` (
  `PackageID` int(5) NOT NULL,
  `PackageType` varchar(50) NOT NULL,
  `CusType` varchar(50) NOT NULL,
  `SingleRoomPrice` varchar(50) NOT NULL,
  `DoubleRoomPrice` varchar(50) NOT NULL,
  `TripleRoomPrice` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fullboard`
--

INSERT INTO `fullboard` (`PackageID`, `PackageType`, `CusType`, `SingleRoomPrice`, `DoubleRoomPrice`, `TripleRoomPrice`) VALUES
(1, 'Full-Board', 'Local', '2000', '4000', '4000'),
(2, 'Full-Board', 'Foreign', '4000', '6000', '8000');

-- --------------------------------------------------------

--
-- Table structure for table `fullboardbooking`
--

CREATE TABLE `fullboardbooking` (
  `RecID` int(11) NOT NULL,
  `CusID` varchar(50) NOT NULL,
  `SingleRoom` varchar(50) NOT NULL,
  `DoubleRoom` varchar(50) NOT NULL,
  `TripleRoom` varchar(50) NOT NULL,
  `NoOfDate` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fullboardbooking`
--

INSERT INTO `fullboardbooking` (`RecID`, `CusID`, `SingleRoom`, `DoubleRoom`, `TripleRoom`, `NoOfDate`, `State`) VALUES
(6, '001', '0', '1', '0', '2', 'Check-out'),
(7, '003', '0', '0', '1', '5', 'Check-out'),
(8, '005', '0', '0', '2', '15', 'Check-out'),
(10, '008', '0', '2', '0', '4', 'Check-in');

-- --------------------------------------------------------

--
-- Table structure for table `halfboard`
--

CREATE TABLE `halfboard` (
  `PackageID` int(5) NOT NULL,
  `PackageType` varchar(50) NOT NULL,
  `CusType` varchar(50) NOT NULL,
  `AdultsPrice` varchar(50) NOT NULL,
  `ChildrenPrice` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `halfboard`
--

INSERT INTO `halfboard` (`PackageID`, `PackageType`, `CusType`, `AdultsPrice`, `ChildrenPrice`) VALUES
(1, 'Half-Board', 'Local', '4000', '2000'),
(2, 'Half-Board', 'Foreign', '6000', '2500');

-- --------------------------------------------------------

--
-- Table structure for table `income`
--

CREATE TABLE `income` (
  `type` varchar(20) NOT NULL,
  `amount` int(11) NOT NULL,
  `date` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `income`
--

INSERT INTO `income` (`type`, `amount`, `date`) VALUES
('fdss', 4, 4),
('Item 2', 22, 22),
('Item 2', 11, 2),
('Item 2', 22, 2),
('Item 3', 22, 2);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoiceID` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `proID` varchar(50) NOT NULL,
  `proName` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  `qty` varchar(50) NOT NULL,
  `discount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoiceID`, `date`, `proID`, `proName`, `price`, `qty`, `discount`) VALUES
('IN1001', '11-05-2018', 'PD1002', 'Pringles', '500', '2', 0),
('IN1001', '11-05-2018', 'PD1002', 'Pringles', '500', '1', 0),
('IN1002', '11-05-2018', 'PD1004', 'Surf Board', '10000', '1', 0),
('IN1003', '17-05-2018', 'PD1001', 'CLEAR Shampoo', '150', '3', 0),
('IN1003', '17-05-2018', 'PD1003', 'Beach Shorts', '900', '1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `kitchen`
--

CREATE TABLE `kitchen` (
  `itemID` varchar(50) NOT NULL,
  `itemname` varchar(50) NOT NULL,
  `catogory` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `re-order` int(11) NOT NULL,
  `optainstock` int(11) NOT NULL,
  `barcode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kitchen`
--

INSERT INTO `kitchen` (`itemID`, `itemname`, `catogory`, `price`, `re-order`, `optainstock`, `barcode`) VALUES
('KT1001', 'Coffee Maker', 'Machines', 15000, 3, 5, 111111),
('KT1002', 'Coffee Maker', 'Machines', 15000, 3, 5, 666666),
('KT1003', 'Coffee Table', 'Furniture', 12000, 2, 10, 888888);

-- --------------------------------------------------------

--
-- Table structure for table `leave`
--

CREATE TABLE `leave` (
  `Empno` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Take` int(11) NOT NULL,
  `Left` int(11) NOT NULL,
  `Nopay` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `RecordID` int(11) NOT NULL,
  `EmpID` int(11) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`RecordID`, `EmpID`, `UserName`, `Password`) VALUES
(1, 12, 'Kalana', 'A123'),
(2, 13, 'Krishan', 'C123'),
(3, 14, 'Madhuni', 'Madhuni'),
(4, 15, 'Charindi', 'R123'),
(5, 16, 'Umesha', 'H123'),
(6, 17, 'Vithusha', 'A123'),
(7, 18, ' khh', ' khh'),
(8, 19, ' Manuka', ' Manuka'),
(9, 20, ' Kasun', ' Kasun');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PayID` varchar(50) NOT NULL,
  `CusID` varchar(50) NOT NULL,
  `Amount` varchar(50) NOT NULL,
  `Method` varchar(50) NOT NULL,
  `PayDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`PayID`, `CusID`, `Amount`, `Method`, `PayDate`) VALUES
('001', '001', '6000.0', 'Cash', '2018-01-12'),
('002', '002', '8000.0', 'Cash', '2018-02-13'),
('003', '003', '20000.0', 'Card', '2018-02-23'),
('004', '004', '12000.0', 'Card', '2018-02-25'),
('005', '005', '240000.0', 'Cash', '2018-04-27'),
('006', '006', '3000.0', 'Cash', '2018-05-11'),
('007', '007', '8000.0', 'Cash', '2018-05-17'),
('008', '008', '48000.0', 'Card', '2018-05-17');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` varchar(50) NOT NULL,
  `productName` varchar(50) NOT NULL,
  `barcode` int(11) NOT NULL,
  `catogory` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `costprice` int(11) NOT NULL,
  `sellprice` int(11) NOT NULL,
  `reorderpoint` int(11) NOT NULL,
  `optainstock` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `tax` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `productName`, `barcode`, `catogory`, `description`, `costprice`, `sellprice`, `reorderpoint`, `optainstock`, `discount`, `tax`) VALUES
('PD1001', 'CLEAR Shampoo', 111111, 'Cosmetics', 'CLEAR SHAMPOO 500ML', 150, 150, 50, 1099, 0, 0),
('PD1002', 'Pringles', 222222, 'Snacks', 'LARGE PRINGLES', 500, 500, 50, 497, 0, 0),
('PD1003', 'Beach Shorts', 333333, 'Clothing', 'BEACH WEAR - FREE SIZE', 700, 900, 100, 49, 0, 0),
('PD1004', 'Surf Board', 444444, 'Beach Accessories', 'ADULT BEACH SURFING BOARD', 7000, 11000, 100, 551, 0, 0),
('PD1005', '3 Roses Tea', 555555, 'Snacks', '3 ROSES 500G TEA PACKET', 200, 200, 50, 500, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `res_bill_detail`
--

CREATE TABLE `res_bill_detail` (
  `billno` int(11) NOT NULL,
  `invID` int(45) NOT NULL,
  `ItemName` varchar(45) DEFAULT NULL,
  `qty` varchar(45) DEFAULT NULL,
  `total` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `res_bill_detail`
--

INSERT INTO `res_bill_detail` (`billno`, `invID`, `ItemName`, `qty`, `total`) VALUES
(1, 7, 'Rice', '4', '1000.0'),
(2, 8, 'Rice', '2', '500.0'),
(3, 9, 'Kottu', '7', '1400.0'),
(4, 10, 'Rice', '5', '1250.0'),
(5, 11, 'Kottu', '1', '200.0'),
(6, 12, 'Kottu', '50', '10000.0'),
(6, 13, 'Freird Rice', '4', '1200.0'),
(7, 14, 'Rice', '3', '750.0'),
(8, 15, 'Rice', '1', '250.0'),
(8, 16, 'Kottu', '1', '200.0'),
(9, 17, 'Kottu', '2', '400.0'),
(10, 18, 'Roll', '5', '250.0'),
(11, 19, 'T bun', '4', '120.0'),
(11, 20, 'Rice', '2', '500.0'),
(12, 21, 'Kottu', '2', '400.0'),
(12, 22, 'Fish bun', '6', '300.0'),
(12, 23, 'Roll', '4', '200.0'),
(12, 24, 'Fish bun', '1', '50.0'),
(13, 25, 'Freird Rice', '5', '1500.0'),
(13, 26, 'Kottu', '6', '1200.0'),
(14, 27, 'Rice', '2', '500.0'),
(14, 29, 'Fish bun', '3', '150.0');

-- --------------------------------------------------------

--
-- Table structure for table `res_bill_sum`
--

CREATE TABLE `res_bill_sum` (
  `billdate` date DEFAULT NULL,
  `billnet` varchar(45) DEFAULT NULL,
  `billno` int(45) NOT NULL,
  `tblORtkaway` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `res_bill_sum`
--

INSERT INTO `res_bill_sum` (`billdate`, `billnet`, `billno`, `tblORtkaway`) VALUES
('2018-04-21', '1902', 1, 'Take Away'),
('2018-04-21', '500', 2, 'Take Away'),
('2018-04-22', '1400', 3, 'Take Away'),
('2018-04-22', '1250', 4, 'RT2'),
('2018-04-22', '200', 5, 'RT4'),
('2018-04-26', '11200', 6, 'Take Away'),
('2018-04-26', '750', 7, 'Take Away'),
('2018-04-26', '450', 8, 'Take Away'),
('2018-04-26', '400', 9, 'Take Away'),
('2018-04-26', '250', 10, 'Take Away'),
('2018-04-27', '620', 11, 'Take Away'),
('2018-05-11', '950', 12, 'Take Away'),
('2018-05-11', '2700', 13, 'Take Away'),
('2018-05-17', '650', 14, 'Take Away'),
(NULL, '0', 15, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `res_instameal`
--

CREATE TABLE `res_instameal` (
  `itenNo` int(11) NOT NULL,
  `mealName` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `res_meal`
--

CREATE TABLE `res_meal` (
  `expDate` date NOT NULL,
  `itemNo` int(45) NOT NULL,
  `lvl` varchar(45) DEFAULT NULL,
  `mealName` varchar(45) DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `res_meal`
--

INSERT INTO `res_meal` (`expDate`, `itemNo`, `lvl`, `mealName`, `quantity`) VALUES
('2018-05-14', 1, '1', 'Kottu', '494'),
('2018-05-11', 2, '2', 'Rice', '43'),
('2018-05-12', 3, '3', 'Freird Rice', '8'),
('2018-05-18', 4, '4', 'Fish bun', '64'),
('2018-05-15', 5, '5', 'T bun', '56'),
('2018-05-15', 6, '6', 'Roll', '40');

-- --------------------------------------------------------

--
-- Table structure for table `res_order`
--

CREATE TABLE `res_order` (
  `CompletedDate` datetime DEFAULT NULL,
  `itmno` int(11) NOT NULL,
  `No` int(11) DEFAULT NULL,
  `OrderedDate` date DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `res_order`
--

INSERT INTO `res_order` (`CompletedDate`, `itmno`, `No`, `OrderedDate`, `quantity`, `status`) VALUES
('2018-04-21 23:44:25', 1, 1, '2018-04-20', 2, 'y'),
('2018-04-26 11:45:36', 2, 2, '2018-04-21', 10, 'n'),
('2018-04-29 15:27:07', 3, 3, '2018-04-12', 56, 'n'),
(NULL, 4, NULL, '2018-05-11', 1, 'N');

-- --------------------------------------------------------

--
-- Table structure for table `res_quick_meal`
--

CREATE TABLE `res_quick_meal` (
  `qitemNo` int(11) NOT NULL,
  `qmealName` varchar(45) DEFAULT NULL,
  `qprice` double(200,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `res_quick_meal`
--

INSERT INTO `res_quick_meal` (`qitemNo`, `qmealName`, `qprice`) VALUES
(1, 'Rice', 250),
(2, 'Kottu', 200),
(3, 'Freird Rice', 300),
(4, 'Fish bun', 50),
(5, 'T bun', 30),
(6, 'Roll', 50);

-- --------------------------------------------------------

--
-- Table structure for table `res_quick_order`
--

CREATE TABLE `res_quick_order` (
  `Billno` int(11) NOT NULL,
  `oid` int(45) NOT NULL,
  `omealName` varchar(45) DEFAULT NULL,
  `oqty` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `res_quick_order`
--

INSERT INTO `res_quick_order` (`Billno`, `oid`, `omealName`, `oqty`, `status`) VALUES
(1, 20, 'Rice', '4', 'N'),
(2, 21, 'Rice', '2', 'N'),
(3, 22, 'Kottu', '7', 'N'),
(4, 23, 'Rice', '5', 'N'),
(5, 24, 'Kottu', '1', 'N'),
(6, 25, 'Kottu', '50', 'N'),
(7, 26, 'Rice', '3', 'N'),
(8, 27, 'Rice', '1', 'N'),
(8, 28, 'Kottu', '1', 'N'),
(9, 29, 'Kottu', '2', 'N');

-- --------------------------------------------------------

--
-- Table structure for table `res_table`
--

CREATE TABLE `res_table` (
  `billno` int(11) NOT NULL,
  `cuscontact` varchar(45) DEFAULT NULL,
  `cusName` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `stime` varchar(45) DEFAULT NULL,
  `tbleno` varchar(45) DEFAULT NULL,
  `tprice` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `res_table`
--

INSERT INTO `res_table` (`billno`, `cuscontact`, `cusName`, `date`, `status`, `stime`, `tbleno`, `tprice`) VALUES
(27, '0771266582', 'Lahiru', '2018-04-23', 'Y', 'Morning', 'table1', '500'),
(28, '0771245889', 'Kamal', '2018-04-01', 'Y', 'Evening', 'table20', '1000'),
(29, '0785656123', 'Weerasekara', '2018-04-23', 'Y', 'Morning', 'table2', '500'),
(30, '0756688995', 'Gagan', '2018-04-07', 'Y', 'Night', 'table13', '500'),
(31, '0115566445', 'Dilshan', '2018-04-27', 'Y', 'Lunch', 'table20', '1000'),
(32, '0765566222', 'Asha', '2018-04-24', 'Y', 'Evening', 'table1', '500'),
(33, '0446688223', 'Kalana', '2018-04-24', 'Y', 'Evening', 'table15', '500'),
(34, ' 0894433123', 'kmn', '2018-04-28', 'Y', 'Lunch', 'table14', '500'),
(35, ' 1223566562', 'Kamal', '2018-05-11', 'Y', 'Morning', 'table19', '1000'),
(36, ' 0232656656', 'kaman', '2018-05-12', 'Y', 'Evening', 'table16', '500'),
(37, '0782653321', 'harshana', '2018-05-12', 'Y', 'Night', 'table16', '500'),
(38, ' 0786543234', 'Krishan Sajith', '2018-05-18', 'Y', 'Morning', 'table1', '500');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `RoomType` varchar(50) NOT NULL,
  `NoOfRooms` varchar(50) NOT NULL,
  `Available` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`RoomType`, `NoOfRooms`, `Available`) VALUES
('Double Room', '50', 48),
('Single Room', '10', 10),
('Triple Room', '5', 5);

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `Empno` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Date` date NOT NULL,
  `Month` varchar(10) NOT NULL,
  `year` int(11) NOT NULL,
  `BasicSalary` double NOT NULL,
  `OTcharge` double NOT NULL,
  `TotalAllowance` double NOT NULL,
  `ETF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`Empno`, `Name`, `Date`, `Month`, `year`, `BasicSalary`, `OTcharge`, `TotalAllowance`, `ETF`) VALUES
(12, 'Kalana', '2018-04-27', 'April', 2018, 80000, 2800, 82800, 32000),
(12, 'Kalana', '2018-03-27', 'February', 2018, 80000, 1200, 81200, 16000),
(13, 'Krishan', '2018-04-27', 'April', 2018, 50000, 1750, 51750, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stid` int(11) NOT NULL,
  `itemname` varchar(50) NOT NULL,
  `qty` varchar(100) NOT NULL,
  `value` varchar(100) NOT NULL,
  `date` varchar(15) NOT NULL,
  `stype` varchar(20) NOT NULL,
  `supplier` varchar(20) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stid`, `itemname`, `qty`, `value`, `date`, `stype`, `supplier`, `status`) VALUES
(1, 'chair', '40', '2000', '2018-05-03', 'Furniture', 'nimal', 1),
(2, 'table', '5', '3000', '2018-05-17', 'Furniture', 'nimal', 1),
(3, 'bed sheets', '15', '450', '2018-05-18', 'Clothing', 'sunimal', 1),
(4, 'vegetables', '10', '45', '2018-05-24', 'Food Materials', 'kalana', 1),
(5, 'news papers', '20', '50', '2018-05-24', 'Other', 'chanuka', 1),
(6, 'table', '3', '5000', '2018-05-17', 'Furniture', 'sunimal', 1),
(7, 'chair', '20', '3000', '2018-05-17', 'Furniture', 'sunimal', 1);

-- --------------------------------------------------------

--
-- Table structure for table `stock2`
--

CREATE TABLE `stock2` (
  `stockID` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `supID` varchar(50) NOT NULL,
  `supName` varchar(50) NOT NULL,
  `proID` varchar(50) NOT NULL,
  `proName` varchar(50) NOT NULL,
  `qty` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock2`
--

INSERT INTO `stock2` (`stockID`, `date`, `supID`, `supName`, `proID`, `proName`, `qty`, `price`) VALUES
('ST1001', '11-05-2018', 'SP1001', 'Lanka Distributors', 'PD1001', 'CLEAR Shampoo', 100, 150),
('ST1002', '11-05-2018', 'SP1002', 'GR33N Distributors', 'PD1004', 'Surf Board', 50, 10000),
('ST1003', '11-05-2018', 'SP1002', 'GR33N Distributors', 'PD1004', 'Surf Board', 2, 7000),
('ST1004', '17-05-2018', 'SP1001', 'Lanka Distributors', 'PD1001', 'CLEAR Shampoo', 2, 150);

-- --------------------------------------------------------

--
-- Table structure for table `supp`
--

CREATE TABLE `supp` (
  `supID` varchar(50) NOT NULL,
  `supname` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contactno` varchar(50) NOT NULL,
  `emailid` varchar(50) NOT NULL,
  `remarks` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supp`
--

INSERT INTO `supp` (`supID`, `supname`, `address`, `contactno`, `emailid`, `remarks`) VALUES
('SP1001', 'Lanka Distributors', 'Galle', '1234567890', 'lanka1@lanka.com', ''),
('SP1002', 'GR33N Distributors', 'Panadura', '0987654321', 'gr@gr.com', '');

-- --------------------------------------------------------

--
-- Table structure for table `suppayments`
--

CREATE TABLE `suppayments` (
  `paymentID` varchar(50) NOT NULL,
  `stockID` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `supID` varchar(50) NOT NULL,
  `supName` varchar(50) NOT NULL,
  `total` varchar(50) NOT NULL,
  `cash` int(11) NOT NULL,
  `cheque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppayments`
--

INSERT INTO `suppayments` (`paymentID`, `stockID`, `date`, `supID`, `supName`, `total`, `cash`, `cheque`) VALUES
('PY1001', 'ST1001', '11-05-2018', 'SP1001', 'Lanka Distributors', '15000', 20000, 0),
('PY1002', 'ST1002', '11-05-2018', 'SP1002', 'GR33N Distributors', '500000', 1000000, 0),
('PY1003', 'ST1003', '11-05-2018', 'SP1002', 'GR33N Distributors', '14000', 1000000, 0),
('PY1004', 'ST1004', '17-05-2018', 'SP1001', 'Lanka Distributors', '300', 500, 0);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supid` int(11) NOT NULL,
  `supname` varchar(50) NOT NULL,
  `suptype` varchar(20) NOT NULL,
  `supaddress` varchar(100) NOT NULL,
  `supcontact` int(11) NOT NULL,
  `supstatus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supid`, `supname`, `suptype`, `supaddress`, `supcontact`, `supstatus`) VALUES
(1, 'nimal', 'Furniture', '299,bandaragama', 123456789, 1),
(2, 'kalana', 'Food Materials', '554,horana', 112364584, 1),
(3, 'sunimal', 'Clothing', '578,kaluthara', 114896523, 1),
(4, 'sagara', 'Furniture', '554,polgasowita', 385412687, 1),
(5, 'chanuka', 'Other', '778,horana', 1236547895, 1),
(6, 'saman', 'Food Materials', '229', 1236123656, 1),
(7, 'madhuni', 'Clothing', '45, kesbawa', 756545345, 1),
(8, 'dulmini', 'Clothing', '10, polgasowita', 786765432, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applyleave`
--
ALTER TABLE `applyleave`
  ADD PRIMARY KEY (`Empno`,`Date`);

--
-- Indexes for table `atendance`
--
ALTER TABLE `atendance`
  ADD PRIMARY KEY (`Empno`,`Date`,`Month`);

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`RecID`),
  ADD UNIQUE KEY `PayID` (`PayID`);

--
-- Indexes for table `catogary`
--
ALTER TABLE `catogary`
  ADD PRIMARY KEY (`catID`);

--
-- Indexes for table `cheque`
--
ALTER TABLE `cheque`
  ADD PRIMARY KEY (`chqid`),
  ADD UNIQUE KEY `chqno` (`chqno`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CusID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Empno`,`NIC`);

--
-- Indexes for table `expences`
--
ALTER TABLE `expences`
  ADD PRIMARY KEY (`expenceddatid`);

--
-- Indexes for table `fullboard`
--
ALTER TABLE `fullboard`
  ADD PRIMARY KEY (`PackageID`);

--
-- Indexes for table `fullboardbooking`
--
ALTER TABLE `fullboardbooking`
  ADD PRIMARY KEY (`RecID`),
  ADD UNIQUE KEY `CusID` (`CusID`);

--
-- Indexes for table `halfboard`
--
ALTER TABLE `halfboard`
  ADD PRIMARY KEY (`PackageID`);

--
-- Indexes for table `kitchen`
--
ALTER TABLE `kitchen`
  ADD PRIMARY KEY (`itemID`),
  ADD UNIQUE KEY `barcode` (`barcode`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`RecordID`),
  ADD KEY `EmpID` (`EmpID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PayID`),
  ADD UNIQUE KEY `CusID` (`CusID`);

--
-- Indexes for table `res_bill_detail`
--
ALTER TABLE `res_bill_detail`
  ADD PRIMARY KEY (`invID`),
  ADD KEY `billf` (`billno`);

--
-- Indexes for table `res_bill_sum`
--
ALTER TABLE `res_bill_sum`
  ADD PRIMARY KEY (`billno`);

--
-- Indexes for table `res_instameal`
--
ALTER TABLE `res_instameal`
  ADD PRIMARY KEY (`itenNo`);

--
-- Indexes for table `res_meal`
--
ALTER TABLE `res_meal`
  ADD PRIMARY KEY (`itemNo`);

--
-- Indexes for table `res_order`
--
ALTER TABLE `res_order`
  ADD PRIMARY KEY (`itmno`);

--
-- Indexes for table `res_quick_meal`
--
ALTER TABLE `res_quick_meal`
  ADD PRIMARY KEY (`qitemNo`);

--
-- Indexes for table `res_quick_order`
--
ALTER TABLE `res_quick_order`
  ADD PRIMARY KEY (`oid`),
  ADD KEY `BillFr` (`Billno`);

--
-- Indexes for table `res_table`
--
ALTER TABLE `res_table`
  ADD PRIMARY KEY (`billno`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`RoomType`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`Empno`,`Month`,`year`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stid`);

--
-- Indexes for table `supp`
--
ALTER TABLE `supp`
  ADD PRIMARY KEY (`supID`);

--
-- Indexes for table `suppayments`
--
ALTER TABLE `suppayments`
  ADD PRIMARY KEY (`paymentID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `card`
--
ALTER TABLE `card`
  MODIFY `RecID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `catogary`
--
ALTER TABLE `catogary`
  MODIFY `catID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `Empno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `expences`
--
ALTER TABLE `expences`
  MODIFY `expenceddatid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `fullboardbooking`
--
ALTER TABLE `fullboardbooking`
  MODIFY `RecID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `halfboard`
--
ALTER TABLE `halfboard`
  MODIFY `PackageID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `RecordID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `res_bill_detail`
--
ALTER TABLE `res_bill_detail`
  MODIFY `invID` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `res_bill_sum`
--
ALTER TABLE `res_bill_sum`
  MODIFY `billno` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `res_instameal`
--
ALTER TABLE `res_instameal`
  MODIFY `itenNo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `res_meal`
--
ALTER TABLE `res_meal`
  MODIFY `itemNo` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `res_quick_order`
--
ALTER TABLE `res_quick_order`
  MODIFY `oid` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `res_table`
--
ALTER TABLE `res_table`
  MODIFY `billno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `CaF` FOREIGN KEY (`PayID`) REFERENCES `payment` (`PayID`);

--
-- Constraints for table `fullboardbooking`
--
ALTER TABLE `fullboardbooking`
  ADD CONSTRAINT `CF` FOREIGN KEY (`CusID`) REFERENCES `customer` (`CusID`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `LFK` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`Empno`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `PF` FOREIGN KEY (`CusID`) REFERENCES `customer` (`CusID`);

--
-- Constraints for table `res_bill_detail`
--
ALTER TABLE `res_bill_detail`
  ADD CONSTRAINT `billf` FOREIGN KEY (`billno`) REFERENCES `res_bill_sum` (`billno`);

--
-- Constraints for table `res_quick_order`
--
ALTER TABLE `res_quick_order`
  ADD CONSTRAINT `BillFr` FOREIGN KEY (`Billno`) REFERENCES `res_bill_sum` (`billno`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
