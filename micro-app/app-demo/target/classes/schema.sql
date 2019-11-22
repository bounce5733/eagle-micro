drop table user if exists;
drop table address if exists;

CREATE TABLE user (
  id bigint NOT NULL,
  name varchar(50) NOT NULL
);

CREATE TABLE address (
 id bigint NOT NULL AUTO_INCREMENT,
 user_id bigint NOT NULL,
 province varchar(50),
 city varchar(50),
 detail varchar(50) NOT NULL
);