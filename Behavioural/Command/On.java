public class On implements Command
{
    Light light;

    public On(Light light)
    {
        this.light = light;
    }

    public void execute()
    {
        this.light.On();
    }
    public void unexecute()
    {
        this.light.Off();
    }
}