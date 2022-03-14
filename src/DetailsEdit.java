import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

public class DetailsEdit {

	JFrame frame;
	private JTextField textField_title;
	private JLabel lblposter;
	private JTextArea txt_area;
	private JDateChooser startDate;
	private JDateChooser endDate;
	private JTextField times_1f;
	private JTextField textField_price;
	String time_avail1, movie_title, movie_desc;
	Date start_date, end_date;
	double movie_price;
	int cinema_num;
	int seat_num = 150;
	String selectedImagePath = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsEdit window = new DetailsEdit();
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
	public DetailsEdit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelo = new JPanel();
		panelo.setBounds(0, 0, 206, 537);
		panelo.setBackground(new Color(247, 165, 35));
		frame.getContentPane().add(panelo);
		panelo.setLayout(null);
		
		JButton btn_dash = new JButton("Dashboard");
		btn_dash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AdminDash ad = new AdminDash();
                ad.frame.setVisible(true);
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
		panelo.add(btn_dash);
		
		JButton btn_sched = new JButton("Scheduled Movies");
		btn_sched.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SchedMovies sm = new SchedMovies();
                sm.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_sched.setForeground(Color.WHITE);
		btn_sched.setBackground(new Color(246, 198, 36));
		btn_sched.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sched.setHorizontalAlignment(SwingConstants.LEFT);
		btn_sched.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_sched.setFocusPainted(false);
		btn_sched.setBorderPainted(false);
		btn_sched.setBounds(5, 126, 194, 40);
		panelo.add(btn_sched);
		
		JButton btn_reservations = new JButton("Reservations");
		btn_reservations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Reservations r = new Reservations();
                r.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_reservations.setForeground(Color.WHITE);
		btn_reservations.setBackground(new Color(247, 165, 35));
		btn_reservations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reservations.setHorizontalAlignment(SwingConstants.LEFT);
		btn_reservations.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_reservations.setFocusPainted(false);
		btn_reservations.setBorderPainted(false);
		btn_reservations.setBounds(5, 173, 194, 40);
		panelo.add(btn_reservations);
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon(this.getClass().getResource("/images/blue-logo.png")));
		lbl_logo.setBounds(20, 18, 67, 46);
		panelo.add(lbl_logo);
		
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
		
		JLabel lbl_schedmovies = new JLabel("Add new movie");
		lbl_schedmovies.setForeground(Color.WHITE);
		lbl_schedmovies.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_schedmovies.setBounds(274, 49, 182, 19);
		frame.getContentPane().add(lbl_schedmovies);
		
		JPanel line = new JPanel();
		line.setBounds(233, 78, 747, 2);
		frame.getContentPane().add(line);
		
		JButton btn_save = new JButton("Save");
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate = simpleDateFormat.format(startDate.getDate());
		        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
		        start_date = date1;
		        
		        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate2 = simpleDateFormat2.format(endDate.getDate());
		        java.sql.Date date2 = java.sql.Date.valueOf(formattedDate2);
		        end_date = date2;
		        
				String connectionUrl = "jdbc:sqlserver://localhost:1433;"
			               +"databaseName = SchedMovies;"
                        +"username = sa;"
			               +"password = markangelo12;"
			               + ";encrypt=true;trustServerCertificate=true;";
	try (Connection connection = DriverManager.getConnection(connectionUrl)){
		
		String query = "INSERT INTO SchedMovies (MovieTitle,StartDate,EndDate,Price,CinemaNo,SeatNo,ShowTime,MovieDesc,MovieImg) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		InputStream inputS =  new FileInputStream(selectedImagePath);
		
		pst.setString(1, textField_title.getText());
		pst.setDate(2, start_date);
		pst.setDate(3, end_date);
		pst.setDouble(4, movie_price = Double.parseDouble(textField_price.getText()));
		pst.setInt(5, cinema_num);
		pst.setInt(6, seat_num);
		pst.setString(7, time_avail1);
		pst.setString(8, txt_area.getText());
		pst.setBlob(9, inputS);
		int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION); {
			if (input == JOptionPane.YES_OPTION) {
				  pst.executeUpdate();
	               JOptionPane.showMessageDialog(null, "Added successfully.");
			}
		}
	} catch(HeadlessException | SQLException x){
        JOptionPane.showMessageDialog(null,x);
    } catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
			}
		});
		btn_save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_save.setBorderPainted(false);
		btn_save.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_save.setBackground(new Color(246, 198, 36));
		btn_save.setBounds(859, 90, 121, 29);
		frame.getContentPane().add(btn_save);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SchedMovies sm = new SchedMovies();
                sm.frame.setVisible(true);
                frame.dispose();
			}
		});
		btn_cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancel.setBorderPainted(false);
		btn_cancel.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_cancel.setBackground(new Color(246, 198, 36));
		btn_cancel.setBounds(732, 90, 121, 29);
		frame.getContentPane().add(btn_cancel);
		
		JPanel panelw = new JPanel();
		panelw.setBounds(233, 129, 747, 380);
		frame.getContentPane().add(panelw);
		panelw.setLayout(null);
		
		JButton btn_change = new JButton("Change");
		btn_change.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_change.setBorderPainted(false);
		btn_change.setBounds(96, 240, 72, 19);
		btn_change.setFont(new Font("Poppins", Font.BOLD, 9));
		btn_change.setBackground(new Color(246, 198, 36));
		panelw.add(btn_change);
		
		JButton btn_upload = new JButton("Upload");
		btn_upload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser browseImageFile = new JFileChooser();
				
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialogue = browseImageFile.showOpenDialog(null);
				
				if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					selectedImagePath = selectedImageFile.getAbsolutePath();
					JOptionPane.showMessageDialog(null, selectedImagePath);
					
					ImageIcon icon = new ImageIcon(selectedImagePath);
					Image image = icon.getImage().getScaledInstance(lblposter.getWidth(),lblposter.getHeight(),Image.SCALE_SMOOTH);
					lblposter.setIcon(new ImageIcon(image));
				
				}
			}
		});
		btn_upload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_upload.setBorderPainted(false);
		btn_upload.setBounds(18, 240, 72, 19);
		btn_upload.setFont(new Font("Poppins", Font.BOLD, 9));
		btn_upload.setBackground(new Color(246, 198, 36));
		panelw.add(btn_upload);
		
		lblposter = new JLabel("");
		lblposter.setBounds(18, 10, 150, 229);
		lblposter.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/images/add new.png")).getImage().getScaledInstance(150, 220, Image.SCALE_DEFAULT)));
		panelw.add(lblposter);
		
		JLabel lblmt = new JLabel("Movie Title:");
		lblmt.setBounds(185, 22, 87, 17);
		lblmt.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblmt);
		
		JLabel lbld = new JLabel("Description:");
		lbld.setBounds(185, 60, 87, 17);
		lbld.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lbld);
		
		JLabel lblstart = new JLabel("Start Showing:");
		lblstart.setBounds(185, 125, 116, 17);
		lblstart.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblstart);
		
		JLabel lblcm1 = new JLabel("Cinema Number:");
		lblcm1.setBounds(185, 214, 112, 19);
		lblcm1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblcm1);
		
		JLabel lblta1 = new JLabel("Times Available:");
		lblta1.setBounds(185, 262, 106, 19);
		lblta1.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		panelw.add(lblta1);
		
		JLabel lblp = new JLabel("Price:");
		lblp.setBounds(195, 314, 45, 19);
		lblp.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblp);
		
		textField_title = new JTextField();
		textField_title.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		textField_title.setBounds(296, 19, 437, 22);
		panelw.add(textField_title);
		textField_title.setColumns(10);
		
        txt_area = new JTextArea();
		txt_area.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_area.setMargin(new Insets(3, 7, 3, 3));
		txt_area.setFont(new Font("Poppins", Font.PLAIN, 12));
		txt_area.setLineWrap(true);
		txt_area.setWrapStyleWord(true);
		txt_area.setBounds(296, 54, 437, 57);
		panelw.add(txt_area);
		
		JButton cinema_1f = new JButton("1");
		cinema_1f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cinema_num = 1;
				
			}
		});
		cinema_1f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cinema_1f.setForeground(new Color(17, 34, 44));
		cinema_1f.setFont(new Font("Poppins", Font.BOLD, 12));
		cinema_1f.setBorderPainted(false);
		cinema_1f.setBackground(new Color(247, 165, 35));
		cinema_1f.setFocusPainted(false);
		cinema_1f.setBounds(296, 209, 45, 30);
		panelw.add(cinema_1f);
		
		JButton cinema_2f = new JButton("2");
		cinema_2f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cinema_num = 2;
				
			}
		});
		cinema_2f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cinema_2f.setForeground(new Color(17, 34, 44));
		cinema_2f.setFont(new Font("Poppins", Font.BOLD, 12));
		cinema_2f.setFocusPainted(false);
		cinema_2f.setBorderPainted(false);
		cinema_2f.setBackground(new Color(246, 198, 36));
		cinema_2f.setBounds(345, 209, 45, 30);
		panelw.add(cinema_2f);
		
		JButton cinema_3f = new JButton("3");
		cinema_3f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cinema_num = 3;
				
			}
		});
		cinema_3f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cinema_3f.setForeground(new Color(17, 34, 44));
		cinema_3f.setFont(new Font("Poppins", Font.BOLD, 12));
		cinema_3f.setFocusPainted(false);
		cinema_3f.setBorderPainted(false);
		cinema_3f.setBackground(new Color(246, 198, 36));
		cinema_3f.setBounds(394, 209, 45, 30);
		panelw.add(cinema_3f);
		
		JButton cinema_4f = new JButton("4");
		cinema_4f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cinema_num = 4;
				
			}
		});
		cinema_4f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cinema_4f.setForeground(new Color(17, 34, 44));
		cinema_4f.setFont(new Font("Poppins", Font.BOLD, 12));
		cinema_4f.setFocusPainted(false);
		cinema_4f.setBorderPainted(false);
		cinema_4f.setBackground(new Color(246, 198, 36));
		cinema_4f.setBounds(443, 209, 45, 30);
		panelw.add(cinema_4f);
		
		times_1f = new JTextField();
		times_1f.setMargin(new Insets(3, 7, 3, 3));
		times_1f.setFont(new Font("Poppins", Font.PLAIN, 12));
		times_1f.setColumns(10);
		times_1f.setBounds(296, 261, 63, 20);
		panelw.add(times_1f);
		
		JButton add_time = new JButton("+");
		add_time.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String time1 = JOptionPane.showInputDialog("Add Time");
				time_avail1 = time1;
				times_1f.setText(time_avail1);
				
			}
		});
		add_time.setBackground(new Color(246, 198, 36));
		add_time.setFont(new Font("Poppins", Font.BOLD, 11));
		add_time.setFocusPainted(false);
		add_time.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add_time.setBorderPainted(false);
		add_time.setBounds(369, 262, 47, 19);
		panelw.add(add_time);
		
		textField_price = new JTextField();
		textField_price.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		textField_price.setBounds(305, 313, 428, 20);
		panelw.add(textField_price);
		textField_price.setColumns(10);
		
		JLabel lblend = new JLabel("End Showing:");
		lblend.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblend.setBounds(185, 165, 116, 17);
		panelw.add(lblend);
		
		startDate = new JDateChooser();
		
		startDate.setBounds(296, 122, 437, 20);
		panelw.add(startDate);
		
		endDate = new JDateChooser();

		endDate.setBounds(296, 162, 437, 20);
		panelw.add(endDate);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setBounds(0, 0, 1010, 539);
		lblrectangle.setIcon(new ImageIcon (this.getClass().getResource("/images/background.png")));
		frame.getContentPane().add(lblrectangle);
	}
}