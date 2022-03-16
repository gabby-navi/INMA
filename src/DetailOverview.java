import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DetailOverview {

	JFrame frame;
	static JMenu user_account;
	JTextField availables;
	JTextField totalprice;
	JTextField price;
	JTextField cusNo;
	JTextField tadReserve;
	JComboBox movie, cinemano, times;

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
		
		user_account = new JMenu("");
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(42, 71, 912, 427);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbltitle = new JLabel("ONLINE MOVIE TICKETS BOOKING");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setBounds(205, 30, 509, 53);
		panel.add(lbltitle);
		lbltitle.setFont(new Font("Poppins", Font.BOLD, 30));
		lbltitle.setForeground(new Color(27, 43, 52));
		
		JLabel date2day = new JLabel("*Date Today*");
		date2day.setHorizontalAlignment(SwingConstants.CENTER);
		date2day.setForeground(new Color(27, 43, 52));
		date2day.setFont(new Font("Poppins", Font.BOLD, 14));
		date2day.setBounds(205, 15, 509, 22);
		panel.add(date2day);
		
		JComboBox movie = new JComboBox();
		movie.setBounds(205, 129, 665, 30);
		panel.add(movie);
		
		JLabel lblmovie = new JLabel("Movie");
		lblmovie.setHorizontalAlignment(SwingConstants.TRAILING);
		lblmovie.setFont(new Font("Poppins", Font.BOLD, 13));
		lblmovie.setBounds(10, 137, 178, 14);
		panel.add(lblmovie);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblprice.setFont(new Font("Poppins", Font.BOLD, 13));
		lblprice.setBounds(10, 178, 178, 14);
		panel.add(lblprice);
		
		times = new JComboBox();
		times.setBounds(205, 211, 665, 30);
		panel.add(times);
		
		JLabel lbltimes = new JLabel("Times Available");
		lbltimes.setHorizontalAlignment(SwingConstants.TRAILING);
		lbltimes.setFont(new Font("Poppins", Font.BOLD, 13));
		lbltimes.setBounds(10, 219, 178, 14);
		panel.add(lbltimes);
		
		cinemano = new JComboBox();
		cinemano.setBounds(205, 252, 665, 30);
		panel.add(cinemano);
		
		JLabel lblcinemas = new JLabel("Cinema Number");
		lblcinemas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblcinemas.setFont(new Font("Poppins", Font.BOLD, 13));
		lblcinemas.setBounds(10, 260, 178, 14);
		panel.add(lblcinemas);
		
		JLabel lblavailable = new JLabel("No. of Seats");
		lblavailable.setHorizontalAlignment(SwingConstants.TRAILING);
		lblavailable.setFont(new Font("Poppins", Font.BOLD, 13));
		lblavailable.setBounds(10, 301, 178, 14);
		panel.add(lblavailable);
		
		JLabel lbltotal = new JLabel("Total Price");
		lbltotal.setHorizontalAlignment(SwingConstants.TRAILING);
		lbltotal.setFont(new Font("Poppins", Font.BOLD, 13));
		lbltotal.setBounds(10, 342, 178, 14);
		panel.add(lbltotal);
		
		availables = new JTextField();
		availables.setBounds(205, 293, 665, 30);
		panel.add(availables);
		availables.setColumns(10);
		
		totalprice = new JTextField();
		totalprice.setColumns(10);
		totalprice.setBounds(205, 334, 665, 30);
		panel.add(totalprice);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(205, 170, 665, 30);
		panel.add(price);
		
		JButton remove_btn = new JButton("OK");
		remove_btn.setForeground(new Color(17, 34, 44));
		remove_btn.setFont(new Font("Poppins", Font.BOLD, 13));
		remove_btn.setBorderPainted(false);
		remove_btn.setBackground(new Color(246, 198, 36));
		remove_btn.setBounds(769, 384, 101, 30);
		panel.add(remove_btn);
		
		JLabel lblCustomerNo = new JLabel("Customer No.");
		lblCustomerNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCustomerNo.setFont(new Font("Poppins", Font.BOLD, 13));
		lblCustomerNo.setBounds(10, 96, 178, 14);
		panel.add(lblCustomerNo);
		
		cusNo = new JTextField();
		cusNo.setColumns(10);
		cusNo.setBounds(205, 88, 178, 30);
		panel.add(cusNo);
		
		JLabel lblDateAndTime = new JLabel("Date and Time of Reservation");
		lblDateAndTime.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateAndTime.setFont(new Font("Poppins", Font.BOLD, 13));
		lblDateAndTime.setBounds(379, 96, 230, 14);
		panel.add(lblDateAndTime);
		
		tadReserve = new JTextField("");
		tadReserve.setColumns(10);
		tadReserve.setBounds(619, 88, 251, 30);
		panel.add(tadReserve);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		lblrectangle.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(lblrectangle);
	}

}
