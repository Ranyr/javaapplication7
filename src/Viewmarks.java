

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;




public class Viewmarks implements ActionListener{
   
     JFrame f;
    JPanel p;
    JLabel l,l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1;
    Font o;
    Viewmarks(){
    f=new JFrame("my app");
    f.setSize(700,700);
    
    p=new JPanel();
    p.setLayout(null);
    f.add(p);
    
    o=new Font("brush script up",Font.BOLD,24);
    p.setBackground(Color.BLUE);
    
    l=new JLabel("Enter Rollno and Class to Get Marksheet");
    l1=new JLabel("Rollno");
    l2=new JLabel("class");
    l3=new JLabel("obtained Marks");
    l4=new JLabel("Max Marks");
    
    t1=new JTextField(20);
    t2=new JTextField(20);
    t3=new JTextField(20);
     t4=new JTextField(20);
    
    b1=new JButton("submit"); 
l.setBounds(140,170,490,25);
l1.setBounds(213,210,90,40);
t1.setBounds(330,220,190,25);

l2.setBounds(210,255,110,40);
t2.setBounds(330,265,190,25);

l3.setBounds(210,300,130,40);
t3.setBounds(330,310,190,25);

l4.setBounds(210,345,130,40);
t4.setBounds(330,355,190,25);

b1.setBounds(220,430,100,25);
l.setFont(o);
l.setForeground(Color.WHITE);
l1.setForeground(Color.WHITE);
l2.setForeground(Color.WHITE);
l3.setForeground(Color.WHITE);
l4.setForeground(Color.WHITE);
    
    p.add(l);
    p.add(l1);
    p.add(t1);
    p.add(l2);
    p.add(t2);
    p.add(l3);
    p.add(t3);
    p.add(l4);
     p.add(t4);
 p.add(b1);
    f.setVisible(true);
    b1.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent e){
     String a1;
     a1=t1.getText();
     
     if(e.getSource()==b1){
     try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
     PreparedStatement stat=con.prepareStatement("Select * from marks where rollno=?");
     
     stat.setString(1, a1);
     ResultSet res=stat.executeQuery();
     while(res.next()){
     t1.setText(res.getString(1));
     t2.setText(res.getString(2));
     t3.setText(res.getString(3)); 
      t4.setText(res.getString(4)); 
     }
     }
     catch(Exception ep){
     System.out.println(ep);
     }
     
     }
  
    }
    public static void main(String p[]){
   Viewmarks s= new Viewmarks();
  
    }
}
