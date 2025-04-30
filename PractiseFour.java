import java.util.*;     //Topic CLASSES AND FUNCTIONS

class AreaOfRectangle{

  int l, w;
  void Area(int l,int w){
    System.out.println(l*w);
  }
}
class BankAccount{
  int accNumber;
  String accHolder;
  int currbalance = 5000;
  void displayName(String accHolder){
    System.out.println(accHolder);
  }
  void displayAccNumber(int accNumber){
    System.out.println(accNumber);
  }
  void displayCurrBalance(){
   System.out.println("currBalance"+ currbalance);
  }
  void deposit(int deposit){
    
    currbalance = currbalance + deposit;
    System.out.println(currbalance);
  }
  void withdraw(int withdrawAmt){
   
    currbalance = currbalance - withdrawAmt;
    System.out.println(currbalance);
  }

}

class Student{
  int rollNumber;
  String name;
  int marks;
  void ShowRollNumber(int rollNumber){
    System.out.println(rollNumber);
  }
  void ShowName(String name){
    System.out.println(name);
  }
  void ShowMarks(int marks){
    System.out.println(marks);
  }
}

public class PractiseFour { // TOPIC FUNCTIONS AND SORTING

  public static int Min(int arr[]) { // return min elelment
    int smallest = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] < smallest) {
        smallest = arr[i];
      }
    }
    return smallest;
  }

  public static int FindTarget(int arr[], int key) { // find target
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == key) {
        return i;
      }
    }
    return -1;
  }




  public static void missingNumber(int arr[]) {    //missing number in array
    int largest = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (largest < arr[i]) {
        largest = arr[i];
      }
    }
    int sum = 0;
    for (int i = 1; i <= largest; i++) { // till largest sum variable sum start with 0
      sum += i;

    }
    int sum1 = 0;
    for (int j = 0; j < arr.length; j++) { // array ka total sum
      sum1 += arr[j];
    }
    int output = sum - sum1;
    System.out.println(output);
  }



  public static int LinearSearch(int arr[],int key){     //Linear search
    for(int i =0;i<arr.length;i++){
      if(arr[i] == key){
        return i;
      }
    }
    return -1;

  }

  public static int binarySearch(int arr[],int key,int start,int end){   //binary search
   if(start >= end){
    return -1;
   }
   int mid = (start+ end)/2;

   for(int i=0;i<arr.length;i++){
     if(arr[i] == key){
      return i;
     }
     else if(key > arr[mid]){  //key badi hai right side
     binarySearch(arr, key, mid+1, end);
     }
     else{
      binarySearch(arr, key, start, mid-1);
     }
   }
   return -1;
  }


  public static void bubbleSort(String str[]){      //bubble sort to sort string Eg. "A","B","C"
    for(int turn =0;turn<str.length-1;turn++){
      for(int j =0;j<str.length-1-turn;j++){
        
         if(str[j].charAt(0) > str[j+1].charAt(0)) {
             String temp = str[j];
             str[j] = str[j+1];
             str[j+1] = temp;
         }
      }
    }
    for(String c:str){
      System.out.println(c + " ");
    }
  }

  








  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  //  String[] str = {"B","C","A"};
  //    bubbleSort(str);
    BankAccount ba = new BankAccount();
    ba.displayName("priya");
    ba.displayAccNumber(12233);
    ba.displayCurrBalance();

    ba.deposit(400);
    ba.withdraw(300);
  }
}
