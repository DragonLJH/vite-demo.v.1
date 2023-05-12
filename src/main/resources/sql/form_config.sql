create table form_config
(
    id     int auto_increment
        primary key,
    id_str varchar(255) default '' not null,
    label  varchar(255) default '' not null,
    type   varchar(255) default '' not null,
    name   varchar(255) default '' not null,
    value  varchar(255) default '' not null
);


