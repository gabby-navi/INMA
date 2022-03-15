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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Reservations {

	JFrame frame;
	static JTable table;
	JScrollPane reservePane;
	private JButton view_deets;
	JMenu user_account;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservations window = new Reservations();
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
	public Reservations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
  	static String connectionUrl = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName = MTRS;"
			+ "username = sa;"
			+ "password = inmainmainma;"
			+ ";encrypt = true;trustServerCertificate = true;";
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_sched = new JButton("Scheduled Movies");
		btn_sched.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sched.setHorizontalAlignment(SwingConstants.LEFT);
		btn_sched.setForeground(Color.WHITE);
		btn_sched.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_sched.setFocusPainted(false);
		btn_sched.setBorderPainted(false);
		btn_sched.setBackground(new Color(247, 165, 35));
		btn_sched.setBounds(5, 79, 194, 40);
		frame.getContentPane().add(btn_sched);
		
		JButton btn_employees = new JButton("Employees");
		btn_employees.addMouseListener(new MouseAdapter() {
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
						EmployeeDetails empD = new EmployeeDetails();
						empD.user_account.setText(NameD);
						empD.frame.setVisible(true);
						frame.dispose();
					}
				}
				catch(SQLException x) {
						x.printStackTrace();
				}
			}
		});
		btn_employees.setHorizontalAlignment(SwingConstants.LEFT);
		btn_employees.setForeground(Color.WHITE);
		btn_employees.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_employees.setFocusPainted(false);
		btn_employees.setBorderPainted(false);
		btn_employees.setBackground(new Color(247, 165, 35));
		btn_employees.setBounds(5, 126, 194, 40);
		frame.getContentPane().add(btn_employees);
		
		JLabel blue_logo = new JLabel("");
		blue_logo.setIcon(new ImageIcon(AdminDash.class.getResource("/images/blue-logo.png")));
		blue_logo.setBounds(20, 18, 67, 46);
		frame.getContentPane().add(blue_logo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 206, 537);
		panel.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btn_reservations = new JButton("Reservations");
		btn_reservations.setHorizontalAlignment(SwingConstants.LEFT);
		btn_reservations.setForeground(Color.WHITE);
		btn_reservations.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_reservations.setFocusPainted(false);
		btn_reservations.setBorderPainted(false);
		btn_reservations.setBackground(new Color(246, 198, 36));
		btn_reservations.setBounds(5, 173, 194, 40);
		panel.add(btn_reservations);
		
		JLabel lbl_schedmovies = new JLabel("Reservations");
		lbl_schedmovies.setForeground(Color.WHITE);
		lbl_schedmovies.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_schedmovies.setBounds(233, 49, 230, 19);
		frame.getContentPane().add(lbl_schedmovies);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(247, 165, 35));
		menuBar.setBounds(735, 10, 263, 43);
		frame.getContentPane().add(menuBar);
		
		reservePane = new JScrollPane();
		reservePane.setFont(new Font("Poppins", Font.PLAIN, 12));
		reservePane.setBounds(233, 132, 747, 188);
		frame.getContentPane().add(reservePane);
		
		table = new JTable();
		table.setFont(new Font("Poppins", Font.PLAIN, 12));
		reservePane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "Customer No.", "Movie", "Time", "Date", "Total Price", "Employee Name"
			}
		));
		
		
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
		
		view_deets = new JButton("View Details");
//		view_deets.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int index = table.getSelectedRow();
//                TableModel model = table.getModel();
//				
//				if (index == -1) {
//					JOptionPane.showMessageDialog(null, "No Row Selected");
//				}
//				else {					  
//					try {
//						String movie_title = model.getValueAt(index, 0).toString();
//						String cinemaNum = model.getValueAt(index, 1).toString();
//						String showtime = model.getValueAt(index, 2).toString();
//						java.util.Date start_date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index, 3));
//						java.util.Date end_date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index, 4));
//		                String price = model.getValueAt(index, 5).toString();
//		                
//		                ao.frame.setVisible(true);
//		                ao.user_account.setText("Admin");
//		                frame.dispose();
//		                
//		                ao.cinemaN.setSelectedItem(cinemaNum);
//						ao.times.setSelectedItem(showtime);
//		                ao.textField_title.setText(movie_title);
//		                ao.startDate.setDate(start_date);
//		                ao.endDate.setDate(end_date);
//		                ao.textField_price.setText(price);
//		                
//					} catch (ParseException e1) {
//						e1.printStackTrace();
//					}  
//				}
//				
//				String selected = model.getValueAt(index, 0).toString();
//				
//				String sqlQuery = "SELECT * FROM SchedMovies\r\n"
//						+ "JOIN Cinemas ON SchedMovies.MovieID = Cinemas.MovieID WHERE MovieTitle='" + selected + "'";
//				
//				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
//					
//					PreparedStatement ps = connection.prepareStatement(sqlQuery);
//					ResultSet rs = ps.executeQuery();
//					
//					if (rs.next()) {
//						
//						String moviedesc = rs.getString("MovieDesc");
//						ao.txt_area.setText(moviedesc);
//						
//						byte[] imagedata = rs.getBytes("MovieImg");
//						ImageIcon format = new ImageIcon(imagedata);
//						Image image = format.getImage();
//						Image imageSize = image.getScaledInstance(AdminOverview.lblposter.getWidth(),AdminOverview.lblposter.getHeight(),Image.SCALE_SMOOTH);
//						ImageIcon img = new ImageIcon(imageSize);
//						
//						AdminOverview.lblposter.setIcon(img);
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "No Data");
//					}
//					
//				} 
//				catch (SQLException ex) {
//					ex.printStackTrace();
//				}
//				
//			}
//		});
		view_deets.setForeground(new Color(17, 34, 44));
		view_deets.setFont(new Font("Poppins", Font.BOLD, 10));
		view_deets.setBorderPainted(false);
		view_deets.setBackground(new Color(246, 198, 36));
		view_deets.setBounds(859, 486, 121, 29);
		frame.getContentPane().add(view_deets);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
	}

}
