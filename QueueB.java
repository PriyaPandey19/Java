import java.util.*;

public class QueueB {

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






   


    
    public static void main(String args[]){
    StackQueue q = new StackQueue();
    q.add(1);
    q.add(2);
    q.add(3);
    
    while (! q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();  
    }
    }
}
