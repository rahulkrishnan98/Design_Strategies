public class Main 
{
    public static void main(String[] args) {
        
        On on = new On();
        Off off = new Off();

        Motor newEngine = new Motor(on, off);
        
        on.settingUp(newEngine);
        off.settingUp(newEngine);

        newEngine.rotate();
        newEngine.stop();
    }
}