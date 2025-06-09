import java.util.stream.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
// class MyThread extends Thread{         //TOPIC Multithreading and stream API
//     public void run(){
//          System.out.println("helllo");
      
//         try{
//         Thread.sleep(2000);
//         }catch(Exception e){
//         }
//        System.out.println("hii");
        
//     }
// }
// class downloadFile{                                       //without thread
//     public static void file(String file){
//      for(int i=1;i<=5;i++){
//         System.out.println(file + " downloading.."+(i*20) + "%");
     
//      try{
//        Thread.sleep(2000);
//      }catch(Exception e){}
//      }
//      System.out.println(file + " done");
//     }
// }



// class DownloadFile extends Thread{             //with thread
//     String file;

//     public DownloadFile(String file){
//         this.file = file;
//     }
//     public  void run(){
//      for(int i=1;i<=5;i++){
//         System.out.println(file + " downloading.."+(i*20) + "%");
     
//      try{
//        Thread.sleep(2000);
//      }catch(Exception e){}
//      }
//      System.out.println(file + " done");
//     }

// }

// class MyRunnable implements Runnable{
//    String file;

//     public MyRunnable(String file){
//         this.file = file;
//     }
//     public  void run(){
//      for(int i=1;i<=5;i++){
//         System.out.println(file + " downloading.."+(i*20) + "%");
     
//      try{
//        Thread.sleep(2000);
//      }catch(Exception e){}
//      }
//      System.out.println(file + " done");
//     }
// }



class bank extends Thread {
    int amt;
    boolean isAvailableBalance = false;
    static int balance=1000;

    public bank(int amt) {
        this.amt = amt; 
    }

    public void run() {
      synchronized(bank.class){
        if (balance >= amt) {
            
            System.out.println("is going withdraw "+amt);
        
        balance -=amt;
        System.out.println("remaining balance "+ balance);
      }
      else{
        System.out.println("sorry....");
      }
    }
    }


    public synchronized void run(int amt){
    while(isAvailableBalance){
      try {
        wait();
      } catch (Exception e) {
        
      }
    }
    

    }
}

class MyThread extends Thread{
  public void run(){
    for(int i=1;i<10;i++){
      System.out.println(getName() + " is running with priority "+ getPriority());
      Thread.yield();
    }
  }
}

 
class sharedResource{        //data produce and consume
  int data;
  boolean dataAvailabe = false;

  public synchronized void produce(int value){
   while(dataAvailabe){
    try {
      wait();
    } catch (Exception e) {
      Thread.currentThread().interrupt();
    }
   } 
   data = value;
   dataAvailabe = true;
   System.out.println("produced " + data);
   notify();
  }

  
   public synchronized void consume(){
    while (!dataAvailabe) {
      try {
        System.out.println("consumer waiting for signal....");
        wait();
      } catch (InterruptedException e) {
       
      }
      // System.out.println("consumer consumed...");
    }
    System.out.println("consumed "+ data);
    dataAvailabe = false;
    notify();
   }
}




public class PractiseEight {
   
    public static void main(String[] args) {
      List<Integer> list = Arrays.asList(1,2,3,4,5);
      List<Integer> list3 = Arrays.asList(10,14,22,30);
       List<Integer> list4 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(999,1000,1500,1000,2000);
       
       List<String> listName1 = Arrays.asList("Java is fun","Stream are poweful");  
      List<String> listName = Arrays.asList("Ram","Shyam","Om","Sita");
      List<String> listStartA= Arrays.asList("apple","banana","apricot","cherry","Avacado");
      
      
      // List<Integer> evenList = list.stream().filter(n -> n%2 == 0).map(n -> n *5).collect(Collectors.toList());

      // int  sum = list.stream().reduce(10,(a,b) -> a+b);

      // int sumList = list.stream().filter(n -> n > 2).filter(n -> n% 2 ==0).reduce(0,(a,b)-> a+b);
       
      // int  smallest = list.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b); 

      // int  secMin = list.stream().sorted((a,b) -> a-b).skip(1).findFirst().orElse(Integer.MIN_VALUE); 
      // System.out.println(secMin);



      List<Integer> evenSq = list.stream().filter(n -> n%2 == 0).map(n -> n*n).collect(Collectors.toList());
       System.out.println(evenSq);



      int sum =0;
      Integer oddSum = list.stream().filter(n -> n%2 != 0).reduce(0,Integer::sum);
      System.out.println(oddSum);



     List<String> listNameList = listName.stream().filter(name -> name.length() > 3).map(String::toUpperCase).collect(Collectors.toList());
     System.out.println(listNameList);



    List<Integer> wordLength = listName.stream().map(String::length).collect(Collectors.toList());
     System.out.println(wordLength);



    Integer totalSum = list2.stream().filter(n -> n > 1000).reduce(0,Integer::sum);
    System.out.println(totalSum);


    long startswithACount = listStartA.stream().filter(name ->name.startsWith("A")||name.startsWith("a")).count();
     System.out.println(startswithACount);


     boolean anyDivSeven = list3.stream().anyMatch(n -> n%7 == 0); 
      System.out.println(anyDivSeven);
   

     Integer MulNumber = list4.stream().reduce(1,(a,b) -> a* b);  
    System.out.println(MulNumber);

    List<String> alWords = listName1.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).collect(Collectors.toList());
    System.out.println(alWords);



     

      









     



      
      

      // ArrayList<String> list = new ArrayList<>();
      // list.add("rahul");
      // list.add("rohit");
      // list.add("mohit");
      // Collections.sort(list,(a,b)-> a.compareTo(b));
      // System.out.println(list);
    //  Runnable r = new Runnable() {
    //   public void run(){
    //     System.out.println("runnable using anonyms class");
    //   }
    //  };
    //  r.run();
    //  Runnable t = ()-> System.out.println("runnable using lambda");
    //   t.run();


      // sharedResource resource= new sharedResource();
      // Thread producer = new Thread(() -> {
      //   for(int i=0;i<= 5;i++){
      //     resource.produce(i);
      //   }
      // });

      // Thread consumer = new Thread(() -> {
      //   for(int i=0;i<= 5;i++){
      //     resource.consume();
      //   }
      // });


      // MyThread t1 = new MyThread();
      // MyThread t2 = new MyThread();

      // t1.setName("low priority");
      //  t2.setName("high priority");

      //  t1.setPriority(Thread.MIN_PRIORITY);
      //  t2.setPriority(Thread.MAX_PRIORITY);

      //  producer.start();
      //  consumer.start();

      //System.out.println("bura");
    //  MyThread t1 = new MyThread();
    //  t1.start();
    //  for(int i=0;i<5;i++){
    //  System.out.println("hiii");} 
    //  DownloadFile d1 = new DownloadFile("file A");
    //  DownloadFile d2 = new DownloadFile("file B");
    //  d1.start(); 
    //  d2.start();
// MyRunnable obj = new MyRunnable("file A");
// MyRunnable obj1 = new MyRunnable("file B");
// Thread t1 = new Thread(obj);
// Thread t2 = new Thread(obj1);
// t1.start();
// t2.start();
// System.out.println("Main thread is running");\
// MyRunnable obj = new MyRunnable("file A");
// Thread t1 = new Thread();
// t1.start();
// try{
//   t1.join();
// }catch(InterruptedException e){
//   e.printStackTrace();
// }
// for(int i=1;i<5;i++){
//   System.out.println(i);
// }
// Thread t1 = new Thread(() -> {
// System.out.println("accha accha");
// try {
//   Thread.sleep(2000);
// } catch (Exception e) {  
// }
// System.out.println("ham last mai aayenge");
// }); 
// t1.start();

// bank b1 = new bank(800);
// b1.start();
// bank b2 = new bank(500);
// b2.start();

    }
}
