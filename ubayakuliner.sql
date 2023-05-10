-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ubayakuliner
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `avatar` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'michelle','michelle',NULL),(2,'jennie','jennie',NULL),(3,'steve','steve',NULL),(4,'sisca','sisca',NULL),(5,'kiki','kiki',NULL),(6,'sally','sally',NULL),(7,'lilac','lilac',NULL),(8,'vivi','vivi',NULL),(9,'celine','celine',NULL),(10,'velita','velita',NULL),(11,'gaby','gaby',NULL),(12,'billy','billy',NULL),(13,'sesil','sesil',NULL);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `best_seller`
--

DROP TABLE IF EXISTS `best_seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `best_seller` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(200) DEFAULT NULL,
  `jambukatutup` varchar(50) DEFAULT NULL,
  `jarak` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `photourl` text,
  `typefood` varchar(100) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `best_seller`
--

LOCK TABLES `best_seller` WRITE;
/*!40000 ALTER TABLE `best_seller` DISABLE KEYS */;
INSERT INTO `best_seller` VALUES (1,'Titik Koma','09.00 am - 10.00 pm','0.3 km','Jl.Tenggilis No. 5','https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiuYnL5dKVQxDX_l9oO9wqChBblwi1BQT61R4VPq1tgIxDwPbuUf5RKqM269a7eX-DX7-FOOTldLh2KsWrw7j0qF-OaUZWy4pQv_wNutCoYn_ilKz3EMZE7GE4hm25tSlqZTRATUM2pRs67zkDH8SMve_cvUI9KKvrEtPwPio21jkY9fJW7GgWr3cz_/s1350/kopi-titik-koma-surabaya-harga-menu-dan-lokasi.jpg','Western Food & Drink','Titik koma merupakan cafe yag sudah memiliki beberapa cabang di Surabaya. Salah satunya disini Jl.Tenggilis No.5'),(2,'Bakso pak Uun','08.00 am - 06.00 pm','0.2 km','Jl.Rungkut Mejoyo Selatan II No.18','https://wisatakulinerindonesia.files.wordpress.com/2010/06/img00691-20100605-14261.jpg','Asia Food','Bakso pak uun menjual bakso dengan pilihan urat, halus, kasar, tahu, dan goreng.'),(3,'Es Teh Indonesia','10.00 am - 10.00 pm','1.2 km','Jl. Tenggilis Mejoyo No. 112','https://brandwazh.com/wp-content/uploads/2022/11/aWNZykEL1qhpLNZKHQ30BiFt4VncH1.jpg','Drink','Es Teh Indonesia memiliki 100++ cabang di Indonesia. Es Teh Indonesia ini menjual beberapa pilihan menu teh yang beragam seperti taro, red velvet, lychee, oreo, teh original, dan lainnya.');
/*!40000 ALTER TABLE `best_seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bestsellermenu`
--

DROP TABLE IF EXISTS `bestsellermenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bestsellermenu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `description` text,
  `photourl` text,
  `lokasi` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bestsellermenu`
--

LOCK TABLES `bestsellermenu` WRITE;
/*!40000 ALTER TABLE `bestsellermenu` DISABLE KEYS */;
INSERT INTO `bestsellermenu` VALUES (1,'Kebab Sapi','Daging sapi, telur, keju','https://img-global.cpcdn.com/recipes/7f39e1870bf68a18/1200x630cq70/photo.jpg','Kebab Turki'),(2,'Caramel Coffee','Coffee, Sugar, Milk, Caramel Syrup','https://www.forkinthekitchen.com/wp-content/uploads/2022/06/220518.homemade.caramel.latte-6630.jpg','Titik Koma'),(3,'Lychee Tea','Lychee Syrup, Tea','https://images.tokopedia.net/img/JFrBQq/2022/9/14/326ee2c2-78e8-4086-9b00-49636a9e0af7.jpg','Es Teh Indonesia');
/*!40000 ALTER TABLE `bestsellermenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `description` text,
  `photoUrl` text,
  `harga` varchar(100) DEFAULT NULL,
  `resto_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_menu_resto1_idx` (`resto_id`),
  CONSTRAINT `fk_menu_resto1` FOREIGN KEY (`resto_id`) REFERENCES `resto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Kebab Sapi','Daging sapi, telur, keju','https://assets.ayobandung.com/crop/0x0:0x0/750x500/webp/photo/2022/08/04/2322384256.jpg','21.000',1),(2,'Kebab Sapi Extra Keju','Daging sapi, telur, extra keju','https://www.tokomesin.com/wp-content/uploads/2017/09/kebab-sosis-tokomesin.jpg','25.000',1),(3,'Kebab Hitam Ayam','Daging ayam, telur, keju','https://www.jagel.id/api/listimage/v/Kebab-Hitam-Ayam-Premium-0-80662ce025cc2054.jpg','21.000',1),(4,'Burger Ayam','Daging Crispy Ayam, sayur, saus','https://asset.kompas.com/crops/S7vCL7w60DW4gZvn427A4K1KZKE=/120x113:815x577/750x500/data/photo/2022/01/25/61ef4b60ead1d.jpeg','20.000',1),(5,'Caramel Frappucino','Caramel Syrup, Coffee, Milk, Whip Cream','https://i0.wp.com/i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/eaee55fa-767e-4ecd-8450-922c1cd82c59_Go-Biz_20220531_170133.jpeg','30.000',2),(6,'Lychee Tea','Tea, Lychee Syrup, Buah Leci, Jelly','https://d1sag4ddilekf6.cloudfront.net/compressed_webp/items/IDITE20220602120645063246/detail/ca06a8d8_e43542bac72.webp','25.000',2),(7,'Avocado Milk','Milk, Avocado, Choco Syrup','https://d1sag4ddilekf6.cloudfront.net/compressed_webp/items/IDITE2022102610163750695/detail/menueditor_item_2805832ea46748248c333c7ad6aa9265_1666779306580190174.webp','27.000',2),(8,'Choco Waffle','Waffle, Choco Syrup, Ice cream','https://2.bp.blogspot.com/-mVW8V8G7oYo/V7ZzXRGvOCI/AAAAAAAAMP4/R9H6VDdwxuYw2cEufR2fzLb2NM62-z1-QCLcB/s1600/16-08-19-09-22-05-541_deco.jpg','35.000',2),(9,'Bakso Campur','Campur 10 biji (Kasar, Halus, Goreng Tahu)','https://fastly.4sqi.net/img/general/600x600/3704163_LRQ0T6CBjMyIiNIDZhilOvkKG80DMJMrhw_HwPMBh1o.jpg','20.000',3),(10,'Bakso Keju','(Keju isi 5 biji)','https://i0.wp.com/resepkoki.id/wp-content/uploads/2020/02/Resep-Bakso-Keju.jpg?fit=1079%2C1177&ssl=1','25.000',3),(11,'Bakso Halus','(Halus isi 5 biji)','https://img-global.cpcdn.com/recipes/2369d46938dce4c5/680x482cq70/bakso-sapi-halus-foto-resep-utama.jpg','10.000',3),(12,'Bakso Kasar','(Kasar isi 5 biji)','https://asset.kompas.com/crops/4aqOaU_1HDJzJZDlhtm1mFQFmSM=/0x0:698x465/750x500/data/photo/2021/01/08/5ff86f55cf2e4.jpg','10.000',3),(13,'Goreng','(Goreng isi 3 biji)','https://i.ytimg.com/vi/Id1ll8EMhfA/maxresdefault.jpg','10.000',3),(14,'Teh Poci Nutrisari','Nutrisari Jeruk','https://d1sag4ddilekf6.cloudfront.net/compressed_webp/items/IDITE20210218061112273899/detail/menueditor_item_d1f03eaabff84fdc910bb8026c588ef1_1613831864016341548.webp','7.000',4),(15,'Teh Poci Milo','Milo','https://d1sag4ddilekf6.cloudfront.net/compressed_webp/items/IDITE2022040612371851193/detail/menueditor_item_c426b3f7013b4a3da0f6000f5af9efe9_1649248588985392335.webp','8.000',4),(16,'Teh Poci Leci','Leci','https://d1sag4ddilekf6.cloudfront.net/compressed_webp/items/IDITE20220112042843070271/detail/menueditor_item_bacaf9093f4544119d1f25eca01c4d1e_1654049515607584226.webp','7.000',4),(17,'Teh Poci Susu Coklat','Susu kental Manis Coklat','https://media-cdn.yummyadvisor.com/store/7f4d9d3c-9eb9-4c55-a0d3-a241e95a3079.jpeg?x-oss-process=style/type_15','8.000',4),(18,'Teh Poci Thai tea','Thai tea','data:image/jpeg;base64,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','10.000',4),(19,'Teh Poci Taro','Taro','https://d1sag4ddilekf6.cloudfront.net/compressed_webp/items/IDITE2022040702451311561/detail/menueditor_item_ae4b529299934e80ae6c9ea7e836220a_1649299490233927984.webp','10.000',4),(20,'Extra Jelly','Jelly','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa4hBM8co9tIfWHSqfU74NZ-LG-C8yGGZ5nQ&usqp=CAU','3.000',4),(21,'Kopi Susu','Coffee, Milk, Cream','https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//101/MTA-5948308/kopi_janji_jiwa_es_kopi_susu_full02_o0s6niie.jpg','18.000',5),(22,'Kopi Gula aren','Coffee, Milk, Gula Aren','https://d1sag4ddilekf6.cloudfront.net/compressed_webp/items/IDITE20221113141018325148/detail/721a5f96ddb543c5900056614c45d5a0_1668348618330765170.webp','20.000',5),(23,'Earl Grey Tea','Teh Earl Grey','https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//108/MTA-8196966/kopi_janji_jiwa_earl_grey_tea_full01_mdsdzp8.jpg','15.000',5),(24,'Yogurt Yuzu','Yuzu','https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//103/MTA-4849950/kopi_janji_jiwa_es_yoghurt_yuzu_full02_hwtymwaq.jpg','20.000',5),(25,'Susu Coklat','Choco Milk','https://d1sag4ddilekf6.cloudfront.net/compressed_webp/items/IDITE20221113141154809095/detail/99644723b374411fb7e890b09a8d08be_1668348714722226367.webp','18.000',5),(26,'Kopi Dolce','Dolce Coffee','https://i0.wp.com/i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/ddcc565b-9e41-4e55-85ce-8ad3914b3ab0_menu-item-image_1637038176036.jpg?resize=728%2C500','22.000',5),(27,'Milo Latte','Milo','https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//95/MTA-8217067/kopi-janji-jiwa_kopi-janji-jiwa_full01.jpg','22.000',5),(28,'Chizu Red Velvet','Red Velvet, Cream, Milk','https://images.tokopedia.net/img/cache/500-square/VqbcmM/2021/7/7/95bc94d5-b09b-4bda-8037-77360ea8ad5e.jpg','22.000',6),(29,'Chizu Taro','Taro, Cream, Milk','https://images.tokopedia.net/img/cache/700/VqbcmM/2021/7/7/d2591295-f69f-43f8-a6f2-fbda715c71e3.jpg','22.000',6),(30,'Chizu Avocado','Avocado, Cream, Milk','https://www.yakurir.com/uploads/barang/21.08-09.50.12-es-teh-chizu-avocado-large.jpg','22.000',6),(31,'Brown Sugar','Brown Sugar, Milk','data:image/jpeg;base64,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','20.000',6),(32,'Lemonade','Lemon, Soda','https://images.tokopedia.net/img/JFrBQq/2022/9/14/effbeacb-9109-4a50-8f1b-e939972e02d0.jpg','18.000',6),(33,'Lychee Tea','Lychee Syrup, Tea','https://images.tokopedia.net/img/JFrBQq/2022/9/14/326ee2c2-78e8-4086-9b00-49636a9e0af7.jpg','15.000',6),(34,'Lemon Tea','Lemon Syrup, Tea','https://images.tokopedia.net/img/cache/700/VqbcmM/2021/7/7/b2a1e55b-5c18-4148-a74a-5eea5408bf43.jpg','15.000',6),(35,'Caramel Coffee','Coffee, Sugar, Milk, Caramel Syrup','https://www.forkinthekitchen.com/wp-content/uploads/2022/06/220518.homemade.caramel.latte-6630.jpg',NULL,2);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resto`
--

DROP TABLE IF EXISTS `resto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(200) DEFAULT NULL,
  `jambukatutup` varchar(50) DEFAULT NULL,
  `jarak` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `photourl` text,
  `typefood` varchar(100) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resto`
--

LOCK TABLES `resto` WRITE;
/*!40000 ALTER TABLE `resto` DISABLE KEYS */;
INSERT INTO `resto` VALUES (1,'Kebab Turki','10.00 am - 08.00 pm','1.3  km','Jl.Rungkut Mejoyo Utara No. 45','https://babarafi.co.id/wp-content/uploads/2021/09/fdhg.png','Turki Food','Kebab Turki didirikan pada tahun 2000 dan mempunyai beberapa cabang di Indonesia. '),(2,'Titik Koma','09.00 am - 10.00 pm','0.3 km','Jl.Tenggilis No. 5','https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiuYnL5dKVQxDX_l9oO9wqChBblwi1BQT61R4VPq1tgIxDwPbuUf5RKqM269a7eX-DX7-FOOTldLh2KsWrw7j0qF-OaUZWy4pQv_wNutCoYn_ilKz3EMZE7GE4hm25tSlqZTRATUM2pRs67zkDH8SMve_cvUI9KKvrEtPwPio21jkY9fJW7GgWr3cz_/s1350/kopi-titik-koma-surabaya-harga-menu-dan-lokasi.jpg','Western Food & Drink','Titik koma merupakan cafe yag sudah memiliki beberapa cabang di Surabaya. Salah satunya disini Jl.Tenggilis No.5'),(3,'Bakso pak Uun','08.00 am - 06.00 pm','0.2 km','Jl.Rungkut Mejoyo Selatan II No.18','https://wisatakulinerindonesia.files.wordpress.com/2010/06/img00691-20100605-14261.jpg','Asia Food','Bakso pak uun menjual bakso dengan pilihan urat, halus, kasar, tahu, dan goreng.'),(4,'Teh Poci','10.00 am - 06.00 pm','0.1 km','Jl. Tenggilis Mejoyo No. 2','https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi5vYnzCsv3JEPGUTxrP1mJZDJSlMJ6oPJFG7D5-C-pSeChvGYtdsN-GHLLiXJFFdJFvAquYTlsekpO2Ut-DgznUnD61R4HwlVKe_FMgatTKZ4g2w0KG357x4vR5mXvr12nLG6QuQ6K2DuAF_BrQshVrJs5_jAMbd2jqj90MDaN-dTIuBnBAdIHLgoa9w/s600/LOWONGAN%20KERJA%20TEH%20POCI%20KAMPUS%20UBAYA%20SURABAYA.jpg','Drink','Teh poci memiliki banyak coabang di Indonesia. Salah satunya buka di Jl. Tenggilis Mejoyo No. 2 seberang UBAYA.'),(5,'Janji Jiwa','09.00 am - 10.00 pm','0.6 km','Jl. Tenggilis Mejoyo No.75','https://assets-pergikuliner.com/YuCn6jGNLm2Wa_Z5Ows9TFnFQVE=/332x0/smart/https://assets-pergikuliner.com/uploads/image/picture/1255561/picture-1549332595.jpg','Drink','Janji jiwa memiliki beberapa cabang di Indonesia. Di Surabaya janji jiwa memiliki hampir sekitar 50 lebih cabang. Salah satunya disini dengan jarak 0.6 km dari UBAYA. Siswa dapat bersantai sambil mengerjakan tugas kuliah maupun nongkrong bareng teman.'),(6,'Es Teh Indonesia','10.00 am - 10.00 pm','1.2 km','Jl. Tenggilis Mejoyo No. 112','https://brandwazh.com/wp-content/uploads/2022/11/aWNZykEL1qhpLNZKHQ30BiFt4VncH1.jpg','Drink','Es Teh Indonesia memiliki 100++ cabang di Indonesia. Es Teh Indonesia ini menjual beberapa pilihan menu teh yang beragam seperti taro, red velvet, lychee, oreo, teh original, dan lainnya.');
/*!40000 ALTER TABLE `resto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `bintang` varchar(10) DEFAULT NULL,
  `tanggal` varchar(45) DEFAULT NULL,
  `comment` text,
  `resto_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reviews_resto_idx` (`resto_id`),
  CONSTRAINT `fk_reviews_resto` FOREIGN KEY (`resto_id`) REFERENCES `resto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,'michelle','5','22-04-2023','kebabnya best!!',1),(2,'jennie','4.6','02-05-2023','mantap bakal beli lagi',1),(3,'steve','4.5','21-03-2023','Juara sih minumannya',2),(4,'sisca','5','06-04-2023','The besttttt',3),(5,'kiki','4','20-03-2023','pelayanannya agak lama',5),(6,'sally','4.2','01-05-2023','Es teh leci nya sih enak',6),(7,'lilac','4.8','04-05-2023','Mantap is the best sih..',4),(8,'vivi','3.5','05-05-2023','kurang sih menurutku, lebih ditingkatkan lagi',3),(9,'celine','4.7','04-05-2023','suka poll',6),(10,'velita','4','22-04-2023','Mntabbb',5),(11,'gaby','4.5','01-05-2023','Kopi susu is the best!',5),(12,'billy','4.2','07-05-2023','makanannya lumayan mahal',2),(13,'sesil','5','08-05-2023','wawwwwwwwwwwww topp',1);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-10 22:04:17
