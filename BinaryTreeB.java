import java.lang.reflect.Array;
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





    static class Info2{     //class to foind diameter for tree
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






    static class Info{               //class to find the top view of tree
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
  
  
  public static void KLevel(Node root,  int level, int k){     //kth level of tree
    if(root == null){
        return;
    }
    if(level == k){
        System.out.println(root.data+ " ");
        return;
    }

    KLevel(root.left, level+1, k);
    KLevel(root.right, level+1, k);
  }











  public static boolean getPath(Node root, int n, ArrayList<Node> path){   //helper of lca
    if(root == null){
        return false;
    }
    path.add(root);    //add root in path

    if(root.data == n){       //node ka data if equal to n so need to check subtree
        return true;
    }
   
    boolean foundLeft = getPath(root.left, n, path);
    boolean foundRight = getPath(root.right, n, path);

    if(foundLeft || foundRight){           // the node exists in left or in right
        return true;
    }
    path.remove(path.size()-1);
    return false;
  }

  public static Node lca(Node root, int n1,int n2){               //lowest common ancestor(approach 1)
    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();

    getPath(root,n1,path1);
    getPath(root,n2, path2);

    //last common ancestor
    int i=0;
    for(;i < path1.size()  && i < path2.size();i++){
        if(path1.get(i) != path2.get(i)){
            break;
        }
    }
    //last lca node -> i-1th
    Node lca = path1.get(i-1);
    return lca;
  }





 
  public static Node lca2(Node root, int n1, int n2){                 //least common ancestor(approach 2)
    if(root == null || root.data== n1 || root.data == n2){
        return root;
    }

    Node leftLca = lca2(root.left, n1, n2);
    Node rightLca = lca2(root.right, n1, n2);

    if(leftLca == null){                          //both n1 and n2 exists in right only
        return rightLca;
    }

    if(rightLca == null){                        //both n1 and n2 exists in left only
        return leftLca;
    }

    return root;                                 //if both exits in alternative side 
  }





  public static int lcaDist(Node root, int n){       //lcs dist
    if(root == null){
        return -1;
    }
    if(root.data == n){
        return 0;
    }

    int leftDist = lcaDist(root.left, n);
    int rightDist = lcaDist(root.right, n);

    if(leftDist == -1 && rightDist == -1){
        return -1;
    }
    else if(leftDist == -1){
        return rightDist + 1;
    }
    else{
        return leftDist + 1;
    }
  }



  public static int minDist(Node root, int n1, int n2){    //min diatsnce between the 2 nodes
    Node lca = lca2(root, n1, n2);
    int dist1 = lcaDist(lca, n1);
    int dist2 = lcaDist(lca, n2);
    
    return dist1 + dist2;
  }





  public static int KAncestor(Node root, int n, int k){   //to find k ancestor of node
    if(root == null){
        return -1;
    }

    if(root.data == n){
        return 0;
    }

    int leftDist = KAncestor(root.left, n, k);
    int rightDist = KAncestor(root.right, n, k);

    if(leftDist == -1 &&  rightDist == -1){
        return -1;
    }
    int max = Math.max(leftDist, rightDist);
    if( max+1 == k){
        System.out.println(root.data);
    }
    return max+1;
  }




  public static int transform(Node root){                //transform tree to sum of all nodes  tree 
    if(root == null){
        return 0;
    }
    int leftChild = transform(root.left);
    int rightChild = transform(root.right);

    int data= root.data;

    int newLeft = root.left == null ? 0 : root.left.data;
    int newRight = root.right == null ? 0 : root.right.data;
    root.data = newLeft + leftChild + newRight + rightChild;
    return data;
  }

  public static void preoder(Node root){             //preorder
    if(root == null){
        return;
    }
    System.out.println(root.data +" ");
    preoder(root.left);
    preoder(root.right);
  }



  public static boolean uniValued(Node root){        //univalued tree or not
    if(root== null){
        return true;
    }
    if(root.left != null && root.data != root.left.data){
        return false;
    }
    if(root.right != null && root .data != root.right.data){
        return false;
    }
    return uniValued(root.left) && uniValued(root.right);

  }







    public static Node mirror(Node root){                //invert binary tree
        if(root == null){
            return root;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;

    }


    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }



    public static Node deleteLeaves(Node root,int x){       //delete the target leaf node
        if(root == null){
            return null;
        }

        root.left = deleteLeaves(root.left,x);
        root.right = deleteLeaves(root.right,x);

        if(root.data == x && root.left == null && root.right == null){
            return null;
    }
      return root;


    }







    static class Result{
        int maxSum ;
    }

    public static int maxSum(Node node, Result result){        //To find maxSum 
        if(node == null){
            return 0;
        }

        int leftSum = maxSum(node.left, result);
        int rightSum = maxSum(node.right, result);


        //max single element
        int maxSinglePath = Math.max(Math.max(leftSum, rightSum) + node.data, node.data);

        int maxTop = Math.max(maxSinglePath,leftSum + rightSum + node.data);

        result.maxSum = Math.max(result.maxSum, maxTop);
        return maxSinglePath;   
    }
    


public static int findMaxSum(Node root){            //find max sum
    Result result = new Result();
    result.maxSum = Integer.MIN_VALUE;
    maxSum(root, result);
    return result.maxSum;
    
}





  

public static void main(String args[]){    //main function
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    

//TopView(root);
//int k = 2;
//KLevel(root, 1, k);

// int n =5, k = 2;
// KAncestor(root, n, k);
 
// int x= 3;
// deleteLeaves(root,x);
// //System.out.print("Inorder traversal after ");
// inorder(root);


System.out.println("Max path sum is "+ findMaxSum(root));


}    
}
