import logging
from assertion import Assertion

logger = logging.getLogger( "TakenAssertion" )

class TakenAssertion(Assertion):
	def __init__(self):
		super( TakenAssertion, self ).__init__()
