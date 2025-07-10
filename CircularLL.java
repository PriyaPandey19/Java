public class CircularLL {
    static class Node{
        int data;
        Node next;
    };
    static Node addToEmpty(Node tail, int data){    //add node to empty CLL
        if(tail != null){
            return tail;
        }
       Node newNode = new Node();
       newNode.data = data;
       tail = newNode;
       newNode.next = tail;
       return tail;
    }

    static Node addFront(Node tail, int data){
     if(tail == null){
        return addToEmpty(tail, data);
     }
     Node newNode = new Node();
     newNode.data = data;
     newNode.next= tail.next;
     tail.next= newNode;
     return tail;
    }

    static Node addEnd(Node tail,int data){
        if(tail == null){
        return addToEmpty(tail, data);
    }
    Node newNode = new Node();
    newNode.data= data;
    newNode.next = tail.next;
    tail.next = newNode;
    tail = newNode;
    return tail;
}

   static Node addAfter(Node tail,int data,int item){
    if(tail == null){
        return null;
    }
    Node newNode,p;
    p = tail.next;
    do{
        if(p.data == item){
            newNode = new Node();
            newNode.data = data;
            newNode.next = p.next;
            p.next = newNode;
            if(p == tail)
             tail= newNode;
             return tail;
        }
        p= p.next;
    }while(p != tail.next);
        System.out.println(item +"The given node is not present");
        return tail;
   }


   static Node deleteNode(Node tail, int key){    //delete node 
    if(tail == null)
    return null;
    if(tail.data == key && tail.next== tail){
        tail = null;
        return tail;
    }
    Node temp = tail,d = new Node();
     if(tail.data == key){
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = tail.next;
        tail = temp.next;
     }

     while(temp.next != tail && temp.next.data != key){
        temp = temp.next;
     }
     if(temp.next.data == key){
        d= temp.next;
        temp.next = d.next;

     }
     return tail;
   }


   static void traverse(Node tail){   //traverse the CircularLL
    Node p;
    if(tail == null){
    System.out.println("list is empty");
    return;
    }
    p = tail.next;
    do{
      System.out.print(p.data+ " ");
      p = p.next;
    }while(p != tail.next);
   System.out.println();
   }






   public static void main(String args[]){    //main function
   Node tail = null;
   tail = addToEmpty(tail, 6);
   tail= addEnd(tail, 8);
   tail = addFront(tail, 2);
   tail = addAfter(tail, 10, 2);
   traverse(tail);  
   deleteNode(tail, 8);
   traverse(tail);
   }
}
