import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SignIn {

	private JFrame frame;
	private JTextField txt_username;
	private JTextField txt_password;
	private JLabel lbl_welcome;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.getContentPane().setBackground(Color.white);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_username = new JTextField();
		txt_username.setBounds(510, 179, 418, 35);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setBounds(510, 265, 418, 35);
		frame.getContentPane().add(txt_password);
		txt_password.setColumns(10);
		
		lbl_welcome = new JLabel("WELCOME");
		lbl_welcome.setForeground(new Color(17, 34, 44));
		lbl_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_welcome.setFont(new Font("Poppins", Font.BOLD, 35));
		lbl_welcome.setBounds(571, 64, 295, 45);
		frame.getContentPane().add(lbl_welcome);
		
		JLabel lbl_username = new JLabel("USERNAME");
		lbl_username.setFont(new Font("Poppins", Font.PLAIN, 13));
		lbl_username.setBounds(510, 161, 73, 14);
		frame.getContentPane().add(lbl_username);
		
		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setFont(new Font("Poppins", Font.PLAIN, 13));
		lbl_password.setBounds(510, 247, 73, 14);
		frame.getContentPane().add(lbl_password);
		
		JLabel lbl_account = new JLabel("Don't have an account?");
		lbl_account.setFont(new Font("Poppins", Font.ITALIC, 12));
		lbl_account.setBounds(607, 463, 147, 14);
		frame.getContentPane().add(lbl_account);
		
		JButton btn_create = new JButton("Create one!");
		btn_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_create.setFocusPainted(false);
		btn_create.setContentAreaFilled(false);
		btn_create.setBorderPainted(false);
		btn_create.setOpaque(false);
		btn_create.setForeground(new Color(246, 144, 0));
		btn_create.setFont(new Font("Poppins", Font.ITALIC, 12));
		btn_create.setBounds(736, 459, 111, 23);
		frame.getContentPane().add(btn_create);
		
		JButton btn_sign = new JButton("Sign in");
		btn_sign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sign.setFocusPainted(false);
		btn_sign.setBorderPainted(false);
		btn_sign.setFont(new Font("Poppins", Font.BOLD, 14));
		btn_sign.setForeground(new Color(17, 34, 44));
		btn_sign.setBackground(new Color(246, 198, 36));
		btn_sign.setBounds(645, 361, 147, 42);
		frame.getContentPane().add(btn_sign);
		
		JButton forgot_pass = new JButton("<html><u>Forgot Password?</u></html>");
		forgot_pass.setFocusPainted(false);
		forgot_pass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		forgot_pass.setHorizontalAlignment(SwingConstants.TRAILING);
		forgot_pass.setFont(new Font("Poppins", Font.ITALIC, 11));
		forgot_pass.setOpaque(false);
		forgot_pass.setContentAreaFilled(false);
		forgot_pass.setBorderPainted(false);
		forgot_pass.setBounds(788, 304, 156, 23);
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
