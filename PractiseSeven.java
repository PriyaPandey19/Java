import java.util.*;     //topic ArrayList and collections

// class ClgStudent implements Comparable<ClgStudent>{
//     int age;
//     String name;
//   public ClgStudent(int age, String name){
//     this.age = age;
//     this.name = name;
//    }
   
//    public String toString(){
//     return age+" "+name;
//    }

//    //@Override
//    public int compareTo(ClgStudent s){
//     return this.age - s.age;
//    }
// }


class ClgStudent{
    int rolln;
    String name;
    int age;

    public ClgStudent(int rolln,String name, int age){
        this.rolln = rolln;
        this.name = name;
        this.age = age;
    }

       public String toString(){
       return rolln+" "+name+" "+ age;
   }

}

class sortByName implements Comparator<ClgStudent>{       //sort by name
    public int compare(ClgStudent s1, ClgStudent s2){
        return s1.name.compareTo(s2.name); 
    }
}

class sortByAge implements Comparator<ClgStudent>{       //sort by age
    public int compare(ClgStudent s1, ClgStudent s2){
        return Integer.compare(s1.age, s2.age); 
    }
}

class sortByRoll implements Comparator<ClgStudent>{       //sort by rollN
    public int compare(ClgStudent s1, ClgStudent s2){
        return Integer.compare(s1.rolln, s2.rolln); 
    }
}





public class PractiseSeven {

    public static void main(String[] args) {
    ArrayList<ClgStudent> list = new ArrayList<>();
     list.add(new ClgStudent(56, "rahul",12));
     list.add(new ClgStudent(12, "rohit",87));
     list.add(new ClgStudent(91, "rina",62));
    System.out.println("Sort by name ---------");
    Collections.sort(list,new sortByName());
    for(ClgStudent s : list){
        System.out.println(s.toString());
    }



    System.out.println("sort by age--------- ");
    Collections.sort(list,new sortByAge());
    for(ClgStudent s : list){
        System.out.println(s.toString());
    }


     System.out.println("sort by rollN------ ");
    Collections.sort(list,new sortByRoll());
    for(ClgStudent s : list){
        System.out.println(s.toString());
    }
    

   
     




    //  ListIterator<String> it = list.listIterator();
    //  while(it.hasNext()){
    //  String data = it.next();
    //  if(data.length() <= 3){
    //     it.set("bye");
    //  } 
    //  }
    //  System.out.println(list);
     

    //   while (it.hasPrevious()) {
    //      String prevData= it.previous();
    //      if(it.nextIndex() == 0){   
        
    //      }
    //      else{
    //         it.set("hello");
    //      }
    // }
    // System.out.println(list);



    




//      ArrayList<String> list2 = new ArrayList<>();
//      list2.add("ranul");
//      list2.add("shanti");
//      list2.add("mohit");
//      list2.add("rohit");
   

//      ListIterator<String> li = list2.listIterator();
//      while(li.hasNext()){
//    String data = li.next();
//    System.out.println(data);
//      }
//      System.out.println("alag hu  ");
//      while (li.hasPrevious()) {
//         String prevData= li.previous();
//         System.out.println(prevData);
//      }





    }
}
