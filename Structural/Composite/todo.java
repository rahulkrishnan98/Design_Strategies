public class todo implements TodoInterface
{
    String text;
    public todo(String text){
        this.text=text;
    }
    public String getHTML(){
        return this.text;
    }
}