public class Off implements State
{

    private Motor newEngine;
    public void rotate()
    {
        System.out.println("System Switched On");
        newEngine.current = newEngine.on;
    }
    public void stop()
    {
        System.out.println("Already Motor is in Stop State");
    }
    public void settingUp(Motor newEngine)
    {
        this.newEngine = newEngine;
    }
}
