CREATE TABLE IF NOT EXISTS posts (
    id bigint not null auto_increment,
    author varchar(64) not null,
    content text(65000) not null,
    post_date datetime not null,
    view_count bigint not null,
    primary key(id)
);