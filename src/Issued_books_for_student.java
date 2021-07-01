import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class Issued_books_for_student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issued_books_for_student frame = new Issued_books_for_student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con = null;
	public Issued_books_for_student() {
		con  = DB.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Borrowed Books");
		lblNewLabel.setForeground(new Color(255, 51, 153));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel.setBounds(202, 11, 196, 28);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(71, 39, 404, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Your User Id");
		lblNewLabel_1.setForeground(new Color(255, 102, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 52, 153, 32);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(183, 50, 251, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				try {
					PreparedStatement pst = con.prepareStatement("SELECT * FROM issued_books where studentid =?");
					pst.setString(1, s);
					ResultSet r = pst.executeQuery();
					//System.out.println(r);
					
					int h ;
					ResultSetMetaData rd = r.getMetaData();
					textField.setText("");
					h=  rd.getColumnCount();
					System.out.println(h);
					DefaultTableModel df = (DefaultTableModel) table.getModel();
					
					df.setRowCount(0);
					
					while(r.next())
				{		
						Vector v2 = new Vector();
					for(int i = 1;i<=h;i++)
					{
							v2.add(r.getString("bookid"));
								//System.out.println(r.getString("id"));
							v2.add(r.getString("bookname"));
							//System.out.println(r.getString("name"));
							v2.add(r.getString("studentname"));
							v2.add(r.getString("date"));
							String date = r.getString("date");
							DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
							Calendar cal = Calendar.getInstance();
					        cal.add(Calendar.DATE, 14);
					        Date todate1 = cal.getTime();    
					        String fromdate = dateFormat.format(todate1);
//					        
					        try {
					        
					        Date firstDate = dateFormat.parse(date);
					        Date secondDate = dateFormat.parse(fromdate);

					        long diff = secondDate.getTime() - firstDate.getTime();

					        TimeUnit time = TimeUnit.DAYS; 
					        long  diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
					        if(diffrence<(long)5) {
					        	
					        	 v2.add(fromdate);
					        	 JOptionPane.showMessageDialog(null,"You Have To Submit This Book With in "+String.valueOf(diffrence));
					        }
					        else
					        {
					        	v2.add(fromdate);
					        }
					        }
					        catch(Exception eh)
					        {
					        	JOptionPane.showMessageDialog(null,eh);
					        }
					        
					       

					       
							
					}
						df.addRow(v2);
//						
				}
					
			
//					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(204, 255, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(492, 52, 101, 32);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 110, 573, 233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book-Id", "Book Name", "Your Name", "Date Of Issue","Date Of Submission"
			}
		));
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_welcome a  =new Student_welcome();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(153, 255, 204));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(463, 360, 130, 34);
		contentPane.add(btnNewButton_1);
	}
}
