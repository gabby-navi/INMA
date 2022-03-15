import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeDashboard {

	JFrame frame;
	static JMenu user_account;

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
	
	static String connectionUrl = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName = MTRS;"
			+ "username = sa;"
			+ "password = inmainmainma;"
			+ ";encrypt = true;trustServerCertificate = true;";

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl2 = new JLabel("Online Movie Tickets Booking");
		lbl2.setFont(new Font("Poppins", Font.BOLD, 35));
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.setBounds(45, 72, 531, 53);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Today");
		lbl3.setForeground(new Color(255, 255, 255));
		lbl3.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 23));
		lbl3.setBounds(45, 135, 95, 43);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("February 16, 2022");
		lbl4.setForeground(new Color(255, 255, 255));
		lbl4.setFont(new Font("Poppins SemiBold", Font.PLAIN, 16));
		lbl4.setBounds(47, 163, 154, 38);
		frame.getContentPane().add(lbl4);
		
		JLabel lblfirstm = new JLabel("");
		lblfirstm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MovieTimes mt = new MovieTimes();
                mt.frame.setVisible(true);
                frame.dispose();
			}
		});
		lblfirstm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblfirstm.setHorizontalAlignment(SwingConstants.CENTER);
		lblfirstm.setBounds(45, 218, 174, 282);
		lblfirstm.setIcon(new ImageIcon(this.getClass().getResource("/images/1.png")));
		frame.getContentPane().add(lblfirstm);
		
		JLabel lblsecm = new JLabel("");
		lblsecm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MovieTimes mt = new MovieTimes();
                mt.frame.setVisible(true);
                frame.dispose();
			}
		});
		lblsecm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblsecm.setHorizontalAlignment(SwingConstants.CENTER);
		lblsecm.setBounds(234, 218, 166, 282);
		lblsecm.setIcon(new ImageIcon(this.getClass().getResource("/images/2.png")));
		frame.getContentPane().add(lblsecm);
		
		JLabel lblthirdm = new JLabel("");
		lblthirdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MovieTimes mt = new MovieTimes();
                mt.frame.setVisible(true);
                frame.dispose();
			}
		});
		lblthirdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblthirdm.setHorizontalAlignment(SwingConstants.CENTER);
		lblthirdm.setBounds(415, 218, 174, 282);
		lblthirdm.setIcon(new ImageIcon(this.getClass().getResource("/images/3.png")));
		frame.getContentPane().add(lblthirdm);
		
		JLabel lblfourthm = new JLabel("");
		lblfourthm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MovieTimes mt = new MovieTimes();
                mt.frame.setVisible(true);
                frame.dispose();
			}
		});
		lblfourthm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblfourthm.setHorizontalAlignment(SwingConstants.CENTER);
		lblfourthm.setBounds(601, 218, 174, 282);
		lblfourthm.setIcon(new ImageIcon(this.getClass().getResource("/images/4.png")));
		frame.getContentPane().add(lblfourthm);
		
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
		
		JButton add_movie = new JButton("See Reservations");
		add_movie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DetailsEdit details_edit = new DetailsEdit();
				details_edit.frame.setVisible(true);
				frame.dispose();
			}
		});
		add_movie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add_movie.setBorderPainted(false);
		add_movie.setFont(new Font("Poppins", Font.BOLD, 10));
		add_movie.setForeground(new Color(17, 34, 44));
		add_movie.setBackground(new Color(246, 198, 36));
		add_movie.setBounds(859, 72, 121, 29);
		frame.getContentPane().add(add_movie);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		lblrectangle.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(lblrectangle);
		
	}
}
