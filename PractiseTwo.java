import java.util.*;

public class PractiseTwo {

   public static int getLargest(int numbers[]){    //get largest
      int largest = Integer.MIN_VALUE;

      for(int i=0;i<numbers.length;i++){
          if(largest < numbers[i]){
              largest = numbers[i];
          }
      }
      return largest;
  }

  public static void reverse(int numbers[]){            //reverse array
   int first =0,last =numbers.length-1;    

   while(first<last){
       int temp = numbers[last];
       numbers[last] =  numbers[first];
       numbers[first] = temp;

       first++;
       last--;
   }
}

public static int[] twoSum(int nums[], int target) { //two sum problem
    for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i] + nums[j] == target){
                return new int[] {i,j};
            }
           // System.out.println("("+i + "," + j+")");
        }
    }
    return new int[] {};
}




   public static void main(String [] args){
   //  Scanner scn = new Scanner(System.in);
   //  System.out.println("Enter size of arr");
   //  int n = scn.nextInt();
   //  int arr[] = new int[n];
   //  System.out.println("Enter value of arr");
   //  for(int i=0;i<n;i++){
   //    arr[i] = scn.nextInt();
   //  }
   //  for(int k=0;k<arr.length;k++){
   //    System.out.print(arr[k]+ " ");
   //  }
   //  int a = 123;
   //  int sum =0;
   //  while(a>0){
   //   int digit = a%10;
   //   sum = sum + digit;
   //      a = a/10;
   //  }
   //  System.out.println(sum);
   

   //  int arr[] ={1,2,3,4,5};
   //  for(int i=0;i<arr.length;i++){
   //       System.out.print(arr[i] + " ");
   //  }
int nums [] ={1,2,3,4,5};
int target =5;
int[] result = twoSum(nums, target);
if(result.length ==2){
    System.out.println("("+result[0] + "," + result[1]+")");
}
else{
    System.out.println("No such pair found");
   } 
}
}
 