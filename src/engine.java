import java.util.*;
class myclass{
    
int id;
String name;
String type;
double price;
  myclass(int id,String name,String type,double price){
  this.id=id;
  this.name=name;
  this.type=type;
  this.price=price;
 
  } 

}

 public class engine{

public static void main(String args[]){

Scanner sc=new Scanner(System.in);
myclass myy[]=new myclass[3];
for(int i=0;i<myy.length;i++)
{
   int a=sc.nextInt();sc.nextLine();
   String b=sc.nextLine();
   String c=sc.nextLine();
   double d=sc.nextDouble();sc.nextLine();
   
   myy[i]= new myclass(a,b,c,d);
 
}
 /*System.out.println("enter value to be matched");
 String pm=sc.nextLine(); */
 System.out.println("enter name to be matched");
 String pm1=sc.nextLine();
 /*System.out.println("ist method output");  
 double value =findavgenginepricebytype(eng,pm);
 System.out.println("value is = "+ value);*/
 
 System.out.println("second method output");
 myclass sp[]=searchengbyname(pm1,myy);
 if(sp==null)
 {
   System.out.print("no course found");
 }
 else{
  for(int i=0;i<sp.length;i++)
  {
     System.out.println(sp[i].id);
  }
 }
}
//ist method////////////////////////////////////////////////////////////////////////////////////////
/*public static double findavgenginepricebytype(engine eng[],String pm)
{
    double sum=0;
    int count=0;
    for(int i=0;i<eng.length;i++)
    {
     if(eng[i].type.equals(pm))
     {   sum=sum+eng[i].price; 
         count++;
     }
     
    }
  if(sum !=0)
    {return sum/count;}  
  return 0;
}*/
///2nd method////////////////////////////////////////////////////////////////////
public static myclass[] searchengbyname(String pm1,myclass myy[])
{  
   int  count=0;
   myclass ex[]=new myclass[0];
   for(int i=0;i<ex.length;i++)
   { 
       if(myy[i].name.equals(pm1))
       {   
            ex=Arrays.copyOf(ex,ex.length+1);
            ex[ex.length-1]=myy[i];
       }
   }
 // Arrays.sort(ex);
 for(int i=0;i<ex.length-1;i++)
   {
    for(int k=0;k<ex.length-i-1;k++)
    {
       if(ex[k].id>ex[k+1].id)
       {
         myclass temp= ex[k];
         ex[k]=ex[k+1];
         ex[k+1]=temp;
        
       }
    
    } 
   
   }
 return ex;
 
 
 
}

}