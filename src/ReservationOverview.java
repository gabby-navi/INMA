import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ReservationOverview {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationOverview window = new ReservationOverview();
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
	public ReservationOverview() {
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
		
		JLabel lbl2 = new JLabel("Detail Overview");
		lbl2.setBounds(94, 71, 283, 39);
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.setFont(new Font("Poppins", Font.BOLD, 35));
		frame.getContentPane().add(lbl2);
		
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
		
		JButton btn_cancel = new JButton("Cancel Reservation");
		btn_cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancel.setBorderPainted(false);
		btn_cancel.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_cancel.setBackground(new Color(246, 198, 36));
		btn_cancel.setBounds(819, 75, 144, 35);
		frame.getContentPane().add(btn_cancel);
		
		JPanel panelw = new JPanel();
		panelw.setBounds(47, 122, 916, 338);
		frame.getContentPane().add(panelw);
		panelw.setLayout(null);
		
		JLabel lblposter = new JLabel("");
		lblposter.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/TAP poster.png")).getImage().getScaledInstance(210, 310, Image.SCALE_DEFAULT)));
		lblposter.setBounds(20, 10, 210, 318);
		panelw.add(lblposter);
		
		JLabel lblcn = new JLabel("Customer No.:");
		lblcn.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblcn.setBounds(250, 16, 91, 19);
		panelw.add(lblcn);
		
		JLabel lbltor = new JLabel("Time of Reservation:");
		lbltor.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbltor.setBounds(250, 46, 134, 19);
		panelw.add(lbltor);
		
		JLabel lblmt = new JLabel("Movie Title:");
		lblmt.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblmt.setBounds(250, 76, 74, 19);
		panelw.add(lblmt);
		
		JLabel lbld = new JLabel("Date:");
		lbld.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbld.setBounds(250, 106, 45, 19);
		panelw.add(lbld);
		
		JLabel lblt = new JLabel("Time:");
		lblt.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblt.setBounds(250, 136, 45, 19);
		panelw.add(lblt);
		
		JLabel lblc = new JLabel("Cinema:");
		lblc.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblc.setBounds(250, 166, 58, 19);
		panelw.add(lblc);
		
		JLabel lblnos = new JLabel("Number of Seats:");
		lblnos.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblnos.setBounds(250, 196, 112, 19);
		panelw.add(lblnos);
		
		JLabel lbls = new JLabel("Seats:");
		lbls.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbls.setBounds(250, 226, 45, 19);
		panelw.add(lbls);
		
		JLabel lblip = new JLabel("Initial Price:");
		lblip.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblip.setBounds(250, 272, 74, 19);
		panelw.add(lblip);
		
		JLabel lbltp = new JLabel("Total Price:");
		lbltp.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbltp.setBounds(250, 302, 74, 19);
		panelw.add(lbltp);
		
		JLabel lbltitle = new JLabel("The Adam Project");
		lbltitle.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbltitle.setBounds(330, 76, 112, 19);
		panelw.add(lbltitle);
		
		JLabel lblcusno = new JLabel("#1234");
		lblcusno.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblcusno.setBounds(351, 16, 45, 19);
		panelw.add(lblcusno);
		
		JLabel lbltimeres = new JLabel("6:55PM");
		lbltimeres.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbltimeres.setBounds(386, 46, 58, 19);
		panelw.add(lbltimeres);
		
		JLabel lbldate = new JLabel("February 16, 2022");
		lbldate.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbldate.setBounds(295, 106, 112, 19);
		panelw.add(lbldate);
		
		JLabel lbltime = new JLabel("8:00PM");
		lbltime.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbltime.setBounds(295, 136, 45, 19);
		panelw.add(lbltime);
		
		JLabel lblcinema = new JLabel("2");
		lblcinema.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblcinema.setBounds(313, 166, 18, 19);
		panelw.add(lblcinema);
		
		JLabel lblnoseats = new JLabel("2");
		lblnoseats.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblnoseats.setBounds(366, 196, 18, 19);
		panelw.add(lblnoseats);
		
		JLabel lblseats = new JLabel("B3, B4");
		lblseats.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblseats.setBounds(300, 226, 112, 19);
		panelw.add(lblseats);
		
		JLabel lblinitial = new JLabel("P320.00");
		lblinitial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblinitial.setBounds(332, 272, 56, 19);
		panelw.add(lblinitial);
		
		JLabel lbltotal = new JLabel("P640.00");
		lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltotal.setBounds(332, 302, 67, 19);
		panelw.add(lbltotal);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
	}

}
