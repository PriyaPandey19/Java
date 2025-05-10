import java.util.*;
public class GreedyAlgorithms {

    public static String getSmallestString(int n,int k){
        char[] res = new char[n];
        Arrays.fill(res,'a');
        k -= n;

        while(k>0){
            if(k >= 25){
                res[n-1] += 25;
                k-=25;
            }
            else{
                res[n-1] += k;
                k =0;
            }
            n-=1;
        }
        return String.valueOf(res);

    }


    public static void main(String args[]){
        int n =5,k=73;
        System.out.println(getSmallestString(n, k));

    }
}
