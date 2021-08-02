-- DROP SCHEMA bank;

CREATE SCHEMA bank AUTHORIZATION postgres;


-- bank.accounts definition

-- Drop table

-- DROP TABLE bank.accounts;

CREATE TABLE bank.accounts (
	id int8 NOT NULL,
	"name" varchar NOT NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	amount float8 NOT NULL,
	CONSTRAINT accounts_pk PRIMARY KEY (username)
);

-- bank.transactions definition

-- Drop table

-- DROP TABLE bank.transactions;

CREATE TABLE bank.transactions (
	id int8 NOT NULL,
	reciever varchar NULL,
	sender varchar NULL,
	amount float8 NOT NULL,
	status varchar NOT NULL,
	"type" varchar NOT NULL,
	CONSTRAINT transactions_pk PRIMARY KEY (id)
);