import java.util.PriorityQueue;

public class PriorityQueueD {
  static class Student implements Comparable<Student>{ //overriding
   String name;
   int rank;

   public Student(String name, int rank){
    this.name = name;
    this.rank = rank;
   }
   @Override
   public int compareTo(Student s2){     //compare 2 objects
    return this.rank - s2.rank;
   }
  }


  public static void main(String args[]){
    PriorityQueue<Student> pq  = new PriorityQueue<>();
     
   pq.add(new Student("A",2));
   pq.add(new Student("B",1));
    pq.add(new Student("C",3));  

    while (!pq.isEmpty()) {
    System.out.println(pq.peek().name + "->" + pq.peek().rank);  
    pq.remove();
    }
  }  
}
