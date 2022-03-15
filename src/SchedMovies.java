import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class SchedMovies {

	JFrame frame;
	static JTable table;
	JScrollPane moviePane;
	private JButton view_deets;
	private JButton remove_btn;
	JMenu user_account;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchedMovies window = new SchedMovies();
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
	public SchedMovies() {
		initialize();
		updateDB();
	}
	
	AdminOverview ao = new AdminOverview();
	
	
    public static void updateDB() {
		
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
		btn_dash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDash admin_dash = new AdminDash();
				admin_dash.user_account.setText("Admin");
				admin_dash.frame.setVisible(true);
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
		frame.getContentPane().add(btn_dash);
		
		JButton btn_sched = new JButton("Scheduled Movies");
		btn_sched.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sched.setHorizontalAlignment(SwingConstants.LEFT);
		btn_sched.setForeground(Color.WHITE);
		btn_sched.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_sched.setFocusPainted(false);
		btn_sched.setBorderPainted(false);
		btn_sched.setBackground(new Color(246, 198, 36));
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
		
		JLabel lbl_schedmovies = new JLabel("Scheduled Movies");
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
		
		moviePane = new JScrollPane();
		moviePane.setFont(new Font("Poppins", Font.PLAIN, 12));
		moviePane.setBounds(233, 132, 747, 188);
		frame.getContentPane().add(moviePane);
		
		table = new JTable();
		table.setFont(new Font("Poppins", Font.PLAIN, 12));
		moviePane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "Movie", "Cinema Number", "Time", "Start Date", "End Date", "Price"
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
		
		JButton add_movie = new JButton("Add Movie");
		add_movie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DetailsEdit details_edit = new DetailsEdit();
				details_edit.user_account.setText("Admin");
				details_edit.frame.setVisible(true);
				frame.dispose();
			}
		});
		add_movie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add_movie.setBorderPainted(false);
		add_movie.setFont(new Font("Poppins", Font.BOLD, 10));
		add_movie.setForeground(new Color(17, 34, 44));
		add_movie.setBackground(new Color(246, 198, 36));
		add_movie.setBounds(859, 90, 121, 29);
		frame.getContentPane().add(add_movie);
		
		view_deets = new JButton("View Details");
		view_deets.addActionListener(new ActionListener() {
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
						java.util.Date start_date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index, 3));
						java.util.Date end_date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index, 4));
		                String price = model.getValueAt(index, 5).toString();
		                
		                ao.frame.setVisible(true);
		                ao.user_account.setText("Admin");
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
		view_deets.setForeground(new Color(17, 34, 44));
		view_deets.setFont(new Font("Poppins", Font.BOLD, 10));
		view_deets.setBorderPainted(false);
		view_deets.setBackground(new Color(246, 198, 36));
		view_deets.setBounds(728, 486, 121, 29);
		frame.getContentPane().add(view_deets);
		
		remove_btn = new JButton("Remove");
		remove_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRow = table.getSelectedRow();
				
				String selected = model.getValueAt(selectedRow, 0).toString();
				
				String sqlQuery = "DELETE FROM Cinemas WHERE MovieTitle='" + selected + "'";
				String sqlQuery2 = "DELETE FROM SchedMovies WHERE MovieTitle='" + selected + "'";
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {            
					
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					PreparedStatement pst = connection.prepareStatement(sqlQuery2);
					
					int deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this movie?", "WARNING", JOptionPane.YES_NO_OPTION); {
						if (deleteItem == JOptionPane.YES_OPTION) {
							ps.executeUpdate();
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Deleted successfully.");
							updateDB();
						}
					}
					
					SchedMovies sm = new SchedMovies();
					sm.user_account.setText("Admin");
					sm.frame.setVisible(true);
					frame.dispose();
				}
				
				catch(HeadlessException | SQLException ex){
		            JOptionPane.showMessageDialog(null, ex);
		        }
			}
		});
		remove_btn.setForeground(new Color(17, 34, 44));
		remove_btn.setFont(new Font("Poppins", Font.BOLD, 10));
		remove_btn.setBorderPainted(false);
		remove_btn.setBackground(new Color(246, 198, 36));
		remove_btn.setBounds(859, 486, 121, 29);
		frame.getContentPane().add(remove_btn);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
	
	}
}
