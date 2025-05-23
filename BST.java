import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root, int val){               //insert the nodes
    if(root == null){
        root = new Node(val);
        return root;
    }

    if(root.data > val){
        //left subtree
        root.left = insert(root.left, val);
    }
    else{
        root.right = insert(root.right, val);
    }
    return root;
    }




  
    public static void inorder(Node root){     //inorder traversal
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }




    public static boolean search(Node root,int key){      //search the key
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
       else if (root.data > key){
           return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }   

    }

    public static Node delete(Node root, int val){                //delete a node
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{
            //case 1- leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2 - single child
            if(root.left ==  null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }


            //case 3 - both child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }



    public static Node findInorderSuccessor(Node root){         //helper of delete function             
    while(root.left != null){
        root = root.left;
    }
    return root;
    }





  public static void printInRange(Node root, int k1,int k2){         //print in range 
    if(root == null){
        return;
    }
    if(root.data >=k1 && root.data <= k2){
        printInRange(root.left, k1, k2);
        System.out.println(root.data +" ");
        printInRange(root.right, k1, k2);
    }
    else if(root.data < k1){
        printInRange(root.left, k1, k2);
    }
    else{
        printInRange(root.right, k1, k2);
}
  }







  public static void printPath(ArrayList<Integer> path){
    for(int i=0;i<path.size();i++){
        System.out.print(path.get(i) + "->");
    }
    System.out.println("null");
  }

  public static void printRoot2Leaf(Node root, ArrayList<Integer> path){    //root to leaf diffrent paths
    if(root == null){
        return;
    }
    path.add(root.data);            //add till leaf node come
    if(root.left == null && root.right == null){
        printPath(path);
    }
    printRoot2Leaf(root.left, path);    //call for left
    printRoot2Leaf(root.right, path);   //call for right
    path.remove(path.size()-1);       //remove while traversing back

  }



  public static boolean isValidBST(Node root, Node min, Node max){         //is valid BST or not
    if(root == null){
        return true;
    }
    if(min != null && root.data <= min.data){
        return  false;
    }
    else if(max != null && root.data >= max.data){
        return false;
    }
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }

   


  public static Node createMirror(Node root){          //create mirror of BST
    if(root == null){
        return null;
    }

    Node leftMirror = createMirror(root.left);
    Node rigthMirror = createMirror(root.right);

    root.left = rigthMirror;
    root.right = leftMirror;
    return root;
  }

  public static void preorder(Node root){              //helper of create mirror
    if(root == null){
        return;
    }
    System.out.println(root.data +" ");
    preorder(root.left);
    preorder(root.right);
  }



  public static Node createBST(int arr[], int st, int end){    //create BST using sorted array
    if(st > end){
        return null;
    }
    int mid = (st + end)/2;          //mid find
    Node root = new Node(arr[mid]);      //add in root
    root.left = createBST(arr, st, mid-1);    //for left
    root.right = createBST(arr, mid+1, end);   //for right
    return root;
  }









 

  public static void getInorder(Node root, ArrayList<Integer> inorder){    //get inoeder
  if(root == null){
    return;
  }
  getInorder(root.left, inorder);
  inorder.add(root.data);
  getInorder(root.right, inorder);
  }


  public static Node createBST(ArrayList<Integer> inorder, int st, int end){   //same as array to BST
    if(st > end){
        return null;
    }

    int mid = (st + end)/2;
    Node root = new Node(inorder.get(mid));
    root.left = createBST(inorder, st, mid-1);
    root.right = createBST(inorder, mid+1, end);
    return root;
  }
  
  public static Node balanceBST(Node root){             //to convert BST to balance BST
    //inorder seq
    ArrayList<Integer> inorder = new ArrayList<>();
    getInorder(root, inorder);

    //sorted inorder -> balanced BST
    root = createBST(inorder, 0, inorder.size()-1);
    return root;
  }






  static class Info{
    boolean isBST;
    int size;
    int max;
    int min;

    public Info(boolean isBST, int size, int min, int max){
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;

    }
  }

  public static int maxBST =0;
  
  public static Info largestBST(Node root){             //largest  BST
    if(root == null){
        return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    Info leftInfo = largestBST(root.left);
    Info rightInfo = largestBST(root.right);
    int size = leftInfo.size + rightInfo.size + 1;
    int min = Math.min(root.data , Math.min(leftInfo.min , rightInfo.min));
    int max = Math.max(root.data , Math.max(leftInfo.max , rightInfo.max));


    //false condition
    if(root.data <= leftInfo.max|| root.data >= rightInfo.min){
        return new Info(false, size, min, max);
    }
    if(leftInfo.isBST && rightInfo.isBST){                 //if both left and right are balance then update maxBST
        maxBST = Math.max(maxBST,size);
     return new Info(true, size, min,max);
    }

    return new Info(false, size, min, max);  
  }






  static int helper1(Node root, int low,int high){
        if(root == null){
            return 0;
        }
        if(low > root.data){
            return helper1(root.right,low,high);
        }
        else if(high < root.data){
            return helper1(root.left,low,high);
        }
        else{
            return root.data + helper1(root.left,low,high)+ helper1(root.right,low,high);
        }
     }
  public  static int rangeSumBST(Node root, int low, int high) {
    int num = helper1(root, low,high);
    return num;    
    }




 





    


    public static void main(String args[]){
        // int values[] = {3,5,6,8,10,11,12};
        // Node root = createBST(values, 0, values.length-1);
        // preorder(root);
    //     Node root = null;

    //     for(int i =0;i<values.length;i++){
    //         root = insert(root, values[i]);
    //     }
        
    //     inorder(root);
    //     System.out.println();

    //   // printRoot2Leaf(root, new ArrayList<>());
    //  if(isValidBST(root, null, null)){
    //   System.out.println("valid");
    //  }
    //  else{
    //     System.out.println("not valid");
    //  }







    // Node root = new Node(8);
    // root.left = new Node(6);
    // root.left.left = new Node(5);
    // root.left.left.left = new Node(3);



    // root.right= new Node(10);
    // root.right.right = new Node(11);
    // root.right.right.right = new Node(12);

    // // root = createMirror(root);
    // // preorder(root);

    //  root = balanceBST(root);
    //  preorder(root);


    Node root = new Node(50);
    root.left = new Node(30);
    root.left.left = new Node(5);
    root.left.right = new Node(20);



    root.right= new Node(60 );
    root.right.left = new Node(45);
    root.right.right= new Node(70);
    root.right.right.left = new Node(65);
    root.right.right.right= new Node(80);



   Info info = largestBST(root);
   System.out.println("largest BST size "+ maxBST);

   //System.out.println(printInRange(root, 5, 70));


    }
}

