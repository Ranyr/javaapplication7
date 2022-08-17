import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class insmark implements ActionListener{
    JFrame f;
    JPanel p;
    JLabel l,l3,l1,l2,l4;
    JTextField t1,t2,t3,t4;
    JOptionPane n1,n2,n3;
    JButton b1,b2,b3,b4;
    Font o;
    
        
    insmark(){
    f=new JFrame("desk");
    f.setSize(700,600);
    
   
    p=new JPanel();
    p.setLayout(null);
    
    f.add(p);
     

    o=new Font("Monotype Corsiva",Font.BOLD,25);  
    n1=new JOptionPane();
    n2=new JOptionPane();
    n3=new JOptionPane();
    
 l=new JLabel("MARKS UPDATION");
 l1=new JLabel("rollno");   
l2=new JLabel("class");
l3=new JLabel("marks obtained");
l4=new JLabel("max marks");


t1=new JTextField(50);
t2=new JTextField(50);
t3=new JTextField(50);
t4=new JTextField(80);

b1=new JButton("Insert");
b2=new JButton("reset");
b3=new JButton("updatet");
b4=new JButton("delete");

l.setBounds(230,40,330,40);
l1.setBounds(180,90,100,27);
l2.setBounds(180,120,100,27);
l3.setBounds(180,150,180,27);
l4.setBounds(180,180,150,27);


t1.setBounds(350,90,190,25);
t2.setBounds(350,120,190,25);
t3.setBounds(350,150,190,25);
t4.setBounds(350,180,190,25);

l.setFont(o);
l1.setFont(o);
l2.setFont(o);
l3.setFont(o);
l4.setFont(o);

 
 l.setForeground(Color.WHITE);
 l1.setForeground(Color.WHITE);
 l2.setForeground(Color.WHITE);
 l3.setForeground(Color.WHITE);
 l4.setForeground(Color.WHITE);
 
 p.setBackground(Color.blue);
 
p.add(l);
p.add(l1); 
p.add(l2);
p.add(l3);
p.add(l4);


p.add(t1);
p.add(t2);
p.add(t3);
p.add(t4);



b1.setBounds(300,300,150,25);
b2.setBounds(300,330,150,25);
b3.setBounds(300,360,150,25);
b4.setBounds(300,390,150,25);

b1.setFont(o);
b2.setFont(o);
p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);

f.add(p);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

f.setVisible(true);
 
    }
    public void actionPerformed(ActionEvent e){
         String a1,a2,a3,a4;
            a1=t1.getText();
             a2=t2.getText();
              a3=t3.getText();
               a4=t4.getText();
        if(e.getSource()==b1){
                        
    try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
     PreparedStatement st=con.prepareStatement("INSERT INTO marks VALUES(?,?,?,?)");
     
st.setString(1,a1);//a1=rollno
st.setString(2,a2);//a3=class
st.setString(3,a3);//a1=marksobtained
st.setString(4,a4);//a2=totalmarks
st.executeUpdate();
n3.showMessageDialog(null,"marks inserted successfully","confirmation msg",1);
      }
    catch(Exception ew){
        System.out.println(ew);
                       }
        }    
        
        //reset button is pressed
        else if(e.getSource()==b2){
            
         t1.setText(" ");     
          t2.setText(" ");     
          t3.setText(" ");     
          t4.setText(" ");     
            
          
        } 
        else if(e.getSource()==b3)//update
        {
      try{ 
           if(!(a1.isEmpty()) && !(a2.isEmpty()))
           {
          // if(a1.equals(rs.getString("rollno")&&(a1.equals(rs.getString("class")){
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
           PreparedStatement stat=con.prepareStatement("Update marks set totalmarks=?,marksobtained=? WHERE rollno=? AND class=?");
           
           stat.setString(1,a1);
           stat.setString(2,a2);
           stat.setString(3,a3);
           stat.setString(4,a4);
        
           stat.executeUpdate();
           JOptionPane n1= new JOptionPane();
           n1.showMessageDialog(null,"data updated successfull","msg box",1);
             //}
           /*else{
            n1.showMessageDialog(null,"u have provided invalide credentials","msg box",1);
           
           }*/
           }
           else 
           { n1.showMessageDialog(null,"empty field's are not required");    }
           
       }
            
       catch(Exception ew){
           System.out.println(ew);
       }
}
    
        else //delete
        {  /*PreparedStatement p=cc.prepareStatement("SELECT username,password FROM admin WHERE username='"+ap+"'");
         ResultSet rs=p.executeQuery();
 while(rs.next())
 { 
  if(!(ap.isEmpty()) && !(ap1.isEmpty()))
  {
     if( (ap.equals(rs.getString("username")))&&(ap1.equals(rs.getString("password"))) )
     {
       n.showMessageDialog(null,"user is verified","msgbox",3);
       new adminhome();
     }*/
           
           try{
               String rno=null,clas=null;
               Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
           PreparedStatement stat=con.prepareStatement("select rollno,class from marks");
           ResultSet res =stat.executeQuery();
           int count=0;
           while(res.next())
           {
            rno=res.getString(1);
            clas=res.getString(2);
            System.out.println(rno+ " "+clas);
             System.out.println(a1+ " "+a2);
           if(a1.equals(rno) && a2.equals(clas) )
            {
            count=1;
            break;
            }
           }
           if(count==1)
           {
            n1.showMessageDialog(null,"found credentials","msg box",1);
            PreparedStatement statdel=con.prepareStatement("delete from marks where rollno=? and class=?");
            statdel.setString(1, a1);
            statdel.setString(2, a2);
            statdel.executeUpdate();
           }
           else
           {
            n1.showMessageDialog(null,"invalid credentials","msg box",1);
           }
               
//               if(!(a1.isEmpty()) && !(a2.isEmpty()))//non empty
//               {                  //??????????????????????????????????
//                // if matches {     
//           Class.forName("com.mysql.jdbc.Driver");
//           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
//           PreparedStatement stat=con.prepareStatement("Delete from marks where rollno=? AND class=?");
//           stat.setString(1,a1);
//           stat.setString(2,a2);
//           stat.executeUpdate();
//           JOptionPane n1=new JOptionPane();
//           n1.showMessageDialog(null,"record deleted successfully","msg box",1);//}
//           
//           //else{ n1.showMessageDialog(null,"invalid credentials","msg box",1);}
//           
//            }
//               
//               else   //empty
//                {n1.showMessageDialog(null,"empty filed's not allowed","msg box",1);}
//               
       }
       catch(Exception ew){
           System.out.println(ew);
       }

        
        
        
        }
    }
        

    public static void main (String args[]){
   insmark s=new insmark();
}
}
