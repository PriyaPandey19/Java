public class SegmentTrees {
    static int tree[];                  //array to store the segment tree
    
    public static void init(int n){                //intilize the array
     tree = new int[4*n];
    }
    public static int buildSt(int arr[], int i, int start, int end){            //build bst  tree using array 
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }
        int mid = (start +end)/2;
        buildSt(arr, 2*i+1, start, mid);    //left subtree 2*i+1
        buildSt(arr, 2*i+2, mid+1, end);     //right subtree 2*i+2
        tree[i] = tree[2*i+1] +tree[2*i+2];
        return tree[i];

    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj){
      if(qj<= si || qi >= sj){ //non overlapping
        return 0;
      }
      else if(si >= qi && sj <= qj){  //complete overlapping
        return tree[i];
      } 
      else{                           //partial overlapping
        int mid = (si + sj)/2;
        int left = getSumUtil(2*i+1, si, mid, qi, qj);
        int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
        return left +right;
      }
    }
    public static int getSum(int arr[], int qi, int qj){    //function to get sum
      int n = arr.length;
      return getSumUtil(0, 0, n-1, qi, qj);
    }


    public static void updateUtil(int i, int si, int sj, int idx, int diff){ 
      if(idx >sj || idx < si){
        return; //out of range
      }
      tree[i] += diff; //update the value
      if(si != sj){
        int mid = (si + sj)/2;
        updateUtil(2*i+1, si,mid, idx, diff);//update left subtree
        updateUtil(2*i+2,mid+1, sj, idx, diff);//update right subtree
      }
    }

    public static void update(int arr[], int idx , int newVal){  //update the value at index idx
      int n = arr.length;
      int diff = newVal - arr[idx];
      arr[idx]= newVal;
      updateUtil(0,0,n-1, idx, diff);
    }












    public static void buildTree(int i, int si, int sj, int arr[]){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }
        int mid = (si +sj)/2;
        buildTree(2*i+1, si, mid, arr);    //left subtree 2*i+1
        buildTree(2*i+2, mid+1, sj, arr);     //right subtree 2*i+2
        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);

    }
     
    public static int getMax(int arr[],int qi, int qj){    //function to get maximum value in range
      int n = arr.length;
      return getMaxUtil(0,0, n-1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj){
      if( si > qj || sj < qi){
        return Integer.MIN_VALUE;
      }   
      else if(si >= qi && sj <= qj){
        return  tree[i];
      }
      else{
        int mid = (si + sj)/2;
        int leftAns = getMaxUtil(2*i+1, si, mid, qi, qj);
        int rightAns = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
        return Math.max(leftAns, rightAns);
      }
    }


 public static void update1(int arr[], int idx , int newVal){  //update the value at index idx
      
      arr[idx]= newVal;
      int n = arr.length;
      updateUtil1(0,0,n-1, idx, newVal);
    } 

    public static void updateUtil1(int i, int si, int sj, int idx, int newVal){ 
      if(idx <si || idx > sj){
        return; //out of range
      }
      tree[i] = Math.max(tree[i], newVal); //update the value
      if(si != sj){
        int mid = (si + sj)/2;
        updateUtil1(2*i+1, si,mid, idx, newVal);//update left subtree
        updateUtil1(2*i+2,mid+1, sj, idx, newVal);//update right subtree
    }
    }

   



  public static void main(String[] args) {      //main function
    //int arr[] ={1,2,3,4,5,6,7,8};
   // int n = arr.length;
    // init(n);
    // buildSt(arr, 0, 0, n-1);

    // // for(int i=0;i<tree.length;i++){
    // //     System.out.print(tree[i]+ " ");
    // // }
    // System.out.println(getSum(arr, 2, 5));
    // update(arr, 2, 2);
    // System.out.println(getSum(arr, 2, 5));


      int arr2[] ={6,8,-1,2,17,1,3,2,4};
      int n1 = arr2.length;
      init(n1);
      buildTree(0,0,n1-1, arr2);
      for(int i=0;i<tree.length;i++){
        System.out.print(tree[i]+ " ");
      }
      // int max = getMax(arr2, 2, 5);
      // System.out.println(max);

      update1(arr2, 2, 20);
      int max1 = getMax(arr2, 2, 5);
      System.out.println(max1);


  }  
}
