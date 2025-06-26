import java.util.Arrays;

public class DynamicProgram2 {

    public static int editDistance(String str1, String str2){    //edit distance
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        //intilize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j] =j;
                }
                  if(j==0){
                    dp[i][j] =i;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){     //same
                 dp[i][j] = dp[i-1][j-1];          //so reduce length of both the string
                } 
                else{                                     //diffrent so add it with +1
                  int add = dp[i][j-1]+1; 
                  int del = dp[i-1][j] +1;
                  int rep = dp[i-1][j-1]+1;
                  dp[i][j] = Math.min(add, Math.min(del, rep));  
                }
            }
        }
        return dp[n][m];
    }


    public static boolean isMatch(String s, String p){    //wildcard matching
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];
        //intilize
        dp[0][0] = true;
        //patter =" "
        for(int i=1;i<n+1;i++){
            dp[i][0] = false;
        }
        //s =" "
        for(int  j=1;j<m+1;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        //bootom up approach
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case ->ith char == jth char || jth char == ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }


    public static int catalnRec(int n){      //catalan using recursion
        if(n ==0 || n == 1){
            return 1;
        }
        int ans =0;
        for(int i=0;i<= n-1;i++){
            ans += catalnRec(i)* catalnRec(n-i-1);
        }
        return ans;
    }


    public static int catalanMem(int n, int dp[]){    //catalan using memoization
        if(n ==0 || n ==1){
            return 1;
        }
        if(dp[n] != -1){
            return  dp[n];
        }
        int ans =0;
        for(int i=0;i<n;i++){
            ans += catalanMem(i, dp) * catalanMem(n-i-1, dp);

        }
        return dp[n] = ans;
    }


    public static int catalanTab(int n){          //catalan using tabulation
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2;i<=n;i++){
        for(int j=0;j<i;j++){
            dp[i] += dp[j]* dp[i-j-1];
        }
    }
    return dp[n];
    }




    public static int countBST(int n){    //count BST tree
        int dp[] = new int[n+1];
        dp[0] =1;
        dp[1] =1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left *right;
            }
        }
        return dp[n];
    }


    public static int mountainRanges(int n){    // mountain ranges
        int dp[] = new int[n+1];
        dp[0] =1;
        dp[1] =1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside *outside;
            }
        }
        return dp[n];
    }








    public static void main(String[] args) {
    String word1 ="intention";
    String word2 = "execution";
    System.out.println(editDistance(word1, word2));


    String s = "abc";
    String p = "**d";
    System.out.println(isMatch(s, p));

    int n =4;
    int dp[] = new int[n+1];
    Arrays.fill(dp,-1);
    System.out.println(catalanMem(n, dp));

    System.out.println(catalanTab(30));

    int m =3;
    System.out.println(countBST(m));

    int h =4;
    System.out.println(mountainRanges(h));
    }
}
