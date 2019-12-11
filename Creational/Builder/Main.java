public class Main
{
    public static void main(String[] args) {
        
        concRobotBuilder builder = new concRobotBuilder();
        robotDirector engineer = new robotDirector(builder);

        engineer.makeRobo();
        robot tobi = engineer.getRobo();
        System.out.println(tobi.getHead());
        System.out.println(tobi.getLeg());
    }
}