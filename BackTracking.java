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

    public static void findPermutation(String str, String ans){      //find all the permutation 
        //base case
        if(str.length() == 0){
         System.out.println(ans);
         return;
        }
        //recursion
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            //"abcde" = "ab"+ "de" = abde
              String Newstr = str.substring(0, i) + str.substring(i+1);
            findPermutation(Newstr, ans+curr);
        }
    }



    public static boolean isSafe(char board[][],int row,int col){   //n queen problem
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
              return false;
            }
        }

        //diagonal left up
        for(int i=row-1,j=col-1; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal right up
        for(int i=row-1,j=col+1; i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char board[][],int row){
        //base
        if(row == board.length){
            printBoard(board);
            return;
        }
        //column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)) {
                board[row][j] ='Q';
                nQueens(board, row+1);    //function call
                board[row][j] ='.';       //backtracking step
            }
        }
    }

    public static void printBoard(char board[][]){
        System.out.println("------------chess board-----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        int n = 4   ;
        char board[][] = new char[n][n];
        //initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]= '.';
            }
        }
        nQueens(board, 0);
    }   
}
