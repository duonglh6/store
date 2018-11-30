SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS role_user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user;




/* Create Tables */

CREATE TABLE role
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(50),
	description varchar(100),
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8;


CREATE TABLE role_user
(
	-- identity of user
	user_id int NOT NULL COMMENT 'identity of user',
	role_id int NOT NULL,
	id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8;


CREATE TABLE user
(
	-- identity of user
	id int NOT NULL AUTO_INCREMENT COMMENT 'identity of user',
	username varchar(50) NOT NULL,
	password varchar(50) NOT NULL,
	fullname varchar(100),
	email varchar(100),
	enabled int,
	created_date date,
	created_by varchar(50),
	modified_date date,
	modified_by varchar(50),
	password_change_date date,
	account_status int,
	PRIMARY KEY (id),
	UNIQUE (username),
	UNIQUE (email)
) DEFAULT CHARACTER SET utf8;



/* Create Foreign Keys */

ALTER TABLE role_user
	ADD FOREIGN KEY (role_id)
	REFERENCES role (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE role_user
	ADD FOREIGN KEY (user_id)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



