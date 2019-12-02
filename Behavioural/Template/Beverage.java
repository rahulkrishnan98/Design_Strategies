public abstract class Beverage
{
    public final void prepBev()
    {
        BoilWater();
        Brew();
        pour();
        addCondiments();
    }

    abstract void Brew();
    abstract void addCondiments();

    void BoilWater()
    {
        System.out.println("Boiling Done");
    }
    void pour()
    {
        System.out.println("Pouring Beverage");
    }
}