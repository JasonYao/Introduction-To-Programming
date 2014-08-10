/**
 * class Human
 * 
 * This class is part of a simple example of polymorphism.
 * 
 * @author Andrew Nuxoll
 */
public final class Human extends Mammal
{
    private String firstName;
    private String lastName;
    
    public Human(String initFirst, String initLast)
    {
        super(initFirst + " " + initLast, 2);
        firstName = initFirst;
        lastName = initLast;
    }
    
    
    public String speak()
    {
        return "Hello, my name is " + this.getName() + ".";
    }
}