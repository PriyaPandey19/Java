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





        private Node getMid(Node head){                    //get mid for merge function
            Node slow = head;
            Node fast = head.next;

            while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            }
            return slow;
        }

        private Node merge(Node head1, Node head2){              //helper function of merge
            Node mergedLL = new Node(-1);

            Node temp = mergedLL;

            while(head1 != null && head2 != null){
                if(head1.data <= head2.data){    //if head1 is small add it in merge LL
                    temp.next = head1;
                    head1 = head1.next;
                    temp = temp.next;
                }
                else{
                    temp.next = head2;   //if head2 is small add it in merge LL
                    head2 = head2.next;
                    temp = temp.next;  
                }
            }
            while(head1 != null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            while (head2 != null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;    
            }
            return mergedLL.next;
        }

        public void zigZag(){              //zig zag LL 1st with last 2nd with 2nd last
            //find mid
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;

            //reverse 2nd half
            Node curr = mid.next;
            mid.next= null;
            Node prev= null;
            Node next;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node left = head;
            Node right= prev;
            Node nextL,nextR;

            //alt merge zig zag merge
            while(left != null && right != null){
                nextL = left.next;
                left.next = right;
                nextR = right.next;
                right.next = nextL;

                left = nextL;
                right = nextR;
            }
        }



        public Node mergeSort(Node head){                    //merge sort using LL
            if(head == null || head.next == null){
                return head;
            }
           //find mid
           Node mid = getMid(head);
           //left & right MS
           Node rightHead = mid.next;
           mid.next= null;
           Node newLeft = mergeSort(head);
           Node newRight = mergeSort(rightHead);

           return merge(newLeft,newRight);
        }




        public Node oddEvenLL(Node head){                //rearange the LL from 1st part even then odd
            if(head == null || head.next == null){
                return head;
            }
           Node oddHead = new Node(-1);              //even node
           Node evenHead = new Node(-1);             //odd node
           Node odd = oddHead;                       //pointer to point odd node
           Node even = evenHead;                     //pointer to point even node
           Node temp = head;

           while(temp != null){
            if(temp.data % 2 == 0){
                even.next = temp;
                even = even.next;
            }
            else{
                odd.next = temp;
                odd = odd.next; 
            }
            temp = temp.next;
           }
           even.next = null;
           even.next = oddHead.next;

           return evenHead.next; 
        }






    public static void  main(String args[]){
     LinkedListImplementationt ll = new LinkedListImplementationt();
    // head = new Node(1);
    // Node temp = new Node(2);
    // head.next = temp;
    // head.next.next = new Node(3);
    // head.next.next.next = temp;

    // System.out.println(isCycle());
    // removeCycle();
    // System.out.println(isCycle());
    //LinkedList<Integer> ll = new LinkedList<>();
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
    
    ll.print();
   head = ll.oddEvenLL(head);
    ll.print();
    
    
   
    }
}
