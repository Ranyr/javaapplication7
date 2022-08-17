/* Input n=6, r=3(search for the element present in the array,not index)
   a[n]={1,2,3,4,7,9}
   Arrange Students in Ascending Order
   find position of studentno=r , if teacher calls student no(r)=7 ,
   case1 :if 7 is already prsent in the row then return its index=4
   case2 :if 7 is not present in the array then search for the position where 7 can be placed in row then return 
   that index where 7 can be placed in asscending order array
*/
package dgt;
import java.util.*;
public class ptinstructor7may 
{
    
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      System.out.println("enter n");
      int n=sc.nextInt();
      System.out.println("enter "+n+" array elements");
      int a[]=new int[n]; 
     for(int i=0;i<n;i++)
     {
       a[i]=sc.nextInt();
     }
     System.out.println("enter student no R for seraching its index in array");
     int r=sc.nextInt();
     int flag=0;
     Arrays.sort(a);
     for(int i=0;i<n;i++)
     {
       if(a[i]==r)
       {   flag=1;
           System.out.println("rth student is present at index= "+i);
           break;
       }
     }
     
     if(flag==0)
     {
       for(int i=0;i<n;i++)
       {
           if(a[i]>r)
           {
             System.out.println("rth student must join the array at index = "+i);
             break;
           }
       }
     }
     
    }
    
}
