

public class Example {

    public static char ch ='Z';
    int a,b;
    public Example(int k, int m){
     a=k;
     b=m;
    }
    public void show(){
        int A = 500;
        System.out.println(a+"-"+b);
        System.out.println(A);
    }
    public static void display(){
      System.out.println("Static function");
    }
  public static void main(String args[]) {
 Example E = new Example(10,20);
   E.show();
   System.out.println(Example.ch);
   Example.display();
  }    
}
