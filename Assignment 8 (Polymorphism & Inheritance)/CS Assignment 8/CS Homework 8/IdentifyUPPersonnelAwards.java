/**
 * Creates an array of UP Personnel objects, then calculates awards based upon certain criteria
 * @author Jason Yao
 * @version 08/04/14
 */
public class IdentifyUPPersonnelAwards
{
    // Constants

    // Full time status constants
    public static final boolean FULL_TIME_STATUS_TRUE = true;
    public static final boolean FULL_TIME_STATUS_FALSE = false;

    // Year constants
    public static final int FRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;

    // Tenure constants
    public static final boolean TENURE_TRUE = true;
    public static final boolean TENURE_FALSE = false;

    /**
     * Will create an array of UP personnel objects, go through those objects,
     * and identify which of them qualify for a series of awards based upon achievement
     */
    public static void main ( String[] args )
    {
        // Logic to create an array of UPPersonnel, with undergraduate, graduate, support and faculty objects
        UPPersonnel[] awardCandidate = new UPPersonnel[16];

        // Creates an array of undergraduates
        awardCandidate[0] = new Undergraduate("Jason", 6073652, FULL_TIME_STATUS_TRUE, 3.64, FRESHMAN, "Computer Science", 37);
        awardCandidate[1] = new Undergraduate("Hermione", 9273619, FULL_TIME_STATUS_TRUE, 3.96, SENIOR, "Computer Science", 130);
        awardCandidate[2] = new Undergraduate("Harry", 8123725, FULL_TIME_STATUS_TRUE, 3.22, SENIOR, "Defense Against the Dark Arts", 87);
        awardCandidate[3] = new Undergraduate("Ron", 7352825, FULL_TIME_STATUS_TRUE, 2.95, SENIOR, "Computer Science", 75);

        // Creates an array of graduate students
        awardCandidate[4] = new Graduate("John", 7352735, FULL_TIME_STATUS_TRUE, 3.8, SOPHOMORE, "Communications", 30);
        awardCandidate[5] = new Graduate("Christine", 7263082, FULL_TIME_STATUS_FALSE, 3.9, SENIOR, "Computer Science", 87);
        awardCandidate[6] = new Graduate("Jasper", 2637648, FULL_TIME_STATUS_FALSE, 3.1, SENIOR, "Computer Science", 79);
        awardCandidate[7] = new Graduate("Bob", 5293876, FULL_TIME_STATUS_TRUE, 2.8, FRESHMAN, "Communications", 13);

        // Creates an array of support staff
        awardCandidate[8] = new Support("Carmen", 8274625, 3000000, "Custodial");
        awardCandidate[9] = new Support("Arya", 8274625, 5950000, "Cafeteria");
        awardCandidate[10] = new Support("Eragon", 8274625, 5000000, "Physical Plant");
        awardCandidate[11] = new Support("Brom", 8274625, 6050000, "Cafeteria");

        // Creates an array of faculty staff
        awardCandidate[12] = new Faculty("Ward", 8273625, 12000000, TENURE_TRUE, 1);
        awardCandidate[13] = new Faculty("Nuxoll", 6374926, 12000000, TENURE_TRUE, 2);
        awardCandidate[14] = new Faculty("Severus", 7293746, 9000000, TENURE_FALSE, 4);
        awardCandidate[15] = new Faculty("Dumbledore", 7263528, 15000000, TENURE_TRUE, 3);

        // Testing everybody's toStrings
        //for (int i = 0; i < awardCandidate.length; ++i)
        //{
        //    System.out.println(awardCandidate[i].toString());
        //}

        // Some breaks in between the awards
        System.out.println();
        System.out.println();

        // Variables to identify the highest ranking student
        boolean changeGPA = true;
        double maxGPA = 0.00;
        int greatestGPAStudent = 0;

        // Variables to identify the highest ranking computer science student
        boolean changeCS = true;
        double maxCSGPA1 = 0.00;
        double maxCSGPA2 = 0.00;
        int greatestCompSciStudent[] = new int[2];

        // Variables to identify the highest ranking faculty member
        boolean changeFaculty = true;
        int minRanking = 100;
        int greatestFacultyMember = 0;

        // Logic to iterate through those objects, and award an award to the highest GPA undergraduate student
        for (int i = 0; i < awardCandidate.length; ++i)
        {
            // Filters by if it "is a" student with the "instance of" usage, and then checks to see what the highest GPA
            if (awardCandidate[i] instanceof Student)
            {
                // Filters by the greatest GPA
                if (changeGPA == true)
                {
                    changeGPA = false;
                    Student studentBunch = (Student) awardCandidate[i];
                    if (studentBunch.getGPA() >= maxGPA)
                    {
                        maxGPA = studentBunch.getGPA();
                        changeGPA = true;
                        greatestGPAStudent = i;
                    }
                }

                // Filters by computer science people
                if (changeCS == true)
                {
                    changeCS = false;

                    Student studentBunch = (Student) awardCandidate[i];
                    if (studentBunch.getDegree().equals("Computer Science"))
                    {
                        // At this point, only computer science people are in
                        if ((studentBunch.getGPA() >= maxCSGPA1) || (studentBunch.getGPA() >= maxCSGPA2))
                        {
                            changeCS = true;

                            // At this point, this student has a higher GPA than atleast one of the others
                            if (studentBunch.getGPA() >= maxCSGPA1)
                            {
                                greatestCompSciStudent[0] = i;
                            }
                            else if (studentBunch.getGPA() >= maxCSGPA2)
                            {
                                greatestCompSciStudent[1] = i;
                            }
                        }
                    }
                }
            }
            else if (awardCandidate[i] instanceof Faculty)
            {

                // Filters by faculty ranking
                if (changeFaculty == true)
                {
                    changeFaculty = false;
                    Faculty facultyBunch = (Faculty) awardCandidate[i];
                    if (facultyBunch.getRanking() <= minRanking)
                    {
                        minRanking = facultyBunch.getRanking();
                        changeFaculty = true;
                        greatestFacultyMember = i;
                    }
                }
            }
        }

        // At this point, the program has run its course looking through each of the objects,
        // and found the student with the highest GPA, with the array index being crowdNumber.

        // The Dean's award intro:
        System.out.println("Welcome to the annual Dean's Award, brought to you by Bertie Bott's Every Flavour Beans™!");
        System.out.println("Annnnd this year's student Dean award goes to...");
        for (int j = 0; j < 2; ++j)
        {
            System.out.println("...");
        }

        // Displays the winner
        System.out.println(awardCandidate[greatestGPAStudent].getName() + ", congratulations!");

        // Some breaks in between the awards
        System.out.println();
        System.out.println();

        // CS award into:
        System.out.println("Welcome to the annual CS Student Award, brought to you by Bertie Bott's Every Flavour Beans™!");
        System.out.println("Annnnd this year's student CS Award goes to...");

        for (int k = 0; k < 2; ++k)
        {
            System.out.println("...");
        }

        // Logic to iterate through those objects, and award a CS award to the highest GPA CS graduate student
        // Check to see if the student has already recieved the dean's award, if so, goes onto the next person
        if (greatestGPAStudent == greatestCompSciStudent[0])
        {
            // Returns the second person
            System.out.println(awardCandidate[greatestCompSciStudent[1]].getName() + ", congratulations!");
        }
        else
        {
            // Returns the first person
            System.out.println(awardCandidate[greatestCompSciStudent[0]].getName() + ", congratulations!");
        }

        // Some breaks in between the awards
        System.out.println();
        System.out.println();

        // Logic to iterate through those objects, and award a faculty award to the highest ranking faculty member

        System.out.println("Welcome to the annual Faculty Award, brought to you by Bertie Bott's Every Flavour Beans™!");
        System.out.println("Annnnd this year's Faculty Award goes to...");

        for (int k = 0; k < 2; ++k)
        {
            System.out.println("...");
        }

        System.out.println("Doctor "+ awardCandidate[greatestFacultyMember].getName() + ", congratulations!");

    }
}


