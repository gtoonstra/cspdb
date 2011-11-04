drop database nqueens;

create database nqueens;

use nqueens;

create table queens_column (
	id 	int primary key,
	row int,
	sum1 int,
	sum2 int,
	taken int
);

insert into queens_column ( id, row, sum1, sum2, taken ) values ( 1, 0, 0, 0, 0 );
insert into queens_column ( id, row, sum1, sum2, taken ) values ( 2, 0, 0, 0, 0 );
insert into queens_column ( id, row, sum1, sum2, taken ) values ( 3, 0, 0, 0, 0 );
insert into queens_column ( id, row, sum1, sum2, taken ) values ( 4, 0, 0, 0, 0 );
insert into queens_column ( id, row, sum1, sum2, taken ) values ( 5, 0, 0, 0, 0 );
insert into queens_column ( id, row, sum1, sum2, taken ) values ( 6, 0, 0, 0, 0 );
insert into queens_column ( id, row, sum1, sum2, taken ) values ( 7, 0, 0, 0, 0 );
insert into queens_column ( id, row, sum1, sum2, taken ) values ( 8, 0, 0, 0, 0 );

