import logging
from domain import Domain

logger = logging.getLogger( "Possibilities" )

class SudokuAssignment( Domain ):
    def __init__(self):
        super( SudokuAssignment, self ).__init__()
        self.assignments = range(1,10)

    """"SELECT mv.some_assignment FROM my_values mv 
        where mv.some_assignment not in 
            ( select t.assignment from tuple t where t.col = %s ) 
        and mv.some_assignment not in 
            ( select t.assignment from tuple t where t.row = %s ) 
        and mv.some_assignment not in 
            ( select t.assignment from tuple t where t.block = %s ) 
        and mv.some_assignment in 
            ( select mv2.some_assignment from my_values mv2, 
                ( SELECT count(*) as mynum, some_assignment, row, col FROM    
                    ( SELECT count( * ) as num, mv3.some_assignment, sc.row, sc.col FROM sudoku_cell sc 
                      LEFT JOIN tuple t ON sc.col = t.col AND sc.row = t.row, my_values mv3 
                      WHERE mv3.some_assignment NOT IN 
                          ( SELECT t.assignment FROM tuple t WHERE t.col = sc.col ) 
                      AND mv3.some_assignment NOT IN 
                          ( SELECT t.assignment FROM tuple t WHERE t.row = sc.row ) 
                      AND mv3.some_assignment NOT IN 
                          ( SELECT t.assignment FROM tuple t WHERE t.block = sc.block ) 
                      AND t.assignment is null AND sc.block = %s GROUP BY mv3.some_assignment HAVING num = 1 ) 
                as numcount ) 
            as nc 
         WHERE ( mv2.some_assignment = nc.some_assignment AND nc.mynum = 1 AND nc.col = %s AND nc.row = %s ) 
         or ( nc.col <> %s OR nc.row <> %s ) or ( nc.mynum = 0 ) )"""

    def get_generator(self, tuple):
        col, row, block = tuple.cell

        for assignment in self.assignments:
            include = True
            for t in self.csp.stack:
                xcol, xrow, xblock = t.cell
                if xcol == col and xrow == row and xblock == block:
                    include = False
                    break
                if xcol != col and xrow != row and xblock != block:
                    continue
                if t.assignment == assignment:
                    include = False
                    break

            if include:
                yield assignment

