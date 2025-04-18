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

    public static void Occurance(int arr[], int key, int i) { // find all occurrences of a key in an array
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

    public static void main(String[] args) {
        // printnumbersDec(5);
        // printnumbersDec(5);
        // System.out.println("Factorial of 5: " + factorial(5));
        // System.out.println(calculateSum(6));
        // System.out.println(fibonacci(5));

        // int arr[] = {1,2,3,2,5};
        // Occurance(arr, 2, 0);

        convertToString(1234);
    }
}
