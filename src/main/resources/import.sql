
INSERT INTO medicos (`codigo`,`apellido`,`especialidad`,`nombre`,`telefono`) VALUES (1,'Ramírez','Cirujano','Antonio','634582079');
INSERT INTO medicos (`codigo`,`apellido`,`especialidad`,`nombre`,`telefono`) VALUES (2,'Romero','Dentista','Iván','614209857');

INSERT INTO pacientes (`codigo`,`apellido`,`codigopostal`,`direccion`,`fechanacimiento`,`nombre`,`poblacion`,`provincia`,`telefono`) VALUES (1,'Díaz','14900','Ronda del Valle nº134','2001-08-08','Miguel','Lucena','Cordoba','628592063');
INSERT INTO pacientes (`codigo`,`apellido`,`codigopostal`,`direccion`,`fechanacimiento`,`nombre`,`poblacion`,`provincia`,`telefono`) VALUES (2,'Pérez','14900','Calle Clara Campoamor 20','2001-11-28','Anita','Lucena','Cordoba','610782639');

INSERT INTO ingresos (`codigo`,`cama`,`fechaingreso`,`numerohabitacion`,`medico_codigo`,`paciente_codigo`) VALUES (1,'1','2021-12-04','1',1,1);
