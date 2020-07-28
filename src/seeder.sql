use adlister_db;
show create table users;
delete from ads where user_id = 3;

use adlister_db;

INSERT INTO users(username, email, password) VALUES ('stitch808', 'Earth@space.com', 'ohanna');

INSERT INTO ads(user_id, title, description ) VALUES (1, 'Spaceship', 'Used only once.  Has some dents and scratches.  Needs a new engine core and plutonium.  Great side project');

INSERT INTO ads(user_id, title, description ) VALUES (1, 'Toaster', 'Used. Likes to throw toast in your face. Has some dents and scratches.');



INSERT INTO users(username, email, password) VALUES ('pleakly1', 'EarthP@space.com', 'mosquitoes');

INSERT INTO ads(user_id, title, description ) VALUES (2, 'Blond Wig', 'Used a few times.  Lice free.  Downsizing collection.  Need gone ASAP');
