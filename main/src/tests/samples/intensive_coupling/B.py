from A import A

#intensive coupling
class B:
    
    _protB = "sgdds"
    _protB2 = "sdgfsdfsdfsdfsd"
    _protBInt = 23
    pubB = 2323
    pubBC = 23233333
    a = A()
    

    def __init__(self):
        self.pubB = a.numberA
        
    
    def do_stuff(self):
        return a.name + _protB 
        
    
    def do_more_stuff(self):
        return a.__name + _protB2 