import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Dlt implements ActionListener{
     JFrame f;
    JPanel p1;
    JLabel l,l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
 JButton b1;
    
    Dlt(){
    f=new JFrame("delete enetries here");
    f.setSize(700,700);
    
    p1=new JPanel();
    p1.setLayout(null);////////////////////////////////////////////
    f.add(p1);
    p1.setBackground(Color.blue);
    
    l=new JLabel("Deletion of records");
    l1=new JLabel("rollno");  
    t1=new JTextField(20);
    l2=new JLabel("class");
    t2=new JTextField(20);
    b1=new JButton("click to delete records in table");    
    
    l.setBounds(70,80,150,30);
    l1.setBounds(50,120,50,30);
    t1.setBounds(150,120,180,30);
    l2.setBounds(50,160,50,30);
    t2.setBounds(150,160,180,30);
    b1.setBounds(150,210,250,30);
    
    l.setForeground(Color.WHITE);
    l1.setForeground(Color.WHITE);
    l2.setForeground(Color.WHITE);
     
    p1.add(l);
    p1.add(l1);
    p1.add(t1);
    p1.add(l2);
    p1.add(t2);
    p1.add(b1);
   
   f.setVisible(true);
   b1.addActionListener(this);
 
    }
    public void actionPerformed(ActionEvent e){
         if(e.getSource()==b1){
      String a1,a2;
      a1=t1.getText();
      a2=t2.getText();
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
           PreparedStatement stat=con.prepareStatement("Delete from marks where rollno=? AND class=?");
           stat.setString(1,a1);
           stat.setString(2,a2);
           stat.executeUpdate();
           JOptionPane n1=new JOptionPane();
           n1.showMessageDialog(null,"record deleted successfully","msg box",1);
       }
       catch(Exception ew){
           System.out.println(ew);
       }

         }
    }
    public static void main(String p[]){
    Dlt d=new Dlt();
    }
}
