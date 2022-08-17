//search details of students having matched ids,*********finding student having max age
package xpr;
import java.util.*; 
 class student 
 {
   private int id;
   private String name;
   private int marks;
   private int age;
    
    student(int id,String name,int marks,int age)
    {
       this.id=id;
       this.name=name;
       this.marks=marks;
       this.age=age;
    }
    
    public void setid(int id)
    {
    this.setid(id);
    }
    public int getid(){
    return id;
    }
    
    
    public void setname(String name){
       this.setname(name);
    } 
    public String getname()
    {return name;}

    
  public void setmarks(int marks)
  {
      this.setmarks(marks);
  }
  public int getmarks()
  {
    return marks;
  }

public void setage(int age){
   this.setage(age);
}
public int getage(){
    return age;
}    
}

///////////////////////////////solution////////////////////////////////////////////////////////
public class sol{
    
public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    student oj[]=new student[3];
    System.out.println("enter array details");
    for(int i=0;i<oj.length;i++)
    {
       int a=sc.nextInt();sc.nextLine();//id
       String b=sc.nextLine();  //name
       int c=sc.nextInt();sc.nextLine();  //marks
       int d=sc.nextInt();sc.nextLine();  // age
       
       oj[i]=new student(a,b,c,d);
    }
    System.out.println("enter range");
    int m=sc.nextInt();
    
  System.out.println("first method output"); 
  student ans1=findstudentwithmaxage(oj,m);
  if(ans1 == null)
   {System.out.println("no obj found");}
  else
  {
    System.out.println(ans1.getid());
    System.out.println(ans1.getname());
     /* System.out.println(ans1.getmarks());
       System.out.println(ans1.getage());  */
  }
 /*System.out.println("enter matched id"); 
 int ids=sc.nextInt();*/
/*student ans2=searchstudentbyid(oj,ids);
System.out.println("second method output");
if(ans2==null)
{System.out.println("not having any idea");}
else
{
 System.out.println(ans2.getid()); 
System.out.println(ans2.getname());
System.out.println(ans2.getmarks());
System.out.println(ans2.getage());
}*/

/*student ans3[]=searchid(oj,ids);
System.out.println("print all students objects having matched id");
for(int i=0;i<ans3.length;i++)
{
System.out.println(ans3[i].getid());
System.out.println(ans3[i].getname());
System.out.println(ans3[i].getmarks());
System.out.println(ans3[i].getage());
}*/


}


//********************finding maximum age from given table,if that max age person having marks greater than  **************************************
public static student findstudentwithmaxage(student oj[],int m)
{  
    //int max1= Integer.MIN_VALUE;
   int max=oj[0].getage();int loc=0;
   for(int i=1;i<oj.length;i++)
   {
    if(oj[i].getage()>max)
     {//max=oj[i].getage();
         loc=i;     
     } 
   }

  if(oj[loc].getmarks()>m) 
  {
      return oj[loc];
  }
  else
  {
    return null;
  }
      
 /* for(int i=0;i<oj.length;i++)
   {
       if(oj[i].getage()==max)
       {
          return oj[i]; 
       }
   }  */

}

//*****************************search details of student having matched id*****************************************
 /* public static student searchstudentbyid(student oj[],int ids)
  {
      for(int i=0;i<oj.length;i++)
      {
       if(oj[i].getid()==ids) 
       {
           return oj[i];
       }
      }
  return null;
  }*/

//*********************** print all students having matched idds given id***********************
/*public static student[] searchid(student oj[],int idds)
{  
  student help[]=new student[0];
  
  for(int i=0;i<oj.length;i++)  
  {
       if(oj[i].getid()==idds)
       {
         help=Arrays.copyOf(help,help.length+1);
         help[help.length-1]=oj[i];
       
       }
  }
  if(help.length>0)
  {return help;}
 else
  {return null;}
  
}*/


}


