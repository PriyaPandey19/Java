import java.util.*;
// interface Walkable{               //TOPIC interfaces and internal intefaces
//     void walk();

// }

// interface Runnable{             
//     void run();
// }

// class Human implements Walkable,Runnable{
//     public void walk(){
//         System.out.println("walk");
//     }
//     public void run(){
//         System.out.println("run");
//     }
// }


// interface A{               
//     void display();
// }
// interface B{               
//     void display();
// }
// class Demo implements A,B{
//    public void display(){
//     System.out.println("dispaly");
//    }

// }














public class PractiseSix {







public static void firstNonrepeating(){
 HashMap<Character, Integer>map = new HashMap<>(); 
 String str = "aaabcccdddeeef";
char[] ch = str.toCharArray();
 for(char i : ch){
     map.put(i, map.getOrDefault(i, 0)+1);
       
 }
 for(char i : ch){
    if(map.get(i) == 1){
        System.out.println("first non repeating "+ i);
        return;
    }
 }
 System.out.println("no one repeating");
}



   public static void main(String args[]){
    firstNonrepeating();
//   Demo obj1 = new Demo();
//   obj1.display();
//   }

//String arr ={1,2,2,42,4,5,3,53,45,3,5};
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
  



// map.forEach((key,value) -> {
//    if(value.equals("tiwari")) {
//          System.out.println("Key: " + key + ", Value: " + value);
//    }
  
// });




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



// HashMap<Character, Integer>map = new HashMap<>();       //to counnt occurance  of alphabetusing hashmap
// String str = "programming";
// char[] ch = str.toCharArray();
// for(char i : ch){
//     map.put(i, map.getOrDefault(i, 0)+1);
// }
// System.out.println(map);
//    }  
// }



// HashMap<String, Integer>map = new HashMap<>();       //to count occuranceusing of words using hashmap
// String str = "programming is fun and fun is programming";
// String[] word = str.split(" ");
// for(String words : word){
// map.put(words, map.getOrDefault(word, 0)+1);
// }

// System.out.println(map);


   }
   }