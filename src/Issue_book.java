import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Issue_book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue_book frame = new Issue_book();
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
	public Issue_book() {
		con =DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Issue");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblNewLabel.setBounds(173, 11, 221, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setForeground(new Color(255, 51, 102));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(29, 64, 121, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Id");
		lblNewLabel_2.setForeground(new Color(255, 51, 102));
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(29, 118, 121, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Student Name");
		lblNewLabel_3.setForeground(new Color(255, 51, 102));
		lblNewLabel_3.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(29, 175, 137, 32);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(218, 63, 228, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 115, 228, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 172, 228, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Student Id");
		lblNewLabel_4.setForeground(new Color(255, 51, 102));
		lblNewLabel_4.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(29, 237, 121, 24);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(218, 225, 228, 32);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(136, 33, 207, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Issue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname = textField.getText();
				String bookid = textField_1.getText();
				String studentname = textField_2.getText();
				String studentid = textField_3.getText();
				
				try {
					PreparedStatement pst1 = con.prepareStatement("Select * FROM issued_books where bookid =?");
					pst1.setString(1, bookid);
					ResultSet r = pst1.executeQuery();
					if(!r.next()) {
					JOptionPane.showConfirmDialog(null,"Do You Want To Issue This Book ? ");
					PreparedStatement pst = con.prepareStatement("insert into issued_books (bookid,bookname,studentid,studentname,date) values(?,?,?,?,?) ");
					Date date = java.util.Calendar.getInstance().getTime();
					DateFormat dateformat = new SimpleDateFormat("dd-M-yyyy");
					String date1  =  dateformat.format(date);
					
					System.out.println(date1);
					pst.setString(1, bookname);
					pst.setString(2, bookid);
					pst.setString(3, studentname);
					pst.setString(4, studentid);
					pst.setString(5, date1);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Issued Sucessfully !");
					textField.setText(" ");
					textField_1.setText(" ");
					textField_2.setText(" ");
					textField_3.setText(" ");
					}
					else
					{
						JOptionPane.showMessageDialog(null," This Book is already Issued to other .Please Select Other Book");
						textField.setText(" ");
						textField_1.setText(" ");
						textField_2.setText(" ");
						textField_3.setText(" ");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e);
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton.setBackground(Color.RED);
			}
		});
		btnNewButton.setBackground(new Color(153, 255, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(173, 295, 106, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(255,153,51));
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian_welcome d = new Librarian_welcome();
				d.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 153, 51));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(426, 337, 112, 32);
		contentPane.add(btnNewButton_1);
	}
}
