public class WindowsFactory implements OSFactory
{
    public Frame getFrame()
    {
		return new MSFrame();
	}
	public Button getButton()
	{
		return new MSButton();
	}
}