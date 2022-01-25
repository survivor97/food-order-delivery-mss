insert into user(email, first_name, last_name, password, role, username) values('test_user@a.com', 'Abc', 'Def', '12345', 'USER', 'abcdef');
insert into user(email, first_name, last_name, password, role, username) values('test_user_2@a.com', 'Bcd', 'Efg', '12345', 'USER', 'abcdef2');
insert into user(email, first_name, last_name, password, role, username) values('test_user_3@a.com', 'Def', 'Ghi', '12345', 'USER', 'abcdef3');

insert into restaurant_manager(email, first_name, last_name, password, role, username) values ('restaurant_manager_1@mail.com', 'Restaurant', 'Manager', '12345', 'RESTAURANT_MANAGER', 'restaurant_manager_1');
insert into restaurant_manager(email, first_name, last_name, password, role, username) values ('restaurant_manager_2@mail.com', 'Restaurant', 'Managera', '12345', 'RESTAURANT_MANAGER', 'restaurant_manager_2');
insert into restaurant_manager(email, first_name, last_name, password, role, username) values ('restaurant_manager_3@mail.com', 'Restaurant', 'Managerb', '12345', 'RESTAURANT_MANAGER', 'restaurant_manager_3');

insert into restaurant(description, name, restaurant_manager_id) values ('Restaurant A Description', 'Restaurant A', 1);
insert into restaurant(description, name, restaurant_manager_id) values ('Restaurant B Description', 'Restaurant B', 2);
insert into restaurant(description, name, restaurant_manager_id) values ('Restaurant C Description', 'Restaurant C', 3);

insert into position (latitude, longitude, restaurant_id) values ('44.414020', '26.104683', 1);
insert into position (latitude, longitude, restaurant_id) values ('44.413051', '26.103213', 2);
insert into position (latitude, longitude, restaurant_id) values ('44.442487', '26.060461', 3);

insert into position (latitude, longitude, user_id) values ('44.414434', '26.105399', 1);
insert into position (latitude, longitude, user_id) values ('44.412064', '26.101259', 2);
insert into position (latitude, longitude, user_id) values ('44.445160', '26.061748', 3);

insert into food(food_category, name, price, weight, restaurant_id) values ('PIZZA', 'Pizza One', '55', '300', 1);
insert into food(food_category, name, price, weight, restaurant_id) values ('FAST_FOOD', 'Cartofi prajiti', '27', '250', 2);
insert into food(food_category, name, price, weight, restaurant_id) values ('BURGERS', 'Burger R', '60', '280', 3);
