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
    


  public static void main(String[] args) {      //main function
    int arr[] ={1,2,3,4,5,6,7,8};
    int n = arr.length;
    init(n);
    buildSt(arr, 0, 0, n-1);

    for(int i=0;i<tree.length;i++){
        System.out.print(tree[i]+ " ");
    }
  }  
}
