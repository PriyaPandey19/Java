class Student{     //TOPIC CONSTRUCTOR AND CONSTRUCTOR CHAINING
   String name;
   Student(){   //default constructor
    System.out.println("hyy");
   }
   Student(int a){  //paramatrized constructor
    this();
    System.out.println(a);
   }
   Student(int a,int b){
    this(a);
    System.out.println(a + b);
   }  

   
}



public class PractiseFive {
   public static void main(String args[]){
   Student obj = new Student();
   Student obj1 = new Student(243);
   Student obj2 = new Student(23,78);
   } 
}
