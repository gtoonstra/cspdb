import logging
from domain import Domain

logger = logging.getLogger( "QueenCol" )

class QueenRow( Domain ):
    def __init__(self):
        super( QueenRow, self ).__init__()
        # rows not already taken
        self.taken = []
        # row + any col id not in sum
        # row not in ( 9 - any-col-id + rowid )
        
"select qc1.id from queens_column qc1 where qc1.id not in (select distinct(qc2.id) from queens_column qc2, queens_column qc3 where qc3.sum1 = ( %s + qc2.id )) and qc1.id not in (select distinct(qc2.id) from queens_column qc2, queens_column qc3 where qc3.sum2 = ( 9 - %s + qc2.id )) and qc1.id not in ( select qc4.row from queens_column qc4 where qc4.row <> 0)"

    def get_values(self):
        for i in self.cols:
            if i not in self.taken:
                yield i
