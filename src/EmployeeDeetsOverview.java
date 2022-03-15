import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDeetsOverview {

	JFrame frame;
	JLabel lbl_employee;
	JTextField textFieldID;
	JTextField textFieldName;
	JTextField textFieldNum;
	JTextField textFieldEmail;
	JTextField textFieldPass;
	public static JLabel emp_profpic;
	JButton cancel_edit, remove_employee, save_edit, edit_employee, btn_upload;
	String selectedImagePath = null;
	JMenu user_account;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDeetsOverview window = new EmployeeDeetsOverview();
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
	public EmployeeDeetsOverview() {
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
		blue_logo.setIcon(new ImageIcon(AdminDash.class.getResource("/images/blue-logo.png")));
		blue_logo.setBounds(20, 18, 67, 46);
		panel.add(blue_logo);
		
		JButton btn_dash = new JButton("Dashboard");
		btn_dash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDash adminD = new AdminDash();
				adminD.user_account.setText("Admin");
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
		panel.add(btn_sched);
		
		JButton btn_reservations = new JButton("Reservations");
		btn_reservations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reservations r = new Reservations();
				r.user_account.setText("Admin");
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
		
		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeDetails empDeets = new EmployeeDetails();
                empDeets.frame.setVisible(true);
                frame.dispose();
			}
		});
		lblback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblback.setBounds(234, 37, 40, 39);
        lblback.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/back.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        frame.getContentPane().add(lblback);
        
        lbl_employee = new JLabel("");
		lbl_employee.setForeground(Color.WHITE);
		lbl_employee.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_employee.setBounds(274, 49, 451, 19);
		frame.getContentPane().add(lbl_employee);
		
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
		white_bg.setBounds(234, 97, 747, 238);
		frame.getContentPane().add(white_bg);
		white_bg.setLayout(null);
		
		btn_upload = new JButton("Change Picture");
		btn_upload.setVisible(false);
		btn_upload.setFocusPainted(false);
		btn_upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialogue = browseImageFile.showOpenDialog(null);
				
				if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					selectedImagePath = selectedImageFile.getAbsolutePath();
					JOptionPane.showMessageDialog(null, selectedImagePath);
					
					ImageIcon icon = new ImageIcon(selectedImagePath);
					Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					emp_profpic.setIcon(new ImageIcon(image));
				}
			}
		});
		btn_upload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_upload.setBorderPainted(false);
		btn_upload.setBounds(263, 200, 120, 19);
		btn_upload.setFont(new Font("Poppins", Font.BOLD, 9));
		btn_upload.setBackground(new Color(246, 198, 36));
		white_bg.add(btn_upload);
		
		emp_profpic = new JLabel("");
		emp_profpic.setHorizontalAlignment(SwingConstants.CENTER);
		emp_profpic.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/emp_prof.png")).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		emp_profpic.setBounds(10, 11, 223, 203);
		white_bg.add(emp_profpic);
		
		JLabel lbl_empName = new JLabel("Employee Name:");
		lbl_empName.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_empName.setBounds(263, 71, 116, 17);
		white_bg.add(lbl_empName);
		
		JLabel lbl_number = new JLabel("Contact Number:");
		lbl_number.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_number.setBounds(263, 102, 116, 17);
		white_bg.add(lbl_number);
		
		JLabel emp_email = new JLabel("Email:");
		emp_email.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		emp_email.setBounds(263, 135, 116, 17);
		white_bg.add(emp_email);
		
		JLabel emp_pass = new JLabel("Password:");
		emp_pass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		emp_pass.setBounds(263, 165, 112, 19);
		white_bg.add(emp_pass);
		
		JLabel lbl_empID = new JLabel("Employee ID:");
		lbl_empID.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_empID.setBounds(263, 41, 87, 17);
		white_bg.add(lbl_empID);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldID.setEditable(false);
		textFieldID.setBounds(385, 39, 312, 20);
		white_bg.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldName.setEditable(false);
		textFieldName.setColumns(10);
		textFieldName.setBounds(385, 69, 312, 20);
		white_bg.add(textFieldName);
		
		textFieldNum = new JTextField();
		textFieldNum.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldNum.setEditable(false);
		textFieldNum.setColumns(10);
		textFieldNum.setBounds(385, 100, 312, 20);
		white_bg.add(textFieldNum);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(385, 133, 312, 20);
		white_bg.add(textFieldEmail);
		
		textFieldPass = new JTextField();
		textFieldPass.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldPass.setEditable(false);
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(385, 164, 312, 20);
		white_bg.add(textFieldPass);
		
		cancel_edit = new JButton("Cancel");
		cancel_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel changes?", "WARNING", JOptionPane.YES_NO_OPTION); {
					if (input == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "No changes were made.");
					}
				}
				
				textFieldName.setEditable(false);
				textFieldNum.setEditable(false);
				textFieldEmail.setEditable(false);
				save_edit.setVisible(false);
				edit_employee.setVisible(true);
				remove_employee.setVisible(true);
				cancel_edit.setVisible(false);
				btn_upload.setVisible(false);
			}
		});
		cancel_edit.setVisible(false);
		cancel_edit.setForeground(new Color(17, 34, 44));
		cancel_edit.setFont(new Font("Poppins", Font.BOLD, 10));
		cancel_edit.setBorderPainted(false);
		cancel_edit.setBackground(new Color(246, 198, 36));
		cancel_edit.setBounds(863, 350, 121, 29);
		frame.getContentPane().add(cancel_edit);
		
		remove_employee = new JButton("Remove");
		remove_employee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)EmployeeDetails.table.getModel();
				int selectedRow = EmployeeDetails.table.getSelectedRow();
				
				String selected = model.getValueAt(selectedRow, 0).toString();
				
				String sqlQuery = "DELETE FROM EmpAccounts WHERE EmpID='" + selected + "'";
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {            
					
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					
					int deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove employee?", "WARNING", JOptionPane.YES_NO_OPTION); {
						if (deleteItem == JOptionPane.YES_OPTION) {
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null, "Deleted successfully.");
							EmployeeDetails.updateDB();
						}
					}
					
					EmployeeDetails empDeets = new EmployeeDetails();
					empDeets.frame.setVisible(true);
					frame.dispose();
				}
				
				catch(HeadlessException | SQLException ex){
		            JOptionPane.showMessageDialog(null, ex);
		        }
			}
		});
		remove_employee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		remove_employee.setBorderPainted(false);
		remove_employee.setFont(new Font("Poppins", Font.BOLD, 10));
		remove_employee.setForeground(new Color(17, 34, 44));
		remove_employee.setBackground(new Color(246, 198, 36));
		remove_employee.setBounds(863, 350, 121, 29);
		frame.getContentPane().add(remove_employee);
		
		save_edit = new JButton("Save");
		save_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)EmployeeDetails.table.getModel();
				int selectedRow = EmployeeDetails.table.getSelectedRow();
				
				String selected = model.getValueAt(selectedRow, 0).toString();
				
				String sqlQuery = "UPDATE EmpAccounts SET EmpName=?, EmpContactNo=?, EmpEmail=? WHERE EmpID='" + selected + "'";
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {            
					
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					ps.setString(1, textFieldName.getText());
					ps.setString(2, textFieldNum.getText());
					ps.setString(3, textFieldEmail.getText());
					
					ps.executeUpdate();	
			           
					JOptionPane.showMessageDialog(null, "Updated Successfully!");
					EmployeeDetails.updateDB();
					
					EmployeeDetails empDeets = new EmployeeDetails();
					empDeets.user_account.setText("Admin");
					empDeets.frame.setVisible(true);
					frame.dispose();
				}
				
				catch(HeadlessException | SQLException ex){
		            JOptionPane.showMessageDialog(null, ex);
		        }
			}
		});
		save_edit.setVisible(false);
		save_edit.setForeground(new Color(17, 34, 44));
		save_edit.setFont(new Font("Poppins", Font.BOLD, 10));
		save_edit.setBorderPainted(false);
		save_edit.setBackground(new Color(246, 198, 36));
		save_edit.setBounds(732, 350, 121, 29);
		frame.getContentPane().add(save_edit);
		
		edit_employee = new JButton("Edit");
		edit_employee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		edit_employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				textFieldName.setEditable(true);
				textFieldNum.setEditable(true);
				textFieldEmail.setEditable(true);
				save_edit.setVisible(true);
				edit_employee.setVisible(false);
				remove_employee.setVisible(false);
				cancel_edit.setVisible(true);
				btn_upload.setVisible(true);
			}
		});
		edit_employee.setForeground(new Color(17, 34, 44));
		edit_employee.setFont(new Font("Poppins", Font.BOLD, 10));
		edit_employee.setBorderPainted(false);
		edit_employee.setBackground(new Color(246, 198, 36));
		edit_employee.setBounds(732, 350, 121, 29);
		frame.getContentPane().add(edit_employee);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
		
	}
}