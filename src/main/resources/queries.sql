drop table data_structure;

create table data_structure(
	id SERIAL PRIMARY KEY,
   	name VARCHAR NOT NULL
);

select * from data_structure;


insert into data_structure(name) values ('array');