CREATE TABLE `test`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) UNIQUE NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `test`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE IF NOT EXISTS `test`.`user_roles` (
    `user_id` INT UNSIGNED NOT NULL REFERENCES `users`(`id`),
    `role_id` INT UNSIGNED NOT NULL REFERENCES `roles`(`id`),
    PRIMARY KEY (`user_id`, `role_id`));

    CREATE TABLE `test`.`projects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `test`.`issues` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) UNIQUE NOT NULL,
  `description` VARCHAR(100) NULL,
  `project_id` INT UNSIGNED NOT NULL REFERENCES `projects`(`id`),
  `user_reporter_id` INT UNSIGNED NOT NULL REFERENCES `users`(`id`),
  `user_assignee_id` INT UNSIGNED NOT NULL REFERENCES `users`(`id`),
  PRIMARY KEY (`id`));
