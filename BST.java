import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
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

  public static void preorder(Node root){
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



    


    public static void main(String args[]){
        int values[] = {3,5,6,8,10,11,12};
        Node root = createBST(values, 0, values.length-1);
        preorder(root);
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
    // root.left = new Node(5);
    // root.right = new Node(10);
    // root.left.left = new Node(3);
    // root.left.right = new Node(6);
    // root.right.right = new Node(11);

    // root = createMirror(root);
    // preorder(root);
    }
}

