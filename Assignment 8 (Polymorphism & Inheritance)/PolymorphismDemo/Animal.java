
/**
 * class Animal
 * 
 * Simple example of an abstract class that is at 
 * the root of a simple example of polymorphism.  
 * 
 * @author Andrew Nuxoll
 */
public abstract class Animal
{
    private String name;
    
    public Animal(String initName)
    {
        name = initName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public abstract String speak();
    
    
    
    
}