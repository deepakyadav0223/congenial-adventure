import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Admin_welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_welcome frame = new Admin_welcome();
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
	public Admin_welcome() {
		con = DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 255, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_librarian a = new Add_librarian();
				a.setVisible(true);
					dispose();
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 22));
		btnNewButton.setBounds(140, 111, 194, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Librarians");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List_librarian a = new List_librarian();
				a.setVisible(true);
				dispose();
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Rockwell", Font.PLAIN, 22));
		btnNewButton_1.setBounds(140, 189, 194, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Librarian");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_Librarian s = new Delete_Librarian();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Rockwell", Font.PLAIN, 21));
		btnNewButton_2.setBounds(141, 263, 193, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnNewButton_3.setBounds(390, 346, 121, 35);
		contentPane.add(btnNewButton_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 86, 490, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setForeground(new Color(255, 51, 0));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 36));
		lblNewLabel.setBounds(165, 32, 173, 43);
		contentPane.add(lblNewLabel);
		
	}

}
