import java.util.*;

//make classname same as those class name which is having main method
public class bubblesort {
    
    
 public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    evs ee[]=new evs[3];
    for(int i=0;i<3;i++)
    {
      int a =sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      ee[i]=new evs(a,b);
    }
    System.out.println("enter name to be matched");
   String nm=sc.nextLine();
   evs sample[]=sort(ee,nm);
   
   System.out.println("output  according to sorted id's of matched courses ");
   for(int i=0;i<sample.length;i++)
   {
       if(sample[i].getname().equals("radhika"))
       { System.out.println(sample[i].getid()+" "+sample[i].getname());}
   
   }
 }
    
    
   
    
    public static evs[] sort(evs[] arr,String nm)
    {
      for(int i=0;i<arr.length-1;i++)
      {
         for(int j=0;j<arr.length-i-1;j++)
         {
           if(arr[j].getid()>arr[j+1].getid())  
           {
              evs temp=arr[j];
              arr[j]=arr[j+1];
              arr[j+1]=temp;
           
           }
         
         }
      
      
      
      }
    return arr;
    }
}

 class evs{
     
 private int id;
  private String name;
  
public evs(int id,String name){
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