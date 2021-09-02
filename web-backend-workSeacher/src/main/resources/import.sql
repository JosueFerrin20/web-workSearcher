INSERT INTO `empresa` (`nombre`, `descripcion`, `fk_experiencia`) VALUES ("Alcatel","Telefonía y Tecnologia",1);
INSERT INTO `empresa` (`nombre`, `descripcion`,`fk_experiencia`) VALUES ("Claro","Señal Telefonia Movil",2);

INSERT INTO `aspirante`( `id_oferta_empleo`, `id_trabajador`,`aspiracion_salarial`, `fecha_registro`) VALUES (1,1,700,"2021-07-10");

INSERT INTO `curso`(`acreditacion`, `descripcion`, `horas`, `nombre`, `tipo`, `fk_trabajador`) VALUES ("Google","Mantenimiento de computadores",20,"Sistemas","Computacion",1);

INSERT INTO `experiencia`(`empresa_anterior`, `fecha_ingreso`, `fecha_salida`, `motivo_salida_trabajo_anterior`, `puesto_desempeñado`, `fk_trabajador`) VALUES ("Huawei","2012-06-16","2018-09-23","Despido por recorte de personal","Empleado",1);

INSERT INTO `idioma`(`nivel`, `nombre`, `fk_trabajador`) VALUES ('Suficiencia','Inglés',1);

INSERT INTO `oferta_empleo`(`puesto`, `rango_sueldo`, `fk_empresa`) VALUES ('Vendedor',600.00,1);

INSERT INTO `trabajador`( `cedula`, `direccion`, `email`, `nombre`, `sexo`, `telefono`, `grado_academico`, `tipo`, `titulo`) VALUES ('0528391742','Latacunga','edgardo@gmail.com','Edgardo Sanchez','Masculino','0936476347','2do Nivel (Colegio)','Empleado','Bachiller')

