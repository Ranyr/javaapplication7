import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class adminforgot implements ActionListener{
    JFrame f;
    JPanel p;
    JLabel l,l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1;
    JOptionPane n1,n2,n3;
    Font o;
    adminforgot(){
        
   /* f=new JFrame();
    f.setSize(700,700);
    
    p=new JPanel();
    f.add(p);
     
    b1=new JButton("click");
    p.add(b1);
    b1.addActionListener(this);
    f.setVisible(true);*/
   f=new JFrame("desktop app");
f.setSize(700,700);

p=new JPanel();
p.setLayout(null);
f.add(p);
n1=new JOptionPane();
n2=new JOptionPane();
n3=new JOptionPane();

o=new Font("brush script up",Font.BOLD,24);

l=new JLabel("SET PASSWORD");
l1=new JLabel("Username");
t1=new JTextField();
l2=new JLabel("New Password");
t2=new JTextField();
l3=new JLabel("Confirm Password");
t3=new JTextField();
b1=new JButton("submit");

l.setBounds(250,170,250,23);
l1.setBounds(213,210,90,40);
t1.setBounds(330,220,190,25);

l2.setBounds(210,255,110,40);
t2.setBounds(330,265,190,25);

l3.setBounds(210,305,130,40);
t3.setBounds(330,315,190,25);

b1.setBounds(290,360,100,25);
l.setFont(o);
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
    
    
    public void actionPerformed(ActionEvent e){
   /* if(e.getSource()==b1)
    new Login1();*/
   String a1,a2,a3;
    if(e.getSource()==b1)
    {
     try{
          a1=t1.getText(); //username
         a2=t2.getText();//new password
         a3=t3.getText();
         if(  (a2.equals(a3))&&((!a1.isEmpty())&&(!a2.isEmpty())&&(!a3.isEmpty()))  )
         {
         Class.forName("com.mysql.jdbc.Driver");
         Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
         PreparedStatement pt=c.prepareStatement("Update adminlogin set password=? where username=?");
           pt.setString(1,a2);
           pt.setString(2,a1);
           pt.executeUpdate();
      
         n1.showMessageDialog(null," New password set successfully!! Now try to login","msg box",3);
        new Admins();
         }
          else{
             n2.showMessageDialog(null,"something went wrong plz try again!!","msg box",3);
             t2.setText(" ");
             t3.setText(" ");
              t1.setText(" ");
         }
     }
           catch(Exception ex){
                       System.out.println(ex);
                    }               
       
     }
    }
    public static void main(String args[]){
    adminforgot c=new adminforgot();
    }
}
