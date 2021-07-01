import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Users_Of_The_System {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users_Of_The_System window = new Users_Of_The_System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Users_Of_The_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(152, 251, 152));
		frame.setBounds(100, 100, 597, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 27));
		lblNewLabel.setBounds(68, 11, 412, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 49, 521, 2);
		frame.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("Log In As Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Sign_up a  = new Admin_Sign_up();
				a.setVisible(true);
				
				
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 24));
		btnNewButton.setBounds(123, 78, 249, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log In As Liberian");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian_login s = new Librarian_login();
				s.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Rockwell", Font.PLAIN, 24));
		btnNewButton_1.setBounds(123, 172, 249, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log In As Student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_login a = new Student_login();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnNewButton_2.setBounds(123, 274, 249, 40);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Quit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnNewButton_3.setBounds(441, 349, 111, 34);
		frame.getContentPane().add(btnNewButton_3);
	}
}
