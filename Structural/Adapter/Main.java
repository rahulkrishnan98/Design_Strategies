public class Main 
{   
    public static void main(String[] args) {
        
        Itarget target = new Adapter(new Adaptee());
        target.request();
    }
}