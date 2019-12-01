import java.io.*; 
import java.util.*; 
public class project implements TodoInterface
{
    String text;
    ArrayList<TodoInterface> todos;
    public project(String text,ArrayList<TodoInterface> todos)
    {
        this.text=text;
        this.todos=todos;
    }
    public String getHTML(){
        String html="";
        html+=this.text;
        for(int i=0;i<todos.size();i++)
        {
            html+="-->";
            html+=todos.get(i).getHTML();
        }
        return html;
    }
}