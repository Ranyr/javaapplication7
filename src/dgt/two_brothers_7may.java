
package dgt;
/*
two brothers b1,b2
input: N=20
output: 10 4(no.of crayons each boy had)

Explanation
it is instructed that Game starts by  b1=turn 1
turn1,turn2,turn3,turn4
b1,b2,b1,b2,b1,b2
at each turn 
(b1 will have no.of caryon=3^turn caryons)b1=3^turn
(b2 will have no. of caryon=4^turn caryons)b2=4^turn

Game will ends when at t turns any brother demands (no. of caryons) > (remainig no of caryons)

turn 0: b1 gets 3^0,i.e. b1 gets 1 caryon, remaining caryons=20-1=19 
turn 1: b2 gets 4^1, i.e. b2 gets 4 caryons ,remaining caryons=19-4=15
turn 2: b3 gets 3^2 i.e b3 gets 9 caryons,remaining caryons= 15-9= 6 
turn 3: b4 gets 4^3 i.e b4 gets 64 caryons,here game ends -----as 64(demanding caroyns)>6(remaining caryons)
so b1=  1+9 = 10 caryons
   b2=  4  caryons 
*/
import java.util.*;
public class two_brothers_7may 
{
   public static void main(String args[]) 
   {
     Scanner sc=new Scanner(System.in);
     System.out.println("enter n as no. of caryons");
     
     int n=sc.nextInt();
     int flag=0,turn=0,count_caryon_b1=0,count_caryon_b2=0,b1=0,b2=0;
     
     while(flag ==0)
     {
       b1=(int)Math.pow(3,turn);
       if(b1>n)
         {flag=1;break;}
       else
         {
            System.out.println(" turn= "+turn);
             n=n-b1;
            turn=turn +1;
          count_caryon_b1=count_caryon_b1+b1;

           System.out.println("remaining n= "+n);
           System.out.println("b1 has cc= "+count_caryon_b1);
         }
       
       b2=(int)Math.pow(4,turn);
       if(b2>n)
         {flag=1;break;}
       else
         {
          System.out.println("turn= "+turn);
             
          n=n-b2;
          turn=turn +1;
          count_caryon_b2=count_caryon_b2+ b2;
     
          System.out.println("remaining n= "+n);
          System.out.println("b2 has cc= " + count_caryon_b2);
         }
     }
     System.out.println("At last ********************");
     System.out.println("count_caryon_b1= "+count_caryon_b1);
     System.out.println("count_caryon_b2= "+count_caryon_b2);
   }
    
}
