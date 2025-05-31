import java.util.HashMap;
import java.util.Set;

public class HashingB {
   
   public static void main(String args[]){
   HashMap<String, Integer> hm = new HashMap<>();

   
      hm.put("India",100);
      hm.put("china",11);
      hm.put("us", 30);
      hm.put("Nepal", 2);

      Set<String> keys = hm.keySet();
      System.out.println(keys);

      for(String k: keys) {
         System.out.println("key=" +k+",value="+hm.get(k));
      }
      
      
   
}    
}
