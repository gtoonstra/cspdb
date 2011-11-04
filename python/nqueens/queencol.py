import logging
from domain import Domain

logger = logging.getLogger( "QueenCol" )

class QueenCol( Domain ):
    def __init__(self):
        super( QueenCol, self ).__init__()
        self.cols = range(1, 9)
        self.taken = []

    def get_values(self):
        for i in self.cols:
            if i not in self.taken:
                yield i
