CREATE TABLE `test`.`employees` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `LAST_NAME` VARCHAR(45) NULL,
  `EMAIL` VARCHAR(45) NULL,
  `DEPT_ID` INT NULL,
  PRIMARY KEY (`ID`));
  
INSERT INTO `test`.`employees` (`LAST_NAME`, `EMAIL`, `DEPT_ID`) VALUES ('Tom', 'tom@163.com', '1');
INSERT INTO `test`.`employees` (`LAST_NAME`, `EMAIL`, `DEPT_ID`) VALUES ('Jerry', 'jerry@126.com', '2');
INSERT INTO `test`.`employees` (`LAST_NAME`, `EMAIL`, `DEPT_ID`) VALUES ('Mike', 'mike@sohu.com', '3');
INSERT INTO `test`.`employees` (`LAST_NAME`, `EMAIL`, `DEPT_ID`) VALUES ('Rose', 'rose@sina.com', '3');
INSERT INTO `test`.`employees` (`LAST_NAME`, `EMAIL`, `DEPT_ID`) VALUES ('wz', 'wz@163.com', '2');

CREATE TABLE `test`.`departments` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DEPT_NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));

  
INSERT INTO `test`.`departments` (`DEPT_NAME`) VALUES ('财务部');
INSERT INTO `test`.`departments` (`DEPT_NAME`) VALUES ('开发部');
INSERT INTO `test`.`departments` (`DEPT_NAME`) VALUES ('人事部');
INSERT INTO `test`.`departments` (`DEPT_NAME`) VALUES ('公关部');
  