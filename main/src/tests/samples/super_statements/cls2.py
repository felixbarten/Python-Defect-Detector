from cls import A

class B(A):
    
    def __init__(self):
        # Python 2 style
        super(A, self).substitution(1, 5)
        
        
    
    # override
    def substitution(self, a, b):
        return (a - b) + 1