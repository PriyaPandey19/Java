import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

interface Walkable{               //TOPIC interfaces and internal intefaces
    void walk();

}

interface Runnable{             
    void run();
}

class Human implements Walkable,Runnable{
    public void walk(){
        System.out.println("walk");
    }
    public void run(){
        System.out.println("run");
    }
}


interface A{               
    void display();
}
interface B{               
    void display();
}
class Demo implements A,B{
   public void display(){
    System.out.println("dispaly");
   }

}













public class PractiseSix {
   public static void main(String args[]){
//   Demo obj1 = new Demo();
//   obj1.display();
//   }

int arr[] ={1,2,2,42,4,5,3,53,45,3,5};
//ArrayList<Integer> arr = new ArrayList<>();
//HashSet<String> set = new HashSet<>();
TreeSet<Integer> set = new TreeSet<>();

//long start = System.nanoTime();

//arr.reversed();
//arr.remove(0);
// int count = 0;
// for(int i=0;i<arr.length;i++){
   
//     if(set.contains(arr[i])){
//     System.out.println("duplicate element "+ arr[i]); 
//    count++;   
//     }
//      set.add(arr[i]);
    
// }
// System.out.println(set);
// System.out.println(count);
  

HashMap<Integer, String>map = new HashMap<>();
map.put(1, "my");
map.put(2, "name");
map.put(3, "tiwari");


map.forEach((key,value) -> {
   if(value.equals("tiwari")) {
         System.out.println("Key: " + key + ", Value: " + value);
   }
  
});


// for(int key : map.keySet()){
//     if(key > 2){
//         System.out.println(map.get(key));
//         System.out.println(key);
//     }
//     // System.out.println(key);
// }
//System.out.println(map.remove("a"));
//System.out.println(map.containsKey("i"));
//System.out.println(map.get("id2"));
   }  
}
