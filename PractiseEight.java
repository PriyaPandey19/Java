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





public class PractiseEight {
    public static void main(String[] args) {
    //  MyThread t1 = new MyThread();
    //  t1.start();
    //  for(int i=0;i<5;i++){
    //  System.out.println("hiii");} 
     DownloadFile d1 = new DownloadFile("file A");
     DownloadFile d2 = new DownloadFile("file B");
     d1.start(); 
     d2.start();



    }
}
