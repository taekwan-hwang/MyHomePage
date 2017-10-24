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
 idx int(20),
 ip varchar(20)
);

alter table post add foreign key(id) references member(id);

drop table member;
drop table post;
select * from post;
select * from member;
delete from member where id=null;
