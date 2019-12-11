public class Main
{
    public static void main(String[] args) {
        
        weatherStation station = new weatherStation();
        concreteObserver observer = new concreteObserver(station);

        station.add(observer);
        station.notifyMe();
    }
}