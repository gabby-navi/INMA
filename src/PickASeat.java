import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PickASeat {

	private JFrame frame;

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
	
	public static String path;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("INMA Theatre");
		lbl1.setFont(new Font("Poppins", Font.BOLD, 16));
		lbl1.setForeground(new Color(255, 255, 255));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(66, 12, 120, 25);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("2:45PM");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.setFont(new Font("Poppins", Font.BOLD, 35));
		lbl2.setBounds(99, 72, 142, 37);
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
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogo.setBounds(10, 4, 55, 37);
		path = "C:\\Users\\niel\\OneDrive\\Pictures\\mtrs-inma\\logo.png";
		ImageIcon logo = new ImageIcon(path);
        Image imgl = logo.getImage();
        Image newImage = imgl.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        lbllogo.setIcon(image); 
		frame.getContentPane().add(lbllogo);
		
		JLabel lblback = new JLabel("");
		lblback.setHorizontalAlignment(SwingConstants.CENTER);
		lblback.setBounds(44, 71, 40, 39);
		path = "C:\\Users\\niel\\OneDrive\\Pictures\\mtrs-inma\\back.png";
		ImageIcon back = new ImageIcon(path);
        Image imgb = back.getImage();
        Image newImage1 = imgb.getScaledInstance(lblback.getWidth(), lblback.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(newImage1);
        lblback.setIcon(image1); 
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
		btn1.setBounds(50, 59, 33, 21);
		panelw.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setBounds(93, 59, 33, 21);
		panelw.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setBounds(136, 59, 33, 21);
		panelw.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setBounds(179, 59, 33, 21);
		panelw.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setBounds(222, 59, 33, 21);
		panelw.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setBounds(296, 59, 33, 21);
		panelw.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setBounds(339, 59, 33, 21);
		panelw.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setBounds(382, 59, 33, 21);
		panelw.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.setBounds(423, 59, 33, 21);
		panelw.add(btn9);
		
		JButton btn10 = new JButton("");
		btn10.setBounds(466, 59, 33, 21);
		panelw.add(btn10);
		
		JButton btn11 = new JButton("");
		btn11.setBounds(509, 59, 33, 21);
		panelw.add(btn11);
		
		JButton btn12 = new JButton("");
		btn12.setBounds(552, 59, 33, 21);
		panelw.add(btn12);
		
		JButton btn13 = new JButton("");
		btn13.setBounds(595, 59, 33, 21);
		panelw.add(btn13);
		
		JButton btn14 = new JButton("");
		btn14.setBounds(668, 59, 33, 21);
		panelw.add(btn14);
		
		JButton btn15 = new JButton("");
		btn15.setBounds(711, 59, 33, 21);
		panelw.add(btn15);
		
		JButton btn16 = new JButton("");
		btn16.setBounds(754, 59, 33, 21);
		panelw.add(btn16);
		
		JButton btn17 = new JButton("");
		btn17.setBounds(797, 59, 33, 21);
		panelw.add(btn17);
		
		JButton btn18 = new JButton("");
		btn18.setBounds(840, 59, 33, 21);
		panelw.add(btn18);
		
		JButton btn19 = new JButton("");
		btn19.setBounds(50, 90, 33, 21);
		panelw.add(btn19);
		
		JButton btn20 = new JButton("");
		btn20.setBounds(93, 90, 33, 21);
		panelw.add(btn20);
		
		JButton btn21 = new JButton("");
		btn21.setBounds(136, 90, 33, 21);
		panelw.add(btn21);
		
		JButton btn22 = new JButton("");
		btn22.setBounds(179, 90, 33, 21);
		panelw.add(btn22);
		
		JButton btn23 = new JButton("");
		btn23.setBounds(222, 90, 33, 21);
		panelw.add(btn23);
		
		JButton btn24 = new JButton("");
		btn24.setBounds(296, 90, 33, 21);
		panelw.add(btn24);
		
		JButton btn25 = new JButton("");
		btn25.setBounds(339, 90, 33, 21);
		panelw.add(btn25);
		
		JButton btn26 = new JButton("");
		btn26.setBounds(382, 90, 33, 21);
		panelw.add(btn26);
		
		JButton btn27 = new JButton("");
		btn27.setBounds(423, 90, 33, 21);
		panelw.add(btn27);
		
		JButton btn28 = new JButton("");
		btn28.setBounds(466, 90, 33, 21);
		panelw.add(btn28);
		
		JButton btn29 = new JButton("");
		btn29.setBounds(509, 90, 33, 21);
		panelw.add(btn29);
		
		JButton btn30 = new JButton("");
		btn30.setBounds(552, 90, 33, 21);
		panelw.add(btn30);
		
		JButton btn31 = new JButton("");
		btn31.setBounds(595, 90, 33, 21);
		panelw.add(btn31);
		
		JButton btn32 = new JButton("");
		btn32.setBounds(668, 90, 33, 21);
		panelw.add(btn32);
		
		JButton btn33 = new JButton("");
		btn33.setBounds(711, 90, 33, 21);
		panelw.add(btn33);
		
		JButton btn34 = new JButton("");
		btn34.setBounds(754, 90, 33, 21);
		panelw.add(btn34);
		
		JButton btn35 = new JButton("");
		btn35.setBounds(797, 90, 33, 21);
		panelw.add(btn35);
		
		JButton btn36 = new JButton("");
		btn36.setBounds(840, 90, 33, 21);
		panelw.add(btn36);
		
		JButton btn37 = new JButton("");
		btn37.setBounds(50, 121, 33, 21);
		panelw.add(btn37);
		
		JButton btn38 = new JButton("");
		btn38.setBounds(93, 121, 33, 21);
		panelw.add(btn38);
		
		JButton btn39 = new JButton("");
		btn39.setBounds(136, 121, 33, 21);
		panelw.add(btn39);
		
		JButton btn40 = new JButton("");
		btn40.setBounds(179, 121, 33, 21);
		panelw.add(btn40);
		
		JButton btn41 = new JButton("");
		btn41.setBounds(222, 121, 33, 21);
		panelw.add(btn41);
		
		JButton btn42 = new JButton("");
		btn42.setBounds(296, 121, 33, 21);
		panelw.add(btn42);
		
		JButton btn43 = new JButton("");
		btn43.setBounds(339, 121, 33, 21);
		panelw.add(btn43);
		
		JButton btn44 = new JButton("");
		btn44.setBounds(382, 121, 33, 21);
		panelw.add(btn44);
		
		JButton btn45 = new JButton("");
		btn45.setBounds(423, 121, 33, 21);
		panelw.add(btn45);
		
		JButton btn46 = new JButton("");
		btn46.setBounds(466, 121, 33, 21);
		panelw.add(btn46);
		
		JButton btn47 = new JButton("");
		btn47.setBounds(509, 121, 33, 21);
		panelw.add(btn47);
		
		JButton btn48 = new JButton("");
		btn48.setBounds(552, 121, 33, 21);
		panelw.add(btn48);
		
		JButton btn49 = new JButton("");
		btn49.setBounds(595, 121, 33, 21);
		panelw.add(btn49);
		
		JButton btn50 = new JButton("");
		btn50.setBounds(668, 121, 33, 21);
		panelw.add(btn50);
		
		JButton btn51 = new JButton("");
		btn51.setBounds(711, 121, 33, 21);
		panelw.add(btn51);
		
		JButton btn52 = new JButton("");
		btn52.setBounds(754, 121, 33, 21);
		panelw.add(btn52);
		
		JButton btn53 = new JButton("");
		btn53.setBounds(797, 121, 33, 21);
		panelw.add(btn53);
		
		JButton btn54 = new JButton("");
		btn54.setBounds(840, 121, 33, 21);
		panelw.add(btn54);
		
		JButton btn55 = new JButton("");
		btn55.setBounds(50, 152, 33, 21);
		panelw.add(btn55);
		
		JButton btn56 = new JButton("");
		btn56.setBounds(93, 152, 33, 21);
		panelw.add(btn56);
		
		JButton btn57 = new JButton("");
		btn57.setBounds(136, 152, 33, 21);
		panelw.add(btn57);
		
		JButton btn58 = new JButton("");
		btn58.setBounds(179, 152, 33, 21);
		panelw.add(btn58);
		
		JButton btn59 = new JButton("");
		btn59.setBounds(222, 152, 33, 21);
		panelw.add(btn59);
		
		JButton btn60 = new JButton("");
		btn60.setBounds(296, 152, 33, 21);
		panelw.add(btn60);
		
		JButton btn61 = new JButton("");
		btn61.setBounds(339, 152, 33, 21);
		panelw.add(btn61);
		
		JButton btn62 = new JButton("");
		btn62.setBounds(382, 152, 33, 21);
		panelw.add(btn62);
		
		JButton btn63 = new JButton("");
		btn63.setBounds(423, 152, 33, 21);
		panelw.add(btn63);
		
		JButton btn64 = new JButton("");
		btn64.setBounds(466, 152, 33, 21);
		panelw.add(btn64);
		
		JButton btn65 = new JButton("");
		btn65.setBounds(509, 152, 33, 21);
		panelw.add(btn65);
		
		JButton btn66 = new JButton("");
		btn66.setBounds(552, 152, 33, 21);
		panelw.add(btn66);
		
		JButton btn67 = new JButton("");
		btn67.setBounds(595, 152, 33, 21);
		panelw.add(btn67);
		
		JButton btn68 = new JButton("");
		btn68.setBounds(668, 152, 33, 21);
		panelw.add(btn68);
		
		JButton btn69 = new JButton("");
		btn69.setBounds(711, 152, 33, 21);
		panelw.add(btn69);
		
		JButton btn70 = new JButton("");
		btn70.setBounds(754, 152, 33, 21);
		panelw.add(btn70);
		
		JButton btn71 = new JButton("");
		btn71.setBounds(797, 152, 33, 21);
		panelw.add(btn71);
		
		JButton btn72s = new JButton("");
		btn72s.setBounds(840, 152, 33, 21);
		panelw.add(btn72s);
		
		JButton btn73 = new JButton("");
		btn73.setBounds(50, 183, 33, 21);
		panelw.add(btn73);
		
		JButton btn74 = new JButton("");
		btn74.setBounds(93, 183, 33, 21);
		panelw.add(btn74);
		
		JButton btn75 = new JButton("");
		btn75.setBounds(136, 183, 33, 21);
		panelw.add(btn75);
		
		JButton btn76 = new JButton("");
		btn76.setBounds(179, 183, 33, 21);
		panelw.add(btn76);
		
		JButton btn77 = new JButton("");
		btn77.setBounds(222, 183, 33, 21);
		panelw.add(btn77);
		
		JButton btn78 = new JButton("");
		btn78.setBounds(296, 183, 33, 21);
		panelw.add(btn78);
		
		JButton btn79 = new JButton("");
		btn79.setBounds(339, 183, 33, 21);
		panelw.add(btn79);
		
		JButton btn80 = new JButton("");
		btn80.setBounds(382, 183, 33, 21);
		panelw.add(btn80);
		
		JButton btn81 = new JButton("");
		btn81.setBounds(423, 183, 33, 21);
		panelw.add(btn81);
		
		JButton btn82 = new JButton("");
		btn82.setBounds(466, 183, 33, 21);
		panelw.add(btn82);
		
		JButton btn83 = new JButton("");
		btn83.setBounds(509, 183, 33, 21);
		panelw.add(btn83);
		
		JButton btn84 = new JButton("");
		btn84.setBounds(552, 183, 33, 21);
		panelw.add(btn84);
		
		JButton btn85 = new JButton("");
		btn85.setBounds(595, 183, 33, 21);
		panelw.add(btn85);
		
		JButton btn86 = new JButton("");
		btn86.setBounds(668, 183, 33, 21);
		panelw.add(btn86);
		
		JButton btn87 = new JButton("");
		btn87.setBounds(711, 183, 33, 21);
		panelw.add(btn87);
		
		JButton btn88 = new JButton("");
		btn88.setBounds(754, 183, 33, 21);
		panelw.add(btn88);
		
		JButton btn89 = new JButton("");
		btn89.setBounds(797, 183, 33, 21);
		panelw.add(btn89);
		
		JButton btn90 = new JButton("");
		btn90.setBounds(840, 183, 33, 21);
		panelw.add(btn90);
		
		JButton btn92 = new JButton("");
		btn92.setBounds(296, 227, 33, 21);
		panelw.add(btn92);
		
		JButton btn93 = new JButton("");
		btn93.setBounds(339, 227, 33, 21);
		panelw.add(btn93);
		
		JButton btn94 = new JButton("");
		btn94.setBounds(382, 227, 33, 21);
		panelw.add(btn94);
		
		JButton btn95 = new JButton("");
		btn95.setBounds(423, 227, 33, 21);
		panelw.add(btn95);
		
		JButton btn96 = new JButton("");
		btn96.setBounds(466, 227, 33, 21);
		panelw.add(btn96);
		
		JButton btn97 = new JButton("");
		btn97.setBounds(509, 227, 33, 21);
		panelw.add(btn97);
		
		JButton btn98 = new JButton("");
		btn98.setBounds(552, 227, 33, 21);
		panelw.add(btn98);
		
		JButton btn99 = new JButton("");
		btn99.setBounds(595, 227, 33, 21);
		panelw.add(btn99);
		
		JButton btn100 = new JButton("");
		btn100.setBounds(638, 227, 33, 21);
		panelw.add(btn100);
		
		JButton btn91 = new JButton("");
		btn91.setBounds(253, 227, 33, 21);
		panelw.add(btn91);
		
		JButton btn_reserve = new JButton("Reserve");
		btn_reserve.setForeground(new Color(255, 255, 255));
		btn_reserve.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_reserve.setBounds(866, 479, 101, 25);
		btn_reserve.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(btn_reserve);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1010, 43);
		panel.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panel);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		lblrectangle.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(lblrectangle);
		
	}
}
