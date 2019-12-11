public class LinuxFactory implements OSFactory
{
    public Button getButton()
    {
		return new LinuxButton();
	}
	public Frame getFrame()
	{
		return new LinuxFrame();
	}
}