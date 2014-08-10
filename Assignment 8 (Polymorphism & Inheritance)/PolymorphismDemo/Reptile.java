/**
 * class Reptile
 * 
 * This class is part of a simple example of polymorphism.
 * 
 * @author Andrew Nuxoll
 */
public class Reptile extends Animal
{
    public Reptile(String initName)
    {
        super(initName);
    }
    
    public String speak()
    {
        return this.getName() + ": Hiss!";
    }
}