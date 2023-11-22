import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 2357207579976680833L;
	private JPanel jp1;
	private JTextField tf1;
	private JPasswordField tf2;
//	public static void main(String[] args) {
//		new LoginPage();
//	}
	
	@SuppressWarnings("serial")
	public LoginPage() {
		setResizable(false);
		jp1 = new JPanel() {
			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(51, 153, 240, 100),
			       getWidth(), getHeight(), new Color(102, 0, 153, 215), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		jp1.setBackground(new Color(102, 51, 102));
		jp1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setVisible(true);
		setContentPane(jp1);
		jp1.setLayout(null);
		
		JPanel jp2 = new JPanel();
		jp2.setBounds(54, 39, 228, 201);
		jp1.add(jp2);
		jp2.setLayout(null);
		
		JLabel l1 = new JLabel("Login");
		l1.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		l1.setBounds(79, 10, 83, 21);
		jp2.add(l1);
		
		JLabel lower = new JLabel("_______________________________________");
		lower.setBounds(0, 32, 228, 13);
		jp2.add(lower);
		
		tf1 = new JTextField();
		tf1.setForeground(new Color(0, 0, 0));		
		tf1.setBounds(70, 59, 136, 19);
		jp2.add(tf1);
		
		tf2 = new JPasswordField("");
		tf2.setForeground(new Color(0, 0, 0));
		tf2.setBounds(70, 92, 136, 19);
		jp2.add(tf2);
		
		JButton LoginBut = new JButton("Login");
		LoginBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user = tf1.getText()+"@gmail.com";
					if(tf1.getText().equals("")){
						throw new Exception("Invalid Credentials");
					}
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/RideKaro","root","root@648");
					String cmd = "select * from user_details where email = '"+user+"'";
					Statement s = c.createStatement();
					ResultSet res = s.executeQuery(cmd);
					String pass = "",name="",email="",phone="",gen="",dob="";
					if(res.next()) {
						name = res.getString(1);
						email = res.getString(2);
						phone = res.getString(3);
						pass = res.getString(4);
						gen = res.getString(5);
						dob = res.getString(6);
					}
					String[] arg = {name,email,phone,gen,dob};
					String pasword = new String(tf2.getPassword());
					if(email.equals(""))
						throw new NotRegistered();
					if(pass.equals(pasword) && (!pass.equals(""))) {
						JOptionPane.showMessageDialog(null,"Login Successfully");
						new User(arg);
						dispose();
					}else {
						throw new WrongPassword();
					}
				}catch(WrongPassword wp) {
					JOptionPane.showMessageDialog(null,"please enter correct Password","Error",JOptionPane.WARNING_MESSAGE);
					tf2.setText("");	
				}
				catch(NotRegistered nr) {
					JOptionPane.showMessageDialog(null,"Account is not Registered","Error",JOptionPane.WARNING_MESSAGE);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Invalid Credentials","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		LoginBut.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		LoginBut.setBounds(56, 132, 85, 21);
		jp2.add(LoginBut);
		
		JLabel l3 = new JLabel("Don't have account?");
		l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 9));
		l3.setForeground(new Color(0, 0, 0));
		l3.setBounds(35, 163, 99, 13);
		jp2.add(l3);
		
		JLabel l4 = new JLabel("Sign Up");
		l4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Register().setVisible(true);
			}
		});
		l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 9));
		l4.setForeground(new Color(0, 153, 204));
		l4.setBounds(132, 163, 45, 13);
		jp2.add(l4);
		
		JLabel uName = new JLabel("Username:");
		uName.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		uName.setBounds(10, 62, 58, 13);
		jp2.add(uName);
		
		JLabel uPass = new JLabel("Password:");
		uPass.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		uPass.setBounds(10, 95, 57, 13);
		jp2.add(uPass);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 315);
		setLocationRelativeTo(null);
	}
}