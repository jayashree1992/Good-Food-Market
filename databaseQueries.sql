CREATE TABLE category(

	id int NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,

	CONSTRAINT pk_category_id PRIMARY KEY (id)

);

INSERT INTO category(name,description,image_url,is_active) VALUES ('Mobile', 'This is desc','abc.png',true);




CREATE TABLE person_user(
	id int NOT NULL AUTO_INCREMENT,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contactnumber VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
	);
	
INSERT INTO person_user (firstname,lastname,role,enabled,password,email,contactnumber) 
VALUES ('Jayashree','Patel','ADMIN',true,'123456','jayashreepatel@gmail.com','8675467892'); 

	
INSERT INTO person_user (firstname,lastname,role,enabled,password,email,contactnumber) 
VALUES ('Bhavesh','Premji','SUPPLIER',true,'123456','bhaveshpremji@gmail.com','6172345678'); 

	
INSERT INTO person_user (firstname,lastname,role,enabled,password,email,contactnumber) 
VALUES ('Sneha','Shah','SUPPLIER',true,'123456','snehashah@gmail.com','8576843853'); 


CREATE TABLE item(
	id int NOT NULL AUTO_INCREMENT,
	itemcode VARCHAR(20),
	name VARCHAR(50),
	brandname VARCHAR(50),
	description VARCHAR(255),
	perunitprice DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	sold INT default 0,
	no_of_people_viewed INT default 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES person_user(id)
	);
	
	
INSERT INTO item (itemcode,name,brandname,description,perunitprice,quantity,is_active,category_id, supplier_id)	
VALUES('ITM1234567890','Milk','Hood','This is fresh whole milk','5','5',true,1,2);

INSERT INTO item (itemcode,name,brandname,description,perunitprice,quantity,is_active,category_id, supplier_id)	
VALUES('ITM1234567567','Banana','Chipotle','This is reipe banama','2','3',true,2,3);

INSERT INTO item (itemcode,name,brandname,description,perunitprice,quantity,is_active,category_id, supplier_id)	
VALUES('ITM1234567786','Potato Chips','Lays','These are crispy chips','3','7',true,3,2);

INSERT INTO item (itemcode,name,brandname,description,perunitprice,quantity,is_active,category_id, supplier_id)	
VALUES('ITM1234567876','Cheese','Amul','This is white cheese','8','12',true,1,1);



CREATE TABLE cart_detail (
	id INT AUTO_INCREMENT,
	cart_id int,
	total DECIMAL(10,2),
	item_id int,
	item_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartdetail_item_id FOREIGN KEY (item_id ) REFERENCES item (id),
	CONSTRAINT pk_cartdetail_id PRIMARY KEY (id)
);

	