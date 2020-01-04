import java.util.*;
public class Person
{
    String Name;
    String Gender;
    Person Spouse = null;
    ArrayList<Person> Children = new ArrayList<Person>(); 
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
        ArrayList<Person> Fathersibl = this.Father.Mother.getChildren();
        Fathersibl.remove(this.Father);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Fathersibl.size();i++){
            if(Fathersibl.get(i).Gender == "Male"){
                Temp.add(Fathersibl.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Maternal_Uncle(){
        ArrayList<Person> Mothersibl = this.Mother.Mother.getChildren();
        Mothersibl.remove(this.Mother);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Mothersibl.size();i++){
            if(Mothersibl.get(i).Gender == "Male"){
                Temp.add(Mothersibl.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Paternal_Aunt(){
        ArrayList<Person> Fathersibl = this.Father.Mother.getChildren();
        Fathersibl.remove(this.Father);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Fathersibl.size();i++){
            if(Fathersibl.get(i).Gender == "Female"){
                Temp.add(Fathersibl.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Maternal_Aunt(){
        ArrayList<Person> Mothersibl = this.Mother.Mother.getChildren();
        Mothersibl.remove(this.Mother);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Mothersibl.size();i++){
            if(Mothersibl.get(i).Gender == "Female"){
                Temp.add(Mothersibl.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Sister_In_Law(){
        ArrayList<Person> Orig = this.Mother.Children;
        Orig.remove(this);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            if((Orig.get(i).getSpouse()!=null) && (Orig.get(i).Gender == "Male")){
                Temp.add(Orig.get(i).getSpouse().Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Brother_In_Law(){
        ArrayList<Person> Orig = this.Mother.Children;
        Orig.remove(this);
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            if((Orig.get(i).getSpouse()!=null) && (Orig.get(i).Gender == "Female")){
                Temp.add(Orig.get(i).getSpouse().Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Son(){
        ArrayList<Person> Orig = this.Children;
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            if(Orig.get(i).Gender == "Male"){
                Temp.add(Orig.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Daughter(){
        ArrayList<Person> Orig = this.Children;
        ArrayList<String> Temp = new ArrayList<String>();
        for(int i=0;i<Orig.size();i++){
            if(Orig.get(i).Gender == "Female"){
                Temp.add(Orig.get(i).Name);
            }
        }
        return Temp;
    }
    public ArrayList<String> Siblings(){
        ArrayList<Person> Orig = this.Mother.Children;
        ArrayList<String> Temp = new ArrayList<String>();
        if(this.Mother != null){
            for(int i=0;i<Orig.size();i++){
                Temp.add(Orig.get(i).Name);
            }
            Temp.remove(this.Name);
            return Temp;
        }
        return null;
    }

    // Constructor
    public Person(String Name, String Gender, Person Father, Person Mother){
        this.Name = Name;
        this.Gender = Gender;
        
        setFather(Father);
        setMother(Mother);
    }
}