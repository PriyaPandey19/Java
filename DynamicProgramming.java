import java.util.Arrays;

public class DynamicProgramming {
    public static int fibTabulation(int n, int f[]){
        int dp[] = new int[n+1];
        dp[0] =0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int countWays(int n){      //using recursion
        if(n ==0){
            return 1;
        }
        if( n < 0 ){
            return 0;
        }
        return countWays(n-1)+countWays(n-2);
    }

    public static int countWays(int n,int ways[]){      //using memoization
        if(n ==0){
            return 1;
        }
        if( n < 0 ){
            return 0;
        }
        if(ways[n] != -1){
            return ways[n];
        }
        ways[n]= countWays(n-1, ways)+ countWays(n-2,ways);
        return ways[n];
    }

     public static int countWays1(int n){      // number of stairs using tabulation

       int dp[] = new int[n+1];
       dp[0] =1;

       for(int i=1;i<=n;i++){
        if(i==1){
            dp[i] = dp[i-1]+0;

        }
        else{
            dp[i] = dp[i-1]+dp[i-2];
        }
       }
       return dp[n];
    }




    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]){   //0-1 knap sack using memoization
        if(W==0|| n ==0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W]; 
        }
        if(wt[n-1] <= W){   //valid
            //include
          int ans1 = val[n-1] +knapsack(val, wt, W-wt[n-1], n-1,dp);
          //exclude
          int ans2 = knapsack(val, wt, W, n-1,dp);
          dp[n][W] =  Math.max(ans1, ans2);
          return dp[n][W];
        }
        else{   //not valid
            dp[n][W] =  knapsack(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }

        public static void print(int dp[][]){
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    System.out.print(dp[i][j] +" ");
                }
                System.out.println();
            }
            System.out.println();
        }




    public static int knapsackTab(int val[], int wt[], int W){    //0-1 knapsack using tabulation
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){  //0th col
         dp[i][0]= 0;
        }
         for(int j=0;j<dp[0].length;j++){  //0th row
         dp[0][j]= 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1];      //ith item wt
                int w = wt[i-1];   //ith item wt
                if( w <= j){     //valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else{   //not valid
                   int excProfit = dp[i-1][j];
                   dp[i][j] = excProfit;
                }

            }
        }
        print(dp);
      return dp[n][W];

    }

     public static void print1(boolean dp[][]){
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    System.out.print(dp[i][j] +" ");
                }
                System.out.println();
            }
            System.out.println();
        }




    public static boolean targetSumSubset(int arr[], int sum){    //target subset sum using tabulation
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        //i = items & j = target sum
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
         for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if( v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
         }
         print1(dp);
         return dp[n][sum];
    }

    


    

    





    public static void main(String[] args) {


    int val[] ={15, 14,10,45, 30};
    int wt[] ={2,5,1,3,4};
    int W = 7;
//     int dp[][] = new int[val.length+1][W+1];
//     for(int i=0;i<dp.length;i++){
//         for(int j=0;j<dp[0].length;j++){
//             dp[i][j] = -1;
//         }
//     }
   
//   //   System.out.println(knapsack(val, wt, W, val.length,dp)); 
//   System.out.println(knapsackTab(val, wt, W));








    }
}
