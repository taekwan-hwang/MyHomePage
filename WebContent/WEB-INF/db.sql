create database hr;
use hr;

create table member (
 id varchar(20) unique primary key,
 pwd varchar(20),
 name varchar(10) unique,
 isMaster bool
 );

insert into member(id, pwd, name, isMaster) values("root", "050505s", "taekwan", true);

create table post (
 id varchar(20),
 head varchar(50),
 content varchar(2000),
 regdate datetime,
 idx int(20) auto_increment primary key,
 ip varchar(20)
);
insert into post values("root", "head", "content", curdate(),1, "127.0.0.1");
insert into post values("root", "head", "content", curdate(),2, "127.0.0.1");
alter table post add foreign key(id) references member(id);
select * from post;
drop table member;
drop table post;
select * from post;
select * from member;
delete from member where id=null;
delete from post where id="root";