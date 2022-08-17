import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class viewattend implements ActionListener{
    JFrame f;
    JPanel p;
    JLabel l,l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1;
    JOptionPane n1,n2,n3;
    Font o;
viewattend(){
f=new JFrame("desktop app");
f.setSize(700,700);

p=new JPanel();
p.setLayout(null);
f.add(p);
n1=new JOptionPane();
n2=new JOptionPane();
n3=new JOptionPane();

o=new Font("brush script up",Font.BOLD,24);
p.setBackground(Color.BLUE);
l=new JLabel("Enter Credentials to Get ATTENDANCESHEET");
l1=new JLabel("rollno");
t1=new JTextField();
l2=new JLabel("class");
t2=new JTextField();
l3=new JLabel("attendance");
t3=new JTextField();

b1=new JButton("go");

l.setBounds(130,170,560,25);
l1.setBounds(213,210,90,40);
t1.setBounds(330,220,190,25);

l2.setBounds(210,255,110,40);
t2.setBounds(330,265,190,25);

l3.setBounds(210,300,130,40);
t3.setBounds(330,310,190,25);



b1.setBounds(290,430,100,25);
l.setFont(o);
l.setForeground(Color.WHITE);
l1.setForeground(Color.WHITE);
l2.setForeground(Color.WHITE);
l3.setForeground(Color.WHITE);



p.add(l);
p.add(l1);
p.add(l2);
p.add(l3);

p.add(t1);
p.add(t2);
p.add(t3);

p.add(b1);
b1.addActionListener(this);
f.setVisible(true);

}
//perform action on clicking on button b
public void actionPerformed(ActionEvent e){
    String a1,a2;
    a1=t1.getText(); //rollno
    a2=t2.getText();//class
 
    if(e.getSource()==b1)
    {
     try{
          
        
       
         Class.forName("com.mysql.jdbc.Driver");
         Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
         PreparedStatement pt=c.prepareStatement("SELECT * FROM attendance WHERE rollno=? AND class=?");
            pt.setString(1,a1); 
             pt.setString(2,a2);
           
     ResultSet res=pt.executeQuery();
     while(res.next()){
     t1.setText(res.getString(1)); //THESE Outputs are according to table present in database
     t2.setText(res.getString(2));
     t3.setText(res.getString(3)); 
     }
        
     } 
           catch(Exception ew){
                       System.out.println(ew);
                    }               
       
     }
 
 }
public static void main(String args[]){
viewattend lk=new viewattend();
}
}
