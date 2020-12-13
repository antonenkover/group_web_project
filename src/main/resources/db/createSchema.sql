create database bank_system CHARACTER SET utf8 COLLATE utf8_bin;
use bank_system;

CREATE TABLE system_user (
id int auto_increment primary key,
login varchar(255) unique,
password varchar(255) not null,
name varchar(255),
surname varchar (255),
account_id int unique
);

create table credit_account (
id int auto_increment primary key,
balance int,
credit_limit int,
dept int,
percentage int,
credit_rate int,
deposit_start date,
deposit_end date,
deposit_duration int,
account_id int,
constraint foreign key (account_id) references system_user(account_id)
);

create table debit_account (
id int auto_increment primary key,
balance int,
debit_rate int,
deposited_sum int,
deposit_start date,
deposit_end date,
deposit_duration int,
account_id int,
constraint foreign key (account_id) references system_user(account_id)
);

create table operations_type (
id int auto_increment primary key,
operation_type varchar(255)
);

create table money_transfer (
id int auto_increment primary key,
user_id int,
transferred_sum int,
operation_time datetime,
operation_type_id int,
constraint foreign key (user_id) references system_user(id),
constraint foreign key (operation_type_id) references operations_type(id)
);

create table services (
id int auto_increment primary key,
title varchar(255),
account_id int
);

create table services_payment (
id int auto_increment primary key,
service_id int,
operation_type_id int,
operation_id int,
constraint foreign key (service_id) references services(id),
constraint foreign key (operation_type_id) references operations_type(id),
constraint foreign key (operation_id) references money_transfer(id)
);

create table user_payment (
id int auto_increment primary key,
receiver_id int,
operation_type_id int,
operation_id int,
constraint foreign key (receiver_id) references system_user(id),
constraint foreign key (operation_type_id) references operations_type(id),
constraint foreign key (operation_id) references money_transfer(id)
);