import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DetailOverview {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailOverview window = new DetailOverview();
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
	public DetailOverview() {
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
		panelo.setBounds(0, 0, 1010, 43);
		panelo.setBackground(new Color(247, 165, 35));
		panelo.setLayout(null);
		frame.getContentPane().add(panelo);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogo.setBounds(32, 0, 55, 43);
		panelo.add(lbllogo);
		lbllogo.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/logo.png")).getImage().getScaledInstance(45, 33, Image.SCALE_DEFAULT)));
		
		JLabel lbl1 = new JLabel("INMA Theatre");
		lbl1.setBounds(95, 11, 131, 25);
		panelo.add(lbl1);
		lbl1.setFont(new Font("Poppins Black", Font.BOLD, 16));
		lbl1.setForeground(new Color(255, 255, 255));
		
		JButton user_account = new JButton("Employee");
		user_account.setBorderPainted(false);
		user_account.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		user_account.setHorizontalAlignment(SwingConstants.TRAILING);
		user_account.setOpaque(false);
		user_account.setContentAreaFilled(false);
		user_account.setFocusPainted(false);
		user_account.setForeground(Color.WHITE);
		user_account.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		user_account.setBounds(872, 6, 107, 32);
		panelo.add(user_account);
		
		JLabel user_profpic = new JLabel("");
		user_profpic.setHorizontalAlignment(SwingConstants.CENTER);
		user_profpic.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/user-account.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		user_profpic.setBounds(832, 0, 63, 43);
		panelo.add(user_profpic);
		
		JLabel lbl2 = new JLabel("Detail Overview");
		lbl2.setBounds(47, 59, 283, 53);
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.setFont(new Font("Poppins", Font.BOLD, 35));
		frame.getContentPane().add(lbl2);
		
		JPanel panelw = new JPanel();
		panelw.setBounds(47, 122, 916, 338);
		frame.getContentPane().add(panelw);
		panelw.setLayout(null);
		
		JLabel lblposter = new JLabel("");
		lblposter.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/TAP poster.png")).getImage().getScaledInstance(210, 310, Image.SCALE_DEFAULT)));
		lblposter.setBounds(20, 10, 210, 318);
		panelw.add(lblposter);
		
		JLabel lblmt = new JLabel("Movie Title:");
		lblmt.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblmt.setBounds(250, 28, 74, 19);
		panelw.add(lblmt);
		
		JLabel lbld = new JLabel("Date:");
		lbld.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbld.setBounds(250, 58, 45, 19);
		panelw.add(lbld);
		
		JLabel lblt = new JLabel("Time:");
		lblt.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblt.setBounds(250, 88, 45, 19);
		panelw.add(lblt);
		
		JLabel lblc = new JLabel("Cinema:");
		lblc.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblc.setBounds(250, 118, 58, 19);
		panelw.add(lblc);
		
		JLabel lblnos = new JLabel("Number of Seats:");
		lblnos.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblnos.setBounds(250, 148, 112, 19);
		panelw.add(lblnos);
		
		JLabel lbls = new JLabel("Seats:");
		lbls.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbls.setBounds(250, 178, 45, 19);
		panelw.add(lbls);
		
		JLabel lblip = new JLabel("Initial Price:");
		lblip.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblip.setBounds(250, 258, 91, 19);
		panelw.add(lblip);
		
		JLabel lbltp = new JLabel("Total Price:");
		lbltp.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbltp.setBounds(250, 288, 74, 19);
		panelw.add(lbltp);
		
		JLabel lbltitle = new JLabel("The Adam Project");
		lbltitle.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbltitle.setBounds(330, 28, 112, 19);
		panelw.add(lbltitle);
		
		JLabel lbldate = new JLabel("February 16, 2022");
		lbldate.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbldate.setBounds(295, 58, 112, 19);
		panelw.add(lbldate);
		
		JLabel lbltime = new JLabel("2:45PM");
		lbltime.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lbltime.setBounds(295, 88, 45, 19);
		panelw.add(lbltime);
		
		JLabel lblcinema = new JLabel("2");
		lblcinema.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblcinema.setBounds(313, 118, 18, 19);
		panelw.add(lblcinema);
		
		JLabel lblnoseats = new JLabel("5");
		lblnoseats.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblnoseats.setBounds(366, 148, 18, 19);
		panelw.add(lblnoseats);
		
		JLabel lblseats = new JLabel("B3, B4, B5, B6, B7");
		lblseats.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		lblseats.setBounds(300, 178, 112, 19);
		panelw.add(lblseats);
		
		JLabel lblinitial = new JLabel("P320.00");
		lblinitial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblinitial.setBounds(332, 258, 56, 19);
		panelw.add(lblinitial);
		
		JLabel lbltotal = new JLabel("P1,600.00");
		lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltotal.setBounds(332, 288, 67, 19);
		panelw.add(lbltotal);
		
		JButton btn_confirm = new JButton("Confirm");
		btn_confirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_confirm.setBorderPainted(false);
		btn_confirm.setBounds(842, 480, 121, 29);
		btn_confirm.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_confirm.setBackground(new Color(246, 198, 36));
		frame.getContentPane().add(btn_confirm);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PickASeat pas = new PickASeat();
                pas.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancel.setBorderPainted(false);
		btn_cancel.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_cancel.setBackground(new Color(246, 198, 36));
		btn_cancel.setBounds(711, 480, 121, 29);
		frame.getContentPane().add(btn_cancel);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setBounds(0, 0, 1010, 539);
		lblrectangle.setIcon(new ImageIcon (this.getClass().getResource("/images/background.png")));
		frame.getContentPane().add(lblrectangle);
	}
}
