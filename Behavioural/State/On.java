public class On implements State
{
    private Motor newEngine;
    public void rotate()
    {
        System.out.println("System is in On State Already");
    }
    public void stop()
    {
        System.out.println("Stopping Motor");
        newEngine.current = newEngine.off;
    }
    public void settingUp(Motor newEngine)
    {
        this.newEngine = newEngine;
    }
}