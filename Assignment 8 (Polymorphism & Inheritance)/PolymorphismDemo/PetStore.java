/**
 * class PetStore
 * 
 * This class is part of a simple example of polymorphism.  
 * It creates an array of objects with a shared ancestor 
 * class and demonstrates how identical method calls yield 
 * different results.  It also demonstrates the instanceof 
 * operator.
 * 
 * @author Andrew Nuxoll
 */
public class PetStore
{
    public static void main(String[] args)
    {
        Animal blob = new Bird("Polly"); // = new Animal("Bob");
        if (blob instanceof Bird)
        {
            Bird blobBird =(Bird) blob;
            blobBird.peck();
        }
        //Create an array of Animals
        Animal[] crowd = new Animal[8];
        crowd[0] = new Bird("Sparrow");
        crowd[1] = new Parrot("Esmerelda");
        crowd[2] = new Dog("Rex");
        crowd[3] = new Human("Jane", "Doe");
        crowd[4] = new Human("John", "Doe");
        crowd[5] = new Reptile("Gecko");
        crowd[6] = new Snake("Snake");
        crowd[7] = new Fish("Pices");
        
       //Animal foo = new Animal("Animal");

        //Have all the Animals speak
        System.out.println("All Animals Say:");
        System.out.println("----------------");
        for(int i = 0; i < crowd.length; i++)
        {
            System.out.println(crowd[i].speak());
        }

        //Have only the mammals speak
        System.out.println("The Mammals Say:");
        System.out.println("----------------");
        for(int i = 0; i < crowd.length; i++)
        {
            if (crowd[i] instanceof Mammal)
            {
               Mammal m = (Mammal) crowd[i];
               System.out.println(m.speak() + " " + m.getNumLegs());
               //System.out.println(crowd[i].speak());
            }
        }
        
        
        // test equals() in Dog
        Dog fido = new Dog("Fido");
        Dog spot = new Dog("Spot");
        Bird tweety = new Bird("Tweety");
        System.out.println("fido.equals(spot): " +  fido.equals(spot));
        System.out.println("fido.equals(tweety): " + fido.equals(tweety));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
    }
}