
public class OOPS {

   public static void main(String[] args){
    Beer b = new Beer();
    
    b.eat();

   } 
}
interface Herbviours{
  void eat();
}
interface Carnivours{
    void sleep();
}
class Beer implements Herbviours,Carnivours{
    public void eat(){
        System.out.println("Bear eats plants and meat");
    }
    public void sleep(){
        System.out.println("Bear sleeps in the cave");
    }
}



