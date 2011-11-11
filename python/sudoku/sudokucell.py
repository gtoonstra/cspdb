import logging
from domain import Domain

logger = logging.getLogger( "SudokuCol" )

class SudokuCell( Domain ):
    def __init__(self):
        super( SudokuCell, self ).__init__()
        self.cells = []
        for col in range(1,10):
            for row in range(1,10):
                block = (((row-1)/3) * 3) + ((col-1)/3) + 1
                self.cells.append( (col, row, block) )

        self.assignments = range(1,10)

    """select distinct( col ) from ( 
          select sc.col, count( * ) as count from sudoku_cell sc left join 
          tuple t on sc.col = t.col and sc.row = t.row, 
          my_values mv where mv.some_assignment not in 
            ( select t.assignment from tuple t where t.col = sc.col ) 
          and mv.some_assignment not in 
            ( select t.assignment from tuple t where t.row = sc.row ) 
          and mv.some_assignment not in 
            ( select t.assignment from tuple t where t.block = sc.block ) 
          and t.assignment is null group by sc.col, sc.row order by count asc ) as subq"""

    def get_generator(self, tuple):
        result = {}
        
        for col, row, block in self.cells:
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
                    idx = col * 10 + row
                    try:
                        col, row, block, count = result[ idx ]
                        result[ idx ] = (col, row, block, count+1)
                    except KeyError as ie:
                        result[ idx ] = (col, row, block, 1)

        print "---"
        for key, (col,row,block,count) in sorted(result.iteritems(), key=lambda (k,(c,r,b,v)): (v,(c,r,b,k))):
            print col, row, block, count
            yield (col, row, block)
