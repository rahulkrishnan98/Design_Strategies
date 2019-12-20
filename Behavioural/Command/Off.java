public class Off implements Command
{
    Light light;

    public Off(Light light)
    {
        this.light = light;
    }

    public void execute()
    {
        this.light.Off();
    }
    public void unexecute()
    {
        this.light.On();
    }
}