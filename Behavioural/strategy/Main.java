public class Main
{
    public static void main(String[] args)
    {
        Iswim swimmer0 = new swimMethod1();
        Iswim swimmer1 = new swimMethod2();
        Iquack quacker0 = new quackMethod1();
        Iquack quacker1 = new quackMethod2();

        duck Duck0 = new duck(swimmer0,quacker0);
        duck Duck1 = new duck(swimmer0,quacker1);
        duck Duck2 = new duck(swimmer1,quacker0);
        duck Duck3 = new duck(swimmer1,quacker1);

        Duck1.swim();
        Duck1.quack();
    }
}