import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin_login extends JFrame {

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
					Admin_login frame = new Admin_login();
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
	public Admin_login() {
		con =  DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 314);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Log In");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(109, 11, 199, 25);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 47, 339, 6);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("User Id");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(32, 64, 89, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(32, 120, 114, 25);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(201, 64, 170, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 121, 170, 30);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String pass = passwordField.getText();
				try {
					PreparedStatement pst1 = con.prepareStatement("select * from sign where userid=? and password=? ");
					pst1.setString(1, user);
					pst1.setString(2, pass);
					ResultSet r = pst1.executeQuery();
					if(r.next())
					{
						JOptionPane.showMessageDialog(null,"    Welcome    ");
						Admin_welcome a  = new Admin_welcome();
						
						a.setVisible(true);
						dispose();
//						textField.setText(" ");
//						passwordField.setText(" ");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"ERROR!! Enter Correct Details");
					}
				
			}
				catch(Exception h)
				{
					System.out.println(h);
				}
			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setBounds(124, 184, 122, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back to Sign Up");
		btnNewButton_1.setBackground(new Color(153, 50, 204));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.YELLOW);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Sign_up a = new Admin_Sign_up();
				a.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(289, 227, 155, 37);
		contentPane.add(btnNewButton_1);
	}

}
