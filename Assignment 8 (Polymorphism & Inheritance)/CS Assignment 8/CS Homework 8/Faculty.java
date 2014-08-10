/**
 * A class to create Support Staff objects via inheritance
 * @author Jason Yao
 * @version 08/04/14
 */
public class Faculty extends Staff
{
    // Instance Variables
    private boolean tenure;
    private int ranking;
    
    /**
     * [CONSTRUCTOR] Initializes the salary, name, department and ID number attibute for any UP faculty members
     * @param initName The name of the staff member
     * @param initIDNum The ID number of the staff member
     * @param initSalary The annual salary the staff member gets
     * @param initTenure Whether the professor has tenure at the university
     * @param initRanking The ranking of the professor based upon student reviews
     */
    public Faculty (String initName, int initIDNum,  int initSalary, boolean initTenure, int initRanking)
    {
        // Initializes the name, ID number, and salary of a faculty member
        super(initName, initIDNum, initSalary);
        
        // Initializes the tenure of a faculty member
        this.tenure = initTenure;
        
        // Initializes the ranking of a faculty member
        this.ranking = initRanking;
    }
    
    /**
     * [ACCESSOR] Gets the faculty member's tenure status
     * @return tenureTrue Returns the faculty member's tenure status
     */
    public boolean getTenure ()
    {
        return tenure;
    }
    
    /**
     * [ACCESSOR] Gets the faculty member's ranking
     * @return facultyRanking Returns the faculty member's ranking from student evaluations
     */
    public int getRanking ()
    {
        return ranking;
    }
    
    /**
     * [ACCESSOR] Gives a String representation of the object, showing a faculty member's ID number, name, and ranking
     * @return facultyObjectString Returns a String representing the object
     */
    public String toString (  )
    {
        String representative = getName() + " is a faculty member, with ID number: " +
                                    getIDNum() + ", and is ranked by students as number " + ranking;
        return representative;
    }
    
    /**
     * [ACCESSOR] Returns true if the faculty member's ranking is equal to another's ranking
     * @param facultyComparedTo Staff object being compared to
     * @return equalTrue set to true if the ranking is equal to another's ranking
     */
    public boolean equals (Faculty facultyComparedTo)
    {
        if (facultyComparedTo != null)
        {
            if (ranking == facultyComparedTo.ranking)
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

