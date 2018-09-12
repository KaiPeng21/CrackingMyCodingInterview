// URLify: Write a method to replace all spaces in a string with '%2e: 
// You may assume that the string has sufficient space at the end to hold 
// the additional characters, and that you are given the "true" length of 
// the string. (Note: if implementing in Java, please use a character array 
// so that you can perform this operation in place.)

// EXAMPLE
// Input:  "Mr John Smith    ", 13 
// Output: "Mr%2eJohn%2eSmith"


public class P03_Urlify{
    public static void main(String[] args){

        String testInput = "Mr John Smith    ";
        int testTrueLength = 13;
        String exptected = "Mr%2eJohn%2eSmith";

        char[] test = testInput.toCharArray();

        System.out.println(test);

        urlify(test, 13);

        System.out.println(test);
        
    }

    public static void urlify(char[] word, int trueLength){
        
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++){
            if (word[i] == ' ') spaceCount++;
        }

        int j = trueLength + spaceCount * 2 - 1;

        for (int i = trueLength - 1; i >= 0; i--){
            if (word[i] != ' '){
                word[j] = word[i];
                j--;
            } else {
                word[j] = '0';
                word[j-1] = '2';
                word[j-2] = '%';
                j -= 3;
            }
        }

    }
}
