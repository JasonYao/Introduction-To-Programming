import java.util.*;

/**
 * Test ArrayList
 * 
 * @author kw 
 * @version April 2014
 */
public class TestArrayList
{
    
    public static void main(String[] args)
    {
      ArrayList<String> wordlist = new ArrayList<String>(); 
      // ArrayList<String> wordlist = new ArrayList<>(); // this works, also
      
      System.out.println("wordlist size is " + wordlist.size() + 
                         ", capacity is " + wordlist.toArray().length);
                       
      wordlist.add("elephant");
      wordlist.add("giraffe");
      wordlist.add("elephant");
      wordlist.add(1,"horse");

      System.out.println("wordlist = " + wordlist);
      

      
      System.out.println("remove elephant is " + wordlist.remove("elephant"));
      System.out.println("remove bird is "+ wordlist.remove("bird"));
      System.out.println("wordlist contains horse is " + wordlist.contains("horse"));
      System.out.println("wordlist contains bird is " + wordlist.contains("bird"));
      System.out.println("wordlist = " + wordlist);
      
      wordlist.set(2,"cat");
      
       System.out.println("wordlist size is " + wordlist.size() + 
                         ", capacity is " + wordlist.toArray().length);
      
      // print the contents of wordlist
      System.out.println("wordlist = " + wordlist);
        
    }
}

