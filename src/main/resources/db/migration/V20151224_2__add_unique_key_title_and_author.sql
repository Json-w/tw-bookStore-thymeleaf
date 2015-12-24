alter table book
add constraint uc_bookId unique (title,author)