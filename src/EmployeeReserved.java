import java.awt.*;
import javax.swing.*;

public class EmployeeReserved {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeReserved window = new EmployeeReserved();
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
	public EmployeeReserved() {
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
		
		JButton btn_dash = new JButton("Dashboard");
		btn_dash.setForeground(Color.WHITE);
		btn_dash.setBackground(new Color(246, 198, 36));
		btn_dash.setBorderPainted(false);
		btn_dash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_dash.setFocusPainted(false);
		btn_dash.setHorizontalAlignment(SwingConstants.LEFT);
		btn_dash.setFont(new Font("Poppins SemiBold", Font.PLAIN, 15));
		btn_dash.setBounds(5, 79, 194, 40);
		frame.getContentPane().add(btn_dash);
		
		JButton btn_sched = new JButton("Scheduled Movies");
		btn_sched.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sched.setHorizontalAlignment(SwingConstants.LEFT);
		btn_sched.setForeground(Color.WHITE);
		btn_sched.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_sched.setFocusPainted(false);
		btn_sched.setBorderPainted(false);
		btn_sched.setBackground(new Color(247, 165, 35));
		btn_sched.setBounds(5, 126, 194, 40);
		frame.getContentPane().add(btn_sched);
		
		JButton btn_reservations = new JButton("Reservations");
		btn_reservations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reservations.setHorizontalAlignment(SwingConstants.LEFT);
		btn_reservations.setForeground(Color.WHITE);
		btn_reservations.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_reservations.setFocusPainted(false);
		btn_reservations.setBorderPainted(false);
		btn_reservations.setBackground(new Color(247, 165, 35));
		btn_reservations.setBounds(5, 173, 194, 40);
		frame.getContentPane().add(btn_reservations);
		
		JLabel blue_logo = new JLabel("");
		blue_logo.setIcon(new ImageIcon(AdminDash.class.getResource("/images/blue-logo.png")));
		blue_logo.setBounds(20, 18, 67, 46);
		frame.getContentPane().add(blue_logo);
		
		JPanel sidenav = new JPanel();
		sidenav.setBounds(0, 0, 206, 537);
		sidenav.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(sidenav);
		sidenav.setLayout(null);
		
		JLabel lblback = new JLabel("");
		lblback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblback.setBounds(234, 37, 40, 39);
		lblback.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/back.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(lblback);
		
		JLabel lbl_dash = new JLabel("Niel Mendoza");
		lbl_dash.setForeground(Color.WHITE);
		lbl_dash.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_dash.setBounds(277, 49, 159, 19);
		frame.getContentPane().add(lbl_dash);
		
		JButton user_account = new JButton("Admin");
		user_account.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		user_account.setBorderPainted(false);
		user_account.setHorizontalAlignment(SwingConstants.TRAILING);
		user_account.setOpaque(false);
		user_account.setContentAreaFilled(false);
		user_account.setFocusPainted(false);
		user_account.setForeground(Color.WHITE);
		user_account.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		user_account.setBounds(905, 17, 79, 32);
		frame.getContentPane().add(user_account);
		
		JLabel user_profpic = new JLabel("");
		user_profpic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		user_profpic.setHorizontalAlignment(SwingConstants.CENTER);
		user_profpic.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/user-account.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		user_profpic.setBounds(859, 10, 63, 43);
		frame.getContentPane().add(user_profpic);
		
		JPanel hr = new JPanel();
		hr.setBounds(233, 78, 747, 2);
		frame.getContentPane().add(hr);
		
		JLabel lbl3 = new JLabel("Today");
		lbl3.setForeground(new Color(255, 255, 255));
		lbl3.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 22));
		lbl3.setBounds(233, 88, 95, 43);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("February 16, 2022");
		lbl4.setForeground(new Color(255, 255, 255));
		lbl4.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl4.setBounds(233, 113, 154, 38);
		frame.getContentPane().add(lbl4);
		
		JPanel movie1 = new JPanel();
		movie1.setBackground(Color.WHITE);
		movie1.setBounds(234, 155, 174, 175);
		frame.getContentPane().add(movie1);
		movie1.setLayout(null);
		
		JLabel movie_title1 = new JLabel("Uncharted");
		movie_title1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 15));
		movie_title1.setBounds(10, 11, 154, 14);
		movie1.add(movie_title1);
		
		JLabel lbl_cinema11 = new JLabel("Cinema 1");
		lbl_cinema11.setForeground(new Color(247, 165, 35));
		lbl_cinema11.setFont(new Font("Poppins", Font.BOLD, 12));
		lbl_cinema11.setBounds(10, 36, 154, 14);
		movie1.add(lbl_cinema11);
		
		JLabel seats_11 = new JLabel("No. of Seats Reserved: 38");
		seats_11.setForeground(Color.BLACK);
		seats_11.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		seats_11.setBounds(10, 61, 154, 14);
		movie1.add(seats_11);
		
		JLabel total_11 = new JLabel("Total: P13,300");
		total_11.setForeground(Color.BLACK);
		total_11.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		total_11.setBounds(10, 77, 154, 14);
		movie1.add(total_11);
		
		JLabel cinema12 = new JLabel("Cinema 2");
		cinema12.setForeground(new Color(247, 165, 35));
		cinema12.setFont(new Font("Poppins", Font.BOLD, 12));
		cinema12.setBounds(10, 102, 154, 14);
		movie1.add(cinema12);
		
		JLabel seats_12 = new JLabel("No. of Seats Reserved: 42");
		seats_12.setForeground(Color.BLACK);
		seats_12.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		seats_12.setBounds(10, 127, 154, 14);
		movie1.add(seats_12);
		
		JLabel total_12 = new JLabel("Total: P14,700");
		total_12.setForeground(Color.BLACK);
		total_12.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		total_12.setBounds(10, 143, 154, 14);
		movie1.add(total_12);
		
		JPanel movie1_1 = new JPanel();
		movie1_1.setLayout(null);
		movie1_1.setBackground(Color.WHITE);
		movie1_1.setBounds(426, 155, 174, 175);
		frame.getContentPane().add(movie1_1);
		
		JLabel movie_title2 = new JLabel("Minions: The Rise of Gru");
		movie_title2.setFont(new Font("Poppins SemiBold", Font.PLAIN, 15));
		movie_title2.setBounds(10, 11, 154, 14);
		movie1_1.add(movie_title2);
		
		JLabel lbl_cinema2 = new JLabel("Cinema 4");
		lbl_cinema2.setForeground(new Color(247, 165, 35));
		lbl_cinema2.setFont(new Font("Poppins", Font.BOLD, 12));
		lbl_cinema2.setBounds(10, 36, 154, 14);
		movie1_1.add(lbl_cinema2);
		
		JLabel seats_2 = new JLabel("No. of Seats Reserved: 70");
		seats_2.setForeground(Color.BLACK);
		seats_2.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		seats_2.setBounds(10, 61, 154, 14);
		movie1_1.add(seats_2);
		
		JLabel total_2 = new JLabel("Total: P28,000");
		total_2.setForeground(Color.BLACK);
		total_2.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		total_2.setBounds(10, 77, 154, 14);
		movie1_1.add(total_2);
		
		JPanel movie1_2 = new JPanel();
		movie1_2.setLayout(null);
		movie1_2.setBackground(Color.WHITE);
		movie1_2.setBounds(617, 155, 174, 175);
		frame.getContentPane().add(movie1_2);
		
		JLabel movie_title3 = new JLabel("Doctor Strange in the Multiverse of Madness");
		movie_title3.setFont(new Font("Poppins SemiBold", Font.PLAIN, 15));
		movie_title3.setBounds(10, 11, 154, 14);
		movie1_2.add(movie_title3);
		
		JLabel lbl_cinema3 = new JLabel("Cinema 4");
		lbl_cinema3.setForeground(new Color(247, 165, 35));
		lbl_cinema3.setFont(new Font("Poppins", Font.BOLD, 12));
		lbl_cinema3.setBounds(10, 36, 154, 14);
		movie1_2.add(lbl_cinema3);
		
		JLabel seats_3 = new JLabel("No. of Seats Reserved: 78");
		seats_3.setForeground(Color.BLACK);
		seats_3.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		seats_3.setBounds(10, 61, 154, 14);
		movie1_2.add(seats_3);
		
		JLabel total_11_2 = new JLabel("Total: P27,300");
		total_11_2.setForeground(Color.BLACK);
		total_11_2.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		total_11_2.setBounds(10, 77, 154, 14);
		movie1_2.add(total_11_2);
		
		JPanel movie1_3 = new JPanel();
		movie1_3.setLayout(null);
		movie1_3.setBackground(Color.WHITE);
		movie1_3.setBounds(806, 155, 174, 175);
		frame.getContentPane().add(movie1_3);
		
		JLabel movie_title4 = new JLabel("The Adam Project");
		movie_title4.setFont(new Font("Poppins SemiBold", Font.PLAIN, 15));
		movie_title4.setBounds(10, 11, 154, 14);
		movie1_3.add(movie_title4);
		
		JLabel cinema_41 = new JLabel("Cinema 2");
		cinema_41.setForeground(new Color(247, 165, 35));
		cinema_41.setFont(new Font("Poppins", Font.BOLD, 12));
		cinema_41.setBounds(10, 36, 154, 14);
		movie1_3.add(cinema_41);
		
		JLabel seats_41 = new JLabel("No. of Seats Reserved: 35");
		seats_41.setForeground(Color.BLACK);
		seats_41.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		seats_41.setBounds(10, 61, 154, 14);
		movie1_3.add(seats_41);
		
		JLabel total_41 = new JLabel("Total: P11,200");
		total_41.setForeground(Color.BLACK);
		total_41.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		total_41.setBounds(10, 77, 154, 14);
		movie1_3.add(total_41);
		
		JLabel cinema42 = new JLabel("Cinema 3");
		cinema42.setForeground(new Color(247, 165, 35));
		cinema42.setFont(new Font("Poppins", Font.BOLD, 12));
		cinema42.setBounds(10, 102, 154, 14);
		movie1_3.add(cinema42);
		
		JLabel seats_42 = new JLabel("No. of Seats Reserved: 37");
		seats_42.setForeground(Color.BLACK);
		seats_42.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		seats_42.setBounds(10, 127, 154, 14);
		movie1_3.add(seats_42);
		
		JLabel total_42 = new JLabel("Total: P11,840");
		total_42.setForeground(Color.BLACK);
		total_42.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		total_42.setBounds(10, 143, 154, 14);
		movie1_3.add(total_42);
		
		JLabel lbl4_1 = new JLabel("Total: P106,500.00");
		lbl4_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl4_1.setForeground(Color.WHITE);
		lbl4_1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl4_1.setBounds(826, 91, 154, 38);
		frame.getContentPane().add(lbl4_1);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
		
//		JLabel label = new JLabel("");
//		path = "D:\\kolehiyo\\c_second year\\second term\\INMA\\New folder\\employee-reserved.png";
//		label.setBounds(0, 0, 1008, 537);
//		frame.getContentPane().add(label);
//		
//		ImageIcon background = new ImageIcon(path);
//		Image img = background.getImage();
//		Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
//		ImageIcon image = new ImageIcon(newImage);
//		label.setIcon(image);
		
		
	}

}
