import logging
from domain import Domain

logger = logging.getLogger( "QueenCol" )

class QueenRow( Domain ):
    def __init__(self):
        super( QueenRow, self ).__init__()
        # rows not already taken
        self.taken = []
        self.sum1 = []
        self.sum2 = []
        self.rows = range(1, 5)
        # row not in sum1=( currentcol + row )
        # row not in sum2=( 9 - currentcolid + rowid )        
        # row not taken

        #"select qc1.id from queens_column qc1 where 
        #qc1.id not in (
        #  select distinct(qc2.id) 
        #  from queens_column qc2, queens_column qc3 
        #  where qc3.sum1 = ( %s + qc2.id )) 
        #and qc1.id not in (
        #  select distinct(qc2.id) 
        #  from queens_column qc2, queens_column qc3 
        #  where qc3.sum2 = ( 9 - %s + qc2.id )) 
        # and qc1.id not in ( 
        #select qc4.row from queens_column qc4 where qc4.row <> 0)"

    def get_generator(self):
        for i in self.rows:
            if i not in self.taken:
                yield i
