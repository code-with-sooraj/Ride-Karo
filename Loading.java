import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Loading extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jp1;

	public static void main(String[] args) {
		new Loading();
	}

	public Loading() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\icon.jpg"));
		setTitle("Ride Karo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 312);
		jp1 = new JPanel();
		jp1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jp1);
		jp1.setLayout(null);
		
		JPanel jp2 = new JPanel() {
			protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 204, 150),
			       getWidth(), getHeight(), new Color(102, 255, 102, 215), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		jp2.setBounds(0, 0, 340, 252);
		jp1.add(jp2);
		jp2.setLayout(null);
		
		JLabel jl1 = new JLabel("Ride Karo");
		jl1.setForeground(Color.BLACK);
		jl1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		jl1.setBounds(95, 10, 145, 35);
		jp2.add(jl1);
		
		JLabel jl2 = new JLabel("forget everything and ride");
		jl2.setForeground(new Color(0, 0, 255));
		jl2.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		jl2.setBounds(130, 41, 200, 23);
		jp2.add(jl2);
		
		JLabel jl3 = new JLabel("");
		jl3.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\ezgif.com-resize (1).gif"));
		jl3.setBounds(95, 96, 156, 90);
		jp2.add(jl3);
		
		JLabel lblNewLabel = new JLabel("Make your journey easy with Ride Karo");
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		lblNewLabel.setBounds(28, 201, 295, 23);
		jp2.add(lblNewLabel);
		
		JProgressBar pb = new JProgressBar();
		pb.setStringPainted(true);
		pb.setBounds(0, 252, 340, 25);
		jp1.add(pb);
		setLocationRelativeTo(null);
		setVisible(true);
		int i = 0;
		try {
			while (i <= 100) {
				pb.setValue(i + 10);
				Thread.sleep(500);
				i += 10;
			}
			if(pb.getValue() >= 100) {
				dispose();
				new LoginPage();
			}
		}
		catch (Exception e) {
		}
	}
}