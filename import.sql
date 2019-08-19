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


INSERT INTO categories VALUES (100,'All Home and Kitchen','');
INSERT INTO categories VALUES (101,'Furniture & Decor','');
INSERT INTO categories VALUES (102,'Home Appliances','');
INSERT INTO categories VALUES (103,'Small Appliances','');
INSERT INTO categories VALUES (109,'Arts, Crafts & Sewing','');
INSERT INTO categories VALUES (113,'Watches and gold','');
INSERT INTO categories VALUES (116,'Camera & Photo','');
INSERT INTO categories VALUES (117,'Computers & Tablets Accessories','');
INSERT INTO categories VALUES (120,'Home & Portable Audio','');
INSERT INTO categories VALUES (126,'Tablets','');
INSERT INTO categories VALUES (127,'Laptops','');
INSERT INTO categories VALUES (128,'Monitors','');
INSERT INTO categories VALUES (129,'Desktops','');
INSERT INTO categories VALUES (130,'Hard Drives & Storage','');
INSERT INTO categories VALUES (131,'Accessories & Peripherals','');
INSERT INTO categories VALUES (132,'PC Components','');
INSERT INTO categories VALUES (133,'PC Gaming','');
INSERT INTO categories VALUES (150,'Hunting & Fishing','');
INSERT INTO categories VALUES (151,'Winter Sports','');
INSERT INTO categories VALUES (152,'Action Sports','');
INSERT INTO categories VALUES (153,'Cycling','');
INSERT INTO categories VALUES (200,'Motorcar','');
INSERT INTO categories VALUES (201,'test','test category');

INSERT INTO productimagepath VALUES (1000,'resources/images/ecommerce/ASUS Transformer Book.jpg');
INSERT INTO productimagepath VALUES (1001,'resources/images/ecommerce/HP Stream 14-Inch Notebook.jpg');
INSERT INTO productimagepath VALUES (1002,'resources/images/ecommerce/Acer Chromebook, Intel Celeron Processor N2830.jpg');
INSERT INTO productimagepath VALUES (1003,'resources/images/ecommerce/ASUS VX7SX-DH71.jpg');
INSERT INTO productimagepath VALUES (1004,'resources/images/ecommerce/HP Pavilion x2 11-h010ca.jpg');
INSERT INTO productimagepath VALUES (1005,'resources/images/ecommerce/Samsung Galaxy Tab 4 7-inch Black.jpg');
INSERT INTO productimagepath VALUES (1006,'resources/images/ecommerce/Apple iPad with Retina Display.jpg');
INSERT INTO productimagepath VALUES (1007,'resources/images/ecommerce/Acer Iconia 7-Inch HD Tablet with Intel Atom processor.jpg');
INSERT INTO productimagepath VALUES (1008,'resources/images/ecommerce/BenQ 24-inch LED 1ms Gaming Console Monitor with 2x HDMI.jpg');
INSERT INTO productimagepath VALUES (1009,'resources/images/ecommerce/ASUS 15.6 HD Intel Dual-Core Laptop.jpg');
INSERT INTO productimagepath VALUES (1009,'resources/images/ecommerce/ASUS 15.6 inches HD Intel Dual-Core Laptop.jpg');
INSERT INTO productimagepath VALUES (1010,'resources/images/ecommerce/BenQ 24-inch LED 1ms Gaming Console Monitor with 2x HDMI.jpg');
INSERT INTO productimagepath VALUES (1010,'resources/images/ecommerce/BenQ 24-inch LED Monitor, 2ms, HDMI.jpg');


INSERT INTO products VALUES (1000,127,'QE54RD34','ASUS Transformer Book 10.1 inch',799.99,7,'10.1 inch','Free MS Office 365 Personal 1 year included.');
INSERT INTO products VALUES (1001,127,'WA67SE39','HP Stream 14-Inch Notebook',418.63,5,'14-Inch','AMD A4 Micro-6400T Quad-Core 4.5W APU (1.0GHZ, 2MB L2 DDR3L-1333MHZ)');
INSERT INTO products VALUES (1002,127,'PY86RF7D','Acer Chromebook, Intel Celeron',329.99,6,'Chromebook','2 GB DDR3 Memory, 16 GB SSD Laptop.');
INSERT INTO products VALUES (1003,127,'VX7SX-DH71','ASUS VX7SX-DH71 ',2299.00,3,'15.6-Inch','16GB DDR3, 4 slots, 16GB Max, 1.5TB Hard Drive 7200RPM,');
INSERT INTO products VALUES (1004,127,'x2 11-h010ca','HP Pavilion Noteboo',649.99,12,'11.6-Inch','Pentium N3510,  - Intel Pentium N3510 with Intel HD Graphics');
INSERT INTO products VALUES (1005,126,'Fs98HY','Samsung Galaxy Tab 4 7-inch',315.49,20,'Tab 4','Android 4.4 Kit Kat OS, 1.2 GHz quad-core Qualcomm processor');
INSERT INTO products VALUES (1006,126,'MD510LL/A','Apple iPad with Retina Display',649.99,23,'9.7 Retina','9.7 Retina Display; 2048 x 1536 Resolution');
INSERT INTO products VALUES (1007,126,'UE64RF21','Acer Iconia 7-Inch HD Tablet',139.95,32,'7-Inch','Acer Iconia 7-Inch HD Tablet with Intel Atom processor');
INSERT INTO products VALUES (1008,128,'RL2455HM','24-inch LED Gaming Console Monitor',219.99,9,'BenQ','BenQ 24-inch LED 1ms Gaming Console Monitor');                                                                                                               
INSERT INTO products VALUES (1009,127,'16GBDDR3','ASUS DUAL-Core Intel Laptop',374.99,42,'16-inch','ASUS  HD Intel Dual-Core Laptop 2.16GHz, 4GB RAM');
INSERT INTO products VALUES (1010,128,'GL2460HM','BenQ 24-inch LED Monitor',273.89,35,'24-inch','BenQ  LED Monitor, 2ms, HDMI (GL2460HM) by BenQ ');

