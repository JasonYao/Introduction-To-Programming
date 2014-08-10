/**
 * A class to create Support Staff objects via inheritance
 * @author Jason Yao
 * @version 08/04/14
 */
public class Support extends Staff
{
    // Instance Variables
    private String department;
    
    /**
     * [CONSTRUCTOR] Initializes the salary, name, department and ID number attibute for any UP support staff members
     * @param initName The name of the staff member
     * @param initIDNum The ID number of the staff member
     * @param initSalary The annual salary the staff member gets
     * @param initDepartment The department the support staff is serving in (i.e. mailing, custodial, etc.)
     */
    public Support (String initName, int initIDNum, int initSalary, String initDepartment)
    {
        // Initializes the name, ID number, and salary of a Support Staff member
        super(initName, initIDNum, initSalary);
        
        // Initializes the department of the support staff
        this.department = initDepartment;
    }
    
    /**
     * [ACCESSOR] Gets the support staff's department
     * @return supportDepartment Returns the support staff's department
     */
    public String getDepartment ()
    {
        return department;
    }
    
    /**
     * [ACCESSOR] Gives a String representation of the object, showing a support staff's ID number, name, and department
     * @return supportStaffObjectString Returns a String representing the object
     */
    public String toString ()
    {
        String representative = getName() + " is a support staff member, with ID number: " +
                                    getIDNum() + ", and is a member of the " + department + "support department";
        return representative;
    }
    
    /**
     * [ACCESSOR] Returns true if the support staff member's salary is equal to another's, and is in the same department
     * @param supportStaffComparedTo Staff object being compared to
     * @return equalTrue set to true if the salary is equal to another's salary, and if both are in the same department
     */
    public boolean equals (Support supportComparedTo)
    {
        if (supportComparedTo != null)
        {
            if ((department == supportComparedTo.department) && (getSalary() == supportComparedTo.getSalary()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}

