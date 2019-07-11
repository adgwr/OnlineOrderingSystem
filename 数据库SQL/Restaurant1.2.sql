DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS lineitem;
DROP TABLE IF EXISTS my_order;
DROP TABLE IF EXISTS food_belong;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS shoppingcart;
DROP TABLE IF EXISTS food;
DROP TABLE IF EXISTS receiver;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS admin_account;

CREATE TABLE admin_account (
	admin_id varchar(100) PRIMARY KEY,
	ad_tel varchar(20),
	password varchar(100),
	issuper TINYINT
);

INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('admin','18000000000','e10adc3949ba59abbe56e057f20f883e', 1);

CREATE TABLE customer (
	c_id varchar(100) PRIMARY KEY,
	c_tel varchar(20),
	c_password varchar(100),
	email varchar(30)
);

INSERT INTO customer VALUES('abc','18100000000','e10adc3949ba59abbe56e057f20f883e','aaa@163.com');
INSERT INTO customer VALUES('abcd','18000000000','e10adc3949ba59abbe56e057f20f883e','bbb@163.com');

CREATE TABLE receiver (
	r_id int PRIMARY KEY AUTO_INCREMENT,
	c_id varchar(30),
	r_name varchar(20),
	address varchar(100),
	r_tel varchar(20),
	isshow TINYINT,
	FOREIGN KEY (c_id) REFERENCES customer (c_id)
);

INSERT INTO receiver(c_id,r_name,address,r_tel,isshow) VALUES('abc','张三','西安市碑林区友谊西路127号','18100000000',1);
INSERT INTO receiver(c_id,r_name,address,r_tel,isshow) VALUES('abc','李四','西安市碑林区友谊西路127号','18200000000',1);

INSERT INTO receiver(c_id,r_name,address,r_tel,isshow) VALUES('abc','王五','西安市碑林区友谊西路127号','18300000000',1);

CREATE TABLE food (
	food_id int PRIMARY KEY AUTO_INCREMENT,
	fd_name varchar(40),
	fd_subname varchar(40),
	fd_image varchar(40),
	fd_price numeric(10, 2),
	fd_description varchar(10000),
	sale_volume int,
	isshow TINYINT
);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('鲜柠香煎银鳕鱼','头盘开胃菜','1.jpg','120','鳕鱼低脂肪、高蛋白，刺少，是老少皆宜的营养食品。鳕鱼具有高营养、低胆固醇、易于被人体吸收等优点。 鳕鱼鱼脂中含有球蛋白、白蛋白及磷的核蛋白，还含有儿童发育所必需的各种氨基酸，其比值和儿童的需要量非常相近，又容易被人消化吸收，还含有不饱和脂肪酸和钙、磷、铁、B族维生素等。',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('四季水果摩卡慕斯','副菜佳肴','2.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('花椰菜生蔬菜沙拉','温婉靓汤','3.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('南非龙虾配澳洲带子','经典西式大餐','4.jpg','208','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('黑椒牛仔骨配黄油西兰花','充饥主菜','5.jpg','168','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('奶豆腐配美味咖喱','甜点','6.jpg','148','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('新西兰羊排配黑椒蘑菇汁','清爽蔬菜','7.jpg','108','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);

CREATE TABLE category (
	category_id int PRIMARY KEY AUTO_INCREMENT,
	category_name varchar(40)
);
INSERT INTO category(category_name) VALUES('主菜');

INSERT INTO category(category_name) VALUES('头盘');

INSERT INTO category(category_name) VALUES('副菜');

INSERT INTO category(category_name) VALUES('靓汤');

INSERT INTO category(category_name) VALUES('蔬果');


CREATE TABLE food_belong (
	food_id int,
	category_id int,
	PRIMARY KEY (food_id, category_id),
	FOREIGN KEY (food_id) REFERENCES food (food_id),
	FOREIGN KEY (category_id) REFERENCES category (category_id)
);

INSERT INTO food_belong(food_id,category_id) VALUES('5','1');

INSERT INTO food_belong(food_id,category_id) VALUES('1','2');

INSERT INTO food_belong(food_id,category_id) VALUES('2','3');

INSERT INTO food_belong(food_id,category_id) VALUES('3','4');

INSERT INTO food_belong(food_id,category_id) VALUES('4','1');

INSERT INTO food_belong(food_id,category_id) VALUES('6','5');

INSERT INTO food_belong(food_id,category_id) VALUES('7','5');

CREATE TABLE my_order (
	order_id int PRIMARY KEY AUTO_INCREMENT,
	c_id varchar(30),
	r_id int,
	order_date varchar(30),
	order_state varchar(10) CHECK (order_state IN (
		'未付款',
		'已付款', 
		'正在配送', 
		'已接单', 
		'待评价',
		'已完成', 
		'已取消'
	)),
	ship_method varchar(10) CHECK (ship_method IN ('商家配送', '到店自取')),
	FOREIGN KEY (c_id) REFERENCES customer (c_id),
	FOREIGN KEY (r_id) REFERENCES receiver (r_id)
);

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-11 18:00:00','已付款','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-12 18:00:00','未付款','商家配送');

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-13 18:00:00','已接单','到店自取');

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abcd',1,'2018-11-14 18:00:00','已付款','商家配送');

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-15 18:00:00','已取消','商家配送');


CREATE TABLE lineitem (
	order_id int,
	food_id int,
	amount int,
	total_price numeric(10,2),
	PRIMARY KEY (order_id, food_id),
	FOREIGN KEY (order_id) REFERENCES my_order (order_id),
	FOREIGN KEY (food_id) REFERENCES food (food_id)
);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(1,2,2,300);

INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(1,3,3,600);

INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(2,1,1,200);

INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(3,1,4,500);

INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(3,5,5,700);

INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(4,4,1,300);

INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(5,5,3,400);

CREATE TABLE shoppingcart (
	c_id varchar(30),
	food_id int,
	amount int,
	PRIMARY KEY (c_id, food_id),
	FOREIGN KEY (c_id) REFERENCES customer (c_id),
	FOREIGN KEY (food_id) REFERENCES food (food_id)
);

INSERT INTO shoppingcart values('abc',1,2);
INSERT INTO shoppingcart values('abc',2,1);
INSERT INTO shoppingcart values('abc',3,1);


CREATE TABLE comments (
	order_id int,
	food_id int,
	comment varchar(10000),
	comment_date varchar(30),
	PRIMARY KEY (order_id, food_id),
	FOREIGN KEY (order_id) REFERENCES my_order (order_id),
	FOREIGN KEY (food_id) REFERENCES food (food_id)
);

INSERT INTO comments(order_id, food_id, comment) values(1,2,'好吃!' );

CREATE TABLE collections (
	c_id varchar(30),
	food_id int,
	PRIMARY KEY (c_id, food_id),
	FOREIGN KEY (c_id) REFERENCES customer (c_id),
	FOREIGN KEY (food_id) REFERENCES food (food_id)
);

INSERT INTO collections values('abc',1);
INSERT INTO collections values('abc',2);
INSERT INTO collections values('abcd',3);