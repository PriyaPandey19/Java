import java.util.*;

public class BinaryTreeB {
    static class Node{
        int data;
        Node left;
        Node right;

       public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;  
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){       //build the binary tree
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }




        public static void preorder(Node root){          //preorder traversal
            if(root == null){
             //System.out.println("-1");  
                return;
            }
            System.out.print(root.data +" ");
            preorder(root.left);
            preorder(root.right);
        }


        public static void inorder(Node root){          //inorder traversal
            if(root == null){
             //System.out.println("-1");  
                return;
            }
           
            inorder(root.left);
             System.out.print(root.data +" ");
            inorder(root.right);
        }


        public static void postorder(Node root){          //inorder traversal
            if(root == null){
             //System.out.println("-1");  
                return;
            }
           
            postorder(root.left);
            postorder(root.right);
             System.out.print(root.data +" ");
        }







        public static void levelOrder(Node root){           //level order
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!= null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
    }





   public static int heightOfTree(Node root){           //height of tree
     if(root == null){
        return 0;
     }

     int lh = heightOfTree(root.left);
     int rh = heightOfTree(root.right);
     return Math.max(lh, rh)+1;

   } 



   public static int count(Node root){                  //count of node
    if(root == null){
        return 0;
    }
    int lcount = count(root.left);
    int rcount = count(root.right);
    int total = lcount + rcount +1;
    return total;
   }




   public static int SumofNode(Node root){                  //count of node
    if(root == null){
        return 0;
    }
    int leftSum = SumofNode(root.left);
    int rightSum = SumofNode(root.right);
    int treeSum = leftSum + rightSum +root.data;
    return treeSum;
   }





   public static int diameter2(Node root){                      //diameter of tree(Approach 1)
    if(root == null){
        return 0;
    }
    int leftDiam = diameter2(root.left);
    int leftHt = heightOfTree(root.left);
    int rightDiam = diameter2(root.right);
    int rightHt = heightOfTree(root.right);

    int selfDiam = leftHt + rightHt + 1;
    return Math.max(selfDiam , Math.max(leftDiam, rightDiam));
   }
    }





    static class Info2{
        int diam;
        int ht;

        public Info2(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info2 diameter(Node root){ 
     if(root == null){
        return new Info2(0, 0);
     }                                                      //diameter of tree(Approach 2)
    Info2 leftInfo = diameter(root.left);
    Info2 rightInfo = diameter(root.right);

    int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht + rightInfo.ht + 1);
    int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
    return new Info2(diam, ht);                                  
    }






    public static boolean isIdentical(Node node, Node subRoot){           
        if(node == null && subRoot == null){
            return true;
        }
        else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){      //isSubtree or not 
    if(root == null){
        return false;
    }   
    if(root.data == subRoot.data){
        if(isIdentical(root,subRoot)){
            return true;
        }
    }
    return isSubtree(root.left, subRoot)|| isSubtree(root.right, subRoot);
    }






    static class Info{
        Node node;
        int hd;

        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
  public static void TopView(Node root){                   //top view of tree
    Queue<Info> q = new LinkedList<>();    
    HashMap<Integer, Node> map = new HashMap<>();

    int min =0, max =0;
    q.add(new Info(root, 0));
    q.add(null);

    while(!q.isEmpty()){
        Info curr = q.remove();
        if(curr == null){
            if(q.isEmpty()){
                break;
            }
            else{
                q.add(null);
            }
        }
        else{
           if(!map.containsKey(curr.hd)){     //first time hd is occuring
            map.put(curr.hd,curr.node);
        }
        if(curr.node.left != null){
            q.add(new Info(curr.node.left, curr.hd-1));
            min = Math.min(min,curr.hd-1);
        }
        if(curr.node.right!= null){
            q.add(new Info(curr.node.right, curr.hd+1));
            max = Math.max(max,curr.hd+1);
        }
        }
    
    }
    for(int i= min;i<= max;i++){
        System.out.print(map.get(i).data+" ");
    }
    System.out.println();
  }  


  




public static void main(String args[]){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    

TopView(root);
}    
}
