import java.util.*;

public class HashingB {

    public static void majorityElements(int arr[]){       //majority element in array if greater than n/3
     HashMap<Integer,Integer> map = new HashMap<>();

     for(int i=0;i<arr.length;i++){
       map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
     }
     
     for(Integer key : map.keySet()){
        if(map.get(key) > arr.length/3){
            System.out.println(key);
        }
     }
    }




    public static boolean isAnagram(String s, String t){      //to check whether it is anagram or not
        if(s.length() != t.length()){
            return false;
        }                                                        
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                map.remove(ch);
                }
                 else{
                map.put(ch, map.get(ch)-1);
            }
        }
            else{
                return false;
            }
        }
        return map.isEmpty();
    }


    public static void interSectionUnion(int arr1[],int arr2[]){    //union and intersection of two array
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
           set.add(arr1[i]);
        }
         for(int i=0;i<arr2.length;i++){
           set.add(arr2[i]);
        }
       for(int val : set){
        System.out.println("union -"+ val);
       }

        //intersection
        set.clear();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int count =0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
               // count++;
                System.out.println("intersection -"+ arr2[i]);     
                set.remove(arr2[i]);
            }
        }
       // System.out.println("intersection "+ count);


    }






    public static void main(String[] args) {
     int arr[]= {1,3,2,5,1,3,1,5,1};
     majorityElements(arr); 
     String s = "race";
     String t = "care";  
     System.out.println(isAnagram(s, t));

     int arr1[] ={7,3,9};
     int arr2[] ={6,3,9,2,9,4};
     interSectionUnion(arr1, arr2);
    
    }
}
