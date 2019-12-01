import java.io.*; 
import java.util.*; 
public class Main
{
    public static void main(String[] args)
    {
        TodoInterface task1 = new todo("Task1");
        TodoInterface task2 = new todo("Task2");
        TodoInterface task3 = new todo("Task3");
        ArrayList<TodoInterface> comp1_child = new ArrayList<TodoInterface>();
        comp1_child.add(task2);
        comp1_child.add(task3);
        
        
        TodoInterface composite2= new project("composite2",comp1_child);

        ArrayList<TodoInterface> comp2_child = new ArrayList<TodoInterface>();
        comp2_child.add(task1);
        comp2_child.add(composite2);

        TodoInterface composite1= new project("Composite1",comp2_child);

        System.out.println(composite1.getHTML());
    }
}