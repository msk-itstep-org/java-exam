# Экзамен по курсу JAVA

## Задание

- В системе имеется множество проектов (`Project`).
- В проектах пользователи (`User`) могут заводить задачи (`Issue`).
- В задаче обязательно указывается проект, автор и исполнитель.
- Все данные должны храниться в БД.
- Для работы с системой необходима авторизация.
- Список всех проектов могут видеть все авторизованные пользователи (`ROLE_USER`).
- Список задач проекта могут видеть только привилегированные пользователи (`ROLE_DEVELOPER`).

Допишите данный проект Spring так, чтобы выполнялись условия выше. По желанию можно расширить возможности проекта.

## Выполнение задания

Задание должно выполняться в отдельной ветке репозитория. Имя ветки - ваша фамилия.

Перед запуском проекта не забудьте скопировать файл `local.properties.dist` из папки `src/main/resources`,
назвать его `local.properties`, положить рядом и переопределить в нем настройки проекта.
