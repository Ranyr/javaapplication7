// enter 3 int id ,string date, enter matched month******* print details of students containing particular month
package xpr;

import java.util.*;
public class strngsplit 
{
   public static void main(String args[])
   {
    Scanner sc=new Scanner(System.in);
    std arr[]=new std[3];
    System.out.println("enter 3 i/ps for id(int),date(string)  in date format dd-mm-yyy");
    for(int i=0;i<arr.length;i++)
    {
        int a=sc.nextInt(); sc.nextLine();
        String b=sc.nextLine();//s[1]=12-may-2000 ,s[2]=11-may-1999,s[3]=13-june-1990
        arr[i]=new std(a,b);
    }
    System.out.println("enter MONTH to be matched in STRING FORMAT ");
    String pm=sc.nextLine();
    std ans[]=splt(arr,pm);//call goes to static method
    // display output
    if(ans == null){
      System.out.println("not found");
    }
    else{
        for(int i=0;i<ans.length;i++)
        {
            System.out.println("hello");
          System.out.println(ans[i].id+"   "+ans[i].date);
        }
    
    }
   
   }
   
   public static std[] splt(std[] arr,String pm){
   System.out.println(" spliting starting from - "); 
    //11     may      2000
   //k=0      k=1      k=2 
    //**************int pos=indexof("-")********************************************
    //**************int pos11=s.indexOf(what to search,from where to search)************
    //**************int pos11=s.indexOf('-',pos+1);it will given
    // in order to search loc of 2nd -,here pos represents location of 1st - but we want position of 2nd - that's why we wrote pos+1
   std help[]=new std[0];
    for(int i=0;i<arr.length;i++)
    {  System.out.println(" i= "+1);
       int pos1=arr[i].date.indexOf("-");//13-may-2000 index=2
       int pos2=arr[i].date.indexOf('-',pos1+1); //start searching the location of 2nd - from index=3
       System.out.println("pos1= " +pos1+ "  pos2=  "+pos2);
       String str=arr[i].date.substring(pos1+1,pos2); // i=0  mth=13, i=1 mnth=8, i=2 mnth=15 ,i=3  mnth=16
       if(str.equals(pm))
       {  System.out.println(arr[i].id+"  "+arr[i].date+"  "+" yes equal");
          help= Arrays.copyOf(help,help.length+1);
          help[help.length-1]=arr[i];
       }
    }
    System.out.println("length= "+help.length);
    if(help.length>0)   
    {return help;}
    else{  return null; }
  } 
   
   }  
   

class std{

int id;
String date;
std(int id,String date)
{
 this.id=id;
 this.date=date;
}


public void setid(int id){
this.setid(id);
}
public int getid(){
return id;
}


public void setdate(String date){
 this.setdate(date);
}
public String getdate()
{return date;}


}