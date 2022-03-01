import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmployeeNew {

	private JFrame frame;
	private JTextField txt_empName;
	private JTextField txt_number;
	private JTextField txt_email;
	private JTextField txt_pass;
	private JTextField txt_confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeNew window = new EmployeeNew();
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
	public EmployeeNew() {
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
		
		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SchedMovies sm = new SchedMovies();
                sm.frame.setVisible(true);
                frame.dispose();
			}
		});
		lblback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblback.setBounds(234, 37, 40, 39);
        lblback.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/back.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        frame.getContentPane().add(lblback);
        
        JLabel lbl_addNew = new JLabel("Add New Employee");
		lbl_addNew.setForeground(Color.WHITE);
		lbl_addNew.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_addNew.setBounds(274, 49, 255, 19);
		frame.getContentPane().add(lbl_addNew);
		
		JButton user_account = new JButton("Admin");
		user_account.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		user_account.setBorderPainted(false);
		user_account.setHorizontalAlignment(SwingConstants.TRAILING);
		user_account.setOpaque(false);
		user_account.setContentAreaFilled(false);
		user_account.setFocusPainted(false);
		user_account.setForeground(Color.WHITE);
		user_account.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		user_account.setBounds(905, 17, 79, 32);
		frame.getContentPane().add(user_account);
		
		JLabel user_profpic = new JLabel("");
		user_profpic.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		user_profpic.setHorizontalAlignment(SwingConstants.CENTER);
		user_profpic.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/user-account.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		user_profpic.setBounds(859, 10, 63, 43);
		frame.getContentPane().add(user_profpic);
		
		JPanel hr = new JPanel();
		hr.setBounds(233, 78, 747, 2);
		frame.getContentPane().add(hr);
		
		JButton save_btn = new JButton("Save");
		save_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DetailsEdit details_edit = new DetailsEdit();
				details_edit.frame.setVisible(true);
				frame.dispose();
			}
		});
		save_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		save_btn.setBorderPainted(false);
		save_btn.setFont(new Font("Poppins", Font.BOLD, 10));
		save_btn.setForeground(new Color(17, 34, 44));
		save_btn.setBackground(new Color(246, 198, 36));
		save_btn.setBounds(861, 91, 121, 29);
		frame.getContentPane().add(save_btn);
		
		JPanel white_bg = new JPanel();
		white_bg.setBackground(Color.WHITE);
		white_bg.setBounds(234, 131, 747, 225);
		frame.getContentPane().add(white_bg);
		white_bg.setLayout(null);
		
		JLabel emp_name = new JLabel("");
		emp_name.setHorizontalAlignment(SwingConstants.CENTER);
		emp_name.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/emp_prof.png")).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		emp_name.setBounds(10, 11, 213, 170);
		white_bg.add(emp_name);
		
		JButton btn_change = new JButton("Change");
		btn_change.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_change.setBorderPainted(false);
		btn_change.setBounds(123, 184, 72, 19);
		btn_change.setFont(new Font("Poppins", Font.BOLD, 9));
		btn_change.setBackground(new Color(246, 198, 36));
		white_bg.add(btn_change);
		
		JButton btn_upload = new JButton("Upload");
		btn_upload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_upload.setBorderPainted(false);
		btn_upload.setBounds(40, 184, 72, 19);
		btn_upload.setFont(new Font("Poppins", Font.BOLD, 9));
		btn_upload.setBackground(new Color(246, 198, 36));
		white_bg.add(btn_upload);
		
		JLabel lbl_empName = new JLabel("Employee Name:");
		lbl_empName.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_empName.setBounds(258, 43, 112, 17);
		white_bg.add(lbl_empName);
		
		JLabel lbl_number = new JLabel("Contact Number:");
		lbl_number.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl_number.setBounds(258, 74, 116, 17);
		white_bg.add(lbl_number);
		
		JLabel emp_email = new JLabel("Email:");
		emp_email.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		emp_email.setBounds(258, 107, 116, 17);
		white_bg.add(emp_email);
		
		JLabel emp_pass = new JLabel("Password:");
		emp_pass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		emp_pass.setBounds(258, 137, 112, 19);
		white_bg.add(emp_pass);
		
		JLabel emp_confirmpass = new JLabel("Confirm Password:");
		emp_confirmpass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		emp_confirmpass.setBounds(258, 167, 131, 19);
		white_bg.add(emp_confirmpass);
		
		txt_empName = new JTextField();
		txt_empName.setBounds(395, 42, 325, 20);
		white_bg.add(txt_empName);
		txt_empName.setColumns(10);
		
		txt_number = new JTextField();
		txt_number.setColumns(10);
		txt_number.setBounds(395, 73, 325, 20);
		white_bg.add(txt_number);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(395, 103, 325, 20);
		white_bg.add(txt_email);
		
		txt_pass = new JTextField();
		txt_pass.setColumns(10);
		txt_pass.setBounds(395, 134, 325, 20);
		white_bg.add(txt_pass);
		
		txt_confirmpass = new JTextField();
		txt_confirmpass.setColumns(10);
		txt_confirmpass.setBounds(395, 167, 325, 20);
		white_bg.add(txt_confirmpass);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.setForeground(new Color(17, 34, 44));
		cancel_btn.setFont(new Font("Poppins", Font.BOLD, 10));
		cancel_btn.setBorderPainted(false);
		cancel_btn.setBackground(new Color(246, 198, 36));
		cancel_btn.setBounds(730, 91, 121, 29);
		frame.getContentPane().add(cancel_btn);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(bg);
	}
}