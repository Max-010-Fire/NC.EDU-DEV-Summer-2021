insert into statuses values(0, 'NotStarted');
insert into statuses values(1, 'InProgress');
insert into statuses values(2, 'Completed');

insert into roles values (0, 'ROLE_ADMIN');
insert into roles values (1, 'ROLE_USER');
insert into roles values (2, 'ROLE_GUEST');

insert into users values(0, 'Max', '$2a$10$IQhv5AXG1q0g8cj8Imwc6OEeakvEjlVk37m9nn/e24dOKmGNG5mB2');
insert into users values(1, 'Dasha', '$2a$10$IQhv5AXG1q0g8cj8Imwc6OEeakvEjlVk37m9nn/e24dOKmGNG5mB2');

insert into user_roles values(0, 0, 0);
insert into user_roles values(1, 1, 1);

insert into tasks values(1, '2009-06-04 22:00:00',  'Description', '2009-06-04 22:00:00', 1, 'Writing', 1);
insert into tasks values(2, '2009-06-04 22:00:00',  'Description', '2009-06-04 22:00:00', 0, 'Reading', 1);
insert into tasks values(3, '2009-06-04 22:00:00',  'Description', '2009-06-04 22:00:00', 1, 'Cleaning', 0);

-- insert into tasks values(0, 0, 'Cleaning', 'Description', 1, '2009-06-04 22:00:00', '2009-06-04 22:00:00');
-- insert into tasks values(1, 1, 'Writing', 'Description', 1, '2009-06-04 22:00:00', '2009-06-04 22:00:00');
-- insert into tasks values(2, 1, 'Reading', 'Description', 0, '2009-06-04 22:00:00', '2009-06-04 22:00:00');