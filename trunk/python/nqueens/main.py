import sys, os

if __name__ == "__main__" and __package__ is None:
    # The following assumes the script is in the top level of the package
    # directory.  We use dirname() to help get the parent directory to add to
    # sys.path, so that we can import the current package.  This is necessary 
    # since when invoked directly, the 'current' package is not automatically
    # imported.
    parent_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    sys.path.insert(0, parent_dir)
    import nqueens
    __package__ = str("nqueens")
    del sys, os

import logging
from csp import CSP

from queencol import QueenCol
from queenrow import QueenRow
from takenassertion import TakenAssertion
from queensgoal import QueensGoal

logger = logging.getLogger( "NQueens" )

class NQueens(CSP):
    def __init__(self):
        super( NQueens, self ).__init__()
        logger.info( "Lol" )

print __name__
if __name__ == "__main__":
    logging.basicConfig(level=logging.DEBUG)
    problem = NQueens()
    num = 8
    problem.add_domain( "queencol", QueenCol(range(1,num+1)) )
    problem.add_domain( "queenrow", QueenRow(range(1,num+1)) )
    problem.add_assertion( TakenAssertion() )
    problem.set_goal( QueensGoal( num ) )
    problem.run()
