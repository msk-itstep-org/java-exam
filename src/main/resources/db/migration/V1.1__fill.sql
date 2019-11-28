insert into roles (role)
values ("ROLE_USER"), ("ROLE_DEVELOPER");

insert into users (username, password)
values ("user", "user"), ("developer", "developer");

insert into user_roles (user_id, role_id)
values (1, 1), (2, 1), (2, 2);

insert into projects (name)
values ("Главный проект");

insert into issues (name, description, project_id, reporter_id, assignee_id)
values
    ("Задача 1", "Первая задача", 1, 1, 2),
    ("Задача 2", "Вторая задача", 1, 2, 2);
