/*
insert into driver(id, firstname, lastname, leader) values (1, 'David', 'Obermair', true);
insert into driver(id, firstname, lastname, leader) values (2, 'Manuel', 'Obermair', false);
insert into driver(id, firstname, lastname, leader) values (3, 'Christoph', 'Obermair', false);
insert into driver(id, firstname, lastname, leader) values (4, 'Silvia', 'Obermair', false);
insert into driver(id, firstname, lastname, leader) values (5, 'Wolfgang', 'Obermair', false);

insert into fuel(id, date, price, driver_id) values (1, '2021-04-01 12:40:00', 30.0, 1);
insert into fuel(id, date, price, driver_id) values (2, '2021-03-03 15:30:00', 25.0, 1);
insert into fuel(id, date, price, driver_id) values (3, '2021-02-21 18:30:00', 15.0, 1);
insert into fuel(id, date, price, driver_id) values (4, '2021-03-11 17:45:00', 10.0, 1);

insert into repair(id, date, price, driver_id) values (1, '2021-03-11 17:45:00', 120.0, 1);
insert into repair(id, date, price, driver_id) values (2, '2021-04-04 14:10:00', 220.0, 1);
insert into repair(id, date, price, driver_id) values (3, '2021-04-02 13:45:00', 320.0, 1);

insert into ride(id, date, km, description, driver_id) values (1, '2021-03-28 13:45:00', 130, 'Altenhof-Schwannenstadt-Wels-Altenhof', 1);
insert into ride(id, date, km, description, driver_id) values (2, '2021-03-29 16:45:00', 54, 'Atzbach-Leonding', 1);
insert into ride(id, date, km, description, driver_id) values (3, '2021-03-30 17:45:00', 30, 'Atzbach-Vöcklabruck-Atzbach', 1);
insert into ride(id, date, km, description, driver_id) values (4, '2021-03-30 13:45:00', 234, 'Atzbach-Linz-Steyr-Atzbach', 1);
insert into ride(id, date, km, description, driver_id) values (5, '2021-04-02 13:45:00', 201, 'Atzbach-Salzburg', 1);

insert into settlement(id, date, km_price, last_mileage, new_mileage) values (1, '2020-08-19 13:45:00', 0.16, 125106, 128306);
insert into settlement(id, date, km_price, last_mileage, new_mileage) values (2, '2021-04-09 13:45:00', 0.16, 128306, 133869);

 */