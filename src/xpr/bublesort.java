//bubble sort

package xpr;

import java.util.Arrays;
import java.util.Scanner;


public class bublesort {
    
public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    evv ee[]=new evv[3];
    // taking input from user
    System.out.println("enter 3 i/ps for these 2 attributes id(int),name(string) parameters");
    for(int i=0;i<3;i++)
    {
      int a =sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      ee[i]=new evv(a,b);
    }
    System.out.println("enter name to be matched");
   String nm=sc.nextLine();
   
   // call goes to static method
   evv sample[]=sort(ee,nm);
   
   // display  output 
   System.out.println("output  according to sorted id's of matched courses ");
   for(int i=0;i<sample.length;i++){    
        System.out.println("heloo");
       System.out.println(sample[i].getid());
         System.out.println(sample[i].getname());
       
   
   }
 }
    
    
   
    
 public static evv[] sort(evv[] arr,String nm)
 {  
        evv help[]=new evv[0];
   for(int i=0;i<arr.length;i++)//if given name matched with already present array then copy those whole rows into new help array
   { 
       if(arr[i].getname().equals(nm))//********inital comparison must be made by taking arr[i] array********
       {   
            help=Arrays.copyOf(help,help.length+1);//*********Array.copyOf()must be assigned to help**********
            help[help.length-1]=arr[i];//*********here arr[i] must be assigned to help[]*****************
       }
   }
        
    //now sort help array according to given id's    
        
      for(int i=0;i<help.length-1;i++)
      {
         for(int j=0;j<help.length-i-1;j++)
         {
        //   if(help[j].getid()< help[j+1].getid()) ***************sort array in descending order 
           if(help[j].getid()>help[j+1].getid())
           {
              evv temp=help[j];//*********here var type=evv***************************************
              help[j]=help[j+1];
              help[j+1]=temp;
           
           }
         
         }  
      
      }
    return help;
    }
}

 


class evv{
     
 private int id;
  private String name;
  
public evv(int id,String name){
 super();
 this.id=id;
 this.name=name;
}
 public int getid()
 {return id;}
 
 public void setid(int id)
 {this.id=id;}
 
 public String getname()
 {return name;}
 public void setname(String name){
  this.name=name;
 }
 
 
 }

