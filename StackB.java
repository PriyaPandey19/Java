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


    static class InnerQueueB {                                     //implement stack using 2 queue
       static Queue<Integer> q1 = new LinkedList<>();
       static Queue<Integer> q2 = new LinkedList<>();

         //is empty or  not
         public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
         }


         //push
         public static void push(int data){
         if(!q1.isEmpty()){
            q1.add(data);
         }
         else{
            q2.add(data);
         }
         }

         //pop
         public static int pop(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }

            int top =-1;

            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }
            else{
              while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }  
            }
            return top;
         }


         //peek
         public static int peek(){
          if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }

            int top =-1;

            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }
            else{
              while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }  
            }
            return top;  
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


    public static void  maxArea(int arr[]){       //largest area of histogram
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //nxt smaller right
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }


        //nxt smaller left
        s = new Stack<>();
        for(int i=0;i<=arr.length-1;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //current area : width = j-i-1
        for(int i=0;i<arr.length-1;i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);

        }
        System.out.println("max area of histogram "+ maxArea);

    }



    public String simplifyPath(String path) {             //simplify path name
        String arr[] = path.split("/");
        Stack<String> st = new Stack<>();
   
        for(int i=0;i<arr.length;i++){
           if(st.isEmpty() == false && arr[i].equals("..") == true){
               st.pop();
           }
           if(arr[i].equals("") == false && arr[i].equals(".") == false && arr[i].equals("..") == false){
               st.push(arr[i]);
           }
        }   
        if(st.isEmpty() == true){
           return "/";
        }
        StringBuilder ans = new StringBuilder();
        for(String curr: st){
           ans.append("/");
           ans.append(curr);
        }
        return ans.toString();
       }


       public static int maxWater(int height[]){      //trapping rain water
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int ans =0;
        for(int i=0;i<n;i++){
            while((!stack.isEmpty()) && (height[stack.peek()]< height[i])){
               int pop_height = height[stack.peek()];
               stack.pop();
               if(stack.isEmpty())
               break;

               int distance = i-stack.peek()-1;
               int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;

               ans += distance * min_height;
            }
            stack.push(i);
        }
        return ans;
       }



    public int longestValidParentheses(String s) {       //longest valid parentehesis
     int n = s.length();
     int index = -1;
     Stack<Integer> st = new Stack<>();
     int ans =0;
     for(int i=0;i<n;i++){
        if(s.charAt(i) == '('){
            st.push(i);    //push index of (
        }
        else{
            if(!st.isEmpty()){
                st.pop();   //match found for )
                if(!st.isEmpty()){
                    ans = Math.max(ans, i-st.peek());
                }
                else{
                    ans = Math.max(ans, i-index);
                }
            }
            else{
                index =i;
            }

        }
     } 
     return ans;
    }
    public static void main(String args[]){         //main function
     Stack s = new Stack<>();
     s.push(1);
     s.push(2);
     s.push(3);

     while(!s.isEmpty()){
        System.out.println(s.peek());
        s.pop();
     }
    }
}