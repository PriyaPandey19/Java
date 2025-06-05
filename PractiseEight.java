// class MyThread extends Thread{         //TOPIC Multithreading
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
      sharedResource resource= new sharedResource();

      Thread producer = new Thread(() -> {
        for(int i=0;i<= 5;i++){
          resource.produce(i);
        }
      });

      Thread consumer = new Thread(() -> {
        for(int i=0;i<= 5;i++){
          resource.consume();
        }
      });


      // MyThread t1 = new MyThread();
      // MyThread t2 = new MyThread();

      // t1.setName("low priority");
      //  t2.setName("high priority");

      //  t1.setPriority(Thread.MIN_PRIORITY);
      //  t2.setPriority(Thread.MAX_PRIORITY);

       producer.start();
       consumer.start();

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
