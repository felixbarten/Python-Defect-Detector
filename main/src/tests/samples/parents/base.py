class BaseCls(object):
    __privVar = "Str"
    _protVar1 = 0;
    _protVar2 = "protected str" 
    _protVar3 = False

    def do_stuff(self):
        _protMember = True
        return _protMember
        
    def do_more_stuff(self, num):
        __privMember = 1
        
        return __privMember + num

class SubBaseCls(BaseCls):
    __privVar1 = "String"
    __privVar2 = 0
    __privVar = 5
    _protVar1 = 234
    
    def do_stuff(self):
        print("SubBaseCls do stuff")
    
    def do_more_stuff(self): 
        return _protVar1;
    
    def illegalAccess(self):
        return __privVar