import java.util.PriorityQueue;

public class PriorityQueueD {
  static class Student implements Comparable<Student>{ //overriding   comparision basis on student rank
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




  static class Point implements Comparable<Point>{     //nearest car from origin
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x,int y,int distSq,int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){    //ascending order 
          return this.distSq - p2.distSq;
        }
    }






    static class Row implements Comparable<Row> {     //weakest soldier
     int soldiers;
     int idx;
     
     public Row(int soldiers, int idx){
      this.soldiers = soldiers;
      this.idx = idx;
     }

     @Override
     public int compareTo(Row r2){
      if(this.soldiers == r2.soldiers){     //agar soldier same hai to unke idx ke based per sort karo
        return this.idx - r2.idx;
      }
      else{
        return this.soldiers - r2.soldiers;      //agar soldier same nhi hai to unke based per sort karo
      }
     }
    }



  public static void main(String args[]){
   int army[][] ={{1,0,0,0},                            //weakest soldier main function
                  {1,1,1,1},
                  {1,0,0,0},
                  {1,0,0,0}};
  int k =2;
  PriorityQueue<Row> pq3 = new PriorityQueue<>();
  for(int i=0;i<army.length;i++){
   int count =0;
   for(int j=0;j<army[0].length;j++){
    count += army[i][j] == 1? 1:0;
   }
   pq3.add(new Row(count, i));
  }
  for(int i=0;i<k;i++){
    System.out.println("R"+ pq3.remove().idx);
  }








    int pts[][] ={{3,3},{5,-1},{-2,4}};                            //nearest car main function
    //int k =2;
   
    PriorityQueue<Point> pq1 = new PriorityQueue<>();
    for(int i=0;i<pts.length;i++){
      int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
      pq1.add(new Point(pts[i][0], pts[i][1], distSq,i));
    }
    
    //nearest k cars
    for(int i=0;i<k;i++){
      System.out.println("C"+ pq1.remove().idx);
    }









    PriorityQueue<Student> pq  = new PriorityQueue<>();        //student class main function
     
   pq.add(new Student("A",2));
   pq.add(new Student("B",1));
    pq.add(new Student("C",3));  

    while (!pq.isEmpty()) {
    System.out.println(pq.peek().name + "->" + pq.peek().rank);  
    pq.remove();
    }





    int ropes[] ={2,3,3,4,6};                         //min cost of connecting n ropes
    PriorityQueue<Integer> pq2 = new PriorityQueue<>();
    for(int i=0;i<ropes.length;i++){
      pq2.add(ropes[i]);
    }

    int cost =0;
    while (pq2.size() > 1) {
     int min = pq2.remove();
     int min2 = pq2.remove();
     cost += min+min2;
     pq2.add(min + min2);
    }
    System.out.println("cost of conecting n ropes "+ cost);
  }  
}
