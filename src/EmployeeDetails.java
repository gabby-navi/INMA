import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EmployeeDetails {

	JFrame frame;
	private static JTable table;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldNumber;
	private JTextField textFieldEmail;
	private JTextField textFieldPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDetails window = new EmployeeDetails();
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
	
	public EmployeeDetails() {
		initialize();
		updateDB();
	}
	
//	EmployeeDeetsOverview showDetails = new EmployeeDeetsOverview();
	
	public static void updateDB() {
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 206, 537);
		panel.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel blue_logo = new JLabel("");
		blue_logo.setIcon(new ImageIcon(AdminDash.class.getResource("/images/blue-logo.png")));
		blue_logo.setBounds(20, 18, 67, 46);
		panel.add(blue_logo);
		
		JButton btn_dash = new JButton("Dashboard");
		btn_dash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDash adminD = new AdminDash();
				adminD.frame.setVisible(true);
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
		panel.add(btn_dash);
		
		JButton btn_sched = new JButton("Scheduled Movies");
		btn_sched.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SchedMovies sm = new SchedMovies();
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
		panel.add(btn_sched);
		
		JButton btn_reservations = new JButton("Reservations");
		btn_reservations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Reservations r = new Reservations();
                r.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_reservations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reservations.setHorizontalAlignment(SwingConstants.LEFT);
		btn_reservations.setForeground(Color.WHITE);
		btn_reservations.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_reservations.setFocusPainted(false);
		btn_reservations.setBorderPainted(false);
		btn_reservations.setBackground(new Color(247, 165, 35));
		btn_reservations.setBounds(5, 173, 194, 40);
		panel.add(btn_reservations);
			
		JButton btn_employees = new JButton("Employees");
		btn_employees.setHorizontalAlignment(SwingConstants.LEFT);
		btn_employees.setForeground(Color.WHITE);
		btn_employees.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_employees.setFocusPainted(false);
		btn_employees.setBorderPainted(false);
		btn_employees.setBackground(new Color(246, 198, 36));
		btn_employees.setBounds(5, 217, 194, 40);
		panel.add(btn_employees);
		
		JLabel lbl_employees = new JLabel("Employees");
		lbl_employees.setForeground(Color.WHITE);
		lbl_employees.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_employees.setBounds(233, 49, 230, 19);
		frame.getContentPane().add(lbl_employees);
		
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
		
		JButton add_employee = new JButton("Add Employee");
		add_employee.setFocusPainted(false);
		add_employee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeNew empNew = new EmployeeNew();
				empNew.frame.setVisible(true);
				frame.dispose();
			}
		});
		add_employee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add_employee.setBorderPainted(false);
		add_employee.setFont(new Font("Poppins", Font.BOLD, 10));
		add_employee.setForeground(new Color(17, 34, 44));
		add_employee.setBackground(new Color(246, 198, 36));
		add_employee.setBounds(859, 90, 121, 29);
		frame.getContentPane().add(add_employee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(233, 132, 747, 188);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				DefaultTableModel RecordTable = (DefaultTableModel)table.getModel();
//				int SelectedRow = table.getSelectedRow();
//				
//				showDetails.lbl_ID1.setText(RecordTable.getValueAt(SelectedRow, 0).toString());
//				showDetails.lbl_name.setText(RecordTable.getValueAt(SelectedRow, 1).toString());
//				showDetails.lbl_num1.setText(RecordTable.getValueAt(SelectedRow, 2).toString());
//				showDetails.lbl_email1.setText(RecordTable.getValueAt(SelectedRow, 3).toString());
//				showDetails.lbl_pass1.setText(RecordTable.getValueAt(SelectedRow, 4).toString());
//				
//				EmployeeDeetsOverview empO = new EmployeeDeetsOverview();
//				empO.frame.setVisible(true);
//				frame.dispose();
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Employee Name", "Contact No.", "Email", "Password"
			}
		));
		
		JButton remove = new JButton("Remove");
		remove.setFocusPainted(false);
		remove.setForeground(new Color(17, 34, 44));
		remove.setFont(new Font("Poppins", Font.BOLD, 10));
		remove.setBorderPainted(false);
		remove.setBackground(new Color(246, 198, 36));
		remove.setBounds(859, 486, 121, 29);
		frame.getContentPane().add(remove);
		
		JButton view_deets = new JButton("View Details");
		view_deets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel RecordTable = (DefaultTableModel)table.getModel();
				int selectedRow = table.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "No Row Selected");
				}
				else {				
//					String ID = RecordTable.getValueAt(selectedRow, 0).toString();
//					String name = RecordTable.getValueAt(selectedRow, 1).toString();
//					String number = RecordTable.getValueAt(selectedRow, 2).toString();
//					String email = RecordTable.getValueAt(selectedRow, 3).toString();
//					String password = RecordTable.getValueAt(selectedRow, 4).toString();
//					
//					showDetails.lbl_ID1.setText(RecordTable.getValueAt(selectedRow, 0).toString());
//					showDetails.lbl_name.setText(name);
//					showDetails.lbl_num1.setText(number);
//					showDetails.lbl_email1.setText(email);
//					showDetails.lbl_pass1.setText(password);
//					
					textFieldID.setText(RecordTable.getValueAt(selectedRow, 0).toString());
					textFieldName.setText(RecordTable.getValueAt(selectedRow, 1).toString());
					textFieldNumber.setText(RecordTable.getValueAt(selectedRow, 2).toString());
					textFieldEmail.setText(RecordTable.getValueAt(selectedRow, 3).toString());
					textFieldPass.setText(RecordTable.getValueAt(selectedRow, 4).toString());
					
					String ID = textFieldID.getText();
					String name = textFieldName.getText();
					String number = textFieldNumber.getText();
					String email = textFieldEmail.getText();
					String password = textFieldPass.getText();
					
					EmployeeDeetsOverview empDeetsO = new EmployeeDeetsOverview();
					empDeetsO.lbl_ID1.setText(ID);
					empDeetsO.lbl_name.setText(name);
					empDeetsO.lbl_num1.setText(number);
					empDeetsO.lbl_email1.setText(email);
					empDeetsO.lbl_pass1.setText(password);
	                empDeetsO.frame.setVisible(true);
	                frame.dispose();
					
				}
			}
		});
		view_deets.setFocusPainted(false);
		view_deets.setForeground(new Color(17, 34, 44));
		view_deets.setFont(new Font("Poppins", Font.BOLD, 10));
		view_deets.setBorderPainted(false);
		view_deets.setBackground(new Color(246, 198, 36));
		view_deets.setBounds(728, 486, 121, 29);
		frame.getContentPane().add(view_deets);
		
		textFieldID = new JTextField();
		textFieldID.setVisible(false);
		textFieldID.setBounds(233, 331, 86, 20);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setVisible(false);
		textFieldName.setColumns(10);
		textFieldName.setBounds(329, 331, 86, 20);
		frame.getContentPane().add(textFieldName);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setVisible(false);
		textFieldNumber.setColumns(10);
		textFieldNumber.setBounds(425, 331, 86, 20);
		frame.getContentPane().add(textFieldNumber);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setVisible(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(521, 331, 86, 20);
		frame.getContentPane().add(textFieldEmail);
		
		textFieldPass = new JTextField();
		textFieldPass.setVisible(false);
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(617, 331, 86, 20);
		frame.getContentPane().add(textFieldPass);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
		
	}
}