public class WaterMobilityFactory implements MobilityFactory 
{
    public ProductAnimal mobility(String animal){
        if(animal=="Fish"){
            return new ConcProdFish();
        }
        else{
            return null;
        }
    }
}