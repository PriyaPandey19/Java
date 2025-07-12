public class DoublyLL {
    public class Node{              //class for node
        //data, next and prev pointers
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next= null;
            this.prev = null;  
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; 

    public void addFirst(int data){         //add at first position
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next= head;
        head.prev= newNode;
        head = newNode;
    }

    public void addLast(int data){               //add at last position
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void print(){                   //to print ll
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){                         //remove first
        if(head == null){
            System.out.println("Dll is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val= head.data;
            head= tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast(){               //remove last 
        if(head == null){
            System.out.println("Dll is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val= head.data;
            head= tail = null;
            size--;
        }
        
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;

    }

    public void reverse(){          //reverse DLL
    Node curr = head;
    Node prev = null;
    Node next;

    while(curr != null){
        next= curr.next;
        curr.next = prev;
        curr.prev= next;

        prev = curr;
        curr = next;
    }
    head = prev;
    }
   public static void main(String args[]){
    DoublyLL dll = new DoublyLL();
     dll.addLast(3);
     dll.addLast(2);
     dll.addLast(1);

    dll.print();
    dll.reverse();
    dll.print();
   }
}
