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
class downloadFile{                                       //without thread
    public static void file(String file){
     for(int i=1;i<=5;i++){
        System.out.println(file + " downloading.."+(i*20) + "%");
     
     try{
       Thread.sleep(2000);
     }catch(Exception e){}
     }
     System.out.println(file + " done");
    }
}



class DownloadFile extends Thread{             //with thread
    String file;

    public DownloadFile(String file){
        this.file = file;
    }
    public  void run(){
     for(int i=1;i<=5;i++){
        System.out.println(file + " downloading.."+(i*20) + "%");
     
     try{
       Thread.sleep(2000);
     }catch(Exception e){}
     }
     System.out.println(file + " done");
    }

}

class MyRunnable implements Runnable{
   String file;

    public MyRunnable(String file){
        this.file = file;
    }
    public  void run(){
     for(int i=1;i<=5;i++){
        System.out.println(file + " downloading.."+(i*20) + "%");
     
     try{
       Thread.sleep(2000);
     }catch(Exception e){}
     }
     System.out.println(file + " done");
    }
}



class bank extends Thread {
    int amt;
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
}





public class PractiseEight {
    public static void main(String[] args) {
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

bank b1 = new bank(800);
b1.start();
bank b2 = new bank(500);
b2.start();

    }
}
