CREATE TABLE sc_springfood.city (
    postal character varying(5) PRIMARY KEY,
    name character varying(40) NOT NULL
);

CREATE TABLE sc_springfood.product (
    product_id integer PRIMARY KEY,
    name character varying(40) NOT NULL,
    description character varying,
    type character varying(40),
    stock integer DEFAULT 0,
    price numeric(6,2) DEFAULT 0,
    active boolean DEFAULT false
);

);CREATE TABLE sc_springfood.customer (
    account integer PRIMARY KEY,
    name character varying(40) NOT NULL,
    phone character varying(40) NOT NULL,
    city character varying(5) NOT NULL,
    street character varying(40) NOT NULL,
	CONSTRAINT fk_account FOREIGN KEY(account) 
	REFERENCES sc_springfood.account (account_id),
	CONSTRAINT fk_customercity FOREIGN KEY(city)
	REFERENCES sc_springfood.city(postal)
);

CREATE TABLE sc_springfood.purchase (
    purchase_id integer PRIMARY KEY,
    customer integer NOT NULL,
    date timestamp without time zone NOT NULL,
    discount smallint DEFAULT 0,
    total numeric(6,2) DEFAULT 0,
    is_delivered boolean DEFAULT false NOT NULL,
	CONSTRAINT fk_customer FOREIGN KEY(customer) 
	REFERENCES sc_springfood.customer(account)
	);

CREATE TABLE sc_springfood.purchase_line (
    line_id integer PRIMARY KEY,
    purchase integer NOT NULL,
    product integer NOT NULL,
    amount smallint NOT NULL,
    line_discount smallint DEFAULT 0,
    total_line numeric(6,2) NOT NULL,
	CONSTRAINT fk_pl_purchase FOREIGN KEY(purchase)
	REFERENCES sc_springfood.purchase(purchase_id),
	CONSTRAINT fk_pl_product FOREIGN KEY(product)
	REFERENCES sc_springfood.product(product_id)
);

