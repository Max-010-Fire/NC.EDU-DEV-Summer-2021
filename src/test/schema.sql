create table users(
 id integer not null primary key,
 name varchar(50) not null,
 password varchar(50) not null
 );

 create table tasks(
 id integer not null primary key,
 userId integer not null,
 title varchar(50),
 description varchar(50),
 taskStatusId integer,
 creationDateTime timestamp,
 dueDateTime timestamp
 );

 create table statuses(
 id integer not null primary key,
 statusName varchar(50) not null
 );

 create table roles(
 id integer not null primary key,
 roleName varchar(50) not null
 );

 create table user_roles(
 id integer not null primary key,
 userId integer not null,
 roleId integer not null
 );