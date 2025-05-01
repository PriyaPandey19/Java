import java.util.ArrayList;
import java.util.Collections;

public class CustomArrayList {
    public static void ReverseArrayList(){               //reverse the array using arraylist
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.size());

        //print the arrayList
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i));
        }
        System.out.println();
    }


    public static int getMax(){                   //get max elements
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;
    }


    public static void swap(ArrayList<Integer> list,int idx1,int idx2){ //swap 2 numbers
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

    // public static int storeWater(ArrayList<Integer> height){     //store most water brute force solution
    //     int maxWater =0;
    //     //brute force
    //      for(int i=0; i<height.size();i++){
    //         for(int j=0;j<height.size();j++){
    //             int ht = Math.min(height.get(i),height.get(j));
    //             int width = j-i;
    //             int currWater = ht*width;
    //             maxWater = Math.max(maxWater,currWater);
    //         }
    //      }
    //      return maxWater;
    // }

    public static int storeWater(ArrayList<Integer> height){    //store most water 2nd solution
        int maxWater =0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp < rp){
            //calculate water area
            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp-lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            //update ptr
            if(height.get(lp) < height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxWater;
    }


    public static boolean pairSum1(ArrayList<Integer> list, int target){   //sorted array mai target found karna
        int lp =0;
        int rp = list.size()-1;
        while( lp != rp){
            //case1
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
            if(list.get(lp) + list.get(rp)  < target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    } 

    public static boolean pairSum2(ArrayList<Integer> list, int target){ //to find target in roated sorted arraylist
        int bp =-1;
        int n = list.size();
          for(int i=0;i<list.size();i++){
            if(list.get(i) > list.get(i+1)){   //breaking point
                bp=i;
                break;
            }
          }
          int lp = bp+1;  //smallest
          int rp = bp; //largest

          while(lp != rp){
            //case 1
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
             //case 2
            if(list.get(lp) + list.get(rp)< target){
                lp = (lp + 1)%n;
            }
            //case 3
            else{
                rp = (n +rp-1)%n;
            }
          }
          return false;

    }

    public static boolean isMonotonic(ArrayList<Integer> list){
            boolean inc = true;
            boolean dec = true;
            for(int i =0;i<list.size()-1;i++){
                if(list.get(i) > list.get(i+1))
                  inc = false;
                if(list.get(i) < list.get(i+1))
                  dec = false;  
            }
            return inc|| dec;
    }


public static ArrayList<Integer> beautifulAList(int n){
    ArrayList<Integer> ans = new ArrayList<>();
    divideConque(1,1,ans,n);
    return ans;
}
public static void divideConque(int start,int increment,ArrayList<Integer> ans,int n){
    if(start + increment >n) {
        ans.add(start);
        return;
    }
    divideConque(start,  2*increment, ans, n);
    divideConque(start + increment, 2*increment, ans, n);
}

    public static void main(String args[]){
        ArrayList<Integer> list= new ArrayList<>();
        //ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1); list.add(2);
        // mainlist.add(list);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(3); list2.add(4);
        // mainlist.add(list2);

        // for(int i=0;i<mainlist.size();i++){
        //     ArrayList<Integer> currList = mainlist.get(i);   //access elements from mainList list of list
        //     for(int j=0;j<currList.size();j++){
        //         System.out.print(currList.get(j) +" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(mainlist);
        
    //     list.add(1);
    //     list.add(2);
    //     list.add(9);
    //     list.add(0);
    //     list.add(5);
    //  //ReverseArrayList();  
    //  //System.out.println(getMax()); 
    // // int idx1 = 1,idx2 = 3;
  
    // // swap(list, idx1, idx2);
    
    // System.out.println(list);
    //  Collections.sort(list);       //sort using collections
    //  System.out.println(list);


    //  Collections.sort(list,Collections.reverseOrder());      //descending order using sort
    //  System.out.println(list);



    // ArrayList<Integer> list1 = new ArrayList<>();
    // ArrayList<Integer> list2 = new ArrayList<>();
    // ArrayList<Integer> list3 = new ArrayList<>();

    // for(int i=1;i<=5;i++){
    //     list1.add(i*1); //1 2 3 4 5
    //     list2.add(i*2); //2 4 6 8 10
    //     list3.add(i*3); //3 6 9 12 15
    // }
    // mainlist.add(list1);
    // mainlist.add(list2);
    // mainlist.add(list3);

    // System.out.print(mainlist);

    
    list.add(1);
    list.add(2);
    list.add(4);
    list.add(5);
    
    
    System.out.println(beautifulAList(4));


    }
}
