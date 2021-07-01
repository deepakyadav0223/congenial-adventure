import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Librarian_Requested extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian_Requested frame = new Librarian_Requested();
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
	Connection con =  null;
	public Librarian_Requested() {
		con  = DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Books Requested To Add In Library");
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 19));
		lblNewLabel.setBounds(151, 11, 366, 33);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(102, 42, 434, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 679, 301);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Book Name", "Subject", "Student Name"
			}
		));
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian_welcome a= new Librarian_welcome();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(588, 382, 112, 23);
		contentPane.add(btnNewButton);
		
		
		
		int h ;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM requestbook");
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
					v2.add(r.getString("id"));
						//System.out.println(r.getString("id"));
					v2.add(r.getString("Bookname"));
					//System.out.println(r.getString("name"));
					v2.add(r.getString("Subject"));
					v2.add(r.getString("user"));
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
