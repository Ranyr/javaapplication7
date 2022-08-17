import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Trial implements ActionListener{
    JFrame f;
    JPanel p;
     JTextField t1;
      JTextField t2;
      JButton b1;
      JOptionPane n1;
    public static void main(String args[])
    { Trial tr=new Trial();}
    
    Trial(){
        f=new JFrame("my frame");
        f.setSize(700,700);
        p=new JPanel();
        f.add(p);
        
    t1=new JTextField(20);
    t2=new JTextField(20);
    b1=new JButton("click");
    n1=new JOptionPane();
    
    p.add(t1);
    p.add(t2);
    p.add(b1);
    b1.addActionListener(this);
    f.setVisible(true);
    }
     public void actionPerformed(ActionEvent ee){
         if(ee.getSource()==b1){
             String a1,a2;
             a1=t1.getText();
             //a2=t2.getText();
    try{
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
    PreparedStatement st=con.prepareStatement("update  trial set password='abc' where username=?");
      st.setString(1,a1);
         //st.setString(2,a2);
         st.executeUpdate();
         n1.showMessageDialog(null,"registed successlly","msgbox",3);
       } 
    catch(Exception e)
        {System.out.println(e);}


    }
}    
}
