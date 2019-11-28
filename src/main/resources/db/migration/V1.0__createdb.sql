CREATE TABLE users(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
   );

INSERT INTO users (username, password)
VALUES ("admin", "admin");

INSERT INTO users (username, password)
VALUES ("test", "test");

CREATE TABLE roles(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role INT UNSIGNED NOT NULL);

INSERT INTO roles (role)
VALUES (1);

INSERT INTO roles (role)
VALUES (2);

CREATE TABLE user_roles(
    user_id INT UNSIGNED NOT NULL,
    role_id INT UNSIGNED NOT NULL
   );

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);

CREATE TABLE projects(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
   );

INSERT INTO projects (name)
VALUES ("Проект 1");

INSERT INTO projects (name)
VALUES ("Проект 2");

CREATE TABLE issues(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    project_id INT UNSIGNED NOT NULL,
    reporter_user_id INT UNSIGNED NOT NULL,
    assignee_user_id INT UNSIGNED NOT NULL
   );

INSERT INTO issues (name, description, project_id, reporter_user_id,assignee_user_id )
VALUES ("Задача 1", "Описание 1", 1, 1, 2);

INSERT INTO issues (name, description, project_id, reporter_user_id,assignee_user_id )
VALUES ("Задача 2", "Описание 2", 2, 1, 2);