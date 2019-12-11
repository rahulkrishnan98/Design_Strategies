public class concRobotBuilder implements robotBuilder
{
    String head;
    String leg;
    private robot robo;


    public concRobotBuilder()
    {
        this.robo = new robot();    
    }

    public void makeHead(String head)
    {
        robo.makeHead(head);
    }
    public void makeLeg(String leg)
    {
        robo.makeLeg(leg);
    }
    public robot getRobot()
    {
        return robo;
    }
}
