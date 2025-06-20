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

     public static int countWays1(int n){      //using tabulation

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

    

    





    public static void main(String[] args) {
     int n = 5;
     int f[] = new int[n+1];
     //System.out.println(fibTabulation(n,f));  
    Arrays.fill(f,-1);
     System.out.println(countWays1(n)); 
    }
}
