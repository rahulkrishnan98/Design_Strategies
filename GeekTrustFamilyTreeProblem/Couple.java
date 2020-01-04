// Note: Husband can have parent, while wife might have parent defined from another part of tree (vice-versa)
public class Couple
{
    Person husband;
    Person wife;
    public Couple(Person Husband, Person Wife, ArrayList<Person> Children)
    {
        // Initialization
        this.husband = Husband;
        this.wife = Wife;
        // Relation and Children
        husband.spouse = Wife;
        wife.spouse = Husband;
        husband.Children = Children;
        wife.Children = Children;
    }
    public void addChild(Person child)
    {
        husband.Children.add(child);
        wife.children.add(child);
    }
}