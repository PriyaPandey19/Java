//import java.util.*;

public class Functions {

    public static int multiply(int a,int b){     //multiply function
        int product = a*b;
        return product;
    }
    public static int factorial(int n){       //factorial function
        int fact =1;
        for(int i =1;i<=n;i++){
             fact = fact*i;
             
        }
        return fact;    
    }

    public static int binCoeff(int n, int r){   //binary coefficient
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n-r);

        int binCoeff = fact_n/(fact_r*fact_nmr);
        return binCoeff;
    }

    public static boolean isPrime(int n){    //to find prime no.
        boolean isPrime = true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i ==0){
                isPrime =false;
                break;
            }
            
        }
    return isPrime;
    }

    public static void primesInRange(int n){   //primes in range
        for(int i=2;i<=n;i++){
          if(isPrime(i)){
           System.out.println(i+" ");
            }
        }
        System.out.println();
    }

    public static void binToDec(int binNum) {           //binary To decimal
        int myNum = binNum;
        int pow =0;
        int decNum =0;

        while(binNum>0){
            int lastDigit = binNum %10;
            decNum = decNum + (lastDigit *(int)Math.pow(2, pow));

            pow++;
            binNum = binNum/10;
        }
        System.out.println("decimal of " +myNum +" = "+ decNum);
    }

    public static void decToBin(int n){      //dec to binary
    int myNum = n;
    int pow =0;
    int binNum =0;

    while(n>0){
        int rem = n%2;
        binNum = binNum + (rem *(int)Math.pow(10, pow));
        pow++;
        n=n/2;
    }
    System.out.println("binary form of"+myNum + "="+binNum);
    }

    public static void Average(int x,int y,int z){   //Average of 3 num
        int avg = (x+y+z)/3;
        System.out.println(avg);
    }
    

    public static boolean IsEven(int n){    //check even or odd
     boolean IsEven =true;
     if(n%2 ==0){
        return true;
     }
     return false;
    }

    public static boolean Palindrome(int n){         //palindrome or not
        int palindrome = n;
        int reverse =0;

        while(palindrome!=0){
            int remainder = palindrome%10;
            reverse = reverse*10 +remainder;
            palindrome = palindrome/10;
        }
        if(n == reverse){
          return true;
        }
      return false;
        
    }

    public static int CalculateSum(int n){   //calculate sum till number become 0
    int sum =0;
    while(n >0){
    int rem = n%10;
    sum = sum +rem;
    n = n/10;
    }
    return sum;
    }
    public static void main(String args[]){
    System.out.println(CalculateSum(105));
    }
    
}
