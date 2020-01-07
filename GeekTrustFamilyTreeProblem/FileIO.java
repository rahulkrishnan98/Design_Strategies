import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileIO
{
    private void processInput(String command, Person Root, FamilyTree family) {
		String[] Query = command.split(" ");
        String Result="";
        ArrayList<String> results = new ArrayList<String>();
		switch (Query[0]) {
        case "ADD_CHILD":
            Result = family.addNewChild(Query[1], Query[2], Query[3], Root);
            System.out.println(Result);
			break;

		case "GET_RELATIONSHIP":
            results = family.getRelation(Query[1], Query[2], Root);
            System.out.println(results);
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