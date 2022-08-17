import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Upd implements ActionListener{
    JFrame f;
    JPanel p1;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1;
     JOptionPane n1;
     
    Upd(){
    f=new JFrame("update enetries here");
    f.setSize(700,700);
    
    p1=new JPanel();
    p1.setLayout(null);////////////////////////////////////////////
    f.add(p1);
    
    p1.setBackground(Color.blue);
    
    l1=new JLabel("rollno");
    l2=new JLabel("class");
    l3=new JLabel("usename");
    l4= new JLabel("password");
   
        
    t1=new JTextField(20);
    t2=new JTextField(20);
    t3=new JTextField(20);
    t4=new JTextField(20);
    
  n1=new JOptionPane();
  b1=new JButton("click to update records in table");    
    
    
    l1.setBounds(50,50,80,30); 
   l2.setBounds(50,100,80,30);
   l3.setBounds(50,150,80,30);
   l4.setBounds(50,190,80,30);
   
   t1.setBounds(150,50,380,30);
  t2.setBounds(150,100,380,30);
  t3.setBounds(150,150,380,30);
 t4.setBounds(150,190,380,30);
  
 b1.setBounds(150,300,240,30);
  
 l1.setForeground(Color.WHITE);
l2.setForeground(Color.WHITE);
l3.setForeground(Color.WHITE);
 l4.setForeground(Color.WHITE);
    p1.add(l1);
    p1.add(t1);
    p1.add(l2);
    p1.add(t2);
    p1.add(l3);
    p1.add(t3);
     p1.add(l4);
    p1.add(t4);
   
     p1.add(b1);
   
    f.setVisible(true);
   b1.addActionListener(this);
 
    }
    public void actionPerformed(ActionEvent e){
         if(e.getSource()== b1){
      String a1,a2,a3,a4;
      a1=t1.getText();//rolno
      a2=t2.getText();//class
      a3=t3.getText();//username
      a4=t4.getText();//password
    
       try{ 
           if(!a3.isEmpty())
           {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
           PreparedStatement stat=con.prepareStatement("Update student set username=?,password=? WHERE rollno=? AND class=?");
           
           stat.setString(1,a3);
           stat.setString(2,a4);
           stat.setString(3,a1);
           stat.setString(4,a2);
           
           
           stat.executeUpdate();
           JOptionPane n1= new JOptionPane();
           n1.showMessageDialog(null,"data updated successfull","msg box",1);
           }
           else{
            n1.showMessageDialog(null,"something went wrong , plz try again","msg box",1);
           
           }
       }
       catch(Exception ew){
           System.out.println(ew);
       }

         }
    }
    public static void main(String p[]){
    Upd v=new Upd();
    }
}
