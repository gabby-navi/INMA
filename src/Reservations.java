import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

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

import net.proteanit.sql.DbUtils;

public class Reservations {

	JFrame frame;
	static JTable tableR;
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
		updateDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	ViewReservations vr = new ViewReservations();
	
	public static void updateDB() {
		
		int q, i;
		
		try (Connection connection = DriverManager.getConnection(connectionUrl);) {
			
			String sqlQuery = "SELECT * FROM Reservations\r\n"
					+ "JOIN SchedMovies ON SchedMovies.MovieID = Reservations.MovieID\r\n"
					+ "JOIN EmpAccounts ON Reservations.EmpID = EmpAccounts.EmpID";
			
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData StData = rs.getMetaData();
			
			q = StData.getColumnCount();
			
			DefaultTableModel RecordTable = (DefaultTableModel)tableR.getModel();
			RecordTable.setRowCount(0);
			
			while(rs.next()) {
				Vector columnData = new Vector();
				
				for (i = 1; i <= q; i++) {
					columnData.add(rs.getString("CustomerNo"));
					columnData.add(rs.getString("MovieTitle"));
					columnData.add(rs.getString("TimeNDate"));
					columnData.add(rs.getString("Price"));
					columnData.add(rs.getString("EmpName"));
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
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		blue_logo.setIcon(new ImageIcon(Reservations.class.getResource("/images/blue-logo.png")));
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
		
		tableR = new JTable();
		tableR.setFont(new Font("Poppins", Font.PLAIN, 12));
		reservePane.setViewportView(tableR);
		tableR.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "Customer No.", "Movie", "Date", "Total Price", "Employee Name"
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
		view_deets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tableR.getSelectedRow();
                TableModel model = tableR.getModel();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No Row Selected");
				}
				else {					  
					String customerN = model.getValueAt(index, 0).toString();
					String movie_title = model.getValueAt(index, 1).toString();
					String date = model.getValueAt(index, 2).toString();
					String price = model.getValueAt(index, 3).toString();
					String empName = model.getValueAt(index, 4).toString();
					
					vr.frame.setVisible(true);
					vr.user_account.setText("Admin");
					frame.dispose();
					
					vr.custno.setText(customerN);
					vr.lbl_addNew.setText(customerN);
					vr.movietitle.setText(movie_title);
					vr.dnt.setText(date);
					vr.tprice.setText(price);
					vr.empN.setText(empName);  
				}
				
				String selected = model.getValueAt(index, 0).toString();
				
				String sqlQuery = "SELECT * FROM Reservations\r\n"
						+ "JOIN SchedMovies ON SchedMovies.MovieID = Reservations.MovieID\r\n"
						+ "JOIN EmpAccounts ON Reservations.EmpID = EmpAccounts.EmpID WHERE CustomerNo='" + selected + "'";
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
					
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						
						int noseats = rs.getInt("ReservedSeats");
						vr.noofseats.setText(String.valueOf(noseats));

						int empID = rs.getInt("EmpID");
						vr.empID.setText(String.valueOf(empID));
						
						double price = rs.getDouble("Price");
						vr.price.setText(String.valueOf(price));
						
						int cine = rs.getInt("CinemaNo");
						vr.cinemano.setText(String.valueOf(cine));
						
						String empN = rs.getString("EmpName");
						vr.empN.setText(empN);
						
						String time = rs.getString("ShowTime");
						vr.time.setText(time);
						
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
		view_deets.setForeground(new Color(17, 34, 44));
		view_deets.setFont(new Font("Poppins", Font.BOLD, 10));
		view_deets.setBorderPainted(false);
		view_deets.setBackground(new Color(246, 198, 36));
		view_deets.setBounds(859, 484, 121, 29);
		frame.getContentPane().add(view_deets);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
	}

}
