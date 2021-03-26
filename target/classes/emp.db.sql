create database if not exists ems_system;
use ems_system;

-- create table employee( id int(11) NOT NULL AUTO_INCREMENT, full_name varchar(64) , email varchar(100), dept varchar(50), salary decimal(10,2), primary key(`id`) );

insert into employee(id,full_name,email,dept, salary) values (3,'Marry Smith','marry.smith@gmail.com','Engineering',975000.23),
(4,'Mike David','mike.david@gmail.com','Dev',225000.23), (5,'Tony Stark','tony.stark@gmail.com','Engineering',98875000.23);