create table products (
    PRODUCT_ID number not null,
    CATEGORY_ID number not null,
    SERIALNUMBER varchar(15) not null,
    PRODUCTNAME varchar(35) not null,
    PRODUCTPRICE number,
    STOCKQUANTITY number,
    SIZE varchar(15),
    DESCRIPTION varchar(100)
);

CREATE TABLE productimagepath (
  PRODUCT_ID number NOT NULL,
  IMAGEPATH varchar(100) NOT NULL
) ;

CREATE TABLE categories (
  CATEGORY_ID number NOT NULL,
  CATEGORYNAME varchar(40) NOT NULL,
  DESCRIPTION varchar(150) DEFAULT NULL
);


INSERT INTO categories VALUES (110,'Clothing & Accessories','');
INSERT INTO categories VALUES (111,'Shoes & Handbags','');
INSERT INTO categories VALUES (112,'Jewelry','');
INSERT INTO categories VALUES (113,'Watches and gold','');
INSERT INTO categories VALUES (114,'Luggage & Bags','');
INSERT INTO categories VALUES (116,'Camera & Photo','');
INSERT INTO categories VALUES (117,'Computers & Tablets Accessories','');
INSERT INTO categories VALUES (120,'Home & Portable Audio','');
INSERT INTO categories VALUES (126,'Tablets','');
INSERT INTO categories VALUES (127,'Laptops','');
INSERT INTO categories VALUES (128,'Monitors','');
INSERT INTO categories VALUES (129,'Desktops','');

INSERT INTO productimagepath VALUES (1000,'resources/images/ecommerce/ASUS Transformer Book.jpg');
INSERT INTO productimagepath VALUES (1001,'resources/images/ecommerce/HP Stream 14-Inch Notebook.jpg');
INSERT INTO productimagepath VALUES (1009,'resources/images/ecommerce/ASUS 15.6 inches HD Intel Dual-Core Laptop.jpg');
INSERT INTO productimagepath VALUES (1093,'resources/images/ecommerce/watch20.png');
INSERT INTO productimagepath VALUES (1094,'resources/images/ecommerce/watch30.png');
INSERT INTO productimagepath VALUES (1095,'resources/images/ecommerce/watch40.jpg');
INSERT INTO productimagepath VALUES (1096,'resources/images/ecommerce/Briefcase.jpg');
INSERT INTO productimagepath VALUES (1097,'resources/images/ecommerce/briefcase1.jpg');
INSERT INTO productimagepath VALUES (1098,'resources/images/ecommerce/briefcase2.jpg');
INSERT INTO productimagepath VALUES (1099,'resources/images/ecommerce/ShirtShoes.jpg');
INSERT INTO productimagepath VALUES (1100,'resources/images/ecommerce/shoes1.jpg');
INSERT INTO productimagepath VALUES (1101,'resources/images/ecommerce/shoes2.jpeg');
INSERT INTO productimagepath VALUES (1102,'resources/images/ecommerce/tie.png');
INSERT INTO productimagepath VALUES (1103,'resources/images/ecommerce/tie2.png');
INSERT INTO productimagepath VALUES (1104,'resources/images/ecommerce/tie3.jpg');

INSERT INTO products VALUES (1000,127,'QE54RD34','ASUS Transformer Book 10.1 inch',799.99,7,'10.1 inch','Free MS Office 365 Personal 1 year included.');
INSERT INTO products VALUES (1001,127,'WA67SE39','HP Stream 14-Inch Notebook',418.63,5,'14-Inch','AMD A4 Micro-6400T Quad-Core 4.5W APU (1.0GHZ, 2MB L2 DDR3L-1333MHZ)');
INSERT INTO products VALUES (1009,127,'16GBDDR3','ASUS DUAL-Core Intel Laptop',374.99,42,'16-inch','ASUS  HD Intel Dual-Core Laptop 2.16GHz, 4GB RAM');
INSERT INTO products VALUES (1093,113,'606792','Swiss Quartz Watch',1445.00,2,'Men','Sport Chrono Analog Display Swiss Quartz Silver Watch');
INSERT INTO products VALUES (1094,113,'241602','Maverick Bracelet Watch', 346.06,4,'Men','Maverick Stainless Steel Bracelet Watch with Blue Dial');
INSERT INTO products VALUES (1095,113,'606792','Analog Swiss Quartz Watch',745.00,6,'Men','Chrono Classic Analog Display Swiss Quartz Silver Watch');
INSERT INTO products VALUES (1096,114,'179000','Laptop Business Bag',197.99,2,'Men','Napa Briefcase Laptop Business Bag Black');
INSERT INTO products VALUES (1097,114,'179001','Professional Briefcase',179.99,2,'Men','Nappa Laptop Case Professional Briefcase Business Bag For Men');
INSERT INTO products VALUES (1098,114,'189990','Laptop Briefcase Bag',189.99,2,'Men','Messenger Bag for Laptop Briefcase Satchel Bag');
INSERT INTO products VALUES (1099,111,'255000','Kenneth Cole Shirt Shoes',255.00,2,'Men','Kenneth Cole Unlisted Men Half Time Oxford');
INSERT INTO products VALUES (1100,111,'4765000','Seattle Apron shoes',118.59,3,'large','Ecco Men Seattle Apron Toe Oxford');
INSERT INTO products VALUES (1101,111,'188000','Black Classic shoes',85.99,5,'medium','Santimon Oxford Shoes Men Brown Classic Lace Up');
INSERT INTO products VALUES (1102,110,'250000','Skinny Tie Necktie',25.00,7,'normal','Men Skinny Tie Necktie with Stripe Textured');
INSERT INTO products VALUES (1103,110,'145200','Classic Stripe Tie',41.00,2,'normal','HISDERN Plaid Tie Handkerchief Woven Classic Stripe Men Necktie & Pocket Squares');
INSERT INTO products VALUES (1104,110,'168900','Skinny Tie 2.4 inches',16.89,8,'Men','Elviros Mens Fashion Solid Color Skinny Tie 2.4 inches Honey');

