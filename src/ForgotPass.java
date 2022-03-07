import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class ForgotPass {

	JFrame frame;
	private JTextField txt_email;
	private JPasswordField txt_newpass;
	private JPasswordField txt_reppass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPass window = new ForgotPass();
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
	public ForgotPass() {
		initialize();
	}
	
	String connectionUrl = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName = ForLogin;"
			+ "username = sa;"
			+ "password = inmainmainma;"
			+ ";encrypt = true;trustServerCertificate = true;";

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 350);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setForeground(Color.BLACK);
		lbl_email.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_email.setBounds(40, 32, 350, 14);
		frame.getContentPane().add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setOpaque(false);
		txt_email.setBounds(40, 49, 350, 30);
		frame.getContentPane().add(txt_email);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try (Connection connection = DriverManager.getConnection(connectionUrl);) {
					
					String email = txt_email.getText();
					String pass = txt_newpass.getText();
					String confirm = txt_reppass.getText();
					
					if (pass.equals(confirm)) {
						String sqlQuery = "UPDATE LoginE SET Employee_Password=? WHERE Employee_Email=?";
						PreparedStatement ps = connection.prepareStatement(sqlQuery);
						ps.setString(1, txt_newpass.getText());
						ps.setString(2, txt_email.getText());
						
						ps.execute();
						
						JOptionPane.showMessageDialog(null, "Password changed.");
					}
					else {
						JOptionPane.showMessageDialog(null, "Password did not match!");
					}
					
				}
				catch (SQLException x) {
					x.printStackTrace();
				}
			}
		});
		btn_save.setBorderPainted(false);
		btn_save.setFocusPainted(false);
		btn_save.setFont(new Font("Poppins", Font.BOLD, 14));
		btn_save.setForeground(new Color(17, 34, 44));
		btn_save.setBackground(new Color(246, 198, 36));
		btn_save.setBounds(255, 245, 135, 30);
		frame.getContentPane().add(btn_save);
		
		JCheckBox CBnewpass = new JCheckBox("");
		CBnewpass.setContentAreaFilled(false);
		CBnewpass.setOpaque(false);
		CBnewpass.setBounds(361, 122, 29, 23);
		Image unchecked = new ImageIcon(this.getClass().getResource("/images/unchecked.png")).getImage();
		CBnewpass.setIcon(new ImageIcon(unchecked));
        Image checked = new ImageIcon(this.getClass().getResource("/images/checked.png")).getImage();
        CBnewpass.setSelectedIcon(new ImageIcon(checked));
        CBnewpass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(CBnewpass.isSelected())
                	txt_newpass.setEchoChar((char)0);
                else
                	txt_newpass.setEchoChar('•');
            }
        });
        frame.getContentPane().add(CBnewpass);
        
        JCheckBox CBreppass = new JCheckBox("");
        CBreppass.setContentAreaFilled(false);
        CBreppass.setOpaque(false);
        CBreppass.setBounds(361, 193, 29, 23);
		Image unchecked1 = new ImageIcon(this.getClass().getResource("/images/unchecked.png")).getImage();
		CBreppass.setIcon(new ImageIcon(unchecked1));
        Image checked1 = new ImageIcon(this.getClass().getResource("/images/checked.png")).getImage();
        CBreppass.setSelectedIcon(new ImageIcon(checked1));
        CBreppass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(CBreppass.isSelected())
                	txt_reppass.setEchoChar((char)0);
                else
                	txt_reppass.setEchoChar('•');
            }
        });
        frame.getContentPane().add(CBreppass);
		
		txt_newpass = new JPasswordField();
		txt_newpass.setOpaque(false);
		txt_newpass.setBounds(40, 118, 350, 30);
		frame.getContentPane().add(txt_newpass);
		
		JLabel lbl_newpass = new JLabel("New Password");
		lbl_newpass.setForeground(Color.BLACK);
		lbl_newpass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_newpass.setBounds(40, 101, 350, 14);
		frame.getContentPane().add(lbl_newpass);
		
		txt_reppass = new JPasswordField();
		txt_reppass.setOpaque(false);
		txt_reppass.setBounds(40, 187, 350, 30);
		frame.getContentPane().add(txt_reppass);
		
		JLabel lbl_reppass = new JLabel("Repeat Password");
		lbl_reppass.setForeground(Color.BLACK);
		lbl_reppass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_reppass.setBounds(40, 170, 350, 14);
		frame.getContentPane().add(lbl_reppass);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_cancel.setForeground(new Color(17, 34, 44));
		btn_cancel.setFont(new Font("Poppins", Font.BOLD, 14));
		btn_cancel.setFocusPainted(false);
		btn_cancel.setBorderPainted(false);
		btn_cancel.setBackground(new Color(246, 198, 36));
		btn_cancel.setBounds(40, 245, 135, 30);
		frame.getContentPane().add(btn_cancel);
		
	}
}
