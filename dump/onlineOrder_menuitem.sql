-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: laiproject.ctfzbnbgtph7.us-east-2.rds.amazonaws.com    Database: onlineOrder
-- ------------------------------------------------------
-- Server version	8.0.20

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `menuitem`
--

DROP TABLE IF EXISTS `menuitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menuitem` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `restaurant_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKleb3sr7v2x4aoa6c8vivhi5qj` (`restaurant_id`),
  CONSTRAINT `FKleb3sr7v2x4aoa6c8vivhi5qj` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuitem`
--

LOCK TABLES `menuitem` WRITE;
/*!40000 ALTER TABLE `menuitem` DISABLE KEYS */;
INSERT INTO `menuitem` VALUES (1,'Made with white meat chicken, our Chicken Fries are coated in a light crispy breading seasoned with savory spices and herbs.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=300,format=auto,quality=50/https://cdn.doordash.com/media/photos/f439436f-c5ab-47af-bac4-7b73ab60a24b-retina-large.jpg','Chicken Fries - 9 Pc',4.89,1),(2,'Our Whopper Sandwich is a 1/4 lb* of savory flame-grilled beef topped with juicy tomatoes, fresh lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=300,format=auto,quality=50/https://cdn.doordash.com/media/photos/f878a689-618b-4c70-a00f-e7b1f320adc9-retina-large.jpg','Whopper Meal',10.59,1),(3,'Our Impossible™ Whopper Sandwich features a savory flame-grilled patty made from plants topped with juicy tomatoes, fresh lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/5c306a5f-fdd2-41d2-a660-9762aaa8eee8-retina-large.jpg','Impossible™ Whopper',7.99,1),(4,'Say hello to our HERSHEY’S® Sundae Pie. One part crunchy chocolate crust and one part chocolate crème filling, garnished with a delicious topping and real HERSHEY’S® Chocolate Chips','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/80b1670d-e9c0-4886-a5b7-1ad48edd24ca-retina-large.jpg','HERSHEY\'S® Sundae Pie',3.09,1),(5,'Our Whopper Sandwich is a 1/4 lb* of savory flame-grilled beef topped with juicy tomatoes, fresh lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/9b3d7985-e457-43b3-938d-5184f48c2687-retina-large-jpeg','Whopper',6.39,1),(6,'Our Double Whopper Sandwich is a pairing of two 1/4 lb* savory flame-grilled beef patties topped with juicy tomatoes, fresh lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/45addf4a-e8a8-47cb-a705-cce1d10ce86d-retina-large.jpg','Double Whopper Meal',11.69,1),(7,'Our Double Whopper Sandwich is a pairing of two 1/4 lb* savory flame-grilled beef patties topped with juicy tomatoes, fresh lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/31dd68c2-06ec-42ad-bcd4-da7bd3425437-retina-large-jpeg','Spicy Crispy Chicken Sandwich',6.09,1),(8,'Our Original Chicken Sandwich is lightly breaded and topped with a simple combination of shredded lettuce and creamy mayonnaise on a sesame seed bun','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/3e437f54-fa4e-4e9d-bf80-8a1e5b120f32-retina-large-jpeg','Original Chicken Sandwich',6.09,1),(9,'Our Bacon King Sandwich features two 1/4 lb* savory flame-grilled beef patties, topped a with hearty portion of thick-cut smoked bacon, melted American cheese and topped with ketchup and creamy mayonnaise all on a soft sesame seed bun.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/adb96c32-3c5b-4375-ba92-b30767d2513d-retina-large.jpg','Bacon King Sandwich Meal',12.19,1),(10,'Cool down with our creamy hand spun OREO® Shake.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/c3ad483f-bad7-44f1-96af-4c3dcfc63c6d-retina-large.jpg','Classic OREO® Shake',3.99,1),(11,'Tofu boiled with your choice of meat and mushrooms. Served with your choice of side and an assortment of kimchi dishes.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/b7055ca9-3caf-4d9d-9c99-04be1e36dbbf-retina-large-jpeg','Original Soft Tofu',17.06,2),(12,'Tofu boiled with beef, shrimp, and clams. Served with your choice of side and an assortment of kimchi dishes.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/37ad1974-1395-4e5c-86ff-fdf120cf8c58-retina-large-jpeg','Combination Soft Tofu',17.06,2),(13,'Tofu boiled with mussels, shrimp, and clam. Served with your choice of side and an assortment of kimchi dishes.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/96bc8289-1950-4b4f-823d-12f33349a5fe-retina-large-jpeg','Seafood Soft Tofu',17.06,2),(14,'Squid, clam, imitation crab, and grilled onions fried in batter.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/0a94b7e9-903d-49b7-937a-7940c8b56ad5-retina-large-jpeg','Seafood Pancake',20.27,2),(15,'Tofu boiled with kimchi and your choice of meat. Served with your choice of side and an assortment of kimchi dishes.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/0c062cff-1868-40e1-946d-29d3e46f1541-retina-large-jpeg','Kimchi Soft Tofu',17.06,2),(16,'Beef short ribs served with rice and an assortment of kimchi dishes.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/6340c369-2485-4d60-afcf-ca9068448d84-retina-large.jpg','Beef Short Ribs',29.36,2),(17,'Tofu boiled with dumplings, rice cake, and beef. Served with your choice of side and an assortment of kimchi dishes.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/b7055ca9-3caf-4d9d-9c99-04be1e36dbbf-retina-large-jpeg','Dumpling Soft Tofu',17.06,2),(18,'Tofu boiled with assorted mushrooms. Served with your choice of side and an assortment of kimchi dishes','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/b7055ca9-3caf-4d9d-9c99-04be1e36dbbf-retina-large-jpeg','Assorted Mushroom Tofu',17.06,2),(19,'Rice, BBQ beef, and vegetables served in stoneware with an assortment of kimchi dishes','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/9844dd4e-3c74-4942-8f90-2b3f4be25049-retina-large-jpeg','BBQ Beef & Vegetables in Stoneware',20.27,2),(20,'Tofu boiled with ham and cheese. Served with your choice of side and an assortment of kimchi dishes.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/9c6b2a1c-1e2c-4d80-a111-2bebbcadd64c-retina-large.jpg','Ham & Cheese Soft Tofu',17.06,2),(21,'Medium spicy.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/5b34852e-d253-461c-8be8-1bb0bc5e39be-retina-large.jpg','农家小炒肉Stir Fried Pork with Pepper',13.99,3),(22,'','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/bf70f262-0c55-41e1-89bc-84c061ae485f-retina-large.jpg','三味茄子Eggplant with Minced Pork, Garlic, Cilantro',14.99,3),(23,'Mild spicy.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/cb870c77-ace1-49ec-aa2f-9e18de102242-retina-large.jpg','大盆花菜Stir Fried Cauliflower with Pork',14.99,3),(24,'Mild spicy.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/1acf9c6b-189d-4583-a151-7ef522c283d9-retina-large.jpg','酸汤鱼片Poached Fish Fillets in Sour Soup',17.99,3),(25,'Very spicy.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/7f05859d-5e83-476d-a45a-73a3eb8a94e0-retina-large.jpg','小炒黄牛肉Stir Fried Beef with Pepper',16.99,3),(26,'Medium spicy.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/8b2ca9fc-2c1d-4bf2-96ff-d0bd3c415e8d-retina-large.jpg','武冈香干炒肚丝Stir Fried Shredded Tripe with Wugang Tofu',19.99,3),(27,'Very spicy.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/89ad8679-346e-41d8-b98f-3501fff4b277-retina-large.jpg','水煮牛肉Poached Sliced Beef in Hot Chili Oil',17.99,3),(28,'With chopped broccoli, peas, carrots, bok choy, egg.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/ec06c431-9426-4971-a129-920440e1c9ce-retina-large.jpg','Fried Rice炒饭',9.5,3),(29,'Very spicy.','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/2fe1b87f-d41f-4fa4-8cae-5f2ee5bb97e4-retina-large.jpg','擂辣椒茄子皮蛋Smashed Green Pepper, Chinese Eggplant & Preserved Egg',11.99,3),(30,'','https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1920,format=auto,quality=50/https://cdn.doordash.com/media/photos/a307e73d-dd12-4841-be14-6f5825a64c59-retina-large.jpg','蒜蓉油麦菜Stir Fried A-Choy with Minced Garlic',10.99,3);
/*!40000 ALTER TABLE `menuitem` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-09 21:53:34
