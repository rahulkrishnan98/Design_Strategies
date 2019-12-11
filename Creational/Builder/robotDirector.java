public class robotDirector
{
    private robotBuilder builder;
    
    public robotDirector(robotBuilder roboEngineer)
    {
        this.builder = roboEngineer;
    }
    
    public void makeRobo()
    {
        this.builder.makeHead("RoboHead");
        this.builder.makeLeg("RoboLeg");
    }

    public robot getRobo()
    {
        return this.builder.getRobot();
    }
}