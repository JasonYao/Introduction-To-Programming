/**
 * Senator creates a ASUP Senator object, which will vote on upcoming projects
 * in the ASUP Meeting
 * 
 * @author Jason Yao
 * @version 06 Mar 2014 finished filling in with student pseudo-code
 */
public class Senator
{
    // instance variables, attributes that are a part of a Senator object
    public String name; // (public) The name of the senator
    public double projectSuppCount = 0; // (public) The number of project(s) that the senator has approved (starts at 0)
    public String projectApprovalRate = ""; // (public) the overall rate the senator approves projects
    public int totalSpent = 0;
    
    // Outputs the constituency as a String based upon its identifier number
    public String constituency;
    public String constituencyHall;
    public String constituencyClass;

    // boolean variable that decides if the senator will vote or not for a specific project
    private boolean vote = false;

    // Senator constituencyAge list
    public static final int Freshman = 0; 
    public static final int Sophomore = 1;
    public static final int Junior = 2;
    public static final int Senior = 3;

    // Senator constituencyHall list
    public static final int Mehling = 0;
    public static final int Villa = 1;
    public static final int Corrado = 2;
    
    public static final int noBeneficiary = 4;

    /**
     * Constructor for objects of class Senator
     */
    public Senator(String name, int constituencyHallIdent, int constituencyClassIdent)
    {
        // Initializes the Senator object to default values
        // Initializes the name of the Senator
        setName(name); // sets the name of the senator
        name = nameToString(); // returns the name of the senator

        // Initializes the senator's constituency
        // First section is the hall the senator represents (if any) using the setConstituencyHall
        //and hallToString methods
        setConstituencyHall(constituencyHallIdent);
        hallToString();

        // Second section is the class the senator represents (if any) using the setConstituencyClass
        //and getConstituencyClass methods
        setConstituencyClass(constituencyClassIdent);
        classToString();

        // Combines the classToString and hallToString methods to return the senator's full constituency.
        setConstituencyFull();
        getConstituency();

        // Calculates the senator's project approval rate
        //setProjectApprovalRate();
        //getProjectApprovalRate();
    }

    /**
     * [mutator] sets the senator's name
     */
    public void setName(String name)
    {
        if (name != null)
        {
            String trimmed = name.trim();
            this.name = trimmed;
        }
    }

    /**
     * [Accessor] returns the senator's name as a string
     * @return returns the name as a string value
     */
    public String nameToString()
    {
        return this.name;
    }

    /**
     * [mutator] sets the senator's hall constituency
     */
    public void setConstituencyHall(int constituencyHallIdent)
    {
        // uses a set of if statements to check if the constituencyHallIdentity number is valid, and if so, sets the
        // senator's this.constituencyHall to either "Class senator only",
        //"Villa Maria Hall", "Mehling Hall", or "Corrado Hall"
        if ((constituencyHallIdent < 0) || (constituencyHallIdent >= 3))
        {
            this.constituencyHall = "Class senator only";
        }
        else if (constituencyHallIdent == Mehling)
        {
            this.constituencyHall = "Mehling Hall";
        }
        else if (constituencyHallIdent == Villa)
        {
            this.constituencyHall = "Villa Maria Hall";
        }
        else
        {
            this.constituencyHall = "Corrado Hall";
        }
    }

    /**
     * [Accessor] returns the senator's hall constituency as a string
     */
    public String hallToString()
    {
        return this.constituencyHall;
    }

    /**
     * [mutator] sets the senator's class constituency
     */
    public void setConstituencyClass(int constituencyClassIdent)
    {
        // uses a set of if statements to check if the constituency Class Identity number is valid, and if so, sets the
        // senator's this.constituencyClass to either "Hall senator only",
        //"Freshman", "Sophomore", "Junior" or "Senior"
        if ((constituencyClassIdent < 0) || (constituencyClassIdent >= 4))
        {
            this.constituencyClass = "Hall senator only";
        }
        else if (constituencyClassIdent == Freshman)
        {
            this.constituencyClass = "Freshmen";
        }
        else if (constituencyClassIdent == Sophomore)
        {
            this.constituencyClass = "Sophomores";
        }
        else if (constituencyClassIdent == Junior)
        {
            this.constituencyClass = "Juniors";
        }
        else
        {
            this.constituencyClass = "Seniors";
        }
    }

    /**
     * [Accessor] returns the senator's Class constituency as a string
     */
    public String classToString ()
    {
        return this.constituencyClass;
    }
    
    /**
     * [mutator] sets the senator's full constituency
     */
    public void setConstituencyFull()
    {
        this.constituency = ((this.constituencyClass) + (", ") + (this.constituencyHall) + ("."));
    }
    
    /**
     * [Accessor] returns the senator's full constituency, from representative of dorm and/or class senator
     */
    public String getConstituency ()
    {
        return constituency;
    }

    /**
     * [Mutator] returns true if the project affects a senator's constituency
     */
    public boolean checkProposal (String beneficiary1, String beneficiary2, boolean vote)
    {
        // checks to see if the Senator will vote for or deny a proposal, based upon the senator's constituency, and the beneficiary of the project
        if (beneficiary1.equals(constituencyClass) || beneficiary2.equals(constituencyHall) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * [mutator] increments voteTotal that the senator has approved
     * 
     * @return           The new vote total
     */
    public double incrementVoteTotal()
    {
        ++projectSuppCount;
        return projectSuppCount;
    }
}
