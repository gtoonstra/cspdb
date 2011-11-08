import logging

logger = logging.getLogger( "Goal" )

class Goal( object ):
    def __init__(self):
        pass

    def set_csp(self, csp):
        self.csp = csp

    def goal_reached(self):
        raise Exception( "Override default implementation in Goal" )