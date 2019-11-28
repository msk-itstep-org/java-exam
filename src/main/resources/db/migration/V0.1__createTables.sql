create table users (
id int auto_increment not null primary key,
username varchar(255) not null unique,
password varchar(255) not null
);

create table roles (
id int auto_increment not null primary key,
role varchar(255) not null unique
);

create table user_roles (
user_id int not null references users(id),
role_id int not null references roles(id),
primary key(user_id,role_id)
);

create table projects (
id int auto_increment not null primary key,
name varchar(255) not null
);

create table issues(
id int auto_increment not null primary key,
name varchar(255) not null,
description varchar(255),
project_id int,
reporter_id int
);

