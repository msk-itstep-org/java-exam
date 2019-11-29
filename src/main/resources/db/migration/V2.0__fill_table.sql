INSERT INTO `test`.`users` (`username`, `password`) VALUES ('admin', 'admin');
INSERT INTO `test`.`users` (`username`, `password`) VALUES ('user', 'user');

INSERT INTO `test`.`roles` (`role`) VALUES ('ROLE_USER');
INSERT INTO `test`.`roles` (`role`) VALUES ('ROLE_DEVELOPER');

INSERT INTO `test`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `test`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '1');

INSERT INTO `test`.`projects` (`name`) VALUES ('Some_project');
INSERT INTO `test`.`projects` (`name`) VALUES ('Another_project');

INSERT INTO `test`.`issues` (`name`, `project_id`, `user_reporter_id`, `user_assignee_id`) VALUES ('Some_issue', '1', '1', '2');
INSERT INTO `test`.`issues` (`name`, `project_id`, `user_reporter_id`, `user_assignee_id`) VALUES ('Another_issue', '2', '2', '1');
INSERT INTO `test`.`issues` (`name`, `project_id`, `user_reporter_id`, `user_assignee_id`) VALUES ('Some_other_issue', '1', '2', '2');
