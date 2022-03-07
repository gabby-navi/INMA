import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;


public class AdminOverview {

	JFrame frame;

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
		
		JLabel lblposter = new JLabel("");
		lblposter.setBounds(18, 10, 150, 229);
		lblposter.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/UN poster.png")).getImage().getScaledInstance(150, 220, Image.SCALE_DEFAULT)));
		panelw.add(lblposter);
		
		JLabel lblmt = new JLabel("Movie Title:");
		lblmt.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblmt.setBounds(185, 22, 87, 17);
		panelw.add(lblmt);
		
		JLabel lbld = new JLabel("Description:");
		lbld.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbld.setBounds(185, 52, 87, 17);
		panelw.add(lbld);
		
		JLabel lblcm1 = new JLabel("Cinema Number:");
		lblcm1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblcm1.setBounds(186, 165, 112, 19);
		panelw.add(lblcm1);
		
		JLabel lblcm2 = new JLabel("Cinema Number:");
		lblcm2.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblcm2.setBounds(186, 225, 114, 19);
		panelw.add(lblcm2);
		
		JLabel lblta1 = new JLabel("Times Available:");
		lblta1.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		lblta1.setBounds(186, 195, 106, 19);
		panelw.add(lblta1);
		
		JLabel lblta2 = new JLabel("Times Available:");
		lblta2.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		lblta2.setBounds(186, 255, 108, 19);
		panelw.add(lblta2);
		
		JLabel lblp = new JLabel("Price:");
		lblp.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblp.setBounds(185, 315, 45, 19);
		panelw.add(lblp);
		
		JLabel lbltitle = new JLabel("Uncharted");
		lbltitle.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbltitle.setBounds(300, 21, 81, 19);
		panelw.add(lbltitle);
		
		JLabel lbldesc1 = new JLabel("Nathan Drake and his wisecracking partner Victor \"Sully\" Sullivan embark");
		lbldesc1.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbldesc1.setBounds(300, 51, 447, 19);
		panelw.add(lbldesc1);
		
		JLabel lbldesc2 = new JLabel("on a dangerous quest to find the greatest treasure never found while also");
		lbldesc2.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbldesc2.setBounds(300, 65, 447, 19);
		panelw.add(lbldesc2);
		
		JLabel lbldesc3 = new JLabel("tracking clues that may lead to Nate's long-lost brother.");
		lbldesc3.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbldesc3.setBounds(300, 79, 437, 19);
		panelw.add(lbldesc3);
		
		JLabel lblcno1 = new JLabel("1");
		lblcno1.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblcno1.setBounds(300, 165, 18, 19);
		panelw.add(lblcno1);
		
		JLabel lblcno2 = new JLabel("2");
		lblcno2.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblcno2.setBounds(300, 225, 21, 19);
		panelw.add(lblcno2);
		
		JLabel lblt1 = new JLabel("8:00PM");
		lblt1.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblt1.setBounds(300, 195, 51, 19);
		panelw.add(lblt1);
		
		JLabel lblt2 = new JLabel("2:30PM");
		lblt2.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblt2.setBounds(300, 255, 45, 19);
		panelw.add(lblt2);
		
		JLabel lblt3 = new JLabel("5:30PM");
		lblt3.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblt3.setBounds(300, 269, 45, 19);
		panelw.add(lblt3);
		
		JLabel lblt4 = new JLabel("8:30PM");
		lblt4.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblt4.setBounds(300, 283, 45, 19);
		panelw.add(lblt4);
		
		JLabel lblprice = new JLabel("P350.00");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblprice.setBounds(300, 315, 81, 19);
		panelw.add(lblprice);
		
		JLabel lblstart = new JLabel("Start Showing:");
		lblstart.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblstart.setBounds(185, 108, 116, 17);
		panelw.add(lblstart);
		
		JLabel lblend = new JLabel("End Showing:");
		lblend.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblend.setBounds(185, 137, 116, 17);
		panelw.add(lblend);
		
		JLabel startDate = new JLabel("February 16, 2022");
		startDate.setFont(new Font("Poppins", Font.PLAIN, 12));
		startDate.setBounds(300, 109, 116, 19);
		panelw.add(startDate);
		
		JLabel endDate = new JLabel("Febraury 18, 2022");
		endDate.setFont(new Font("Poppins", Font.PLAIN, 12));
		endDate.setBounds(300, 135, 116, 19);
		panelw.add(endDate);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setBounds(0, 0, 1010, 539);
		lblrectangle.setIcon(new ImageIcon (this.getClass().getResource("/images/background.png")));
		frame.getContentPane().add(lblrectangle);
	}
}
