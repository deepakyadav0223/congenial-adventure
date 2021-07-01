import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Requesting_book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requesting_book frame = new Requesting_book();
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
	public Requesting_book() {
		con = DB.dbconnect();
		JComboBox comboBox ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 377);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"---------  Please Select  -------", "Computer Science", "Electronic and Communication Engineering", "Electrical Engineering", "Instrumentation and Control Engineering", "Mechanical Engineering", "Civil Engineering", "Chemical Engineering", "Textile Technology", "Others"}));
		comboBox.setBounds(183, 113, 250, 33);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Requesting For Books");
		lblNewLabel.setForeground(new Color(102, 51, 153));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(109, 11, 314, 35);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(72, 49, 403, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setForeground(new Color(255, 51, 102));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(32, 57, 103, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Subject");
		lblNewLabel_2.setForeground(new Color(255, 51, 102));
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(32, 126, 103, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Your User Id");
		lblNewLabel_3.setForeground(new Color(255, 51, 102));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(32, 186, 121, 26);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Request-Now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String subject = (String) comboBox.getSelectedItem();
				String user = textField_2.getText();
				try {
					PreparedStatement pst  =con.prepareStatement("select * from student where userid = ?");
					pst.setString(1,user);
					ResultSet r = pst.executeQuery();
					if(r.next())
					{
						PreparedStatement pst1  =con.prepareStatement("insert into requestbook (bookname,subject,user) values(?,?,?)");
						pst1.setString(1,name);
						pst1.setString(2,subject);
						pst1.setString(3,user);
						JOptionPane.showConfirmDialog(null, "Do You Want To Availabe  this Book In Library ?");
						pst1.executeUpdate();
						JOptionPane.showMessageDialog(null,"Your Request Made Sucessfully");
						textField.setText("");
						textField_2.setText(" ");
						comboBox.setSelectedIndex(0);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Your User Id");
					}
					
					
					
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(194, 249, 170, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go-Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_welcome a  = new Student_welcome();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 51));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(414, 297, 136, 30);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(183, 57, 250, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 182, 262, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		
		
		
		
		}
}
