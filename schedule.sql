create table user
(
    user_email       varchar(50)                         not null
        primary key,
    user_name        varchar(10)                         not null,
    user_create_date timestamp default CURRENT_TIMESTAMP null,
    user_update_date timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

create table schedule
(
    id          int auto_increment
        primary key,
    email       varchar(50)                         not null,
    todo        varchar(200)                        not null,
    password    varchar(20)                         not null,
    create_date timestamp default CURRENT_TIMESTAMP null,
    update_date timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint schedule_ibfk_1
        foreign key (email) references user (user_email)
);

create index email
    on schedule (email);

INSERT INTO schedule.user (user_email, user_name, user_create_date, user_update_date) VALUES ('가나@sparta.com', '가나', '2024-10-01 10:01:31', '2024-10-01 10:01:31');
INSERT INTO schedule.user (user_email, user_name, user_create_date, user_update_date) VALUES ('다라@sparta.com', '다라', '2024-10-01 10:01:39', '2024-10-01 10:01:39');
INSERT INTO schedule.user (user_email, user_name, user_create_date, user_update_date) VALUES ('마바@sparta.com', '마바', '2024-10-01 10:01:46', '2024-10-01 10:01:46');
INSERT INTO schedule.user (user_email, user_name, user_create_date, user_update_date) VALUES ('사아@sparta.com', '사아', '2024-10-01 10:01:54', '2024-10-01 10:01:54');
INSERT INTO schedule.user (user_email, user_name, user_create_date, user_update_date) VALUES ('자차@sparta.com', '자차', '2024-10-01 10:01:59', '2024-10-01 10:01:59');
INSERT INTO schedule.user (user_email, user_name, user_create_date, user_update_date) VALUES ('카타@sparta.com', '카타', '2024-10-01 10:02:05', '2024-10-01 10:02:05');
INSERT INTO schedule.user (user_email, user_name, user_create_date, user_update_date) VALUES ('파하@sparta.com', '파하', '2024-10-01 10:02:09', '2024-10-01 10:02:09');



INSERT INTO schedule.schedule (id, email, todo, password, create_date, update_date) VALUES (3, '가나@sparta.com', '할일', '1234', '2024-10-01 10:03:32', '2024-10-01 10:03:32');
INSERT INTO schedule.schedule (id, email, todo, password, create_date, update_date) VALUES (4, '다라@sparta.com', '할일', '1234', '2024-10-01 10:03:43', '2024-10-01 10:03:43');
INSERT INTO schedule.schedule (id, email, todo, password, create_date, update_date) VALUES (5, '마바@sparta.com', '할일', '1234', '2024-10-01 10:03:45', '2024-10-01 10:03:45');
INSERT INTO schedule.schedule (id, email, todo, password, create_date, update_date) VALUES (6, '사아@sparta.com', '할일', '1234', '2024-10-01 10:03:47', '2024-10-01 10:03:47');
INSERT INTO schedule.schedule (id, email, todo, password, create_date, update_date) VALUES (7, '자차@sparta.com', '할일', '1234', '2024-10-01 10:03:49', '2024-10-01 10:03:49');
INSERT INTO schedule.schedule (id, email, todo, password, create_date, update_date) VALUES (8, '카타@sparta.com', '할일', '1234', '2024-10-01 10:03:52', '2024-10-01 10:03:52');
INSERT INTO schedule.schedule (id, email, todo, password, create_date, update_date) VALUES (9, '파하@sparta.com', '할일', '1234', '2024-10-01 10:03:54', '2024-10-01 10:03:54');
