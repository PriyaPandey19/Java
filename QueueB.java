import java.util.*;

public class QueueB {    // Queue implementation in Java

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class LLQueue{                           //implementation of queue using Linked list
       static Node head = null;
       static Node tail = null; 

        public static boolean isEmpty(){
            return head == null && tail == null;
        }


       //add
        public static void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        }


        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
           int front = head.data;
           //single element
           if(tail == head){
            tail = head = null;
           }
           else{
            head = head.next;
           }
           return front;
        } 


        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }

    }




    static class Queue{                           //implementation of queue using array
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size =n;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }


       //add
        public static void add(int data){
        if(rear == size-1){
            System.out.println("queue is full");
            return;
        }
        rear = rear +1;
        arr[rear] = data;
        }


        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        } 


        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }

    }


    static class CllQueue{                           //implementation of circularqueue using array
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CllQueue(int n){
            arr = new int[n];
            size =n;
            rear = -1;
            front = -1;
        }
      
        //isEmpty
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
       
        //isFull
        public static boolean isFull(){
            return (rear + 1)% size == front;
        }


       //add
        public static void add(int data){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        //1st element
        if(front == -1){
            front = 0;
        }
        rear = (rear +1)%size;
        arr[rear] = data;
        }


        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
           int result = arr[front];

           //last element delete
           if(rear == front){
            rear = front = -1;
           }
           else{
            front = (front +1)%size;
           }
           return result;
        } 


        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[front];
        }

    }





    static class StackQueue{                        //implement queue using 2 stack
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //isEmpty or not
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        //pop
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            return s1.pop();
        }

 
        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            return s1.peek();
        }
    }



    public static void printNonRepeating(String str){      //print Non repeating element in queue
        int freq[] = new int[26];
        java.util.Queue<Character> q = new LinkedList<>();
      
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
       System.out.println();
        
    }




   public static void interLeave(java.util.Queue<Integer> q){      //interleave 1234 =>  1324
     java.util.Queue<Integer> firsthalf = new LinkedList<>();    //first queue to store starting elements
        int size = q.size();

        for(int i=0;i<size/2;i++){
            firsthalf.add(q.remove());                            
        }

        while (!firsthalf.isEmpty()) {
           q.add(firsthalf.remove());
           q.add(q.remove()); 
        }
   }



   public static void reverse(java.util.Queue<Integer> q){     //reverse the queue using stack
       Stack<Integer> s = new Stack<>();

       while(!q.isEmpty()){
        s.push(q.remove());
       }

       while(!s.isEmpty()){
        q.add(s.pop());
       }
   }


   public static void generateBinary(int n){         //generate binary numbers from 1 to n
    for(int i=1;i<= n;i++){
        String s = Integer.toBinaryString(i);
        System.out.println(s);
    }
   }




   public static int minCost(int arr[],int n){         //minmium cost to connect n ropes
    PriorityQueue<Integer> pq = new PriorityQueue<>();
     for(int i=0;i<n;i++){
        pq.add(arr[i]);
     }
     int res =0;

     while(pq.size()>1){
        int first = pq.poll();
        int second = pq.poll();

        res+= first+second;
        pq.add(first+second);
     }
     return res;
   }




   


   public static java.util.Queue<Integer> reverseK(java.util.Queue<Integer> q, int k){     //reverse the first k elements of queue
    if(q ==null || k<=0|| k>q.size()){
        return q;
    }

    Stack<Integer> s = new Stack<>();

    for(int i=0;i<k;i++){
        s.push(q.remove());
    }

    while(!s.isEmpty()){
        q.add(s.pop());
    }

    int size = q.size();
    for(int i=0;i<size-k;i++){
        q.add(q.poll());
    }
    return q;
   }


   


    
    public static void main(String args[]){
    // StackQueue q = new StackQueue();
    // q.add(1);
    // q.add(2);
    // q.add(3);
    
    // while (! q.isEmpty()) {
    //   System.out.println(q.peek());
    //   q.remove();  
    // }

    // java.util.Queue<Integer> q = new LinkedList<>();
    // q.add(1);
    // q.add(2);
    // q.add(3);
    // q.add(4);
   

    java.util.Queue<Integer> q = new LinkedList<>();
    q.add(10);
    q.add(20);
    q.add(30);
    q.add(40);
    q.add(50);

        reverseK(q, 3);
        while(!q.isEmpty()){
            System.out.print(q.remove() +" ");
        }
        System.out.println();
    
    }
}
