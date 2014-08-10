// import-list
import java.text.*;
import java.util.*;
/**
 * Prints fortune and lucky number, given input by user
 * 
 * @author Jason Yao
 * @date 19 January 2014
 * @version 1.0 rev
 * ---------------------------
 * CS203 Computer Science C
 * ---------------------------
 * *****************************
 * Last updated in Spring 2008
 * *****************************
 */
public class Fortune
{   
    /**
     * This is the main method for this program.  It prompts the user and
     * then prints the fortune.
     * @param  args command-line arguments
     */
    public static void main(String[] args)
    {
        
        // define the keyboard object
        Scanner keyboard = new Scanner(System.in);
        
        /////////////////////////////////////////////////////
        // !!!!!! YOUR MODIFICATIONS SHOULD START HERE !!!!!
        /**
         * Introduction to the program,
         * Uses the Scaner to get user input, then saves that input into a string.
         **/
        System.out.print("Hello there! I am the great Java Fortune Teller- \nTell me, what is your name?");
        String name = keyboard.nextLine();
        System.out.print("Hi ");
        System.out.print(name);
        System.out.println("!");
        
        // Uses Scanner to get user's age input, then saves that input into an integer variable
        System.out.println("In order for me to calculate your fortunes, I'll need more information!");
        System.out.print("So tell me, how old are you?");
        int age =  keyboard.nextInt();
        
        /**
         * Utilizes while statement to make sure that the age given is less than the current oldest living person
         * Loops forever if the user keeps putting in input that is obviously not true
         * Special thanks to Dr.Nuxoll for helping me with understanding these while loops!
         */
        while (age > 123)
        {
            System.out.print("Psh, as if, you old fart- now how old are you, really?");
            age =  keyboard.nextInt();
        }   
        while (age < 0)
        {
            System.out.print("Psh, as if you were born in the future- now how old are you, really?");
            age =  keyboard.nextInt();
        }
        System.out.println("Thanks for that!");
        
        // Uses Scanner to get user's GPA input, then saves input into a double variable
        System.out.println("I'll still need just a bit more information to get your accurate fortune!");
        System.out.print("What is your current GPA?");
        double gpa =  keyboard.nextDouble();
        
        // Uses the while statements in order to catch if somebody was trying to input improper GPA numbers
        while (gpa <= 0)
        {
            System.out.println("Now, I knew you were a bit slow from the looks of you, but that's just amazing!");
            System.out.print("Now seriously, put in your actual GPA this time.");
            gpa = keyboard.nextDouble();
        }
        while (gpa > 4)
        {
            System.out.println("Now, I know you think you're so smart, trying to trick me.");
            System.out.print("But seriously, put in your actual GPA this time.");
            gpa = keyboard.nextDouble();
        }
        System.out.println("Thanks for letting me know!");
        
        // Uses Scanner to get user's favorite games that they like to play, then saves as a string
        System.out.print("Now onto something more fun- what are two of your favorite games to play?");
        keyboard.nextLine();
        String favGames = keyboard.nextLine();
        System.out.print("Oh, cool! I love playing ");
        System.out.print(favGames);
        System.out.println(" as well!");
        
        // Uses Scanner to get user's oldest living relative, and saving that information as a byte
        System.out.print("Just out of curiosity, how old is your oldest living relative?");
        byte relAge = keyboard.nextByte();
        System.out.print("Wow, that's amazing that your relative is ");
        System.out.print(relAge);
        System.out.println(" years old!");
        
        // Uses Scanner to know how many video games use plays, and stores as an integer
        System.out.print("How many video games do you play? (if you don't play any, just type in 0)");
        int gamer = keyboard.nextInt();
        
        // Uses the while statement in order to catch negative/an overload of video games played
        while (gamer < 0)
        {
            System.out.println("Mm, I too like to play negative games.");
            System.out.println("It's fantastically fun to laugh at you, for example");
            System.out.print("Now be a good human and put in an actual number of games you like to play.");
            gamer = keyboard.nextInt();
        }
        while (gamer >= 100)
        {
            System.out.println("Now, I like to play games just as much as the other guys,");
            System.out.print("but there's no way in hell that you're playing ");
            System.out.print(gamer);
            System.out.println(" games actively. \nYou'd go crazy from staring at a screen for so long.");
            System.out.println("Similar to my programmer right now.");
            System.out.print("Now tell me truthfully this time, how many games do you play?");
            gamer = keyboard.nextInt();
        }
        
        // Uses an if/else statement in order to comment on the user playing/ not playing games
        if (gamer >= 1)
        {
            System.out.println("Nice to know that you play video games as well!");
        }
        else if (gamer == 0)
        {
            System.out.println("Good to know that you're not wasting your time on that stuff!");
        }

        // Uses Scanner to know how much the user makes in a year, stores as a float
        System.out.print("Now, totally not because I want to scam you, \nbut how much money do you make in a year?");
        float monies = keyboard.nextFloat();
        
        // Uses a while statement in order to catch if somebody puts in a negative number
        while (monies < 0)
        {
            System.out.println("Wow, I didn't realize debt collectors were so aggresive,");
            System.out.println("to the point that they took money from those without it.");
            System.out.print("But seriously, I want to scam you, so how much do you make?");
            monies = keyboard.nextFloat();
        }
        System.out.print("Wow, $");
        System.out.print(monies);
        System.out.println(" is a lot of money! (for me to scam)");

        // Uses Scanner to figure out which career the user would like to have, stores as a string
        System.out.print("As a theoretical question, if you could go into any career (and be successful), \nwhich would it be?");
        keyboard.nextLine();
        String career = keyboard.nextLine();
        System.out.print("Now that's a cool career to get into, ");
        System.out.print(career);
        System.out.println("!");
        
        // Uses previous numerical inputs to compute a "Lucky" number
        System.out.println("I've gathered enough information to now calculate your lucky number!");
        int luckynum;
            luckynum = (int)(monies/(relAge+(age-gamer))*gpa+0.5); // The +0.5 is to round the subtotal, instead of truncating
        int finalnum = Math.abs(luckynum);
        System.out.println("and your lucky number is...");
        System.out.println("...");
        System.out.println("...");
        System.out.print(finalnum);
        System.out.println("!");
        
        // Uses previous string inputs to compute a customized fortune (incorporates name)
        System.out.print("I've got enough information to show your fortune as well, ");
        System.out.print(name);
        System.out.println("!");
        
        // Uses previous string inputs to compute a customized fortune (incorporates age & favgame)
        System.out.print("Your fortune: as an ");
        System.out.print(age);
        System.out.println(" year old,");
        System.out.println("you will go through your years in the future wandering, learning and growing.");
        System.out.println("You will always strive to better yourself and those around you,");
        System.out.print("while taking the time occasionally for yourself to play ");
        System.out.print(favGames);
        System.out.println(",");
        System.out.println("which you'll always have a special place in your heart for.");
        
        // Uses previous string inputs to compute a customized fortune (incorporates career & relage)
        int finAge = relAge + 20;
        System.out.print("With a successful career in ");
        System.out.print(career);
        System.out.println(",");
        System.out.println("you will be famous for your contributions to society,");
        System.out.print("and will live to at least ");
        System.out.print(finAge);
        System.out.println("!");
        
        // Thanks the user for using the Java Fortune Teller!
        System.out.println("This has been so much fun!");
        System.out.print("Thank you so much for playing the Fortune Teller program, ");
        System.out.print(name);
        System.out.println("!");
        System.out.println("Hope you have a good day!");
        
        // !!!!!! YOUR MODIFICATIONS SHOULD END HERE !!!!!
        /////////////////////////////////////////////////////
    }
}
