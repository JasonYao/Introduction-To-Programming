/**
 * class Bird
 * 
 * This class is part of a simple example of polymorphism.
 * 
 * @author Andrew Nuxoll
 */
public class Bird extends Animal
{
    public Bird(String initName)
    {
        super(initName);
    }
    
    public String peck()
    {
        return "rat-a-tat!";
    }
    
    public String speak()
    {
        return (this.getName() + ": Chirp!");
    }
}