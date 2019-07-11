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

INSERT INTO receiver(c_id,r_name,address,r_tel,isshow) VALUES('abc','����','�����б�����������·127��','18100000000',1);
INSERT INTO receiver(c_id,r_name,address,r_tel,isshow) VALUES('abc','����','�����б�����������·127��','18200000000',1);

INSERT INTO receiver(c_id,r_name,address,r_tel,isshow) VALUES('abc','����','�����б�����������·127��','18300000000',1);

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

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('�������������','ͷ�̿�θ��','1.jpg','120','�����֬�����ߵ��ף����٣������ٽ��˵�Ӫ��ʳƷ��������и�Ӫ�����͵��̴������ڱ��������յ��ŵ㡣 ������֬�к����򵰰ס��׵��׼��׵ĺ˵��ף������ж�ͯ����������ĸ��ְ����ᣬ���ֵ�Ͷ�ͯ����Ҫ���ǳ�����������ױ����������գ������в�����֬����͸ơ��ס�����B��ά���صȡ�',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('�ļ�ˮ��Ħ��Ľ˹','���˼���','2.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('��Ҭ�����߲�ɳ��','��������','3.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('�Ϸ���Ϻ����޴���','������ʽ���','4.jpg','208','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('�ڽ�ţ�й������������','�伢����','5.jpg','168','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('�̶�������ζ���','���','6.jpg','148','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('������������ڽ�Ģ��֭','��ˬ�߲�','7.jpg','108','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);

CREATE TABLE category (
	category_id int PRIMARY KEY AUTO_INCREMENT,
	category_name varchar(40)
);
INSERT INTO category(category_name) VALUES('����');

INSERT INTO category(category_name) VALUES('ͷ��');

INSERT INTO category(category_name) VALUES('����');

INSERT INTO category(category_name) VALUES('����');

INSERT INTO category(category_name) VALUES('�߹�');


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
		'δ����',
		'�Ѹ���', 
		'��������', 
		'�ѽӵ�', 
		'������',
		'�����', 
		'��ȡ��'
	)),
	ship_method varchar(10) CHECK (ship_method IN ('�̼�����', '������ȡ')),
	FOREIGN KEY (c_id) REFERENCES customer (c_id),
	FOREIGN KEY (r_id) REFERENCES receiver (r_id)
);

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-11 18:00:00','�Ѹ���','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-12 18:00:00','δ����','�̼�����');

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-13 18:00:00','�ѽӵ�','������ȡ');

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abcd',1,'2018-11-14 18:00:00','�Ѹ���','�̼�����');

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-15 18:00:00','��ȡ��','�̼�����');


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

INSERT INTO comments(order_id, food_id, comment) values(1,2,'�ó�!' );

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