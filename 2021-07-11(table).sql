use mydb;

create tablespace statea;
drop tablespace statea;

create database statea;

use statea;

create table tbl_like(
like_hit	bigint	primary key default 0	,
like_cncode	char(5)	not null	
);

drop table tbl_image;
create table tbl_image(
	img_code	bigint auto_increment		primary key,
	img_name	varchar(300)	not null	,
    img_upname  varchar(300)	not null	,
	img_cncode	char(5)	not null	
);

drop table tbl_board;
create table tbl_board(
	bd_code	CHAR(5)		PRIMARY KEY,
bd_title	VARCHAR(50)	NOT NULL	,
bd_content	VARCHAR(1000)	NOT NULL,	
bd_user	VARCHAR(10)	NOT NULL	,
bd_vcount bigint default 0,
bd_time	varchar(20)	NOT NULL	
);

create table tbl_notice(
	nt_code	CHAR(5)		PRIMARY KEY,
nt_title	VARCHAR(50)	NOT NULL	,
nt_content	VARCHAR(1000)	NOT NULL,	
nt_writer	VARCHAR(10)	NOT NULL	,	
nt_time	varCHAR(20)	NOT NULL	
);

select * from tbl_board;
select * from tbl_image;