use adlister_db;
show create table users;
delete from ads where user_id = 3;

use adlister_db;
TRUNCATE ads;
INSERT INTO users(username, email, password) VALUES ('stitch808', 'Earth@space.com', 'ohanna');

INSERT INTO ads(user_id, title, description ) VALUES (1, 'Spaceship', 'Asking price:  $2 million.   Used only once.  Has some dents and scratches.  Needs a new engine core and plutonium.  Great side project');

INSERT INTO ads(user_id, title, description ) VALUES (1, 'Toaster', 'Used. Likes to throw toast in your face. Has some dents and scratches. $5 OBO');



INSERT INTO users(username, email, password) VALUES ('pleakly1', 'EarthP@space.com', 'mosquitoes');

INSERT INTO ads(user_id, title, description ) VALUES (2, 'Blond Wig', 'Used a few times.  Lice free. Guaranteed to make you look and feel like a sexy earth woman.   Downsizing collection.  Need gone ASAP!  $10 OBO');


INSERT INTO ads(user_id, title, description ) VALUES (3, 'Shot gun', 'Selling for a friend.  Used a few times, but not correctly.     decided on peace.   Need gone ASAP!  $800  OBO');