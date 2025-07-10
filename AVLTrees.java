public class AVLTrees {
     static class Node{                  //class Node
        int data, height;
        Node left,right;

        Node(int data){
            this.data = data;
            height =1;
        }
     }

     public static Node root;




     public static int height(Node root){       //height of tree
        if(root == null)
            return 0;
        
        return root.height;
     }




     static int max(int a, int b){       //function to find max
        return (a > b) ? a: b;
     }





     //right rotated subtree 
     public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        //perform rotation
        x.right = y;
        y.left = T2;

        //update height
        y.height=Math.max(height(y.left),height(y.right)) + 1;
        x.height= Math.max(height(x.left),height(x.right)) + 1;

        //return root
        return x;  
     }




     //left rotated subtree
       public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        //perform rotation
        y.left = x;
        x.right = T2;

        //update height
        x.height= Math.max(height(x.left),height(x.right)) + 1;
        y.height=Math.max(height(y.left),height(y.right)) + 1;

        //return root
        return y;  
       }


       //get balance factor of node
       public static int getBalance(Node root){
        if(root == null)
          return 0;

        return  height(root.left)-height(root.right);
       }



       public static Node insert(Node root, int key){      //insert the node
        if(root == null)
        return new Node(key);

        if(key < root.data){
            root.left = insert(root.left, key);
        }
       else if(key > root.data){
            root.right = insert(root.right, key);
        }
        else{
            return root;
        }
       
        //update root height
        root.height = 1+ Math.max(height(root.left),height(root.right));

        //get root's balance factor
        int bf = getBalance(root);

        //left left case
        if(bf > 1 && key < root.left.data)
        return rightRotate(root);

        //rigth right case
         if(bf < -1 && key > root.right.data)
        return leftRotate(root);

        //left right case
        if(bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //right left case
        if(bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;    

       }






       public static void preorder(Node root){      //preorder of the node
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);

       }







       public static Node getMiNode(Node root){
        Node curr = root;
        //min data is in left
        while(curr.left != null)
            curr = curr.left;
            return curr;
        
    }

        public static Node deleteNode(Node root, int key){                 //delete node with key
            //perform usual BST delete
            if(root ==  null){
                return root;
            }

            //key < root's data
            if(key < root.data){
                root.left = deleteNode(root.left, key);
            }

            //key > root's data
            else if(key > root.data){
                root.right = deleteNode(root.right, key);
            }

            else{
                //node with only one child or no child
                if((root.left== null)|| (root.right == null)){
                    Node temp = null;
                    if(temp == root.left)
                       temp = root.right;
                    else
                       temp = root.left;
                       
                       //no child case
                       if(temp == null){
                        temp = root;
                        root = null;
                       }
                       else
                        root = temp;
                       
                }
             else{
               //node with 2 children
               Node temp = getMiNode(root.right);
               //copy the inorder successor
               root.data = temp.data;
               //delete the inorder successor
               root.right = deleteNode(root.right, temp.data);
             }
            }

            if(root == null)
            return root;

            //update height
            root.height = Math.max(height(root.left), height(root.right))+1;

            //get balance
            int bf = getBalance(root);
            //if this node become unbalace then 4 cases



            //left left case
            if(bf > 1 && getBalance(root.left) >=0)
            return rightRotate(root);

            //left right case
            if(bf > 1 && getBalance(root.left) < 0){
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

            //right right case
            if(bf < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

            //right left case
            if(bf < -1 && getBalance(root.right) > 0){
                root.right= rightRotate(root.right);
                return leftRotate(root);
            }
            return root;
        }

        
       






    public static void main(String args[]){    //main function
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        //root = deleteNode(root, 40);


        preorder(root);
    }
}
