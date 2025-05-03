import java.util.LinkedList;

public class LinkedListImplementationt {
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
    public static int size;

    public void addFirst(int data){     //add first node
       //create a node 
       Node newNode = new Node(data);
       size++;
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
        size++;
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
        size++;
        Node temp = head;
        int i=0;

        while(i < idx-1){
        temp= temp.next;
        i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        
    }

    public int removeFirst(){
        if(size == 0){                              //remove first node
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } 
        else if(size == 1){
            int val= head.data;
            head = tail = null;
            size = 0;
            return val;
        }                            
        int val = head.data;
        head = head.next;
        size--;
        return val; 
    }

    public int removeLast(){               //remove the last digit
        if(size == 0){
            System.out.println("LL is empty");
        }
        else if( size == 1){
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){           //to search the key in LL using iterative
        Node temp = head;
        int i=0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key){        //recursive function to search key        
    if(head == null){
        return  -1;
    }
    if(head.data == key){
        return 0;
    }
    int idx = helper(head.next, key);
    if(idx == -1){
        return -1;
    }
    return idx+1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }

    public void reverse(){             //reverse the LL 
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        }

        public void deleteNthfromEnd(int n){         //delete nth node from end
            int sz =0;
            Node temp= head;
            while (temp != null) {
               temp = temp.next;
               sz++; 
            }
            if(n == sz){
                head = head.next;
                return;
            }
            //sz-n
            int i= 1;
            int iToFind = sz-n;
            Node prev = head;
            while(i < iToFind){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return;
        }




          
        public Node findMiddle(Node head){           //slow fast approach   
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public boolean checkPalindrome(){                     //check LL is palindrome or not
            if(head == null || head.next == null){
                return true;
            }
            //find mid
            Node midNode = findMiddle(head);

            //reverse 2nd half
            Node prev = null;
            Node curr = midNode;
            Node next;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev= curr;
                curr= next;
            }
            Node right = prev;    //right half head
            Node left= head;

            //check left and right half
            while( right != null){
                if(left.data != right.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }

        public  static boolean isCycle(){             //detect cycle in LL
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){
                    return true;
                }
            }
            return false;
        }

        public static void removeCycle(){          //remove a cycle
            //detect cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                    cycle = true;
                    break;
                }
            }
            if(cycle == false){
                return;
            }

            //find meeting point
             slow = head;
             Node prev = null;//last node
             while(slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
             }

             //remove cycle -> last.next = null
             prev.next = null;
        }

        private Node getMid(Node head){
            Node slow = head;
            Node fast = head.next;

            while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            }
            return slow;
        }

        // public Node mergeSort(Node head){
        //     if(head == null && head.next != null){
        //         return head;
        //     }
        //    //find mid
        //    Node mid = getMid();
        //    //left & right MS
        //    Node rightHead = mid.next;
        //    mid.next= null;
        //    Node newLeft = mergeSort(head);
        //    Node newRight = mergeSort(rightHead);

        //    return merge(newLeft,newRight);
        // }

    public static void  main(String args[]){
    // LinkedListImplementationt ll = new LinkedListImplementationt();
    // head = new Node(1);
    // Node temp = new Node(2);
    // head.next = temp;
    // head.next.next = new Node(3);
    // head.next.next.next = temp;

    // System.out.println(isCycle());
    // removeCycle();
    // System.out.println(isCycle());
    LinkedList<Integer> ll = new LinkedList<>();
    ll.addLast(1);
    ll.addLast(2);
    ll.addFirst(0);
    System.out.println(ll);
   
    }
}
