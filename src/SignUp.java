

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignUp {

	private JFrame frame;
	private JTextField txt_name;
	private JTextField txt_username;
	private JLabel lbl_welcome;
	private JTextField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txt_name = new JTextField();
		txt_name.setBounds(510, 148, 418, 35);
		frame.getContentPane().add(txt_name);
		txt_name.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setBounds(510, 224, 418, 35);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		lbl_welcome = new JLabel("CREATE ACCOUNT");
		lbl_welcome.setForeground(new Color(17, 34, 44));
		lbl_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_welcome.setFont(new Font("Poppins", Font.BOLD, 35));
		lbl_welcome.setBounds(510, 43, 418, 45);
		frame.getContentPane().add(lbl_welcome);
		
		JLabel lbl_name = new JLabel("NAME");
		lbl_name.setFont(new Font("Poppins", Font.PLAIN, 13));
		lbl_name.setBounds(510, 130, 73, 14);
		frame.getContentPane().add(lbl_name);
		
		JLabel lbl_username = new JLabel("USERNAME");
		lbl_username.setFont(new Font("Poppins", Font.PLAIN, 13));
		lbl_username.setBounds(510, 206, 73, 14);
		frame.getContentPane().add(lbl_username);
		
		txt_password = new JTextField();
		txt_password.setColumns(10);
		txt_password.setBounds(510, 307, 418, 35);
		frame.getContentPane().add(txt_password);
		
		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setFont(new Font("Poppins", Font.PLAIN, 13));
		lbl_password.setBounds(510, 289, 73, 14);
		frame.getContentPane().add(lbl_password);
		
		JLabel lbl_account = new JLabel("Already have an account?");
		lbl_account.setFont(new Font("Poppins", Font.ITALIC, 12));
		lbl_account.setBounds(610, 479, 166, 14);
		frame.getContentPane().add(lbl_account);
		
		JButton btn_create = new JButton("Sign in");
		btn_create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_create.setFocusPainted(false);
		btn_create.setContentAreaFilled(false);
		btn_create.setBorderPainted(false);
		btn_create.setOpaque(false);
		btn_create.setForeground(new Color(246, 144, 0));
		btn_create.setFont(new Font("Poppins", Font.ITALIC, 12));
		btn_create.setBounds(741, 475, 111, 23);
		frame.getContentPane().add(btn_create);
		
		JButton btn_sign = new JButton("Sign up");
		btn_sign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sign.setFocusPainted(false);
		btn_sign.setBorderPainted(false);
		btn_sign.setFont(new Font("Poppins", Font.BOLD, 14));
		btn_sign.setForeground(new Color(17, 34, 44));
		btn_sign.setBackground(new Color(246, 198, 36));
		btn_sign.setBounds(645, 384, 147, 42);
		frame.getContentPane().add(btn_sign);
		
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
		logo.setIcon(new ImageIcon(SignUp.class.getResource("/images/itu.png")));
		logo.setBounds(103, 48, 198, 183);
		frame.getContentPane().add(logo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 34, 44));
		panel.setBounds(0, 0, 405, 289);
		frame.getContentPane().add(panel);
				
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(SignIn.class.getResource("/images/login.png")));
		lblNewLabel.setBounds(0, 0, 406, 537);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
