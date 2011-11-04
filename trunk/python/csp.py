#!/usr/bin/env python

import logging

from tuple import Tuple

logger = logging.getLogger( "CSP" )

class CSP(object):
    def __init__(self):
        self.domains = {}
        self.assertions = []

    def add_domain(self, domainname, domain):
        domain.set_csp( self )
        self.domains[ domainname ] = domain

    def add_assertion(self, assertion):
        self.assertions.append( assertion )

    def set_goal(self, goal):
        self.goal = goal

    def run(self):
        while True:
            tuple = Tuple()
            for dname, domain in self.domains.iteritems():
                for value in domain.get_values():
                    #if value == None:
                    #   break
                    setattr( tuple, dname, value )
                    break

            print tuple
