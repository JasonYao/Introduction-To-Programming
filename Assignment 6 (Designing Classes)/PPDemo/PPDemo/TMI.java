
/**
 * TMI - a class with all-public methods and instance variables
 * 
 * @author kw
 * @version 24 Feb 2014
 */
public class TMI
{
    // instance variables - replace the example below with your own
    public String name;
    public String greeting;
    public int age;

    /**
     * Constructor for objects of class TMI
     */
    public TMI(String newName, String newGreeting, int newAge)
    {
        // initialise instance variables
        name = newName;
        greeting = newGreeting;
        age = newAge;
    }

    /**
     * getAge - get the age of this TMI object
     * 
     * @return     age
     */
    public int getAge()
    {
        // put your code here
        return age;
    }
}
