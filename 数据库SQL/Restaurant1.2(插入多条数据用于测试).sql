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
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad1','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad2','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad3','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad4','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad5','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad6','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad7','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad8','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad9','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad10','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad11','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad12','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad13','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad14','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad15','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad16','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad17','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad18','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad19','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO admin_account(admin_id, ad_tel, password, issuper) VALUES('ad20','18000000000','e10adc3949ba59abbe56e057f20f883e', 0);

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

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('1鲜柠香煎银鳕鱼','头盘开胃菜','1.jpg','120','鳕鱼低脂肪、高蛋白，刺少，是老少皆宜的营养食品。鳕鱼具有高营养、低胆固醇、易于被人体吸收等优点。 鳕鱼鱼脂中含有球蛋白、白蛋白及磷的核蛋白，还含有儿童发育所必需的各种氨基酸，其比值和儿童的需要量非常相近，又容易被人消化吸收，还含有不饱和脂肪酸和钙、磷、铁、B族维生素等。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('2四季水果摩卡慕斯','副菜佳肴','2.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('3花椰菜生蔬菜沙拉','温婉靓汤','3.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('4南非龙虾配澳洲带子','经典西式大餐','4.jpg','208','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('5黑椒牛仔骨配黄油西兰花','充饥主菜','5.jpg','168','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('6奶豆腐配美味咖喱','甜点','6.jpg','148','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('7新西兰羊排配黑椒蘑菇汁','清爽蔬菜','7.jpg','108','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('8鲜柠香煎银鳕鱼','头盘开胃菜','1.jpg','120','鳕鱼低脂肪、高蛋白，刺少，是老少皆宜的营养食品。鳕鱼具有高营养、低胆固醇、易于被人体吸收等优点。 鳕鱼鱼脂中含有球蛋白、白蛋白及磷的核蛋白，还含有儿童发育所必需的各种氨基酸，其比值和儿童的需要量非常相近，又容易被人消化吸收，还含有不饱和脂肪酸和钙、磷、铁、B族维生素等。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('9四季水果摩卡慕斯','副菜佳肴','2.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('10花椰菜生蔬菜沙拉','温婉靓汤','3.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('11南非龙虾配澳洲带子','经典西式大餐','4.jpg','208','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('12黑椒牛仔骨配黄油西兰花','充饥主菜','5.jpg','168','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('13奶豆腐配美味咖喱','甜点','6.jpg','148','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('14新西兰羊排配黑椒蘑菇汁','清爽蔬菜','7.jpg','108','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('15鲜柠香煎银鳕鱼','头盘开胃菜','1.jpg','120','鳕鱼低脂肪、高蛋白，刺少，是老少皆宜的营养食品。鳕鱼具有高营养、低胆固醇、易于被人体吸收等优点。 鳕鱼鱼脂中含有球蛋白、白蛋白及磷的核蛋白，还含有儿童发育所必需的各种氨基酸，其比值和儿童的需要量非常相近，又容易被人消化吸收，还含有不饱和脂肪酸和钙、磷、铁、B族维生素等。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('16四季水果摩卡慕斯','副菜佳肴','2.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('17花椰菜生蔬菜沙拉','温婉靓汤','3.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('18南非龙虾配澳洲带子','经典西式大餐','4.jpg','208','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('19黑椒牛仔骨配黄油西兰花','充饥主菜','5.jpg','168','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('20奶豆腐配美味咖喱','甜点','6.jpg','148','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('21新西兰羊排配黑椒蘑菇汁','清爽蔬菜','7.jpg','108','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('22鲜柠香煎银鳕鱼','头盘开胃菜','1.jpg','120','鳕鱼低脂肪、高蛋白，刺少，是老少皆宜的营养食品。鳕鱼具有高营养、低胆固醇、易于被人体吸收等优点。 鳕鱼鱼脂中含有球蛋白、白蛋白及磷的核蛋白，还含有儿童发育所必需的各种氨基酸，其比值和儿童的需要量非常相近，又容易被人消化吸收，还含有不饱和脂肪酸和钙、磷、铁、B族维生素等。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('23四季水果摩卡慕斯','副菜佳肴','2.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('24花椰菜生蔬菜沙拉','温婉靓汤','3.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('25南非龙虾配澳洲带子','经典西式大餐','4.jpg','208','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('26黑椒牛仔骨配黄油西兰花','充饥主菜','5.jpg','168','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('27奶豆腐配美味咖喱','甜点','6.jpg','148','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('28新西兰羊排配黑椒蘑菇汁','清爽蔬菜','7.jpg','108','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('29鲜柠香煎银鳕鱼','头盘开胃菜','1.jpg','120','鳕鱼低脂肪、高蛋白，刺少，是老少皆宜的营养食品。鳕鱼具有高营养、低胆固醇、易于被人体吸收等优点。 鳕鱼鱼脂中含有球蛋白、白蛋白及磷的核蛋白，还含有儿童发育所必需的各种氨基酸，其比值和儿童的需要量非常相近，又容易被人消化吸收，还含有不饱和脂肪酸和钙、磷、铁、B族维生素等。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('30四季水果摩卡慕斯','副菜佳肴','2.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('31花椰菜生蔬菜沙拉','温婉靓汤','3.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('32南非龙虾配澳洲带子','经典西式大餐','4.jpg','208','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('33黑椒牛仔骨配黄油西兰花','充饥主菜','5.jpg','168','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('34奶豆腐配美味咖喱','甜点','6.jpg','148','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('35新西兰羊排配黑椒蘑菇汁','清爽蔬菜','7.jpg','108','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('36鲜柠香煎银鳕鱼','头盘开胃菜','1.jpg','120','鳕鱼低脂肪、高蛋白，刺少，是老少皆宜的营养食品。鳕鱼具有高营养、低胆固醇、易于被人体吸收等优点。 鳕鱼鱼脂中含有球蛋白、白蛋白及磷的核蛋白，还含有儿童发育所必需的各种氨基酸，其比值和儿童的需要量非常相近，又容易被人消化吸收，还含有不饱和脂肪酸和钙、磷、铁、B族维生素等。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('37四季水果摩卡慕斯','副菜佳肴','2.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('38花椰菜生蔬菜沙拉','温婉靓汤','3.jpg','198','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('39南非龙虾配澳洲带子','经典西式大餐','4.jpg','208','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('40黑椒牛仔骨配黄油西兰花','充饥主菜','5.jpg','168','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('41奶豆腐配美味咖喱','甜点','6.jpg','148','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('42新西兰羊排配黑椒蘑菇汁','清爽蔬菜','7.jpg','108','龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。龙虾一般分两种，一种是大西洋龙虾，以加拿大，美国波士顿最出名，特点是有一对很大的钳子；另一种是太平洋龙虾，从日本一直到我国南海到澳洲都有，它的钳子显然较细。那么出产澳大利亚的龙虾比较肥大有名，就经常叫这种龙虾为澳洲龙虾，应该讲澳大利亚不是唯一的原产地。',1);

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

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-11 18:00:00','已完成','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-12 18:00:00','未付款','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-13 18:00:00','已接单','到店自取');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abcd',1,'2018-11-14 18:00:00','已完成','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-15 18:00:00','已取消','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-11 18:00:00','已付款','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-12 18:00:00','未付款','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-13 18:00:00','已接单','到店自取');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abcd',1,'2018-11-14 18:00:00','已付款','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-15 18:00:00','已取消','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-11 18:00:00','已付款','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-12 18:00:00','未付款','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-13 18:00:00','已接单','到店自取');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abcd',1,'2018-11-14 18:00:00','已付款','商家配送');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-15 18:00:00','已取消','商家配送');
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
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(6,2,2,300);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(6,3,3,600);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(7,1,1,200);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(8,1,4,500);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(9,5,5,700);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(10,4,1,300);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(11,5,3,400);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(12,2,2,300);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(12,3,3,600);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(13,2,2,300);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(13,3,3,600);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(14,1,1,200);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(15,1,4,500);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(15,5,5,700);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(16,4,1,300);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(17,5,3,400);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(18,2,2,300);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(18,3,3,600);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(19,1,1,200);
INSERT INTO lineitem(order_id,food_id,amount,total_price) VALUES(20,1,4,500);

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

INSERT INTO comments(order_id, food_id, comment, comment_date) values(1,2,'1好吃!' ,'2018-11-14 18:00:01');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(2,2,'2好吃!','2018-11-14 18:00:02' );
INSERT INTO comments(order_id, food_id, comment, comment_date) values(3,2,'1好吃!' ,'2018-11-14 18:00:03');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(4,2,'2好吃!' ,'2018-11-14 18:00:04');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(5,2,'1好吃!' ,'2018-11-14 18:00:05');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(6,2,'2好吃!' ,'2018-11-14 18:00:06');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(7,2,'1好吃!' ,'2018-11-14 18:00:07');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(8,2,'2好吃!' ,'2018-11-14 18:00:08');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(9,2,'1好吃!' ,'2018-11-14 18:00:09');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(10,2,'2好吃!' ,'2018-11-14 18:00:10');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(11,2,'1好吃!' ,'2018-11-14 18:00:11');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(12,2,'2好吃!' ,'2018-11-14 18:00:12');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(13,2,'1好吃!' ,'2018-11-14 18:00:13');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(14,2,'2好吃!' ,'2018-11-14 18:00:14');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(15,2,'1好吃!' ,'2018-11-14 18:00:15');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(16,2,'2好吃!' ,'2018-11-14 18:00:16');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(17,2,'1好吃!' ,'2018-11-14 18:00:17');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(18,2,'2好吃!' ,'2018-11-14 18:00:18');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(19,2,'1好吃!' ,'2018-11-14 18:00:19');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(20,2,'2好吃!' ,'2018-11-14 18:00:20');



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
INSERT INTO collections values('abc',3);
INSERT INTO collections values('abc',4);
INSERT INTO collections values('abc',5);
INSERT INTO collections values('abc',6);
INSERT INTO collections values('abc',7);
INSERT INTO collections values('abc',8);
INSERT INTO collections values('abc',9);
INSERT INTO collections values('abc',10);
INSERT INTO collections values('abc',11);
INSERT INTO collections values('abc',12);
INSERT INTO collections values('abc',13);
INSERT INTO collections values('abc',14);
INSERT INTO collections values('abc',15);
INSERT INTO collections values('abc',16);
INSERT INTO collections values('abc',17);
INSERT INTO collections values('abc',18);
INSERT INTO collections values('abc',19);
INSERT INTO collections values('abc',20);
INSERT INTO collections values('abc',21);
INSERT INTO collections values('abc',22);
INSERT INTO collections values('abc',23);
INSERT INTO collections values('abc',24);
INSERT INTO collections values('abc',25);
INSERT INTO collections values('abc',26);
INSERT INTO collections values('abc',27);
INSERT INTO collections values('abc',28);
INSERT INTO collections values('abc',29);
INSERT INTO collections values('abc',30);
INSERT INTO collections values('abc',31);
INSERT INTO collections values('abc',32);
INSERT INTO collections values('abc',33);
INSERT INTO collections values('abc',34);
INSERT INTO collections values('abc',35);
INSERT INTO collections values('abc',36);
INSERT INTO collections values('abc',37);
INSERT INTO collections values('abc',38);
INSERT INTO collections values('abc',39);
INSERT INTO collections values('abc',40);
INSERT INTO collections values('abc',41);