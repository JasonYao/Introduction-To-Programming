/**
 * class Parrot
 * 
 * This class is part of a simple example of polymorphism.
 * 
 * @author Andrew Nuxoll
 */
public class Parrot extends Bird
{
    public Parrot(String initName)
    {
        super(initName);
    }
    
    public String speak()
    {
        return this.getName() + " wants a cracker!";
    }
}