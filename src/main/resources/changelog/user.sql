

create table if not exists user_details.users (

    id bigint unsigned auto_increment not null,
    user_name varchar(40) not null ,
    password  varchar(40) not null ,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    primary key (id)
);