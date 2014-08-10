/**
 * [ABSTRACT] An abstract class to hold attributes of a staff member at UP
 * @author Jason Yao
 * @version 08/04/14
 */
public abstract class Staff extends UPPersonnel
{
    // Instance Variables
    private int salary;
    
    /**
     * [CONSTRUCTOR] Initializes the salary, name and ID number attibute for any UP staff members
     * @param initName The name of the staff member
     * @param initIDNum The ID number of the staff member
     * @param initSalary The annual salary the staff member gets
     */
    public Staff (String initName, int initIDNum, int initSalary)
    {
        // Initializes the name and ID number attribute via super
        super(initName, initIDNum);
        
        // Initializes the salary attribute to initSalary
        this.salary = initSalary;
    }

    /**
     * [ACCESSOR] Gets the salary of the staff member
     * @return staffSalary Annual salary amount of the staff member, in pennies
     */
    public int getSalary ()
    {
        return salary;
    }

    /**
     * [ACCESSOR] Outputs an object into a string format that includes the staff member's name, ID number and salary
     * @return outPutString the object in a String output
     */
    public String toString ()
    {
        String representative = getName() + " is a staff member, with ID number: " +
                                    getIDNum() + ", and has an annual salary of " + salary;
        return representative;
    }

    /**
     * [ACCESSOR] Returns true if the staff member's salary is equal to another's
     * @param staffComparedTo Staff object being compared to
     * @return equalTrue set to true if the salary is equal to another staff object
     */
    public boolean equals(Staff staffComparedTo)
    {
        if (salary == staffComparedTo.salary)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

