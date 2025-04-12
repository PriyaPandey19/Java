import java.util.*;

public class Strings{
    public static void printLetters(String str){   //to print each letter of the string in a new line
        for(int i =0;i<str.length();i++){
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String str){  //to check if the string is palindrome or not
        for(int i =0;i<str.length()/2;i++){
          int n = str.length();
          if(str.charAt(i) != str.charAt(n-1-i)) {
            //not a palindrome
            return false;
          }
        }
        return true;
    }

    public static float getShortestPath(String path) {        //shortest path
        int x =0,y=0;

        for(int i =0;i<path.length();i++){
            char dir = path.charAt(i);
            //south
            if(dir == 'S') {
                y--;
            }
            else if(dir == 'N'){
                y++;
            }
            else if(dir == 'W'){
                x--;
            }
            else{
                x++;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2 +Y2);
    }


        public static String subString(String str,int si,int ei){          //substring 
         String subString = "";
         for(int i = si;i<ei;i++){
            subString += str.charAt(i);
         }
         return subString;
        }


        public static void PrintLargestString(String fruits[]){     //to print largest string in the array
      String Largest = fruits[0];
      for(int i =1;i<fruits.length;i++){
        if(Largest.compareTo(fruits[i])<0){
            Largest = fruits[i];
        }
    }
    System.out.println(Largest);
    }


    public static String toUpperCase(String str){          //to convert first letter of each word to upper case
        StringBuilder sb = new StringBuilder("");
        
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == ' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str){              //to compress the string
        String newStr ="";

       for(int i=0;i<str.length();i++){
        Integer count =1;
        while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
            count++;
            i++;
        }
        newStr += str.charAt(i);
        if(count > 1){
            newStr += count.toString();
        }
        
           }
           return newStr;
    }

public static int countVowel(String str){         //to count the number of vowels in a string
    int count =0;
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
     if(ch =='a'|| ch =='e' || ch =='i' || ch =='o' || ch == 'u'){
        count++;
     }
    }
    return count;
}  

public static boolean checkAnagram(String s1,String s2){   //to check if two strings are anagrams of each other
    if(s1.length() != s2.length()){
        return false;
    }
    char ch1[] = s1.toCharArray();
    Arrays.sort(ch1);

    char ch2[] = s2.toCharArray();
    Arrays.sort(ch2);

    return Arrays.equals(ch1, ch2);

}


    public static void main(String args[]){
        // String str ="aaabbcccdd";
        // System.out.println(compress(str)); // a3b2c2d4


        // String str = "hi, how are you?";
        // System.out.println(toUpperCase(str));

        // StringBuilder sb = new StringBuilder("");
        // for(char ch ='a';ch<='z';ch++){
        //     sb.append(ch);
        // }
        // System.out.println(sb.length());
    //    char arr[] = {'a','b','c','d','e'}; 
    //    String str ="abcd";
    //    String str1 = new String("xyz");

    //    Scanner scn = new Scanner(System.in);
    //    String name;
    //    name = scn.nextLine();
    //    System.out.println(name);

    // String firsString = "Hello";
    // String secondString = "World";
    // String fullString = firsString + " "+secondString ;
    // printLetters(fullString);

    // String str = "HelloWorld";
    // System.out.println(subString(str, 0, 5)); // Hello

    // String fruits[] ={"apple", "banana", "cherry", "date", "elderberry"};
    // PrintLargestString(fruits); 

    String str="ApnaCollege";
    String str1 = "ApnaCollege";
    String str2 = "ApnaCoegell";
    System.out.println(checkAnagram(str1,str2)); // true
     //System.out.println(countVowel(str));

    }
} 