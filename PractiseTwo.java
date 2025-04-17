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



public static int[] twoSum(int nums[], int target) {      //two sum problem
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

public static int SumOFTwoArray(int arr1[],int arr2[]){   //sum of 1D array
    int sum =0;
   for(int i=0;i<arr1.length;i++){
         sum += arr1[i] + arr2[i]; 
   } 
   return sum;
}

public static void SumOFTwoArrays(int arr1[],int arr2[]){   //sum of two 1D array and store it in another array
    int sum[] = new int[arr1.length];
     for(int i=0;i<arr1.length;i++){
        sum[i] += arr1[i] +arr2[i];
     }
     for(int i=0;i<sum.length;i++){
        System.out.print(sum[i] + " ");
     }
   
}

public static void commonTwo(int arr1[],int arr2[]){  //common elements in two array
    System.out.println("Common elements are: ");
    for(int i=0;i<arr1.length;i++){
        for(int j=0;j<arr2.length;j++){
            if(arr1[i] ==arr2[j]){
                System.out.println(arr1[i]+" ");
                break;
            }
        }
    }
   
}

public static void mergeTwoArray(int arr1[],int arr2[]){    //merge 2 array
    int[] arr3 = new int[arr1.length + arr2.length];
    for(int i=0;i<arr1.length;i++){
        arr3[i] = arr1[i];
    }
    for(int i=0;i<arr2.length;i++){
     arr3[arr1.length + i] = arr2[i];   
    }
    for(int i=0;i<arr3.length;i++){
        System.out.print(arr3[i] + " ");
    }
}

public static void sum2DArray(int arr1[][]){      //sum of 2D array
    int sum =0;
   for(int i=0;i<arr1.length;i++){
    for(int j=0;j<arr1[i].length;j++){
       
        sum += arr1[i][j];
    }
   }
   System.out.println("sum of 2D array is "+ sum);
}


public static void uniqueElements(int arr1[],int arr2[]){   //unique elements in two array

    for(int i=0;i<arr1.length;i++){
        boolean found = false;
        for(int j=0;j<arr2.length;j++){
            if(arr1[i] == arr2[j]){
             found = true;
             break;
        }
    }
        if(!found){
            System.out.println(arr1[i] + " "+ arr2[i]);
        }
    }
    
}


public static void copyArray(int arr1[]){     //copy array from 1 array to another
    int arr2[] = new int[arr1.length];
    for(int i=0;i<arr1.length;i++){
        arr2[i] = arr1[i];
    }
    for(int i=0;i<arr2.length;i++){
        System.out.println(arr2[i]);
    }
}


public static void maxElement(int arr1[],int arr2[]){
    int max = Integer.MIN_VALUE;
    for(int i=0;i<arr1.length;i++){
        if(arr1[i] > max){
            max = arr1[i];
        }
    }
    for(int i=0;i<arr2.length;i++){
        if(arr2[i]>max){
            max = arr2[i];
        }
    }
    System.out.println("Max element is "+ max);
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
// int nums [] ={1,2,3,4,5};
// int target =5;
// int[] result = twoSum(nums, target);
// if(result.length ==2){
//     System.out.println("("+result[0] + "," + result[1]+")");
// }
// else{
//     System.out.println("No such pair found");
//    } 
int arr1[] = {6,2,3,9,5};
int arr2[] = {6,7,8,9,10};
maxElement(arr1, arr2);

}
}
 