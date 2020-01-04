// Note: Husband can have parent, while wife might have parent defined from another part of tree (vice-versa)
import java.util.*;
public class Couple
{
    Person husband;
    Person wife;
    ArrayList<Person> Children = new ArrayList<Person>();
    public Couple(Person Husband, Person Wife)
    {
        // Initialization
        this.husband = Husband;
        this.wife = Wife;
        // Relation 
        husband.Spouse = Wife;
        wife.Spouse = Husband;
    }
    public void addChild(Person child)
    {
        this.husband.Children.add(child);
        this.wife.Children.add(child);
    }
}