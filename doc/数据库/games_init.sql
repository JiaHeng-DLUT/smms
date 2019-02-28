create table athelete
(
aid		char(8) primary key,
aname		varchar(50) not null,
gnum		varchar(50),
aage		char(5),
asex		char(5),
snum		varchar(50),
);

create table groups
(
gnum		char(8) primary key,
gname		varchar(50) not null,
anum		char(8),
goldnum		int,
selivernum	int,
coppernum	int,
);

create table refer
(
referid		char(8) primary key,
refername	varchar(50) not null,
referlevel	char(5),
recomptn	varchar(50)
);

create table sport
(
snum		char(8) primary key,
sname		varchar(50) not null,
wrecord		varchar(50),
lhrecord	varchar(50)
);

create table comschedule
(
comsnum		char(8) primary key,
comsdate	varchar(20) not null,
comstime	varchar(20),
sportname	varchar(50) not null,
comsaddr	varchar(50),
pathamt		varchar(50),
groups		varchar(50),
comlevel	char(5),
refername	varchar(50),
);

create table comrelt
(
comsnum		char(8),
comname		varchar(50),
athnum		char(8),
athename	varchar(50),
comlevel	char(5),
postion		char(5),
achment		varchar(50),
primary key(comsnum, athnum),
);



