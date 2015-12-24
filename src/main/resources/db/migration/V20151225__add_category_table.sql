drop table if exists category;
create table category(
    code varchar(25) primary key,
    name varchar(55) unique not null,
    describ text null
);

insert into category (code,name) values('001','since'),('002','IT'),('003','media');