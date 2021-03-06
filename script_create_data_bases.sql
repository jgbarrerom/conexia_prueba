CREATE DATABASE CONEXIA;
USE CONEXIA;

CREATE TABLE CLIENTE(
  ID_CLIENTE INT NOT NULL AUTO_INCREMENT,
  NOMBRE_CLIENTE VARCHAR(30),
  APELLIDO_PATERNO_CLIENTE VARCHAR(30),
  APELLIDO_MATERNO_CLIENTE VARCHAR(30),
  OBSERVACIONES TEXT,
  PRIMARY KEY(ID_CLIENTE)
);

CREATE TABLE MESA(
  ID_MESA INT NOT NULL AUTO_INCREMENT,
  NUMERO_MAX_COMENSAL INT,
  UBICACION TEXT,
  PRIMARY KEY(ID_MESA)
);

CREATE TABLE COCINERO(
  ID_COCINERO INT NOT NULL AUTO_INCREMENT,
  NOMBRE VARCHAR(30),
  APELLIDO_PATERNO_CLIENTE VARCHAR(30),
  APELLIDO_MATERNO_COCINERO VARCHAR(30),
  PRIMARY KEY(ID_COCINERO)
);

CREATE TABLE CAMARERO(
  ID_CAMARERO INT NOT NULL AUTO_INCREMENT,
  NOMBRE_CAMARERO VARCHAR(30),
  APELLIDO_PATERNO_CAMARERO VARCHAR(30),
  APELLIDO_MATERNO_CAMARERO VARCHAR(30),
  PRIMARY KEY(ID_CAMARERO)
);

CREATE TABLE FACTURA(
  ID_FACTURA INT NOT NULL AUTO_INCREMENT,
  ID_CLIENTE INT NOT NULL,
  ID_CAMARERO INT NOT NULL,
  ID_MESA INT NOT NULL,
  FECHA_FACTURA DATE,
  PRIMARY KEY(ID_FACTURA),
  FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE),
  FOREIGN KEY(ID_CAMARERO) REFERENCES CAMARERO(ID_CAMARERO),
  FOREIGN KEY(ID_MESA) REFERENCES MESA(ID_MESA)
);

CREATE TABLE PLATO (
	ID_PLATO INT NOT NULL AUTO_INCREMENT,
	NOMBRE_PLATO varchar(30) NULL,
	VALOR_PLATO BIGINT UNSIGNED NULL,
	PRIMARY KEY (ID_PLATO)
);

CREATE TABLE DETALLE_FACTURA(
  ID_DETALLE INT NOT NULL AUTO_INCREMENT,
  ID_FACTURA INT NOT NULL,
  ID_COCINERO INT NOT NULL,
  ID_PLATO INT NOT NULL,
  UNIDADES_PLATO INT DEFAULT NULL,
  SUBTOTAL_DETALLE bigint(20) unsigned DEFAULT NULL
  PRIMARY KEY(ID_DETALLE),
  FOREIGN KEY(ID_FACTURA) REFERENCES FACTURA(ID_FACTURA),
  FOREIGN KEY(ID_COCINERO) REFERENCES COCINERO(ID_COCINERO),
  FOREIGN KEY(ID_PLATO) REFERENCES PLATO(PLATO)
);


-- CONSULTA VENTAS POR MES Y NOMBRE CAMARERO
SELECT CAM.NOMBRE_CAMARERO, CAM.APELLIDO_PATERNO_CAMARERO,CAM.APELLIDO_MATERNO_CAMARERO,
SUM(DET.SUBTOTAL_DETALLE) TOTAL_VENTA, MONTH(FAC.FECHA_FACTURA) MES
FROM CAMARERO CAM LEFT JOIN FACTURA FAC ON CAM.ID_CAMARERO=FAC.ID_CAMARERO
LEFT JOIN DETALLE_FACTURA DET ON FAC.ID_FACTURA=DET.ID_FACTURA
GROUP BY CAM.ID_CAMARERO, MONTH(FAC.FECHA_FACTURA);

-- CLIENTE QUE HA GASTADO MAS DE 100000
SELECT CL.NOMBRE_CLIENTE,CL.APELLIDO_PATERNO_CLIENTE,CL.APELLIDO_MATERNO_CLIENTE,
SUM(DET.SUBTOTAL_DETALLE)
FROM CLIENTE CL INNER JOIN FACTURA FA ON CL.ID_CLIENTE=FA.ID_CLIENTE
INNER JOIN DETALLE_FACTURA DET ON FA.ID_FACTURA=DET.ID_FACTURA
GROUP BY CL.NOMBRE_CLIENTE,CL.APELLIDO_PATERNO_CLIENTE,CL.APELLIDO_MATERNO_CLIENTE
HAVING SUM(DET.SUBTOTAL_DETALLE) > 100000;
