public class Person
{
    String Name;
    String Gender;
    Person Spouse = null;
    ArrayList<Person> Children = null; 
    public Person Father;
    public Person Mother;

    // Getter-Methods
    public Person getFather(){
        return this.Father;
    }
    public Person getMother(){
        return this.Mother;
    }
    public Person getSpouse(){
        return this.Spouse;
    }
    public Person getChildren(){
        return this.Children;
    }

    // Setter-Methods
    public void setFather(Person Father){
        this.Father = Father;
    }
    public void setMother(Person Mother){
        this.Mother = Mother;
    }
    public void setSpouse(Person Spouse){
        this.Spouse = Spouse;
    }
    public void setChildren(ArrayList<Person> Children){
        this.Children = Children;
    }

    // Constructor
    public Person(String Name, String Gender, Person Father, Person Mother, Person Spouse = null, ArrayList<person> Children=null){
        this.Name = Name;
        this.Gender = Gender;
        
        setFather(Father);
        setMother(Mother);
        setSpouse(Spouse);
        setChildren(Children);
    }
}