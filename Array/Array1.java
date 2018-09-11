import java.util.*;

///
/// Is Unique: Implement an algorithm to determine if a string 
/// has all unique characters. What if you cannot use additional 
/// data structures?
///

public class Array1{
    public static void main(String[] args){
        boolean test1 = isUnique("abcde");
        boolean test2 = isUnique("abbde");
        boolean sol1 = isUniqueSolution("abcde");
        boolean sol2 = isUniqueSolution("abbde");

        System.out.println(String.format("Mine: %b %b", test1, test2));
        System.out.println(String.format("Sol : %b %b", sol1, sol2));
    }

    // my implementation
    public static boolean isUnique(String input){
        
        long myset = 0;

        for (Character c : input.toCharArray()){
            int hash = (int) c;
            if ((myset & (1 << hash)) != 0){
                return false;
            }
            myset |= (1 << hash);
        }

        return true;
    }

    // solution
    // Assume the input string is ascii decoded.
    // If it is a Unicode String, we would need to increase the storage size.
    public static boolean isUniqueSolution(String input){
        if (input.length() > 128){
            return false;
        }

        boolean[] char_set = new boolean[128];

        for (int i = 0; i < input.length(); i++){
            int val = input.charAt(i);
            if (char_set[val]){
                return false;
            }
            char_set[val] = true;
        }

        return true;
    }
}