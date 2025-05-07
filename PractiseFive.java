class Animal{     //TOPIC CONSTRUCTOR AND CONSTRUCTOR CHAINING And Inheritance
   void show(){
      System.out.println("animal");
   }  
}
class Dog extends Animal{
   void eat(){
      System.out.println("eat");
   }
}
class Puppy extends Dog{
   void cute(){
      System.out.println("cutiee");
   }
}



class Parent{
  void eat(){
   System.out.println("maggie");
  }
  }
  class Child extends Parent{
   void eat(){
       System.out.println("pastaa");
       super.eat();
   }
  }

  class Shape{
   void area(int a, int b){
  System.out.println("Area of rectangle" + a*b);
   }
   void area(double r){
      System.out.println("Area of circle" + 3.14*r*r);
       }
   void area(int c){
         System.out.println("Area of square" + c*c);
          }    
   void area(double h,double b){
      System.out.println("Arae of triangle"+0.5 * b*h);
   }
  }


  class Square{
   void print(){
      System.out.println("Area of square");
   }
   void print(int i){
      System.out.println(i*i);
   }
  }


  




public class PractiseFive {
   public static void main(String args[]){
   Square obj = new Square();
   obj.print();
   obj.print(4);

   } 
}
