      //topic interface
public class OOPS {

   public static void main(String[] args){    //main function
    Beer b = new Beer();
    
    b.eat();

   } 
}
interface Herbviours{           //inteface
  void eat();
}
interface Carnivours{           //interface
    void sleep();
}
class Beer implements Herbviours,Carnivours{             //impelemnts interface
    public void eat(){
        System.out.println("Bear eats plants and meat");
    }
    public void sleep(){
        System.out.println("Bear sleeps in the cave");
    }
}



