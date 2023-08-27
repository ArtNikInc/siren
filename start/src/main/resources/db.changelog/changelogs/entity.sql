--liquibase formatted sql

--changeset nkozlov:users
CREATE TABLE users
(
    id          UUID NOT NULL PRIMARY KEY,
    login       varchar(250) NOT NULL,
    password    varchar(250) NOT NULL,
    name    varchar(250) NOT NULL,
    logo_url    varchar(250)
);
CREATE INDEX users_id_index ON users (id);
--comment: Добавлена таблица comment

--changeset nkozlov:posts
CREATE TABLE posts
(
    id           UUID          NOT NULL PRIMARY KEY,
    title        varchar(250)  NOT NULL,
    sub_title     varchar(250)  NOT NULL,
    body         text          NOT NULL,
    created_at    timestamp     NOT NULL,
    published_at  timestamp     NOT NULL
);
CREATE INDEX post_id_index ON posts (id);
--comment: Добавлена таблица post
