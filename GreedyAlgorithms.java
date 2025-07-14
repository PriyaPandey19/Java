import java.util.*;

public class GreedyAlgorithms {

  public static String getSmallestString(int n, int k) { //  lexicographically smallest string of length with given sum
    char[] res = new char[n];
    Arrays.fill(res, 'a');
    k -= n;

    while (k > 0) {
      if (k >= 25) {
        res[n - 1] += 25;
        k -= 25;
      } else {
        res[n - 1] += k;
        k = 0;
      }
      n -= 1;
    }
    return String.valueOf(res);

  }







  public static void activitySelection(int start[], int end[]) { // activity selection problem if ending time is sorted
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    // 1st activity always selected
    maxAct = 1;
    ans.add(0);
    int lastEnd = end[0];

    for (int i = 1; i < end.length; i++) {
      if (start[i] >= lastEnd) {
        // activity selected
        maxAct++;
        ans.add(i);
        lastEnd = end[i];
      }
    }
    System.out.println("max activity : " + maxAct);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print("A" + ans.get(i) + " ");
    }
    System.out.println();
  }

  public static void activitySelectionNotSorted(int start[], int end[]) { // activity selection problem if ending time
                                                                          // is not sorted
    // 1. create a 2d array of activities
    // 2. sort the array based on ending time
    // 3. apply the same logic as above

    // creating 2d array
    int activites[][] = new int[start.length][3];
    for (int i = 0; i < start.length; i++) {
      activites[i][0] = i;
      activites[i][1] = start[i];
      activites[i][2] = end[i];
    }

    // lamda function
    Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));

    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    // 1st activity always selected
    maxAct = 1;
    ans.add(activites[0][0]);
    int lastEnd = activites[0][2];

    for (int i = 1; i < end.length; i++) {
      if (activites[i][1] >= lastEnd) {
        // activity selected
        maxAct++;
        ans.add(activites[i][0]);
        lastEnd = activites[i][2];
      }
    }
    System.out.println("max activity : " + maxAct);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print("A" + ans.get(i) + " ");
    }
    System.out.println();
  }

  public static void knapsack(int val[], int weight[], int W) { // knapsack problem
    double ratio[][] = new double[val.length][2];

    for (int i = 0; i < val.length; i++) {
      // 0th col =>idx ; 1st col => ratio
      ratio[i][0] = i;
      ratio[i][1] = val[i] / (double) weight[i];
    }

    // ascending order
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    int capacity = W;
    int finalVal = 0;

    for (int i = ratio.length - 1; i >= 0; i--) {
      int idx = (int) ratio[i][0];
      if (capacity >= weight[idx]) { // include full item
        finalVal += val[idx];
        capacity -= weight[idx];
      } else {
        // else fractional part
        finalVal += (ratio[i][1] * capacity);
        capacity = 0;
        break;
      }
    }
    System.out.println("final val " + finalVal);
  }

  public static void minAbsoluteDiff(int A[], int B[]) { // minimum absolute difference of pair
    Arrays.sort(A);
    Arrays.sort(B);

    int minDiff = 0;

    for (int i = 0; i < A.length; i++) {
      minDiff += Math.abs(A[i] - B[i]);

    }
    System.out.println("min absolute diff of pair " + minDiff);
  }

  public static void chainPairs(int pairs[][]) { // chain of pairs
    Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    int chainLen = 1;
    int chainEnd = pairs[0][1]; // last selected pair

    for (int i = 1; i < pairs.length; i++) {
      if (pairs[i][0] > chainEnd) { // if next pair start is greater than last selected pair end
        chainLen++;
        chainEnd = pairs[i][1]; // update last selected pair end
      }
    }
    System.out.println("max length of chain " + chainLen);

  }

  public static void minCoins(Integer[] coins, int amount) { // minimum coins to make given amount
    Arrays.sort(coins, Comparator.reverseOrder()); // sort in descending order

    int countOfCoins = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amount) { // if coin is less than amount
        while (coins[i] <= amount) { // keep adding coins
          countOfCoins++;
          ans.add(coins[i]);
          amount -= coins[i];
        }
      }
    }
    System.out.println("Total sum of coins " + countOfCoins);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }
  }

  static class Job {
    int deadline;
    int profit;
    int id;

    public Job(int i, int d, int p) {
      id = i;
      deadline = d;
      profit = p;
    }
  }

  public static void jobSequencing(int jobsInfo[][]) { // job sequencing problem
    ArrayList<Job> jobs = new ArrayList<>();

    for (int i = 0; i < jobsInfo.length; i++) {
      jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
    }
    Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // sort the object in descending order of profit

    ArrayList<Integer> seq = new ArrayList<>();
    int time = 0;
    for (int i = 0; i < jobs.size(); i++) {
      Job curr = jobs.get(i);

      if (curr.deadline > time) { // if deadline is greater than time
        seq.add(curr.id); // add job id to the sequence
        time++;
      }
    }

    System.out.println("max jobs =" + seq.size());
    for (int i = 0; i < seq.size(); i++) {
      System.out.println(seq.get(i) + " ");
    }

  }

  public static void chocolaProblem(Integer costVer[], Integer costHor[]) { // chocola problem

    Arrays.sort(costVer, Collections.reverseOrder());
    Arrays.sort(costHor, Collections.reverseOrder());

    int h = 0, v = 0;
    int hp = 1, vp = 1;
    int cost = 0;

    while (h < costHor.length && v < costVer.length) {
      if (costVer[v] <= costHor[h]) { // horizontal cut
        cost += (costHor[h] * vp); //
        hp++;
        h++;
      } else {
        cost += (costVer[v] * hp); // vertical cut
        vp++;
        v++;
      }
    }

    while (h < costHor.length) {
      cost += (costHor[h] * vp);
      hp++;
      h++;
    }
    while (v < costVer.length) {
      cost += (costVer[v] * hp);
      vp++;
      v++;
    }
    System.out.println("min cost of cuts " + cost);

  }



  public static int BalancedPartition(String str, int n){     // balanced partition  example "LLRRRLLRRL" ==> 4
    if(n == 0){
      return 0;
    }  
    int r=0,l=0;
    int ans =0;

    for(int i=0;i<n;i++){
      if(str.charAt(i) == 'R'){
        r++;
      }
      else if(str.charAt(i) == 'L'){
        l++;
      }
      if(r == l){
        ans++;
      }
    }
    return ans;
  }


  public static int kthOdd(int range[],int k){      // kth odd number in range from backward
    if(k <= 0){
      return 0;
    }
    int L = range[0];
    int R = range[1];

    if((R & 1) > 0){
      int count = (int)Math.ceil((R- L + 1)/2);
      if(k > count)
        return 0;
      
      else
        return (R - 2 * k+ 2);
  
    }
    else{
       int count = (R- L + 1)/2;
      if(k > count)
        return 0;
      
      else
        return (R - 2 * k+ 1);
    }
  }




  

  public static int ans = 10000000;
  public static void calculateMinSubarraySum(int a[],int n, int k, int index,int sum,int maxSum){    //calcuate min subarray sum
    if(k == 1){                                //base case                                              that is divided into k parts
      maxSum = Math.max(maxSum, sum);
      sum =0;
      for(int i= index;i<n;i++){
        sum += a[i];
      }
      maxSum = Math.max(maxSum,sum);
      ans = Math.min(ans,maxSum);
      return;
    }
    sum =0;
    for(int i= index;i<n;i++){
      sum += a[i];
      maxSum = Math.max(maxSum, sum);
      calculateMinSubarraySum(a, n, k-1, i+1, sum, maxSum);
    }
  }
  
  




  public static void main(String args[]) {              // main function
    // Integer coins[] ={1,2,5,10,20,50,100,500,1000};
    // int amount = 1219;
    // minCoins(coins, amount);

    // int jobsInfo[][] ={{4,20},{1,10},{1,40},{1,30}};
    // jobSequencing(jobsInfo);

    // int n = 5, m = 6;
    // Integer costVer[] = { 2, 1, 3, 1, 4 };
    // Integer costHor[] = { 4, 1, 2 };
    // chocolaProblem(costVer, costHor);

    // String str = "LLRRRLLRRL";
    // int n = str.length();

    // System.out.println(BalancedPartition(str, n) + " ");

    int arr[] ={1,2,3,4};
    int k =3;
    int n = 4;
    calculateMinSubarraySum(arr, n, k, 0, 0, 0);
    System.out.println("min subarray sum " + ans);



  }
}
