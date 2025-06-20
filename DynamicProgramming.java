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

    public static int knapsack(int val[], int wt[], int W, int n){
        if(W==0|| n ==0){
            return 0;
        }
        if(wt[n-1] <= W){   //valid
            //include
          int ans1 = val[n-1] +knapsack(val, wt, W-wt[n-1], n-1);
          //exclude
          int ans2 = knapsack(val, wt, W, n-1);
          return Math.max(ans1, ans2);
        }
        else{   //not valid
            return knapsack(val, wt, W, n-1);
        }
    }

    

    





    public static void main(String[] args) {
    int val[] ={15, 14, 10,45, 30};
    int wt[] ={2,5,1,3,4};
    int W = 7;
     //System.out.println(fibTabulation(n,f));  
   
     System.out.println(knapsack(val, wt, W, val.length)); 
    }
}
