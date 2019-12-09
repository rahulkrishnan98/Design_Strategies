public class LandMobilityFactory implements MobilityFactory
{
    @Override
    public ProductAnimal mobility(String animal)
    {
        if(animal=="Cat"){
            return new ConcProdCat();
        }
        else if(animal=="Dog"){
            return new ConcProdDog();
        }
        else{
            return null;
        }
    }
}