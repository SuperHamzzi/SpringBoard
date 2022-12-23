-- tblBoard --
CREATE TABLE tblBoard(
	idx int not null,
	memID varchar(20) not null,  
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(),
	count int default 0,
	boardGroup int,
	boardSequence int,
	boardLevel int,
	boardAvailable int,
	primary key(idx)
);

create table tblMember(
	memID varchar(50) not null,
	memPwd varchar(50) not null,
	memName varchar(50) not null,
	memPhone varchar(50) not null,
	memAddr varchar(100),
	latitude decimal(13,10),
	longitude decimal(13,10),
	primary key(memID)
);

select max(idx) from tblBoard;
select IFNULL(max(idx)+1, 1) from tblBoard;
select IFNULL(max(boardGroup)+1, 0) from tblBoard;


insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit01','게시판연습','게시판연습','관리자',
now(),0,IFNULL(max(boardGroup)+1, 0), 0 ,0, 1
from tblBoard;

insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit02','게시판연습','게시판연습','김재혁',
now(),0,IFNULL(max(boardGroup)+1, 0), 0 ,0, 1
from tblBoard;

insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit03','게시판연습','게시판연습','안녕',
now(),0,IFNULL(max(boardGroup)+1, 0), 0 ,0, 1
from tblBoard;

select * from tblBoard;

insert into tblMember(memID,memPwd,memName,memPhone)
values('bit01','bit01','관리자','010-1111-1111');
insert into tblMember(memID,memPwd,memName,memPhone)
values('bit02','bit02','김재혁','010-2222-2222');
insert into tblMember(memID,memPwd,memName,memPhone)
values('bit03','bit03','김재햑','010-3333-3333');

select * from tblMember;

select * from tblBoard;
delete from tblBoard;
delete from tblBoard where idx=1;
delete from tblBoard where idx=2;
delete from tblBoard where idx=3;
