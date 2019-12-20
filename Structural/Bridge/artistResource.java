public class artistResource implements ImplementorResource
{
    artist name;
    public artistResource(artist name)
    {
        this.name = name;
    }
    public String snippet(){
        return this.name.returnName();
    }
}