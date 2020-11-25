/* CREATE DATABASE*/

Create database OnlineTour;

/* CREATE USER TABLE*/
CREATE TABLE user(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30),
email VARCHAR(30) UNIQUE KEY,
password VARCHAR(30),
dob DATE,phone CHAR(10)
);

/* CREATE AGENT TABLE*/

CREATE TABLE agent(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30),
email VARCHAR(30) UNIQUE KEY,
password VARCHAR(30),
age INT(11),
phone VARCHAR(10),
shop_name VARCHAR(50),
shop_address VARCHAR(50),
image VARCHAR(50)
);

/*RequestTourTable  */

CREATE TABLE requestTour(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
agent_id INT(11) ,
image VARCHAR(50),
shop_name VARCHAR(30),
tour_name VARCHAR(30),
place VARCHAR(30),
city VARCHAR(30),
pincode VARCHAR(30),
day VARCHAR(30),
price FLOAT,
hotel_name VARCHAR(30),
hotel_address VARCHAR(50),
hotel_pincode VARCHAR(10),
hotel_manager VARCHAR(30),
hotel_phone VARCHAR(10),
description VARCHAR(1000),
FOREIGN KEY(agent_id) REFERENCES agent(id)
);

/*TourTable  */
CREATE TABLE tour(
tour_id INT(11) PRIMARY KEY AUTO_INCREMENT,
agent_id INT(11) ,
image VARCHAR(50),
tour_name VARCHAR(30),
place VARCHAR(30),
city VARCHAR(30),
pincode VARCHAR(30),
day VARCHAR(30),
price FLOAT,
hotel_name VARCHAR(30),
hotel_address VARCHAR(50),
hotel_pincode VARCHAR(10),
hotel_manager VARCHAR(30),
hotel_phone VARCHAR(10),
description VARCHAR(1000),
FOREIGN KEY(agent_id) REFERENCES agent(id)
);

/*View_Agent_tour*/
CREATE VIEW Agent_Tour_View AS
SELECT agent.id,name,shop_name,email,phone,shop_address,
tour.tour_id,image,tour_name,place,city,pincode,day,price,hotel_name,hotel_address,hotel_pincode,hotel_manager,hotel_phone,description
FROM agent, tour
WHERE  agent.id = tour.agent_id;



/*CREATE TABLE BOOKING*/

CREATE table booking(
booking_id INT(11) PRIMARY KEY AUTO_INCREMENT,
tourID INT(11),
userId INT(11),
total_member INT(11),
child INT(11),
adult INT(11),
citizen INT(11),
FOREIGN KEY(tourID) REFERENCES tour(tour_id),
FOREIGN KEY(userId) REFERENCES user(id)
);


/*CREATE TABLE PAYMENT*/
CREATE TABLE payment(
payId INT(11) PRIMARY KEY AUTO_INCREMENT,
userId INT(11),
tourId INT(11),
amount FLOAT(11),
paymentType VARCHAR(30),
FOREIGN KEY(userId) REFERENCES user(id),
FOREIGN KEY(tourId) REFERENCES tour(tour_id)
);