use sudoku;

-- first block
insert into tuple( col, row, block, assignment ) values ( 2, 1, 1, 1 );
insert into tuple( col, row, block, assignment ) values ( 1, 2, 1, 6 );
insert into tuple( col, row, block, assignment ) values ( 1, 3, 1, 3 );
insert into tuple( col, row, block, assignment ) values ( 2, 3, 1, 4 );
insert into tuple( col, row, block, assignment ) values ( 3, 3, 1, 8 );

-- second block
insert into tuple( col, row, block, assignment ) values ( 5, 1, 2, 4 );
insert into tuple( col, row, block, assignment ) values ( 6, 1, 2, 6 );
insert into tuple( col, row, block, assignment ) values ( 4, 2, 2, 3 );
insert into tuple( col, row, block, assignment ) values ( 4, 3, 2, 7 );
insert into tuple( col, row, block, assignment ) values ( 5, 3, 2, 2 );

-- third block
insert into tuple( col, row, block, assignment ) values ( 8, 3, 3, 6 );
insert into tuple( col, row, block, assignment ) values ( 9, 3, 3, 9 );

-- fourth block
insert into tuple( col, row, block, assignment ) values ( 3, 4, 4, 1 );
insert into tuple( col, row, block, assignment ) values ( 1, 5, 4, 4 );
insert into tuple( col, row, block, assignment ) values ( 3, 5, 4, 7 );
insert into tuple( col, row, block, assignment ) values ( 2, 6, 4, 6 );

-- sixth block
insert into tuple( col, row, block, assignment ) values ( 8, 4, 6, 8 );
insert into tuple( col, row, block, assignment ) values ( 7, 5, 6, 3 );
insert into tuple( col, row, block, assignment ) values ( 9, 5, 6, 5 );
insert into tuple( col, row, block, assignment ) values ( 7, 6, 6, 7 );

-- seventh block
insert into tuple( col, row, block, assignment ) values ( 1, 7, 7, 7 );
insert into tuple( col, row, block, assignment ) values ( 2, 7, 7, 3 );

-- eighth block
insert into tuple( col, row, block, assignment ) values ( 5, 7, 8, 8 );
insert into tuple( col, row, block, assignment ) values ( 6, 7, 8, 2 );
insert into tuple( col, row, block, assignment ) values ( 6, 8, 8, 7 );
insert into tuple( col, row, block, assignment ) values ( 4, 9, 8, 4 );
insert into tuple( col, row, block, assignment ) values ( 5, 9, 8, 1 );

-- ninth block
insert into tuple( col, row, block, assignment ) values ( 7, 7, 9, 9 );
insert into tuple( col, row, block, assignment ) values ( 8, 7, 9, 1 );
insert into tuple( col, row, block, assignment ) values ( 9, 7, 9, 4 );
insert into tuple( col, row, block, assignment ) values ( 9, 8, 9, 8 );
insert into tuple( col, row, block, assignment ) values ( 8, 9, 9, 7 );
