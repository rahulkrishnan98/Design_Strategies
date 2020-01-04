import java.io.*; 
import java.util.*; 

public class FamilyTree
{
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
        
    }
}