import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Issued extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issued frame = new Issued();
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
	public Issued() {
		con=  DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 492);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issued Books");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 26));
		lblNewLabel.setBounds(242, 11, 258, 34);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 661, 327);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book Id", "Book Name", "Student Id", "Student Name", "Date Of Issue"
			}
		));
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian_welcome c = new Librarian_welcome();
				c.setVisible(true);
				dispose();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(Color.CYAN);
			}
		});
		btnNewButton.setBackground(new Color(51, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(479, 418, 111, 24);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(98, 43, 473, 2);
		contentPane.add(separator);
		
		try {
			PreparedStatement pst =  con.prepareStatement("SELECT * FROM issued_books");
			int h ;
			ResultSet r = pst.executeQuery();
		
			ResultSetMetaData rd = r.getMetaData();
		
			h=  rd.getColumnCount();
			System.out.println(h);
			DefaultTableModel df = (DefaultTableModel) table.getModel();
			
			df.setRowCount(0);
			
			while(r.next())
		{
				Vector v2 = new Vector();
			for(int i = 1;i<=h;i++)
			{
					v2.add(r.getString("bookid"));
						//System.out.println(r.getString("id"));
					v2.add(r.getString("bookname"));
					//System.out.println(r.getString("name"));
				v2.add(r.getString("studentid"));
				v2.add(r.getString("studentname"));
				v2.add(r.getString("date"));
				
				
			}
				df.addRow(v2);
//				
		}
			
//			
//			
//			
//			
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
