import java.util.*;

public class Recurison {
    public static void printnumbersDec(int n) { // print numbers in descending order
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printnumbersDec(n - 1);
    }

    public static void printnumbersInc(int n) { // print numbers in ascending order
        if (n == 1) {
            System.out.println(n);
            return;
        }
        printnumbersInc(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) { // calculate factorial of a number
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int calculateSum(int n) { // calculate sum of first n natural numbers
        if (n == 0) {
            return 0;
        }
        return n + calculateSum(n - 1);
    }

    public static int fibonacci(int n) { // calculate nth fibonacci number
        if (n == 0 || n == 1) {
            return n;
        }
        int fib1 = fibonacci(n - 1);
        int fib2 = fibonacci(n - 2);
        int fib = fib1 + fib2;
        return fib;
    }

    public static boolean isSorted(int arr[], int i) { // check if array is sorted
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static void Occurance(int arr[], int key, int i) {    // find all occurrences of a key in an array
        if (i == arr.length - 1) {
            return;
        }
        if (arr[i] == key) {
            System.out.println(i);
        }
        Occurance(arr, key, i + 1);
    }

    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void convertToString(int number) {       // convert number to string
        if (number == 0) {
            return;
        }
        int lastDigit = number % 10;
        convertToString(number / 10);
        System.out.print(digits[lastDigit] + " ");

    }
    public static  int firstOccurance(int arr[],int i,int key){   //first occurance in in array
        if(i == arr.length-1){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurance(arr, i+1, key);

}

  public static int lastOccurance(int arr[],int i,int key){     // last occurance in array
    if(i == arr.length){
        return -1;
    }
    int isFound = lastOccurance(arr, i+1, key);
    if(isFound == -1 && arr[i] == key){
        return i;
    }
    return isFound;
  }

  public static int power(int x, int n){    // calculate power of a number
    if( n ==0){
        return 1;
    }
    // int nm1 = power(x, n-1);
    // int xn = x * nm1;
    return x * power(x, n-1);
  }



  public static int powerOptimized(int x, int n){   // optimized power calculation
   if(n ==0){
    return 1;
   }
   int halfPower = powerOptimized(x, n/2);
   int halfPowerSq = halfPower * halfPower; // x^n/2 * x^n/2 = x^n
  //n is odd
  if(n % 2 != 0){
    halfPowerSq = x * halfPowerSq;
  }
  return halfPowerSq;
  }

    
public static int  tilingProblem(int n){     //tiling problem to find number of ways to fill a 2xn board with 1x2 tiles
    //base case
    if(n == 0 || n == 1){
        return 1;
    }
    //vertical case
    int fnm1 = tilingProblem(n-1);

    //horizonatl case
    int fnm2 = tilingProblem(n-2);
    int totalWays = fnm1 + fnm2;
    return totalWays;


}

public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){    // remove duplicates from a string
    if(idx == str.length()){
        System.out.println(newStr);
        return;
    }
    //kaam
    char currChar = str.charAt(idx);
    if(map[currChar - 'a'] == true){         //duplicate exists so incresse the idx
        removeDuplicates(str, idx+1, newStr, map);
    }
    else{
        map[currChar - 'a'] = true;
        removeDuplicates(str, idx, newStr.append(currChar), map);
    }
}
    public static void main(String[] args) {
        // printnumbersDec(5);
        // printnumbersDec(5);
        // System.out.println("Factorial of 5: " + factorial(5));
        // System.out.println(calculateSum(6));
        // System.out.println(fibonacci(5));

         String str = "appnnacollege";
         removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
