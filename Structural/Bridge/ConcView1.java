public class ConcView1 extends views
{
    ImplementorResource resource;
    public ConcView1(ImplementorResource r)
    {
        this.resource = r;
    }
    public String show()
    {
        System.out.println("I am showing big view");
        return this.resource.snippet(); 
    }
}