public class Concview2 extends views
{
    ImplementorResource resource;
    public Concview2(ImplementorResource r)
    {
        this.resource = r;
    }
    public String show()
    {
        System.out.println("I am showing smaller view");
        return this.resource.snippet(); 
    }
}