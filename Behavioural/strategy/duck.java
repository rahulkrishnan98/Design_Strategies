public class duck
{
    Iswim swimmer;
    Iquack quacker;

    duck(Iswim s, Iquack q)
    {
        this.swimmer=s;
        this.quacker=q;
    }
    public void swim(){
        swimmer.swim();
    }
    public void quack(){
        quacker.quack();
    }
}