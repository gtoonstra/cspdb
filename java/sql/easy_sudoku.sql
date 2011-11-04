use sudoku;

-- first block
insert into tuple( col, row, block, assignment ) values ( 1, 1, 1, 8 );
insert into tuple( col, row, block, assignment ) values ( 2, 1, 1, 6 );
insert into tuple( col, row, block, assignment ) values ( 1, 3, 1, 1 );

-- second block
insert into tuple( col, row, block, assignment ) values ( 6, 1, 2, 9 );
insert into tuple( col, row, block, assignment ) values ( 4, 2, 2, 5 );
insert into tuple( col, row, block, assignment ) values ( 5, 2, 2, 3 );
insert into tuple( col, row, block, assignment ) values ( 6, 2, 2, 4 );
insert into tuple( col, row, block, assignment ) values ( 4, 3, 2, 8 );
insert into tuple( col, row, block, assignment ) values ( 5, 3, 2, 7 );

-- third block
insert into tuple( col, row, block, assignment ) values ( 7, 1, 3, 4 );
insert into tuple( col, row, block, assignment ) values ( 8, 1, 3, 7 );
insert into tuple( col, row, block, assignment ) values ( 9, 3, 3, 9 );

-- fourth block
insert into tuple( col, row, block, assignment ) values ( 3, 4, 4, 1 );
insert into tuple( col, row, block, assignment ) values ( 3, 6, 4, 7 );
use sudoku;

-- fifth block
insert into tuple( col, row, block, assignment ) values ( 4, 4, 5, 9 );
insert into tuple( col, row, block, assignment ) values ( 5, 4, 5, 8 );
insert into tuple( col, row, block, assignment ) values ( 4, 5, 5, 7 );
insert into tuple( col, row, block, assignment ) values ( 6, 5, 5, 2 );
insert into tuple( col, row, block, assignment ) values ( 5, 6, 5, 4 );
insert into tuple( col, row, block, assignment ) values ( 6, 6, 5, 5 );

-- sixth block
insert into tuple( col, row, block, assignment ) values ( 7, 4, 6, 7 );
insert into tuple( col, row, block, assignment ) values ( 7, 6, 6, 3 );

-- seventh block
insert into tuple( col, row, block, assignment ) values ( 1, 7, 7, 6 );
insert into tuple( col, row, block, assignment ) values ( 2, 9, 7, 9 );
insert into tuple( col, row, block, assignment ) values ( 3, 9, 7, 8 );

-- eighth block
insert into tuple( col, row, block, assignment ) values ( 5, 7, 8, 5 );
insert into tuple( col, row, block, assignment ) values ( 6, 7, 8, 1 );
insert into tuple( col, row, block, assignment ) values ( 4, 8, 8, 4 );
insert into tuple( col, row, block, assignment ) values ( 5, 8, 8, 9 );
insert into tuple( col, row, block, assignment ) values ( 6, 8, 8, 8 );
insert into tuple( col, row, block, assignment ) values ( 4, 9, 8, 2 );

-- ninth block
insert into tuple( col, row, block, assignment ) values ( 9, 7, 9, 8 );
insert into tuple( col, row, block, assignment ) values ( 8, 9, 9, 4 );
insert into tuple( col, row, block, assignment ) values ( 9, 9, 9, 5 );
