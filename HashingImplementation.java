import java.util.*;

public class HashingImplementation {                    //implementstion of hashMap from scratch
   static class HashMap<K,V> {   //generic means we don't know the data type
      private class Node{
      K key;
      V value;

      public Node(K key, V value){
         this.key = key;
         this.value = value;
      }
      }
      
      private int n;
      private int N;
      private LinkedList<Node> buckets[];   //array of linked list

      public HashMap(){
         this.N=4;
         this.buckets = new LinkedList[4];   //khali bucket of linked list
         for(int i=0;i<4;i++){
            this.buckets[i] = new LinkedList<>();
         }
      }

      private int hashFunction(K key){          //this is the hash code function that will return idx
       int hc = key.hashCode();
       return Math.abs(hc) % N;
      }

      private int SearchInLL(K key,int bi){        //this is the function to search node at given idx
         LinkedList<Node> ll = buckets[bi];
         int di =0;
         
         for(int i=0;i<ll.size();i++){
            Node node = ll.get(i);
            if(node.key == key){
               return di;
            }
            di++;
         }
         return -1;
      }



      private void rehash(){                         //rehash function
         LinkedList<Node> oldBuck[] = buckets;
         buckets = new LinkedList[N*2];    //create new bucket with double size
         N = 2*N;
         for(int i=0;i<buckets.length;i++){
            buckets[i] = new LinkedList<>();
         }
          //nodes-> add in bucket
        for(int i=0;i<oldBuck.length;i++){
         LinkedList<Node> ll = oldBuck[i];
         for(int j=0;j<ll.size();j++){
            Node node = ll.get(j);    
            put(node.key, node.value);
         }
        }
      }


      public void put(K key, V value){       //to put the node in LL if not present or update the value
         int bi = hashFunction(key);
         int di = SearchInLL(key,bi);

         if(di != -1){
            Node node = buckets[bi].get(di);  //update the value if present
            node.value = value;
         }
         else{
            buckets[bi].add(new Node(key,value));   //add new node
            n++;
         }
        
         double lambda = (double)n/N;   //lambda is greater than k so call the rehash function
         if(lambda > 2.0){
            rehash();
         }
      }



      public boolean containsKey(K key){    //to check whether key contains or not 
         int bi = hashFunction(key);
         int di = SearchInLL(key,bi);

         if(di != -1){   //valid
           return true;
         }
         else{
           return false;
         }

      }



      public V get(K key){                        //to get the value at specific idx
         int bi = hashFunction(key);
         int di = SearchInLL(key,bi);

         if(di != -1){
            Node node = buckets[bi].get(di);  // valid value so return value
            return node.value;
         }
         else{
           return null;
         }  
      }





      public V remove(K key){            //to remove the value at specific idx
         int bi = hashFunction(key);
         int di = SearchInLL(key,bi);

         if(di != -1){
            Node node = buckets[bi].remove(di);  //remove the value and decresase the size
            n--;
            return node.value;
         }
         else{
            return null;
         }
      }

     public ArrayList<K> keySet(){               //to print key using arrayList
      ArrayList<K> keys = new ArrayList<>();

      for(int i=0;i<buckets.length;i++){
         LinkedList<Node> ll = buckets[i];
         for(Node node : ll){
            keys.add(node.key);
         }
      }
      return keys;
     }

     public boolean isEmpty(){      //to check whwtwer it is empty or not
      return n==0;
     }
   }





   
   public static void main(String args[]){
      HashMap<String, Integer> hm= new HashMap<>();
      hm.put("India",100);
      hm.put("China",150);
      hm.put("US",50);
      hm.put("Nepal",5);

      ArrayList<String> keys = hm.keySet();
      for(String key : keys){
         System.out.println(key);
      }

      System.out.println(hm.get("India"));
      System.out.println(hm.remove("India"));
      System.out.println(hm.get("India"));
   // HashMap<String, Integer> hm = new HashMap<>();

   
   //    hm.put("India",100);
   //    hm.put("china",11);
   //    hm.put("us", 30);
   //    hm.put("Nepal", 2);

   //    Set<String> keys = hm.keySet();
   //    System.out.println(keys);

   //    for(String k: keys) {
   //       System.out.println("key=" +k+",value="+hm.get(k));
   //    }
      
      
   
}    
}
