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

INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('1�������������','ͷ�̿�θ��','1.jpg','120','�����֬�����ߵ��ף����٣������ٽ��˵�Ӫ��ʳƷ��������и�Ӫ�����͵��̴������ڱ��������յ��ŵ㡣 ������֬�к����򵰰ס��׵��׼��׵ĺ˵��ף������ж�ͯ����������ĸ��ְ����ᣬ���ֵ�Ͷ�ͯ����Ҫ���ǳ�����������ױ����������գ������в�����֬����͸ơ��ס�����B��ά���صȡ�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('2�ļ�ˮ��Ħ��Ľ˹','���˼���','2.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('3��Ҭ�����߲�ɳ��','��������','3.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('4�Ϸ���Ϻ����޴���','������ʽ���','4.jpg','208','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('5�ڽ�ţ�й������������','�伢����','5.jpg','168','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('6�̶�������ζ���','���','6.jpg','148','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('7������������ڽ�Ģ��֭','��ˬ�߲�','7.jpg','108','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('8�������������','ͷ�̿�θ��','1.jpg','120','�����֬�����ߵ��ף����٣������ٽ��˵�Ӫ��ʳƷ��������и�Ӫ�����͵��̴������ڱ��������յ��ŵ㡣 ������֬�к����򵰰ס��׵��׼��׵ĺ˵��ף������ж�ͯ����������ĸ��ְ����ᣬ���ֵ�Ͷ�ͯ����Ҫ���ǳ�����������ױ����������գ������в�����֬����͸ơ��ס�����B��ά���صȡ�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('9�ļ�ˮ��Ħ��Ľ˹','���˼���','2.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('10��Ҭ�����߲�ɳ��','��������','3.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('11�Ϸ���Ϻ����޴���','������ʽ���','4.jpg','208','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('12�ڽ�ţ�й������������','�伢����','5.jpg','168','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('13�̶�������ζ���','���','6.jpg','148','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('14������������ڽ�Ģ��֭','��ˬ�߲�','7.jpg','108','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('15�������������','ͷ�̿�θ��','1.jpg','120','�����֬�����ߵ��ף����٣������ٽ��˵�Ӫ��ʳƷ��������и�Ӫ�����͵��̴������ڱ��������յ��ŵ㡣 ������֬�к����򵰰ס��׵��׼��׵ĺ˵��ף������ж�ͯ����������ĸ��ְ����ᣬ���ֵ�Ͷ�ͯ����Ҫ���ǳ�����������ױ����������գ������в�����֬����͸ơ��ס�����B��ά���صȡ�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('16�ļ�ˮ��Ħ��Ľ˹','���˼���','2.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('17��Ҭ�����߲�ɳ��','��������','3.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('18�Ϸ���Ϻ����޴���','������ʽ���','4.jpg','208','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('19�ڽ�ţ�й������������','�伢����','5.jpg','168','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('20�̶�������ζ���','���','6.jpg','148','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('21������������ڽ�Ģ��֭','��ˬ�߲�','7.jpg','108','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('22�������������','ͷ�̿�θ��','1.jpg','120','�����֬�����ߵ��ף����٣������ٽ��˵�Ӫ��ʳƷ��������и�Ӫ�����͵��̴������ڱ��������յ��ŵ㡣 ������֬�к����򵰰ס��׵��׼��׵ĺ˵��ף������ж�ͯ����������ĸ��ְ����ᣬ���ֵ�Ͷ�ͯ����Ҫ���ǳ�����������ױ����������գ������в�����֬����͸ơ��ס�����B��ά���صȡ�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('23�ļ�ˮ��Ħ��Ľ˹','���˼���','2.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('24��Ҭ�����߲�ɳ��','��������','3.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('25�Ϸ���Ϻ����޴���','������ʽ���','4.jpg','208','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('26�ڽ�ţ�й������������','�伢����','5.jpg','168','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('27�̶�������ζ���','���','6.jpg','148','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('28������������ڽ�Ģ��֭','��ˬ�߲�','7.jpg','108','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('29�������������','ͷ�̿�θ��','1.jpg','120','�����֬�����ߵ��ף����٣������ٽ��˵�Ӫ��ʳƷ��������и�Ӫ�����͵��̴������ڱ��������յ��ŵ㡣 ������֬�к����򵰰ס��׵��׼��׵ĺ˵��ף������ж�ͯ����������ĸ��ְ����ᣬ���ֵ�Ͷ�ͯ����Ҫ���ǳ�����������ױ����������գ������в�����֬����͸ơ��ס�����B��ά���صȡ�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('30�ļ�ˮ��Ħ��Ľ˹','���˼���','2.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('31��Ҭ�����߲�ɳ��','��������','3.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('32�Ϸ���Ϻ����޴���','������ʽ���','4.jpg','208','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('33�ڽ�ţ�й������������','�伢����','5.jpg','168','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('34�̶�������ζ���','���','6.jpg','148','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('35������������ڽ�Ģ��֭','��ˬ�߲�','7.jpg','108','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('36�������������','ͷ�̿�θ��','1.jpg','120','�����֬�����ߵ��ף����٣������ٽ��˵�Ӫ��ʳƷ��������и�Ӫ�����͵��̴������ڱ��������յ��ŵ㡣 ������֬�к����򵰰ס��׵��׼��׵ĺ˵��ף������ж�ͯ����������ĸ��ְ����ᣬ���ֵ�Ͷ�ͯ����Ҫ���ǳ�����������ױ����������գ������в�����֬����͸ơ��ס�����B��ά���صȡ�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('37�ļ�ˮ��Ħ��Ľ˹','���˼���','2.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('38��Ҭ�����߲�ɳ��','��������','3.jpg','198','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('39�Ϸ���Ϻ����޴���','������ʽ���','4.jpg','208','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('40�ڽ�ţ�й������������','�伢����','5.jpg','168','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('41�̶�������ζ���','���','6.jpg','148','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);
INSERT INTO food(fd_name,fd_subname,fd_image,fd_price,fd_description,isshow) VALUES('42������������ڽ�Ģ��֭','��ˬ�߲�','7.jpg','108','��Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء���Ϻһ������֣�һ���Ǵ�������Ϻ���Լ��ô�������ʿ����������ص�����һ�Ժܴ��ǯ�ӣ���һ����̫ƽ����Ϻ�����ձ�һֱ���ҹ��Ϻ������޶��У�����ǯ����Ȼ��ϸ����ô�����Ĵ����ǵ���Ϻ�ȽϷʴ��������;�����������ϺΪ������Ϻ��Ӧ�ý��Ĵ����ǲ���Ψһ��ԭ���ء�',1);

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

INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-11 18:00:00','�����','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-12 18:00:00','δ����','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-13 18:00:00','�ѽӵ�','������ȡ');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abcd',1,'2018-11-14 18:00:00','�����','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-15 18:00:00','��ȡ��','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-11 18:00:00','�Ѹ���','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-12 18:00:00','δ����','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-13 18:00:00','�ѽӵ�','������ȡ');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abcd',1,'2018-11-14 18:00:00','�Ѹ���','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-15 18:00:00','��ȡ��','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-11 18:00:00','�Ѹ���','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-12 18:00:00','δ����','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',1,'2018-11-13 18:00:00','�ѽӵ�','������ȡ');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abcd',1,'2018-11-14 18:00:00','�Ѹ���','�̼�����');
INSERT INTO my_order(c_id,r_id,order_date,order_state,ship_method) VALUES('abc',2,'2018-11-15 18:00:00','��ȡ��','�̼�����');
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

INSERT INTO comments(order_id, food_id, comment, comment_date) values(1,2,'1�ó�!' ,'2018-11-14 18:00:01');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(2,2,'2�ó�!','2018-11-14 18:00:02' );
INSERT INTO comments(order_id, food_id, comment, comment_date) values(3,2,'1�ó�!' ,'2018-11-14 18:00:03');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(4,2,'2�ó�!' ,'2018-11-14 18:00:04');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(5,2,'1�ó�!' ,'2018-11-14 18:00:05');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(6,2,'2�ó�!' ,'2018-11-14 18:00:06');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(7,2,'1�ó�!' ,'2018-11-14 18:00:07');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(8,2,'2�ó�!' ,'2018-11-14 18:00:08');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(9,2,'1�ó�!' ,'2018-11-14 18:00:09');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(10,2,'2�ó�!' ,'2018-11-14 18:00:10');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(11,2,'1�ó�!' ,'2018-11-14 18:00:11');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(12,2,'2�ó�!' ,'2018-11-14 18:00:12');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(13,2,'1�ó�!' ,'2018-11-14 18:00:13');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(14,2,'2�ó�!' ,'2018-11-14 18:00:14');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(15,2,'1�ó�!' ,'2018-11-14 18:00:15');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(16,2,'2�ó�!' ,'2018-11-14 18:00:16');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(17,2,'1�ó�!' ,'2018-11-14 18:00:17');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(18,2,'2�ó�!' ,'2018-11-14 18:00:18');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(19,2,'1�ó�!' ,'2018-11-14 18:00:19');
INSERT INTO comments(order_id, food_id, comment, comment_date) values(20,2,'2�ó�!' ,'2018-11-14 18:00:20');



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