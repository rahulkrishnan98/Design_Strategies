public class Main 
{
    public static void main(String[] args) {

        WindowsFactory windows= new WindowsFactory();
        Button windowsButton = windows.getButton();

        windowsButton.ButtonText();

        LinuxFactory linux = new LinuxFactory();
        Frame linuxFrame = linux.getFrame();

        linuxFrame.Breadth();
    }
}