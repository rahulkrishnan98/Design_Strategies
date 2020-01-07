class FamilyExceptions extends Exception 
{ 
    public String str;
    public FamilyExceptions(String s) 
    { 
        str = s;
    } 
    public String toString(){
        return ("Invalid request: "+str) ;
    }
} 