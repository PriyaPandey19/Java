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






  public static void main(String[] args) {
    int arr[] = { 1,2,3,4,5};
  System.out.println(binarySearch(arr, 3, 0, arr.length));
  }
}
