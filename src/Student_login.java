import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Student_login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_login  frame = new Student_login ();
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
	
	public Student_login () {
		con =DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setForeground(new Color(51, 0, 204));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(122, 1, 130, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Id");
		lblNewLabel_1.setForeground(new Color(255, 51, 153));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(27, 60, 120, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 51, 153));
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(27, 123, 120, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String pass = passwordField.getText();
				
				try {
					PreparedStatement pst = con.prepareStatement("SELECT * FROM student where userid =? and password =?");
					pst.setString(1, user);
					pst.setString(2, pass);
					ResultSet r = pst.executeQuery();
					if(r.next()) {
						JOptionPane.showMessageDialog(null,"Welcome");
						dispose();
						Student_welcome a = new Student_welcome();
						a.setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Credential");
					}
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(153, 255, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(122, 176, 89, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have account . Please Contact to Librarian");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 230, 287, 31);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 204, 153));
		btnNewButton_1.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		btnNewButton_1.setBounds(307, 252, 113, 31);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(157, 60, 176, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 117, 175, 29);
		contentPane.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 403, 2);
		contentPane.add(separator);
	}
}
