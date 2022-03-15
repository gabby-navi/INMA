import java.awt.*;
import javax.swing.*;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class AdminOverview {

	JFrame frame;
	static JLabel lblposter;
	JTextField textField_price;
	JTextField textField_title;
	JTextArea txt_area;
	String time_avail1, movie_title, movie_desc;
	Date start_date, end_date;
	double movie_price;
	int cinema_num;
	int seat_num = 150;
	JDateChooser startDate;
	JDateChooser endDate;
	JButton cancel_edit, remove_movie, save_edit, edit_employee, btn_change;
	JComboBox cinemaN, times, cinemaN2, times2;
	JButton add_cine, add_cinema, cancel_addcine;
	String selectedImagePath = null;
	JMenu user_account;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOverview window = new AdminOverview();
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
	public AdminOverview() {
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
		lbl_logo.setIcon(new ImageIcon(this.getClass().getResource("/images/logo.png")));
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
		
		JLabel lbl_schedmovies = new JLabel("Uncharted");
		lbl_schedmovies.setForeground(Color.WHITE);
		lbl_schedmovies.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lbl_schedmovies.setBounds(274, 49, 137, 19);
		frame.getContentPane().add(lbl_schedmovies);
		
		JPanel line = new JPanel();
		line.setBounds(233, 78, 747, 2);
		frame.getContentPane().add(line);
		
		edit_employee = new JButton("Edit");
		edit_employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_price.setEditable(true);
				txt_area.setEditable(true);
				cinemaN.setEnabled(true);
				times.setEnabled(true);
				startDate.setEnabled(true);
				endDate.setEnabled(true);
				
				save_edit.setVisible(true);
				edit_employee.setVisible(false);
				remove_movie.setVisible(false);
				cancel_edit.setVisible(true);
				btn_change.setVisible(true);
			}
		});
		edit_employee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		edit_employee.setForeground(new Color(17, 34, 44));
		edit_employee.setFont(new Font("Poppins", Font.BOLD, 10));
		edit_employee.setBorderPainted(false);
		edit_employee.setBackground(new Color(246, 198, 36));
		edit_employee.setBounds(728, 91, 121, 29);
		frame.getContentPane().add(edit_employee);
		
		cancel_edit = new JButton("Cancel");
		cancel_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel changes?", "WARNING", JOptionPane.YES_NO_OPTION); {
					if (input == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "No changes were made.");
					}
				}
				
				textField_price.setEditable(false);
				txt_area.setEditable(false);
				cinemaN.setEnabled(false);
				times.setEnabled(false);
				startDate.setEnabled(false);
				endDate.setEnabled(false);
				
				save_edit.setVisible(false);
				edit_employee.setVisible(true);
				remove_movie.setVisible(true);
				cancel_edit.setVisible(false);
				btn_change.setVisible(false);
			}
		});
		cancel_edit.setVisible(false);
		cancel_edit.setForeground(new Color(17, 34, 44));
		cancel_edit.setFont(new Font("Poppins", Font.BOLD, 10));
		cancel_edit.setBorderPainted(false);
		cancel_edit.setBackground(new Color(246, 198, 36));
		cancel_edit.setBounds(859, 91, 121, 29);
		frame.getContentPane().add(cancel_edit);
		
		remove_movie = new JButton("Remove");
		remove_movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)SchedMovies.table.getModel();
				int selectedRow = SchedMovies.table.getSelectedRow();
				
				String selected = model.getValueAt(selectedRow, 0).toString();
				
				String sqlQuery = "DELETE FROM Cinemas WHERE MovieTitle='" + selected + "'";
				String sqlQuery2 = "DELETE FROM SchedMovies WHERE MovieTitle='" + selected + "'";
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {            
					
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					PreparedStatement pst = connection.prepareStatement(sqlQuery2);
					
					int deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this movie?", "WARNING", JOptionPane.YES_NO_OPTION); {
						if (deleteItem == JOptionPane.YES_OPTION) {
							ps.executeUpdate();
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Deleted successfully.");
							SchedMovies.updateDB();
						}
					}
				}
				
				catch(HeadlessException | SQLException ex){
		            JOptionPane.showMessageDialog(null, ex);
		        }
			}
		});
		remove_movie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		remove_movie.setBorderPainted(false);
		remove_movie.setFont(new Font("Poppins", Font.BOLD, 10));
		remove_movie.setForeground(new Color(17, 34, 44));
		remove_movie.setBackground(new Color(246, 198, 36));
		remove_movie.setBounds(859, 91, 121, 29);
		frame.getContentPane().add(remove_movie);
		
		save_edit = new JButton("Save");
		save_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)SchedMovies.table.getModel();
				int selectedRow = SchedMovies.table.getSelectedRow();
				
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
		        
		        java.util.Date startD = startDate.getDate();
		        java.util.Date endD = endDate.getDate();
		        
		        String strDate = DateFormat.getDateInstance().format(startD);
		        String eDate = DateFormat.getDateInstance().format(endD);
				
				int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
//		        String selected = model.getValueAt(selectedRow, 0).toString();
				
				String sqlQuery = "UPDATE Cinemas SET StartDate=?, EndDate=?, Price=?, CinemaNo=?, SeatNo=?, ShowTime=?,"
						+ "MovieDesc=? WHERE id=?";
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {            
					
					PreparedStatement ps = connection.prepareStatement(sqlQuery);
					
					ps.setString(1, strDate);
					ps.setString(2, eDate);
					ps.setDouble(3, movie_price = Double.parseDouble(textField_price.getText()));
					ps.setString(4, (String) cinemaN2.getSelectedItem());
					ps.setInt(5, seat_num);
					ps.setString(6, (String) times2.getSelectedItem());
					ps.setString(7, txt_area.getText());
					ps.setInt(8, id);

					ps.executeUpdate();
			           
					JOptionPane.showMessageDialog(null, "Updated Successfully!");
					SchedMovies.updateDB();
					
					SchedMovies sm = new SchedMovies();
	                sm.frame.setVisible(true);
	                frame.dispose();
				}
				
				catch(HeadlessException | SQLException ex){
		            JOptionPane.showMessageDialog(null, ex);
		        } 
			}
		});
		save_edit.setVisible(false);
		save_edit.setForeground(new Color(17, 34, 44));
		save_edit.setFont(new Font("Poppins", Font.BOLD, 10));
		save_edit.setBorderPainted(false);
		save_edit.setBackground(new Color(246, 198, 36));
		save_edit.setBounds(728, 91, 121, 29);
		frame.getContentPane().add(save_edit);
		
		JPanel panelw = new JPanel();
		panelw.setBackground(Color.WHITE);
		panelw.setBounds(233, 129, 747, 380);
		frame.getContentPane().add(panelw);
		panelw.setLayout(null);
		
		btn_change = new JButton("Change");
		btn_change.setVisible(false);
		btn_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialogue = browseImageFile.showOpenDialog(null);
				
				if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					selectedImagePath = selectedImageFile.getAbsolutePath();
					JOptionPane.showMessageDialog(null, "Changed picture successfully!");
					
					ImageIcon icon = new ImageIcon(selectedImagePath);
					Image image = icon.getImage().getScaledInstance(lblposter.getWidth(),lblposter.getHeight(),Image.SCALE_SMOOTH);
					lblposter.setIcon(new ImageIcon(image));
				}
			}
		});
		btn_change.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_change.setBorderPainted(false);
		btn_change.setBounds(48, 240, 87, 19);
		btn_change.setFont(new Font("Poppins", Font.BOLD, 10));
		btn_change.setBackground(new Color(246, 198, 36));
		panelw.add(btn_change);
		
		lblposter = new JLabel("");
		lblposter.setBounds(18, 12, 150, 220);
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
		
		JLabel lblp = new JLabel("Price:");
		lblp.setBounds(185, 261, 45, 19);
		lblp.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		panelw.add(lblp);
		
		JLabel lblprice = new JLabel("");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblprice.setBounds(300, 292, 81, 19);
		panelw.add(lblprice);
		
		JLabel lblend = new JLabel("End Showing:");
		lblend.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		lblend.setBounds(185, 165, 116, 17);
		panelw.add(lblend);
		
		textField_title = new JTextField();
		textField_title.setEditable(false);
		textField_title.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
		textField_title.setBounds(306, 19, 418, 22);
		panelw.add(textField_title);
		textField_title.setColumns(10);
		
        txt_area = new JTextArea();
        txt_area.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        txt_area.setEditable(false);
        txt_area.setMargin(new Insets(3, 7, 3, 3));
        txt_area.setFont(new Font("Poppins", Font.PLAIN, 12));
        txt_area.setLineWrap(true);
        txt_area.setWrapStyleWord(true);
        txt_area.setBounds(306, 54, 418, 57);
        panelw.add(txt_area);
        
        textField_price = new JTextField();
        textField_price.setEditable(false);
        textField_price.setFont(new Font("Poppins Regular", Font.PLAIN, 12));
        textField_price.setBounds(306, 261, 418, 20);
        panelw.add(textField_price);
        textField_price.setColumns(10);
        
        startDate = new JDateChooser();
        JTextFieldDateEditor Seditor = (JTextFieldDateEditor) startDate.getDateEditor();
        Seditor.setEditable(false);
        startDate.setEnabled(false);
		startDate.setBounds(306, 122, 418, 20);
		panelw.add(startDate);
		
		endDate = new JDateChooser();
		JTextFieldDateEditor Eeditor = (JTextFieldDateEditor) endDate.getDateEditor();
        Eeditor.setEditable(false);
		endDate.setEnabled(false);
		endDate.setBounds(306, 162, 418, 20);
		panelw.add(endDate);
        
        JLabel lblcm = new JLabel("Cinema Number:");
        lblcm.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
        lblcm.setBounds(185, 214, 112, 19);
        panelw.add(lblcm);
        
        UIManager.put( "ComboBox.disabledForeground", Color.BLACK);
        UIManager.put("DateChooser.disabledForeground", Color.BLACK);
        
        cinemaN = new JComboBox();
        cinemaN.setEnabled(false);
        cinemaN.setFont(new Font("Poppins", Font.PLAIN, 12));
        cinemaN.setBackground(Color.WHITE);
        cinemaN.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
        cinemaN.setBounds(307, 208, 97, 30);
        panelw.add(cinemaN);
        
        JLabel lblta = new JLabel("Times Available:");
        lblta.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
        lblta.setBounds(428, 214, 106, 19);
        panelw.add(lblta);
        
        times = new JComboBox();
        times.setEnabled(false);
        times.setFont(new Font("Poppins", Font.PLAIN, 12));
        times.setBackground(Color.WHITE);
        times.setModel(new DefaultComboBoxModel(new String[] {"12:30PM", "1:00PM", "1:30PM", "2:00PM", "2:30PM", 
				"3:00PM", "3:30PM", "4:00PM", "4:30PM", "5:00PM", "5:30PM", "6:00PM", "6:30PM", "7:00PM", "7:30PM", "8:00PM"}));
        times.setBounds(544, 208, 180, 29);
        panelw.add(times);
        
        JLabel lblcm2 = new JLabel("Cinema Number:");
        lblcm2.setVisible(false);
        lblcm2.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
        lblcm2.setBounds(185, 338, 112, 19);
        panelw.add(lblcm2);
        
        cinemaN2 = new JComboBox();
        cinemaN2.setVisible(false);
        cinemaN2.setFont(new Font("Poppins", Font.PLAIN, 12));
        cinemaN2.setBackground(Color.WHITE);
        cinemaN2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
        cinemaN2.setBounds(307, 332, 97, 30);
        panelw.add(cinemaN2);
        
        JLabel lblta2 = new JLabel("Times Available:");
        lblta2.setVisible(false);
        lblta2.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
        lblta2.setBounds(428, 338, 106, 19);
        panelw.add(lblta2);
        
        times2 = new JComboBox();
        times2.setVisible(false);
        times2.setFont(new Font("Poppins", Font.PLAIN, 12));
        times2.setBackground(Color.WHITE);
        times2.setModel(new DefaultComboBoxModel(new String[] {"12:30PM", "1:00PM", "1:30PM", "2:00PM", "2:30PM", 
				"3:00PM", "3:30PM", "4:00PM", "4:30PM", "5:00PM", "5:30PM", "6:00PM", "6:30PM", "7:00PM", "7:30PM", "8:00PM"}));
        times2.setBounds(544, 332, 180, 29);
        panelw.add(times2);
        
        cancel_addcine = new JButton("Cancel");
        cancel_addcine.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel changes?", "WARNING", JOptionPane.YES_NO_OPTION); {
					if (input == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Cinema was not added.");
					}
				}
        		
        		cancel_addcine.setVisible(false);
        		add_cinema.setVisible(false);
        		add_cine.setVisible(true);
        		
        		lblcm2.setVisible(false);
        		cinemaN2.setVisible(false);
        		lblta2.setVisible(false);
        		times2.setVisible(false);
        	}
        });
        cancel_addcine.setVisible(false);
        cancel_addcine.setForeground(new Color(17, 34, 44));
        cancel_addcine.setFont(new Font("Poppins", Font.BOLD, 10));
        cancel_addcine.setBorderPainted(false);
        cancel_addcine.setBackground(new Color(246, 198, 36));
        cancel_addcine.setBounds(603, 292, 121, 29);
        panelw.add(cancel_addcine);
        
        add_cinema = new JButton("Add Cinema");
        add_cinema.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
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
		        
		        java.util.Date startD = startDate.getDate();
		        java.util.Date endD = endDate.getDate();
		        
		        String strDate = DateFormat.getDateInstance().format(startD);
		        String eDate = DateFormat.getDateInstance().format(endD);
		        
				try (Connection connection = DriverManager.getConnection(connectionUrl)){
					
					String query2 = "INSERT INTO Cinemas (StartDate, EndDate, Price, CinemaNo, SeatNo, ShowTime, MovieDesc, MovieTitle)"
							+ "VALUES (?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst = connection.prepareStatement(query2);
					
					pst.setString(1, strDate);
					pst.setString(2, eDate);
					pst.setDouble(3, movie_price = Double.parseDouble(textField_price.getText()));
					pst.setString(4, (String) cinemaN2.getSelectedItem());
					pst.setInt(5, seat_num);
					pst.setString(6, (String) times2.getSelectedItem());
					pst.setString(7, txt_area.getText());
					pst.setString(8, textField_title.getText());
					
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION); {
						if (input == JOptionPane.YES_OPTION) {
							  pst.executeUpdate();
				              JOptionPane.showMessageDialog(null, "Added cinema successfully.");
						}
					}
					
					SchedMovies sm = new SchedMovies();
	                sm.frame.setVisible(true);
	                frame.dispose();
					
				} catch(HeadlessException | SQLException x){
			        JOptionPane.showMessageDialog(null,x);
			        x.printStackTrace();
			        
			    } 
        	}
        });
        add_cinema.setVisible(false);
        add_cinema.setForeground(new Color(17, 34, 44));
        add_cinema.setFont(new Font("Poppins", Font.BOLD, 10));
        add_cinema.setBorderPainted(false);
        add_cinema.setBackground(new Color(246, 198, 36));
        add_cinema.setBounds(472, 292, 121, 29);
        panelw.add(add_cinema);
        
        add_cine = new JButton("Add Cinema");
        add_cine.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		cancel_addcine.setVisible(true);
        		add_cinema.setVisible(true);
        		add_cine.setVisible(false);
        		
        		cinemaN2.removeItem(cinemaN.getSelectedItem());
        		
        		lblcm2.setVisible(true);
        		cinemaN2.setVisible(true);
        		lblta2.setVisible(true);
        		times2.setVisible(true);
        	}
        });
        add_cine.setForeground(new Color(17, 34, 44));
        add_cine.setFont(new Font("Poppins", Font.BOLD, 10));
        add_cine.setBorderPainted(false);
        add_cine.setBackground(new Color(246, 198, 36));
        add_cine.setBounds(603, 292, 121, 29);
        panelw.add(add_cine);
        
        JLabel lblrectangle = new JLabel("");
        lblrectangle.setBounds(0, 0, 1010, 539);
        lblrectangle.setIcon(new ImageIcon (this.getClass().getResource("/images/background.png")));
        frame.getContentPane().add(lblrectangle);
	}
}
