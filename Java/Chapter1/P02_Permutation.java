
// Check Permutation: 
// Given two strings, write a method to decide 
// if one is a permutation of the other.

public class P02_Permutation{
    public static void main(String[] args){

        String[][] tests = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}, {"banana", "banan"}};

        for (String[] test : tests){
            System.out.println(String.format("%s %s - %b", test[0], test[1], arePermutation(test[0], test[1])));
        }

    }

    public static boolean arePermutation(String strA, String strB){
        if (strA.length() != strB.length()){
            return false;
        }

        int[] histagram = new int[128];
        
        for (Character chr : strA.toCharArray()){
            histagram[chr] += 1;
        }

        for (Character chr : strB.toCharArray()){
            histagram[chr] -= 1;
            if (histagram[chr] < 0){
                return false;
            }
        }

        return true;
    }
}