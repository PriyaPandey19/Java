import java.util.*;
public class GreedyAlgorithms {

    public static String getSmallestString(int n,int k){      //smallest string with given sum
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








    public static void activitySelection(int start[],int end[]){      //activity selection problem if ending time is sorted
        int maxAct =0;
        ArrayList<Integer> ans = new  ArrayList<>();

        //1st activity always selected
        maxAct =1;
        ans.add(0);
        int lastEnd = end[0];

        for(int i=1;i<end.length;i++){
          if(start[i] >= lastEnd){
            //activity selected
            maxAct++;
            ans.add(i);
            lastEnd = end[i];
          }
        }
        System.out.println("max activity : "+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }







    public static void activitySelectionNotSorted(int start[],int end[]){     //activity selection problem if ending time is not sorted
           //1. create a 2d array of activities
           //2. sort the array based on ending time
           //3. apply the same logic as above

           //creating 2d array
          int activites[][] = new int[start.length][3];
           for(int i=0;i<start.length;i++){
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
           } 
           
           //lamda function
           Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));

        int maxAct =0;
        ArrayList<Integer> ans = new  ArrayList<>();

        //1st activity always selected
        maxAct =1;
        ans.add(activites[0][0]);
        int lastEnd = activites[0][2];

        for(int i=1;i<end.length;i++){
          if(activites[i][1] >= lastEnd){
            //activity selected
            maxAct++;
            ans.add(activites[i][0]);
            lastEnd = activites[i][2];
          }
        }
        System.out.println("max activity : "+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }




    public static void knapsack(int val[],int weight[],int W){       //knapsack problem
        double ratio[][] = new double[val.length][2];

       for(int i=0;i<val.length;i++){
        //0th col =>idx ; 1st col => ratio
        ratio[i][0] = i;
        ratio[i][1]= val[i]/(double)weight[i];
       }

       //ascending order
       Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

       int capacity = W;
       int finalVal =0;

       for(int i = ratio.length-1;i>=0;i--){
         int idx = (int)ratio[i][0];
         if(capacity >= weight[idx]){    //include full item
            finalVal += val[idx];
            capacity-= weight[idx];
         }
         else{
          //else fractional part
            finalVal += (ratio[i][1]* capacity);
            capacity =0;
            break;
         }
       }
       System.out.println("final val " + finalVal);
    }

    

    public static void minAbsoluteDiff(int A[],int B[]){           //minimum absolute difference of pair
      Arrays.sort(A);
      Arrays.sort(B);

      int minDiff =0;

      for(int i=0;i<A.length;i++){
        minDiff += Math.abs(A[i]-B[i]);
         
      }
      System.out.println("min absolute diff of pair "+ minDiff);
    }





    public static void chainPairs(int pairs[][]){             //chain of pairs
      Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));

      int chainLen =1;
      int chainEnd = pairs[0][1];   //last selected pair

      for(int i=1;i<pairs.length;i++){
        if(pairs[i][0] > chainEnd){   //if next pair start is greater than last selected pair end
          chainLen++;
          chainEnd = pairs[i][1];      //update last selected pair end
        }
      }
      System.out.println("max length of chain " + chainLen);

    }






    public static void minCoins(Integer[] coins ,int amount){     //minimum coins to make given amount
      Arrays.sort(coins, Comparator.reverseOrder());   //sort in descending order

    int countOfCoins =0;
    ArrayList<Integer> ans = new ArrayList<>();

    for(int i=0;i<coins.length;i++){
      if(coins[i] <= amount){                         //if coin is less than amount
        while(coins[i] <= amount){                    //keep adding coins
          countOfCoins++;
          ans.add(coins[i]);
          amount -= coins[i];
        }
      }
    }
    System.out.println("Total sum of coins "+ countOfCoins);
    for(int i=0;i<ans.size();i++){
      System.out.print(ans.get(i) + " ");
    }
  }




    public static void main(String args[]){
    Integer coins[] ={1,2,5,10,20,50,100,500,1000};
    int amount = 1219;
    minCoins(coins, amount);

    }
}
