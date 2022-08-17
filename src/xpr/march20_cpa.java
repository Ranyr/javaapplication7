
package xpr;

import java.util.*;
public class march20_cpa 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        flowers fl[]=new flowers[4];
        for(int i=0;i<4;i++)
        {
           int a=sc.nextInt();sc.nextLine();
           String b=sc.nextLine();
           int c=sc.nextInt();sc.nextLine();
           int d=sc.nextInt();sc.nextLine();
           String e=sc.nextLine();
           fl[i]=new flowers(a,b,c,d,e);
        }
        System.out.println("enter matched type");
        String tp=sc.nextLine();
       flowers ans=findminpricebytype(fl,tp);//if its Rating <3
        if(ans == null){System.out.println("there is no flower");}
        else{System.out.println("id= "+ans.getFlowerid());}
       
       
    }
    
    public static flowers findminpricebytype(flowers fl[],String tp)
    {
      int min=Integer.MAX_VALUE;
      flowers help[]=new flowers[3];
        for(int i=0;i<fl.length;i++)
        {
           if((fl[i].getType().equalsIgnoreCase(tp))&&(fl[i].getRating()>3))
           {
               
             if(fl[i].getPrice()<min)
             {
               min=fl[i].getPrice();
             
             }   
              
           }
        }
            
     
      
        
     /*   for(int i=0;i<help.length-1;i++)
        {
           for(int j=0;j<help.length-i-1;j++)
           {
                 if(help[j].getFlowerid()>help[j+1].getFlowerid())
                 {
                     flowers temp= help[j];
                     help[j]=help[j+1];
                     help[j+1]=temp; 
                 }
           
           }
        
        }*/
      
        for(int i=0;i<fl.length;i++)
       {
           if(fl[i].getPrice()==min)
           {return fl[i];}
       
       
       }
       return null;
    }

}

class flowers{

    int flowerid;
    String flowername;
    int price;
    int rating;
    String type;

    public flowers(int flowerid, String flowername, int price, int rating, String type) {
        this.flowerid = flowerid;
        this.flowername = flowername;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }

    public int getFlowerid() {
        return flowerid;
    }

    public void setFlowerid(int flowerid) {
        this.flowerid = flowerid;
    }

    public String getFlowername() {
        return flowername;
    }

    public void setFlowername(String flowername) {
        this.flowername = flowername;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

}