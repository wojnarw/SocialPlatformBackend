create table posts (
    id bigint not null auto_increment,
    author varchar(255) not null,
    content longtext not null,
    post_date datetime not null,
    view_count bigint not null,
    primary key(id)
);


insert into posts (id, author, content, post_date, view_count) values (1, 'autor1', 'tresc1', CURRENT_TIMESTAMP, 0);
insert into posts (id, author, content, post_date, view_count) values (2, 'autor2', 'tresc2', CURRENT_TIMESTAMP, 0);
insert into posts (id, author, content, post_date, view_count) values (3, 'autor3', 'tresc3', CURRENT_TIMESTAMP, 0);
-- insert into posts (author, content, post_date, view_count) values ('autor1', 'tresc1', '20100301', 0);
-- insert into posts (author, content, post_date, view_count) values ('autor2', 'tresc2', '2022-12-12 12:12', 0);
-- insert into posts (author, content, post_date, view_count) values ('autor3', 'tresc3', '20100301', 0);