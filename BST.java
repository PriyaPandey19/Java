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

  public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
    if(root == null){
        return;
    }
    path.add(root.data);            //add till leaf node come
    if(root.left == null && root.right == null){
        printPath(path);
    }
    printRoot2Leaf(root.left, path);    //call for left
    printRoot2Leaf(root.right, path);   //call for right
    path.remove(path.size()-1);

  }

    


    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i =0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        
        inorder(root);
        System.out.println();

       printRoot2Leaf(root, new ArrayList<>());
    }
}

