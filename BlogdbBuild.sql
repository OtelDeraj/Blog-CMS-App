drop database if exists blogdb;

create database blogdb;

use blogdb;


create table Users(
id int primary key auto_increment,
userName varchar(30) not null unique,
`password` varchar(100) not null,
enabled bool not null
);

create table `Role`(
id int primary key auto_increment,
`role` varchar(30) not null
);

create table UserRole(
userId int not null,
roleId int not null,
primary key(userId, roleId),
foreign key fk_userrole_users(userId)
references Users(id),
foreign key fk_userrole_users(roleId)
references `Role`(id)
);

insert into users(userName, `password`, enabled)
values
('Admin', 'password', 1),
('Author', 'password', 1);

insert into `Role`(`role`)
values
('ROLE_ADMIN'),
('ROLE_AUTHOR');

insert into UserRole(userId, roleId)
values
(1, 1),
(2, 2);

select * from userrole;

UPDATE users SET `password` = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 1;
UPDATE users SET `password` = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 2;



