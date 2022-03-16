import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmployeeDashboard {

	JFrame frame;
	static JMenu user_account;
	JTextField avails;
	JTextField totalprice;
	JTextField price;
	JTextField seatno;
	int seat_num = 100;
	JLabel date2day;
	JComboBox movie, times, cinemano;
	static String empName;
	static int empID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDashboard window = new EmployeeDashboard();
					window.frame.setVisible(true);
					window.setName(empID, empName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeDashboard() {
		initialize();
		curDateTime();
		CBFill();
	}
	
	DetailOverview deets = new DetailOverview();
	
	public void setName (int empID, String empName){
		this.empID = empID;
		this.empName = empName;
	}
	
	public void curDateTime() {
		
		Thread curDateTime = new Thread() {
			public void run() {
				try {
					while (true) {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		                Date dateToday = new Date(); 
		                String date = formatter.format(dateToday);
						
						Calendar cal = new GregorianCalendar();
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						date2day.setText(date + "    " + hour + ":" + minute + ":" + second);
						sleep(1000);
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		curDateTime.start();
	}
	
	public void CBFill() {
		try (Connection connection = DriverManager.getConnection(connectionUrl);) {  
			
			String sqlSelect = "SELECT * FROM SchedMovies JOIN Cinemas ON SchedMovies.MovieID = Cinemas.MovieID;";
			
			PreparedStatement ps = connection.prepareStatement(sqlSelect);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				movie.addItem(rs.getString("MovieTitle"));
				times.addItem(rs.getString("ShowTime"));
				cinemano.addItem(Integer.toString(rs.getInt("CinemaNo")));
			}
			
		}
		
		catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
	}
	
	static String connectionUrl = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName = MTRS;"
			+ "username = sa;"
			+ "password = inmainmainma;"
			+ ";encrypt = true;trustServerCertificate = true;";

	DetailOverview deetO = new DetailOverview();
	
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(42, 71, 912, 427);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbltitle = new JLabel("ONLINE MOVIE TICKETS BOOKING");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setBounds(205, 30, 509, 53);
		panel.add(lbltitle);
		lbltitle.setFont(new Font("Poppins", Font.BOLD, 30));
		lbltitle.setForeground(new Color(27, 43, 52));
		
		date2day = new JLabel("*Date Today*");
		date2day.setHorizontalAlignment(SwingConstants.CENTER);
		date2day.setForeground(new Color(27, 43, 52));
		date2day.setFont(new Font("Poppins", Font.BOLD, 14));
		date2day.setBounds(205, 15, 509, 22);
		panel.add(date2day);
		
		movie = new JComboBox();
		movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {  
					
					String selected = movie.getSelectedItem().toString();
					
					String sqlSelect = "SELECT * FROM SchedMovies\r\n"
							+ "JOIN Cinemas ON SchedMovies.MovieID = Cinemas.MovieID WHERE MovieTitle='" + selected + "'";
					
					PreparedStatement ps = connection.prepareStatement(sqlSelect);
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						price.setText(String.valueOf(rs.getDouble("Price")));
						avails.setText(String.valueOf(rs.getInt("SeatNo")));
					}
				}
				
				catch(HeadlessException | SQLException ex){
		            JOptionPane.showMessageDialog(null, ex);
		        }
			}
		});
		movie.setBounds(205, 107, 665, 30);
		panel.add(movie);
		
		JLabel lblmovie = new JLabel("Movie");
		lblmovie.setHorizontalAlignment(SwingConstants.TRAILING);
		lblmovie.setFont(new Font("Poppins", Font.BOLD, 13));
		lblmovie.setBounds(10, 115, 178, 14);
		panel.add(lblmovie);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblprice.setFont(new Font("Poppins", Font.BOLD, 13));
		lblprice.setBounds(10, 156, 178, 14);
		panel.add(lblprice);
		
		times = new JComboBox();
		times.setBounds(205, 189, 665, 30);
		panel.add(times);
		
		JLabel lbltimes = new JLabel("Times Available");
		lbltimes.setHorizontalAlignment(SwingConstants.TRAILING);
		lbltimes.setFont(new Font("Poppins", Font.BOLD, 13));
		lbltimes.setBounds(10, 197, 178, 14);
		panel.add(lbltimes);
		
		cinemano = new JComboBox();
		cinemano.setBounds(205, 230, 665, 30);
		panel.add(cinemano);
		
		JLabel lblcinemas = new JLabel("Cinema Number");
		lblcinemas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblcinemas.setFont(new Font("Poppins", Font.BOLD, 13));
		lblcinemas.setBounds(10, 238, 178, 14);
		panel.add(lblcinemas);
		
		JLabel lblavailable = new JLabel("Available Seats");
		lblavailable.setHorizontalAlignment(SwingConstants.TRAILING);
		lblavailable.setFont(new Font("Poppins", Font.BOLD, 13));
		lblavailable.setBounds(10, 279, 178, 14);
		panel.add(lblavailable);
		
		JLabel lbltotal = new JLabel("Total Price");
		lbltotal.setHorizontalAlignment(SwingConstants.TRAILING);
		lbltotal.setFont(new Font("Poppins", Font.BOLD, 13));
		lbltotal.setBounds(10, 320, 178, 14);
		panel.add(lbltotal);
		
		JLabel lblseatno = new JLabel("No. of Seats");
		lblseatno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblseatno.setFont(new Font("Poppins", Font.BOLD, 13));
		lblseatno.setBounds(390, 279, 144, 14);
		panel.add(lblseatno);
		
		avails = new JTextField();
		avails.setBounds(205, 271, 224, 30);
		panel.add(avails);
		avails.setColumns(10);
		
		totalprice = new JTextField();
		totalprice.setColumns(10);
		totalprice.setBounds(205, 312, 665, 30);
		panel.add(totalprice);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(205, 148, 665, 30);
		panel.add(price);
		
		JButton remove_btn = new JButton("Reserve");
		remove_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
                Date dateToday = new Date(); 
                String date = formatter.format(dateToday);
				
				String movieCB = (String) movie.getSelectedItem();
		        String timeCB = (String) times.getSelectedItem();
		        String cinemaCB = (String) cinemano.getSelectedItem();
		        
		        int availseats = Integer.parseInt(avails.getText());
		        int numSeats = Integer.parseInt(seatno.getText());
		        
		        int diff =  availseats - numSeats;
		        

				try (Connection connection = DriverManager.getConnection(connectionUrl)){
					
					String sql = "SELECT MovieID FROM SchedMovies WHERE MovieTitle='" + movieCB + "'";
			        
			        PreparedStatement ps = connection.prepareStatement(sql);
			        ResultSet rs = ps.executeQuery();
			        
			        String id = "";
			        while (rs.next()) {
			        	id = rs.getString("MovieID");
			        }
					
					String query2 = "INSERT INTO Reservations (Price, ShowTime, CinemaNo, MovieID, ReservedSeats, EmpID, TimeNDate)"
							+ "VALUES (?,?,?,?,?,?,?)";
					ps = connection.prepareStatement(query2);
					
					ps.setString(1, price.getText());
					ps.setString(2, timeCB);
					ps.setString(3, cinemaCB);
					ps.setString(4, id);
					ps.setInt(5, numSeats);
					ps.setInt(6, empID);
					ps.setString(7, date);
					
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION); {
						if (input == JOptionPane.YES_OPTION) {
							  ps.executeUpdate();
							  
							  String sqlQuery = "UPDATE Cinemas SET SeatNo=? WHERE MovieID='" + id + "'";      
								
							  ps = connection.prepareStatement(sqlQuery);
							
							  ps.setInt(1, diff);

							  ps.executeUpdate();
				              JOptionPane.showMessageDialog(null, "Added successfully.");
						}
					}
					
				} catch(HeadlessException | SQLException x){
			        JOptionPane.showMessageDialog(null,x);
			        x.printStackTrace();
			        
			    } 
				
				DetailOverview detail = new DetailOverview();
				detail.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		remove_btn.setForeground(new Color(17, 34, 44));
		remove_btn.setFont(new Font("Poppins", Font.BOLD, 13));
		remove_btn.setBorderPainted(false);
		remove_btn.setBackground(new Color(246, 198, 36));
		remove_btn.setBounds(702, 365, 168, 30);
		panel.add(remove_btn);
		
		seatno = new JTextField();
		seatno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				double pricee = Double.parseDouble(price.getText());
				double seatNum = Double.parseDouble(seatno.getText());
				double tp = pricee * seatNum;
				totalprice.setText(String.valueOf(tp));
			}
		});
		seatno.setColumns(10);
		seatno.setBounds(546, 271, 324, 30);
		panel.add(seatno);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		lblrectangle.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(lblrectangle);
		
	}
}
