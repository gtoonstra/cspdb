import logging
from assertion import Assertion

logger = logging.getLogger( "TakenAssertion" )

CELL_DOMAIN = "cell"
# ROW_DOMAIN = "possibilities"

class TakenAssertion(Assertion):
	def __init__(self):
		super( TakenAssertion, self ).__init__()

	def assertTuple(self, tuple):
		#self.csp.domains[ CELL_DOMAIN ].taken.append( tuple.queencol )
		pass
	
	def retractTuple(self, tuple):
		#self.csp.domains[ CELL_DOMAIN ].taken.remove( tuple.queencol )
		pass
