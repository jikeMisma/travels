
---用户表

create table t_user(
	id int(10) PRIMARY key auto_increment,
	usrname varchar(60),
	password varchar(60),
	email varchar(60)

);

---省份表
create table t_provice(
	id int(10) PRIMARY key auto_increment,
	name varchar(60),
	tags varchar(80),
	placecounts int(4)

)

----景点表

create table t_place(
	id int(10) PRIMARY key auto_increment,
	name varchar(60),
	picpath varchar(100),
	hottime TIMESTAMP,
	hotticket double(7,2),
	dimticket double(7,2),
	placedis varchar(200),
	proviceid int(10) REFERENCES t_provice(id)

);
