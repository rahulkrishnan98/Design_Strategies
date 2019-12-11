public class concreteObserver implements IObserver
{
    weatherStation station;
    public concreteObserver(weatherStation station)
    {
        this.station  = station;
    }
    public void update()
    {
        System.out.println(this.station.getTemp());
    }
}