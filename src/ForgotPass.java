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
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_email.setBounds(40, 32, 350, 14);
		frame.getContentPane().add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setBorder(new EmptyBorder(0, 0, 0, 0));
		txt_email.setBounds(40, 49, 350, 30);
		frame.getContentPane().add(txt_email);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_save.setBorderPainted(false);
		btn_save.setFocusPainted(false);
		btn_save.setFont(new Font("Poppins", Font.BOLD, 14));
		btn_save.setForeground(new Color(17, 34, 44));
		btn_save.setBackground(new Color(246, 198, 36));
		btn_save.setBounds(255, 245, 135, 30);
		frame.getContentPane().add(btn_save);
		
		txt_newpass = new JPasswordField();
		txt_newpass.setBorder(new EmptyBorder(0, 0, 0, 0));
		txt_newpass.setBounds(40, 118, 350, 30);
		frame.getContentPane().add(txt_newpass);
		
		JLabel lbl_newpass = new JLabel("New Password");
		lbl_newpass.setForeground(Color.WHITE);
		lbl_newpass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_newpass.setBounds(40, 101, 350, 14);
		frame.getContentPane().add(lbl_newpass);
		
		txt_reppass = new JPasswordField();
		txt_reppass.setBorder(new EmptyBorder(0, 0, 0, 0));
		txt_reppass.setBounds(40, 187, 350, 30);
		frame.getContentPane().add(txt_reppass);
		
		JLabel lbl_reppass = new JLabel("Repeat Password");
		lbl_reppass.setForeground(Color.WHITE);
		lbl_reppass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		lbl_reppass.setBounds(40, 170, 350, 14);
		frame.getContentPane().add(lbl_reppass);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setForeground(new Color(17, 34, 44));
		btn_cancel.setFont(new Font("Poppins", Font.BOLD, 14));
		btn_cancel.setFocusPainted(false);
		btn_cancel.setBorderPainted(false);
		btn_cancel.setBackground(new Color(246, 198, 36));
		btn_cancel.setBounds(40, 245, 135, 30);
		frame.getContentPane().add(btn_cancel);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		bg.setBounds(0, 0, 434, 311);
		frame.getContentPane().add(bg);
	}
}
