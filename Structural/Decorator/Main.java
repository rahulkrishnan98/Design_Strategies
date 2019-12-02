public class Main
{
    public static void main(String[] args)
    {
        Beverage b  = new Expresso();
        b = new milk(b);
        b = new soy(b);
        Beverage c = new Decaf();
        c = new choco(c);
        System.out.println(c.getDescription() + " " + c.cost());
        System.out.println(b.getDescription() + " " + b.cost());
    }
}