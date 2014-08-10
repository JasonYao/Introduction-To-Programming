import java.util.ArrayList;
/**
 * Test ArrayList
 * 
 * @author kw 
 * @version April 2014
 */
public class Tester
{
  
    public static void main(String[] arg)
    {
        Integer myInt = new Integer(3);
        ArrayList<String> wordlist = new ArrayList<String>();
        ArrayList<Integer> intlist = new ArrayList<Integer>();
        // ArrayList<String> wordlist2 = new ArrayList<>();
        
        wordlist.add("elephant");
        wordlist.add("giraffe");
        wordlist.add("bunny rabbit");
        wordlist.add("giraffe");
        System.out.println("wordlist = " + wordlist);
        
        wordlist.set(1, "cat");
        System.out.println("wordlist after set(1..) = " + wordlist);
        wordlist.add(1, "lion");
        System.out.println("wordlistafter add(1..) = " + wordlist);
        System.out.println(" remove giraffe is " + 
                           wordlist.remove("giraffe"));
        System.out.println(" remove bird is " + 
                           wordlist.remove("bird"));
        System.out.println("wordlist = " + wordlist);
       
       
    }
}
