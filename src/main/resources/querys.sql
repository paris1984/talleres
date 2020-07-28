drop table vehiculos;

create table IF NOT EXISTS vehiculos(
matricula varchar(15) primary key,
tipo      varchar(20)
);

insert into vehiculos values('0815 GYR','coche');
insert into vehiculos values('1234 BCD','moto');
insert into vehiculos values('1236 BCD','');

select * from vehiculos where matricula like '0815 GYR';

select * from vehiculos;