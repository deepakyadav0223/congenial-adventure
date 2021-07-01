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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Add_books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_books frame = new Add_books();
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
	public Add_books() {
		con = DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Book");
		lblNewLabel.setForeground(new Color(204, 0, 51));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(211, 11, 144, 26);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(87, 45, 445, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setForeground(new Color(153, 51, 204));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(37, 62, 144, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Name");
		lblNewLabel_2.setForeground(new Color(153, 102, 153));
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(37, 129, 118, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Subject ");
		lblNewLabel_3.setForeground(new Color(153, 102, 153));
		lblNewLabel_3.setFont(new Font("Rockwell", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(37, 200, 144, 26);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(216, 58, 230, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 116, 230, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-----Please Select----", "Computer Science", "Electronic and Communication Engineering", "Electrical Engineering", "Instrumentation and Control Engineering", "Mechanical Engineering", "Civil Engineering", "Chemical Engineering", "Textile Technology", "Others", ""}));
		comboBox.setBounds(211, 185, 235, 41);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id  = textField.getText();
				String name = textField_1.getText();
				String option  = (String) comboBox.getSelectedItem();
				
				
				try {
					
					PreparedStatement pst = con.prepareStatement("Select * from books where bookid=?" );
					pst.setString(1, id);
					ResultSet r = 	pst.executeQuery();
				if(!r.next()) {
					JOptionPane.showConfirmDialog(null,"Do You Want To Add This Book ?");
					PreparedStatement pst1 = con.prepareStatement("insert  into books(bookid,Bookname,Subject) values(?,?,?)" );
					pst1.setString(1, id);
					pst1.setString(2, name);
					pst1.setString(3, option);
					pst1.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Added Sucessfully");
					textField.setText("");
					textField_1.setText("" );
					comboBox.setSelectedIndex(0);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The Book with same id is already Present . Please check Book ID");
				}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.WHITE);;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(255, 0, 102));;
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(173, 288, 150, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.MAGENTA);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Librarian_welcome a = new Librarian_welcome();
				a.setVisible(true);
				
			}
		});
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(450, 358, 133, 31);
		contentPane.add(btnNewButton_1);
	}
}
