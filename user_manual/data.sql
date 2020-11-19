create table users(id INTEGER PRIMARY KEY,email varchar(255) unique,name varchar(255),password varchar(255));
create table books(id int primary key,title varchar(255),description varchar(255),rating int);
create table seller_book(id int primary key,seller_id int references users(id),price int,book_id int referenc
         es books(id),date int);
create table orders(id int primary key,buy_id int references users(id),seller_b_id int references seller_book
         (id),price int,status varchar(255));
create table carts(id int primary key,seller_book_id int references seller_book(id),user_id int references us
         ers(id));
