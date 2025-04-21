public class PractiseThree {

public static void RowSum(int arr[][]){         //sum of each row in 2D array
    for(int i=0;i<arr.length;i++){
        int rowSum =0;
        for(int j=0;j<arr[i].length;j++){
            rowSum += arr[i][j];
        }
        System.out.println(rowSum);
    }
}

public static void ColumnSum(int arr[][]){        //sum of each column in 2D array
    for(int i=0;i<arr[0].length;i++){
        int colSum =0;
        for(int j =0;j<arr.length;j++){
            colSum += arr[j][i];
        }
        System.out.println(colSum);
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

public static int maxElement(int arr[][]){      //max element in 2D array
    int max = Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
            if(arr[i][j] > max){
                max = arr[i][j];
            } 
        }
       
    }
    return max;
}


public static int minElement(int arr[][]){      //min  element in 2D array
    int min = Integer.MAX_VALUE;
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
            if(arr[i][j] < min){
                min = arr[i][j];
            } 
        }
       
    }
    return min;
}





    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,9,6},{7,8,5}};
        //RowSum(arr);
   System.out.println(minElement(arr));
    
    }
}
