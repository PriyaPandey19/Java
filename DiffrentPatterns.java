import java.util.*;

 class DiffrentPatterns{
    public static void main(String args[]){
        Scanner scn  = new Scanner(System.in);         //*** 
         int n = scn.nextInt();                        //** 
          for(int i=1;i<=n;i++) {                      //* 
               for (int j=n-i+1;j>=1;j--){
                System.out.print("* ");
               }
               System.out.println();
          }




          for(int i =1;i<=n;i++){               //1
            for(int j=1;j<=i;j++){              //22
               System.out.print(i);             //333
            }                                   //4444 
            System.out.println();
          }


          for(int i =1;i<=n;i++){               //* 
            for(int j=1;j<=i;j++){              //**
               System.out.print("*");         //***
            }                                   //**** 
            System.out.println();
          }


          for(int i =1;i<=n;i++){                  //1
               for(int j=1;j<=i;j++){              //12
                  System.out.print(j);             //123
               }                                   //1234 
               System.out.println();
             }


             char ch ='A';
             for(int i =1;i<=n;i++){                 //A
               for(int j=1;j<=i;j++){                //BC
                  System.out.print(ch);              //CDEF
                   ch++;                             //GHIJK
               }                                    
               System.out.println();
             }


             int rows= scn.nextInt();                              
            int cols = scn.nextInt();                                //*******
                                                                     //*     *
             for (int i=1;i<=rows;i++){                              //*     *
               for(int j=1;j<=cols;j++){                             //******* 
                    if (i==1 || i== rows || j==1|| j==cols) {
                        System.out.print("*"); 
                    }
                    else{
                         System.out.print(" ");
                    }
                    
               }
               System.out.println();

             }

             int  m = scn.nextInt();                               //      *
             for(int i=1;i<=m;i++){                                //     **
               for(int j=1;j<=m-i;j++){                            //    ***
                    System.out.print(" ");                       //   ****
               }   
               for(int j=1;j<=i;j++){
                    System.out.print("*");
               }                                
               System.out.println();
             }
   



             int b = scn.nextInt();                      //1 1 1 1
             for(int i=1;i<=b;i++) {                     //2 2 2
               for (int j=b-i+1;j>=1;j--){               //3 3
                System.out.print(i + " ");               //4
               }
               System.out.println();
          }


          int t = scn.nextInt();                         //1 2 3 4
             for(int i=1;i<=t;i++) {                     //1 2 3
               for (int j=1;j<=b-i+1;j++){               //1 2
                System.out.print(j + " ");               //1
               }
               System.out.println();
          }

      int p = scn.nextInt();
          int num =1;
          for(int i =1;i<=p;i++){                        //1
            for(int j=1;j<=i;j++){                       //2 3
               System.out.print(num + " ");              //4 5 6
                num++;                                   //7 8 9 10 11
            }                                    
            System.out.println();
          }



          int h = scn.nextInt();
          for(int i =1;i<=h;i++){                  //1
               for(int j=1;j<=i;j++){              //0 1
                  if((i+j)%2 == 0){                //1 0 1
                   System.out.print("1" + " ");    //0 1 0 1
                  }
                  else{
                    System.out.print("0"+" ");
                  }           
               }                                   
               System.out.println();
             }
                                                 
    int digit =1;                               //1 2 3 4
     for(int i=1;i<=3;i++){                     //5 6 7 8
      for(int j =1;j<=4;j++){                  //9 10 11 12
        System.out.print(digit+"\t");
        digit++;
      }
      System.out.println();
     }




    int g = scn.nextInt();
     for(int i=1;i<=g;i++){
      for(int j=1;j<=i;j++){
        System.out.print("*");
      }
      for(int j=1;j<=2*(g-i);j++){
        System.out.print(" ");
      }
      for(int j=1;j<=i;j++){
        System.out.print("*");                       //*        */      
      }                                                //**      **
      System.out.println();                            //***    ***
     }                                                //***********
                                                     // ***********
     for(int i=g;i>=1;i--){                          // ***     ***
      for(int j=1;j<=i;j++){                         // **       **
        System.out.print("*");                     // *         *
      }
      for(int j=1;j<=2*(g-i);j++){
        System.out.print(" ");
      }
      for(int j=1;j<=i;j++){
        System.out.print("*");
      }
      System.out.println();
     }



     int  f = scn.nextInt();                               //      ****
     for(int i=1;i<=f;i++){                                //     ****
       for(int j=1;j<=f-i;j++){                            //    ****
            System.out.print(" ");                       //   ****
       }   
       for(int j=1;j<=f;j++){
            System.out.print("*");
       }                                
       System.out.println();
     }


     int  k= scn.nextInt();                               //       ****
     for(int i=1;i<=k;i++){                                //     *  *
       for(int j=1;j<=k-i;j++){                            //    *  *
            System.out.print(" ");                       //   ****
       }
       for(int j=1;j<=k;j++){
       if(i==1||i==k|| j==1||j==k){
            System.out.print("*");
       } 
       else{
        System.out.print(" ");
       }
      }                               
       System.out.println();
     }




               int  u = scn.nextInt();                             
             for(int i=1;i<=u;i++){                                     
               for(int j=1;j<=u-i;j++){                            
                    System.out.print(" ");                       
               }   
               for(int j=1;j<=2*i-1;j++){
                    System.out.print("*");
               }                                            //   *
               System.out.println();                       //   ***
             }                                           //    *****
                                                         //   *******
             for(int i=u;i>=1;i--){                      //    *****                
              for(int j=1;j<=u-i;j++){                   //     ***         
                   System.out.print(" ");              //      *        
              }   
              for(int j=1;j<=2*i-1;j++){
                   System.out.print("*");
              }                                
              System.out.println();
            }




            int  r = scn.nextInt();                          //   1   
             for(int i=1;i<=r;i++){                          //  2 2           
               for(int j=1;j<=r-i;j++){                      // 3 3 3      
                    System.out.print(" ");                 //4 4 4 4      
               }   
               for(int j=1;j<=i;j++){
                    System.out.print(i+" ");
               }                                            
               System.out.println();                       
             }




             int q = scn.nextInt();                      //1  
             for(int i=1;i<=q;i++) {                     //1 2 
               for (int j=1;j<=q-1;j++){                 //1 2 3
                System.out.print(" ");                 //1 2 3 4
               }
               for(int j =1;j<=i;j++){
                System.out.print(j);
               }
               System.out.println();
          }

          

          int  y = scn.nextInt();                             
          for(int i=1;i<=y;i++){                                     
            for(int j=1;j<=y-i;j++){                            
                 System.out.print(" ");                       
            }                                                   //* 
            for(int j=1;j<=2*i-1;j++){                        //*   *
              if(i ==1 || i==y|| j==1||j==(2*i-1))           //*     *
                 System.out.print("*");                   //*       *
                                                          //************
            else{
              System.out.print(" ");
            }  
          }                                         
            System.out.println();                       
          }   
          
          

          int  w = scn.nextInt();                             
          for(int i=1;i<=w;i++){                                     
            for(int j=1;j<=w-i;j++){                            
                 System.out.print(" ");                       
            }   
            for(int j=1;j<=2*i-1;j++){
              if(j ==1|| j==2*i-1)
                 System.out.print("*");
              else{
                System.out.print(" ");
              }   
            }                                            //   *
            System.out.println();                       //   * *
          }                                           //    *   *
                                                      //   *     *
          for(int i=w;i>=1;i--){                      //   *     *                
           for(int j=1;j<=w-i;j++){                   //    *   *         
                System.out.print(" ");              //      *        
           }   
           for(int j=1;j<=2*i-1;j++){
            if(j ==1 || j==2*i-1)
                System.out.print("*");
                else{
                  System.out.print(" ");
                }
           }                                
           System.out.println();
         }


         for(int i =1;i<=n;i++){               
          for(int j=1;j<=i;j++){               //*
             if(j ==1|| j ==i ||i==n)          //**
             System.out.print("*");          //*  *
              else{                            //*****
                System.out.print(" ");
              }                                
          }                                   
          System.out.println();
        }


    
        int o = scn.nextInt();                             
        for(int i=o;i>=1;i--){                     //*******               
          for(int j=1;j<=o-i;j++){                  //*****             
               System.out.print(" ");              //***          
          }                                           //* 
          for(int j=1;j<=2*i-1;j++){
               System.out.print("*");
          }                                            
          System.out.println();                       
        } 


        int l = scn.nextInt();                             
        for(int i=l;i>=1;i--){                     //*******               
          for(int j=1;j<=l-i;j++){                  //*   *             
               System.out.print(" ");              //* *          
          }                                           //* 
          for(int j=1;j<=2*i-1;j++){
            if(i==l||j==1||j==2*i-1)
               System.out.print("*");
               else{
                System.out.print(" ");
               }
          }                                            
          System.out.println();                       
        } 


        int s = scn.nextInt();                             
        for(int i=s;i>=1;i--){                                    
          for(int j=1;j<=s-i;j++){                               
               System.out.print(" ");                          
          }                                           
          for(int j=1;j<=2*i-1;j++){
               System.out.print("*");
          }                                            
          System.out.println();                       //******
        }                                             //***** 
                                                       //***
                                                        //* 
        for(int i=1;i<=s;i++){                          //*        
          for(int j=1;j<=s-i;j++){                     //***           
               System.out.print(" ");               //*****         
          }                                          //*******  
          for(int j=1;j<=2*i-1;j++){
               System.out.print("*");
          }                                            
          System.out.println();                       
        } 




        int a1=scn.nextInt();                                                       
        for(int i=a1;i>=1;i--){                                //     ****
          for(int j=1;j<=a1-i;j++){                            //      ***
               System.out.print(" ");                       //        **
          }                                                   //         *  
          for(int j=1;j<=i;j++){
               System.out.print("*");
          }                                
          System.out.println();
        }

       int x= scn.nextInt();
     for(int i =1;i<=x;i++){
       for(int j =1;j<=x-i;j++){
        System.out.print(" ");
       }
       for(int j =1;j<=i;j++){
        System.out.print(j);
       }
       for(int j =i-1;j>=1;j--){
        System.out.print(j);
       }
       System.out.println("");

     }   

     int  b2 = scn.nextInt();    
            int num1=1;                      //   1   
             for(int i=1;i<=b2;i++){                          //  2 2           
               for(int j=1;j<=b2-i;j++){                      // 3 3 3      
                    System.out.print(" ");                 //4 4 4 4      
               }   
               for(int j=1;j<=i;j++){
                    System.out.print(num1+" ");
                    num1++;
               }                                            
               System.out.println();                       
             }


scn.close();
    }
    }
