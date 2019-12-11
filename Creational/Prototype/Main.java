public class Main 
{
    public static void main(String[] args) {
        

        lion Queen = new lion();

        lion clonedLioness = (lion) Queen.makeCopy();

        System.out.println("Queen HashCode: " + System.identityHashCode(System.identityHashCode(Queen)));
        System.out.println("Lioness HashCode: " + System.identityHashCode(System.identityHashCode(clonedLioness)));

    }
}