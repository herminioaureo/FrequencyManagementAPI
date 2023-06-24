CREATE TABLE `frequencydb`.`company` (
  `idcompany` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `segment` VARCHAR(45) NOT NULL,
  `uuid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcompany`));
  
CREATE TABLE `frequencydb`.`employee` (
  `idemployee` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `uuid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idemployee`));
  
CREATE TABLE `frequencydb`.`frequency` (
  `idfrequency` INT NOT NULL AUTO_INCREMENT,
  `dateTime` DATETIME NOT NULL,
  `uuid` VARCHAR(45) NOT NULL,
  `idcompany` INT NOT NULL,
  `idemployee` INT NOT NULL,
  PRIMARY KEY (`idfrequency`),
  INDEX `fk_employee_idx` (`idemployee` ASC) VISIBLE,
  INDEX `fk_company_idx` (`idcompany` ASC) VISIBLE,
  CONSTRAINT `fk_employee`
    FOREIGN KEY (`idemployee`)
    REFERENCES `frequencydb`.`employee` (`idemployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_company`
    FOREIGN KEY (`idcompany`)
    REFERENCES `frequencydb`.`company` (`idcompany`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `frequencydb`.`employee`
VALUES ('1', 'Michael Scott', 'Regional Manager', '1111');

INSERT INTO `frequencydb`.`employee`
VALUES ('2', 'Dwight Schrute', 'Assistant of Regional Manager', '2222');