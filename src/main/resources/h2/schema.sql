drop table if exists user_addresses;
drop table if exists teacher_courses;
drop table if exists student_course;
drop table if exists student;
drop table if exists address;
drop table if exists course;
drop table if exists user;
drop table if exists unit;
drop table if exists comment;
drop table if exists post;
drop table if exists school_teacher;
drop table if exists teacher;
drop table if exists school;
drop table if exists phone;
drop table if exists phone_details;
drop table if exists book_details;
drop table if exists book;
drop table if exists content_details;
drop table if exists content;

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

create table phone (
	id int auto_increment primary key,
	number varchar(255),
	details_id int
);

create table phone_details (
	id int auto_increment primary key,
	provider varchar(255),
	technology varchar(255)
);

alter table phone
add constraint fk_phone_details_id
foreign key (details_id) references phone_details(id);


create table book (
	id int auto_increment primary key,
	name varchar(255)
);

create table book_details (
	id int auto_increment primary key,
	author varchar(255),
	press varchar(255),
	book_id int
);

alter table book_details
add constraint fk_book_details_id
foreign key (book_id) references book(id);

create table content (
	id int auto_increment primary key,
	title varchar(255)
);

create table content_details (
	id int auto_increment primary key,
	text text,
	content_id int
);

alter table content_details
add constraint fk_content_details_id
foreign key (content_id) references content(id);

create table address (
	id int auto_increment primary key,
	number varchar(255),
	street varchar(255)
);

create table user_addresses (
	user_id int not null,
	addresses_id int not null
);


alter table user_addresses
add constraint fk_addresses_id
foreign key (addresses_id) references address(id);

alter table user_addresses
add constraint fk_user_id
foreign key (user_id) references user(id);

create table course (
	id int auto_increment primary key,
	name varchar(255)
);

create table teacher_courses (
	teachers_id int not null,
	courses_id int not null
);

alter table teacher_courses
add constraint fk_tc_teacher_id
foreign key (teachers_id) references teacher(id);

alter table teacher_courses
add constraint fk_tc_course_id
foreign key (courses_id) references course(id);


alter table teacher_courses
add constraint uk_teacher_course
unique (teachers_id, courses_id);

create table student (
	id int auto_increment primary key,
	name varchar(255)
);

create table student_course (
	student_id int not null,
	course_id int not null
);

alter table student_course
add constraint fk_sc_student_id
foreign key (student_id) references student(id);

alter table student_course
add constraint fk_sc_course_id
foreign key (course_id) references course(id);


alter table student_course
add constraint uk_student_course
unique (student_id, course_id);