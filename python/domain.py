import logging

logger = logging.getLogger( "Domain" )

class Domain( object ):
    def __init__(self):
        self.curgen = None
        self.generators = []
        self.curval = None
        self.curvals = []

    def set_csp(self, csp):
        self.csp = csp

    def stack_size(self):
        return len(self.generators)

    def push_generator(self):
        self.generators.append( self.curgen )
        self.curgen = self.get_generator()
        self.curvals.append( self.curval )
        self.curval = None

    def refresh_generator(self):
        self.curgen = self.get_generator()
        self.curval = None        

    def pop_generator(self):
        self.curgen = self.generators.pop()
        self.curval = self.curvals.pop()

    def clear_curval(self):
        self.curval = None

    def get_values(self):
        if self.curval != None:
            yield self.curval
        else:
            for i in self.curgen:
                self.curval = i
                yield self.curval

    def get_generator(self):
        logger.error( "Override this function in your implementation" )
