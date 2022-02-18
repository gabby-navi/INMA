import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MovieTimes {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieTimes window = new MovieTimes();
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
	public MovieTimes() {
		initialize();
	}
	
	public static String path;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1010, 43);
		panel.setBackground(new Color(247, 165, 35));
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogo.setBounds(32, 0, 55, 43);
		panel.add(lbllogo);
		lbllogo.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/blue-logo.png")).getImage().getScaledInstance(45, 33, Image.SCALE_DEFAULT)));
		
		JLabel lbl1 = new JLabel("INMA Theatre");
		lbl1.setBounds(95, 11, 131, 25);
		panel.add(lbl1);
		lbl1.setFont(new Font("Poppins Black", Font.BOLD, 16));
		lbl1.setForeground(new Color(255, 255, 255));
		
		JButton user_account = new JButton("Employee");
		user_account.setBorderPainted(false);
		user_account.setHorizontalAlignment(SwingConstants.TRAILING);
		user_account.setOpaque(false);
		user_account.setContentAreaFilled(false);
		user_account.setFocusPainted(false);
		user_account.setForeground(Color.WHITE);
		user_account.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		user_account.setBounds(872, 6, 107, 32);
		panel.add(user_account);
		
		JLabel user_profpic = new JLabel("");
		user_profpic.setHorizontalAlignment(SwingConstants.CENTER);
		user_profpic.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/user-account.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		user_profpic.setBounds(832, 0, 63, 43);
		panel.add(user_profpic);
		
		JPanel time1 = new JPanel();
		time1.setBackground(Color.WHITE);
		time1.setBounds(44, 125, 283, 175);
		frame.getContentPane().add(time1);
		time1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2:45PM");
		lblNewLabel.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 23));
		lblNewLabel.setBounds(18, 18, 121, 24);
		time1.add(lblNewLabel);
		
		JLabel lblCinema = new JLabel("Cinema 2");
		lblCinema.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lblCinema.setBounds(18, 40, 121, 24);
		time1.add(lblCinema);
		
		JLabel lblNoOfSeats = new JLabel("No. of Seats: 150");
		lblNoOfSeats.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lblNoOfSeats.setBounds(18, 75, 121, 24);
		time1.add(lblNoOfSeats);
		
		JLabel lblAvailableSeats = new JLabel("Available Seats: 80");
		lblAvailableSeats.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lblAvailableSeats.setBounds(18, 95, 142, 24);
		time1.add(lblAvailableSeats);
		
		JButton btnNewButton = new JButton("Reserve Seats");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(246, 198, 36));
		btnNewButton.setForeground(new Color(17, 34, 44));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 13));
		btnNewButton.setBounds(18, 130, 244, 34);
		time1.add(btnNewButton);
		
//		JPanel time2 = new JPanel();
//		time2.setBackground(Color.WHITE);
//		time2.setBounds(363, 125, 283, 175);
//		frame.getContentPane().add(time2);
//		time2.setLayout(null);
//		
//		JPanel time3 = new JPanel();
//		time3.setBackground(Color.WHITE);
//		time3.setBounds(678, 125, 283, 175);
//		frame.getContentPane().add(time3);
//		time3.setLayout(null);
//		
//		JPanel time4 = new JPanel();
//		time4.setBackground(Color.WHITE);
//		time4.setBounds(44, 322, 283, 175);
//		frame.getContentPane().add(time4);
//		time4.setLayout(null);
//		
//		JPanel time5 = new JPanel();
//		time5.setBackground(Color.WHITE);
//		time5.setBounds(363, 322, 283, 175);
//		frame.getContentPane().add(time5);
//		time5.setLayout(null);
		
//		JLabel bg = new JLabel("");
//		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
//		bg.setBounds(0, 0, 1008, 537);
//		frame.getContentPane().add(bg);
		
		JLabel label = new JLabel("");
		path = "D:\\kolehiyo\\c_second year\\second term\\INMA\\New folder\\movie-times.png";
		label.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(label);
		
		ImageIcon background = new ImageIcon(path);
		Image img = background.getImage();
		Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImage);
		label.setIcon(image);
		
			
	}
}
