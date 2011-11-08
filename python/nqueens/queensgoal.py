import logging
from goal import Goal

logger = logging.getLogger( "QueensGoal" )

class QueensGoal( Goal ):
    def __init__(self):
        super( QueensGoal, self ).__init__()

    def set_csp(self, csp):
        self.csp = csp

    def goal_reached(self):
        if len( self.csp.stack ) == 4:
            return True
        
        return False
