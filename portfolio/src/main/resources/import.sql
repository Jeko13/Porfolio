delete from users;
insert into users (id, username, password, userrole) values (null, 'zk', 'zk', 'admin');

delete from products;
insert into products (id, productname, createDate, price) values (null, 'Tirage 10x15', CURRENT_TIMESTAMP, 1.5);
insert into products (id, productname, createDate, price) values (null, 'Tirage 13x18', CURRENT_TIMESTAMP, 3.0);
insert into products (id, productname, createDate, price) values (null, 'Tirage 20x30', CURRENT_TIMESTAMP, 5.0);
insert into products (id, productname, createDate, price) values (null, 'Tirage 30x45', CURRENT_TIMESTAMP, 18.0);

delete from galleries;
insert into galleries (id, galleryname, createDate, updateDate) values (null, 'Galerie 1', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into galleries (id, galleryname, createDate, updateDate) values (null, 'Galerie 2', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

delete from photos;
insert into photos (id, photoname, createDate, available, imgPath,photoindex,gallery_id) values (null, 'Cookies', CURRENT_TIMESTAMP, true, '/image/cookie.jpg',1,1);
insert into photos (id, photoname, createDate, available, imgPath,photoindex,gallery_id) values (null, 'Toast', CURRENT_TIMESTAMP, true, '/image/toast.jpg',2,1);
insert into photos (id, photoname, createDate, available, imgPath,photoindex,gallery_id) values (null, 'Chocolate', CURRENT_TIMESTAMP, true, '/image/chocolate.jpg',4,1);
insert into photos (id, photoname, createDate, available, imgPath,photoindex,gallery_id) values (null, 'Butter', CURRENT_TIMESTAMP, true, '/image/butter.jpg',3,2);
insert into photos (id, photoname, createDate, available, imgPath,photoindex,gallery_id) values (null, 'Milk', CURRENT_TIMESTAMP, true, '/image/milk.jpg',6,2);
insert into photos (id, photoname, createDate, available, imgPath,photoindex,gallery_id) values (null, 'Coffee Powder', CURRENT_TIMESTAMP, true, '/image/coffee.jpg',5,2);