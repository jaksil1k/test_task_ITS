insert into users(name, email, password) values ('zhaksylyk', 'nartai53@gmail.com', '5');
insert into users(name, email, password) values ('example', 'example@gmail.com', '5');
insert into users(name, email, password) values ('zhaksylyk', 'nartai51@gmail.com', '5');
insert into users(name, email, password) values ('zhaksylyk', 'nartai52@gmail.com', '5');
-- insert into users(id, name, email, password) values (41, 'zhaksylyk', 'nartai54@gmail.com', '5');
insert into friends values ('nartai53@gmail.com', 'example@gmail.com');
insert into friends values ('example@gmail.com', 'nartai53@gmail.com');
insert into friends values ('nartai53@gmail.com', 'nartai52@gmail.com');
insert into friends values ('nartai52@gmail.com', 'nartai53@gmail.com');
insert into friends values ('nartai53@gmail.com', 'nartai51@gmail.com');
insert into friends values ('nartai51@gmail.com', 'nartai53@gmail.com');

insert into locations values (11, 'name of locations 1', '1 location');
insert into locations values (21, 'name of locations 2', '2 location');
insert into locations values (31, 'name of locations 3', '3 location');
insert into locations values (41, 'name of locations 4', '4 location');
-- insert into users_locations values('nartai53@gmail.com', 11);
insert into users_locations values('example@gmail.com', 11);
insert into users_locations values('nartai53@gmail.com', 21);
insert into users_locations values('nartai51@gmail.com', 11);
insert into users_locations values('nartai52@gmail.com', 11);

-- insert into shared_locations values (1, false, 11, 'example@gmail.com', 'nartai53@gmail.com')
