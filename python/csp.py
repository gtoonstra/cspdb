#!/usr/bin/env python

import logging
#import pdb

from tuple import Tuple
from collections import deque

logger = logging.getLogger( "CSP" )

class CSP(object):
    def __init__(self):
        self.dnames = deque([])
        self.domains = {}
        self.assertions = []
        self.stack = []

    def add_domain(self, domainname, domain):
        domain.set_csp( self )
        if len( self.domains ) == 0:
            self.topdomain = domain
        self.domains[ domainname ] = domain
        self.dnames.append( domainname )

    def add_assertion(self, assertion):
        self.assertions.append( assertion )
        assertion.set_csp( self )

    def set_goal(self, goal):
        self.goal = goal
        goal.set_csp( self )

    def run(self):
        
        solutions = 0
        while True:
            ret = False
            tuple = Tuple()
            ret = self.recurse_domains( deque( self.dnames ), tuple )
            if ret:
                self.assertTuple( tuple )
                self.stack.append( tuple )
                if self.goal.goal_reached():
                    print "goal reached..."
                    solutions += 1
                    for tuple in self.stack:
                        print tuple
                    self.do_retract()
            else:
                if not self.do_retract():
                    break
                
        print "%d solutions found" % solutions

    def recurse_domains(self, dnames, tuple):
        try:
            dname = dnames.popleft()
        except IndexError:
            print "indexerror"
            return None

        domain = self.domains[ dname ]

        if domain.stack_size() < len( self.stack ):
            domain.push_generator( tuple )

        if (domain.stack_size() == 0) and (domain.curgen == None):
            domain.refresh_generator( tuple )
 
        for value in domain.get_values():
            if value == None:
                return False 
            setattr( tuple, dname, value )
            if len(dnames) > 0:
                # still other domains to process...
                ret = self.recurse_domains( deque( dnames ), tuple )
                if not ret:
                    # other domain did not succeed... continue with next val
                    domain.clear_curval()
                    continue
                else:
                    # other domain did succeed... go on...
                    return True
            else:
                # this is final domain. apparently we found something.
                # remove current val before next iteration
                domain.clear_curval()
                return True

        # found nothing. pop state
        domain.pop_generator()
        return False

    def retractTuple(self, tuple):
        for assertion in self.assertions:
            assertion.retractTuple(tuple)
    
    def assertTuple(self, tuple):
        for assertion in self.assertions:
            assertion.assertTuple(tuple)

    def do_retract(self):
        if len(self.stack) == 0:
            return False
        mostRecentTuple = self.stack.pop()
        self.retractTuple( mostRecentTuple )
        return True
