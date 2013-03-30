SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `acal2` ;
CREATE SCHEMA IF NOT EXISTS `acal2` DEFAULT CHARACTER SET latin1 ;
USE `acal2` ;

-- -----------------------------------------------------
-- Table `acal2`.`taxa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`taxa` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`taxa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(255) NULL DEFAULT NULL ,
  `nome` VARCHAR(255) NOT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  `valor` DECIMAL(19,2) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`categoriasocio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`categoriasocio` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`categoriasocio` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descricao` TEXT NULL DEFAULT NULL ,
  `nome` VARCHAR(255) NOT NULL ,
  `taxa` FLOAT NOT NULL ,
  `taxasId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK9AEAD6E1EB06E4EA` (`taxasId` ASC) ,
  CONSTRAINT `FK9AEAD6E1EB06E4EA`
    FOREIGN KEY (`taxasId` )
    REFERENCES `acal2`.`taxa` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`motivodespesa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`motivodespesa` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`motivodespesa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `descricao` TEXT NOT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`endereco` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`endereco` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descricao` TEXT NULL DEFAULT NULL ,
  `nome` VARCHAR(255) NOT NULL ,
  `tipo` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`pessoa` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`pessoa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `apelido` VARCHAR(255) NULL DEFAULT NULL ,
  `bairro` VARCHAR(255) NULL DEFAULT NULL ,
  `categoriaSocio` INT(11) NULL DEFAULT NULL ,
  `cep` VARCHAR(255) NULL DEFAULT NULL ,
  `cidade` VARCHAR(255) NULL DEFAULT NULL ,
  `cpf` INT(11) NULL DEFAULT NULL ,
  `dataNasc` DATETIME NULL DEFAULT NULL ,
  `Email` VARCHAR(255) NULL DEFAULT NULL ,
  `nome` VARCHAR(255) NOT NULL ,
  `nomeMae` VARCHAR(255) NULL DEFAULT NULL ,
  `nomePai` VARCHAR(255) NULL DEFAULT NULL ,
  `numero` INT(11) NULL DEFAULT NULL ,
  `numeroMatricula` INT(11) NULL DEFAULT NULL ,
  `observacoes` TEXT NULL DEFAULT NULL ,
  `rgEmissao` DATE NULL DEFAULT NULL ,
  `rgExpedidor` VARCHAR(255) NULL DEFAULT NULL ,
  `rgNumero` INT(11) NULL DEFAULT NULL ,
  `sexo` VARCHAR(255) NULL DEFAULT NULL ,
  `sobrenome` VARCHAR(255) NOT NULL ,
  `status` BIT(1) NOT NULL ,
  `telefone` VARCHAR(255) NULL DEFAULT NULL ,
  `uf` VARCHAR(255) NULL DEFAULT NULL ,
  `idEndereco` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FKC4E40FA758EBBA0D` (`idEndereco` ASC) ,
  CONSTRAINT `FKC4E40FA758EBBA0D`
    FOREIGN KEY (`idEndereco` )
    REFERENCES `acal2`.`endereco` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`funcionario` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`funcionario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `cargo` VARCHAR(255) NOT NULL ,
  `dataContratacao` DATETIME NOT NULL ,
  `matricula` INT(11) NOT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  `salario` FLOAT NOT NULL ,
  `idPessoa` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK50401DDBA2F76C89` (`idPessoa` ASC) ,
  CONSTRAINT `FK50401DDBA2F76C89`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `acal2`.`pessoa` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`cheque`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`cheque` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`cheque` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `dataPagamento` DATETIME NULL DEFAULT NULL ,
  `dataVencimento` DATETIME NOT NULL ,
  `numero` INT(11) NOT NULL ,
  `observacoes` TEXT NULL DEFAULT NULL ,
  `valor` DECIMAL(10,2) NOT NULL ,
  `idFuncionario` INT(11) NOT NULL ,
  `idMotivoDespesa` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FKAED8F221893CFF1` (`idMotivoDespesa` ASC) ,
  INDEX `FKAED8F221B686FB5B` (`idFuncionario` ASC) ,
  CONSTRAINT `id_motivo_depesa`
    FOREIGN KEY (`idMotivoDespesa` )
    REFERENCES `acal2`.`motivodespesa` (`id` )
    ON UPDATE CASCADE,
  CONSTRAINT `id_funcionario`
    FOREIGN KEY (`idFuncionario` )
    REFERENCES `acal2`.`funcionario` (`id` )
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`chequeslog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`chequeslog` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`chequeslog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `idOriginal` INT(11) NULL DEFAULT NULL ,
  `dataPagamento` DATETIME NULL DEFAULT NULL ,
  `dataVencimento` DATETIME NULL DEFAULT NULL ,
  `dataAlteracao` DATETIME NULL DEFAULT NULL ,
  `numero` INT(11) NULL DEFAULT NULL ,
  `observacoes` TEXT NULL DEFAULT NULL ,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL ,
  `idFuncionarioAlteracao` INT(11) NULL DEFAULT NULL ,
  `tipo` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`socio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`socio` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`socio` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `dataVence` DATE NULL DEFAULT NULL ,
  `dataAprovacao` DATETIME NULL DEFAULT NULL ,
  `dataMatricula` DATETIME NOT NULL ,
  `numeroSocio` INT(11) NOT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  `idCategoriaSocio` INT(11) NOT NULL ,
  `idPessoa` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `Id_pessoa` (`idPessoa` ASC) ,
  INDEX `FK68884EDA2F76C89` (`idPessoa` ASC) ,
  INDEX `FK68884EDD8D64A80` (`idCategoriaSocio` ASC) ,
  CONSTRAINT `FK68884EDA2F76C89`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `acal2`.`pessoa` (`id` ),
  CONSTRAINT `FK68884EDD8D64A80`
    FOREIGN KEY (`idCategoriaSocio` )
    REFERENCES `acal2`.`categoriasocio` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`conta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`conta` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`conta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `dataPag` DATETIME NULL DEFAULT NULL ,
  `dataVence` DATETIME NOT NULL ,
  `observacoes` TEXT NULL DEFAULT NULL ,
  `taxaSocio` DECIMAL(10,2) NULL DEFAULT NULL ,
  `taxaRelogio` DOUBLE NULL DEFAULT NULL ,
  `idNumeroSocio` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK5A7376FC2A54024` (`idNumeroSocio` ASC) ,
  CONSTRAINT `FK5A7376FC2A54024`
    FOREIGN KEY (`idNumeroSocio` )
    REFERENCES `acal2`.`socio` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`contrato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`contrato` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`contrato` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `corpo` TEXT NULL DEFAULT NULL ,
  `descricao` TEXT NOT NULL ,
  `nome` TEXT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`motivoentrada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`motivoentrada` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`motivoentrada` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(255) NOT NULL ,
  `descricao` TEXT NULL DEFAULT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`entrada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`entrada` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`entrada` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `data` DATE NOT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  `valor` DECIMAL(10,2) NOT NULL ,
  `idCedente` INT(11) NOT NULL ,
  `idFuncionario` INT(11) NOT NULL ,
  `idMotivoEntrada` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FKA12266579628C684` (`idMotivoEntrada` ASC) ,
  INDEX `FKA12266574303C16E` (`idCedente` ASC) ,
  INDEX `FKA1226657B686FB5B` (`idFuncionario` ASC) ,
  CONSTRAINT `FKA12266579628C684`
    FOREIGN KEY (`idMotivoEntrada` )
    REFERENCES `acal2`.`motivoentrada` (`id` ),
  CONSTRAINT `FKA12266574303C16E`
    FOREIGN KEY (`idCedente` )
    REFERENCES `acal2`.`socio` (`id` ),
  CONSTRAINT `FKA1226657B686FB5B`
    FOREIGN KEY (`idFuncionario` )
    REFERENCES `acal2`.`funcionario` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`entradaslog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`entradaslog` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`entradaslog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `idOriginal` INT(11) NULL DEFAULT NULL ,
  `dataOriginal` DATE NULL DEFAULT NULL ,
  `dataAlteracao` DATETIME NULL DEFAULT NULL ,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL ,
  `idCedente` INT(11) NULL DEFAULT NULL ,
  `idFuncionario` INT(11) NULL DEFAULT NULL ,
  `idMotivoEntrada` INT(11) NULL DEFAULT NULL ,
  `tipo` VARCHAR(255) NULL DEFAULT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  `idFuncionarioAlteracao` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`saida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`saida` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`saida` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `data` DATETIME NOT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  `valor` DECIMAL(10,2) NOT NULL ,
  `favorecido` VARCHAR(255) NOT NULL ,
  `idfuncionario` INT(11) NOT NULL ,
  `idmotivosaida` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK6823D98F5B1A7DB` (`idmotivosaida` ASC) ,
  INDEX `FK6823D98B686FB5B` (`idfuncionario` ASC) ,
  CONSTRAINT `FK6823D98B686FB5B`
    FOREIGN KEY (`idfuncionario` )
    REFERENCES `acal2`.`funcionario` (`id` ),
  CONSTRAINT `FK6823D98F5B1A7DB`
    FOREIGN KEY (`idmotivosaida` )
    REFERENCES `acal2`.`motivodespesa` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`saidaslog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`saidaslog` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`saidaslog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `idoriginal` INT(11) NULL DEFAULT NULL ,
  `dataoriginal` DATE NULL DEFAULT NULL ,
  `dataalteracao` DATETIME NULL DEFAULT NULL ,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL ,
  `favorecido` VARCHAR(255) NULL DEFAULT NULL ,
  `idfuncionario` INT(11) NULL DEFAULT NULL ,
  `idFuncionarioAltercao` INT(11) NULL DEFAULT NULL ,
  `idmotivosaida` INT(11) NULL DEFAULT NULL ,
  `tipo` VARCHAR(255) NULL DEFAULT NULL ,
  `observacao` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `acal2`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acal2`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `acal2`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `senha` VARCHAR(45) NULL DEFAULT NULL ,
  `nivel` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `acal2` ;
USE `acal2`;

DELIMITER $$

USE `acal2`$$
DROP TRIGGER IF EXISTS `acal2`.`ChequeLogInsert` $$
USE `acal2`$$
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ChequeLogInsert after insert ON cheque
FOR EACH ROW BEGIN INSERT INTO 
chequeslog (
idOriginal,
dataPagamento,
dataVencimento,
dataAlteracao,
numero,
observacoes,
valor,
idFuncionarioAlteracao,
tipo
)VALUES(
new.id,
new.dataPagamento,
new.dataVencimento,
now(),
new.numero,
new.observacoes,
new.valor,
1,
'insert'

);





  END */$$


USE `acal2`$$
DROP TRIGGER IF EXISTS `acal2`.`ChequeLogDelete` $$
USE `acal2`$$
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ChequeLogDelete after delete ON cheque
FOR EACH ROW BEGIN INSERT INTO 
chequeslog(
idOriginal,
dataPagamento,
dataVencimento,
dataAlteracao,
numero,
observacoes,
valor,
idFuncionarioAlteracao,
tipo
)VALUES(
old.id,
old.dataPagamento,
old.dataVencimento,
now(),
old.numero,
old.observacoes,
old.valor,
1,
'delete'

);





  END */$$


DELIMITER ;

DELIMITER $$

USE `acal2`$$
DROP TRIGGER IF EXISTS `acal2`.`EntradaLogInsert` $$
USE `acal2`$$
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER EntradaLogInsert after insert ON entrada
FOR EACH ROW BEGIN  INSERT INTO
entradasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
idCedente,
idFuncionario,
idMotivoEntrada,
tipo,
observacao

) values(
new.id,
new.data,
now(),
new.valor,
new.idCedente,
new.idFuncionario,
new.idMotivoEntrada,
'insert',
new.observacao
);

  END */$$


USE `acal2`$$
DROP TRIGGER IF EXISTS `acal2`.`EntradaLogDelete` $$
USE `acal2`$$
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER EntradaLogDelete after delete ON entrada
FOR EACH ROW BEGIN  INSERT INTO
entradasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
idCedente,
idFuncionario,
idMotivoEntrada,
tipo,
observacao

) values(
old.id,
old.data,
now(),
old.valor,
old.idCedente,
old.idFuncionario,
old.idMotivoEntrada,
'delete',
old.observacao
);

  END */$$


DELIMITER ;

DELIMITER $$

USE `acal2`$$
DROP TRIGGER IF EXISTS `acal2`.`SaidaLogInsert` $$
USE `acal2`$$
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER SaidaLogInsert  after insert ON saida
FOR EACH ROW BEGIN  INSERT INTO
saidasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
favorecido,
idFuncionario,

idMotivosaida,
tipo,
observacao

) values(
new.id,
new.data,
now(),
new.valor,
new.favorecido,
new.idfuncionario,
new.idmotivosaida,
'insert',
new.observacao
);

  END */$$


USE `acal2`$$
DROP TRIGGER IF EXISTS `acal2`.`SaidaLogDelete` $$
USE `acal2`$$
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER SaidaLogDelete  after delete ON saida
FOR EACH ROW BEGIN  INSERT INTO
saidasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
favorecido,
idFuncionario,

idMotivosaida,
tipo,
observacao

) values(
old.id,
old.data,
now(),
old.valor,
old.favorecido,
old.idfuncionario,
old.idmotivosaida,
'delete',
old.observacao
);

  END */$$


DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
