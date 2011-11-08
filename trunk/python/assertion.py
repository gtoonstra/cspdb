import logging

logger = logging.getLogger( "Assertion" )

class Assertion( object ):
    def __init__(self):
        pass

    def set_csp(self, csp):
        self.csp = csp

    def assertTuple(self, tuple):
        raise Exception( "override assert implementation in assertion" )
    
    def retractTuple(self, tuple):
        raise Exception( "override retract implementation in assertion" )
