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


