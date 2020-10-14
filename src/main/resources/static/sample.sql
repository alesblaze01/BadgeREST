use test;
insert into users(user_id,fullname,salt,username) values(1,'username1','User1','user1 Salt');
insert into users(user_id,fullname,salt,username) values(2,'username2','User2','user2 Salt');
insert into users(user_id,fullname,salt,username) values(3,'username3','User3','user3 Salt');

insert into badges(badge_id,badge_name,badge_description,badge_logo,issuer_id) values(1,'Badge1','Badge1 desc','Badge1 logo',1);
insert into badges(badge_id,badge_name,badge_description,badge_logo,issuer_id) values(2,'Badge2','Badge2 desc','Badge2 logo',2);
insert into badges(badge_id,badge_name,badge_description,badge_logo,issuer_id) values(3,'Badge3','Badge3 desc','Badge3 logo',3);