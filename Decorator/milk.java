public class milk extends condimentDecorator
{
    Beverage beverage;
    public milk(Beverage b)
    {
        this.beverage = b;
    }

    public String getDescription()
    {
        return beverage.getDescription() + " " + "Milk";
    }

    public double cost()
    {
        return beverage.cost() + 25.5;
    }
}