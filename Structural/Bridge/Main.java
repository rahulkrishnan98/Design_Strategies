public class Main 
{
    public static void main(String[] args) {
        artist Name = new artistConc1();
        ImplementorResource r = new artistResource(Name);   
        // Large View
        views large = new ConcView1(r);
        System.out.println(large.show());
        // Small View
        views small = new Concview2(r);
        System.out.println(small.show());
    }
}