import java.util.*;

public class BasicSorting {
  public static void bubbleSort(int arr[]){      //bubble sort
    for(int turn =0;turn<arr.length-1;turn++){
       // int swap =0;
      for(int j =0;j<arr.length-1-turn;j++){

         if(arr[j] > arr[j+1]) {
           // swap =1;
            //swap
             int temp = arr[j];
             arr[j] = arr[j+1];
             arr[j+1] = temp;
         }
      }
    }
  }


  public static void modifiedbubbleSort(int arr[]){      // Optimized  bubble sort
    for(int turn =0;turn<arr.length-1;turn++){
       boolean swapped = false;
      for(int j =0;j<arr.length-1-turn;j++){

         if(arr[j] > arr[j+1]) {
           
             int temp = arr[j];
             arr[j] = arr[j+1];
             arr[j+1] = temp;
             swapped = true;
         }
      }
      if(swapped == false){
        break;
      }
    }
  }
  
  
  public static void selectionSort(int arr[]){             //selection sort
    for(int i=0;i<arr.length-1;i++){
        int minPos =i;
         for(int j=i+1;j<arr.length;j++){
            if(arr[minPos] > arr[j]){
                minPos = j;
            }
         }
         //swap
         int temp = arr[minPos];
         arr[minPos] = arr[i];
         arr[i] = temp;
    }
  }

  public static void insertionSort(int arr[]){   //insertion sort
    for(int i=1;i<arr.length;i++){
        int curr =arr[i];
        int prev =i-1;
        //finding out the correct position of the current element
        while(prev >=0 && arr[prev] > curr){
            arr[prev+1] = arr[prev];
            prev--;
        }
        arr[prev+1] = curr;
    }
  }

  public static void countingSort(int arr[]){    //counting sort
    int largest = Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
        largest = Math.max(largest,arr[i]);
    }

    int count[] = new int[largest+1];
    for(int i=0;i<arr.length;i++){
        count[arr[i]]++;
    }

    //sorting
    int j=0;
    for(int i=0;i<count.length;i++){
        while(count[i] >0){
            arr[j] = i;
            j++;
            count[i]--;
        }
    }
  }
  
  public static void printArr(int arr[]){       //print array
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+ " ");
    }
    System.out.println();
  }


  public static void main(String args[]){
    int arr[] ={1,4,1,3,2,4,3,7};
    
    
    Arrays.sort(arr);  //using inbuilt function to sort in descending order
    countingSort(arr);
     printArr(arr);
  }
}
