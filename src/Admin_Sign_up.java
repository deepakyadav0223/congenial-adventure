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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin_Sign_up extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Sign_up frame = new Admin_Sign_up();
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
	Connection con = null ;
	
	public Admin_Sign_up() {
		con = DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Sign Up");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblNewLabel.setBounds(223, 11, 194, 31);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(43, 53, 575, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name ");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(43, 88, 134, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Id");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(43, 137, 105, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone No.");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_3.setBounds(43, 186, 119, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email Id");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(43, 251, 105, 20);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
			String user = textField_1.getText();
			String phone = textField_2.getText() ;
			String email = textField_3.getText();
			String password = passwordField.getText();
			
			try {
				PreparedStatement pst1 = con.prepareStatement("select * from sign where userid=? and password=? ");
				pst1.setString(1, user);
				pst1.setString(2, password);
				ResultSet r = pst1.executeQuery();
				if(r.next())
				{
					JOptionPane.showMessageDialog(null,"You had already Registered!");
//					Welcome a  = new Welcome();
//					a.setVisible(true);
				}
				else
				{
				PreparedStatement pst = con.prepareStatement("insert into sign(name,userid,phone,email,password) values(?,?,?,?,?) ");
				pst.setString(1,name);
				pst.setString(2,user);
				pst.setString(3,phone);
				pst.setString(4,email);
				pst.setString(5,password);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Submitted! You can login Now");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				passwordField.setText("");
				
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
				
				
				
				
				
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 22));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(222, 369, 119, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_login c =  new Admin_login();
				c.setVisible(true);
					dispose();
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnNewButton_1.setBounds(552, 389, 105, 37);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(187, 85, 257, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 137, 257, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 186, 257, 36);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 240, 257, 37);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_5.setBounds(43, 305, 105, 37);
		contentPane.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 297, 254, 37);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_6 = new JLabel("Had Already Account ? Log In Now!\r\n");
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(466, 297, 225, 55);
		contentPane.add(lblNewLabel_6);
	}
}
