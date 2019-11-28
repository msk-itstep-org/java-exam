create table roles (
    id int not null auto_increment primary key,
    role varchar(100) not null,
    unique index (role)
);

create table users (
    id int not null auto_increment primary key,
    username varchar(100) not null,
    password varchar(100) not null,
    unique index (username)
);

create table user_roles (
    user_id int not null references users (id),
    role_id int not null references roles (id),
    primary key (user_id, role_id)
);

create table projects (
    id int not null auto_increment primary key,
    name varchar(100) not null
);

create table issues (
    id int not null auto_increment primary key,
    name varchar(100) not null,
    description varchar(200) not null,
    project_id int not null references projects (id),
    reporter_id int not null references users (id),
    assignee_id int not null references users (id)
);
