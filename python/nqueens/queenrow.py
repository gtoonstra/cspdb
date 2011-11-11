import logging
from domain import Domain

logger = logging.getLogger( "QueenCol" )

class QueenRow( Domain ):
    def __init__(self, rows):
        super( QueenRow, self ).__init__()
        # rows not already taken
        self.taken = []
        self.sum1 = []
        self.sum2 = []
        self.rows = rows
        # row not in sum1=( currentcol + row )
        # row not in sum2=( 9 - currentcolid + rowid )        
        # row not taken

    def get_generator(self, tuple):
        for i in self.rows:
            if i not in self.taken:
                if ( tuple.queencol + i ) in self.sum1:
                    continue
                if ( 9 - tuple.queencol + i ) in self.sum2:
                    continue
                yield i
