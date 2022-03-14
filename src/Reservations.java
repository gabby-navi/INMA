import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class Reservations {

	JFrame frame;
	static JTable table;
	private JButton view_deets;

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
	
	static String connectionUrl = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName = MTRS;"
			+ "username = sa;"
			+ "password = inmainmainma;"
			+ ";encrypt = true;trustServerCertificate = true;";
	
	public static void updateDB() {
		
		int q, i;
		
		try (Connection connection = DriverManager.getConnection(connectionUrl);) {
			
			String sqlQuery = "SELECT * FROM Reservations";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData StData = rs.getMetaData();
			
			q = StData.getColumnCount();
			
			DefaultTableModel RecordTable = (DefaultTableModel)table.getModel();
			RecordTable.setRowCount(0);
			
			while(rs.next()) {
				Vector columnData = new Vector();
				
				for (i = 1; i <= q; i++) {
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
		btn_sched.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchedMovies sched_movies = new SchedMovies();
				sched_movies.frame.setVisible(true);
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
		
		JButton btn_reservations = new JButton("Reservations");
		btn_reservations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reservations.setHorizontalAlignment(SwingConstants.LEFT);
		btn_reservations.setForeground(Color.WHITE);
		btn_reservations.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_reservations.setFocusPainted(false);
		btn_reservations.setBorderPainted(false);
		btn_reservations.setBackground(new Color(246, 198, 36));
		btn_reservations.setBounds(5, 173, 194, 40);
		frame.getContentPane().add(btn_reservations);
		
		JLabel blue_logo = new JLabel("");
		blue_logo.setIcon(new ImageIcon(AdminDash.class.getResource("/images/blue-logo.png")));
		blue_logo.setBounds(20, 18, 67, 46);
		frame.getContentPane().add(blue_logo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 206, 537);
		panel.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_reservations = new JLabel("Reservations");
		lbl_reservations.setForeground(Color.WHITE);
		lbl_reservations.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_reservations.setBounds(233, 49, 230, 19);
		frame.getContentPane().add(lbl_reservations);
		
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
		
		JPanel hr = new JPanel();
		hr.setBounds(233, 78, 747, 2);
		frame.getContentPane().add(hr);
		
//		view_deets = new JButton("View Details");
//		view_deets.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int index = table.getSelectedRow();
//                TableModel model = table.getModel();
//				
//				if (index == -1) {
//					JOptionPane.showMessageDialog(null, "No Row Selected");
//				}
//				else {					
//					
//	                String id = model.getValueAt(index, 0).toString();
//	                String name = model.getValueAt(index, 1).toString();
//	                String contact = model.getValueAt(index, 2).toString();
//	                String email = model.getValueAt(index, 3).toString();
//	                String password = model.getValueAt(index, 4).toString();
	                
//	                edo.frame.setVisible(true);
//	                frame.dispose();
//	                
//	                edo.textFieldID.setText(id);
//	                edo.textFieldName.setText(name);
//	                edo.textFieldNum.setText(contact);
//	                edo.textFieldEmail.setText(email);
//	                edo.textFieldPass.setText(password);
//	                edo.lbl_employee.setText(name);
//				}
//				
//				
//				String selected = model.getValueAt(index, 0).toString();
//				
//				String sqlQuery = "SELECT * FROM Reservations WHERE EmpID='" + selected + "'";
//				
//				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
//					
//					PreparedStatement ps = connection.prepareStatement(sqlQuery);
//					ResultSet rs = ps.executeQuery();
//					
//					if (rs.next()) {
//						byte[] imagedata = rs.getBytes("EmpImg");
//						ImageIcon format = new ImageIcon(imagedata);
//						Image image = format.getImage();
//						Image imageSize = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//						ImageIcon img = new ImageIcon(imageSize);
//						
//						EmployeeDeetsOverview.emp_profpic.setIcon(img);
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "No Data");
//					}
//					
//				} 
//				catch (SQLException ex) {
//					ex.printStackTrace();
//				}
//			}
//		});
//		view_deets.setFocusPainted(false);
//		view_deets.setForeground(new Color(17, 34, 44));
//		view_deets.setFont(new Font("Poppins", Font.BOLD, 10));
//		view_deets.setBorderPainted(false);
//		view_deets.setBackground(new Color(246, 198, 36));
//		view_deets.setBounds(859, 486, 121, 29);
//		frame.getContentPane().add(view_deets);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPane.setBounds(233, 132, 747, 188);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee", "Date", "Reserved Seats", "Total"
			}
		));
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
		
	}
}
