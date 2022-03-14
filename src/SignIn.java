import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class SignIn {

	JFrame frame;
	public static JTextField txt_email;
	private JLabel lbl_welcome;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
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
	public SignIn() {
		initialize();
	}
	
	String connectionUrl = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName = MTRS;"
			+ "username = sa;"
			+ "password = inmainmainma;"
			+ ";encrypt = true;trustServerCertificate = true;";

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("INMA Theatres");
		frame.setBounds(100, 100, 1024, 576);
		frame.getContentPane().setBackground(Color.white);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_welcome = new JLabel("WELCOME");
		lbl_welcome.setForeground(new Color(17, 34, 44));
		lbl_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_welcome.setFont(new Font("Poppins", Font.BOLD, 35));
		lbl_welcome.setBounds(571, 91, 295, 45);
		frame.getContentPane().add(lbl_welcome);
		
		JLabel lbl_email = new JLabel("EMAIL");
		lbl_email.setFont(new Font("Poppins", Font.PLAIN, 13));
		lbl_email.setBounds(510, 188, 73, 14);
		frame.getContentPane().add(lbl_email);
		
		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setFont(new Font("Poppins", Font.PLAIN, 13));
		lbl_password.setBounds(510, 274, 73, 14);
		frame.getContentPane().add(lbl_password);
		
		JLabel checker_email = new JLabel("");
		checker_email.setForeground(Color.RED);
		checker_email.setFont(new Font("Poppins", Font.PLAIN, 11));
		checker_email.setBounds(510, 245, 418, 14);
		frame.getContentPane().add(checker_email);
		
		JLabel checker_pass = new JLabel("");
		checker_pass.setFont(new Font("Poppins", Font.PLAIN, 11));
		checker_pass.setForeground(Color.RED);
		checker_pass.setBounds(510, 330, 307, 14);
		frame.getContentPane().add(checker_pass);
		
		txt_email = new JTextField();
		txt_email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				checker_email.setText("");
			}
		});
		txt_email.setBounds(510, 206, 418, 35);
		frame.getContentPane().add(txt_email);
		
		JCheckBox CBpass = new JCheckBox("");
		CBpass.setContentAreaFilled(false);
		CBpass.setOpaque(false);
		CBpass.setBounds(894, 298, 29, 23);
		Image unchecked = new ImageIcon(this.getClass().getResource("/images/unchecked.png")).getImage();
        CBpass.setIcon(new ImageIcon(unchecked));
        Image checked = new ImageIcon(this.getClass().getResource("/images/checked.png")).getImage();
        CBpass.setSelectedIcon(new ImageIcon(checked));
        CBpass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(CBpass.isSelected())
                	txt_password.setEchoChar((char)0);
                else
                	txt_password.setEchoChar('•');
            }
        });
        frame.getContentPane().add(CBpass);
		
		txt_password = new JPasswordField();
		txt_password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				checker_pass.setText("");
			}
		});
		txt_password.setOpaque(false);
		txt_password.setBounds(510, 292, 418, 35);
		frame.getContentPane().add(txt_password);
		
		JButton btn_sign = new JButton("Sign in");
		btn_sign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
					
					String email = txt_email.getText();
					String pass = txt_password.getText();
					
					String sqlQuery = "SELECT * FROM EmpAccounts WHERE EmpEmail=? and EmpPassword=?";
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					ps.setString(1, txt_email.getText());
					ps.setString(2, txt_password.getText());
					ResultSet rs = ps.executeQuery();
					
					// database variable
					String EmailD = "";
                    String PassD = "";
                    String NameD  = "";
                    String PositionD = "";
                    
                    while (rs.next()) {
                        EmailD = rs.getString("EmpEmail");
                        PassD = rs.getString("EmpPassword");
                        NameD = rs.getString("EmpName");
                        PositionD = rs.getString("Position");
                    }
                    
                    // query for position
                    String query1 = "SELECT * FROM Accounts WHERE EmpName=? and Position=?";
                    PreparedStatement ps1 = connection.prepareStatement(query1);
                    ps1.setString(1, NameD);
                    ps1.setString(2, PositionD);
                    ResultSet rs1 = ps1.executeQuery();
                    
                    if (EmailD.equals(email) && PassD.equals(pass)) {
                        if (NameD.equals("Admin") && PositionD.equals("Admin")) {
                            AdminDash ad = new AdminDash();
                            ad.user_account.setText("Admin");
                            ad.frame.setVisible(true);
                            frame.dispose();
                        }
                        else if (PositionD.equals("Employee")) {
                            EmployeeDashboard ed = new EmployeeDashboard();
                            ed.user_account.setText(NameD);
                            ed.frame.setVisible(true);
                            frame.dispose();
                        }
                    }
					else {
						JOptionPane.showMessageDialog(null, "Email or password is incorrect!", "Message Error", JOptionPane.WARNING_MESSAGE);
					}
					
	                if (txt_email.getText().equals("")) {
	                	checker_email.setText("This field cannot be empty.");
	                }
	                
	                if (txt_password.getText().equals("")) {
	                	checker_pass.setText("This field cannot be empty.");
	                }
					
				}
				catch (SQLException x) {
					x.printStackTrace();
				}
			}
		});
		btn_sign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sign.setFocusPainted(false);
		btn_sign.setBorderPainted(false);
		btn_sign.setFont(new Font("Poppins", Font.BOLD, 14));
		btn_sign.setForeground(new Color(17, 34, 44));
		btn_sign.setBackground(new Color(246, 198, 36));
		btn_sign.setBounds(645, 388, 147, 42);
		frame.getContentPane().add(btn_sign);
		
		JButton forgot_pass = new JButton("<html><u>Forgot Password?</u></html>");
		forgot_pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPass fp = new ForgotPass();
				fp.frame.setVisible(true);	
			}
		});
		forgot_pass.setFocusPainted(false);
		forgot_pass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		forgot_pass.setHorizontalAlignment(SwingConstants.TRAILING);
		forgot_pass.setFont(new Font("Poppins", Font.ITALIC, 11));
		forgot_pass.setOpaque(false);
		forgot_pass.setContentAreaFilled(false);
		forgot_pass.setBorderPainted(false);
		forgot_pass.setBounds(788, 331, 156, 23);
		frame.getContentPane().add(forgot_pass);
		
		JLabel mall_name = new JLabel("INMA Theatre");
		mall_name.setForeground(Color.WHITE);
		mall_name.setHorizontalAlignment(SwingConstants.CENTER);
		mall_name.setFont(new Font("Poppins", Font.BOLD, 28));
		mall_name.setBounds(72, 218, 262, 35);
		frame.getContentPane().add(mall_name);
		
		JLabel theatre_desc = new JLabel("Add description");
		theatre_desc.setHorizontalAlignment(SwingConstants.CENTER);
		theatre_desc.setForeground(Color.WHITE);
		theatre_desc.setFont(new Font("Poppins", Font.PLAIN, 11));
		theatre_desc.setBounds(150, 257, 95, 14);
		frame.getContentPane().add(theatre_desc);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(this.getClass().getResource("/images/itu.png")));
		logo.setBounds(103, 48, 198, 183);
		frame.getContentPane().add(logo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 34, 44));
		panel.setBounds(0, 0, 405, 289);
		frame.getContentPane().add(panel);
				
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/login.png")));
		lblNewLabel.setBounds(0, 0, 406, 537);
		frame.getContentPane().add(lblNewLabel);
				
	}
}
