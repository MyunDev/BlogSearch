drop table if exists keyword CASCADE;

create table keyword
(
    id       bigint    not null unique auto_increment,
    edit_dtm timestamp,
    count    integer,
    keyword  varchar(255),
    reg_dtm  timestamp not null,
    primary key (id)
);