import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.text.DecimalFormat;
/**
 * Meeting simulates an ASUP vote for projects to be funded.
 * 
 * @author Karen Ward 
 * @author Jason Yao
 * @version Oct. 28, 2013
 * @version 25 Feb 2014 changed name of Senator class; 
 *                      altered simulation to provide places for testing project preferences
 *                      and custom attributes;
 *                      moved loops testing toString() earlier in simulation
 * @version 05 Mar 2014 finished filling in with student code
 */

public class Meeting
{
    public static final int BUDGET = 5100000; // Total $$ available for project funding, in pennies
    public static int totalProjects; // Total number of projects available
    public static final int initialVoteCast = 0; // Initializes the number of initial votes to 0

    /**
     * main method - test the Project and Senator classes
     */
    public static void main(String[] args) 
    {
        Project[] proposed = new Project[7];  // proposed projects (feel free to make more)
        Senator[] senator  = new Senator[19];   // the senators (feel free to make more)

        // Sets the total number of projects (used for calculating the project approval rate of senators)
        int totalProjects = proposed.length;

        // Create some new projects and store them in proposed array
        proposed[0] = new Project("Add bee blocker in villa", 900000, Project.capImprove, initialVoteCast, Senator.noBeneficiary, Senator.Villa);
        proposed[1] = new Project("Add senior lounge", 200000, Project.capImprove, initialVoteCast, Senator.Senior, Senator.noBeneficiary);
        proposed[2] = new Project("Fix Mehling elevators", 1300000, Project.capImprove, initialVoteCast, Senator.noBeneficiary, Senator.Mehling);
        proposed[3] = new Project("Add a soup kitchen for homeless at Corrado", 800000, Project.service, initialVoteCast, Senator.noBeneficiary, Senator.Corrado);
        proposed[4] = new Project("Give pizza to all Freshman", 200000, Project.social, initialVoteCast, Senator.Freshman, Senator.noBeneficiary);
        proposed[5] = new Project("Give PS4s to all Sophomores", 2000000, Project.social, initialVoteCast, Senator.Sophomore, Senator.noBeneficiary);
        proposed[6] = new Project("Start ice-cream thursdays for all Juniors", 1000000, Project.social, initialVoteCast, Senator.Junior, Senator.noBeneficiary);

        // Create some senators and store them in senators array
        senator[0] = new Senator("Bob", Senator.Corrado, Senator.Senior);
        senator[1] = new Senator("Marley", Senator.Villa, Senator.Junior);
        senator[2] = new Senator("Jane", Senator.Mehling, Senator.Freshman);
        senator[3] = new Senator("Joe", Senator.noBeneficiary, Senator.Freshman);
        senator[4] = new Senator("Nick", Senator.noBeneficiary, Senator.Sophomore);
        senator[5] = new Senator("Kevin", Senator.noBeneficiary, Senator.Junior);
        senator[6] = new Senator("Abby", Senator.noBeneficiary, Senator.Senior);
        senator[7] = new Senator("Bri", Senator.Mehling, Senator.noBeneficiary);
        senator[8] = new Senator("Sunbear", Senator.Villa, Senator.noBeneficiary);
        senator[9] = new Senator("Sam", Senator.Corrado, Senator.noBeneficiary);
        senator[10] = new Senator("Ella", Senator.Mehling, Senator.Sophomore);
        senator[11] = new Senator("Meghan", Senator.Mehling, Senator.Junior);
        senator[12] = new Senator("Shelby", Senator.Mehling, Senator.Senior);
        senator[13] = new Senator("John", Senator.Villa, Senator.Senior);
        senator[14] = new Senator("Jacob", Senator.Villa, Senator.Freshman);
        senator[15] = new Senator("Jason", Senator.Villa, Senator.Sophomore);
        //senator[16] = new Senator("Michael", Senator.Corrado, Senator.Junior); <-- got rid of this one to make final vote more uneven
        senator[16] = new Senator("Adina", Senator.Corrado, Senator.Freshman);
        senator[17] = new Senator("Alex", Senator.Corrado, Senator.Sophomore);

        // The Senators arrive and mingle before the before the meeting, 
        // discussing the proposed projects
        System.out.println("\nSenators arrive:");
        for (int s = 0; s < senator.length && senator[s] != null; ++s)
        {
            System.out.print("Senator " + senator[s].name); // tests setName() and getName() for Senator class
            System.out.println(", representing " + senator[s].constituency);
            // tests the whole bunch of constituency methods for Senator class
        }

        System.out.println();
        System.out.println("Projects are discussed:");
        for (int p = 0; p < proposed.length && proposed[p] != null; ++p)
        {
            System.out.print("Project ID Number: " + proposed[p].IDNum); // tests setIDNum() and getIDNum() for Project class
            System.out.println(": " + proposed[p].name); // tests setName() and getName() for Project class
        }

        // Uses an if statement to check if the senator will approve of a project, if checkProposal method returns true
        // then the senator's number of supported projects will increment, and the vote boolean will be changed to true.
        // Once the vote boolean is true, the meeting method will take

        // Some senators change their minds about the projects they will vote for
        // Add code here to test your methods to add or delete projects from the 
        // list of projects that a senator plans to vote for

        // Start the meeting
        System.out.println();
        System.out.print("The ASUP Senate will come to order. ");
        System.out.println("Secretary, please call the roll.");
        for (int s = 0; s < senator.length && senator[s] != null; ++s)
        {
            // code to print the Senator's name and constituency
            System.out.print (senator[s].name);
            System.out.println(" is present.");
        }

        System.out.println("Thank you. \n\nWe will now decide which projects to fund.");
        System.out.println("Total budget available: $" + BUDGET/100);
        System.out.println("Proposed projects are ");
        for (int p = 0; p < proposed.length && proposed[p] != null; ++p)
        {
            // code to print the project id, name, and cost, one project per line
            System.out.print("Project ID #: " + proposed[p].IDNum + ", ");
            System.out.print("Name: " + proposed[p].name + ", ");
            System.out.println("Estimated Cost: $" + proposed[p].costEstimate/100 + ".");
        }

        // Each senator votes
        System.out.println();
        // Iterates through each of the proposed projects, calling the checkProposal() method to see
        // if the senator will vote for that particular project
        for (int p = 0; p < proposed.length && proposed[p] != null; ++p)
        {
            // Initializes the vote to 0 first, increments whenever the senator's constituency matches beneficiaries
            int totalVotesYes = 0;
            int totalVotesNo = 0;
            String senatorVotes = "";

            // Iterates through the number of senators, having each one vote on whether they'd approve or not.
            for (int s = 0; s < senator.length && senator[s] != null; ++s)
            {
                // Does a check to see if the BUDGET is filled, if not, then calls checkProposal()
                if (senator[s].totalSpent < BUDGET)
                {
                    // Checks to see if the proposal vote is yes (true)

                    // Checks to see if the class beneficiary is the same as the senator's constituency
                    if (proposed[p].beneficiary1.equals(senator[s].constituencyClass))
                    {
                        // Increments the total votes for that project
                        ++totalVotesYes;

                        // Increments the total value the senator has voted for by the project's estimated cost
                        senator[s].totalSpent = senator[s].totalSpent + proposed[p].costEstimate;

                        // Increments the number of projects that the senator is supporting
                        senator[s].projectSuppCount = senator[s].projectSuppCount + 1;

                        // Strings together the senators that will vote for the project
                        senatorVotes = senatorVotes + (senator[s].name + ", ");
                    }
                    // Checks to see if the hall beneficiary is the same as the senator's constituency
                    else if (proposed[p].beneficiary2.equals(senator[s].constituencyHall))
                    {
                        // Increments the total votes for that project
                        ++totalVotesYes;

                        // Increments the total value the senator has voted for by the project's estimated cost
                        senator[s].totalSpent = senator[s].totalSpent + proposed[p].costEstimate;

                        // Increments the number of projects that the senator is supporting
                        senator[s].projectSuppCount = senator[s].projectSuppCount + 1;

                        // Strings together the senators that will vote for the project
                        senatorVotes = senatorVotes + (senator[s].name + ", ");
                    }
                    // Otherwise, votes no on the project
                    else
                    {
                        // Increments the total No votes for that project
                        ++totalVotesNo;
                    }
                }
                // Budget is gone, so the senator will vote no for the project
                else
                {
                    // Increments the total No votes for that project
                    ++totalVotesNo;
                } // Ends loop for the senator's voting
            } // Ends iteration of senator, moves onto next one until end

            // At this point, all senators have voted for a particular project, and the totalVotesYes and totalVotesNo has been calculated
            // Then the project's vote count will be initialized
            proposed[p].voteCast = totalVotesYes;

            // Outputs the votes for the project
            System.out.println("For PID: " + proposed[p].IDNum + ", Senators " + senatorVotes + "voted yes.");
        } // Ends iteration of projects, moves onto next one until end
        System.out.println("The projects have now been voted upon, thank you.");
        
        System.out.println();
        
        // Out puts each senator's project approval rating
        System.out.println("Based upon this meeting's project proposals, each senator's project approval rate is below:");
        for (int i = 0; i < senator.length && senator[i] != null; ++i)
        {
            double approvRating = ((senator[i].projectSuppCount)/totalProjects) * 100;
            
            DecimalFormat decimalRounding = new DecimalFormat("0.00");
            String approvRatingRounded = decimalRounding.format(approvRating);

            senator[i].projectApprovalRate = approvRatingRounded;
            System.out.println("Senator " + senator[i].name + ": " + senator[i].projectApprovalRate + "% Project Approval Rate");
        }

        // Report the vote
        System.out.println("\nThe final tally follows:");
        for (int p = 0; p < proposed.length && proposed[p] != null; ++p)
        {
            // Outputs the vote
            System.out.println("The final tally for Project ID: " + proposed[p].IDNum + " is "+ proposed[p].voteCast + ".");
        }

        // Amount of money spent for the voted upon projects
        int projectTotal = 0;
        // Uses the vote output, and selects the project(s) with the most votes. Subtracts from the Budget the cost of the project, until
        // the budget is used up. Any remainder will roll over to next year's budget
        for (int i = 0; i < proposed.length && proposed[i] != null && BUDGET - projectTotal - proposed[i].costEstimate > 0; ++i)
        {
            if ((proposed[i].voteCast == 5) && (BUDGET - projectTotal > 0))
            {
                projectTotal = projectTotal + proposed[i].costEstimate;
            }
        }

        for (int i = 0; i < proposed.length && proposed[i] != null && BUDGET - projectTotal - proposed[i].costEstimate > 0; ++i)
        {
            if ((proposed[i].voteCast == 4) && (BUDGET - projectTotal > 0))
            {
                projectTotal = projectTotal + proposed[i].costEstimate;
            }
        }

        for (int i = 0; i < proposed.length && proposed[i] != null && BUDGET - projectTotal - proposed[i].costEstimate > 0; ++i)
        {
            if ((proposed[i].voteCast == 3) && (BUDGET - projectTotal > 0))
            {
                projectTotal = projectTotal + proposed[i].costEstimate;
            }
        }
        
        System.out.println();
        
        int leftoverBudget = BUDGET - projectTotal; // The leftover budget, in pennies
        System.out.println("The total amount spent is: $" + projectTotal/100 + ".");
        System.out.println("The leftover budget is: $" + leftoverBudget/100 + ".");

        System.out.println();
        System.out.println("\nThank you, all. This meeting is adjourned!");
    }
}
