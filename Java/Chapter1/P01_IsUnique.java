/*
    Is Unique: 
    Implement an algorithm to determine if a string has all unique characters. 
    What if you cannot use additional data structures?
*/

public class P01_IsUnique{
    public static void main(String[] args){
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(String.format("%s %b", word, isUnique(word)));
        }
        
        for (String word : words) {
			System.out.println(String.format("%s %b", word, isUniqueNoDataStructure(word)));
        }
        
    }

    // Assumption:
    // All characters are ASCII decoded.
    // There must be no more than 128 characters

    public static boolean isUnique(String input){
        
        if (input.length() > 128){
            return false;
        }

        boolean[] setvector = new boolean[128];
        
        for (Character chr : input.toCharArray()){
            if (setvector[chr]){
                return false;
            }
            setvector[chr] = true;
        }

        return true;
    }

    // Additional Assumption:
    // only uses lower case letters from a to z
    public static boolean isUniqueNoDataStructure(String input){
        
        int bitvector = 0;

        for (Character chr : input.toCharArray()){

            int index = chr - 'a';

            if ((bitvector & (1 << index)) > 0){
                return false;
            }
            bitvector |= (1 << index);
        }

        return true;
    }
}