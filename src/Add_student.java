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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add_student extends JFrame {

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
					Add_student frame = new Add_student();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,e);;
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con = null ;
	
	public Add_student() {
		con = DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
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
		
		JLabel lblNewLabel_3 = new JLabel("Father Name");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_3.setBounds(43, 186, 146, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email Id/Phone No.");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(24, 245, 205, 33);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(Color.RED);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
			String user = textField_1.getText();
			String father = textField_2.getText() ;
			String email = textField_3.getText();
			String password = passwordField.getText();
			
			try {
				PreparedStatement pst1 = con.prepareStatement("SELECT * FROM student where userid=? and password=? ");
				pst1.setString(1, user);
				pst1.setString(2, password);
				ResultSet r = pst1.executeQuery();
				if(r.next())
				{
					JOptionPane.showMessageDialog(null,"Student  already Registered!");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					passwordField.setText("");
				}
				else
				{
					JOptionPane.showConfirmDialog(null,"Do you want to add this student ?");
				PreparedStatement pst = con.prepareStatement("insert into student (name,userid,father,email,password) values(?,?,?,?,?) ");
				pst.setString(1,name);
				pst.setString(2,user);
				pst.setString(3,father);
				pst.setString(4,email);
				pst.setString(5,password);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Student Registered Succesfully !");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				passwordField.setText("");
				
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1);
			}
			
			
				
				
				
				
				
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 22));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(223, 367, 181, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.GREEN);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian_welcome c =  new Librarian_welcome();
				c.setVisible(true);
					dispose();
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnNewButton_1.setBounds(552, 389, 139, 37);
		contentPane.add(btnNewButton_1);
//		
		textField = new JTextField();
		textField.setBounds(252, 85, 257, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(252, 133, 257, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(252, 183, 257, 36);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(252, 247, 257, 37);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_5.setBounds(43, 305, 105, 37);
		contentPane.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(252, 305, 254, 37);
		contentPane.add(passwordField);
		
//		JLabel lblNewLabel_6 = new JLabel("Had Already Account ? Log In Now!\r\n");
//		lblNewLabel_6.setBackground(Color.WHITE);
//		lblNewLabel_6.setForeground(Color.BLACK);
//		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNewLabel_6.setBounds(466, 297, 225, 55);
//		contentPane.add(lblNewLabel_6);
	}
}
