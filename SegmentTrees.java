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

    public static void update(int arr[], int idx , int newVal){
      int n = arr.length;
      int diff = newVal - arr[idx];
      arr[idx]= newVal;
      updateUtil(0,0,n-1, idx, diff);
    }
    


  public static void main(String[] args) {      //main function
    int arr[] ={1,2,3,4,5,6,7,8};
    int n = arr.length;
    init(n);
    buildSt(arr, 0, 0, n-1);

    // for(int i=0;i<tree.length;i++){
    //     System.out.print(tree[i]+ " ");
    // }
    System.out.println(getSum(arr, 2, 5));
    update(arr, 2, 2);
    System.out.println(getSum(arr, 2, 5));
  }  
}
