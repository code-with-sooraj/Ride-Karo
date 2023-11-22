import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jp1;
	private JTextField tf11;
	private JTextField tf12;
	private JTextField tf13;
	private JTextField tf14;
	private JTextField tf15;
	
	private JLabel name;
	private JLabel email;
	private JLabel contact;
	private JLabel gender;
	private JLabel DOB;

	static String Name;
	static String Email;
	static String Contact;
	static String Gender;
	static String DoB;
	private JTable table;
	private JTextField getBike;
	private JTextField retBike;
	private JTable tourTable;
	
	HashMap<String,String> map = new HashMap<String,String>();
	private JTable bookTable;
//	public static void main(String[] args) {
//		Name = args[0];
//		Email = args[1];
//		Contact = args[2];
//		Gender = args[3];
//		DoB = args[4];
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					User frame = new User();
//					frame.setVisible(true);
//					new LoginPage().dispose();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public User(String[] args) {
		Name = args[0];
		Email = args[1];
		Contact = args[2];
		Gender = args[3];
		DoB = args[4];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User f = new User();
					f.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public User() {
		map.put("BR059533", "Honda Activa 5G");
		map.put("BR059507", "Honda Activa 5G");
		map.put("BR059568", "Honda Splendor");
		map.put("BR0D4712", "Luna");
		map.put("BR050001", "Honda Activa 5G");
		map.put("BR052107", "Honda Activa 5G");
		map.put("BR012268", "Honda Splendor");
		map.put("BR0D2342", "Luna");
		map.put("BR057231", "Harley Davidson");
		map.put("BR051233", "Honda Activa 5G");
		map.put("BR052903", "Harley Davidson");
		map.put("BR0D2002", "Hero Electric");
		map.put("BR052109", "Honda Activa 5G");
		map.put("BR002218", "Honda Splendor");
		map.put("BR0D2340", "Luna");
		map.put("BR057121", "Harley Davidson");
		map.put("BR051247", "Honda Activa 5G");
		map.put("BR050568", "Honda Splendor");
		map.put("BR0D1212", "Luna");
		map.put("BR050002", "Honda Activa 5G");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 468);
		jp1 = new JPanel();
		jp1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jp1);
		jp1.setLayout(null);
		
		JPanel jp2 = new JPanel();
		jp2.setBounds(0, 0, 196, 431);
		jp2.setBackground(new Color(204, 255, 204));
		jp1.add(jp2);
		jp2.setLayout(null);
		
		JLabel l1 = new JLabel("Menu Bar");
		l1.setForeground(new Color(153, 0, 0));
		l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		l1.setBounds(10, 10, 193, 28);
		jp2.add(l1);
		
		JLabel lower = new JLabel("________________________");
		lower.setForeground(new Color(204, 0, 0));
		lower.setBounds(10, 19, 164, 13);
		jp2.add(lower);
		
		JPanel jp3 = new JPanel();
		jp3.setBackground(new Color(255, 255, 204));
		jp3.setBounds(20, 55, 154, 28);
		jp2.add(jp3);
		jp3.setLayout(null);
		
		JLabel l2 = new JLabel("My Account");
		
		l2.setFont(new Font("Bodoni MT", Font.PLAIN, 13));
		l2.setBounds(10, 0, 144, 26);
		jp3.add(l2);
		
		JPanel jp4 = new JPanel();
		jp4.setLayout(null);
		jp4.setBackground(new Color(255, 255, 204));
		jp4.setBounds(20, 110, 154, 28);
		jp2.add(jp4);
		
		JLabel l3 = new JLabel("My Tours");
		
		l3.setFont(new Font("Bodoni MT", Font.PLAIN, 13));
		l3.setBounds(0, 2, 144, 26);
		jp4.add(l3);
		
		JLabel log = new JLabel("");
		log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				dispose();
				new LoginPage();
			}
		});
		log.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\logout (1).png"));
		log.setBounds(20, 384, 30, 30);
		jp2.add(log);
		
		JPanel jp5 = new JPanel();
		jp5.setLayout(null);
		jp5.setBackground(new Color(255, 255, 204));
		jp5.setBounds(20, 165, 154, 28);
		jp2.add(jp5);
		
		JLabel l4 = new JLabel("Available Bikes");
		
		l4.setFont(new Font("Bodoni MT", Font.PLAIN, 13));
		l4.setBounds(0, 2, 144, 26);
		jp5.add(l4);
		
		JPanel jp6 = new JPanel();
		jp6.setLayout(null);
		jp6.setBackground(new Color(255, 255, 204));
		jp6.setBounds(20, 220, 154, 28);
		jp2.add(jp6);
		
		JLabel l5 = new JLabel("Book a Ride");
		l5.setFont(new Font("Bodoni MT", Font.PLAIN, 13));
		l5.setBounds(0, 2, 144, 26);
		jp6.add(l5);
		
		JPanel jp6_1 = new JPanel();
		jp6_1.setLayout(null);
		jp6_1.setBackground(new Color(255, 255, 204));
		jp6_1.setBounds(20, 275, 154, 28);
		jp2.add(jp6_1);
		
		JLabel l6 = new JLabel("About Us");
		l6.setFont(new Font("Bodoni MT", Font.PLAIN, 13));
		l6.setBounds(0, 2, 144, 26);
		jp6_1.add(l6);
		
		JLabel ver = new JLabel("Version 1.0");
		ver.setForeground(new Color(0, 51, 255));
		ver.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ver.setBounds(51, 322, 100, 22);
		jp2.add(ver);
		
		JLabel low1 = new JLabel("___________");
		low1.setForeground(new Color(0, 51, 255));
		low1.setBounds(51, 328, 110, 13);
		jp2.add(low1);
		
		JLabel logout = new JLabel("Logout");
		logout.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		logout.setBounds(60, 388, 74, 17);
		jp2.add(logout);
		
		JTabbedPane tp = new JTabbedPane(JTabbedPane.TOP);
		tp.setBounds(191, -21, 545, 452);
		jp1.add(tp);
		
		JPanel tp2 = new JPanel()
		{
			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(51, 153, 240, 100),
			       getWidth(), getHeight(), new Color(102, 0, 153, 215), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
//		tp2.setBackground(SystemColor.activeCaption);
		tp.addTab("New tab", null, tp2, null);
		
		JPanel tp1 = new JPanel() {
			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(51, 153, 240, 100),
			       getWidth(), getHeight(), new Color(255, 255, 153, 215), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		tp.addTab("New tab", null, tp1, null);
		tp1.setLayout(null);
		
		
		
		JLabel l11 = new JLabel("   ****Welcome to Ride Karo****");
		l11.setFont(new Font("Lucida Calligraphy", Font.BOLD, 26));
		l11.setBounds(10, 10, 501, 31);
		tp1.add(l11);
		
		JLabel l13 = new JLabel("Forget everything and ride...");
		l13.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 14));
		l13.setForeground(new Color(255, 51, 0));
		l13.setBounds(234, 51, 277, 20);
		tp1.add(l13);
		
		JLabel l14 = new JLabel("Book your ride now: ");
		l14.setForeground(new Color(128, 0, 128));
		l14.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		l14.setBounds(10, 94, 159, 31);
		tp1.add(l14);
		
		JLabel l15 = new JLabel("From:");
		l15.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		l15.setBounds(53, 130, 70, 20);
		tp1.add(l15);
		
		tf11 = new JTextField();
		tf11.setBounds(128, 132, 150, 20);
		tp1.add(tf11);
		tf11.setColumns(10);
		
		JLabel l16 = new JLabel("To:");
		l16.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		l16.setBounds(53, 170, 70, 20);
		tp1.add(l16);
		
		tf12 = new JTextField();
		tf12.setColumns(10);
		tf12.setBounds(128, 170, 150, 20);
		tp1.add(tf12);
		
		JLabel l17 = new JLabel("Date:");
		l17.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		l17.setBounds(53, 210, 70, 20);
		tp1.add(l17);
		
		tf13 = new JTextField();
		tf13.setColumns(10);
		tf13.setBounds(128, 210, 150, 20);
		tp1.add(tf13);
		
		JButton b11 = new JButton("Confirm");
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = Email;
				String bikeNo = tf15.getText();
				String date = tf13.getText();
				int status = 0;
				String[] times = tf14.getText().split("-",5);
				String start = tf11.getText();
				String stop = tf12.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/RideKaro","root","root@648");
					Statement st = c.createStatement();
					String stm = "select * from available_bikes";
					ResultSet rs = st.executeQuery(stm);
					int flag = 0;
					while(rs.next()) {
						if(rs.getString(2).equals(bikeNo))
							flag = 1;
					}
					if(flag == 1) {
						
						String sd = "delete from available_bikes where bike_no= '"+bikeNo+"'";
						String cmd = "insert into Booking values ('"+userName+"','"+bikeNo+"','"
								+date+"','"+times[0]+"','"+times[1]+"','"+start+"','"+stop+"')";
						st.executeUpdate(sd);
						st.executeUpdate(cmd);
						
						JOptionPane.showMessageDialog(null,"Booked Successfully");
						tf15.setText("");tf12.setText("");tf13.setText("");tf14.setText("");
						tf11.setText("");	
					}
					else {
						JOptionPane.showMessageDialog(null,null,"Bike is not Available",JOptionPane.ERROR_MESSAGE);
						tf15.setText("");
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,null,"Specific Bike is in Service",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		b11.setBackground(new Color(0, 0, 255));
		b11.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		b11.setBounds(111, 347, 108, 33);
		tp1.add(b11);
		
		JLabel l18 = new JLabel("Timing:");
		l18.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		l18.setBounds(53, 250, 70, 20);
		tp1.add(l18);
		
		tf14 = new JTextField();
		tf14.setColumns(10);
		tf14.setBounds(128, 250, 150, 20);
		tp1.add(tf14);
		
		tp.add(tp1);
		
		JLabel lblModel = new JLabel("Bike No:");
		lblModel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblModel.setBounds(53, 290, 70, 20);
		tp1.add(lblModel);
		
		tf15 = new JTextField();
		tf15.setColumns(10);
		tf15.setBounds(128, 290, 150, 20);
		tp1.add(tf15);
		
		JLabel lblCompleteYourJourney = new JLabel("Complete your journey here");
		lblCompleteYourJourney.setForeground(new Color(128, 0, 128));
		lblCompleteYourJourney.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblCompleteYourJourney.setBounds(312, 239, 218, 31);
		tp1.add(lblCompleteYourJourney);
		
		JLabel Ret_bikeno = new JLabel("Bike No:");
		Ret_bikeno.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		Ret_bikeno.setBounds(312, 290, 70, 20);
		tp1.add(Ret_bikeno);
		
		retBike = new JTextField();
		retBike.setColumns(10);
		retBike.setBounds(391, 292, 120, 20);
		tp1.add(retBike);
		
		JButton retButton = new JButton("Return");
		retButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BikeNo = retBike.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/RideKaro","root","root@648");
					String cmd = "select bike_no from Booking where username = '"+Email+"'";
					Statement s = c.createStatement();
					ResultSet rs = s.executeQuery(cmd);
					int flag = 0;
					while(rs.next()) {
						if(rs.getString(1).equals(BikeNo))
							flag = 1;
					}
					if(flag==0) {
						JOptionPane.showMessageDialog(null,"Please Enter a valid Bike Number",null,JOptionPane.ERROR_MESSAGE);
						retBike.setText("");
					}
					else {
						Statement st = c.createStatement();
						String addSt = "select username,bike_no,date,s_time,e_time,source,destination "
								+ "from Booking where username = '"+Email+"' and bike_no='"+BikeNo+"'";
						ResultSet rst = st.executeQuery(addSt);
						while(rst.next()) {
							String name = rst.getString(1);
							String bike = rst.getString(2);
							String date = rst.getString(3);
							String stime = rst.getString(4);
							String etime = rst.getString(5);
							String source = rst.getString(6);
							String dest = rst.getString(7);
							String add = "insert into returned values ('"+
							name+"','"+bike+"','"+date+"','"+stime+"','"+etime+"','"+source+"','"+dest+"')";
							Statement stm = c.createStatement();
							stm.execute(add);
						}
						String delSt = "delete from Booking where bike_no = '"+BikeNo+"'";
						st.executeUpdate(delSt);
						
						JOptionPane.showMessageDialog(null,"Returned Successfully");
						retBike.setText("");
					}
				}catch(Exception ae) {
					System.out.print(ae);
					ae.printStackTrace();
					JOptionPane.showMessageDialog(null,null,"Bike Already returned",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		retButton.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		retButton.setBackground(Color.BLUE);
		retButton.setBounds(366, 347, 108, 33);
		tp1.add(retButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(312, 130, 199, 100);
		tp1.add(panel);
		panel.setLayout(null);
		
		JLabel l12 = new JLabel("Rate(rupees): ");
		l12.setBounds(0, 7, 103, 18);
		panel.add(l12);
		l12.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		
		JLabel l19 = new JLabel("100Rs/Hour");
		l19.setBounds(114, 7, 83, 18);
		panel.add(l19);
		l19.setForeground(new Color(0, 51, 255));
		l19.setFont(new Font("Californian FB", Font.BOLD, 13));
		
		JLabel l21 = new JLabel("Fine (rupees): ");
		l21.setBounds(0, 34, 103, 18);
		panel.add(l21);
		l21.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		
		JLabel l20 = new JLabel("120Rs/Hour(when late)");
		l20.setBounds(20, 59, 167, 18);
		panel.add(l20);
		l20.setForeground(new Color(0, 51, 255));
		l20.setFont(new Font("Californian FB", Font.BOLD, 13));
		
		JLabel l20_1 = new JLabel("extra fine(when damaged)");
		l20_1.setForeground(new Color(0, 51, 255));
		l20_1.setFont(new Font("Californian FB", Font.BOLD, 13));
		l20_1.setBounds(20, 82, 167, 18);
		panel.add(l20_1);
		
		JPanel tp3 = new JPanel(){
			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(51, 153, 240, 150),
			       getWidth(), getHeight(), new Color(255, 255, 153, 180), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		tp.addTab("New tab", null, tp3, null);
		
		JPanel tp4 = new JPanel(){
			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(51, 153, 240, 150),
			       getWidth(), getHeight(), new Color(102, 0, 153, 180), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		tp.addTab("New tab", null, tp4, null);
		
		JPanel tp5 = new JPanel();
		tp.addTab("New tab", null, tp5, null);
		
		JPanel tp6 = new JPanel();
		tp.addTab("New tab", null, tp6, null);
		tp6.setLayout(null);
		
		JPanel sourabh = new JPanel() {
			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(51, 153, 240, 100),
			       getWidth(), getHeight(), new Color(102, 0, 153, 215), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		sourabh.setBounds(0, 0, 267, 404);
		tp6.add(sourabh);
		sourabh.setLayout(null);
		
		JLabel pName = new JLabel("Name: ");
		pName.setForeground(new Color(0, 0, 0));
		pName.setFont(new Font("Courier New", Font.PLAIN, 13));
		pName.setBounds(10, 169, 53, 17);
		sourabh.add(pName);
		
		JLabel pN = new JLabel("Prabhat Kumar Raj");
		pN.setForeground(new Color(102, 0, 0));
		pN.setFont(new Font("Courier New", Font.PLAIN, 12));
		pN.setBounds(64, 170, 161, 17);
		sourabh.add(pN);
		
		JLabel pD = new JLabel("DOB: ");
		pD.setFont(new Font("Courier New", Font.PLAIN, 12));
		pD.setBounds(10, 210, 53, 13);
		sourabh.add(pD);
		
		JLabel pDOB = new JLabel("21-01-2003");
		pDOB.setForeground(new Color(102, 0, 0));
		pDOB.setFont(new Font("Courier New", Font.PLAIN, 12));
		pDOB.setBounds(64, 209, 145, 17);
		sourabh.add(pDOB);
		
		JLabel pB = new JLabel("Branch:");
		pB.setForeground(Color.BLACK);
		pB.setFont(new Font("Courier New", Font.PLAIN, 12));
		pB.setBounds(10, 246, 53, 17);
		sourabh.add(pB);
		
		JLabel pCSE = new JLabel("CSE");
		pCSE.setForeground(new Color(102, 0, 0));
		pCSE.setFont(new Font("Courier New", Font.PLAIN, 12));
		pCSE.setBounds(64, 247, 53, 17);
		sourabh.add(pCSE);
		
		JLabel pR = new JLabel("Role:");
		pR.setForeground(Color.BLACK);
		pR.setFont(new Font("Courier New", Font.PLAIN, 12));
		pR.setBounds(10, 282, 53, 17);
		sourabh.add(pR);
		
		JLabel pRole = new JLabel("App Designer and DBA");
		pRole.setForeground(new Color(102, 0, 0));
		pRole.setFont(new Font("Courier New", Font.PLAIN, 12));
		pRole.setBounds(64, 283, 182, 17);
		sourabh.add(pRole);
		
		JLabel pPhoto = new JLabel("");
		pPhoto.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\ezgif.com-resize.jpg"));
		pPhoto.setBounds(46, 10, 163, 132);
		sourabh.add(pPhoto);
		
		JLabel lblContact_1 = new JLabel("Contact: ");
		lblContact_1.setForeground(Color.BLACK);
		lblContact_1.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblContact_1.setBounds(10, 309, 65, 17);
		sourabh.add(lblContact_1);
		
		JLabel lblNewLabel = new JLabel("sahprabhat2101@gmail.com");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblNewLabel.setBounds(74, 310, 183, 13);
		sourabh.add(lblNewLabel);
		
		JPanel prabhat = new JPanel() {
			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(51, 153, 240, 100),
			       getWidth(), getHeight(), new Color(102, 0, 153, 215), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		prabhat.setBounds(266, 0, 274, 404);
		tp6.add(prabhat);
		prabhat.setLayout(null);
		
		JLabel sName = new JLabel("Name: ");
		sName.setForeground(Color.BLACK);
		sName.setFont(new Font("Courier New", Font.PLAIN, 13));
		sName.setBounds(10, 169, 53, 17);
		prabhat.add(sName);
		
		JLabel sN = new JLabel("Sourav Kumar");
		sN.setForeground(new Color(102, 0, 0));
		sN.setFont(new Font("Courier New", Font.PLAIN, 12));
		sN.setBounds(73, 169, 161, 17);
		prabhat.add(sN);
		
		JLabel sDOB = new JLabel("DOB: ");
		sDOB.setFont(new Font("Courier New", Font.PLAIN, 12));
		sDOB.setBounds(10, 211, 53, 13);
		prabhat.add(sDOB);
		
		JLabel sDate = new JLabel("05-04-2002");
		sDate.setForeground(new Color(102, 0, 0));
		sDate.setFont(new Font("Courier New", Font.PLAIN, 12));
		sDate.setBounds(73, 210, 145, 17);
		prabhat.add(sDate);
		
		JLabel sBranch = new JLabel("Branch:");
		sBranch.setForeground(Color.BLACK);
		sBranch.setFont(new Font("Courier New", Font.PLAIN, 12));
		sBranch.setBounds(10, 244, 53, 17);
		prabhat.add(sBranch);
		
		JLabel sCSE = new JLabel("CSE");
		sCSE.setForeground(new Color(102, 0, 0));
		sCSE.setFont(new Font("Courier New", Font.PLAIN, 12));
		sCSE.setBounds(73, 244, 53, 17);
		prabhat.add(sCSE);
		
		JLabel sRole = new JLabel("Role:");
		sRole.setForeground(Color.BLACK);
		sRole.setFont(new Font("Courier New", Font.PLAIN, 12));
		sRole.setBounds(10, 282, 53, 17);
		prabhat.add(sRole);
		
		JLabel sAppRole = new JLabel("App Designer and DBA");
		sAppRole.setForeground(new Color(102, 0, 0));
		sAppRole.setFont(new Font("Courier New", Font.PLAIN, 12));
		sAppRole.setBounds(73, 283, 182, 17);
		prabhat.add(sAppRole);
		
		JLabel sPhoto = new JLabel("");
		sPhoto.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\ezgif.com-resize (1).jpg"));
		sPhoto.setBounds(55, 10, 163, 132);
		prabhat.add(sPhoto);
		
		JLabel lblContact_1_1 = new JLabel("Contact: ");
		lblContact_1_1.setForeground(Color.BLACK);
		lblContact_1_1.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblContact_1_1.setBounds(10, 309, 71, 17);
		prabhat.add(lblContact_1_1);
		
		JLabel lblSouravuyadavgmailcom = new JLabel("souravuyadav003@gmail.com");
		lblSouravuyadavgmailcom.setForeground(new Color(128, 0, 0));
		lblSouravuyadavgmailcom.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblSouravuyadavgmailcom.setBounds(83, 310, 183, 13);
		prabhat.add(lblSouravuyadavgmailcom);
		tp.add(tp2);
		tp2.setLayout(null);
		
		JLabel l22 = new JLabel("My Account");
		l22.setForeground(new Color(0, 0, 255));
		l22.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		l22.setBounds(192, 10, 101, 31);
		tp2.add(l22);
		
		JLabel myAcc = new JLabel("New label");
		myAcc.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\ezgif.com-resize (3).jpg"));
		myAcc.setBounds(180, 43, 105, 105);
		tp2.add(myAcc);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblName.setBounds(75, 154, 88, 31);
		tp2.add(lblName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblUsername.setBounds(75, 195, 88, 31);
		tp2.add(lblUsername);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setForeground(new Color(0, 0, 0));
		lblContact.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblContact.setBounds(75, 236, 101, 31);
		tp2.add(lblContact);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(new Color(0, 0, 0));
		lblGender.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblGender.setBounds(75, 277, 101, 31);
		tp2.add(lblGender);
		
		name = new JLabel("New label");
		name.setFont(new Font("Californian FB", Font.PLAIN, 14));
		name.setBounds(192, 154, 181, 31);
		tp2.add(name);
		
		email = new JLabel("New label");
		email.setFont(new Font("Californian FB", Font.PLAIN, 14));
		email.setBounds(192, 195, 251, 31);
		tp2.add(email);
		
		contact = new JLabel("New label");
		contact.setBackground(Color.DARK_GRAY);
		contact.setFont(new Font("Californian FB", Font.PLAIN, 14));
		contact.setBounds(192, 236, 181, 31);
		tp2.add(contact);
		
		gender = new JLabel("New label");
		gender.setBackground(Color.WHITE);
		gender.setFont(new Font("Californian FB", Font.PLAIN, 14));
		gender.setBounds(192, 277, 181, 31);
		tp2.add(gender);
		
		JLabel lblDob = new JLabel("DOB: ");
		lblDob.setForeground(Color.BLACK);
		lblDob.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblDob.setBounds(75, 318, 88, 31);
		tp2.add(lblDob);
		
		DOB = new JLabel("New label");
		DOB.setForeground(Color.BLACK);
		DOB.setFont(new Font("Californian FB", Font.PLAIN, 14));
		DOB.setBounds(192, 318, 88, 31);
		tp2.add(DOB);
		tp.add(tp3);
		tp3.setLayout(null);
		
		JScrollPane tourHist = new JScrollPane();
		tourHist.setBounds(22, 30, 496, 164);
		tp3.add(tourHist);
		
		tourTable = new JTable();
		tourHist.setViewportView(tourTable);
		
		
		JLabel MyHistory = new JLabel("My History");
		MyHistory.setForeground(new Color(153, 0, 0));
		MyHistory.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		MyHistory.setBounds(22, 0, 108, 22);
		tp3.add(MyHistory);
		
		JLabel myBooking = new JLabel("My ongoing booking");
		myBooking.setForeground(new Color(153, 0, 0));
		myBooking.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		myBooking.setBounds(22, 204, 156, 22);
		tp3.add(myBooking);
		
		JScrollPane myBook = new JScrollPane();
		myBook.setBounds(22, 236, 496, 158);
		tp3.add(myBook);
		
		bookTable = new JTable();
		myBook.setViewportView(bookTable);
		tp.add(tp4);
		tp4.setLayout(null);
		
		JLabel label = new JLabel("Available Bikes");
		label.setForeground(Color.RED);
		label.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		label.setBounds(10, 10, 154, 23);
		tp4.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 64, 498, 265);
		tp4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton retrn = new JButton("Book");
		retrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String str = getBike.getText();
					if(str.equals(null)) {
						JOptionPane.showMessageDialog(null, null,"Please enter bike number",JOptionPane.ERROR_MESSAGE);
					}
					else {
						tp.setSelectedComponent(tp1);
						tf15.setText(str);
					}
				}catch(Exception ae) {
					
				}
			}
		});
		retrn.setBackground(new Color(138, 43, 226));
		retrn.setForeground(new Color(0, 0, 0));
		retrn.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		retrn.setBounds(354, 347, 85, 23);
		tp4.add(retrn);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Bike no:");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 347, 107, 23);
		tp4.add(lblNewLabel_2);
		
		getBike = new JTextField();
		getBike.setBounds(147, 347, 146, 23);
		tp4.add(getBike);
		getBike.setColumns(10);
		tp.add(tp5);
		tp.add(tp6);
		
		l6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp.setSelectedComponent(tp6);
			}
		});
		
		l5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp.setSelectedComponent(tp1);
			}
		});
		
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp.setSelectedComponent(tp2);
				name.setText(Name);
				name.setForeground(Color.black);
				email.setText(Email);
				email.setForeground(Color.black);
				contact.setText(Contact);
				contact.setForeground(Color.black);
				gender.setText(Gender);
				gender.setForeground(Color.black);
				DOB.setText(DoB);
				DOB.setForeground(Color.black);
			}
		});
		
		l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp.setSelectedComponent(tp3);
				try {
					tourTable.setModel(new DefaultTableModel());
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/RideKaro","root","root@648");
					String com = "select * from returned where username='"+Email+"'";
					Statement stm = c.createStatement();
					ResultSet rst = stm.executeQuery(com);
					ResultSetMetaData rsmd = rst.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tourTable.getModel();
					int colm = rsmd.getColumnCount();
					String[] colName = new String[colm];
					for(int i=0;i<colm;i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					while(rst.next()) {
						String userN = rst.getString(1);
						String bike = rst.getString(2);
						String date = rst.getString(3);
						String stime = rst.getString(4);
						String etime = rst.getString(5);
						String src = rst.getString(6);
						String des = rst.getString(7);
						String[] row = {userN,bike,date,stime,etime,src,des};
						try {
							String cmd = "insert into available_bikes values ('"+map.get(bike)+"','"+bike+"')";
							Statement stmt = c.createStatement();
							stmt.executeUpdate(cmd);	
						}catch(Exception ae) {
							
						}
						model.addRow(row);
					}
					stm.close();c.close();	
				}catch(Exception ae) {
					ae.printStackTrace();
				}
				try {
					bookTable.setModel(new DefaultTableModel());
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RideKaro","root","root@648");
					String com = "select bike_no,date,s_time,e_time,source,destination from booking where username='"+Email+"'";
					Statement stm = con.createStatement();
					ResultSet rst = stm.executeQuery(com);
					ResultSetMetaData rsmd = rst.getMetaData();
					DefaultTableModel bookModel = (DefaultTableModel) bookTable.getModel();
					int colm = rsmd.getColumnCount();
					String[] colName = new String[colm];
					for(int i=0;i<colm;i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					bookModel.setColumnIdentifiers(colName);
					while(rst.next()) {
						String bike = rst.getString(1);
						String date = rst.getString(2);
						String stime = rst.getString(3);
						String etime = rst.getString(4);
						String src = rst.getString(5);
						String des = rst.getString(6);
						String[] row = {bike,date,stime,etime,src,des};
						bookModel.addRow(row);
					}
					stm.close();con.close();
				}catch(Exception ae) {
					ae.printStackTrace();
				}	
			}
		});
		
		l4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp.setSelectedComponent(tp4);
				try {
					table.setModel(new DefaultTableModel());
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/RideKaro","root","root@648");
					String cmd = "select * from available_bikes";
					PreparedStatement ps = c.prepareStatement(cmd);
					ResultSet rs = ps.executeQuery(cmd);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel mod = (DefaultTableModel) table.getModel();
					int colm = rsmd.getColumnCount();
					String[] colName  = new String[colm];
					for(int i=0;i<colm;i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					mod.setColumnIdentifiers(colName);
					while(rs.next()) {
						String modName = rs.getString(1);
						String bikeNo = rs.getString(2);
						String[] row = {modName,bikeNo};
						mod.addRow(row);
					}
					getBike.setText("");
					ps.close();c.close();
				}catch(Exception ae) {
					
				}
			}
		});
		setLocationRelativeTo(null);
	}
}