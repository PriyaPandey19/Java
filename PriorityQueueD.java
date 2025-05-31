import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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





    static class Pair implements Comparable<Pair>{          //sliding window problem
      int val;
      int idx;

      public Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
      }

      @Override
      public int compareTo(Pair p2){
        //descending order
        return p2.val - this.val;
      }

    } 





    static class Node implements Comparable<Node>{
        int row,col,effort;

        Node(int row,int col,int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
        public int compareTo(Node other){
            return this.effort - other.effort;
        }
    }

     public static int minimumEffortPath(int[][] heights) {     //path with min effort
            int rows = heights.length,cols = heights[0].length;
            boolean[][] vis = new boolean [rows][cols];

            //top,right,down,left
            int[] dr ={-1,0,+1,0};
            int[] dc = {0,+1,0,-1};

            Queue<Node> q = new PriorityQueue<>();
            q.add(new Node(0,0,0));

            while(q.size() != 0) {
                Node node = q.remove();
                int sr = node.row, sc = node.col;
                vis[sr][sc] = true;
                int effort = node.effort;

                if(sr == rows-1 && sc == cols-1) return effort;

                for(int idx =0;idx<4;idx++){
                    int nr = sr + dr[idx];
                    int nc = sc+ dc[idx];

                    if(nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;  //out of boundary
                    if(vis[nr][nc] == true) continue;

                    int diff = Math.abs(heights[nr][nc] - heights[sr][sc]);
                    q.add(new Node (nr,nc,Math.max(effort, diff)));
                }
            } 
            return 0;
    }









    static PriorityQueue<Integer> min;       //kth largest element in stream of integer
    static int t;

    static List<Integer>getAllKthNumber(int arr[]){
      List<Integer> list = new ArrayList<>();
      for(int val : arr){
        if(min.size() < t)      //add elements in priority queue till size t
            min.add(val);
        else{
          if(val > min.peek()){    
            min.poll();           //this will give min value and at last add current value in pq
            min.add(val);
          }
        }
        if(min.size() >=t)          //we obtain smallest kth element that is in peek
          list.add(min.peek());
        else
           list.add(-1);

      }
      return list;
    }



    


  public static void minTime(int arr[],int n,int k){     //min time to fill slots
  Queue<Integer> q = new LinkedList<>();

  boolean vis[] = new boolean[n+1];
  int time =0;

  for(int i=0;i<k;i++){
    q.add(arr[i]);
  vis[arr[i]] =true;
  }

  while (q.size() > 0) {
   for(int i=0;i<q.size();i++) {
    int curr = q.poll();
    if(curr-1 >= 1 && !vis[curr-1]){  //adding of the left side element 
        vis[curr-1] = true;
        q.add(curr-1);
    }
    if(curr+1 <= n && !vis[curr+1]){   //adding of the right side element
        vis[curr+1] = true;
        q.add(curr+1);
    }
   }
   time++;
  }
  System.out.println(time -1);
}













static class ListNode{      
  int data;
  ListNode next;

  ListNode(int key){
    data = key;
    next = null;
  }
}


static class ListNodeComparator implements Comparator<ListNode>{
  public int compare(ListNode k1, ListNode k2){
    if(k1.data > k2.data)
        return 1;
  
    else if(k1.data < k2.data)
        return -1;
    return 0;
  }
}

static ListNode mergeKlist(ListNode[] arr, int k){              //merge k linked list in ascneding order
  PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListNodeComparator());
 ListNode at[] = new ListNode[k];
  ListNode head = new ListNode(0);
  ListNode last = head;

  for(int i=0;i<k;i++){    //intialize priority queue with nodes of each
    if(arr[i] != null){
      queue.add(arr[i]);
    }
  }

  if(queue.isEmpty()){
    return null;
  }

  while (!queue.isEmpty()) {
    ListNode curr = queue.poll();
    last.next = curr;
    last = last.next;
    if(curr.next != null){
      queue.add(curr.next);
    } 
  }
  return head.next;
}

public static void printList(ListNode node){     //to print LL
  while (node!= null) {
    System.out.println(node.data+ " ");
    node = node.next;
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








    int arr[] = {1,3,-1,-3,5,3,6,7};                     //sliding window main function
    int p =3;  //window size
    int res[] =new int[arr.length-p+1]; //n-k+1

    PriorityQueue<Pair> pq4 = new PriorityQueue<>();

    //1st window
    for(int i=0;i<p;i++){
      pq4.add(new Pair(arr[i], i));
    }
   res[0] = pq4.peek().val;

   //rest window
   for(int i=p;i<arr.length;i++){
    while (pq4.size() > 0 && pq4.peek().idx <= (i-p)) {    //remove the elements if they are not in window
     pq4.remove();
    }
    pq4.add(new Pair(arr[i], i));                     //add current element
    res[i-p+1] = pq4.peek().val;
   }

   for(int i=0;i<res.length;i++){
    System.out.print(res[i] +" ");
   } 
   System.out.println(); 






int heights[][] ={{1,2,2},{3,8,2},{5,3,5}};      //main function path with min efforts
  System.out.println(minimumEffortPath(heights)); 








  min = new PriorityQueue<>();        //kth largest element in a stream main fumction
  t=3;
  int arr1[] = {1,2,3,4,5,6};
  List<Integer>res1 = getAllKthNumber(arr1);
  for(int x :res1){
    System.out.println(x +" ");
  }



  int n = 6;                                     //min time to fill slot main function
  int arr2[] ={2,6};
   int u = arr2.length;
  System.out.print("min time: ");
  minTime(arr2,n,u);




  int N = 3;                                    //merge k linked list main function
  ListNode[] a = new ListNode[N];
  ListNode head1 = new ListNode(1);
  a[0] = head1;                         //1 Linked list
  head1.next = new ListNode(3);
  head1.next.next = new ListNode(5);
  head1.next.next.next = new ListNode(7);


   ListNode head2 = new ListNode(2);
  a[1] = head2;                         //2 Linked list
  head2.next = new ListNode(4);
  head2.next.next = new ListNode(6);
  head2.next.next.next = new ListNode(8);


   ListNode head3 = new ListNode(0);
  a[2] = head3;                         //3 Linked list
  head3.next = new ListNode(9);
  head3.next.next = new ListNode(10);
  head3.next.next.next = new ListNode(11);



  ListNode mergedList = mergeKlist(a, N);
  if(mergedList != null)
      printList(mergedList);
      System.out.println();





  }  
}
