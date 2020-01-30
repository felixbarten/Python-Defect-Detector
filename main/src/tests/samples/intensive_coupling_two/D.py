from C import C
from B import B

# Threshold = 3
#intensive coupling between D <-> B but not D <-> as D does not have enough references to C. (only two)
class D:
    
    _protD = "sgdds"
    _protD2 = "sdgfsdfsdfsdfsd"
    _protDInt = 62
    pubD = 42
    pubD2 = 132
    b = B()
    c = C()

    def __init__(self):
        pass
    
    def do_stuff(self):
        b.doSomething()
    
    def do_more_stuff(self):
        pass
    
    def methodOne(self): 
        return  c.methodAlpha(52, 32) + c.memberA 
    
    def methodTwo(self): 
        return b.do_stuff()
    
    def methodThree(self): 
        return b.pubB + b.pubA
    
    def methodFour(self): 
        return b.memberCls.getMember()