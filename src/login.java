import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class login implements ActionListener {
    
       JFrame f;
        JPanel p;
        JLabel l,l1,l2;
        JTextField t1,t2;
        JButton b1,b2;
        Font n1,n2;
        JOptionPane n,nx;
   
    
    
    
    login()
    {
        
    f=new JFrame("my project");
    f.setSize(1350,700);
    p=new JPanel();
    
    p.setLayout(null);
    p.setBounds(20,20,680,680); 
     
    n1=new Font("brush script up",Font.BOLD,28);
    n2=new Font("times new roman",Font.BOLD,17);
    
    
    l=new JLabel("Login  Form");
    l1=new JLabel("Enter Username");
    l2=new JLabel("Enter Password");
    
    t1=new JTextField(20);
    t2=new JTextField(20);
    
    b1=new JButton("ok");
    b2=new JButton("forgot password");

     n=new JOptionPane();
     nx=new JOptionPane();
    
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    
    l.setBounds(200,120,180,30);
    l1.setBounds(100,170,150,30);
    t1.setBounds(260,170,150,30);
    l2.setBounds(100,210,150,30);
    t2.setBounds(260,210,150,30);
    b1.setBounds(170,270,150,30);
    b2.setBounds(170,310,150,30); 
    
    l.setFont(n1);
    l1.setFont(n2);
    l2.setFont(n2);
    
    
     l.setForeground(Color.WHITE);
    l1.setForeground(Color.WHITE);
    l2.setForeground(Color.WHITE);
  

    t1.setBackground(Color.WHITE);
    t2.setBackground(Color.WHITE);
    b1.setBackground(Color.WHITE);
    b1.setForeground(Color.black);
    b2.setBackground(Color.WHITE);
    b2.setForeground(Color.black);
        
   Color c1=new Color(60,30,150);
    p.add(l);
    p.add(l1);
    p.add(l2);
    p.add(t1);
    p.add(t2);
    p.add(b1);
    p.add(b2);
    p.setBackground(c1);
    
    f.add(p);
    f.setVisible(true);
    }
  
  public void actionPerformed(ActionEvent e){
      
   String x,x1;
    
if(e.getSource()==b1){

     
     try{
          x=t1.getText();
         x1=t2.getText();
         Class.forName("com.mysql.jdbc.Driver");
         Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
         PreparedStatement p=cc.prepareStatement("SELECT username,password FROM student WHERE username='"+x+"'");
         ResultSet rs=p.executeQuery();
 while(rs.next())
 {
    if((x.isEmpty())||(x1.isEmpty()))
    {nx.showMessageDialog(null,"no such user found plz contact admin","msgbox",3);}
     
     else if( (!x.isEmpty())&&(!x1.isEmpty()) &&(x.equals(rs.getString("username")))&&(x1.equals(rs.getString("password"))) ) 
 {
  n.showMessageDialog(null,"credentials are verified","msgbox",3);
  new stuhomepage();
 }
 
 
 }
 }
 catch(Exception ew){
 System.out.println(ew);
         }
 }
 else{
 new userforgot();
 
 }

  }  
  public static void main(String args[]){
        login l=new login();
    }   
}
