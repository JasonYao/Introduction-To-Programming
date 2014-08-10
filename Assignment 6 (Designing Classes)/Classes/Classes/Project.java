import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
/**
 * Project creates Project objects, that are sent to the ASUP meeting and voted upon.
 * @author Jason Yao
 * @version 06 Mar 2014 finished filling in with student code
 */
public class Project
{
    // instance variables, attributes that are a part of a Project object
    public String name; // (public) the name of the project
    public int costEstimate; // (public) the estimated cost of the project (units are in pennies)
    private int projectCategoryIdent; // (private) the project category identifier number
    public int IDNum = 100; // (public) the project's identifier number, start at 100, and increment upwards per project
    private static int IDNumInstance = 100; // (private) the count of the Identification numbers in total
    public int voteCast = 0; // (public) the number of votes cast for the project
    private String projectCategory; // (private) the project's category in string form

    // Beneficiary identification
    public String beneficiary1; // (public) the project's beneficiaries, corresponding with the senator's Class constituency
    public String beneficiary2; // (public) the project's beneficiaries, corresponding with the senator's Hall constituency

    // Establishes the Project Category constants
    public static final int capImprove = 0; // (public) projects that improve something pe
    public static final int service = 1;
    public static final int social = 2;

    /**
     * Constructor for objects of class Project
     * @param  name                   the name
     * @param  costEstimate           the estimated cost for the project (units: pennies)
     * @param  projectCategoryIdent   the identifier number for the type of project it falls under
     * @param  totalProjects          the number of total projects up for vote
     * @param  voteCast               the number of votes cast for the project
     */
    public Project(String name, int costEstimate, int projectCategoryIdent, int voteCast, int beneficiary1, int beneficiary2)
    {
        // Initializes values for the project object

        // Initializes the name of the object
        // uses the setName() method, with the param: name, in order to have the name trimmed,
        // then initialized for that object
        setName(name);

        //uses the getName() method, with no param, in order to return the name of the project
        getName();

        // Initializes the estimated cost of the object
        // uses the setCost() method, with the param: costEstimate, in order to initialize the object's estimated cost
        setCost(costEstimate);

        // uses the getCost() method, with no param, in order to return the cost of the project
        getCost();

        // Initializes the project's category identifier code
        // uses the setCatIdent() method, with the param: projectCategoryIdent, in order to initialize the object's
        // category identifier code
        setCatIdent(projectCategoryIdent);

        // uses the getCatIdent() method, with no param, in order to return the category identifier
        getCatIdent();

        // Initializes the ID number of the object
        // uses the setIDNum() method, with param: totalProjects, in order to initialize the object's
        // project ID number to a value that begins at 100, and increments by 1 for every project (totalProject)
        setIDNum();
        // use an if statement to help with the incrementation, have it so that if (IDNum < 100 + totalProject), then
        // IDNum = IDNum + 1;, else use a comment to do nothing

        // uses the getIDNum() method, with no param, in order to return the object's project identification number
        getIDNum();

        // Initializes the number of votes cast for that project
        // uses the setVoteCast() method, with the param: voteCast, in order to initialize the number of votes for the
        // project object
        setVoteCast(voteCast);

        // uses the getVoteCast() method, with no param, in order to return the number of votes the object has garnered
        // from the senators that are voting
        getVoteCast();

        setBeneficiary1 (beneficiary1);
        getBeneficiary1 ();

        setBeneficiary2 (beneficiary2);
        getBeneficiary2 ();
    }

    // Methods to set and get the name of the object
    /**
     * [mutator] sets the name of the project
     * @param  name   the name that's sent in from the Meeting method
     */
    public void setName (String name)
    {
        // Sets a string to trim the name input, and then sets this.name to the trimmed string
        String trimmed = name.trim();
        this.name = trimmed;
    }

    /**
     * [Accessor] gets the name of the project
     */
    public String getName ()
    {
        return this.name;
    }

    // Methods to set and get the estimated cost of the object (cost is in pennies)
    /**
     * [mutator] sets the estimated cost of the project
     * @param  costEstimate   the estimated cost that's sent in from the Meeting method (note that the units is in pennies)
     */
    public void setCost (int costEstimate)
    {
        this.costEstimate = costEstimate;
    }

    /**
     * [Accessor] gets the estimated cost of the project
     */
    public int getCost ()
    {
        return this.costEstimate;
    }

    // Methods to set and get the object's categorical identification number
    /**
     * [mutator] sets the category of the project
     * @param  projectCategoryIdent  the project identity number that's sent in from the Meeting method
     */
    public void setCatIdent (int projectCategoryIdent)
    {
        // Uses an if statement to check if the ID number is valid. Use the boolean: projectCategoryIdent < 3
        // && projectCategoryIdent >= 0
        if (projectCategoryIdent == capImprove)
        {
            String m = "Capital Improvement";
            this.projectCategory = m;
        }
        else if (projectCategoryIdent == service)
        {
            String n = "service";
            this.projectCategory = n;
        }
        else if (projectCategoryIdent == social)
        {
            String b = "Social";
            this.projectCategory = b;
        }
        else
        {
            String q = "Other Project Category Identification code";
            this.projectCategory = q;
        }
    }

    /**
     * [Accessor] gets the category of the project
     */
    public String getCatIdent ()
    {
        // returns this.projectCategory, as the identification number has now been parsed into a string that can
        // be formatted as an output.
        return this.projectCategory;
    }

    // Methods to set and get the project's identification number
    /**
     * [mutator] sets the ID number of the project
     * @param  IDNum   the identification number that's based off of the number of IDs in place
     */
    public void setIDNum ()
    {
        // Initializes the project ID number of the object
        ++IDNumInstance;
        IDNum = IDNumInstance;
    }

    /**
     * [Accessor] gets the project identification number of the project
     */
    public int getIDNum ()
    {
        return this.IDNum;
    }

    // Methods to set and get the number of votes cast for the project
    /**
     * [mutator] sets the number of votes cast for the project
     * @param  voteCast   the amount of votes that's sent in from the Meeting method
     */
    public void setVoteCast (int voteCast)
    {
        this.voteCast = voteCast;
    }

    /**
     * [Accessor] gets the number of votes for the project
     */
    public int getVoteCast ()
    {
        return this.voteCast;
    }

    // Methods to set and get the project's benficiaries 1
    /**
     * [mutator] sets the beneficiary's based upon the identification
     * @param  beneficiary1   the Class (if any) of the proposal's beneficiaries
     */
    public void setBeneficiary1 (int beneficiary1)
    {
        // uses an if statement with a boolean of beneficiary1 == Freshman
        if (beneficiary1 == Senator.Freshman)
        {
            this.beneficiary1 = "Freshmen";
        }
        else if (beneficiary1 == Senator.Sophomore)
        {
            this.beneficiary1 = "Sophomores";
        }
        else if (beneficiary1 == Senator.Junior)
        {
            this.beneficiary1 = "Juniors";
        }
        else if (beneficiary1 == Senator.Senior)
        {
            this.beneficiary1 = "Seniors";
        }
        else
        {
            this.beneficiary1 = "No Class beneficiary";
        }
    }

    /**
     * [Accessor] gets the beneficiary's based upon the identification
     */
    public String getBeneficiary1 ()
    {
        return this.beneficiary1;
    }

    // Methods to set and get the project's benficiaries 2
    /**
     * [mutator] sets the beneficiary's based upon the identification
     * @param  beneficiary2   the Hall (if any) of the proposal's beneficiaries
     */
    public void setBeneficiary2 (int beneficiary2)
    {
        // uses an if statement with a boolean of beneficiary2 == Mehling
        if (beneficiary2 == Senator.Mehling)
        {
            this.beneficiary2 = "Mehling Hall";
        }
        else if (beneficiary2 == Senator.Villa)
        {
            this.beneficiary2 = "Villa Maria Hall";
        }
        else if (beneficiary2 == Senator.Corrado)
        {
            this.beneficiary2 = "Corrado Hall";
        }
        else
        {
            this.beneficiary2 = "No Hall beneficiaries";
        }
    }

    /**
     * [Accessor] gets the number of votes for the project
     */
    public String getBeneficiary2 ()
    {
        return this.beneficiary2;
    }
}
