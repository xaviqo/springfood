CREATE OR REPLACE FUNCTION FUN_recalculateTotals() RETURNS TRIGGER AS $$

	DECLARE
		productPrice INTEGER := 0;
	BEGIN
	
		--GET PRODUCT PRICE
		SELECT price INTO productPrice FROM sc_springfood.product pro
		WHERE pro.product_id = NEW.product;
		
		--DO MATHS AND UPDATE NEW.*
		NEW.total_line = (productPrice*NEW.amount);
		
		--UPDATE MAIN ORDER
		UPDATE sc_springfood.purchase 
		SET total = total + NEW.total_line
		WHERE purchase_id = NEW.purchase;
		
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER TRG_recalculateTotals BEFORE INSERT ON sc_springfood.purchase_line
FOR EACH ROW
EXECUTE PROCEDURE FUN_recalculateTotals();

CREATE OR REPLACE FUNCTION FUN_updateStock() RETURNS TRIGGER AS $$
	DECLARE
		prodStock INTEGER;
	BEGIN
		--GET PRODUCT STOCK
		SELECT stock INTO prodStock FROM sc_springfood.product pro
		WHERE pro.product_id = NEW.product;
		
		IF (prodStock >= NEW.amount) THEN
			UPDATE sc_springfood.product 
			SET stock = stock - NEW.amount
			WHERE product_id = NEW.product;
		END IF;
		
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER TRG_updateStock AFTER INSERT ON sc_springfood.purchase_line
FOR EACH ROW
EXECUTE PROCEDURE FUN_updateStock();


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
