import java.util.*;

public class BitManipulation {

    public static void oddOrEven(int n) {     //to check if the number is odd or even
        int bitMask =1;
        if((n & bitMask) ==0){
            System.out.println("Even");
        }
        else{
            System.out.println("Odd");
        }
    }

    public static int getIthBit(int n,int i) {    //to get the ith bit of the number
        int bitMask = 1<<i;
        if((n & bitMask) ==0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static int setIthBit(int n,int i) {    //to set the ith bit of the number
        int bitMask = 1<<i;
        return  n|bitMask;
    }

    public static int clearIthBit(int n,int i){   //to clear the ith bit of the number
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit){  //update the ith bit of the number
        // if(newBit ==0){
        //     return clearIthBit(n,i);
        // }
        // else{
        //     return setIthBit(n,i);
        // }

        n = clearIthBit(n, i);
        int BitMask = newBit<<i;
        return n| BitMask;
    }

    public static int clearIBits(int n,int i){   //to clear the i bits of the number
        int bitMask =(~0) <<i;
        return n & bitMask;
    }
    public static int clearIBitsinRange(int n,int i,int j) { //to clear the i bits of the number in the range i to j
        int a = ((~0)<< (j+1));
        int b = (1<<i)-1;
        int bitMask = a|b;
        return n & bitMask;
    }




    public static boolean isPowerOfTwo(int n){  //to check if the number is power of 2
        return (n&(n-1)) ==0;
    }




    public static int countSetBits(int n){    //to count the number of set bits in the number i.e 1
        int count =0;
        while(n >0){
            if((n&1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int swapNumbers(int a,int b){  //to swap the numbers without using third variable
        a = a^b;
        b = a^b;
        a = a^b;
        return a;
    }

    public static char uppercasetolowercase(char ch){  //to convert uppercase to lowercase
        ch = (char)(ch|32);
        return ch;
    }


  public static void main(String args[]){
System.out.println((uppercasetolowercase('A')));
  }  
}
