import java.util.*;
import java.io.*;
public class weatherStation implements Subject
{
    ArrayList<IObserver> obsList = new ArrayList<IObserver>();
    int temp = 10;

    public void add(IObserver obj)
    {
        obsList.add(obj);
    }
    public void notifyMe()
    {
        for(int i=0;i<obsList.size();i++)
        {
            obsList.get(i).update();
        }
    }

    public int getTemp()
    {
        return temp;
    }
}