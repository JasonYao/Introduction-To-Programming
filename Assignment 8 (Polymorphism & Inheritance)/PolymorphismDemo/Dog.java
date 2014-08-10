/**
 * class Dog
 * 
 * This class is part of a simple example of polymorphism.
 * 
 * @author Andrew Nuxoll
 */
public class Dog extends Mammal
{
    public Dog(String initName)
    {
        super(initName, 4);
    }
    
    public String speak()
    {
       return this.getName() + ": Woof!";
    }
    
    public boolean equals(Object other)
    {
        if (other instanceof Dog)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}