
INSERT INTO medicos (`codigo`,`apellido`,`especialidad`,`nombre`,`telefono`) VALUES (1,'Ramírez Oña','Cirujía','Antonio','634582079');
INSERT INTO medicos (`codigo`,`apellido`,`especialidad`,`nombre`,`telefono`) VALUES (2,'Romero Ávila','Odontología','Iván','614209857');
INSERT INTO medicos (`codigo`,`apellido`,`especialidad`,`nombre`,`telefono`) VALUES (3,'Sánchez Porras','Ginecología','Yolanda','679542036');
INSERT INTO medicos (`codigo`,`apellido`,`especialidad`,`nombre`,`telefono`) VALUES (4,'Pérez Del PIno','Otorrinolaringología','Gregorio','635201480');
INSERT INTO medicos (`codigo`,`apellido`,`especialidad`,`nombre`,`telefono`) VALUES (5,'Aranda López','Enfermería','Mº Teresa','632504816');

INSERT INTO pacientes (`codigo`,`apellido`,`codigopostal`,`direccion`,`fechanacimiento`,`nombre`,`poblacion`,`provincia`,`telefono`) VALUES (1,'Díaz Sánchez','14900','Ronda del Valle nº134','2001-08-08','Miguel','Lucena','Cordoba','628592063');
INSERT INTO pacientes (`codigo`,`apellido`,`codigopostal`,`direccion`,`fechanacimiento`,`nombre`,`poblacion`,`provincia`,`telefono`) VALUES (2,'Pérez Aranda','14900','Calle Clara Campoamor 20','2001-11-28','Ana','Lucena','Cordoba','610782639');
INSERT INTO pacientes (`codigo`,`apellido`,`codigopostal`,`direccion`,`fechanacimiento`,`nombre`,`poblacion`,`provincia`,`telefono`) VALUES (3,'Díaz Pérez','14004','Calle del amor nº 26','2008-08-28','María','Córdoba','Cordoba','610962819');
INSERT INTO pacientes (`codigo`,`apellido`,`codigopostal`,`direccion`,`fechanacimiento`,`nombre`,`poblacion`,`provincia`,`telefono`) VALUES (4,'Cabello Fernandez','14089','Calle Miguel Cuenca','2006-11-16','Joaquín','Sevilla','Sevilla','684759830');
INSERT INTO pacientes (`codigo`,`apellido`,`codigopostal`,`direccion`,`fechanacimiento`,`nombre`,`poblacion`,`provincia`,`telefono`) VALUES (5,'Rodriguez Aranda','19021','Ronda del Selpillar nº 4','2002-04-16','Marina','Navas Del Selpillar','Cordoba','617504837');
INSERT INTO pacientes (`codigo`,`apellido`,`codigopostal`,`direccion`,`fechanacimiento`,`nombre`,`poblacion`,`provincia`,`telefono`) VALUES (6,'Juan Gandía','27890','Avenida Nueva Vía','2003-10-17','Ferrán','Barcelona','Barcelona','682035476');

INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (1,'1','2021-12-04','1',1,1);
INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (2,'2','2021-11-28','1',5,2);
INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (3,'4','2020-09-16','2',2,1);
INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (4,'2','2022-01-27','7',4,4);
INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (5,'3','2019-12-26','4',1,4);
INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (6,'2','2021-01-12','6',3,3);
INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (7,'4','2021-02-21','3',3,5);
INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (8,'2','2018-06-14','8',5,6);
