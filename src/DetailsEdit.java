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
import com.toedter.calendar.JTextFieldDateEditor;

public class DetailsEdit {

	JFrame frame;
	JTextField textField_price;
	JTextField textField_title;
	JLabel lblposter;
	JTextArea txt_area;
	JDateChooser startDate;
	JDateChooser endDate;
	String time_avail1, movie_title, movie_desc;
	Date start_date, end_date;
	double movie_price;
	int cinema_num;
	JComboBox cinemaN, times;
	int seat_num;
	String selectedImagePath = null;
	JMenu user_account;

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
		
		JButton btn_employees = new JButton("Employees");
		btn_employees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeDetails empD = new EmployeeDetails();
				empD.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_employees.setHorizontalAlignment(SwingConstants.LEFT);
		btn_employees.setForeground(Color.WHITE);
		btn_employees.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		btn_employees.setFocusPainted(false);
		btn_employees.setBorderPainted(false);
		btn_employees.setBackground(new Color(247, 165, 35));
		btn_employees.setBounds(5, 173, 194, 40);
		panelo.add(btn_employees);
		
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
		        
		        if (cinemaN.getSelectedItem() == "1") {
		        	seat_num = 100;
		        }
		        else if (cinemaN.getSelectedItem() == "2") {
		        	seat_num = 150;
		        }
		        else if (cinemaN.getSelectedItem() == "3") {
		        	seat_num = 250;
		        }
		        else if (cinemaN.getSelectedItem() == "4") {
		        	seat_num = 200;
		        }
		        
				try (Connection connection = DriverManager.getConnection(connectionUrl)){
					
					String query1 = "INSERT INTO SchedMovies (MovieTitle) VALUES (?)";
					PreparedStatement ps = connection.prepareStatement(query1);
					
					ps.setString(1, textField_title.getText());
					
					String query2 = "INSERT INTO Cinemas (StartDate, EndDate, Price, CinemaNo, SeatNo, ShowTime, MovieDesc, MovieImg, MovieTitle)"
							+ "VALUES (?,?,?,?,?,?,?,?,?)";
					
					InputStream inputS =  new FileInputStream(selectedImagePath);
					PreparedStatement pst = connection.prepareStatement(query2);
					
					pst.setDate(1, start_date);
					pst.setDate(2, end_date);
					pst.setDouble(3, movie_price = Double.parseDouble(textField_price.getText()));
					pst.setString(4, (String) cinemaN.getSelectedItem());
					pst.setInt(5, seat_num);
					pst.setString(6, (String) times.getSelectedItem());
					pst.setString(7, txt_area.getText());
					pst.setBlob(8, inputS);
					pst.setString(9, textField_title.getText());
					
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION); {
						if (input == JOptionPane.YES_OPTION) {
							  ps.executeUpdate();
							  pst.executeUpdate();
				              JOptionPane.showMessageDialog(null, "Added successfully.");
						}
					}
					
					SchedMovies sm = new SchedMovies();
	                sm.frame.setVisible(true);
	                frame.dispose();
					
				} catch(HeadlessException | SQLException x){
			        JOptionPane.showMessageDialog(null,x);
			        x.printStackTrace();
			        
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
				int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel adding movie?", "WARNING", JOptionPane.YES_NO_OPTION); {
					if (input == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "No movie was added.");
						SchedMovies sm = new SchedMovies();
		                sm.frame.setVisible(true);
		                frame.dispose();
					}
				}
			}
		});
		btn_cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancel.setBorderPainted(false);
		btn_cancel.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_cancel.setBackground(new Color(246, 198, 36));
		btn_cancel.setBounds(732, 90, 121, 29);
		frame.getContentPane().add(btn_cancel);
		
		JPanel panelw = new JPanel();
		panelw.setBackground(Color.WHITE);
		panelw.setBounds(233, 129, 747, 380);
		frame.getContentPane().add(panelw);
		panelw.setLayout(null);
		
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
					JOptionPane.showMessageDialog(null, "Uploaded picture successfully!");
					
					ImageIcon icon = new ImageIcon(selectedImagePath);
					Image image = icon.getImage().getScaledInstance(lblposter.getWidth(),lblposter.getHeight(),Image.SCALE_SMOOTH);
					lblposter.setIcon(new ImageIcon(image));
				}
			}
		});
		btn_upload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_upload.setBorderPainted(false);
		btn_upload.setBounds(57, 240, 72, 19);
		btn_upload.setFont(new Font("Poppins", Font.BOLD, 9));
		btn_upload.setBackground(new Color(246, 198, 36));
		panelw.add(btn_upload);
		
		lblposter = new JLabel("");
		lblposter.setBounds(18, 12, 150, 220);
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
		lblta1.setBounds(428, 214, 106, 19);
		lblta1.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		panelw.add(lblta1);
		
		JLabel lblp = new JLabel("Price:");
		lblp.setBounds(185, 261, 45, 19);
		lblp.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblp);
		
		textField_title = new JTextField();
		textField_title.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		textField_title.setBounds(306, 19, 418, 22);
		panelw.add(textField_title);
		textField_title.setColumns(10);
		
        txt_area = new JTextArea();
		txt_area.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_area.setMargin(new Insets(3, 7, 3, 3));
		txt_area.setFont(new Font("Poppins", Font.PLAIN, 12));
		txt_area.setLineWrap(true);
		txt_area.setWrapStyleWord(true);
		txt_area.setBounds(306, 54, 418, 57);
		panelw.add(txt_area);
		
		textField_price = new JTextField();
		textField_price.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		textField_price.setBounds(306, 261, 418, 20);
		panelw.add(textField_price);
		textField_price.setColumns(10);
		
		JLabel lblend = new JLabel("End Showing:");
		lblend.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblend.setBounds(185, 165, 116, 17);
		panelw.add(lblend);
		
		startDate = new JDateChooser();
		JTextFieldDateEditor Seditor = (JTextFieldDateEditor) startDate.getDateEditor();
        Seditor.setEditable(false);
		startDate.setBounds(306, 122, 418, 20);
		panelw.add(startDate);
		
		endDate = new JDateChooser();
		JTextFieldDateEditor Eeditor = (JTextFieldDateEditor) endDate.getDateEditor();
        Eeditor.setEditable(false);
		endDate.setBounds(306, 162, 418, 20);
		panelw.add(endDate);
		
		cinemaN = new JComboBox();
		cinemaN.setBackground(Color.WHITE);
		cinemaN.setFont(new Font("Poppins", Font.PLAIN, 12));
		cinemaN.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cinemaN.setBounds(307, 208, 97, 30);
		panelw.add(cinemaN);
		
		times = new JComboBox();
		times.setBackground(Color.WHITE);
		times.setFont(new Font("Poppins", Font.PLAIN, 12));
		times.setModel(new DefaultComboBoxModel(new String[] {"12:30PM", "1:00PM", "1:30PM", "2:00PM", "2:30PM", 
				"3:00PM", "3:30PM", "4:00PM", "4:30PM", "5:00PM", "5:30PM", "6:00PM", "6:30PM", "7:00PM", "7:30PM", "8:00PM"}));
		times.setBounds(544, 208, 180, 29);
		panelw.add(times);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setBounds(0, 0, 1010, 539);
		lblrectangle.setIcon(new ImageIcon (this.getClass().getResource("/images/background.png")));
		frame.getContentPane().add(lblrectangle);
	}
}
