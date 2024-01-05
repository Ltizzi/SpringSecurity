create database easybank;

use easybank;

CREATE TABLE `users`(
`id` INT NOT NULL, AUTO_INCREMENT,
`username` VARCHAR(45) NOT NULL,
`password` VARCHAR(45) NOT NULL,
`enable` INT NOT NULL,
PRIMARY KEY(`id`));


CREATE TABLE `authorities`(
`id` INT NOT NULL, AUTO_INCREMENT,
`username` VARCHAR(45) NOT NULL,
`authorities` VARCHAR(45) NOT NULL,
PRIMARY KEY(`id`));

CREATE TABLE `customers`(
`id` INT NOT NULL, AUTO_INCREMENT,
`email` VARCHAR(45) NOT NULL,
`pwd` VARCHAR(200) NOT NULL,
`role` VARCHAR(45) NOT NULL,
PRIMARY KEY(`id`));

INSERT IGNORE INTO `users` VALUES (NULL, `ltizzi`, `123`, `1`);
INSERT IGNORE INTO `authorities` VALUES (NULL, `ltizzi`, `write`);
INSERT INTO `customers` VALUES(NULL, `caca@caca.com`, `123`, `admin`);