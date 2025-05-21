interface Walkable{               //TOPIC interfaces
    void walk();

}

interface Runnable{             
    void run();
}

class Human implements Walkable,Runnable{
    public void walk(){
        System.out.println("walk");
    }
    public void run(){
        System.out.println("run");
    }
}


interface A{               
    void display();
}
interface B{               
    void display();
}
class Demo implements A,B{
   public void display(){
    System.out.println("dispaly");
   }

}













public class PractiseSix {
  public static void main(String args[]){
  Demo obj1 = new Demo();
  obj1.display();
  }  
}
