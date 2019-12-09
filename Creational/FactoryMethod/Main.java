public class Main
{
    public static void main(String[] args) {
        String animal0="Cat";
        String animal1="Dog";
        String animal2="Fish";
        
        LandMobilityFactory lander = new LandMobilityFactory();
        WaterMobilityFactory waterer = new WaterMobilityFactory();

        ProductAnimal howImove0 = lander.mobility(animal0);
        ProductAnimal howImove1 = waterer.mobility(animal1);

        howImove1.Iam();
    }
}