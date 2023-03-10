-- tblBoard --
create table tblBoard(
	idx int not null, -- 게시판 넘버
	memID varchar(20) not null,  -- 댓글 아이디
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
drop table tblBoard;

select max(idx) from tblBoard; -- NULL -> 1 , 2+1->3
select IFNULL(max(idx)+1, 1) from tblBoard;
select IFNULL(max(boardGroup)+1, 0) from tblBoard;

insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit01','게시판연습','게시판연습','관리자',
now(),0, IFNULL(max(boardGroup)+1, 0), 0, 0, 1
from tblBoard;

insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit02','게시판연습','게시판연습','김재혁',
now(),0, IFNULL(max(boardGroup)+1, 0), 0, 0, 1
from tblBoard;

insert into tblBoard
select IFNULL(max(idx)+1, 1),'bit03','게시판연습','게시판연습','홍길동',
now(),0, IFNULL(max(boardGroup)+1, 0), 0, 0, 1
from tblBoard;

select * from tblBoard;

create table tblMember(
  memID varchar(50) not null, -- 회원ID
  memPwd varchar(50) not null, -- 회원비번
  memName varchar(50) not null, -- 회원이름
  memPhone varchar(50) not null, -- 회원전화번호
  memAddr varchar(100), -- 회원주소
  latitude decimal(13,10), -- 현재위치위도
  longitude decimal(13,10), -- 현재위치경도
  primary key(memID)
);
drop table tblMember;

insert into tblMember(memID, memPwd, memName, memPhone)
values('test1','test1','관리자','010-1111-1111');
insert into tblMember(memID, memPwd, memName, memPhone)
values('test2','test2','김재혁','010-2222-2222');
insert into tblMember(memID, memPwd, memName, memPhone)
values('test3','test3','홍길동','010-3333-3333');

delete from tblMember where memID='bit01';
delete from tblMember where memID='bit02';
delete from tblMember where memID='bit03';

select * from tblMember;

select * from tblBoard;

delete from tblBoard;

delete from tblBoard where idx=0;
delete from tblBoard where idx=1;
delete from tblBoard where idx=2;
delete from tblBoard where idx=3;


