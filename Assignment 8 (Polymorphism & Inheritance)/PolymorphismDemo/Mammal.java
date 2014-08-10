/**
 * class Mammal
 * 
 * This class is part of a simple example of polymorphism.
 * 
 * @author Andrew Nuxoll
 */
public abstract class Mammal extends Animal
{
    private int numLegs;

    public Mammal(String initName, int initLegs)
    {
        super(initName);
        numLegs = initLegs;
    }
    
    public int getNumLegs()
    {
        return numLegs;
    }
}