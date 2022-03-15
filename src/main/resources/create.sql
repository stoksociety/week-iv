SET MODE PostgreSQL;

CREATE TABLE departments(
 id int PRIMARY KEY ,departName VARCHAR,departDesc VARCHAR, employeeNo VARCHAR
);

CREATE TABLE  users (
 id int PRIMARY KEY, ame VARCHAR, position VARCHAR,role VARCHAR,department VARCHAR, departId int
);


CREATE TABLE news (
 id int PRIMARY KEY, title VARCHAR,content VARCHAR,departmentId int
);