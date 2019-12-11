public class lion implements Animal
{
    String id = "original";
    public lion()
    {
        System.out.println("Created Lion");
    }

    public Animal makeCopy()
    {
       System.out.println("Initializing Lion");
       lion lioness = null;
       try {
            lioness = (lion) super.clone();
       } catch (Exception e) {
           //TODO: handle exception
           System.out.println("Exception in Clone");
       } 
       return lioness;

    }
    public String toString()
    {
        return "Created a lioness copy ";
    }
}