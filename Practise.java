import java.util.*;     //BASIC QUESTIONS

public class Practise {
    public static void main(String [] args){
        Scanner scn  = new Scanner(System.in);         
        //  int n = scn.nextInt(); 
        //  switch(n){
        //     case 1:
        //         System.out.println("monday");
        //         break;
        //     case 2:
        //         System.out.println("tuesday");
        //         break;
        //     case 3:
        //         System.out.println("wednesday");
        //         break;
        //     case 4:
        //         System.out.println("thursday");
        //         break;
        //     case 5 :
        //         System.out.println("friday");
        //         break;
        //     case 6 :
        //         System.out.println("saturday");
        //         break; 
        //     default:
        //     System.out.println("sunday");       
        //  }


        //  int a = scn.nextInt(); 
        //  int b = scn.nextInt(); 
        //  int c = scn.next().charAt(0);
   
        // switch(c){
        //     case '+':
        //         System.out.println("addition is " + (a+b));
        //         break;
        //     case '-':
        //         System.out.println("suntraction is " + (a-b));
        //         break;
        //     case '*':
        //         System.out.println("multiplication is " + (a*b));
        //         break;
        //     case '/':
        //         System.out.println("division is " + (a/b)); 
        //         break;
        //     default:
        //     System.out.println("invalid operator");
        //  }

        //  int i = scn.nextInt();
        //  switch(i){
        //  case 1:
        //     System.out.println("one");
        //     break;
        // case 2:
        //     System.out.println("two");
        //     break;
        // case 3:
        //        System.out.println("three");
        //         break;
        // case 4:
        //         System.out.println("four");
        //         break;  
        //  case 5:
        //       System.out.println("five");
        //       break;
        //  case 6:
        //       System.out.println("six");
        //       break;
        //  case 7:
        //       System.out.println("seven");
        //       break; 
        //  case 8:
        //       System.out.println("eight");
        //       break;
        // case 9:
        //       System.out.println("nine");
        //       break;  
        //  default:
        //      System.out.println("nothing");                                             
        //  }
     

        //  for(int j= 0;j<=5;j++){
        //     System.out.println(j);
        //  }


        //  int i=0;
        //  while(i<=5){
        //     System.out.println(i);
        //     i++;
        //  }

        int n =scn.nextInt();
        if(n%2==0){
            System.out.println("even number");
        }else{
            System.out.println("odd number");
        }

        int a = scn.nextInt();
        if(a>0){
            System.out.println("positive number");
        }
        else if(a<0){
            System.out.println("negative number");
        }
        else{
       System.out.println("zero");
        } 


        int b = scn.nextInt();
        int c = scn.nextInt();

        if(b> c){
            System.out.println("b is greater than c");
        }
        else{
            System.out.println("c is greater than b");
        }



        char ch = scn.next().charAt(0);
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("vowel");
                break;
           default:
           System.out.println("consonant");     
        }

   

int g = scn.nextInt();
    for(int i=1;i<=10;i++){
        int table = g*i;
        System.out.println(g+ "*" + i + "=" + table);
    }


    int num = scn.nextInt();
    if(num % 5 ==0 && num % 11 ==0){
        System.out.println("divisible by 5 and 11");
    }
    else{
        System.out.println("not divisible by 5 and 11");

    }


int h = scn.nextInt();
if(h% 3 ==0){
    System.out.println("divisible by 3");
}
else{
    System.out.println("it is not divisible by 3");
}


// int r = scn.nextInt();
// int fact = 1;
// for(int i=1;i<=r;i++){
//     fact = fact*i;
// }
// System.out.println(fact);


// int number  = 29;
// boolean isPrime = true;
// if(number <= 1) {
//     isPrime = false;
// } else{
//     for(int i =2;i<= number/2;i++){
//         if(number % i == 0){
//             isPrime = false;
//             break;
//         }
//     }
// }
// if(isPrime){
//     System.out.println(" 29 is prime");
// }
// else{
//     System.out.println("not prime");
// }



// int n1 = scn.nextInt();
// for(int i =1;i<=n1;i++){
//  System.out.println(i);   
// }
 

// int num1 = scn.nextInt();
// int reverse =0;

// while(num > 0){
//     int digit = num1 % 10;
//     reverse = reverse * 10 + digit;
//     num1 /= 10;
// }
// System.out.println("Reversed number: " + reverse);




char ch1 = scn.next().charAt(0);
int asciiValue = (int) ch1;
System.out.println("ASCII value of " + ch1 + " is: " + asciiValue);


float num1 = 3.224f;
int num2 = (int)num1;
System.out.println("The integer value is: " + num2);


    }     
}
