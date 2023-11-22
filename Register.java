import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jp1;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JPasswordField passField;
	private JPasswordField passField1;
	private JTextField dobtf;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Register frame = new Register();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\register user.png"));
		setResizable(false);
		setTitle("Register");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 596);
		jp1 = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(102, 0, 153, 150),
			       getWidth(), getHeight(), new Color(51, 153, 240, 240), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		jp1.setBackground(new Color(102, 0, 255));
		jp1.setBorder(new LineBorder(new Color(153, 255, 102), 1, true));
		
		setLocationRelativeTo(null);
		setContentPane(jp1);
		jp1.setLayout(null);
		
		JPanel jp2 = new JPanel();
		jp2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		jp2.setBounds(93, 60, 500, 437);
		jp1.add(jp2);
		jp2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create an account");
		lblNewLabel.setForeground(new Color(102, 0, 255));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 212, 29);
		jp2.add(lblNewLabel);
		
		JPanel jp3 = new JPanel();
		jp3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		jp3.setBackground(UIManager.getColor("MenuBar.shadow"));
		jp3.setBounds(2, 44, 495, 305);
		jp2.add(jp3);
		jp3.setLayout(null);
		
		JLabel fName = new JLabel("First Name *");
		fName.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		fName.setForeground(new Color(0, 0, 0));
		fName.setBounds(10, 10, 80, 13);
		jp3.add(fName);
		
		tf1 = new JTextField();
		tf1.setBounds(10, 33, 176, 24);
		jp3.add(tf1);
		tf1.setColumns(10);
		
		JLabel lName = new JLabel("Last Name *");
		lName.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		lName.setForeground(Color.BLACK);
		lName.setBounds(278, 10, 90, 13);
		jp3.add(lName);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(278, 33, 176, 24);
		jp3.add(tf2);
		
		JLabel email = new JLabel("Email *");
		email.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		email.setBounds(10, 76, 80, 13);
		jp3.add(email);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(10, 99, 176, 24);
		jp3.add(tf3);
		
		JLabel contact = new JLabel("Contact No. *");
		contact.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		contact.setBounds(288, 77, 80, 13);
		jp3.add(contact);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(278, 101, 176, 24);
		jp3.add(tf4);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		gender.setBounds(10, 151, 80, 13);
		jp3.add(gender);
		
		JRadioButton rb1 = new JRadioButton("Male");
		rb1.setActionCommand("Male");
		rb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		rb1.setBackground(UIManager.getColor("MenuBar.shadow"));
		rb1.setBounds(71, 148, 72, 21);
		jp3.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Female");
		rb2.setActionCommand("Female");
		rb2.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		rb2.setBackground(UIManager.getColor("MenuBar.shadow"));
		rb2.setBounds(165, 148, 90, 21);
		jp3.add(rb2);
		
		JRadioButton rb3 = new JRadioButton("Transgender");
		rb3.setActionCommand("Transgender");
		rb3.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		rb3.setBackground(UIManager.getColor("MenuBar.shadow"));
		rb3.setBounds(257, 148, 129, 21);
		jp3.add(rb3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		JLabel lblNewLabel_1 = new JLabel("Create password: *");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 220, 115, 13);
		jp3.add(lblNewLabel_1);
		
		passField = new JPasswordField();
		passField.setBounds(135, 216, 176, 24);
		jp3.add(passField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirm password:*");
		lblNewLabel_1_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 265, 120, 13);
		jp3.add(lblNewLabel_1_1);
		
		passField1 = new JPasswordField();
		passField1.setBounds(135, 262, 176, 24);
		jp3.add(passField1);
		
		JLabel lblNewLabel_2 = new JLabel("D-O-B: ");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 180, 59, 13);
		jp3.add(lblNewLabel_2);
		
		dobtf = new JTextField();
		dobtf.setBounds(60, 178, 126, 19);
		jp3.add(dobtf);
		dobtf.setColumns(10);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/RideKaro","root","root@648");
					Statement s = c.createStatement();
					String name = tf1.getText()+" "+tf2.getText();
					String email = tf3.getText();
					String phone = tf4.getText();
					char[] pass1 = passField.getPassword();
					String pas1 = new String(pass1);
					char[] pass2 = passField1.getPassword();
					String pas2 = new String(pass2);
					String dob = dobtf.getText();
					String type = bg.getSelection().getActionCommand();
					if(pas1.length() < 8)
						throw new WrongPassword();
					if(!pas1.equals(pas2)) {
						JOptionPane.showMessageDialog(null,"Please Enter same Password");	
					}
					else {
						String stm = "insert into user_details values('"
								+name+"','"+email+"','"+phone+"','"+pas1+"','"+type+"','"+dob+"')";
						s.executeUpdate(stm);
						JOptionPane.showMessageDialog(null,"Registered Successfully");
						tf1.setText("");tf2.setText("");tf3.setText("");tf4.setText("");
						passField.setText("");passField1.setText("");dobtf.setText("");
						bg.setSelected(bg.getSelection(), false);
					}
				}catch(WrongPassword wp) {
					JOptionPane.showMessageDialog(null,"Password length should be atleast 8",null,JOptionPane.ERROR_MESSAGE);
					passField.setText("");
					passField1.setText("");
				}
				catch(Exception ae) {
					
				}
			}
		});
		register.setForeground(new Color(255, 255, 255));
		register.setBackground(new Color(102, 0, 255));
		register.setFont(new Font("Courier New", Font.PLAIN, 13));
		register.setBounds(162, 363, 140, 29);
		register.setBorder(BorderFactory.createLineBorder(Color.blue));
		jp2.add(register);
		
		JLabel back = new JLabel("Back to login");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new LoginPage();
			}
		});
		back.setForeground(new Color(102, 51, 255));
		back.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		back.setBounds(289, 403, 93, 13);
		jp2.add(back);
		
		JLabel lower = new JLabel("____________");
		lower.setBounds(287, 402, 83, 13);
		jp2.add(lower);
	}
}