import java.io.*; 
import java.util.*; 

public class FamilyTree
{
    public static void main(String[] args) {
        // Composition of Root of Lengaburu Family Tree
        Person KingShan = new Person("King Shan", "Male", null, null,null,null);
        Person QueenAnga = new Person("Queen Anga", "Female", null, null, null, null);

        Couple RootCouple = new Couple(kingShan, QueenAnga, null);

        // Level 1
        // Immediate Children
        Person Chit = new Person("Chit", "Male", KingShan, QueenAnga, null, null);
        Person Ish = new Person("Ish", "Male", KingShan, QueenAnga, null, null);
        Person Vich = new Person("Vich", "Male", KingShan, QueenAnga, null, null);
        Person Aras = new Person("Aras", "Male", KingShan, QueenAnga, null, null);
        Person Satya = new Person("Satya", "Female", KingShan, QueenAnga, null, null);

        RootCouple.addChild(Chit);
        RootCouple.addChild(Ish);
        RootCouple.addchild(Vich);
        RootCouple.addChild(Aras);
        RootCouple.addChild(Satya);

        // Secondary Children
        Person Amba = new Person("Amba", "Female", null, null, null,null);
        Person Lika = new Person("Lika", "Female", null, null, null,null);
        Person Chitra = new Person("Chitra", "Female", null, null, null,null);
        Person Vyan = new Person("Vyan", "Male", null, null, null,null);

        // Couples
        Couple ChitFamily = new Couple(Chit, Amba, null);
        Couple VichFamily = new Couple(Vich, Lika, null);
        Couple ArasFamily = new Couple(Aras, Chitra, null);
        Couple VyanFamily = new Couple(Vyan, Satya, null);

        // Level 2
        // Immediate Children
        Person Dritha = new Person("Dritha", "Female", Chit, Amba, null, null);
        Person Tritha = new Person("Tritha", "Female", Chit, Amba, null, null);
        Person Vritha = new Person("Vritha", "Male", Chit, Amba, null, null);
        ChitFamily.addChild(Dritha);
        ChitFamily.addChild(Tritha);
        ChitFamily.addChild(Vritha);

        Person Vila = new Person("Vila", "Female", Vich, Lika, null, null);
        Person Chika = new Person("Chika", "Female", Vich, Lika, null, null);
        VichFamily.addChild(Vila);
        VichFamily.addChild(Chika);

        Person Jnki = new Person("Jnki", "Female", Aras, Chitra, null, null);
        Person Ahit = new Person("Ahit", "Male", Aras, Chitra, null, null);
        ArasFamily.addChild(Jnki);
        ArasFamily.addChild(Ahit);

        Person Asva = new Person("Asva", "Male", Vyan, Satya, null, null);
        Person Vyas = new Person("Vyas", "Male", Vyan, Satya, null, null);
        Person Atya = new Person("Atya", "Female", Vyan, Satya, null, null);
        VyanFamily.addChild(Asva);
        VyanFamily.addChild(Vyas);
        VyanFamily.addChild(Atya);  

        // Secondary Children
        Person Jaya = new Person("Jaya", "Male", null, null, null, null);
        
        Person Arit = new Person("Arit", "Male", null, null, null, null);

        Person Satvy = new Person("Satvy", "Female", null, null, null, null);
        Person Krpi = new Person("Krpi", "Female", null, null, null, null);
    
        // Couples
        Couple JayaFamily = new Couple(Jaya, Dritha, null);
        Couple AritFamily = new Couple(Arit, Jnki, null);
        Couple AsvaFamily = new Couple(Asva, Satvy, null);
        Couple VyasFamily = new Couple(Vyas, Krpi, null);

        // Level 3
        // Immediate Children
        Person Yodhan = new Person("Yodhan", "Male", Jaya, Dritha, null, null);
        JayaFamily.addChild(Yodhan);

        Person Laki = new Person("Laki", "Male", Arit, Jnki, null, null);
        Person Lavnya = new Person("Lavnya", "Female", Arit, Jnki, null, null);
        AritFamily.addChild(Laki);
        AritFamily.addChild(Lavnya);

        Person Vasa = new Person("Vasa", "Male", Asva, Satvy, null, null);
        AritFamily.addChild(Vasa);

        Person Kriya = new Person("Kriya", "Male", Vyas, Krpi, null, null);
        Person Krithi = new Person("Krithi", "Female", Vyas, Krpi, null, null);
        VyasFamily.addChild(Kriya);
        VyasFamily.addChild(Krithi);
    }
}