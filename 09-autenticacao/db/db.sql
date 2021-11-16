CREATE USER auth WITH PASSWORD '123456';

CREATE DATABASE auth WITH OWNER auth;

CREATE EXTENSION pgcrypto;

CREATE TABLE users (
	id SERIAL,
	login VARCHAR (256) NOT NULL,
	password VARCHAR (256) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE groups (
	id SERIAL,
	"group" VARCHAR(32) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE users_groups (
	user_id INTEGER,
	group_id INTEGER,
	PRIMARY KEY (user_id, group_id),
	FOREIGN KEY (user_id) REFERENCES users (id),
	FOREIGN KEY (group_id) REFERENCES groups (id)
);

INSERT INTO groups ("group") VALUES ('USER'), ('ADMIN');
INSERT INTO users (login, password) VALUES ('user', encode(digest('123456', 'sha256'), 'base64'));
INSERT INTO users (login, password) VALUES ('admin', encode(digest('123456', 'sha256'), 'base64'));
INSERT INTO users_groups (user_id, group_id) VALUES (1, 1), (2, 2);
