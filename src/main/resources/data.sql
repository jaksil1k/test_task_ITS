insert into users(name, email, password) values ('zhaksylyk', 'nartai53@gmail.com', '5');
insert into users(name, email, password) values ('example', 'example@gmail.com', '5');
-- insert into users(id, name, email, password) values (21, 'zhaksylyk', 'nartai52@gmail.com', '5');
-- insert into users(id, name, email, password) values (31, 'zhaksylyk', 'nartai53@gmail.com', '5');
-- insert into users(id, name, email, password) values (41, 'zhaksylyk', 'nartai54@gmail.com', '5');
-- insert into friends values (11, 21);
-- insert into friends values (11, 31);
-- insert into friends values (11, 41);
-- insert into friends values (21, 31);
insert into locations values (11, 'name of locations 1', '1 location');
insert into locations values (21, 'name of locations 2', '2 location');
-- insert into locations values (2, 'name of locations 2', '2 location');
-- insert into locations values (3, 'name of locations 3', '3 location');
-- insert into locations values (4, 'name of locations 4', '4 location');
-- insert into users_locations values('nartai53@gmail.com', 11);
insert into users_locations values('example@gmail.com', 11);
insert into users_locations values('nartai53@gmail.com', 21);
insert into shared_locations values (1, false, 11, 'example@gmail.com', 'nartai53@gmail.com')
