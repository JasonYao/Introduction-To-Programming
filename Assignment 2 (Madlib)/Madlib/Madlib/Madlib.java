import java.util.*;
/**
 * A class for producing a Mad Lib: the user supplies
 * words or phrases that become part of a story
 * 
 * @author Jason Yao
 * 
 * @version 27/14/01
 * ------------------------------
 * last updated:  Spring 2014
 * ------------------------------ 
 */
public class Madlib {
    public static void main(String[] args) {
        // !!! Start your modifications here
        
        // Sets up the keyboard object for user input
        Scanner keyboard = new Scanner(System.in);
        
        // Displays a welcome message to the user
        System.out.println("Hello there! Welcome to the wonderful world of Madlibs!");
        System.out.println("This Java project will make a story");
        System.out.println("based on the words that you enter here!");
        
        // Asks the user for their *name*
        System.out.println("Before we get started, though, could you please tell me your full name?");
        String nameOriginal = keyboard.nextLine();
        String nameTrimmed = nameOriginal.trim(); // Trims user input
        String nameLower = nameTrimmed.toLowerCase();
        int nameSpace = nameLower.lastIndexOf(" ");
        int nameLength = nameLower.length();
        
        // Uses an if statement to see if the user input full name or not, and capitalizes the first letter
        if (nameSpace == -1)
        {
            // Grabs name and capitalizes for 1 word names
            String charOne = nameLower.substring(0, 1);
            String oneRest = nameLower.substring(1, nameLength);
            String charOneCap = charOne.toUpperCase();
            String oneName = charOneCap + oneRest;
            
            // Asks for *Favourite Colour*
            System.out.print("Hi there ");
            System.out.print(oneName);
            System.out.println("! Could you please let me know what your favourite colour is?");
        }

        // Takes the first name and capitalizes the first letter
        String firstNameLower = nameLower.substring(0, nameSpace);
        String nameFirstChar = firstNameLower.substring(0,1);
        String firstRest = firstNameLower.substring(1, nameSpace);
        String nameFirstCharCap = nameFirstChar.toUpperCase();
        String word1Cap = nameFirstCharCap + firstRest;
            
        //Takes the last name and capitalizes the first letter
        String secondNameLower = nameLower.substring(nameSpace + 1, nameLength);
        String nameSecondChar = secondNameLower.substring(0,1);
        int lengthSecond = nameLength - (nameSpace + 1);
        String secondRest = secondNameLower.substring(1, lengthSecond);
        String nameSecondCharCap = nameSecondChar.toUpperCase();
        String word2Cap = nameSecondCharCap + secondRest;
            
        // Adds up the first and last names together
        String nameCap = word1Cap + " " + word2Cap;
            
        // Asks for *Favourite Colour*
        System.out.print("Hi there ");
        System.out.print(nameCap);
        System.out.println("! Could you please let me know what your favourite colour is?");

        
        String favColourOriginal = keyboard.nextLine();
        String favColourTrimmed = favColourOriginal.trim(); // Trims user input
        String favColourLower = favColourTrimmed.toLowerCase();
        
        System.out.print("Wonderful, ");
        System.out.print(favColourLower);
        System.out.println(" is a great colour!");
        
        // Converts the favourite colour into l33t speak, and changes up to 6 characters
        String l33t1 = favColourLower.replace("a", "@");
        String l33t2 = l33t1.replace("a", "4");
        String l33t3 = l33t2.replace("e", "3");
        String l33t4 = l33t3.replace("o", "0");
        String l33t5 = l33t4.replace("w", "VV");
        String l33t6 = l33t5.replace("i", "1");
        String l33t7 = l33t6.replace("s", "$");
        
        // Asks for *Adjective describing themselves*
        System.out.println("What about you, though? What is a good adjective to describe yourself with?");
        
        String descAdjOriginal = keyboard.nextLine();
        String descAdjTrimmed = descAdjOriginal.trim(); // Trims user input
        String descAdjLower = descAdjTrimmed.toLowerCase();
        
        System.out.print("Yes, I can see how you are very " + descAdjLower);
        System.out.println("!");
        
        // Asks for *Favourite role model (First and Last name please!)
        System.out.println("Who was your favourite role model while growing up? (first and last names, please!)");
        
        String favRoleOriginal = keyboard.nextLine();
        String favRoleTrimmed = favRoleOriginal.trim(); // Trims user input
        String favRoleLower = favRoleTrimmed.toLowerCase();
        int space = favRoleLower.lastIndexOf(" ");
        int length = favRoleLower.length();
        
        // Takes the first name and only capitalizes the first letter
        String firstRoleNameLower = favRoleLower.substring(0, space);
        String first = firstRoleNameLower.substring(0,1);
        String rest = firstRoleNameLower.substring(1, space);
        String firstCap = first.toUpperCase();
        String firstWordCap = firstCap + rest;
        
        // Takes the last name and only capitalizes the first letter
        String secondRoleNameLower = favRoleLower.substring(space + 1, length);
        String second = secondRoleNameLower.substring(0,1);
        int length2 = length - (space + 1);
        String rest2 = secondRoleNameLower.substring(1, length2);
        String secondCap = second.toUpperCase();
        String secondWordCap = secondCap + rest2;
        
        // Displays the final string of the role model's name
        String roleModelCap = firstWordCap + " " + secondWordCap;
        
        System.out.print("Ahh, I've heard of ");
        System.out.print(roleModelCap);
        System.out.println("! A very good choice!");
        
        // Asks for *Favourite drink to get at starbucks*
        System.out.println("Now then, can you tell me what your favorite drink to get from Starbucks is?");
        
        String favDrinkOriginal = keyboard.nextLine();
        String favDrinkTrimmed = favDrinkOriginal.trim();
        String favDrinkLower = favDrinkTrimmed.toLowerCase();
        int favDrinkInt = favDrinkLower.length();
        
        System.out.print("Ahh, ");
        System.out.print(favDrinkLower);
        System.out.println(" sounds wonderful this time of the year!");
        
        // Asks for *verb ending in -ing*
        System.out.println("Can you tell me a verb ending with '-ing', such as running or skipping?");
        
        String verbOriginal = keyboard.nextLine();
        String verbTrimmed = verbOriginal.trim();
        
        // Adds a hyphen approximately halfway
        int verbLength = verbTrimmed.length();
        double verbLengthDouble = (double) verbLength;
        double verbHalfDouble = (verbLength+0.5)/2;
        int verbHalf = (int) verbHalfDouble;
        String verbHyphen = verbTrimmed.substring (0 , verbHalf) + "-" + verbTrimmed.substring(verbHalf , verbLength);
        
        System.out.println("Thanks for that!");
        
        // Asks for a funny sound
        System.out.println("Now then, if you could be so kind as to type in a noise, such as ftttzzz");
        String noise = keyboard.nextLine();
        String noiseTrimmed = noise.trim();
        String noiseCaps = noiseTrimmed.toUpperCase();
        
        // Asks for a 2 word phrase
        System.out.println("I'm just going to need a  bit more information, then we can get to the Madlibs!");
        System.out.println("Please type in a two word phrase, such as green eggs.");
        String multiPass = keyboard.nextLine();
        String multiPassTrimmed = multiPass.trim();
        int multiSpace = multiPassTrimmed.indexOf(" ");
        int multiLength = multiPassTrimmed.length();
        String multiWord1 = multiPassTrimmed.substring(0, multiSpace);
        String multiWord2 = multiPassTrimmed.substring(multiSpace + 1, multiLength);
        String multiReverse = multiWord2 + " " + multiWord1;
        
        System.out.println("Thanks for that! And as promised, finally onto the Madlib!");
        System.out.println();
        
        /*
         * The Mablib, story by Jason Yao and Brianna Weeks, on a very, very strange skype call
         */
        System.out.println("The Pirate Rum Disco");
        System.out.println();
        
        //First Paragraph
        System.out.println("       Once upon a time, the great pirate Captain " + nameCap + " and crewmembers like");
        System.out.println("First Mate " + noiseCaps + " were forced ashore by a " + descAdjLower + " storm.");
        System.out.println("They were bored on land as the only thing for them to do was to drink " + favDrinkLower + ",");
        System.out.println("which incidentally has " + favDrinkInt + " characters in it!");
        System.out.println("This didn't sound too appealing for the rest of their lives,");
        System.out.println("and so it wasn't long before Captain " + word2Cap + " noticed that the crew wasn't the only marooned group of");
        System.out.println("pirates on this island, so the Captain started to plot and plan and scheme and scream to come up with an idea.");
        System.out.println("Captain " + word2Cap + " was going to organize the first ever Pirate Rum Disco!");
        System.out.println();
        System.out.println("       In only a few short hours, the pirates decided to go with " + favColourLower + " as their colour choice,");
        System.out.println("while some made sure to correct the others and call it " + l33t7 + ".");
        System.out.println("All the pirates boogied into the night using dance moves not seen since " + multiReverse + " was around.");
        System.out.println("Eventually, the party got so big that even " + roleModelCap + " decided to show up, crashing the pirate party.");
        System.out.println("By the stirrings of the morning, deckhand " + verbHyphen + " realized he had married a goat,");
        System.out.println("and the other pirates woke up with headaches that made them wince and blink,");
        System.out.println("all the while thinking of when the next Pirate Rum Disco would be.");
        System.out.println();
        System.out.println("The End.");
        
        // !!! End your modifications here
        
    }
}
