public class Main
{
    public static void main(String[] args)
    {
        coffee c = new coffee();
        tea t = new tea();

        c.prepBev();
        System.out.println("***************");
        t.prepBev();
    }
}