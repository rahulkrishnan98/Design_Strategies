public class soy extends condimentDecorator
{
    Beverage beverage;
    public soy(Beverage b)
    {
        this.beverage = b;
    }
    public String getDescription()
    {
        return beverage.getDescription() + " " + "Soy";
    }

    public double cost()
    {
        return beverage.cost() + 17.2;
    }
}