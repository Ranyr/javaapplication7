  import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
  
public class addattend  implements ActionListener{
JFrame f;
    JPanel p;
    JLabel l,l3,l1,l2;
    JTextField t1,t2,t3;
    JOptionPane n,n1,n2,n3;
    JButton b1,b2,b3,b4;
    Font o;
    
        
    addattend(){
    f=new JFrame("desk");
    f.setSize(700,600);
    
   
    p=new JPanel();
    p.setLayout(null);
    
    f.add(p);
     

    o=new Font("Monotype Corsiva",Font.BOLD,25);
    n=new JOptionPane();
    n1=new JOptionPane();
    n2=new JOptionPane();
    n3=new JOptionPane();
    
 l=new JLabel("ATTENDANCE UPDATION");
 l1=new JLabel("rollno");   
l2=new JLabel("class");
l3=new JLabel("Attendance");



t1=new JTextField(50);
t2=new JTextField(50);
t3=new JTextField(50);


b1=new JButton("submit");
b2=new JButton("reset");
b3=new JButton("delete");
b4=new JButton("update");

l.setBounds(230,40,330,40);
l1.setBounds(180,90,100,27);
l2.setBounds(180,120,100,27);
l3.setBounds(180,150,180,27);



t1.setBounds(350,90,190,25);
t2.setBounds(350,120,190,25);
t3.setBounds(350,150,190,25);


l.setFont(o);
l1.setFont(o);
l2.setFont(o);
l3.setFont(o);


 
 l.setForeground(Color.WHITE);
 l1.setForeground(Color.WHITE);
 l2.setForeground(Color.WHITE);
 l3.setForeground(Color.WHITE);

 
 p.setBackground(Color.blue);
 
p.add(l);
p.add(l1); 
p.add(l2);
p.add(l3);



p.add(t1);
p.add(t2);
p.add(t3);




b1.setBounds(300,300,150,25);
b2.setBounds(300,330,150,25);
b3.setBounds(300,360,150,25);
b4.setBounds(300,390,150,25);

b1.setFont(o);
b2.setFont(o);
b3.setFont(o);
b4.setFont(o);
p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);
f.add(p);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
f.setVisible(true);
 
    }
    public void actionPerformed(ActionEvent e){
         String a1,a2,a3;
            a1=t1.getText();
             a2=t2.getText();
              a3=t3.getText();
              
          
    if(e.getSource()==b1){  //addtion of new entry 
        
          if(!(a1.isEmpty()) && !(a2.isEmpty()) && !(a3.isEmpty())){        
             try{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
               PreparedStatement st=con.prepareStatement("INSERT INTO attendance VALUES(?,?,?)");
     
             st.setString(1,a1);//a3=attendance rollno
             st.setString(2,a2);//a1=rollno  class 
             st.setString(3,a3);//a2=class  attendance


            st.executeUpdate();
            n1.showMessageDialog(null,"attendance inserted successfully","confirmation msg",1);
              }
            catch(Exception ew){
                      System.out.println(ew);
                       }
        }
          else{n1.showMessageDialog(null,"empty fields are not allowed","confirmation msg",1);}
         
    } 
        //reset button is pressed
        else if(e.getSource()==b2){
            
         t1.setText(" ");     
          t2.setText(" ");     
          t3.setText(" ");     
             
            
          
        }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
        else if(e.getSource()==b3){        //for deletion make rollno ,class mandatory to enter from user
            
            if(!(a1.isEmpty()) && !(a2.isEmpty())){
                
            try{
          
         
         Class.forName("com.mysql.jdbc.Driver");
         Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
         PreparedStatement p=cc.prepareStatement("SELECT rollno,class FROM attendance WHERE rollno='"+a1+"'");
         ResultSet rs=p.executeQuery();
 while(rs.next())
 {
  if( (a1.equals(rs.getString("rollno")))&&(a1.equals(rs.getString("class"))) )
  {
    n2.showMessageDialog(null,"yesss","confirmation msg",2);   
                        
         // try{
         //  Class.forName("com.mysql.jdbc.Driver");
         //  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
         /*  PreparedStatement stat=cc.prepareStatement("Delete from attendance where rollno=? AND class=?");
           stat.setString(1,a1);
           stat.setString(2,a2);
           stat.executeUpdate();
           JOptionPane n1=new JOptionPane();
           n1.showMessageDialog(null,"record deleted successfully","msg box",1);*/
       }
  
  else{ n2.showMessageDialog(null,"invalid","confirmation msg",3);}
 }
            }
       catch(Exception ew){
           System.out.println(ew);
       }
         
            }  
            
            
            
            else{
            
             n.showMessageDialog(null,"it's mandatory to fill both class and rollno","confirmation msg",1);
            
            }  
        }
    
    }
    
        

    public static void main (String args[]){
   addattend s=new addattend();
}
  
  
}
  //