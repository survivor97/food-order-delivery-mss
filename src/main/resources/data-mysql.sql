insert into admin (email, first_name, last_name, password, role, username) values ('admin@email.com', 'Admin', 'Admin', '$2a$12$IirpPZVMxpLPQAQ4mLtUHuvhkZpvw4YJvcKh/YKnRrSacm9Mym4nC', 'ADMIN', 'admin');

insert into user (email, first_name, last_name, password, role, username) values ('test_user@a.com', 'Lily', 'Hannah', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'USER', 'user');
insert into user (email, first_name, last_name, password, role, username) values ('test_user_2@a.com', 'Justice', 'Dakota', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'USER', 'user_2');
insert into user (email, first_name, last_name, password, role, username) values ('test_user_3@a.com', 'Emerson', 'Charlie', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'USER', 'user_3');
insert into user (email, first_name, last_name, password, role, username) values ('test_user_3@a.com', 'Second', 'Charlie', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'USER', 'user_4');

insert into restaurant_manager (email, first_name, last_name, password, role, username) values ('restaurant_manager_1@mail.com', 'Restaurant', 'Manager', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'RESTAURANT_MANAGER', 'restaurant_manager');
insert into restaurant_manager (email, first_name, last_name, password, role, username) values ('restaurant_manager_2@mail.com', 'Restaurant', 'Managera', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'RESTAURANT_MANAGER', 'restaurant_manager_2');
insert into restaurant_manager (email, first_name, last_name, password, role, username) values ('restaurant_manager_3@mail.com', 'Restaurant', 'Managerb', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'RESTAURANT_MANAGER', 'restaurant_manager_3');
insert into restaurant_manager (email, first_name, last_name, password, role, username) values ('restaurant_manager_4@mail.com', 'Restaurant', 'Managerc', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'RESTAURANT_MANAGER', 'restaurant_manager_4');


insert into delivery_user (email, first_name, last_name, password, role, username) values ('delivery_user_1@mail.com', 'Ellie', 'Nora', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'DELIVERY_USER', 'delivery_user');
insert into delivery_user (email, first_name, last_name, password, role, username) values ('delivery_user_2@mail.com', 'Aria', 'Zoey', '$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'DELIVERY_USER', 'delivery_user_2');
insert into delivery_user (email, first_name, last_name, password, role, username) values ('delivery_user_3@mail.com', 'William', 'Denver', '$$2a$12$Wdo1wdk0/Uakw9uSsqpp2Oza1UYIpOK97o5eIPCXiTXvhi2hwj5jG', 'DELIVERY_USER', 'delivery_user_3');

insert into restaurant (description, name, restaurant_manager_id) values ('Restaurant A Description', 'Restaurant A', 1);
insert into restaurant (description, name, restaurant_manager_id) values ('Restaurant B Description', 'Restaurant B', 2);
insert into restaurant (description, name, restaurant_manager_id) values ('Restaurant C Description', 'Restaurant C', 3);
insert into restaurant (description, name, restaurant_manager_id) values ('Restaurant C Description', 'Restaurant D', 4);

insert into position (latitude, longitude, restaurant_id) values ('44.414020', '26.104683', 1);
insert into position (latitude, longitude, restaurant_id) values ('44.413051', '26.103213', 2);
insert into position (latitude, longitude, restaurant_id) values ('44.442487', '26.060461', 3);

insert into position (latitude, longitude, user_id) values ('44.414434', '26.105399', 1);
insert into position (latitude, longitude, user_id) values ('44.412064', '26.101259', 2);
insert into position (latitude, longitude, user_id) values ('44.419600', '26.139513', 3);

insert into food (food_category, name, price, weight, restaurant_id) values ('PIZZA', 'Pizza One', '55', '300', 1);
insert into food (food_category, name, price, weight, restaurant_id) values ('FAST_FOOD', 'Cartofi prajiti', '27', '250', 2);
insert into food (food_category, name, price, weight, restaurant_id) values ('BURGERS', 'Burger R', '60', '280', 3);

insert into orders (order_date_time, order_status, delivery_user_id, restaurant_id, user_id) values ('2022-01-25 01:30:00', 'RECEIVED', 1, 1, 1);
insert into orders_food values (1, 1);

insert into orders (order_date_time, order_status, delivery_user_id, restaurant_id, user_id) values ('2022-01-25 01:20:00', 'RECEIVED', 2, 2, 2);
insert into orders_food values (2, 2);

insert into orders (order_date_time, order_status, delivery_user_id, restaurant_id, user_id) values ('2022-01-25 01:16:00', 'RECEIVED', 3, 3, 3);
insert into orders_food values (3, 3);

insert into review (comment, score, restaurant_id) values ('The Best', 10, 1);
insert into review (comment, score, restaurant_id) values ('Not so good', 7, 2);
insert into review (comment, score, restaurant_id) values ('Naspa', 4, 3);
