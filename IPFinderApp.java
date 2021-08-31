import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IPFinderApp extends JFrame implements ActionListener{  
    JLabel l1;  
    JTextField t;  
    JButton b1,b2;  
    public IPFinderApp()
    {  
        super("IP Finder");
        t=new JTextField(); 
        t.setBounds(100,100,200,20); 
        b1=new JButton("Search IP");
        b1.setBounds(100,200,100,30);
        b2=new JButton("Exit");
        b2.setBounds(220,200,80,30);
        l1=new JLabel("IP Finder");  
        l1.setBounds(120,40,300,20);
        l1.setFont(new Font("Times New Roman", Font.BOLD,28));
        b1.addActionListener(this);
        b2.addActionListener(this); 
        add(t);  
        add(l1);  
        add(b1); 
        add(b2);   
        setSize(430,400);  
        setLayout(null);  
        setVisible(true);
        setTitle("IP Finder by Rushali");
        setLocationRelativeTo(null);  
    } 

    @Override
    public void actionPerformed(ActionEvent e){  
        String str=e.getActionCommand();
        if(str.equals("Search IP")){
            try { 
                String url=t.getText(); 
                InetAddress inet=InetAddress.getByName(url);  
                String ip=inet.getHostAddress();  
                JOptionPane.showMessageDialog(this, ip);  
            } 
            catch (UnknownHostException ex) {  
                JOptionPane.showMessageDialog(this, "Enter a valid URL!", "Alert!", JOptionPane.WARNING_MESSAGE);  
            }  
        }
        else if(str.equals("Exit")){
            dispose();
            repaint();
        }     
    }

    public static void main(String[] args) {  
        new IPFinderApp();  
    }  
  
}