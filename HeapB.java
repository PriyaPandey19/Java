import java.util.*;
import java.util.ArrayList;


public class HeapB{
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){                           //add in heap
            //add at last index
            arr.add(data);

            int x = arr.size()-1;  //x is child
            int par = (x-1)/2;     //par index

            while(arr.get(x) < arr.get(par)){
              //swap
              int temp = arr.get(x);
              arr.set(x, arr.get(par));
              arr.set(par,temp);

              x = par;
              par= (x-1)/2;
            }
        }

        public  int peek(){                                 //return root in min heap
        return arr.get(0);    
        }


        private void heapify(int i){                   //helper of remove function
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);
            }

        }


        public  int remove(){  
           int data = arr.get(0);                                           //remove the node
            //step 1 swap first and last element
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            //arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);            

           //step 2 delete last
           arr.remove(arr.size()-1);

           //step 3 heapify
           heapify(0);
           return data;
        }



        public boolean isEmpty(){                 //is Empty or not
            return arr.size() == 0;
        }
    }






    public static void heapify(int arr[],int i, int size){     //helper of heap sort
        
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx =i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }

    }

    public static void heapSort(int arr[]){     //to sort an heap in ascending order using maxHeap
     //build maxHeap
     int n = arr.length;
     for(int i= n/2; i>=0;i--){
        heapify(arr,i, n);
     } 
     
     for(int i=n-1;i>0;i--){
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, 0, i);
     }
    }


    




    
    public static void main(String args[]){
    Heap pq = new Heap();
    // pq.add(3);
    // pq.add(4);
    // pq.add(1);
    // pq.add(5);

    // while(!pq.isEmpty()){
    //     System.out.println(pq.peek());
    //     pq.remove();
    // }




    // int arr[] ={1,2,4,5,3};
    // heapSort(arr);

    // //print
    // for(int i=0;i<arr.length;i++){
    //     System.out.print(arr[i] +" ");
    // }
    // System.out.println();

    





    }
}