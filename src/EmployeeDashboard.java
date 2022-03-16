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
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;

public class EmployeeDashboard {

	JFrame frame;
	static JMenu user_account;
	JTextField avails;
	JTextField totalprice;
	JTextField price;
	private JTextField price_1;
	JTextField seatno;
	int seat_num = 100;
	JLabel date2day;
	private JLabel date2day2;
	JComboBox movie, timesA, cinemanoS;
	static String empName;
	static int empID;
	private JTextField movieTitlE;
	private JTextField timeS;
	private JTextField cinemanO;
	JTextField availableS;
	JTextField totalpricE;
	JTextField price2;
	JTextField cusNo;
	JTextField tadReserve;
	JTextField movieTitle, times2, cinemano2;
	JLabel customerNum;
	static int availables;
	static double totalprice2;
	private JPanel panel2;
	private JLabel lbltitle2;
	private JLabel lblmovie2;
	private JLabel lblprice2;
	private JLabel lbltimes2;
	private JLabel lblcinemas2;
	private JLabel lblavailable2;
	private JLabel lbltotal2;
	private JButton remove_btn2;

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
						date2day2.setText(date + "    " + hour + ":" + minute + ":" + second);
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
		
		timesA = new JComboBox();
		timesA.setEditable(true);
		timesA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(connectionUrl);) {  
					
					String selected = movie.getSelectedItem().toString();
					
					String sqlSelect = "SELECT * FROM SchedMovies\r\n"
							+ "JOIN Cinemas ON SchedMovies.MovieID = Cinemas.MovieID WHERE MovieTitle='" + selected + "'";
					
					PreparedStatement ps = connection.prepareStatement(sqlSelect);
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						cinemanoS.setSelectedItem(rs.getString("CinemaNo"));
					}
				}
				
				catch(HeadlessException | SQLException ex){
		            JOptionPane.showMessageDialog(null, ex);
		        }
			}
		});
		timesA.setBounds(205, 189, 665, 30);
		panel.add(timesA);
		
		cinemanoS = new JComboBox();
		cinemanoS.setEditable(true);
		cinemanoS.setBounds(205, 230, 665, 30);
		panel.add(cinemanoS);
		
		JLabel lbltitle = new JLabel("MOVIE TICKETS BOOKING");
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
		movie.setEditable(true);
		movie.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				try (Connection connection = DriverManager.getConnection(connectionUrl);) { 
					
					String selected = movie.getSelectedItem().toString();
					
					String sqlSelect = "SELECT * FROM SchedMovies\r\n"
							+ "JOIN Cinemas ON SchedMovies.MovieID = Cinemas.MovieID WHERE MovieTitle='" + selected + "'";
					
					PreparedStatement ps = connection.prepareStatement(sqlSelect);
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						price.setText(String.valueOf(rs.getDouble("Price")));
						avails.setText(String.valueOf(rs.getInt("SeatNo")));
						
						timesA.addItem(rs.getString("ShowTime"));
						cinemanoS.addItem(Integer.toString(rs.getInt("CinemaNo")));
						
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
		
		JLabel lbltimes = new JLabel("Times Available");
		lbltimes.setHorizontalAlignment(SwingConstants.TRAILING);
		lbltimes.setFont(new Font("Poppins", Font.BOLD, 13));
		lbltimes.setBounds(10, 197, 178, 14);
		panel.add(lbltimes);
		
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
		        String timeCB = (String) timesA.getSelectedItem();
		        String cinemaCB = (String) cinemanoS.getSelectedItem();
		        
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
					
					ps.setString(1, totalprice.getText());
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
				
				movieTitlE.setText(movieCB);
				price_1.setText(price.getText());
				totalpricE.setText(totalprice.getText());
				availableS.setText(avails.getText());
				tadReserve.setText(date);
				timeS.setText(timeCB);
				cinemanO.setText(cinemaCB);
				
				try (Connection connection = DriverManager.getConnection(connectionUrl)) {
				
				String sql = "SELECT MovieID FROM SchedMovies WHERE MovieTitle='" + movieCB + "'";
		        
		        PreparedStatement ps = connection.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();
		        
		        String id = "";
		        while (rs.next()) {
		        	id = rs.getString("MovieID");
		        }
		        
		        ps.executeQuery();
		        
		        String sQL = "SELECT * FROM Reservations WHERE MovieID='" + id + "'";
		        ps = connection.prepareStatement(sQL);
		        ResultSet rs2 = ps.executeQuery();
		        
		        String cn = "";
		        while (rs2.next()) {
		        	cn = rs2.getString("CustomerNo");
		        	cusNo.setText(cn);
		        }
		        
		        
				} catch(HeadlessException | SQLException x){
			        JOptionPane.showMessageDialog(null,x);
			        x.printStackTrace();
			        
			    } 
				
				panel2.setVisible(true);
				panel.setVisible(false);
				
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
		
		panel2 = new JPanel();
		panel2.setVisible(false);
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(42, 71, 912, 427);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		lbltitle2 = new JLabel("MOVIE TICKETS BOOKING");
		lbltitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle2.setBounds(205, 30, 509, 53);
		panel2.add(lbltitle2);
		lbltitle2.setFont(new Font("Poppins", Font.BOLD, 30));
		lbltitle2.setForeground(new Color(27, 43, 52));
		
		date2day2 = new JLabel("*Date Today*");
		date2day2.setHorizontalAlignment(SwingConstants.CENTER);
		date2day2.setForeground(new Color(27, 43, 52));
		date2day2.setFont(new Font("Poppins", Font.BOLD, 14));
		date2day2.setBounds(205, 15, 509, 22);
		panel2.add(date2day2);
		
		lblmovie2 = new JLabel("Movie");
		lblmovie2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblmovie2.setFont(new Font("Poppins", Font.BOLD, 13));
		lblmovie2.setBounds(10, 137, 178, 14);
		panel2.add(lblmovie2);
		
		lblprice2 = new JLabel("Price");
		lblprice2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblprice2.setFont(new Font("Poppins", Font.BOLD, 13));
		lblprice2.setBounds(10, 178, 178, 14);
		panel2.add(lblprice2);
		
		lbltimes2 = new JLabel("Times Available");
		lbltimes2.setHorizontalAlignment(SwingConstants.TRAILING);
		lbltimes2.setFont(new Font("Poppins", Font.BOLD, 13));
		lbltimes2.setBounds(10, 219, 178, 14);
		panel2.add(lbltimes2);
		
		lblcinemas2 = new JLabel("Cinema Number");
		lblcinemas2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblcinemas2.setFont(new Font("Poppins", Font.BOLD, 13));
		lblcinemas2.setBounds(10, 260, 178, 14);
		panel2.add(lblcinemas2);
		
		lblavailable2 = new JLabel("No. of Seats");
		lblavailable2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblavailable2.setFont(new Font("Poppins", Font.BOLD, 13));
		lblavailable2.setBounds(10, 301, 178, 14);
		panel2.add(lblavailable2);
		
		lbltotal2 = new JLabel("Total Price");
		lbltotal2.setHorizontalAlignment(SwingConstants.TRAILING);
		lbltotal2.setFont(new Font("Poppins", Font.BOLD, 13));
		lbltotal2.setBounds(10, 342, 178, 14);
		panel2.add(lbltotal2);
		
		availableS = new JTextField();
		availableS.setEditable(false);
		availableS.setBounds(205, 293, 665, 30);
		panel2.add(availableS);
		availableS.setColumns(10);
		
		totalpricE = new JTextField();
		totalpricE.setEditable(false);
		totalpricE.setColumns(10);
		totalpricE.setBounds(205, 334, 665, 30);
		panel2.add(totalpricE);
		
		price_1 = new JTextField();
		price_1.setEditable(false);
		price_1.setColumns(10);
		price_1.setBounds(205, 170, 665, 30);
		panel2.add(price_1);
		
		remove_btn2 = new JButton("OK");
		remove_btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Reservation completed!", "Message", JOptionPane.PLAIN_MESSAGE);
				panel2.setVisible(false);
				panel.setVisible(true);
			}
		});
		remove_btn2.setForeground(new Color(17, 34, 44));
		remove_btn2.setFont(new Font("Poppins", Font.BOLD, 13));
		remove_btn2.setBorderPainted(false);
		remove_btn2.setBackground(new Color(246, 198, 36));
		remove_btn2.setBounds(769, 384, 101, 30);
		panel2.add(remove_btn2);
		
		JLabel lblCustomerNo = new JLabel("Customer No.");
		lblCustomerNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCustomerNo.setFont(new Font("Poppins", Font.BOLD, 13));
		lblCustomerNo.setBounds(10, 96, 178, 14);
		panel2.add(lblCustomerNo);
		
		cusNo = new JTextField();
		cusNo.setEditable(false);
		cusNo.setColumns(10);
		cusNo.setBounds(205, 88, 178, 30);
		panel2.add(cusNo);
		
		JLabel lblDateAndTime = new JLabel("Date and Time of Reservation");
		lblDateAndTime.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateAndTime.setFont(new Font("Poppins", Font.BOLD, 13));
		lblDateAndTime.setBounds(379, 96, 230, 14);
		panel2.add(lblDateAndTime);
		
		tadReserve = new JTextField("");
		tadReserve.setEditable(false);
		tadReserve.setColumns(10);
		tadReserve.setBounds(619, 88, 251, 30);
		panel2.add(tadReserve);
		
		movieTitlE = new JTextField();
		movieTitlE.setEditable(false);
		movieTitlE.setColumns(10);
		movieTitlE.setBounds(205, 129, 665, 30);
		panel2.add(movieTitlE);
		
		timeS = new JTextField();
		timeS.setEditable(false);
		timeS.setColumns(10);
		timeS.setBounds(205, 211, 665, 30);
		panel2.add(timeS);
		
		cinemanO = new JTextField();
		cinemanO.setEditable(false);
		cinemanO.setColumns(10);
		cinemanO.setBounds(205, 252, 665, 30);
		panel2.add(cinemanO);
		
		customerNum = new JLabel("");
		customerNum.setBounds(205, 88, 178, 30);
		panel2.add(customerNum);
		
		JLabel lblrectangle = new JLabel("");
		lblrectangle.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		lblrectangle.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(lblrectangle);
		
	}
}
