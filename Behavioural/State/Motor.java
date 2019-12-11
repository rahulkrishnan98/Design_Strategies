public class Motor 
{
    State on, off, current;
    
    public Motor(State On, State Off){
        this.current = Off;
        this.on = On;
        this.off = Off;
    }

    public void rotate()
    {
        current.rotate();
    }

    public void stop()
    {
        current.stop();
    }
}