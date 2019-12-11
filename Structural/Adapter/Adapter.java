public class Adapter implements Itarget
{
    Adaptee adaptee;
    
    public Adapter(Adaptee adaptee)
    {
        this.adaptee = adaptee;
    }

    public void request()
    {
        this.adaptee.specificRequest();
    }
}