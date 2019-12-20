public class Main 
{
    public static void main(String[] args) {
        
        Light light = new Light();

        Command on = new On(light);
        Command off = new Off(light);

        Invoker invoker = new Invoker(on, off);
        invoker.clickOn();
        invoker.clickOff();
    }
}