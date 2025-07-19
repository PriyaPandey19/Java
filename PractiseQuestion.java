public class PractiseQuestion {

    public static void SumOfAlternate(int numbers){        //32   sum of alternate

        int ans = 0;
        boolean add = true;
        while(numbers > 0){
            int digit = numbers%10;   //akhari number ko store karana
            if(add){
                ans+= digit;    //add in ans 
            }
            add = !add;
            numbers /=10;       //chota karna numbers
        }
        System.out.println(ans);
    }


    public static void FirstLastSum(int num){     //31
        int lastDigit = num%10;
        int firstDigit =0;
        while(num >0){
            firstDigit = num %10;
            num = num /10;
        }
        int sum = firstDigit +lastDigit;
        System.out.println(sum);
    }

    public static void SwapTwo(int a,int b){   //30
        int temp = a;
        a =b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }


    public static int Fibonacci(int n){   //28
        if(n ==0 || n==1){
            return n;
        }
    int fib1 = Fibonacci(n-1);
    int fib2 = Fibonacci(n-2);
    int fib = fib1 + fib2;
    return fib;
    }

    public static int calculateSum(int n) { // 4
        if (n == 0) {
            return 0;
        }
        return n + calculateSum(n - 1);
    }


    public static int factorial(int number){   //27 factorial
        if(number ==0){
          return 1;
        }
        return number * factorial(number-1);
    }

  public static void PerfectOrNot(int n){       //18  perfect number
    int Sum =0;
    for(int i=1;i<n;i++){
        if(n % i ==0){
            System.out.println(i);
            Sum += i;
        }
    }
    if(Sum == n){
     System.out.println("perfect number");
    }
    else{
        System.out.println("not a perfect number");
    }
  }


  public static void PerfectOrNotRange(int range){     //19
    for(int n =1;n<=range;n++) {    //iterate through each till range
    int Sum =0;     
    for(int i=1;i<n;i++){
        if(n % i ==0){
            Sum += i;   
        }
    }
    if(Sum == n){
        System.out.println(n + " perfect number");
       } 
    }
  }


  public static boolean isPrime(int n){    //14
    boolean isPrime = true;
    for(int i=2;i<=Math.sqrt(n);i++){
        if(n%i ==0){
            isPrime =false;
            break;
        }
        
    }
return isPrime;
}
  
public static void primesInRange(int range){   //15  primes in range
    for(int i=2;i<=range;i++){
      if(isPrime(i)){
       System.out.println(i+" ");
        }
    }
    System.out.println();
}
  
   
public static void primesBetweenRange(int start,int end){   //16 primes between range
    for(int i=start;i<=end;i++){
      if(isPrime(i)){
       System.out.println(i+" ");
        }
    }
    System.out.println();
}


  public static void Countfactor(int n){         //13  count factors
    System.out.println("Factors of "+ n +" are");
    int count =0;
    for(int i=1;i<=n;i++){
      if(n%i == 0){
    System.out.println(i);
        count ++;
      }  
    }
   System.out.println("total factor count are: "+count);
  }

  public static void Sumfactor(int n){         //12   sum of factors
    int sum =0;
    int count =0;
    for(int i=1;i<=n;i++){
      if(n%i == 0){
        System.out.println(i);
       sum += i;
      }  
    }
   System.out.println("total factor sum are: "+sum);
  }


  public static void factor(int n){         //11   factor
   // int sum =0;
    //int count =0;
    for(int i=1;i<=n;i++){
      if(n%i == 0){
        System.out.println(i);
       
      }  
    }
  
  }


  public static boolean Palindrome(int n){         //10  palindrome number
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

public static void reverseNumber(int num){    //9  reverse number
    int reverse = 0;
    while(num >0){
        int digit = num %10;
         reverse = reverse * 10+digit;
        num /= 10;
}  
    System.out.println(reverse);
}



public static void countDigit(int num){   //8 count digits
    int count =0;
    while(num >0){
        num/= 10;
        count++;
    }
    System.out.println(count);
}


public static void sumOfGivenNum(int num){   //7  sum of digits
    int sum =0;
    while(num >0){
    int digit = num %10;
         sum += digit;
        num /= 10;
    }
    System.out.println(sum);
}



public static void prducttillGivenNum(int n){   //5   product till n
    int product =1;
    for(int i=1;i<=n;i++){
        product *= i;   
    }
    System.out.println(product);
}


public static void sumtillGivenNum(int n){   //4   sum till n
    int sum =0;
    for(int i=0;i<=n;i++){
        sum += i;   
    }
    System.out.println(sum);
}


public static void numberReverse(int n){   //3   reverse number from n to 0
    
    for(int i=n;i>=0;i--){
       System.out.println(i);
    }
   // System.out.println(sum);
}


public static void number(int n){   //1    //print number from 0 to n
    
    for(int i=0;i<=n;i++){
       System.out.println(i);
    }
   // System.out.println(sum);
}








 

   

    public static void main(String[] args){
    //     int n = 4;
    //    for(int i=0;i<n;i++){
    //     System.out.println(Fibonacci(i));
    // }
     // PerfectOrNotRange(100);
   //System.out.println(Palindrome(1267));
    reverseNumber(123);
   number(4);
    }
}
