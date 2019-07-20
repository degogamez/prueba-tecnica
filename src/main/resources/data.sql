insert into cliente(nombre, direccion, ciudad, telefono) values('Diego','Direccion 1', 'Medellín', '12345678901234567891');
insert into cliente(nombre, direccion, ciudad, telefono) values('Aleja','Direccion 2', 'Medellín', '12345678901234567892');
insert into cliente(nombre, direccion, ciudad, telefono) values('German','Direccion 3', 'Bello', '12345678901234567893');
insert into cliente(nombre, direccion, ciudad, telefono) values('Basilia','Direccion 4', 'Envigado', '12345678901234567894');

insert into tarjeta(numero, ccv, tipo, id_cliente) values('1111 1111 1111 1111', 123, 'Tipo T1', 1);
insert into tarjeta(numero, ccv, tipo, id_cliente) values('2222 2222 2222 2222', 1234, 'Tipo T2', 1);
insert into tarjeta(numero, ccv, tipo, id_cliente) values('3333 3333 3333 3333', 123, 'Tipo T1', 2);
insert into tarjeta(numero, ccv, tipo, id_cliente) values('4444 4444 4444 4444', 1234, 'Tipo T2', 2);
insert into tarjeta(numero, ccv, tipo, id_cliente) values('5555 5555 5555 5555', 123, 'Tipo T1', 3);
insert into tarjeta(numero, ccv, tipo, id_cliente) values('6666 6666 6666 6666', 1234, 'Tipo T2', 3);
insert into tarjeta(numero, ccv, tipo, id_cliente) values('7777 7777 7777 7777', 123, 'Tipo T1', 4);
insert into tarjeta(numero, ccv, tipo, id_cliente) values('8888 8888 8888 8888', 1234, 'Tipo T2', 4);

insert into consumo(fecha, descripcion, monto, id_tarjeta) values('2019-01-05 16:16:16', 'Compra camiseta', '1,111.09', 1);
insert into consumo(fecha, descripcion, monto, id_tarjeta) values('2019-01-07 14:16:16', 'Compra blusa', '1,111.09', 3);
insert into consumo(fecha, descripcion, monto, id_tarjeta) values('2019-02-09 13:16:16', 'Compra tenis', '1,111.09', 5);
insert into consumo(fecha, descripcion, monto, id_tarjeta) values('2019-01-10 12:16:16', 'Compra bolso', '1,111.09', 7);