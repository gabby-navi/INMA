import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class EmployeeDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDashboard window = new EmployeeDashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeDashboard() {
		initialize();
	}
	
	public static String path;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("INMA Theatre");
		lbl1.setFont(new Font("Poppins", Font.BOLD, 16));
		lbl1.setForeground(new Color(255, 255, 255));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(66, 12, 120, 25);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Online Movie Tickets Booking");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Poppins", Font.BOLD, 35));
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.setBounds(38, 59, 531, 53);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Today");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setForeground(new Color(255, 255, 255));
		lbl3.setFont(new Font("Poppins", Font.PLAIN, 23));
		lbl3.setBounds(38, 122, 95, 43);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("February 16, 2022");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setForeground(new Color(255, 255, 255));
		lbl4.setFont(new Font("Poppins SemiBold", Font.PLAIN, 16));
		lbl4.setBounds(40, 156, 154, 38);
		frame.getContentPane().add(lbl4);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogo.setBounds(10, 4, 55, 37);
		path = "C:\\Users\\niel\\OneDrive\\Pictures\\mtrs-inma\\logo.png";
		ImageIcon background = new ImageIcon(path);
        Image imgl = background.getImage();
        Image newImage = imgl.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        lbllogo.setIcon(image); 
		frame.getContentPane().add(lbllogo);
		
		JLabel lblfirstm = new JLabel("");
		lblfirstm.setHorizontalAlignment(SwingConstants.CENTER);
		lblfirstm.setBounds(46, 204, 174, 282);
		Image img1 = new ImageIcon(this.getClass().getResource("1.png")).getImage();
		lblfirstm.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(lblfirstm);
		
		JLabel lblsecm = new JLabel("");
		lblsecm.setHorizontalAlignment(SwingConstants.CENTER);
		lblsecm.setBounds(235, 204, 166, 282);
		Image img2 = new ImageIcon(this.getClass().getResource("2.png")).getImage();
		lblsecm.setIcon(new ImageIcon(img2));
		frame.getContentPane().add(lblsecm);
		
		JLabel lblthirdm = new JLabel("");
		lblthirdm.setHorizontalAlignment(SwingConstants.CENTER);
		lblthirdm.setBounds(416, 204, 174, 282);
		Image img3 = new ImageIcon(this.getClass().getResource("3.png")).getImage();
		lblthirdm.setIcon(new ImageIcon(img3));
		frame.getContentPane().add(lblthirdm);
		
		JLabel lblfourthm = new JLabel("");
		lblfourthm.setHorizontalAlignment(SwingConstants.CENTER);
		lblfourthm.setBounds(602, 204, 174, 282);
		Image img4 = new ImageIcon(this.getClass().getResource("4.png")).getImage();
		lblfourthm.setIcon(new ImageIcon(img4));
		frame.getContentPane().add(lblfourthm);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1010, 43);
		panel.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panel);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setBounds(0, 0, 1010, 539);
		Image imgr = new ImageIcon(this.getClass().getResource("Rectangle 2.png")).getImage();
		lblrectangle.setIcon(new ImageIcon(imgr));
		frame.getContentPane().add(lblrectangle);
		
	}
}
