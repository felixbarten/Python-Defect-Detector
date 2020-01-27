import Logging

import sys as system

from D import D

#intensive coupling
class C:
    
    _protB = "sgdds"
    _protB2 = "sdgfsdfsdfsdfsd"
    _protBInt = 23
    memberA = 2323
    pubB = 2323
    pubBC = 23233333
    d = D();

    def __init__(self):
        pass
    
    def do_stuff(self):
        pass
    
    def do_more_stuff(self):
        pass
    
    def methodOne(self): 
        return  d.methodAlpha + d.pubD 
    
    def methodTwo(self): 
        return d.do_stuff()
    
    def methodThree(self): 
        return d.pubB + d.pubA
    
    def methodAlpha(self, numA, numB): 
        return numA + numB