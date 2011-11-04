drop database sudoku;

create database sudoku;

use sudoku;

create table my_values ( 
    some_assignment int primary key
);

create table sudoku_cell (
	col int NOT NULL,
	row int NOT NULL,
	block int NOT NULL,
	primary key( col, row )
);

create table tuple (
    col int,
    row int, 
    block int,
    assignment int,
    primary key( col, row )
);

create table solution (
	solution_id int,
	score int,
    col int,
    row int, 
    block int,
    assignment int
);

-- add-normal-domain( "possibilities" "SELECT mv.some_assignment FROM my_values mv where mv.some_assignment not in ( select t.assignment from tuple t where t.col = %s ) and mv.some_assignment not in ( select t.assignment from tuple t where t.row = %s ) and mv.some_assignment not in ( select t.assignment from tuple t where t.block = %s ) and mv.some_assignment in ( select mv2.some_assignment from my_values mv2, ( SELECT count(*) as mynum, some_assignment, row, col FROM ( SELECT count( * ) as num, mv3.some_assignment, sc.row, sc.col FROM sudoku_cell sc LEFT JOIN tuple t ON sc.col = t.col AND sc.row = t.row, my_values mv3 WHERE mv3.some_assignment NOT IN ( SELECT t.assignment FROM tuple t WHERE t.col = sc.col ) AND mv3.some_assignment NOT IN ( SELECT t.assignment FROM tuple t WHERE t.row = sc.row ) AND mv3.some_assignment NOT IN ( SELECT t.assignment FROM tuple t WHERE t.block = sc.block ) AND t.assignment is null AND sc.block = %s GROUP BY mv3.some_assignment HAVING num = 1 ) as numcount ) as nc WHERE ( mv2.some_assignment = nc.some_assignment AND nc.mynum = 1 AND nc.col = %s AND nc.row = %s ) or ( nc.mynum = 1 AND (nc.col <> %s OR nc.row <> %s ) ) or ( nc.mynum = 0 ) )" );
-- add-normal-domain( "possibilities" "SELECT mv.some_assignment FROM my_values mv where mv.some_assignment not in ( select t.assignment from tuple t where t.col = %s ) and mv.some_assignment not in ( select t.assignment from tuple t where t.row = %s ) and mv.some_assignment not in ( select t.assignment from tuple t where t.block = %s )" );

insert into my_values( some_assignment ) values ( 1 );
insert into my_values( some_assignment ) values ( 2 );
insert into my_values( some_assignment ) values ( 3 );
insert into my_values( some_assignment ) values ( 4 );
insert into my_values( some_assignment ) values ( 5 );
insert into my_values( some_assignment ) values ( 6 );
insert into my_values( some_assignment ) values ( 7 );
insert into my_values( some_assignment ) values ( 8 );
insert into my_values( some_assignment ) values ( 9 );

insert into sudoku_cell ( col, row, block ) values ( 1, 1, 1 );
insert into sudoku_cell ( col, row, block ) values ( 2, 1, 1 );
insert into sudoku_cell ( col, row, block ) values ( 3, 1, 1 );
insert into sudoku_cell ( col, row, block ) values ( 1, 2, 1 );
insert into sudoku_cell ( col, row, block ) values ( 2, 2, 1 );
insert into sudoku_cell ( col, row, block ) values ( 3, 2, 1 );
insert into sudoku_cell ( col, row, block ) values ( 1, 3, 1 );
insert into sudoku_cell ( col, row, block ) values ( 2, 3, 1 );
insert into sudoku_cell ( col, row, block ) values ( 3, 3, 1 );

insert into sudoku_cell ( col, row, block ) values ( 4, 1, 2 );
insert into sudoku_cell ( col, row, block ) values ( 5, 1, 2 );
insert into sudoku_cell ( col, row, block ) values ( 6, 1, 2 );
insert into sudoku_cell ( col, row, block ) values ( 4, 2, 2 );
insert into sudoku_cell ( col, row, block ) values ( 5, 2, 2 );
insert into sudoku_cell ( col, row, block ) values ( 6, 2, 2 );
insert into sudoku_cell ( col, row, block ) values ( 4, 3, 2 );
insert into sudoku_cell ( col, row, block ) values ( 5, 3, 2 );
insert into sudoku_cell ( col, row, block ) values ( 6, 3, 2 );

insert into sudoku_cell ( col, row, block ) values ( 7, 1, 3 );
insert into sudoku_cell ( col, row, block ) values ( 8, 1, 3 );
insert into sudoku_cell ( col, row, block ) values ( 9, 1, 3 );
insert into sudoku_cell ( col, row, block ) values ( 7, 2, 3 );
insert into sudoku_cell ( col, row, block ) values ( 8, 2, 3 );
insert into sudoku_cell ( col, row, block ) values ( 9, 2, 3 );
insert into sudoku_cell ( col, row, block ) values ( 7, 3, 3 );
insert into sudoku_cell ( col, row, block ) values ( 8, 3, 3 );
insert into sudoku_cell ( col, row, block ) values ( 9, 3, 3 );

insert into sudoku_cell ( col, row, block ) values ( 1, 4, 4 );
insert into sudoku_cell ( col, row, block ) values ( 2, 4, 4 );
insert into sudoku_cell ( col, row, block ) values ( 3, 4, 4 );
insert into sudoku_cell ( col, row, block ) values ( 1, 5, 4 );
insert into sudoku_cell ( col, row, block ) values ( 2, 5, 4 );
insert into sudoku_cell ( col, row, block ) values ( 3, 5, 4 );
insert into sudoku_cell ( col, row, block ) values ( 1, 6, 4 );
insert into sudoku_cell ( col, row, block ) values ( 2, 6, 4 );
insert into sudoku_cell ( col, row, block ) values ( 3, 6, 4 );

insert into sudoku_cell ( col, row, block ) values ( 4, 4, 5 );
insert into sudoku_cell ( col, row, block ) values ( 5, 4, 5 );
insert into sudoku_cell ( col, row, block ) values ( 6, 4, 5 );
insert into sudoku_cell ( col, row, block ) values ( 4, 5, 5 );
insert into sudoku_cell ( col, row, block ) values ( 5, 5, 5 );
insert into sudoku_cell ( col, row, block ) values ( 6, 5, 5 );
insert into sudoku_cell ( col, row, block ) values ( 4, 6, 5 );
insert into sudoku_cell ( col, row, block ) values ( 5, 6, 5 );
insert into sudoku_cell ( col, row, block ) values ( 6, 6, 5 );

insert into sudoku_cell ( col, row, block ) values ( 7, 4, 6 );
insert into sudoku_cell ( col, row, block ) values ( 8, 4, 6 );
insert into sudoku_cell ( col, row, block ) values ( 9, 4, 6 );
insert into sudoku_cell ( col, row, block ) values ( 7, 5, 6 );
insert into sudoku_cell ( col, row, block ) values ( 8, 5, 6 );
insert into sudoku_cell ( col, row, block ) values ( 9, 5, 6 );
insert into sudoku_cell ( col, row, block ) values ( 7, 6, 6 );
insert into sudoku_cell ( col, row, block ) values ( 8, 6, 6 );
insert into sudoku_cell ( col, row, block ) values ( 9, 6, 6 );

insert into sudoku_cell ( col, row, block ) values ( 1, 7, 7 );
insert into sudoku_cell ( col, row, block ) values ( 2, 7, 7 );
insert into sudoku_cell ( col, row, block ) values ( 3, 7, 7 );
insert into sudoku_cell ( col, row, block ) values ( 1, 8, 7 );
insert into sudoku_cell ( col, row, block ) values ( 2, 8, 7 );
insert into sudoku_cell ( col, row, block ) values ( 3, 8, 7 );
insert into sudoku_cell ( col, row, block ) values ( 1, 9, 7 );
insert into sudoku_cell ( col, row, block ) values ( 2, 9, 7 );
insert into sudoku_cell ( col, row, block ) values ( 3, 9, 7 );

insert into sudoku_cell ( col, row, block ) values ( 4, 7, 8 );
insert into sudoku_cell ( col, row, block ) values ( 5, 7, 8 );
insert into sudoku_cell ( col, row, block ) values ( 6, 7, 8 );
insert into sudoku_cell ( col, row, block ) values ( 4, 8, 8 );
insert into sudoku_cell ( col, row, block ) values ( 5, 8, 8 );
insert into sudoku_cell ( col, row, block ) values ( 6, 8, 8 );
insert into sudoku_cell ( col, row, block ) values ( 4, 9, 8 );
insert into sudoku_cell ( col, row, block ) values ( 5, 9, 8 );
insert into sudoku_cell ( col, row, block ) values ( 6, 9, 8 );

insert into sudoku_cell ( col, row, block ) values ( 7, 7, 9 );
insert into sudoku_cell ( col, row, block ) values ( 8, 7, 9 );
insert into sudoku_cell ( col, row, block ) values ( 9, 7, 9 );
insert into sudoku_cell ( col, row, block ) values ( 7, 8, 9 );
insert into sudoku_cell ( col, row, block ) values ( 8, 8, 9 );
insert into sudoku_cell ( col, row, block ) values ( 9, 8, 9 );
insert into sudoku_cell ( col, row, block ) values ( 7, 9, 9 );
insert into sudoku_cell ( col, row, block ) values ( 8, 9, 9 );
insert into sudoku_cell ( col, row, block ) values ( 9, 9, 9 );

