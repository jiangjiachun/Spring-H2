drop table if exists user;
drop table if exists unit;
drop table if exists comment;
drop table if exists post;
drop table if exists school_teacher;
drop table if exists teacher;
drop table if exists school;

create table unit(
	id int auto_increment primary key,
	name varchar(250) not null,
	create_datetime datetime not null
);
create table user (
	id int auto_increment primary key,
	unit_id int,
	name varchar(250) not null,
	email varchar(250) default null,
	age int not null,
	create_datetime datetime not null
);

alter table user
add constraint fk_user_unit_id 
foreign key (unit_id) references unit(id);

create table post(
	id int auto_increment primary key,
	title varchar(250) not null
);
create table comment(
	id int auto_increment  primary key,
	post_id int,
	review varchar(250) not null
);

alter table comment
add constraint fk_comment_post_id 
foreign key (post_id) references post(id);

create table school(
	id int auto_increment primary key,
	name varchar(100) not null
);
create table school_teacher(
	school_id int not null,
	teacher_id int not null
);
create table teacher(
	id int auto_increment primary key,
	name varchar(20) not null
);

alter table school_teacher
add constraint uk_teacher_id
unique (teacher_id);

alter table school_teacher
add constraint fk_school_id
foreign key (school_id) references school(id);

alter table school_teacher
add constraint fk_teacher_id
foreign key (teacher_id) references teacher(id);