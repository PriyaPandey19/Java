import java.util.*;

public class TwoDArrays {
    public static boolean search(int matrix[][], int key){     //search
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == key){
                    System.out.println("found at cell (" + i+","+j+")");
                    return true;
                }
            }
         }
         System.out.println("key not found");
             return false;
    }

    public static void SpiralMatrix(int matrix[][]){       //spiral matrix  
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length -1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol){
            //top
            for(int j = startCol;j<endCol;j++){
                System.out.print(matrix[startRow][j] + " ");
            }
            //right
            for(int i = startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol]+ " ");
            }
            //bottom
            for(int j = endCol-1;j>=startCol;j--) {
                if(startRow == endRow){
                    break;
                }
                System.out.print(matrix[endRow][j] +" ");
            }
            //left
            for(int i = endRow-1;i>=startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol] +" ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();

    }

    public static int diagonalSum(int matrix[][]){               //diagonal sum
        int sum =0;

        for(int i =0;i<matrix.length;i++){      //0(n^2) approach 1
            for(int j =0;j<matrix[0].length;j++){
                if( i ==j){
                    sum += matrix[i][j];
                }
                else if(i +j == matrix.length-1){
                    sum += matrix[i][j];
                }
            }
        }


        for(int i=0;i<matrix.length;i++){    //0(n) approach 2
            sum += matrix[i][i];

            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-i-1];
            }
        } 
        return sum;
    }

      public static boolean staircaseSearch( int matrix[][],int key){   //to find the  element in ascending order matrix
             int row=0,col=matrix[0].length-1;

             while(row < matrix.length && col >= 0){
                if(matrix[row][col] == key){
                    System.out.println("found at index (" + row + "," + col + ")");
                    return true;
                }
                else if(key < matrix[row][col]){
                    col--;
                }
                else{
                    row++;
                }
             }
             System.out.println("key not found");
             return false;
      }

    

    
public static boolean Occurance(int matrix[][]){    //count occurences of each element in 2d matrix 
    int maxElement = Integer.MIN_VALUE;

    //find the maximum element 
    for(int i =0;i<matrix.length;i++){
        for(int j =0;j<matrix[i].length;j++){
            maxElement = Math.max(maxElement,matrix[i][j]);
        }
    }
    int freq[] = new int[maxElement+1];
  
    //count occurences of each element
    for(int i =0;i<matrix.length;i++){
        for(int j =0;j<matrix[i].length;j++){
            freq[matrix[i][j]]++;
        }
    }
    //check if any element occur
    for(int count : freq){
        if(count >0){
            //System.out.println();
            return true;
        }
    }
    return false;

}

public static int Sumof2ndRow(int matrix[][]){      //sum of 2nd row in 2d Matrix
    int startRow =1;
        int sum=0;
        for(int j=0;j<matrix[1].length;j++){
             sum = sum + matrix[startRow][j];
          //  return sum;
        }
    
    return sum;
}

public static int[][] Transpose(int m,int n,int matrix[][]){    //Transpose of matrix
    int ans[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;   //2d maktrix answer

}

public static void SortArray(int arr[]){           //0s 1s 2s in array
    int size = arr.length;
    Arrays.sort(arr);

    for(int i=0;i<size;i++){
        System.out.print(arr[i] +" ");
    }
    System.out.println();
}





    public static void main(String args[]){
      int matrix[][] =new int[3][3];
      int n = matrix.length, m =matrix[0].length;
      
//  Scanner sc = new Scanner(System.in);
      //input
    //  for(int i=0;i<n;i++) {
    //     for(int j=0;j<m;j++){
    //         matrix[i][j] =sc.nextInt();
    //     }
    //  } 

     //output
    //  for(int i=0;i<n;i++){
    //     for(int j=0;j<m;j++){
    //         System.out.print(matrix[i][j] + " ");
    //     }
    //      System.out.println();
    //  }
      search(matrix,6);


    int matrix1[][] ={
        {1,4,9},
        {11,4,3},
        {2,2,3}
        
    };
   //staircaseSearch(matrix, 14);
    // System.out.println(Sumof2ndRow(matrix));
//   int[][] result = Transpose(3, 3, matrix);

//   for(int i =0;i<result.length;i++){
//     for(int j =0;j<result[i].length;j++){
//       System.out.print(result[i][j]+" ");  
      
//     }
//     System.out.println();
//   }

int arr[] ={5,7,0,1,2,5,3,2};
SortArray(arr);
    }
}
