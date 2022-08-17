import java.util.*;
public class trii {
   
      public static void main(String args[])
      {
       Scanner sc=new Scanner(System.in);
       solution sol[]=new solution[3];
       System.out.println("enter 3 inputs");
       for(int i=0;i<3;i++)
       {
            int a=sc.nextInt();sc.nextLine();
            String b=sc.nextLine();
            double c=sc.nextDouble();sc.nextLine();
            sol[i]=new solution(a,b,c);
       }
       
      System.out.println("enter id so that you get sorted record lesser than those id");
      int idd=sc.nextInt();
      solution ans1[]=dispnmsacctosortedid(sol,idd);
      
          System.out.println("first output names ");
          for(int i=0;i<ans1.length;i++)
          {
                  System.out.println(ans1[i].getnm());
          
          }
      
      }
      
      public static solution[] dispnmsacctosortedid(solution sol[],int idd)
      {
          solution help[]=new solution[0];
          for(int i=0;i<sol.length;i++)
          {
             if(sol[i].getid()<idd)
             {
              help= Arrays.copyOf(help,help.length+1);   
              help[help.length-1]=sol[i];
             } 
          }
          
          
          
          for(int i=0;i<help.length;i++)
          {
             for(int j=0;j<help.length-i-1;j++)
             {
                 if(help[j].getid()<help[j+1].getid())
                 {
                      solution temp=help[j];
                      help[j]= help[j+1];
                      help[j+1]= temp;
                 }
             
             
             }
          
          }
      
        if(help.length>0){return help;}
        else
        { return null;}
      
      
      } 
}
  class solution{
  
    
   int id;
    String nm;
    double marks;
    
    public solution(int id,String nm,double marks)
    {
      this.id=id;
      this.nm=nm;
      this.marks=marks;
    }
    public void setid(int id){this.id=id;}
    public void setnm(String nm){this.nm=nm;}
    public void setmarks(double marks){this.marks=marks;}
    
    public int getid(){return id;}
    public String getnm(){return nm;}
    public double getmarks(){return marks;}
  
  }