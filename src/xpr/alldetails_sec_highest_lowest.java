
package xpr;
import java.util.*;

public class alldetails_sec_highest_lowest {
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      
      soll arr[]=new soll[3];
      for(int i=0;i<3;i++)
      {
      int  a=sc.nextInt(); sc.nextLine(); // Id
      String b=sc.nextLine();  //name
      arr[i]=new soll(a,b);
      }
   /*System.out.println(" print whole table data according to sorted id");
    soll ans[]= data_acc_to_sorttedid(arr);
    for(int i=0;i<ans.length;i++)
    {
    
     System.out.println(ans[i].getid());
     System.out.println(ans[i].getname());
    } */
   
       /* soll ans1=second_highest_id(arr);
    
          System.out.println(ans1.getid());
          System.out.println(ans1.getname());  */
 
     soll trial=secondlowest_id(arr);
     System.out.println(trial.getid());
     System.out.println(trial.getname());
    }
    
  /* public static soll[] data_acc_to_sorttedid(soll arr[])
   {   
     
      for(int i=0;i<arr.length-1;i++)
      {
         for(int j=0;j<arr.length-i-1;j++)
         {
           if(arr[j].getid()>arr[j+1].getid())  
           {
              soll temp=arr[j];//*********here var type=evv***************************************
              arr[j]=arr[j+1];
              arr[j+1]=temp;
           
           }
         
         }  
      
      }
     return arr;
  } */
   
   
  /* public static soll second_highest_id(soll ap[])
   {
        int hp[]=new int[0];
        for(int i=0;i<3;i++)
        {
          hp= Arrays.copyOf(hp,hp.length+1);
          hp[hp.length-1]=ap[i].getid();
        }
       Arrays.sort(hp);
       System.out.println("after sorting");
       for(int i=0;i<hp.length;i++)
       {
           System.out.println(hp[i]);
                       
       }
       int x=hp[hp.length-2];
       System.out.println("second highest id ="+x);
       for(int i=0;i<ap.length;i++)
       {
          if(ap[i].getid()==x)
          {return ap[i];}
       }
       return null;
   } */
    
    public static soll secondlowest_id(soll ap1[])
    {  
     int help2[]=new int[0];
     for(int i=0;i<ap1.length;i++)
     {
      help2= Arrays.copyOf(help2,help2.length+1);
      help2[help2.length-1]=ap1[i].getid();
     }
    
     System.out.println("array after sorting");
      Arrays.sort(help2);
     for(int i=0;i<help2.length;i++)
     {System.out.println(help2[i]);}
     
     int y=help2[1];  //***********************2nd lowest id***************************************************
     System.out.println("second lowest id= "+y);
     System.out.println("details of second lowest object");
     for(int i=0;i<ap1.length-1;i++)
     {
        if(ap1[i].getid()==y)
        {return ap1[i];}
     }
     return null;
    }
    
}



 class soll {
 
 int id;
 String name;

 
 soll(int id,String name)
 {
   this.id=id;
   this.name=name;
   
 }
 
 public void setid(int id)
 {
   this.id=id;
 }
 public void setname(String name){this.name=name;}
 
 
 public int getid(){return id;}
 public String getname(){return name;}


 }