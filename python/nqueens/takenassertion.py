import logging
from assertion import Assertion

logger = logging.getLogger( "TakenAssertion" )

COL_DOMAIN = "queencol"
ROW_DOMAIN = "queenrow"

class TakenAssertion(Assertion):
	def __init__(self):
		super( TakenAssertion, self ).__init__()

	def assertTuple(self, tuple):
		self.csp.domains[ COL_DOMAIN ].taken.append( tuple.queencol )
		self.csp.domains[ ROW_DOMAIN ].taken.append( tuple.queenrow ) 

	def retractTuple(self, tuple):
		self.csp.domains[ COL_DOMAIN ].taken.remove( tuple.queencol )
		self.csp.domains[ ROW_DOMAIN ].taken.remove( tuple.queenrow )
