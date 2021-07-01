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
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Delete_Librarian extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Librarian frame = new Delete_Librarian();
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
	public Delete_Librarian() {
		con = DB.dbconnect();
		setBackground(new Color(0, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Librarian");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblNewLabel.setBounds(168, 11, 261, 42);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 51, 471, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Name Of Librarian");
		lblNewLabel_1.setForeground(new Color(255, 51, 153));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 82, 184, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Id Of Librarian");
		lblNewLabel_2.setForeground(new Color(255, 51, 153));
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(36, 139, 184, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Your Password ");
		lblNewLabel_3.setForeground(new Color(255, 51, 153));
		lblNewLabel_3.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(36, 249, 203, 26);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(265, 82, 213, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(265, 139, 213, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String pass = passwordField.getText();
				String userid_lib = textField_1.getText();
				String user = textField_2.getText();
				try {
					PreparedStatement pst = con.prepareStatement("select * from sign where userid=? and password=?");
					pst.setString(1, user);
					pst.setString(2, pass);
					ResultSet r = pst.executeQuery();
					if(r.next())
					{
						PreparedStatement pst1 = con.prepareStatement("DELETE FROM libdetails where name = ? and userid=?");
						pst1.setString(1, name);
						pst1.setString(2, userid_lib);
						pst1.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"Librarian Deleted Successfully !");
						textField.setText(" ");
						passwordField.setText(" ");
						textField_1.setText(" ");
						textField_2.setText(" ");
						}
						
					else
					{
						JOptionPane.showMessageDialog(null, "Enter Your Correct Details");
					}
				}
				catch(Exception ef)
				{
					ef.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(102, 255, 255));
		btnNewButton.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		btnNewButton.setBounds(237, 316, 107, 32);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 246, 213, 29);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Your User Id");
		lblNewLabel_4.setForeground(new Color(255, 51, 153));
		lblNewLabel_4.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(36, 202, 172, 20);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(265, 196, 213, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_welcome a =  new Admin_welcome();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(153, 51, 153));
		btnNewButton_1.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
		btnNewButton_1.setBounds(477, 327, 107, 32);
		contentPane.add(btnNewButton_1);
	}
}
