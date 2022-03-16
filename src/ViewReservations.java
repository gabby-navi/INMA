import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ViewReservations {

	JFrame frame;
	JMenu user_account;
	JLabel empID, noofseats, movietitle, time, custno, empN, tprice, cinemano, price, dnt, lbl_addNew;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReservations window = new ViewReservations();
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
	public ViewReservations() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 206, 537);
		panel.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel blue_logo = new JLabel("");
		blue_logo.setIcon(new ImageIcon(EmployeeNew.class.getResource("/images/blue-logo.png")));
		blue_logo.setBounds(20, 18, 67, 46);
		panel.add(blue_logo);
		
		JButton btn_sched = new JButton("Scheduled Movies");
		btn_sched.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
					
					String sqlQuery = "SELECT * FROM EmpAccounts WHERE EmpName=?";
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					ps.setString(1, user_account.getText());
					ResultSet rs = ps.executeQuery();
					
					// database variable
					String NameD  = "";
					
					while (rs.next()) {
						NameD = rs.getString("EmpName");
					}
					
					if(user_account.getText().equals(NameD)){
						SchedMovies sm = new SchedMovies();
						sm.user_account.setText(NameD);
		                sm.frame.setVisible(true);
		                frame.dispose();
					}
				}
				catch(SQLException x) {
						x.printStackTrace();
				}
			}
		});
		btn_sched.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sched.setHorizontalAlignment(SwingConstants.LEFT);
		btn_sched.setForeground(Color.WHITE);
		btn_sched.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_sched.setFocusPainted(false);
		btn_sched.setBorderPainted(false);
		btn_sched.setBackground(new Color(247, 165, 35));
		btn_sched.setBounds(5, 79, 194, 40);
		panel.add(btn_sched);
			
		JButton btn_employees = new JButton("Employees");
		btn_employees.setHorizontalAlignment(SwingConstants.LEFT);
		btn_employees.setForeground(Color.WHITE);
		btn_employees.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_employees.setFocusPainted(false);
		btn_employees.setBorderPainted(false);
		btn_employees.setBackground(new Color(247, 165, 35));
		btn_employees.setBounds(5, 126, 194, 40);
		panel.add(btn_employees);
		
		JButton btn_reservations = new JButton("Reservations");
		btn_reservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservations r = new Reservations();
				r.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_reservations.setHorizontalAlignment(SwingConstants.LEFT);
		btn_reservations.setForeground(Color.WHITE);
		btn_reservations.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_reservations.setFocusPainted(false);
		btn_reservations.setBorderPainted(false);
		btn_reservations.setBackground(new Color(246, 198, 36));
		btn_reservations.setBounds(5, 173, 194, 40);
		panel.add(btn_reservations);
		
		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
					
					String sqlQuery = "SELECT * FROM EmpAccounts WHERE EmpName=?";
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					ps.setString(1, user_account.getText());
					ResultSet rs = ps.executeQuery();
					
					// database variable
					String NameD  = "";
					
					while (rs.next()) {
						NameD = rs.getString("EmpName");
					}
					
					if(user_account.getText().equals(NameD)){
						EmployeeDetails empDeets = new EmployeeDetails();
						empDeets.user_account.setText(NameD);
		                empDeets.frame.setVisible(true);
		                frame.dispose();
					}
				}
				catch(SQLException x) {
						x.printStackTrace();
				}
			}
		});
		lblback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblback.setBounds(234, 37, 40, 39);
        lblback.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/back.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        frame.getContentPane().add(lblback);
        
        lbl_addNew = new JLabel("");
		lbl_addNew.setForeground(Color.WHITE);
		lbl_addNew.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_addNew.setBounds(274, 49, 451, 19);
		frame.getContentPane().add(lbl_addNew);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(247, 165, 35));
		menuBar.setBounds(735, 10, 263, 43);
		frame.getContentPane().add(menuBar);
		
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
		
		JPanel hr = new JPanel();
		hr.setBounds(233, 78, 747, 2);
		frame.getContentPane().add(hr);
		
		JPanel white_bg = new JPanel();
		white_bg.setBackground(Color.WHITE);
		white_bg.setBounds(234, 91, 747, 211);
		frame.getContentPane().add(white_bg);
		white_bg.setLayout(null);
		
		JLabel lbl_custno = new JLabel("Customer No.");
		lbl_custno.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_custno.setBounds(37, 26, 112, 17);
		white_bg.add(lbl_custno);
		
		JLabel lbl_movie = new JLabel("Movie");
		lbl_movie.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_movie.setBounds(37, 57, 116, 17);
		white_bg.add(lbl_movie);
		
		JLabel lbl_time = new JLabel("Time");
		lbl_time.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_time.setBounds(37, 90, 116, 17);
		white_bg.add(lbl_time);
		
		JLabel lbl_empID = new JLabel("Employee ID");
		lbl_empID.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_empID.setBounds(37, 153, 116, 17);
		white_bg.add(lbl_empID);
		
		JLabel lbl_custno_1 = new JLabel("No. of Seats");
		lbl_custno_1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_custno_1.setBounds(37, 123, 112, 17);
		white_bg.add(lbl_custno_1);
		
		empID = new JLabel("");
		empID.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		empID.setBounds(147, 153, 184, 17);
		white_bg.add(empID);
		
		noofseats = new JLabel("");
		noofseats.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		noofseats.setBounds(147, 123, 184, 17);
		white_bg.add(noofseats);
		
		time = new JLabel("");
		time.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		time.setBounds(147, 90, 184, 17);
		white_bg.add(time);
		
		movietitle = new JLabel("");
		movietitle.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		movietitle.setBounds(147, 57, 184, 17);
		white_bg.add(movietitle);
		
		custno = new JLabel("");
		custno.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		custno.setBounds(147, 26, 184, 17);
		white_bg.add(custno);
		
		empN = new JLabel("");
		empN.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		empN.setBounds(541, 153, 178, 17);
		white_bg.add(empN);
		
		JLabel lbl_empN = new JLabel("Employee Name");
		lbl_empN.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_empN.setBounds(341, 153, 116, 17);
		white_bg.add(lbl_empN);
		
		JLabel lbl_tprice = new JLabel("Total Price");
		lbl_tprice.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_tprice.setBounds(341, 123, 112, 17);
		white_bg.add(lbl_tprice);
		
		tprice = new JLabel("");
		tprice.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		tprice.setBounds(541, 123, 178, 17);
		white_bg.add(tprice);
		
		JLabel lbl_cn = new JLabel("Cinema No.");
		lbl_cn.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_cn.setBounds(341, 90, 116, 17);
		white_bg.add(lbl_cn);
		
		cinemano = new JLabel("");
		cinemano.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		cinemano.setBounds(541, 90, 178, 17);
		white_bg.add(cinemano);
		
		JLabel lbl_price = new JLabel("Price");
		lbl_price.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_price.setBounds(341, 57, 116, 17);
		white_bg.add(lbl_price);
		
		price = new JLabel("");
		price.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		price.setBounds(541, 57, 178, 17);
		white_bg.add(price);
		
		JLabel lbl_dnt = new JLabel("Date and Time of Reservation");
		lbl_dnt.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_dnt.setBounds(341, 26, 190, 17);
		white_bg.add(lbl_dnt);
		
		dnt = new JLabel("");
		dnt.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		dnt.setBounds(541, 26, 178, 17);
		white_bg.add(dnt);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
	}

}
