public class choco extends condimentDecorator
{
    Beverage beverage;
    public choco(Beverage b)
    {
        this.beverage = b;
    }
    public String getDescription()
    {
        return beverage.getDescription() + " " + "choco";
    }

    public double cost()
    {
        return beverage.cost() + 11.1 ;
    }
}