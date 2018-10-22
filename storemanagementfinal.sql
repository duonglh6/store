create database storemanagement char set utf8 collate utf8_general_ci;
use storemanagement;
create table role(
 role_id integer not null auto_increment,
 role_name nvarchar(30),
 primary key (role_id)
);
create table user(
 user_id integer not null auto_increment,
 full_name nvarchar(30),
 dob datetime,
 phone_number char(12),
 address nvarchar(100),
 gender tinyint,
 identity_number char(14),
 email nvarchar(50),
 username varchar(50) not null,
 password varchar(50) not null,
 role_id integer not null,
 primary key (user_id),
 constraint fk_user_role foreign key(role_id)
 references role(role_id)
);


create table catalogue(
  catalogue_id integer not null auto_increment,
  catalogue_name nvarchar(50),
  catalogue_path text,
  primary key (catalogue_id)
);



create table product(
 product_id integer not null auto_increment,
 product_name nvarchar(100),
 giatien varchar(50),
 description text,
 product_path text,
 catalogue_id integer,
 primary key(product_id),
 constraint fk_product_catalogue foreign key(catalogue_id) references catalogue(catalogue_id)
 
);
create table color(
  color_id integer auto_increment,
  color_name nvarchar(50),
  primary key(color_id)
);
create table size(
  size_id integer auto_increment,
  size nvarchar(20),
  primary key(size_id)
);
create table product_detail(
detail_id integer auto_increment,
product_id integer,
size_id integer,
color_id integer,
amount integer,
start_date timestamp,
primary key(detail_id),
constraint fk_detail_product foreign key(product_id) references product(product_id),
constraint fk_detail_size foreign key(size_id) references size(size_id),
constraint fk_detail_color foreign key(color_id) references color(color_id)
);
create table promotion(
   promotion_id integer auto_increment,
   promotion_name nvarchar(200),
   start_promotion datetime,
   end_promotion datetime,
   description text,
   promotion_type text,
   primary key(promotion_id)
   
);
create table promotion_detail(
   detail_id integer auto_increment,
   promotion_id integer,
   product_id integer,
   sale_off integer,
   primary key(detail_id),
   constraint fk_promotion_detail_product foreign key(product_id) references product(product_id),
   constraint fk_promotion_detail_promotion foreign key(promotion_id) references promotion(promotion_id)
);
create table bill(
  bill_id integer auto_increment,
  user_id integer,
  phone_number char(12),
  address nvarchar(200),
  status tinyint,
  delivery_date datetime,
  primary key(bill_id),
  constraint fk_bill_user foreign key(user_id) references user(user_id)
);
create table comment(
  comment_id integer auto_increment,
  content text,
  product_id integer,
  user_id integer,
  primary key (comment_id),
  constraint fk_comment_user foreign key(user_id) references user(user_id),
  constraint fk_comment_product foreign key(product_id) references product(product_id)
  
);
create table bill_detail(
  bill_detail_id integer auto_increment,
  bill_id integer ,
  product_id integer,
  amount integer,
  price varchar(100),
  primary key (bill_detail_id),
    constraint fk_bill_detail_bill foreign key(bill_id) references bill(bill_id),
  constraint fk_bill_detail_product foreign key(product_id) references product(product_id)
)