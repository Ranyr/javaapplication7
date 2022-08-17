
package dgt;
/*Input : n=5,l=4 
arr[n]={7,4,3,4,2}
 find first and last index of l and print both indexes 
output:1 3  */

/*example 2:arr[n]={2,3,1,4,6,7}, l=3 ,output: 1 1
if 3 ocuurs only once then print same index  twice  */

import java.util.*;
public class govsurvey7_may 
{
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter height of building");
      int n=sc.nextInt();
      System.out.println("enter "+n+  "enteries for array");
      int a[]=new int[n];
      int l=0;
      
      for(int i=0;i<n;i++)
      {
        a[i]=sc.nextInt();    
      }
       System.out.println("enter searching value l ");
       l=sc.nextInt();
       Arrays.sort(a);
       int loc=0,loc1=0;
      for(int i=0;i<n;i++)
      {
        if(a[i]==l)
        {loc=i;break;}  
       
      }
      for(int i=loc+1;i<n;i++)
      {
        if(a[i]==l)
        {loc1=i;break;}
      }
      
      if((loc !=0)&&(loc1 !=0))
      {
        System.out.println("loc= "+loc+   " loc1= "+loc1);  
      }
      else if((loc !=0)&&(loc1==0))
      {System.out.println("loc= "+loc+" "+loc );}
      else if((loc1 !=0)&&(loc ==0))
      {System.out.println("loc1 = "+loc1+" "+loc1);}
      else
      {System.out.println("not found");}
    }
    
}
