# Test source for testing complexity. 
# Code shows various python constructs creating complexity. 
# Python v3 style used.

class ClassOne(self):
    
    
    #complexity should be two
    def ifElseStmt(self): 
        
        if "string " == "string2":
            print("Strings are equal")
        else:
            print("strings are not equal")
        
        switchStmt()
            
    # cyclo == 7?
    def switchStmt(self):
        choice = int(5)
        if(choice == 0): 
            pass
        elif(choice == 1):
            pass
        elif(choice == 2):
            pass
        elif(choice == 3):
            pass
        elif(choice == 4):
            pass
        elif(choice==5):
            print(choice)
        else:
            print("choice is none of the above")
            
        print ("done")
        
        
    # cc == 3
    def loops(self):
        for i in range(0,5):
            if i % 2 == 0:
                print(i + " is even")
            else:
                print ("uneven")
                
    # cc = 7  
    def advLoops(self):    
        for i in range(0,500):
            if i % 2 == 0:
                print(i + " is even")
                if i * 356 % 3 > 1000:
                    print "something" 
                else: 
                    print "something else"  
                    
            else:
                for j in range(500,0):
                    while (j > 400):
                        print "j val is high"
                        if j == 250:
                            break
    
    
    # cc == 2
    def forStmt(self):
        
        for i in range(0,500):
            print("-")
            
            
    # cc == 2
    def forElseStmt(self):
        
        for i in range(0,500):
            print(i)
        else:
            print("out for")
        
    
    def tryCatchStmt(self):
        try:
            print("tried")
            
        except ValueError:
            print("caught exception")
        
        
    
    def tryMultiCatchStmt(self):
        try:
            print("tried")
        except ValueError:
            print("caught exception")
        except IOError:
            print("caught")
        except:
            raise
                    