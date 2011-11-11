import logging
from goal import Goal

logger = logging.getLogger( "SudokuGoal" )

class SudokuGoal( Goal ):
    def __init__(self, num):
        super( SudokuGoal, self ).__init__()
        self.num = num

    def set_csp(self, csp):
        self.csp = csp

    def goal_reached(self):
        if len( self.csp.stack ) == self.num:
            return True
        
        return False
