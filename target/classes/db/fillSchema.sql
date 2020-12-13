use bank_system;

insert into system_user values (NULL, 'vasya01', 'password', 'Vasya', 'Petrov', 010, 'USER');
insert into system_user values (NULL, 'Hello002', 'ksh18846', 'Ivan', 'Miroshnik', 023, 'USER');
insert into system_user values (NULL, 'bEaUtYfUl00', 'qwerty', 'Mariia', 'Krut', 022, 'USER');
insert into system_user values (NULL, 'lol0l0l', '1234567890', 'Yergor', 'Artezkiy', 011, 'USER');
insert into system_user values (NULL, 'admin', 'admin_password', '', '', 00, 'ADMIN');
insert into system_user values (NULL, 'hello', '00000', '', '', 8888, 'USER');


insert into credit_account values (NULL, 100, 1000, 90, 10, 2, '2019-10-12', '2020-10-12', 12, 010);
insert into credit_account values (NULL, 12000, 25000, 24999, 7, 4, '2018-09-11', '2020-09-11', 24, 022);

insert into debit_account values (NULL, 0, 12, 1000, '2019-06-04', '2020-06-04', 12, 023);
insert into debit_account values (NULL, 0, 10, 10000, '2018-02-08', '2020-02-08', 24, 011);

insert into operations_type values (NULL, 'Pay for services');
insert into operations_type values (NULL, 'Transfer to another account');

insert into money_transfer values (NULL, 1, 10, '2019-10-29 00:00:00', 1);
insert into money_transfer values (NULL, 2, 999, '2019-10-29 00:00:01', 2);
insert into money_transfer values (NULL, 3, 600, '2019-10-29 00:00:02', 1);
insert into money_transfer values (NULL, 4, 122, '2019-10-29 00:00:003', 2);

insert into services values (NULL, 'Heating department', 123);
insert into services values (NULL, 'Light and water department', 009);

insert into services_payment values (NULL, 1, 1, 1);
insert into services_payment values (NULL, 2, 1, 3);

insert into user_payment values (NULL, 2, 2, 4);
insert into user_payment values (NULL, 4, 2, 2);
