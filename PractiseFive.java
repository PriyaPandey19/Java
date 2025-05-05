class Student{
    String name ="rohit";
    int age = 34;
    Student(String n,int a){
    name = n;
    age = a;
    System.out.println(name+ age);
    }

}


public class PractiseFive {
   public static void main(String args[]){
   Student st = new Student("rahul",32);
System.out.println(st.age);
    System.out.println(st.name);
   } 
}
