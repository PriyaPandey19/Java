public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data= data;
             this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data){     //add first node
       //create a node 
       Node newNode = new Node(data);

        if(head == null){
        head = tail = newNode;
        return;   
        }
        //newNode next = head
        newNode.next = head;

        //head = newNode
        head = newNode;
    }

    public void addLast(int data){      //add last node
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail= newNode;
    }


    public void print(){          //LL is empty
        if(head == null){
            System.out.println("LL is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){    // add node at any index
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i=0;

        while(i < idx-1){
        temp= temp.next;
        i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        
    }

    public static void  main(String args[]){
    LinkedList ll = new LinkedList();
  
    ll.addFirst(2);
    ll.addFirst(1);
    ll.addLast(3);
    ll.addLast(4);
    ll.add(0, 9);
    ll.print();
    }
}
