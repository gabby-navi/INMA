import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;


public class AdminOverview {

	JFrame frame;
	static JLabel lblposter;
//	JLabel lbl_price;
	JLabel lblcno1;
	JTextField times_1f;
	JTextField textField_price;
	JTextField textField_title;
	JTextArea txt_area;
	String time_avail1, movie_title, movie_desc;
	Date start_date, end_date;
	double movie_price;
	int cinema_num;
	int seat_num = 150;
	JTextField startDate;
	JTextField endDate;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOverview window = new AdminOverview();
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
	public AdminOverview() {
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
		
		JPanel panelo = new JPanel();
		panelo.setBounds(0, 0, 206, 537);
		panelo.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panelo);
		panelo.setLayout(null);
		
		JButton btn_dash = new JButton("Dashboard");
		btn_dash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AdminDash ad = new AdminDash();
                ad.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_dash.setForeground(Color.WHITE);
		btn_dash.setBackground(new Color(247, 165, 35));
		btn_dash.setBorderPainted(false);
		btn_dash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_dash.setFocusPainted(false);
		btn_dash.setHorizontalAlignment(SwingConstants.LEFT);
		btn_dash.setFont(new Font("Poppins SemiBold", Font.PLAIN, 15));
		btn_dash.setBounds(5, 79, 194, 40);
		panelo.add(btn_dash);
		
		JButton btn_sched = new JButton("Scheduled Movies");
		btn_sched.setForeground(Color.WHITE);
		btn_sched.setBackground(new Color(246, 198, 36));
		btn_sched.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sched.setHorizontalAlignment(SwingConstants.LEFT);
		btn_sched.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_sched.setFocusPainted(false);
		btn_sched.setBorderPainted(false);
		btn_sched.setBounds(5, 126, 194, 40);
		panelo.add(btn_sched);
		
		JButton btn_reservations = new JButton("Reservations");
		btn_reservations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Reservations r = new Reservations();
                r.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_reservations.setForeground(Color.WHITE);
		btn_reservations.setBackground(new Color(247, 165, 35));
		btn_reservations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reservations.setHorizontalAlignment(SwingConstants.LEFT);
		btn_reservations.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_reservations.setFocusPainted(false);
		btn_reservations.setBorderPainted(false);
		btn_reservations.setBounds(5, 173, 194, 40);
		panelo.add(btn_reservations);
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon(this.getClass().getResource("/images/logo.png")));
		lbl_logo.setBounds(20, 18, 67, 46);
		panelo.add(lbl_logo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(247, 165, 35));
		menuBar.setBounds(735, 10, 263, 43);
		frame.getContentPane().add(menuBar);
		
		JMenu user_account = new JMenu("   Admin   ");
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
				
				SchedMovies sm = new SchedMovies();
                sm.frame.setVisible(true);
                frame.dispose();
			}
		});
		lblback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblback.setBounds(234, 37, 40, 39);
        lblback.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/back.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        frame.getContentPane().add(lblback); 
		
		JLabel lbl_schedmovies = new JLabel("Uncharted");
		lbl_schedmovies.setForeground(Color.WHITE);
		lbl_schedmovies.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_schedmovies.setBounds(274, 49, 137, 19);
		frame.getContentPane().add(lbl_schedmovies);
		
		JPanel line = new JPanel();
		line.setBounds(233, 78, 747, 2);
		frame.getContentPane().add(line);
		
		JButton btn_edit = new JButton("Edit");
		btn_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AdminOverviewEdit aoe = new AdminOverviewEdit();
                aoe.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_edit.setBorderPainted(false);
		btn_edit.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_edit.setBackground(new Color(246, 198, 36));
		btn_edit.setBounds(859, 90, 121, 29);
		frame.getContentPane().add(btn_edit);
		
		JPanel panelw = new JPanel();
		panelw.setBackground(Color.WHITE);
		panelw.setBounds(233, 129, 747, 380);
		frame.getContentPane().add(panelw);
		panelw.setLayout(null);
		
		JButton btn_change = new JButton("Change");
		btn_change.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_change.setBorderPainted(false);
		btn_change.setBounds(48, 240, 87, 19);
		btn_change.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_change.setBackground(new Color(246, 198, 36));
		panelw.add(btn_change);
		
		lblposter = new JLabel("");
		lblposter.setBounds(18, 12, 150, 220);
		panelw.add(lblposter);
		
		JLabel lblmt = new JLabel("Movie Title:");
		lblmt.setBounds(185, 22, 87, 17);
		lblmt.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblmt);
		
		JLabel lbld = new JLabel("Description:");
		lbld.setBounds(185, 60, 87, 17);
		lbld.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lbld);
		
		JLabel lblstart = new JLabel("Start Showing:");
		lblstart.setBounds(185, 125, 116, 17);
		lblstart.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblstart);
		
		JLabel lblcm1 = new JLabel("Cinema Number:");
		lblcm1.setBounds(185, 214, 112, 19);
		lblcm1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblcm1);
		
		JLabel lblta1 = new JLabel("Times Available:");
		lblta1.setBounds(185, 262, 106, 19);
		lblta1.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		panelw.add(lblta1);
		
		JLabel lblp = new JLabel("Price:");
		lblp.setBounds(185, 305, 45, 19);
		lblp.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblp);
		
//		lbltitle = new JLabel("");
//		lbltitle.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
//		lbltitle.setBounds(282, 21, 437, 19);
//		panelw.add(lbltitle);
//		
		lblcno1 = new JLabel("");
		lblcno1.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblcno1.setBounds(296, 214, 437, 19);
		panelw.add(lblcno1);
//		
//		lblt1 = new JLabel("");
//		lblt1.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
//		lblt1.setBounds(299, 220, 420, 19);
//		panelw.add(lblt1);
//		
//		lbl_price = new JLabel("");
//		lbl_price.setFont(new Font("Dialog", Font.PLAIN, 12));
//		lbl_price.setBounds(284, 292, 435, 19);
//		panelw.add(lbl_price);
		
		JLabel lblprice = new JLabel("");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblprice.setBounds(300, 292, 81, 19);
		panelw.add(lblprice);
		
		JLabel lblend = new JLabel("End Showing:");
		lblend.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblend.setBounds(185, 165, 116, 17);
		panelw.add(lblend);
		
//		startDate = new JLabel("");
//		startDate.setFont(new Font("Poppins", Font.PLAIN, 12));
//		startDate.setBounds(282, 109, 437, 19);
//		panelw.add(startDate);
//		
//		endDate = new JLabel("");
//		endDate.setFont(new Font("Poppins", Font.PLAIN, 12));
//		endDate.setBounds(282, 136, 437, 19);
//		panelw.add(endDate);
		
		textField_title = new JTextField();
		textField_title.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		textField_title.setBounds(296, 19, 437, 22);
		panelw.add(textField_title);
		textField_title.setColumns(10);
		
        txt_area = new JTextArea();
		txt_area.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_area.setMargin(new Insets(3, 7, 3, 3));
		txt_area.setFont(new Font("Poppins", Font.PLAIN, 12));
		txt_area.setLineWrap(true);
		txt_area.setWrapStyleWord(true);
		txt_area.setBounds(296, 54, 437, 57);
		panelw.add(txt_area);
		
		times_1f = new JTextField();
		times_1f.setMargin(new Insets(3, 7, 3, 3));
		times_1f.setFont(new Font("Poppins", Font.PLAIN, 12));
		times_1f.setColumns(10);
		times_1f.setBounds(296, 261, 437, 20);
		panelw.add(times_1f);
		
		textField_price = new JTextField();
		textField_price.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		textField_price.setBounds(296, 305, 437, 20);
		panelw.add(textField_price);
		textField_price.setColumns(10);
		
		startDate = new JTextField();
		startDate.setFont(new Font("Poppins", Font.PLAIN, 12));
		startDate.setColumns(10);
		startDate.setBounds(296, 122, 437, 22);
		panelw.add(startDate);
		
		endDate = new JTextField();
		endDate.setFont(new Font("Poppins", Font.PLAIN, 12));
		endDate.setColumns(10);
		endDate.setBounds(296, 162, 437, 22);
		panelw.add(endDate);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setBounds(0, 0, 1010, 539);
		lblrectangle.setIcon(new ImageIcon (this.getClass().getResource("/images/background.png")));
		frame.getContentPane().add(lblrectangle);
	}
}
