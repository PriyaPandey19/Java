import java.util.*;

import javax.xml.transform.stax.StAXResult;

public class StackB{
    static class Node{               //implementation of stack using Linked list
      int data;
      Node next;
      Node(int data){
        this.data = data;
        this.next = null;
      }
    }

    static class StackLL{
      static Node head= null;

      public static boolean isEmpty(){
        return head == null;
      }

      //push
      public static void push(int data){
        Node newNode = new Node(data);

        if(isEmpty()){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
      }

      //pop
      public static int pop(){
        if(isEmpty()){
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
      }

      //peek
      public static int peek(){
        if(isEmpty()){
            return -1; 
      }
      return head.data;

      
    }
}


    static class StackArrayList{                                   //implementation of stack using ArrayList
        static ArrayList<Integer> list = new ArrayList<>();
        //to check empty
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        //push
        public static void push(int data){
            list.add(data);
        }
        
        //pop
        public static int pop(){
          if(isEmpty()){
            return -1;
          }  
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
              }    
        return list.get(list.size()-1);    
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data){   //push at  bottom of stack
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top= s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }



    public static String reverseString(String str){        //to reverse the string 
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }



    public static void reverseStack(Stack<Integer> s){   //reverse a stack
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void printStack(Stack<Integer> s){
        while(! s.isEmpty()){
            System.out.println(s.pop());
        }

    }


    public static void stockSpan(int stocks[],int span[]){       //stock span problem
        Stack<Integer> s = new Stack<>();
        span[0] =1;
        s.push(0);

        for(int i=1;i<stocks.length;i++){
            int currPrice = stocks[i];
            while(! s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }



    public static void nxtGreater(Stack<Integer> s, int arr[], int nxtGreater[]){   //nxt greater
    for(int i=arr.length-1;i>=0;i--){
        //while to pop smaller elements
        while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
            s.pop();
        }

        //if else is stack is empty or we found our nxtgreater
        if(s.isEmpty()){
            nxtGreater[i] = -1;
        }
        else{
            nxtGreater[i] = arr[s.peek()];
        }

        //push
        s.push(i);
    }
    for(int i=0;i<nxtGreater.length;i++){
        System.out.print(nxtGreater[i]+ " ");
    }
    System.out.println();
    }




    public static boolean isValidParenthesis(String str){     //valid Parenthesis
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{'|| ch == '['){    //opening so push in stack
                s.push(ch);
            }

            else{
                if(s.isEmpty()){
                    return false;
                }                                //checking if combination exists
          if((s.peek() == '(' && ch == ')')  || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                s.pop();
                }
                else{
                    return false;
                }
            }
        }
      if(s.isEmpty()){
        return true;
      }
      else{
        return false;
      }
    }


    public static boolean isDuplicate(String str){                //is duplicate parenthesis
    Stack<Character> s = new Stack<>();

    for(int i=0;i<str.length();i++){
     char ch = str.charAt(i);

     //closing
     if(ch == ')'){
        int count =0;
        while(s.pop() != '('){
            count++;
        }
        if(count < 1){
            return true;   //duplicate
        }
        
     }
     else{
        //opening
        s.push(ch);
     }
    }
    return false;
    }

    public static void main(String args[]){
      String str ="((a+b))";
     System.out.println(isDuplicate(str));
    }
}