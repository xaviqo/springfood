CREATE OR REPLACE FUNCTION FUN_recalculateTotals() RETURNS TRIGGER AS $$

	DECLARE
		productPrice INTEGER := 0;
	BEGIN
	
		--GET PRODUCT PRICE
		SELECT price INTO productPrice FROM sc_springfood.product pro
		WHERE pro.id = NEW.product;
		
		--DO MATHS AND UPDATE NEW.*
		NEW.total = (productPrice*NEW.amount);
		NEW.total_sale = NEW.total - (NEW.total*NEW.line_sale/100);
		
		--UPDATE MAIN ORDER
		UPDATE sc_springfood.order 
		SET total = total + NEW.total_sale
		WHERE id = NEW.order;
		
		RAISE NOTICE 'TOTAL CON DTO: % TOTAL SIN DTO: %',NEW.total_sale,NEW.total;
		
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER TRG_recalculateTotals BEFORE INSERT ON sc_springfood.order_line
FOR EACH ROW
EXECUTE PROCEDURE FUN_recalculateTotals();

CREATE OR REPLACE FUNCTION FUN_updateStock() RETURNS TRIGGER AS $$
	DECLARE
		prodStock INTEGER;
	BEGIN
		--GET PRODUCT STOCK
		SELECT stock INTO prodStock FROM sc_springfood.product pro
		WHERE pro.id = NEW.product;
		
		IF (prodStock >= NEW.amount) THEN
			UPDATE sc_springfood.product 
			SET stock = stock - NEW.amount
			WHERE id = NEW.product;
		END IF;
		
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION FUN_updateLineCount() RETURNS TRIGGER AS $$
	DECLARE
		countLines SMALLINT;
	BEGIN
		SELECT count(1) INTO countLines FROM sc_springfood.order_line
		WHERE orderid = NEW.orderid;
		
		UPDATE sc_springfood.orders 
		SET line_count = countLines
		WHERE id = NEW.orderid;
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER TRG_updateLineCount AFTER INSERT ON sc_springfood.order_line
FOR EACH ROW
EXECUTE PROCEDURE FUN_updateLineCount();
