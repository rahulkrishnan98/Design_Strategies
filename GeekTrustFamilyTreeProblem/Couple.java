import java.util.*;
public class Couple
{
    Person husband;
    Person wife;
    public Couple(Person Husband, Person Wife)
    {
        // Check
        try{
            if((Husband.getSpouse() != null )||(Wife.getSpouse() != null)){
                System.out.println("Invalid Relation Request [Try Single Associations]");
                throw new FamilyExceptions("Spouse Exists");
            }
        }
        catch(FamilyExceptions e){
            System.out.println(e);
        }   
        // Initialization
        this.husband = Husband;
        this.wife = Wife;
        husband.Spouse = Wife;
        wife.Spouse = Husband;
    }
    public void addChild(Person child)
    {
        this.husband.addChildren(child);
        this.wife.addChildren(child);
    }
    public ArrayList<Person> getChild(){
        return this.wife.getChildren();
    }
    public ArrayList<Person> CoupleNames(){
        ArrayList<Person> coupleNames = new ArrayList<Person>();
        coupleNames.add(this.husband);
        coupleNames.add(this.wife);
        return coupleNames;
    }

}