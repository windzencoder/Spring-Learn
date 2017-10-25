CREATE TABLE `test`.`book` (
  `isbn` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(45) NULL,
  `price` INT NULL,
  PRIMARY KEY (`isbn`));
alter table book AUTO_INCREMENT=1001;


INSERT INTO `test`.`book` (`book_name`, `price`) VALUES ('Java', '100');
INSERT INTO `test`.`book` (`book_name`, `price`) VALUES ('Oracle', '70');
  


CREATE TABLE `test`.`account` (
  `username` VARCHAR(45) NOT NULL,
  `balance` INT NULL,
  PRIMARY KEY (`username`));

  
INSERT INTO `test`.`account` (`username`, `balance`) VALUES ('AA', '160');

CREATE TABLE `test`.`book_stock` (
  `isbn` INT NOT NULL,
  `stock` INT NULL,
  PRIMARY KEY (`isbn`));
  
  
INSERT INTO `test`.`book_stock` (`isbn`, `stock`) VALUES ('1001', '4');
INSERT INTO `test`.`book_stock` (`isbn`, `stock`) VALUES ('1002', '8');