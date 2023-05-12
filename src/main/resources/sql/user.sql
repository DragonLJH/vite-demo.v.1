create table user
(
    user_id       int          not null
        primary key,
    user_phone    varchar(255) not null,
    user_password varchar(255) not null,
    user_name     varchar(255) null,
    user_power    int          not null,
    constraint user_phone
        unique (user_phone)
);


