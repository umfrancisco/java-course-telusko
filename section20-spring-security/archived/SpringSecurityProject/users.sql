create table users (
	id int primary key,
	username varchar(250),
	password varchar(250)
);

insert into users (id, username, password) values
(1, 'user', '9876'),
(2, 'admin', '9876543');