import sys, os

if __name__ == "__main__" and __package__ is None:
    # The following assumes the script is in the top level of the package
    # directory.  We use dirname() to help get the parent directory to add to
    # sys.path, so that we can import the current package.  This is necessary 
    # since when invoked directly, the 'current' package is not automatically
    # imported.
    parent_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    sys.path.insert(0, parent_dir)
    import sudoku
    __package__ = str("sudoku")
    del sys, os

import logging
from csp import CSP

from sudokucell import SudokuCell
from assignment import SudokuAssignment
from takenassertion import TakenAssertion
from sudokugoal import SudokuGoal
from tuple import Tuple

import csv

logger = logging.getLogger( "Sudoku" )

class Sudoku(CSP):
    def __init__(self, datafile):
        super( Sudoku, self ).__init__()
        logger.info( "Sudoku" )
        problemReader = csv.reader(open( datafile, 'rb'), delimiter=',', quotechar='#')
        for row in problemReader:
            if len(row) == 0:
                continue
            # row[ 0 ] == col
            # row[ 1 ] == row
            # row[ 2 ] == block
            # row[ 3 ] == value
            tuple = Tuple()
            a = int(row.pop())
            b = int(row.pop())
            r = int(row.pop())
            c = int(row.pop())
            tuple.cell = (c, r, b)
            tuple.assignment = a
            self.stack.append( tuple )

print __name__
if __name__ == "__main__":
    logging.basicConfig(level=logging.DEBUG)
    problem = Sudoku( "data/easy.data" )
    problem.add_domain( "cell", SudokuCell() )
    problem.add_domain( "assignment", SudokuAssignment() )
    problem.add_assertion( TakenAssertion() )
    problem.set_goal( SudokuGoal( 81 ) )
    problem.run()
