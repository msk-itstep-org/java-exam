CREATE TABLE afonin_db.projects (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    UNIQUE index (role)
);

CREATE TABLE afonin_db.roles (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(25),
);

CREATE TABLE afonin_db.users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(25),
    password VARCHAR(25),
    UNIQUE index (username)
);

CREATE TABLE afonin_db.user_roles (
    user_id INT NOT NULL REFERENCES users (id),
    role_id INT NOT NULL REFERENCES roles (id),,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE afonin_db.issues (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    project_id INT NOT NULL REFERENCES projects (id),
    reporter_id NOT NULL REFERENCES users (id),
    assignee_id NOT NULL REFERENCES users (id),
);




