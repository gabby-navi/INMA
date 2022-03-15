import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PickASeat {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickASeat window = new PickASeat();
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
	public PickASeat() {
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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(247, 165, 35));
		menuBar.setBounds(0, 0, 1008, 43);
		frame.getContentPane().add(menuBar);
		
		JMenu lbl_company = new JMenu("  INMA Theatre  ");
		lbl_company.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/blue-logo.png")).getImage().getScaledInstance(45, 33, Image.SCALE_DEFAULT)));
		lbl_company.setFont(new Font("Poppins Black", Font.BOLD, 16));
		lbl_company.setForeground(new Color(255, 255, 255));
		menuBar.add(lbl_company);
		
		JMenu user_account = new JMenu("   Employee   ");
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
		
		JLabel lbl2 = new JLabel("2:45PM");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.setFont(new Font("Poppins", Font.BOLD, 35));
		lbl2.setBounds(90, 72, 142, 37);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("The Adam Project");
		lbl3.setForeground(new Color(255, 255, 255));
		lbl3.setFont(new Font("Poppins", Font.BOLD, 16));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBounds(815, 60, 152, 34);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("Cinema 3");
		lbl4.setFont(new Font("Poppins SemiBold", Font.PLAIN, 16));
		lbl4.setForeground(new Color(255, 255, 255));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setBounds(881, 92, 88, 22);
		frame.getContentPane().add(lbl4);
		
		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MovieTimes movie_times = new MovieTimes();
				movie_times.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblback.setBounds(44, 71, 40, 39);
		lblback.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/back.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		frame.getContentPane().add(lblback);
		
		JPanel panelw = new JPanel();
		panelw.setBounds(46, 131, 918, 315);
		panelw.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panelw);
		panelw.setLayout(null);
		
		JLabel lbl5 = new JLabel("SCREEN");
		lbl5.setBounds(10, 5, 898, 19);
		lbl5.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		panelw.add(lbl5);
		
		JLabel lbl6 = new JLabel("Total Number of Seats:");
		lbl6.setForeground(new Color(255, 255, 255));
		lbl6.setFont(new Font("Poppins", Font.BOLD, 16));
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setBounds(46, 479, 195, 25);
		frame.getContentPane().add(lbl6);
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setBackground(new Color(246, 198, 36));
			}
		});
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setBounds(45, 60, 33, 21);
		panelw.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setBackground(new Color(246, 198, 36));
			}
		});
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setBounds(88, 60, 33, 21);
		panelw.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3.setBackground(new Color(246, 198, 36));
			}
		});
		btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn3.setBounds(131, 60, 33, 21);
		panelw.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4.setBackground(new Color(246, 198, 36));
			}
		});
		btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn4.setBounds(174, 60, 33, 21);
		panelw.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5.setBackground(new Color(246, 198, 36));
			}
		});
		btn5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn5.setBounds(217, 60, 33, 21);
		panelw.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn6.setBackground(new Color(246, 198, 36));
			}
		});
		btn6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn6.setBounds(291, 60, 33, 21);
		panelw.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn7.setBackground(new Color(246, 198, 36));
			}
		});
		btn7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn7.setBounds(334, 60, 33, 21);
		panelw.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn8.setBackground(new Color(246, 198, 36));
			}
		});
		btn8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn8.setBounds(377, 60, 33, 21);
		panelw.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn9.setBackground(new Color(246, 198, 36));
			}
		});
		btn9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn9.setBounds(418, 60, 33, 21);
		panelw.add(btn9);
		
		JButton btn10 = new JButton("");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn10.setBackground(new Color(246, 198, 36));
			}
		});
		btn10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn10.setBounds(461, 60, 33, 21);
		panelw.add(btn10);
		
		JButton btn11 = new JButton("");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn11.setBackground(new Color(246, 198, 36));
			}
		});
		btn11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn11.setBounds(504, 60, 33, 21);
		panelw.add(btn11);
		
		JButton btn12 = new JButton("");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn12.setBackground(new Color(246, 198, 36));
			}
		});
		btn12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn12.setBounds(547, 60, 33, 21);
		panelw.add(btn12);
		
		JButton btn13 = new JButton("");
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn13.setBackground(new Color(246, 198, 36));
			}
		});
		btn13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn13.setBounds(590, 60, 33, 21);
		panelw.add(btn13);
		
		JButton btn14 = new JButton("");
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn14.setBackground(new Color(246, 198, 36));
			}
		});
		btn14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn14.setBounds(663, 60, 33, 21);
		panelw.add(btn14);
		
		JButton btn15 = new JButton("");
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn15.setBackground(new Color(246, 198, 36));
			}
		});
		btn15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn15.setBounds(706, 60, 33, 21);
		panelw.add(btn15);
		
		JButton btn16 = new JButton("");
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn16.setBackground(new Color(246, 198, 36));
			}
		});
		btn16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn16.setBounds(749, 60, 33, 21);
		panelw.add(btn16);
		
		JButton btn17 = new JButton("");
		btn17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn17.setBackground(new Color(246, 198, 36));
			}
		});
		btn17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn17.setBounds(792, 60, 33, 21);
		panelw.add(btn17);
		
		JButton btn18 = new JButton("");
		btn18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn18.setBackground(new Color(246, 198, 36));
			}
		});
		btn18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn18.setBounds(835, 60, 33, 21);
		panelw.add(btn18);
		
		JButton btn19 = new JButton("");
		btn19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn19.setBackground(new Color(246, 198, 36));
			}
		});
		btn19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn19.setBounds(45, 91, 33, 21);
		panelw.add(btn19);
		
		JButton btn20 = new JButton("");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn20.setBackground(new Color(246, 198, 36));
			}
		});
		btn20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn20.setBounds(88, 91, 33, 21);
		panelw.add(btn20);
		
		JButton btn21 = new JButton("");
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn21.setBackground(new Color(246, 198, 36));
			}
		});
		btn21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn21.setBounds(131, 91, 33, 21);
		panelw.add(btn21);
		
		JButton btn22 = new JButton("");
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn22.setBackground(new Color(246, 198, 36));
			}
		});
		btn22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn22.setBounds(174, 91, 33, 21);
		panelw.add(btn22);
		
		JButton btn23 = new JButton("");
		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn23.setBackground(new Color(246, 198, 36));
			}
		});
		btn23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn23.setBounds(217, 91, 33, 21);
		panelw.add(btn23);
		
		JButton btn24 = new JButton("");
		btn24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn24.setBackground(new Color(246, 198, 36));
			}
		});
		btn24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn24.setBounds(291, 91, 33, 21);
		panelw.add(btn24);
		
		JButton btn25 = new JButton("");
		btn25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn25.setBackground(new Color(246, 198, 36));
			}
		});
		btn25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn25.setBounds(334, 91, 33, 21);
		panelw.add(btn25);
		
		JButton btn26 = new JButton("");
		btn26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn26.setBackground(new Color(246, 198, 36));
			}
		});
		btn26.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn26.setBounds(377, 91, 33, 21);
		panelw.add(btn26);
		
		JButton btn27 = new JButton("");
		btn27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn27.setBackground(new Color(246, 198, 36));
			}
		});
		btn27.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn27.setBounds(418, 91, 33, 21);
		panelw.add(btn27);
		
		JButton btn28 = new JButton("");
		btn28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn28.setBackground(new Color(246, 198, 36));
			}
		});
		btn28.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn28.setBounds(461, 91, 33, 21);
		panelw.add(btn28);
		
		JButton btn29 = new JButton("");
		btn29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn29.setBackground(new Color(246, 198, 36));
			}
		});
		btn29.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn29.setBounds(504, 91, 33, 21);
		panelw.add(btn29);
		
		JButton btn30 = new JButton("");
		btn30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn30.setBackground(new Color(246, 198, 36));
			}
		});
		btn30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn30.setBounds(547, 91, 33, 21);
		panelw.add(btn30);
		
		JButton btn31 = new JButton("");
		btn31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn31.setBackground(new Color(246, 198, 36));
			}
		});
		btn31.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn31.setBounds(590, 91, 33, 21);
		panelw.add(btn31);
		
		JButton btn32 = new JButton("");
		btn32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn32.setBackground(new Color(246, 198, 36));
			}
		});
		btn32.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn32.setBounds(663, 91, 33, 21);
		panelw.add(btn32);
		
		JButton btn33 = new JButton("");
		btn33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn33.setBackground(new Color(246, 198, 36));
			}
		});
		btn33.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn33.setBounds(706, 91, 33, 21);
		panelw.add(btn33);
		
		JButton btn34 = new JButton("");
		btn34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn34.setBackground(new Color(246, 198, 36));
			}
		});
		btn34.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn34.setBounds(749, 91, 33, 21);
		panelw.add(btn34);
		
		JButton btn35 = new JButton("");
		btn35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn35.setBackground(new Color(246, 198, 36));
			}
		});
		btn35.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn35.setBounds(792, 91, 33, 21);
		panelw.add(btn35);
		
		JButton btn36 = new JButton("");
		btn36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn36.setBackground(new Color(246, 198, 36));
			}
		});
		btn36.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn36.setBounds(835, 91, 33, 21);
		panelw.add(btn36);
		
		JButton btn37 = new JButton("");
		btn37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn37.setBackground(new Color(246, 198, 36));
			}
		});
		btn37.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn37.setBounds(45, 122, 33, 21);
		panelw.add(btn37);
		
		JButton btn38 = new JButton("");
		btn38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn38.setBackground(new Color(246, 198, 36));
			}
		});
		btn38.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn38.setBounds(88, 122, 33, 21);
		panelw.add(btn38);
		
		JButton btn39 = new JButton("");
		btn39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn39.setBackground(new Color(246, 198, 36));
			}
		});
		btn39.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn39.setBounds(131, 122, 33, 21);
		panelw.add(btn39);
		
		JButton btn40 = new JButton("");
		btn40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn40.setBackground(new Color(246, 198, 36));
			}
		});
		btn40.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn40.setBounds(174, 122, 33, 21);
		panelw.add(btn40);
		
		JButton btn41 = new JButton("");
		btn41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn41.setBackground(new Color(246, 198, 36));
			}
		});
		btn41.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn41.setBounds(217, 122, 33, 21);
		panelw.add(btn41);
		
		JButton btn42 = new JButton("");
		btn42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn42.setBackground(new Color(246, 198, 36));
			}
		});
		btn42.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn42.setBounds(291, 122, 33, 21);
		panelw.add(btn42);
		
		JButton btn43 = new JButton("");
		btn43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn43.setBackground(new Color(246, 198, 36));
			}
		});
		btn43.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn43.setBounds(334, 122, 33, 21);
		panelw.add(btn43);
		
		JButton btn44 = new JButton("");
		btn44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn44.setBackground(new Color(246, 198, 36));
			}
		});
		btn44.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn44.setBounds(377, 122, 33, 21);
		panelw.add(btn44);
		
		JButton btn45 = new JButton("");
		btn45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn45.setBackground(new Color(246, 198, 36));
			}
		});
		btn45.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn45.setBounds(418, 122, 33, 21);
		panelw.add(btn45);
		
		JButton btn46 = new JButton("");
		btn46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn46.setBackground(new Color(246, 198, 36));
			}
		});
		btn46.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn46.setBounds(461, 122, 33, 21);
		panelw.add(btn46);
		
		JButton btn47 = new JButton("");
		btn47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn47.setBackground(new Color(246, 198, 36));
			}
		});
		btn47.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn47.setBounds(504, 122, 33, 21);
		panelw.add(btn47);
		
		JButton btn48 = new JButton("");
		btn48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn48.setBackground(new Color(246, 198, 36));
			}
		});
		btn48.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn48.setBounds(547, 122, 33, 21);
		panelw.add(btn48);
		
		JButton btn49 = new JButton("");
		btn49.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn49.setBackground(new Color(246, 198, 36));
			}
		});
		btn49.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn49.setBounds(590, 122, 33, 21);
		panelw.add(btn49);
		
		JButton btn50 = new JButton("");
		btn50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn50.setBackground(new Color(246, 198, 36));
			}
		});
		btn50.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn50.setBounds(663, 122, 33, 21);
		panelw.add(btn50);
		
		JButton btn51 = new JButton("");
		btn51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn51.setBackground(new Color(246, 198, 36));
			}
		});
		btn51.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn51.setBounds(706, 122, 33, 21);
		panelw.add(btn51);
		
		JButton btn52 = new JButton("");
		btn52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn52.setBackground(new Color(246, 198, 36));
			}
		});
		btn52.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn52.setBounds(749, 122, 33, 21);
		panelw.add(btn52);
		
		JButton btn53 = new JButton("");
		btn53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn53.setBackground(new Color(246, 198, 36));
			}
		});
		btn53.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn53.setBounds(792, 122, 33, 21);
		panelw.add(btn53);
		
		JButton btn54 = new JButton("");
		btn54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn54.setBackground(new Color(246, 198, 36));
			}
		});
		btn54.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn54.setBounds(835, 122, 33, 21);
		panelw.add(btn54);
		
		JButton btn55 = new JButton("");
		btn55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn55.setBackground(new Color(246, 198, 36));
			}
		});
		btn55.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn55.setBounds(45, 153, 33, 21);
		panelw.add(btn55);
		
		JButton btn56 = new JButton("");
		btn56.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn56.setBackground(new Color(246, 198, 36));
			}
		});
		btn56.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn56.setBounds(88, 153, 33, 21);
		panelw.add(btn56);
		
		JButton btn57 = new JButton("");
		btn57.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn57.setBackground(new Color(246, 198, 36));
			}
		});
		btn57.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn57.setBounds(131, 153, 33, 21);
		panelw.add(btn57);
		
		JButton btn58 = new JButton("");
		btn58.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn58.setBackground(new Color(246, 198, 36));
			}
		});
		btn58.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn58.setBounds(174, 153, 33, 21);
		panelw.add(btn58);
		
		JButton btn59 = new JButton("");
		btn59.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn59.setBackground(new Color(246, 198, 36));
			}
		});
		btn59.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn59.setBounds(217, 153, 33, 21);
		panelw.add(btn59);
		
		JButton btn60 = new JButton("");
		btn60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn60.setBackground(new Color(246, 198, 36));
			}
		});
		btn60.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn60.setBounds(291, 153, 33, 21);
		panelw.add(btn60);
		
		JButton btn61 = new JButton("");
		btn61.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn61.setBackground(new Color(246, 198, 36));
			}
		});
		btn61.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn61.setBounds(334, 153, 33, 21);
		panelw.add(btn61);
		
		JButton btn62 = new JButton("");
		btn62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn62.setBackground(new Color(246, 198, 36));
			}
		});
		btn62.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn62.setBounds(377, 153, 33, 21);
		panelw.add(btn62);
		
		JButton btn63 = new JButton("");
		btn63.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn63.setBackground(new Color(246, 198, 36));
			}
		});
		btn63.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn63.setBounds(418, 153, 33, 21);
		panelw.add(btn63);
		
		JButton btn64 = new JButton("");
		btn64.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn64.setBackground(new Color(246, 198, 36));
			}
		});
		btn64.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn64.setBounds(461, 153, 33, 21);
		panelw.add(btn64);
		
		JButton btn65 = new JButton("");
		btn65.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn65.setBackground(new Color(246, 198, 36));
			}
		});
		btn65.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn65.setBounds(504, 153, 33, 21);
		panelw.add(btn65);
		
		JButton btn66 = new JButton("");
		btn66.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn66.setBackground(new Color(246, 198, 36));
			}
		});
		btn66.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn66.setBounds(547, 153, 33, 21);
		panelw.add(btn66);
		
		JButton btn67 = new JButton("");
		btn67.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn67.setBackground(new Color(246, 198, 36));
			}
		});
		btn67.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn67.setBounds(590, 153, 33, 21);
		panelw.add(btn67);
		
		JButton btn68 = new JButton("");
		btn68.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn68.setBackground(new Color(246, 198, 36));
			}
		});
		btn68.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn68.setBounds(663, 153, 33, 21);
		panelw.add(btn68);
		
		JButton btn69 = new JButton("");
		btn69.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn69.setBackground(new Color(246, 198, 36));
			}
		});
		btn69.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn69.setBounds(706, 153, 33, 21);
		panelw.add(btn69);
		
		JButton btn70 = new JButton("");
		btn70.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn70.setBackground(new Color(246, 198, 36));
			}
		});
		btn70.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn70.setBounds(749, 153, 33, 21);
		panelw.add(btn70);
		
		JButton btn71 = new JButton("");
		btn71.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn71.setBackground(new Color(246, 198, 36));
			}
		});
		btn71.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn71.setBounds(792, 153, 33, 21);
		panelw.add(btn71);
		
		JButton btn72 = new JButton("");
		btn72.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn72.setBackground(new Color(246, 198, 36));
			}
		});
		btn72.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn72.setBounds(835, 153, 33, 21);
		panelw.add(btn72);
		
		JButton btn73 = new JButton("");
		btn73.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn73.setBackground(new Color(246, 198, 36));
			}
		});
		btn73.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn73.setBounds(45, 184, 33, 21);
		panelw.add(btn73);
		
		JButton btn74 = new JButton("");
		btn74.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn74.setBackground(new Color(246, 198, 36));
			}
		});
		btn74.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn74.setBounds(88, 184, 33, 21);
		panelw.add(btn74);
		
		JButton btn75 = new JButton("");
		btn75.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn75.setBackground(new Color(246, 198, 36));
			}
		});
		btn75.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn75.setBounds(131, 184, 33, 21);
		panelw.add(btn75);
		
		JButton btn76 = new JButton("");
		btn76.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn76.setBackground(new Color(246, 198, 36));
			}
		});
		btn76.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn76.setBounds(174, 184, 33, 21);
		panelw.add(btn76);
		
		JButton btn77 = new JButton("");
		btn77.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn77.setBackground(new Color(246, 198, 36));
			}
		});
		btn77.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn77.setBounds(217, 184, 33, 21);
		panelw.add(btn77);
		
		JButton btn78 = new JButton("");
		btn78.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn78.setBackground(new Color(246, 198, 36));
			}
		});
		btn78.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn78.setBounds(291, 184, 33, 21);
		panelw.add(btn78);
		
		JButton btn79 = new JButton("");
		btn79.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn79.setBackground(new Color(246, 198, 36));
			}
		});
		btn79.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn79.setBounds(334, 184, 33, 21);
		panelw.add(btn79);
		
		JButton btn80 = new JButton("");
		btn80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn80.setBackground(new Color(246, 198, 36));
			}
		});
		btn80.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn80.setBounds(377, 184, 33, 21);
		panelw.add(btn80);
		
		JButton btn81 = new JButton("");
		btn81.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn81.setBackground(new Color(246, 198, 36));
			}
		});
		btn81.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn81.setBounds(418, 184, 33, 21);
		panelw.add(btn81);
		
		JButton btn82 = new JButton("");
		btn82.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn82.setBackground(new Color(246, 198, 36));
			}
		});
		btn82.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn82.setBounds(461, 184, 33, 21);
		panelw.add(btn82);
		
		JButton btn83 = new JButton("");
		btn83.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn83.setBackground(new Color(246, 198, 36));
			}
		});
		btn83.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn83.setBounds(504, 184, 33, 21);
		panelw.add(btn83);
		
		JButton btn84 = new JButton("");
		btn84.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn84.setBackground(new Color(246, 198, 36));
			}
		});
		btn84.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn84.setBounds(547, 184, 33, 21);
		panelw.add(btn84);
		
		JButton btn85 = new JButton("");
		btn85.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn85.setBackground(new Color(246, 198, 36));
			}
		});
		btn85.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn85.setBounds(590, 184, 33, 21);
		panelw.add(btn85);
		
		JButton btn86 = new JButton("");
		btn86.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn86.setBackground(new Color(246, 198, 36));
			}
		});
		btn86.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn86.setBounds(663, 184, 33, 21);
		panelw.add(btn86);
		
		JButton btn87 = new JButton("");
		btn87.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn87.setBackground(new Color(246, 198, 36));
			}
		});
		btn87.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn87.setBounds(706, 184, 33, 21);
		panelw.add(btn87);
		
		JButton btn88 = new JButton("");
		btn88.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn88.setBackground(new Color(246, 198, 36));
			}
		});
		btn88.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn88.setBounds(749, 184, 33, 21);
		panelw.add(btn88);
		
		JButton btn89 = new JButton("");
		btn89.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn89.setBackground(new Color(246, 198, 36));
			}
		});
		btn89.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn89.setBounds(792, 184, 33, 21);
		panelw.add(btn89);
		
		JButton btn90 = new JButton("");
		btn90.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn90.setBackground(new Color(246, 198, 36));
			}
		});
		btn90.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn90.setBounds(835, 184, 33, 21);
		panelw.add(btn90);
		
		JButton btn92 = new JButton("");
		btn92.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn92.setBackground(new Color(246, 198, 36));
			}
		});
		btn92.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn92.setBounds(291, 228, 33, 21);
		panelw.add(btn92);
		
		JButton btn93 = new JButton("");
		btn93.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn93.setBackground(new Color(246, 198, 36));
			}
		});
		btn93.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn93.setBounds(334, 228, 33, 21);
		panelw.add(btn93);
		
		JButton btn94 = new JButton("");
		btn94.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn94.setBackground(new Color(246, 198, 36));
			}
		});
		btn94.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn94.setBounds(377, 228, 33, 21);
		panelw.add(btn94);
		
		JButton btn95 = new JButton("");
		btn95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn95.setBackground(new Color(246, 198, 36));
			}
		});
		btn95.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn95.setBounds(418, 228, 33, 21);
		panelw.add(btn95);
		
		JButton btn96 = new JButton("");
		btn96.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn96.setBackground(new Color(246, 198, 36));
			}
		});
		btn96.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn96.setBounds(461, 228, 33, 21);
		panelw.add(btn96);
		
		JButton btn97 = new JButton("");
		btn97.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn97.setBackground(new Color(246, 198, 36));
			}
		});
		btn97.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn97.setBounds(504, 228, 33, 21);
		panelw.add(btn97);
		
		JButton btn98 = new JButton("");
		btn98.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn98.setBackground(new Color(246, 198, 36));
			}
		});
		btn98.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn98.setBounds(547, 228, 33, 21);
		panelw.add(btn98);
		
		JButton btn99 = new JButton("");
		btn99.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn99.setBackground(new Color(246, 198, 36));
			}
		});
		btn99.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn99.setBounds(590, 228, 33, 21);
		panelw.add(btn99);
		
		JButton btn100 = new JButton("");
		btn100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn100.setBackground(new Color(246, 198, 36));
			}
		});
		btn100.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn100.setBounds(633, 228, 33, 21);
		panelw.add(btn100);
		
		JButton btn91 = new JButton("");
		btn91.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn91.setBackground(new Color(246, 198, 36));
			}
		});
		btn91.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn91.setBounds(248, 228, 33, 21);
		panelw.add(btn91);
		
		JButton btn_reserve = new JButton("Reserve");
		btn_reserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DetailOverview detail_overview = new DetailOverview();
				detail_overview.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_reserve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reserve.setBorder(null);
		btn_reserve.setForeground(new Color(17, 34, 44));
		btn_reserve.setFont(new Font("Poppins", Font.BOLD, 13));
		btn_reserve.setBounds(838, 467, 129, 37);
		btn_reserve.setBackground(new Color(246, 198, 36));
		frame.getContentPane().add(btn_reserve);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		lblrectangle.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(lblrectangle);
		
	}
}
