insert into unit 
	(id, name, create_datetime)
values
	(1, '科技公司', now()),
	(2, '网络公司', now());
insert into user 
	(unit_id, name, email, age, create_datetime) 
values
	(2,'test_1','test_1@163.com',33,now()),
	(1,'test_2','test_2@163.com',40,now()),
	(2,'test_3','test_3@163.com',29,now()),
	(1,'test_4','test_4@163.com',19,now()),
	(1,'test_5','test_5@163.com',32,now()),
	(2,'test_6','test_6@163.com',28,now()),
	(2,'test_7','test_7@163.com',70,now()),
	(2,'test_8','test_8@163.com',48,now()),
	(2,'test_9','test_9@163.com',54,now()),
	(2,'test_10','test_10@163.com',61,now()),
	(2,'test_11','test_11@163.com',29,now()),
	(1,'test_12','test_12@163.com',47,now()),
	(2,'test_13','test_13@163.com',37,now()),
	(1,'test_14','test_14@163.com',52,now()),
	(2,'test_15','test_15@163.com',67,now()),
	(1,'test_16','test_16@163.com',45,now()),
	(1,'test_17','test_17@163.com',57,now()),
	(1,'test_18','test_18@163.com',24,now()),
	(2,'test_19','test_19@163.com',62,now()),
	(2,'test_20','test_20@163.com',70,now()),
	(1,'test_21','test_21@163.com',65,now()),
	(2,'test_22','test_22@163.com',56,now()),
	(2,'test_23','test_23@163.com',66,now()),
	(2,'test_24','test_24@163.com',18,now()),
	(1,'test_25','test_25@163.com',35,now()),
	(1,'test_26','test_26@163.com',47,now()),
	(1,'test_27','test_27@163.com',67,now()),
	(2,'test_28','test_28@163.com',61,now()),
	(1,'test_29','test_29@163.com',24,now()),
	(2,'test_30','test_30@163.com',35,now()),
	(2,'test_31','test_31@163.com',15,now()),
	(1,'test_32','test_32@163.com',28,now()),
	(1,'test_33','test_33@163.com',55,now()),
	(2,'test_34','test_34@163.com',44,now()),
	(1,'test_35','test_35@163.com',42,now()),
	(1,'test_36','test_36@163.com',61,now()),
	(2,'test_37','test_37@163.com',33,now()),
	(1,'test_38','test_38@163.com',33,now()),
	(2,'test_39','test_39@163.com',69,now()),
	(2,'test_40','test_40@163.com',25,now()),
	(1,'test_41','test_41@163.com',30,now()),
	(1,'test_42','test_42@163.com',50,now()),
	(1,'test_43','test_43@163.com',17,now()),
	(1,'test_44','test_44@163.com',26,now()),
	(1,'test_45','test_45@163.com',34,now()),
	(1,'test_46','test_46@163.com',50,now()),
	(1,'test_47','test_47@163.com',32,now()),
	(2,'test_48','test_48@163.com',42,now()),
	(1,'test_49','test_49@163.com',42,now()),
	(2,'test_50','test_50@163.com',58,now());
	
insert into address (number, street) values ('number1', 'street1');

insert into user_addresses (user_id, addresses_id) values (1, 1);