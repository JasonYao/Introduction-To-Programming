/**
 * A class to create Graduate Student objects via inheritance
 * @author Jason Yao
 * @version 08/04/14
 */
public class Graduate extends Student
{
    // Instance Variables
    public static final double MIN_GRADUATE_GPA = 3.00;
    
    /**
     * [CONSTRUCTOR] Initializes the variables for an Graduate object
     * Graduate constructor
     * @param initName The name of the student
     * @param initIDNum The ID number of the student
     * @param initStatus The student's fulltime status
     * @param initGPA The student's current GPA as of the last official records
     * @param initEnrolledAge The number of years the student has attended UP or university in general
     * @param initDegree The student's field of study
     * @param initNumCredits The number of credits the student has taken so far
     */
    public Graduate (String initName, int initIDNum, boolean initStatus, double initGPA, int initEnrolledAge, String initDegree, int initNumCredits)
    {
        super(initName, initIDNum, initStatus, initGPA, initEnrolledAge, initDegree, initNumCredits);
    }
    
    /**
     * [ACCESSOR] Gets the minimum GPA allowed for a graduate student
     * @return graduateMinGPA returns the minimum allowed GPA
     */
    public double getMinGPA ()
    {
        minStudentGPA = MIN_GRADUATE_GPA;
        return minStudentGPA;
    }
    
    /**
     * [ACCESSOR] Gives a String representation of the object, showing a student's field of study, GPA, Class name, and fulltime status
     * @return studentObjectString Returns a String representing the object
     */
    public String toString ()
    {
        String representative = getName() + " is a " + getDegree() + " majour, with a GPA of " + getGPA() + ", and is ";

        if (getStatus() == true)
        {
            representative = representative + "a full time ";
            if (getMinGPA() > 2.00)
            {
                representative = representative + "graduate student";
            }
            else
            {
                representative = representative + "undergraduate student";
            }
        }
        else
        {
            representative = representative + "not a full time ";
            if (getMinGPA() > 2.00)
            {
                representative = representative + "graduate student";
            }
            else
            {
                representative = representative + "undergraduate student";
            }
        }
        return representative;
    }
}

