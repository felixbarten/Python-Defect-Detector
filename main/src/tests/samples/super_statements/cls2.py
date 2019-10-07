from cls import A
from argparse import _SubParsersAction

class B(A):
    
    def __init__(self):
        # Python 2 style
        super(A, self).substitution(1, 5)
        
        
    
    # override
    def substitution(self, a, b):
        return (a - b) + 1
    
    def easyParse(self):
        super(A, self)
        
    def easyParse2(self): 
        super().__init__()
    
    
    def easyParse3(self): 
        super()
    
    def hardParse(self):
        super(_SubParsersAction._ChoicesPseudoAction, self)

    def hardParse2(self):
        return super(Invoice, cls).view_attributes() + [
            ('/form/notebook/page[@id="electronic_invoice"]', 'states', {
                    'invisible': Eval('type') == 'in',
                    }),
            ('/form/notebook/page[@id="electronic_invoice_incoterms"]',
                'states', {
                    'invisible': Eval('type') == 'in',
                    }),
            ]
        
    def hardParse3(self): 
        sup = super(_SubParsersAction._ChoicesPseudoAction, self)
