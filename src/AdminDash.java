import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class AdminDash {

	JFrame frame;
	static JTable table;
	JScrollPane moviePane, scrollPane;
	JMenu user_account;
	private JButton view_deetsSM;


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
		updateDBMovies();
		updateDBEmps();
	}
	
	AdminOverview ao = new AdminOverview();
	EmployeeDeetsOverview edo = new EmployeeDeetsOverview();
	
	public static void updateDBMovies() {
		
		int q, i;
		
		try (Connection connection = DriverManager.getConnection(connectionUrl);) {
			
			String sqlQuery = "SELECT * FROM Cinemas";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData StData = rs.getMetaData();
			
			q = StData.getColumnCount();
			
			DefaultTableModel RecordTable = (DefaultTableModel)table.getModel();
			RecordTable.setRowCount(0);
			
			while(rs.next()) {
				Vector columnData = new Vector();
				
				for (i = 1; i <= q; i++) {
					columnData.add(rs.getString("MovieTitle"));
					columnData.add(rs.getString("CinemaNo"));
					columnData.add(rs.getString("ShowTime"));
					columnData.add(rs.getString("StartDate"));
					columnData.add(rs.getString("EndDate"));
					columnData.add(rs.getString("Price"));
				}
				
				RecordTable.addRow(columnData);
			}
			
		}
		catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
	}
	
	public static void updateDBEmps() {
		
		int q, i;
		
		try (Connection connection = DriverManager.getConnection(connectionUrl);) {
			
			String sqlQuery = "SELECT * FROM EmpAccounts";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData StData = rs.getMetaData();
			
			q = StData.getColumnCount();
			
			DefaultTableModel RecordTable = (DefaultTableModel)table.getModel();
			RecordTable.setRowCount(0);
			
			while(rs.next()) {
				Vector columnData = new Vector();
				
				for (i = 1; i <= q; i++) {
					columnData.add(rs.getString("EmpID"));
					columnData.add(rs.getString("EmpName"));
					columnData.add(rs.getString("EmpContactNo"));
					columnData.add(rs.getString("EmpEmail"));
					columnData.add(rs.getString("EmpPassword"));
				}
				
				RecordTable.addRow(columnData);
			}
			
		}
		catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
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
		btn_sched.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchedMovies sm = new SchedMovies();
				sm.user_account.setText("Admin");
                sm.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_sched.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sched.setHorizontalAlignment(SwingConstants.LEFT);
		btn_sched.setForeground(Color.WHITE);
		btn_sched.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_sched.setFocusPainted(false);
		btn_sched.setBorderPainted(false);
		btn_sched.setBackground(new Color(247, 165, 35));
		btn_sched.setBounds(5, 126, 194, 40);
		frame.getContentPane().add(btn_sched);
		
		JButton btn_employees = new JButton("Employees");
		btn_employees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeDetails empD = new EmployeeDetails();
				empD.user_account.setText("Admin");
				empD.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_employees.setHorizontalAlignment(SwingConstants.LEFT);
		btn_employees.setForeground(Color.WHITE);
		btn_employees.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_employees.setFocusPainted(false);
		btn_employees.setBorderPainted(false);
		btn_employees.setBackground(new Color(247, 165, 35));
		btn_employees.setBounds(5, 173, 194, 40);
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
		
		JLabel lbl_dash = new JLabel("Dashboard");
		lbl_dash.setForeground(Color.WHITE);
		lbl_dash.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_dash.setBounds(233, 49, 159, 19);
		frame.getContentPane().add(lbl_dash);
		
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
		
		JLabel lbl_schedmovies = new JLabel("Scheduled Movies");
		lbl_schedmovies.setForeground(Color.WHITE);
		lbl_schedmovies.setFont(new Font("Poppins", Font.BOLD, 16));
		lbl_schedmovies.setBounds(235, 103, 159, 14);
		frame.getContentPane().add(lbl_schedmovies);
		
		view_deetsSM = new JButton("View Details");
		view_deetsSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
                TableModel model = table.getModel();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No Row Selected");
				}
				else {					
					try {
						String movie_title = model.getValueAt(index, 0).toString();
						String cinemaNum = model.getValueAt(index, 1).toString();
						String showtime = model.getValueAt(index, 2).toString();
						java.util.Date start_date = new SimpleDateFormat("YYYY-MM-DD").parse((String)model.getValueAt(index, 3));
						java.util.Date end_date = new SimpleDateFormat("YYYY-MM-DD").parse((String)model.getValueAt(index, 4));
		                String price = model.getValueAt(index, 5).toString();
		                
		                ao.frame.setVisible(true);
		                frame.dispose();
		                
		                ao.cinemaN.setSelectedItem(cinemaNum);
						ao.times.setSelectedItem(showtime);
		                ao.textField_title.setText(movie_title);
		                ao.startDate.setDate(start_date);
		                ao.endDate.setDate(end_date);
		                ao.textField_price.setText(price);
		                
					} catch (ParseException e1) {
						e1.printStackTrace();
					} 
				}
				
				String selected = model.getValueAt(index, 0).toString();
				
				String sqlQuery = "SELECT * FROM Cinemas WHERE MovieTitle='" + selected + "'";
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
					
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						
						String moviedesc = rs.getString("MovieDesc");
						ao.txt_area.setText(moviedesc);
						
						byte[] imagedata = rs.getBytes("MovieImg");
						ImageIcon format = new ImageIcon(imagedata);
						Image image = format.getImage();
						Image imageSize = image.getScaledInstance(AdminOverview.lblposter.getWidth(),AdminOverview.lblposter.getHeight(),Image.SCALE_SMOOTH);
						ImageIcon img = new ImageIcon(imageSize);
						
						AdminOverview.lblposter.setIcon(img);
					}
					else {
						JOptionPane.showMessageDialog(null, "No Data");
					}
					
				} 
				catch (SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		view_deetsSM.setForeground(new Color(17, 34, 44));
		view_deetsSM.setFont(new Font("Poppins", Font.BOLD, 10));
		view_deetsSM.setBorderPainted(false);
		view_deetsSM.setBackground(new Color(246, 198, 36));
		view_deetsSM.setBounds(859, 90, 121, 29);
		frame.getContentPane().add(view_deetsSM);
		
		moviePane = new JScrollPane();
		moviePane .setFont(new Font("Poppins", Font.PLAIN, 12));
		moviePane .setBounds(233, 126, 747, 170);
		frame.getContentPane().add(moviePane );
		
		table = new JTable();
		table.setFont(new Font("Poppins", Font.PLAIN, 12));
		moviePane .setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "Movie", "Cinema Number", "Time", "Start Date", "End Date", "Price"
			}
		));
		
		JLabel lbl_reservations = new JLabel("Employees");
		lbl_reservations.setForeground(Color.WHITE);
		lbl_reservations.setFont(new Font("Poppins", Font.BOLD, 16));
		lbl_reservations.setBounds(235, 316, 159, 14);
		frame.getContentPane().add(lbl_reservations);
		
		JButton view_deetsR = new JButton("View Details");
		view_deetsR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
                TableModel model = table.getModel();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No Row Selected");
				}
				else {					
					
	                String id = model.getValueAt(index, 0).toString();
	                String name = model.getValueAt(index, 1).toString();
	                String contact = model.getValueAt(index, 2).toString();
	                String email = model.getValueAt(index, 3).toString();
	                String password = model.getValueAt(index, 4).toString();
	                
	                edo.frame.setVisible(true);
	                edo.user_account.setText("Admin");
	                frame.dispose();
	                
	                edo.textFieldID.setText(id);
	                edo.textFieldName.setText(name);
	                edo.textFieldNum.setText(contact);
	                edo.textFieldEmail.setText(email);
	                edo.textFieldPass.setText(password);
	                edo.lbl_employee.setText(name);
				}
				
				
				String selected = model.getValueAt(index, 0).toString();
				
				String sqlQuery = "SELECT * FROM EmpAccounts WHERE EmpID='" + selected + "'";
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
					
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						byte[] imagedata = rs.getBytes("EmpImg");
						ImageIcon format = new ImageIcon(imagedata);
						Image image = format.getImage();
						Image imageSize = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
						ImageIcon img = new ImageIcon(imageSize);
						
						EmployeeDeetsOverview.emp_profpic.setIcon(img);
					}
					else {
						JOptionPane.showMessageDialog(null, "No Data");
					}
					
				} 
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		view_deetsR.setForeground(new Color(17, 34, 44));
		view_deetsR.setFont(new Font("Poppins", Font.BOLD, 10));
		view_deetsR.setBorderPainted(false);
		view_deetsR.setBackground(new Color(246, 198, 36));
		view_deetsR.setBounds(859, 307, 121, 29);
		frame.getContentPane().add(view_deetsR);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPane.setBounds(233, 345, 747, 170);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Employee Name", "Contact No.", "Email", "Password"
			}
		));
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
		
	}
}
