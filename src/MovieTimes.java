import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MovieTimes {

	JFrame frame;
	 JLabel title;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(247, 165, 35));
		menuBar.setBounds(0, 0, 1008, 43);
		frame.getContentPane().add(menuBar);
		
		JMenu lbl_company = new JMenu("  INMA Theatre  ");
		lbl_company.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/blue-logo.png")).getImage().getScaledInstance(45, 33, Image.SCALE_DEFAULT)));
		lbl_company.setFont(new Font("Poppins Black", Font.BOLD, 16));
		lbl_company.setForeground(new Color(255, 255, 255));
		menuBar.add(lbl_company);
		
		JMenu user_account = new JMenu("   Employee   ");
		user_account.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/user-account.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		user_account.setHorizontalAlignment(SwingConstants.CENTER);
		user_account.setBounds(new Rectangle(0, 0, 10, 0));
		user_account.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		user_account.setForeground(Color.WHITE);
		user_account.setContentAreaFilled(false);
		user_account.setBackground(new Color(247, 165, 35));
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(user_account);
		
		JMenuItem logout_item = new JMenuItem("Logout");
		logout_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exitconfirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "", JOptionPane.YES_NO_OPTION);
				if (exitconfirmation == JOptionPane.YES_OPTION) {
					SignIn signIn = new SignIn();
					signIn.frame.setVisible(true);
					frame.dispose();
				}			
			}
		});
		logout_item.setBackground(Color.WHITE);
		logout_item.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		user_account.add(logout_item);
		
		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeDashboard emp_dash = new EmployeeDashboard();
				emp_dash.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblback.setBounds(44, 71, 40, 39);
		lblback.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/back.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(lblback);
		
		title = new JLabel("The Adam Project");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Poppins", Font.BOLD, 30));
		title.setBounds(90, 72, 302, 37);
		frame.getContentPane().add(title);
		
		JLabel lblNewLabel = new JLabel("February 16, 2022");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblNewLabel.setBounds(806, 80, 155, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel time1 = new JPanel();
		time1.setBackground(Color.WHITE);
		time1.setBounds(44, 125, 283, 175);
		frame.getContentPane().add(time1);
		time1.setLayout(null);
		
		JLabel lbl_time1 = new JLabel("2:45PM");
		lbl_time1.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 23));
		lbl_time1.setBounds(18, 16, 121, 24);
		time1.add(lbl_time1);
		
		JLabel lbl_cinema1 = new JLabel("Cinema 2");
		lbl_cinema1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_cinema1.setBounds(18, 38, 121, 24);
		time1.add(lbl_cinema1);
		
		JLabel lbl_seats1 = new JLabel("No. of Seats: 150");
		lbl_seats1.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_seats1.setBounds(18, 75, 121, 24);
		time1.add(lbl_seats1);
		
		JLabel lbl_available1 = new JLabel("Available Seats: 100");
		lbl_available1.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_available1.setBounds(18, 95, 142, 24);
		time1.add(lbl_available1);
		
		JButton btn_reserve1 = new JButton("Reserve Seats");
		btn_reserve1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_reserve1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PickASeat pickseat = new PickASeat();
				pickseat.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_reserve1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reserve1.setBorder(null);
		btn_reserve1.setBackground(new Color(246, 198, 36));
		btn_reserve1.setForeground(new Color(17, 34, 44));
		btn_reserve1.setFocusPainted(false);
		btn_reserve1.setFont(new Font("Poppins", Font.BOLD, 13));
		btn_reserve1.setBounds(18, 130, 244, 34);
		time1.add(btn_reserve1);
		
		JLabel price1 = new JLabel("P320");
		price1.setForeground(new Color(247, 165, 35));
		price1.setVerticalAlignment(SwingConstants.TOP);
		price1.setHorizontalAlignment(SwingConstants.TRAILING);
		price1.setFont(new Font("Poppins Medium", Font.BOLD, 15));
		price1.setBounds(194, 13, 68, 24);
		time1.add(price1);
		
		JPanel time2 = new JPanel();
		time2.setBackground(Color.WHITE);
		time2.setBounds(363, 125, 283, 175);
		frame.getContentPane().add(time2);
		time2.setLayout(null);
		
		JLabel lbl_time2 = new JLabel("8:00PM");
		lbl_time2.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 23));
		lbl_time2.setBounds(18, 16, 121, 24);
		time2.add(lbl_time2);
		
		JLabel lbl_cinema2 = new JLabel("Cinema 2");
		lbl_cinema2.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_cinema2.setBounds(18, 38, 121, 24);
		time2.add(lbl_cinema2);
		
		JLabel lbl_seats2 = new JLabel("No. of Seats: 150");
		lbl_seats2.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_seats2.setBounds(18, 75, 121, 24);
		time2.add(lbl_seats2);
		
		JLabel lbl_available2 = new JLabel("Available Seats: 80");
		lbl_available2.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_available2.setBounds(18, 95, 142, 24);
		time2.add(lbl_available2);
		
		JButton btn_reserve2 = new JButton("Reserve Seats");
		btn_reserve2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PickASeat pickseat = new PickASeat();
				pickseat.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_reserve2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reserve2.setBorder(null);
		btn_reserve2.setBackground(new Color(246, 198, 36));
		btn_reserve2.setForeground(new Color(17, 34, 44));
		btn_reserve2.setFocusPainted(false);
		btn_reserve2.setFont(new Font("Poppins", Font.BOLD, 13));
		btn_reserve2.setBounds(18, 130, 244, 34);
		time2.add(btn_reserve2);
		
		JLabel price2 = new JLabel("P320");
		price2.setForeground(new Color(247, 165, 35));
		price2.setVerticalAlignment(SwingConstants.TOP);
		price2.setHorizontalAlignment(SwingConstants.TRAILING);
		price2.setFont(new Font("Poppins Medium", Font.BOLD, 15));
		price2.setBounds(194, 13, 68, 24);
		time2.add(price2);
		
		JPanel time3 = new JPanel();
		time3.setBackground(Color.WHITE);
		time3.setBounds(678, 125, 283, 175);
		frame.getContentPane().add(time3);
		time3.setLayout(null);
		
		JLabel lbl_time3 = new JLabel("12:00PM");
		lbl_time3.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 23));
		lbl_time3.setBounds(18, 16, 121, 24);
		time3.add(lbl_time3);
		
		JLabel lbl_cinema3 = new JLabel("Cinema 3");
		lbl_cinema3.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_cinema3.setBounds(18, 38, 121, 24);
		time3.add(lbl_cinema3);
		
		JLabel lbl_seats3 = new JLabel("No. of Seats: 250");
		lbl_seats3.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_seats3.setBounds(18, 75, 121, 24);
		time3.add(lbl_seats3);
		
		JLabel lbl_available3 = new JLabel("Available Seats: 150");
		lbl_available3.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_available3.setBounds(18, 95, 142, 24);
		time3.add(lbl_available3);
		
		JButton btn_reserve3 = new JButton("Reserve Seats");
		btn_reserve3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PickASeat pickseat = new PickASeat();
				pickseat.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_reserve3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reserve3.setBorder(null);
		btn_reserve3.setBackground(new Color(246, 198, 36));
		btn_reserve3.setForeground(new Color(17, 34, 44));
		btn_reserve3.setFocusPainted(false);
		btn_reserve3.setFont(new Font("Poppins", Font.BOLD, 13));
		btn_reserve3.setBounds(18, 130, 244, 34);
		time3.add(btn_reserve3);
		
		JLabel price3 = new JLabel("P320");
		price3.setForeground(new Color(247, 165, 35));
		price3.setVerticalAlignment(SwingConstants.TOP);
		price3.setHorizontalAlignment(SwingConstants.TRAILING);
		price3.setFont(new Font("Poppins Medium", Font.BOLD, 15));
		price3.setBounds(194, 13, 68, 24);
		time3.add(price3);
		
		JPanel time4 = new JPanel();
		time4.setBackground(Color.WHITE);
		time4.setBounds(44, 322, 283, 175);
		frame.getContentPane().add(time4);
		time4.setLayout(null);
		
		JLabel lbl_time4 = new JLabel("3:00PM");
		lbl_time4.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 23));
		lbl_time4.setBounds(18, 16, 121, 24);
		time4.add(lbl_time4);
		
		JLabel lbl_cinema4 = new JLabel("Cinema 3");
		lbl_cinema4.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_cinema4.setBounds(18, 38, 121, 24);
		time4.add(lbl_cinema4);
		
		JLabel lbl_seats4 = new JLabel("No. of Seats: 250");
		lbl_seats4.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_seats4.setBounds(18, 75, 121, 24);
		time4.add(lbl_seats4);
		
		JLabel lbl_available4 = new JLabel("Available Seats: 109");
		lbl_available4.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_available4.setBounds(18, 95, 142, 24);
		time4.add(lbl_available4);
		
		JButton btn_reserve4 = new JButton("Reserve Seats");
		btn_reserve4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PickASeat pickseat = new PickASeat();
				pickseat.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_reserve4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reserve4.setBorder(null);
		btn_reserve4.setBackground(new Color(246, 198, 36));
		btn_reserve4.setForeground(new Color(17, 34, 44));
		btn_reserve4.setFocusPainted(false);
		btn_reserve4.setFont(new Font("Poppins", Font.BOLD, 13));
		btn_reserve4.setBounds(18, 130, 244, 34);
		time4.add(btn_reserve4);
		
		JLabel price4 = new JLabel("P320");
		price4.setForeground(new Color(247, 165, 35));
		price4.setVerticalAlignment(SwingConstants.TOP);
		price4.setHorizontalAlignment(SwingConstants.TRAILING);
		price4.setFont(new Font("Poppins Medium", Font.BOLD, 15));
		price4.setBounds(194, 13, 68, 24);
		time4.add(price4);
		
		JPanel time5 = new JPanel();
		time5.setBackground(Color.WHITE);
		time5.setBounds(363, 322, 283, 175);
		frame.getContentPane().add(time5);
		time5.setLayout(null);
		
		JLabel lbl_time5 = new JLabel("6:00PM");
		lbl_time5.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 23));
		lbl_time5.setBounds(18, 16, 121, 24);
		time5.add(lbl_time5);
		
		JLabel lbl_cinema5 = new JLabel("Cinema 3");
		lbl_cinema5.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_cinema5.setBounds(18, 38, 121, 24);
		time5.add(lbl_cinema5);
		
		JLabel lbl_seats5 = new JLabel("No. of Seats: 250");
		lbl_seats5.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_seats5.setBounds(18, 75, 121, 24);
		time5.add(lbl_seats5);
		
		JLabel lbl_available5 = new JLabel("Available Seats: 235");
		lbl_available5.setFont(new Font("Poppins Medium", Font.PLAIN, 13));
		lbl_available5.setBounds(18, 95, 142, 24);
		time5.add(lbl_available5);
		
		JButton btn_reserve5 = new JButton("Reserve Seats");
		btn_reserve5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PickASeat pickseat = new PickASeat();
				pickseat.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_reserve5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reserve5.setBorder(null);
		btn_reserve5.setBackground(new Color(246, 198, 36));
		btn_reserve5.setForeground(new Color(17, 34, 44));
		btn_reserve5.setFocusPainted(false);
		btn_reserve5.setFont(new Font("Poppins", Font.BOLD, 13));
		btn_reserve5.setBounds(18, 130, 244, 34);
		time5.add(btn_reserve5);
		
		JLabel price5 = new JLabel("P320");
		price5.setForeground(new Color(247, 165, 35));
		price5.setVerticalAlignment(SwingConstants.TOP);
		price5.setHorizontalAlignment(SwingConstants.TRAILING);
		price5.setFont(new Font("Poppins Medium", Font.BOLD, 15));
		price5.setBounds(194, 13, 68, 24);
		time5.add(price5);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
			
	}
}
