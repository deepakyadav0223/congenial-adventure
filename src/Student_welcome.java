import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_welcome frame = new Student_welcome();
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
	public Student_welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 35));
		lblNewLabel.setBounds(169, 11, 223, 46);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(100, 59, 292, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Available Books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_books_for_students a = new All_books_for_students();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(51, 255, 204));
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 21));
		btnNewButton.setBounds(134, 86, 223, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Your Issued Books");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issued_books_for_student s = new Issued_books_for_student();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(51, 255, 0));
		btnNewButton_1.setFont(new Font("Rockwell", Font.PLAIN, 19));
		btnNewButton_1.setBounds(134, 144, 223, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Requesting For Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Requesting_book a = new Requesting_book();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(0, 102, 204));
		btnNewButton_2.setFont(new Font("Rockwell", Font.PLAIN, 18));
		btnNewButton_2.setBounds(134, 201, 223, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_login d = new Student_login();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(153, 255, 102));
		btnNewButton_3.setFont(new Font("Rockwell", Font.PLAIN, 19));
		btnNewButton_3.setBounds(334, 302, 110, 43);
		contentPane.add(btnNewButton_3);
	}
}
