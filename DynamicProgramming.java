import java.util.Arrays;
import java.util.HashSet;

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

    

  public static int unboundedKnapsack(int val[], int wt[], int W){      //unbounded knapsack using tabulation
    int n  = val.length;
    int dp[][] = new int[n+1][W+1];

    for(int i=0;i<n+1;i++){
        dp[i][0]=0;
    }
    for(int j=0;j<W+1;j++){
        dp[0][j] =0;
    }

    for(int i=1;i<n+1;i++){
        for(int j=1;j<W+1;j++){
            if(wt[i-1] <= j){ //valid
                dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
            }
            else{ //not valid
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    print(dp);
    return dp[n][W];
  }




  public static int coinChange(int coins[], int sum){    //coin change using tabulation
    int n = coins.length;
    int dp[][] = new int[n+1][sum+1];

    for(int i=0;i<n+1;i++){
        dp[i][0] =1;
    }
     for(int j=1;j<sum+1;j++){
        dp[0][j] =0;
    }
    for(int i=1;i<n+1;i++){
        for(int j=1;j<sum+1;j++){
            if(coins[i-1] <= j){   //valid
                dp[i][j] = dp[i][j-coins[i-1]]+ dp[i-1][j];
            }
            else{                    //not valid
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[n][sum];
  }





  //weight => length , val->prices, W-> totRod
  public static int rodCutting(int length[], int prices[], int totRod){   //rod cutting using memoization

    int n = prices.length;
    int dp[][] = new int[n+1][totRod+1];

    for(int i=0;i<n+1;i++){
        for(int j=0;j<totRod+1;j++){
            if(i ==0 || j==0){
                dp[i][j] =0;
            }
        }
    }
    for(int i=1;i<n+1;i++){
        for(int j=1;j<totRod+1;j++){
            //valid
            if(length[i-1] <= j){
                dp[i][j] = Math.max(prices[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
            }
            else{  //invalid
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[n][totRod]; 
  }



  public static int lcs2(String str1, String str2, int n, int m, int dp[][]){  //lcs using memoization
    if(n ==0 || m==0){
        return 0;
    }
    if(dp[n][m] != -1){
        return dp[n][m];
    }

    if(str1.charAt(n-1) == str2.charAt(m-1)){
        return dp[n][m] = lcs2(str1, str2, n-1, m-1,dp)+1;
    }
    else{
        int ans1 = lcs2(str1, str2, n-1, m, dp);
        int ans2 =lcs2(str1, str2, n, m-1, dp);
        return dp[n][m] = Math.max(ans1, ans2);
    }
  } 



  public static int lcsTab(String str1, String str2){    //lcs using tabulation
    int n = str1.length();
    int m = str2.length();

    int dp[][] = new int[n+1][m+1];
    for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
            if(i==0 || j==0){
                dp[i][j] =0;
            }
        }
    }
    for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1]+1;
            }
            else{
                int ans1 = dp[i-1][j];
                int ans2 = dp[i][j-1];
                dp[i][j] = Math.max(ans1,ans2);
            }
        }
    }
    return dp[n][m];
  }



  public static int longestCommonSubstring(String str3, String str4){    //lcs using tabulation
    int n = str3.length();
    int m = str4.length();
    int ans =0; 

    int dp[][] = new int[n+1][m+1];    //initilize
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
         for(int j=0;j<n+1;j++){
            dp[0][j] = 0;
        }

    for(int i=1;i<n+1;i++){                    //if both the char are same so reduce both length by -1
        for(int j=1;j<m+1;j++){
            if(str3.charAt(i-1) == str4.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1]+1;
                ans = Math.max(ans, dp[i][j]);
            }
            else{
                dp[i][j] = 0;
            }
        }
    }
    return ans;
  }







  public static int lcs(int arr1[], int arr2[]){    //helper function of lis
    int n = arr1.length;
    int m = arr2.length;
    int dp[][] = new int[n+1][m+1];

    for(int i=0;i<n+1;i++){
        dp[i][0] = 0;
    }
     for(int j=0;j<m+1;j++){
        dp[0][j] = 0;
    }

    for(int i=1;i<n+1;i++){
     for(int j=1;j<m+1;j++){
        if(arr1[i-1] == arr2[j-1]){
            dp[i][j] = dp[i-1][j-1] +1;
        }
        else{
            int ans1 = dp[i-1][j];
            int ans2 = dp[i][j-1];
            dp[i][j] = Math.max(ans1, ans2);
        }
     }
    }
    return dp[n][m];
  }

  public static int lis(int arr1[]){                //longest increasing subseqence
    HashSet<Integer> set = new HashSet<>();
    for(int i=0;i<arr1.length;i++){
        set.add(arr1[i]);
    }

    int arr2[] = new int[set.size()];
    int i=0;
    for(int num : set){
        arr2[i] = num;
        i++;
    }
    Arrays.sort(arr2);
    return lcs(arr1, arr2);

  }



    public static void main(String[] args) {
   int coins[] ={1,2,3};
   int sum =4;
   System.out.println(coinChange(coins, sum));

   int length[] = {1,2,3,4,5,6,7,8};
   int prices[] ={1,5,8,9,10,17,17,20};
   int totRod = 8;
   System.out.println(rodCutting(length, prices, totRod));

   String str1 = "abcdge";
   String str2 = "abedg";
   int n = str1.length();
   int m = str2.length();
   int dp[][] = new int[n+1][m+1];
   System.out.println(lcsTab(str1, str2));


   String str3 = "ABCDE";
   String str4 = "ABGCE";
   System.out.println(longestCommonSubstring(str3, str4));


   int arr[] = {50,3,10,7,40,80};
   System.out.println(lis(arr));







    }
}
