//import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysCC {
    public static int linearSearch(int numbers[], int key) { // linear search
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int getLargest(int numbers[]) { // get largest
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }
        return largest;
    }

    public static int binarySearch(int numbers[], int key) { // binary search
        int start = 0;
        int end = numbers.length - 1;

        for (int i = 0; i < numbers.length; i++) {
            int mid = (start + end) / 2;

            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverse(int numbers[]) { // reverse array
        int first = 0, last = numbers.length - 1;

        while (first < last) {
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            first++;
            last--;
        }
    }

    public static void Pair(int numbers[]) { // pair of numbers
        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + curr + "," + numbers[j] + ")");
            }
            System.out.println();
        }
    }

    public static void printSubarrays(int numbers[]) { // larget and smallest subarrays sum
        int sum = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(numbers[k] + " ");
                    sum = sum + numbers[k];
                }
                System.out.println();
                System.out.println("sum of subarray is " + sum);
                if (largest < sum) {
                    largest = sum;
                }
                if (smallest > sum) {
                    smallest = sum;
                }
            }
            System.out.println();
        }

        System.out.println("largest sum is " + largest);
        System.out.println("smallest sum is " + smallest);
    }

    public static void maxSubarraySum(int numbers[]) { // 0(n^2) time complexity
        int currsum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        // calcuate prefix array
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = 1; j < numbers.length; j++) {
                int end = j;

                currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (maxSum < currsum) {
                    maxSum = currsum;
                }
            }
        }
        System.out.println("max sum:    " + maxSum);
    }

    public static void kadanes(int numbers[]) { // kadanes algorithm to find max subarray sum
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("our max subarray is: " + ms);
    }

    public static void Occurence(int numbers[]) {      // to find occurance of element

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            boolean counted = false;

            for (int k = 0; k < i; k++) {
                if (numbers[i] == numbers[k]) {
                    counted = true;
                    break;
                }
            }
            if (counted)
                continue;

            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
            System.out.println(numbers[i] + " ocuured " + count + " times ");

        }

    }

    public static int check(int numbers[], int target) { // to find the index of target element in fully sorted array
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] == target) {
                return mid;
            }
            if (numbers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) { // left half or right half is sorted array
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // left half is sorted
            else if (nums[lo] <= nums[mid]) {
                // target lies is the left half
                if (nums[lo] <= target && target <= nums[mid]) {
                    hi = mid - 1;
                } else // target lies in the right half
                {
                    lo = mid + 1;
                }
            } else // right half is sorted
            {
                // target is in right half
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else // target is in left half
                {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int trappedRainWater(int height[]) { // trapped rain water problem
        int n = height.length;

        // calculate left max boundary
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }

        // calculate right max
        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }

        int trappedwater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftmax[i], rightmax[i]);
            // trapped water = wterLevel - height[i]
            trappedwater += waterLevel - height[i];
        }
        return trappedwater;
    }

    public static int buyAndSellStock(int prices[]) { // buy and sell stock problem
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }


    public int[] plusOne(int[] digits) {            //plus one number to array
        int n = digits.length;

        for(int i = n-1;i>=0;i--){   //traverse the array from last
            if(digits[i] < 9){
            digits[i]++;         //value is less than 9 so only increment
            return digits;
        }
        digits[i] =0;
        }

        int[] result = new int[n+1];   //if 9 is there so we need to insert 1 at position 0
        result[0] = 1;
        return result;

    }

    public static int singleNumber(int[] nums) {   //return that number that does not repeat in array
      int result =0;
      for(int num :nums){
      result ^= num;
      }  
      return result;
    }


    public boolean containsDuplicate(int[] nums) {     //return true if duplicate are there
     Set<Integer> seen = new HashSet<>();
     for(int num : nums){
        if(seen.contains(num)){            //if eleemnts are there so return true
            return true;
        }
        seen.add(num);                    //otherwise add in hashset
     }   
     return false;
    }

     public  static int missingNumber(int[] nums) {       //find missing number in array
       int n = nums.length;
       int expectedSum = n*(n+1)/2;        //expected sum 3+0+1+2 = 6

       int actualSum =0;
       for(int num : nums){
        actualSum += num;                   //actual sum 3+0+1 = 4
       }  
       return expectedSum - actualSum;        //so diffrence is ans = 6-4 =2
    }

     public static int thirdMax(int[] nums) {    //find the 3 max elements
       Arrays.sort(nums);      //we will sort the elements
       int distinctCount = 1;   
       int n = nums.length;

       for(int i=n-2;i>=0;i--){
        if(nums[i] != nums[i+1]){    //if we found the distinct count so increase its value
            distinctCount++;  
            if(distinctCount == 3){          //if we found the elements so return value
                return nums[i];
            }
        }
       }
       return nums[n-1];   
    }



     public void moveZeroes(int[] nums) {     //move all zeroes to the end of array
       int insertPos = 0;                      //starting idx  with 0;

       for(int num : nums){
        if(num != 0){           //if current element is not zero than add it in 0th idx and move the idx further 
            nums[insertPos++] = num;
        }
       } 
       while(insertPos < nums.length){
        nums[insertPos++] =0;
       }
    }


     public List<Integer> findDisappearedNumbers(int[] nums) {    //find disappeared numbers
      //we will use the index of the array to mark the numbers that are present
      List<Integer> result = new ArrayList<>();   

      for(int i=0;i<nums.length;i++){
        int index = Math.abs(nums[i]) -1;  //get the index of the number
        //if the number is positive, we will mark it as negative to indicate that it is present
        //if it is already negative, it means we have seen this number before
        if(nums [index] > 0){
            nums[index] = -nums[index];
        }
      }  
      for(int i=0;i<nums.length;i++){
        if(nums[i] > 0){
            result.add(i+1);
        }
      }
      return result;
    }

    public  static int maximumProduct(int[] nums) {    //find maximum product of three numbers
        Arrays.sort(nums);
        int n = nums.length;

        int product1 = nums[n-1] * nums[n-2] * nums[n-3];   //as last 3 digits are largest so multiply them

        //this is done to handle the case where we have two negative numbers and one positive number
        int product2 = nums[0] * nums[1] * nums[n-1];   //as first 2 digits are smallest and last digit is largest so multiply them

        return Math.max(product1, product2);
    }

    public static void main(String args[]) {            //main function
        int height[] = { 2,2,1 };
        System.out.println((height));
        // int height[] ={4,2,0,6,3,2,5};
        // int prices[] ={7,1,5,3,6,4};ṇ
        // int numbers[] = {2,4,6,8,4,1};
        // int key =10;
        // int index = linearSearch(numbers, key);
        // if(index == -1){
        // System.out.println("not found");
        // }
        // else{
        // System.out.println("found"+index );
        // }
        // reverse(numbers);
        // for(int i=0;i<numbers.length;i++){
        // System.out.println(numbers[i]);
        // }

        // Pair(numbers);
        // maxSubarraySum(numbers);
        // System.out.println(check(numbers,8));
        // System.out.println(linearSearch(numbers, 6));
        // System.out.println(buyAndSellStock(prices));

        //Occurence(height);
    }
}
