import java.io.*;
import java.util.*;

public class FileIO
{
    private void processInput(String command, Person Root, FamilyTree family) {
        ArrayList<Person> Everyone = Root.getEveryone();
        ArrayList<String> EveryoneStr = new ArrayList<String>();
        for(int i=0;i<Everyone.size();i++){
            EveryoneStr.add(Everyone.get(i).Name);
        }
		String[] Query = command.split(" ");
        String Result="";
        ArrayList<String> results =  new ArrayList<String>();
		switch (Query[0]) {
        case "ADD_CHILD":
            if(!(EveryoneStr.contains(Query[1]))){
                Result = "PERSON_NOT_FOUND";
                System.out.println(Result);
                break;
            }
            Result = family.addNewChild(Query[1], Query[2], Query[3], Root);
            System.out.println(Result);
			break;

        case "GET_RELATIONSHIP":
            if(!(EveryoneStr.contains(Query[1]))){
                Result = "PERSON_NOT_FOUND";
                System.out.println(Result);
                break;
            }
            results = family.getRelation(Query[1], Query[2], Root);
            if(results.isEmpty()){
                System.out.println("NONE");
            }
            else{
                StringBuilder sb = new StringBuilder();
                for (String s : results){
                    sb.append(s);
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            }
			break;

		default:
            Result = "INVALID_COMMAND";
            System.out.println(Result);
			break;
		}
    }
    public void processFile(File file, Person Root, FamilyTree family) {
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
                String command = sc.nextLine();
                processInput(command, Root, family);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
}