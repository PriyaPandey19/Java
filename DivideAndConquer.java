public class DivideAndConquer{
      

    public static void printArr(int arr[]){     //print array
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[],int si, int ei){   //merge sort
        if(si >= ei){
            return;
        }
        int mid = si +(ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i=si; //iterator for left part
        int j = mid+1; //iterator for right part
        int k =0;  //iterator for temp

        while(i <= mid && j <= ei){
            if(arr[i]< arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
               temp[k] = arr[j];
               j++;
            }
            k++;
        }
        //left part
        while( i<= mid){
            temp[k++] = arr[i++];
        }
        //right part
        while(j <= ei){
            temp[k++] = arr[j++];
        }
        //copy elements in org array
        for(k=0, i=si;k<temp.length;k++,i++){
         arr[i] = temp[k];   
        }
        
    }

    public static void  quickSort(int arr[],int si,int ei){   //quick sort
      if(si >= ei){   //base case
        return;
      }
      int pidx = partition(arr, si,ei);
      quickSort(arr, si, pidx-1);   //left half
      quickSort(arr, pidx+1, ei);   //right half
    }

    public static int partition(int arr[],int si,int ei){     //partition function
    int pivot = arr[ei];
    int i= si-1;   //to make place for els smaller than pivot

    for(int j=si;j<ei;j++){
        if(arr[j] <= pivot){
            i++;
            //swap
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
    i++;
    int temp = pivot;
    arr[ei] = arr[i];
    arr[i] = temp;
    return i;
    }




    public static int search(int arr[],int tar,int si,int ei){      //the serach function for rotated sorted array
           if(arr[si]>arr[ei]){
            return -1; 
           }                                                 //search in rotated sorted array
        //kaam
        int mid = si +(ei-si)/2;

        if(arr[mid] == tar){   //at mid
            return mid;
        }
        //mid L1
        if(arr[si] <= arr[mid]){
            //case a: left
            if(arr[si] <= tar && tar <= arr[mid]){
                return search(arr, tar, si, mid-1);
            }
            //case b: right
            else{
                return search(arr, tar, mid+1, ei);
            }
        }
        else{
            //case c: left
            if(arr[mid] <= tar && tar <= arr[ei]){
                return search(arr, tar, mid+1, ei);
            }
            //case d: right
            else{
                return search(arr, tar, si, mid-1);
            } 
        }
    }


public static String[] mergeSort1(String[] arr,int lo,int hi){    //to merge string array in alphabatical order
 if(lo == hi){                //base case
    String[] A ={arr[lo]};
    return A;
 } 
 int mid = lo + (hi -lo) /2; 
 String[] arr1 = mergeSort1(arr, lo, mid);  //left side
 String[] arr2 = mergeSort1(arr, mid+1, hi);    //right side

 String[] arr3 = merge1(arr1,arr2);
 return arr3;
}
public static String[] merge1(String[] arr1,String[] arr2){
    int m = arr1.length;
    int n = arr2.length;
    String[] arr3 = new String[m+n];

    int idx =0;
    int i=0;
    int j=0;

    while(i < m && j < n){
      if(isAlphabetSmaller(arr1[i],arr2[j])){
        arr3[idx] = arr1[i];
        i++;
        idx++;
      }
      else{
        arr3[idx] = arr2[j];
        j++;
        idx++; 
      }
    }

   while(i <m){
    arr3[idx] = arr1[i];
    i++;
    idx++;
   }
   while(j <n){
    arr3[idx] = arr2[j];
    j++;
    idx++;
   }
   return arr3;
}

public static boolean isAlphabetSmaller(String str1,String str2){    //is alphabet smaller
    if(str1 == null || str2 == null){
        return false;
    }
    if(str1.compareTo(str2)<0){
        return true;
    }
    return false;
}






public static int CommonElements(int arr[]){   //count the max element
   int majority = arr.length/2;
   
    for(int i=0;i<arr.length;i++){
        int count =0;
        for(int j=0;j<arr.length;j++){
        if(arr[i] == arr[j]){
          count++;
        }
        } 
       if(count > majority){
        return arr[i];
       } 
    }
    
   return -1;
}

public static int getInversionCount(int arr1[]){       //get inversion count where arr[i] > arr[j]
    int n = arr1.length;
    int count =0;
     for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(arr1[i] > arr1[j]){
            count++;
            }
        }
     }
     return count;
}


    
    public static void main(String[] args){          //main function
    int arr1[] ={1,20,6,4,5};
   System.out.println(getInversionCount(arr1));
    }
}