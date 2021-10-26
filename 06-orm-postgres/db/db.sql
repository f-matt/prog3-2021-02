-- Criação do usuário tmp
CREATE USER tmp WITH PASSWORD '123456';

CREATE DATABASE tmp WITH OWNER tmp;


-- Após conectar ao banco com o usuário tmp
CREATE TABLE contatos (
	id SERIAL,
	nome CHARACTER VARYING (32),
	email_principal CHARACTER VARYING (32),
	telefone CHARACTER VARYING (16),
	PRIMARY KEY (id)
);
