drop table if exists user;
drop table if exists unit;

create table unit(
	id int auto_increment  primary key,
	name varchar(250) not null,
	create_datetime datetime not null
);
create table user (
	id int auto_increment  primary key,
       unit_id int not null,
	name varchar(250) not null,
	email varchar(250) default null,
	age int not null,
	create_datetime datetime not null
);

alter table user add foreign key (unit_id) references unit(id);