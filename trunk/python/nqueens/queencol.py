import logging
from domain import Domain

logger = logging.getLogger( "QueenCol" )

class QueenCol( Domain ):
    def __init__(self, cols):
        super( QueenCol, self ).__init__()
        self.cols = cols
        self.taken = []

    def get_generator(self, tuple):
        for i in self.cols:
            if i not in self.taken:
                yield i
