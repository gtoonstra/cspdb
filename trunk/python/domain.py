import logging

logger = logging.getLogger( "Domain" )

class Domain( object ):
    def __init__(self):
        pass

    def set_csp(self, csp):
        self.csp = csp

    def get_values(self):
        logger.error( "Override this function in your implementation" )
