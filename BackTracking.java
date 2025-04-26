public class BackTracking {

    public static void changeArr(int arr[],int i,int val){    //travse the array and backtracking
        if(i == arr.length){
        printArr(arr);
         return;
        }
        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i] - 2;
    }



    public static void printArr(int arr[]){     //print array
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }


    public static void findSubsets(String str, int i, String ans){     //find all possible subsets
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }

         //yes choice
        findSubsets(str, i+1, ans+str.charAt(i));
        //no choice
        findSubsets(str, i+1, ans);
    }

    


    public static void main(String[] args){
        String str = "abc";
        findSubsets(str, 0, "");
    }
}
