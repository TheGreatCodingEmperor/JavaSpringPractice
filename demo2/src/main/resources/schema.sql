CREATE TABLE PUBLIC.COMPANY (
ID INTEGER NOT NULL,
NAME VARCHAR(30),
TEL VARCHAR(30),
CONSTRAINT COMPANY_PK PRIMARY KEY (ID)
);

CREATE TABLE PUBLIC.STAFF (
ID INTEGER NOT NULL AUTO_INCREMENT,
NAME VARCHAR(30),
ACCOUNT VARCHAR(30),
CONSTRAINT STAFF_PK PRIMARY KEY (ID)
);

CREATE TABLE PUBLIC.PRODUCT (
ID INTEGER NOT NULL AUTO_INCREMENT,
NAME VARCHAR(30),
PRICE DOUBLE,
CONSTRAINT PRODUCT_PK PRIMARY KEY (ID)
);