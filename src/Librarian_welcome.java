import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Librarian_welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian_welcome frame = new Librarian_welcome();
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
	Connection con= null;
	public Librarian_welcome() {
		con = DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(203, 11, 196, 34);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 51, 434, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Add Students");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_student d = new Add_student();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(173, 255, 47));
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnNewButton.setBounds(160, 65, 221, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Students");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_student a = new View_student();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Rockwell", Font.PLAIN, 19));
		btnNewButton_1.setBackground(new Color(238, 130, 238));
		btnNewButton_1.setBounds(160, 126, 221, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Books");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_books a = new Add_books();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(127, 255, 0));
		btnNewButton_2.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnNewButton_2.setBounds(160, 185, 221, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Books");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_books a = new All_books();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(106, 90, 205));
		btnNewButton_3.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnNewButton_3.setBounds(160, 251, 221, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Librarian_login d  = new Librarian_login();
				d.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(new Color(64, 224, 208));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_4.setBounds(433, 407, 126, 34);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("View Issued Books");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issued a = new Issued();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBackground(new Color(102, 205, 170));
		btnNewButton_5.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnNewButton_5.setBounds(160, 314, 221, 39);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Issue Book");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issue_book a  = new Issue_book();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setBackground(new Color(102, 204, 255));
		btnNewButton_6.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnNewButton_6.setBounds(160, 375, 221, 39);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Requested Books");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian_Requested a=  new Librarian_Requested();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setBackground(new Color(0, 153, 204));
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_7.setBounds(0, 404, 150, 50);
		contentPane.add(btnNewButton_7);
	}
}
