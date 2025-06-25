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


    public static boolean isMatch(String s, String p){
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



    public static void main(String[] args) {
    String word1 ="intention";
    String word2 = "execution";
    System.out.println(editDistance(word1, word2));


    String s = "abc";
    String p = "**d";
    System.out.println(isMatch(s, p));
    }
}
