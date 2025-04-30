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
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();

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



    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();

    for(int i=1;i<=5;i++){
        list1.add(i*1); //1 2 3 4 5
        list2.add(i*2); //2 4 6 8 10
        list3.add(i*3); //3 6 9 12 15
    }
    mainlist.add(list1);
    mainlist.add(list2);
    mainlist.add(list3);

    System.out.print(mainlist);

    }
}
