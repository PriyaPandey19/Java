public class PractiseThree {

public static void RowSum(int arr[][]){         //sum of each row in 2D array
    for(int i=0;i<arr.length;i++){
        int rowSum =0;
        for(int j=0;j<arr[i].length;j++){
            rowSum += arr[i][j];
        }
        System.out.println(rowSum);
    }
}

public static void ColumnSum(int arr[][]){        //sum of each column in 2D array
    for(int i=0;i<arr[0].length;i++){
        int colSum =0;
        for(int j =0;j<arr.length;j++){
            colSum += arr[j][i];
        }
        System.out.println(colSum);
    }
}


public static void sum2DArray(int arr1[][]){      //sum of 2D array
    int sum =0;
   for(int i=0;i<arr1.length;i++){
    for(int j=0;j<arr1[i].length;j++){
       
        sum += arr1[i][j];
    }
   }
   System.out.println("sum of 2D array is "+ sum);
}


public static void uniqueElements(int arr1[],int arr2[]){   //unique elements in two array

    for(int i=0;i<arr1.length;i++){
        boolean found = false;
        for(int j=0;j<arr2.length;j++){
            if(arr1[i] == arr2[j]){
             found = true;
             break;
        }
    }
        if(!found){
            System.out.println(arr1[i] + " "+ arr2[i]);
        }
    }
    
}

public static int maxElement(int arr[][]){      //max element in 2D array
    int max = Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
            if(arr[i][j] > max){
                max = arr[i][j];
            } 
        }
       
    }
    return max;
}


public static int minElement(int arr[][]){      //min  element in 2D array
    int min = Integer.MAX_VALUE;
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
            if(arr[i][j] < min){
                min = arr[i][j];
            } 
        }
       
    }
    return min;
}

public static void StringEqual(String str1,String str2){   //strings are equal or not
    for(int i=0;i<str1.length();i++){
      for(int j=0;j<str2.length();j++){
        if(str1.charAt(i) == str2.charAt(j)){
            System.out.println(str1.charAt(i));
        }
      }
    }
}


public static boolean isPalindrome(String str){  //to check if the string is palindrome or not
    for(int i =0;i<str.length()/2;i++){
      int n = str.length();
      if(str.charAt(i) != str.charAt(n-1-i)) {
        //not a palindrome
        return false;
      }
    }
    return true;
}

public static void Commonchar(String str){   //find target
 char[] arr = str.toCharArray();
 char target ='a';
 int count =0;

 for(int i=0;i<arr.length;i++){
    if(arr[i] == target){
        count++;
    }
 }
 System.out.println(count);
 
}

public static int countVowel(String str){         //to count the number of vowels in a string
    int count =0;
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
     if(ch =='a'|| ch =='e' || ch =='i' || ch =='o' || ch == 'u'){
        count++;
     }
    }
    return count;
}  

public static void removeDuplicate(String str){    //remove duplicate
    for(int i=0;i<str.length();i++){
       boolean flag = true;
       for(int j=0;j<i;j++){
        if(str.charAt(i) == str.charAt(j) && i!=j){
            flag = false;
            break;
        }
       }
       if(flag){
        System.out.println(str.charAt(i));
       }
    }  
}







    public static void main(String[] args) {
        String str = "hello";
      
    
    }
}
