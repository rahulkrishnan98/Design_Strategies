// Able to create null valued people
import java.io.*; 
import java.nio.*;
import java.util.*; 
import java.lang.*; 

public class FamilyTree
{
    public static Person person;
    public static Boolean addNewChild(String MotherName, String ChildName, String Gender, Person Root){
        Boolean added = false;
        ArrayList<Person> Everyone = Root.getEveryone();
        for(int i=0;i<Everyone.size();i++){
            if(Everyone.get(i).Name == MotherName){
                if(Everyone.get(i).getSpouse() != null){
                    Person newChild = new Person(ChildName,Gender, Everyone.get(i).getSpouse(), Everyone.get(i));
                    Everyone.get(i).addChildren(newChild);
                    added = true;
                    break;
                }
            }
        }
        return added;
    }
    public static ArrayList<String> getRelation(String Name, String Relation, Person Root){
        ArrayList<String> relations = new ArrayList<String>();
        ArrayList<Person> Everyone = Root.getEveryone();
        for(int i=0;i<Everyone.size();i++){
            if(Everyone.get(i).Name == Name){
                person = Everyone.get(i);
            }
        }
		switch (Relation) {
		case "DAUGHTER":
			relations = person.Daughter();
			break;

		case "SON":
			relations = person.Son();
			break;

		case "SIBLINGS":
			relations = person.Siblings();
			break;

		case "SISTER_IN_LAW":
			relations = person.Sister_In_Law();
			break;

		case "BROTHER_IN_LAW":
			relations = person.Brother_In_Law();
			break;

		case "MATERNAL_AUNT":
			if (person.Mother != null)
				relations = person.Maternal_Aunt();
			break;

		case "PATERNAL_AUNT":
			if (person.Father != null)
				relations = person.Paternal_Aunt();
			break;

		case "MATERNAL_UNCLE":
			if (person.Mother != null)
				relations = person.Maternal_Uncle();
			break;

		case "PATERNAL_UNCLE":
			if (person.Father != null)
				relations = person.Paternal_Uncle();
			break;

		default:
			relations.add("DOES NOT EXIST");
			break;
        }
        return relations;
    }

    public static void main(String[] args) {
        // Composition of Root of Lengaburu Family Tree
        Person KingShan = new Person("King Shan", "Male", null, null);
        Person QueenAnga = new Person("Queen Anga", "Female", null, null);

        Couple RootCouple = new Couple(KingShan, QueenAnga);

        // Level 1
        // Immediate Children
        Person Chit = new Person("Chit", "Male", KingShan, QueenAnga);
        Person Ish = new Person("Ish", "Male", KingShan, QueenAnga);
        Person Vich = new Person("Vich", "Male", KingShan, QueenAnga);
        Person Aras = new Person("Aras", "Male", KingShan, QueenAnga);
        Person Satya = new Person("Satya", "Female", KingShan, QueenAnga);

        RootCouple.addChild(Chit);
        RootCouple.addChild(Ish);
        RootCouple.addChild(Vich);
        RootCouple.addChild(Aras);
        RootCouple.addChild(Satya);

        // Secondary Children
        Person Amba = new Person("Amba", "Female", null, null);
        Person Lika = new Person("Lika", "Female", null, null);
        Person Chitra = new Person("Chitra", "Female", null, null);
        Person Vyan = new Person("Vyan", "Male", null, null);

        // Couples
        Couple ChitFamily = new Couple(Chit, Amba);
        Couple VichFamily = new Couple(Vich, Lika);
        Couple ArasFamily = new Couple(Aras, Chitra);
        Couple VyanFamily = new Couple(Vyan, Satya);

        // Level 2
        // Immediate Children
        Person Dritha = new Person("Dritha", "Female", Chit, Amba);
        Person Tritha = new Person("Tritha", "Female", Chit, Amba);
        Person Vritha = new Person("Vritha", "Male", Chit, Amba);
        ChitFamily.addChild(Dritha);
        ChitFamily.addChild(Tritha);
        ChitFamily.addChild(Vritha);

        Person Vila = new Person("Vila", "Female", Vich, Lika);
        Person Chika = new Person("Chika", "Female", Vich, Lika);
        VichFamily.addChild(Vila);
        VichFamily.addChild(Chika);

        Person Jnki = new Person("Jnki", "Female", Aras, Chitra);
        Person Ahit = new Person("Ahit", "Male", Aras, Chitra);
        ArasFamily.addChild(Jnki);
        ArasFamily.addChild(Ahit);

        Person Asva = new Person("Asva", "Male", Vyan, Satya);
        Person Vyas = new Person("Vyas", "Male", Vyan, Satya);
        Person Atya = new Person("Atya", "Female", Vyan, Satya);
        VyanFamily.addChild(Asva);
        VyanFamily.addChild(Vyas);
        VyanFamily.addChild(Atya);  

        // Secondary Children
        Person Jaya = new Person("Jaya", "Male", null, null);
        
        Person Arit = new Person("Arit", "Male", null, null);

        Person Satvy = new Person("Satvy", "Female", null, null);
        Person Krpi = new Person("Krpi", "Female", null, null);
    
        // Couples
        Couple JayaFamily = new Couple(Jaya, Dritha);
        Couple AritFamily = new Couple(Arit, Jnki);
        Couple AsvaFamily = new Couple(Asva, Satvy);
        Couple VyasFamily = new Couple(Vyas, Krpi);

        // Level 3
        // Immediate Children
        Person Yodhan = new Person("Yodhan", "Male", Jaya, Dritha);
        JayaFamily.addChild(Yodhan);

        Person Laki = new Person("Laki", "Male", Arit, Jnki);
        Person Lavnya = new Person("Lavnya", "Female", Arit, Jnki);
        AritFamily.addChild(Laki);
        AritFamily.addChild(Lavnya);

        Person Vasa = new Person("Vasa", "Male", Asva, Satvy);
        AritFamily.addChild(Vasa);

        Person Kriya = new Person("Kriya", "Male", Vyas, Krpi);
        Person Krithi = new Person("Krithi", "Female", Vyas, Krpi);
        VyasFamily.addChild(Kriya);
        VyasFamily.addChild(Krithi);

        // Check
        // CHange switch case names to right format
        Person Root = KingShan;
        System.out.println(addNewChild(Chitra.Name, "Aria", "Female",Root));
        System.out.println(Chitra.getChildren());
        System.out.println(getRelation(Lavnya.Name, "MATERNAL_AUNT", Root));
    }
}