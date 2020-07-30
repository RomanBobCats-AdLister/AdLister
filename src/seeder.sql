use adlister_db;
show create table users;
<<<<<<< HEAD

=======
>>>>>>> master

use adlister_db;
TRUNCATE categories;
TRUNCATE ads;
TRUNCATE users;

# insert users
INSERT INTO users(username, email, password) VALUES ('stitch808', 'Earth@space.com', 'ohanna');
INSERT INTO users(username, email, password) VALUES ('pleakly1', 'EarthP@space.com', 'mosquitoes');
INSERT INTO users(username, email, password) VALUES ('sparrowJ', 'black_pearl@pirates.com', 'treasure');
INSERT INTO users(username, email, password) VALUES ('parrH', 'elastigirl@incredibles.com', 'strecthy2000');


INSERT INTO categories (category) VALUES ('clothing');
INSERT INTO categories (category) VALUES ('vehicles');
INSERT INTO categories (category) VALUES ('collectibles');
INSERT INTO categories (category) VALUES ('pets');
INSERT INTO categories (category) VALUES ('household');
INSERT INTO categories (category) VALUES ('beauty');
INSERT INTO categories (category) VALUES ('misc');



INSERT INTO ads(cat_id, title, description ) VALUES (1, 'Spaceship', 'Asking price:  $2 million.   Used only once.  Has some dents and scratches.  Needs a new engine core and plutonium.  Great side project');

INSERT INTO ads(user_id, title, description ) VALUES (1, 'Toaster', 'Used. Likes to throw toast in your face. Has some dents and scratches. $5 OBO');

INSERT INTO ads(user_id, title, description ) VALUES (2, 'Blond Wig', 'Used a few times.  Lice free. Guaranteed to make you look and feel like a sexy earth woman.   Downsizing collection.  Need gone ASAP!  $10 OBO');

INSERT INTO ads(user_id, title, description ) VALUES (3, 'A Jar of Dirt', 'Missing Davey Jones heart, but great condition.   10 gold coins OBO');

INSERT INTO ads(user_id, title, description ) VALUES (3, 'Annoying Monkey', 'Impossible to kill.  Loves to steal.   1 gold coin OBO');

INSERT INTO ads(user_id, title, description ) VALUES (4, 'Super Suit', 'Gray, designed by Alexander Galbaki.  Has a small tear on left shoulder.  Easliy mendable.  Asking $150 OBO');

INSERT INTO ads(user_id, title, description ) VALUES (5, 'Shot gun', 'Selling for a friend.  Used a few times, but not correctly.     decided on peace.   Need gone ASAP!  $800  OBO');

<<<<<<< HEAD
=======
insert into categories(id, category) values (1, 'test');
insert into categories(id, category) values (2, 'Collectible');
insert into categories(id, category) values (3, 'Music');
insert into categories(id, category) values (4, 'Art');
insert into categories(id, category) values (5, 'Other');

insert into ads(cat_id, user_id, title, description) values (2, 1, 'shirt', 'really soft');

Update categories
Set Category = 'Music'
where id = 2;
Update categories
Set Category = 'Art'
where id = 3;
Update categories
Set Category = 'Test'
where id = 4;
Update categories
Set Category = 'Other'
where id = 5;

DELETE from categories where category = 'test';
>>>>>>> master
