import java.util.*;

public class DynamicProgram2 {

    public static int editDistance(String str1, String str2) { // edit distance
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        // intilize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same
                    dp[i][j] = dp[i - 1][j - 1]; // so reduce length of both the string
                } else { // diffrent so add it with +1
                    int add = dp[i][j - 1] + 1;
                    int del = dp[i - 1][j] + 1;
                    int rep = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }
        return dp[n][m];
    }

    public static boolean isMatch(String s, String p) { // wildcard matching
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        // intilize
        dp[0][0] = true;
        // patter =" "
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // s =" "
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // bootom up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // case ->ith char == jth char || jth char == ?
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static int catalnRec(int n) { // catalan using recursion
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalnRec(i) * catalnRec(n - i - 1);
        }
        return ans;
    }

    public static int catalanMem(int n, int dp[]) { // catalan using memoization
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMem(i, dp) * catalanMem(n - i - 1, dp);

        }
        return dp[n] = ans;
    }

    public static int catalanTab(int n) { // catalan using tabulation
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static int countBST(int n) { // count BST tree
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    public static int mountainRanges(int n) { // mountain ranges using tabulation
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside;
            }
        }
        return dp[n];
    }

    public static int mcm(int arr[], int i, int j) { // mcm using recursion
        if (i == j) { // base case single matrix
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k); // Ai....Ak => arr[i-1]*arr[k]
            int cost2 = mcm(arr, k + 1, j); // Ai+1......Aj => arr[k]*arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    public static int mcmMem(int arr[], int i, int j, int dp[][]) { // mcm using memoization
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }
        return dp[i][j] = ans;
    }

    public static int mcmTab(int arr[]) {       //mcm using tabulation
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initilization
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        print(dp);
        return dp[1][n - 1];
    }

    public static void print(int dp[][]){             //print function
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int minPartition(int arr[]){     //min patition using tabulation
        int n = arr.length;
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }

        int W = sum/2;            //bag weight exactly half to find min diffrence btw them

        int dp[][] = new int[n+1][W+1];

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(arr[i-1] <= j){    //include
                    dp[i][j]= Math.max(arr[i-1] +dp[i-1][j-arr[i-1]] , dp[i-1][j]);
                }
                else{     //exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];      //2d array
        if( sum %2 == 0 && sum1 == sum/2){
          System.out.println("TRUE");
        }
        else{
            System.out.println("FALSE");
        }
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

     public static int  minJumps(int nums[]){          //min jumps to reach i=0 to i= n-1
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] =0;

        for(int i=n-2;i>=0;i--){
            int steps = nums[i];
            int ans =Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps && j<n;j++){
              if(dp[j] != -1){
                ans = Math.min(ans, dp[j]+1);
              }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        return dp[0];
     }


    public static void main(String[] args) {
       int nums[] ={2,3,1,1,4};
        System.out.println(minJumps(nums));
    }
}
