/**
 * [ABSTRACT] An abstract class to allow other classes to extend from it, specifically to create Student objects
 * @author Jason Yao
 * @version 08/04/14
 */
public abstract class Student extends UPPersonnel
{
    // Instance Variables
    private boolean fullTimeStatus;
    private double studentGPA;
    private int yearsEnrolled;
    private String degreeField;
    public double minStudentGPA;
    private int numCredits;
    
    /**
     * [CONSTRUCTOR] Initializes a student's values to include their status, their GPA, student year (1st, 2nd, etc),
     * their degree field, and the minimum
     * @param initName The name of the student
     * @param initIDNum The ID number of the student
     * @param initStatus The student's fulltime status
     * @param initGPA The student's current GPA as of the last official records
     * @param initEnrolledAge The number of years the student has attended UP or university in general
     * @param initDegree The student's field of study
     * @param initNumCredits The number of credits the student has taken so far
     */
    public Student (String initName, int initIDNum, boolean initStatus, double initGPA, int initEnrolledAge, String initDegree, int initNumCredits)
    {
        // Initializes the student's name and ID number
        super(initName, initIDNum);
        
        // Initializes the student's number of credits taken so far
        this.numCredits = initNumCredits;
        
        // Initializes the student's fulltime status
        this.fullTimeStatus = initStatus;
        
        // Initializes the student's GPA
        this.studentGPA = initGPA;
        
        // Initializes the number of years the student has been enrolled for
        this.yearsEnrolled = initEnrolledAge;
        
        // Initializes the student's degree field
        this.degreeField = initDegree;
    }

    /**
     * [ACCESSOR] Gets the status of the student, about whether the student is attending UP fulltime or not
     * @return studentTimeStatus Returns true if the student is attending the minimum number of credits
     */
    public boolean getStatus ()
    {
        return fullTimeStatus;
    }

    /**
     * [ACCESSOR] Gets the GPA of the student
     * @return studentGPA Returns the GPA of the student, truncates to 2 decimal places after adding 0.005,
     * effectively rounding the value to 2 decimals
     */
    public double getGPA ()
    {
        return studentGPA;
    }
    
    /**
     * [ACCESSOR] Gets the number of credits the student has taken so far
     * @return studentNumCredits Returns the number of credits the student has taken so far, includes this semester's courses
     */
    public int getNumCredits ()
    {
        return numCredits;
    }

    /**
     * [ACCESSOR] Gets the number of years the student has been enrolled at UP, or any other university
     * @return studentEnrolledAge Returns which year the student is in (1st year, 2nd year, etc)
     */
    public int getEnrolledAge ()
    {
        return yearsEnrolled;
    }

    /**
     * [ACCESSOR] Gets the degree field of the student
     * @return studentDegreeField Returns the student's field of study in a String
     */
    public String getDegree ()
    {
        return degreeField;
    }

    /**
     * [ACCESSOR] Sets the minimum GPA of the student, differs from undergraduates to graduate students
     * @return studentMinGPA
     */
    abstract public double getMinGPA ();

    /**
     * [ACCESSOR] Gives a String representation of the object, showing a student's field of study, GPA, and fulltime status
     * @return studentObjectString Returns a String representing the object
     */
    public String toString ()
    {
        String representative = getName() + " is a " + degreeField + " majour, with a GPA of " + studentGPA + ", and is ";
        
        if (fullTimeStatus == true)
        {
            representative = representative + "a full time student";
        }
        else
        {
            representative = representative + "not a full time student";
        }
        return representative;
    }

    /**
     * [ACCESSOR] Returns true if two Student objects are considered equals, and false if they are found different
     * @param studentComparedTo The Student object being compared to
     * @return studentEquals Returns true if two students are equal based upon whether they have the same fulltime status and GPA score.
     */
    public boolean equals (Student studentComparedTo)
    {
        if (studentComparedTo != null)
        {
            if ((studentGPA == studentComparedTo.getGPA()) && (fullTimeStatus == studentComparedTo.getStatus()))
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

