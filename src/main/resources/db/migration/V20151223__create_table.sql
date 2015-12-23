drop table if exists book;
create table book(
    isbn varchar(30) primary key,
    name varchar(100) not null,
    author varchar(50) not null,
    price double not null
);
insert into book(isbn,name,author,price) values('12345600','test book','test author',23.43)