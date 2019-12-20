public class Invoker
{
    Command on;
    Command off;

    public Invoker(Command on, Command off)
    {
        this.on = on;
        this.off = off;
    }

    public void clickOn()
    {
        this.on.execute();
    }

    public void clickOff()
    {
        this.off.execute();
    }
}