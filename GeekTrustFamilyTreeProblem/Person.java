import java.util.*;
public class Person
{
    public static ArrayList<Person> Everyone = new ArrayList<Person>();
    String Name;
    String Gender;
    Person Spouse = null;
    ArrayList<Person> Children = new ArrayList<Person>(); 
    ArrayList<String> Empty = new ArrayList<String>();
    public Person Father;
    public Person Mother;

    public void addChildren(Person person){
        if(this.Children.contains(person)){
            System.out.println("Child Already Added");
        }
        else{
            this.Children.add(person);
        }
    }
    // Getter-Methods
    public ArrayList<Person> getEveryone(){
        return Everyone;
    }
    public Person getFather(){
        return this.Father;
    }
    public Person getMother(){
        return this.Mother;
    }
    public Person getSpouse(){
        return this.Spouse;
    }
    public ArrayList<Person> getChildren(){
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
    // // Relations
    public ArrayList<String> Paternal_Uncle(){
        if((this.Father == null) || (this.Father.Mother == null)){
            return Empty;
        }
        ArrayList<Person> Fathersibl = this.Father.Mother.getChildren();
        Fathersibl.remove(this.Father);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Fathersibl.size();i++){
            if(Fathersibl.get(i).Gender.equals("Male")){
                Temp.add(Fathersibl.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Maternal_Uncle(){
        if((this.Mother == null)||(this.Mother.Mother == null)){
            return Empty;
        }
        ArrayList<Person> Mothersibl = this.Mother.Mother.getChildren();
        Mothersibl.remove(this.Mother);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Mothersibl.size();i++){
            if(Mothersibl.get(i).Gender.equals("Male")){
                Temp.add(Mothersibl.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Paternal_Aunt(){
        if((this.Father == null)||(this.Father.Mother ==null)){
            return Empty;
        }
        ArrayList<Person> Fathersibl = this.Father.Mother.getChildren();
        Fathersibl.remove(this.Father);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Fathersibl.size();i++){
            if(Fathersibl.get(i).Gender.equals("Female")){
                Temp.add(Fathersibl.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Maternal_Aunt(){
        if((this.Mother == null)||(this.Mother.Mother == null)){
            return Empty;
        }
        ArrayList<Person> Mothersibl = this.Mother.Mother.getChildren();
        Mothersibl.remove(this.Mother);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Mothersibl.size();i++){
            if(Mothersibl.get(i).Gender.equals("Female")){
                Temp.add(Mothersibl.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Sister_In_Law(){
        if((this.Mother == null) || (this.Mother.Children.isEmpty())){
            return Empty;
        }
        ArrayList<Person> Orig = this.Mother.Children;
        Orig.remove(this);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            if((Orig.get(i).getSpouse()!=null) && (Orig.get(i).Gender.equals("Male"))){
                Temp.add(Orig.get(i).getSpouse().Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Brother_In_Law(){
        if((this.Mother == null)||(this.Mother.Children.isEmpty())){
            return Empty;
        }
        ArrayList<Person> Orig = this.Mother.Children;
        Orig.remove(this);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            if((Orig.get(i).getSpouse()!=null) && (Orig.get(i).Gender.equals("Female"))){
                Temp.add(Orig.get(i).getSpouse().Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Son(){
        ArrayList<Person> Orig = this.Children;
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            if(Orig.get(i).Gender.equals("Male")){
                Temp.add(Orig.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Daughter(){
        ArrayList<Person> Orig = this.Children;
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            if(Orig.get(i).Gender.equals("Female")){
                Temp.add(Orig.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Siblings(){
        if((this.Mother == null)||(this.Mother.Children.isEmpty())){
            return Empty;
        }
        ArrayList<Person> Orig = this.Mother.Children;
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            Temp.add(Orig.get(i).Name);
        }
        Temp.remove(this.Name);
        return Temp;
    }
    
    
    // Constructor
    public Person(String Name,String Gender, Person Father, Person Mother){
        this.Name = Name;
        this.Gender = Gender;
        setFather(Father);
        setMother(Mother);
        Everyone.add(this);
    }

    public String toString(){
        return this.Name;
    }
}