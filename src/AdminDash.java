import java.awt.*;
import javax.swing.*;


public class AdminDash {

	private JFrame frame;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDash window = new AdminDash();
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
	public AdminDash() {
		initialize();
	}
	
	public static String path;
	private JTable table;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 206, 537);
		panel.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_dash = new JLabel("Dashboard");
		lbl_dash.setForeground(Color.WHITE);
		lbl_dash.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_dash.setBounds(233, 49, 159, 19);
		frame.getContentPane().add(lbl_dash);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(233, 78, 747, 2);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Scheduled Movies");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 16));
		lblNewLabel.setBounds(235, 103, 159, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lbl_reservations = new JLabel("Reservations");
		lbl_reservations.setForeground(Color.WHITE);
		lbl_reservations.setFont(new Font("Poppins", Font.BOLD, 16));
		lbl_reservations.setBounds(235, 316, 159, 14);
		frame.getContentPane().add(lbl_reservations);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(AdminDash.class.getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
		
//		JLabel label = new JLabel("");
//		path = "D:\\kolehiyo\\c_second year\\second term\\INMA\\New folder\\AdminDashboard.png";
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
