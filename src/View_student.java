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
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_student extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_student frame = new View_student();
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
	public View_student() {
		con = DB.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Of Students");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblNewLabel.setBounds(119, 11, 229, 34);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 451, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Librarian_welcome a= new Librarian_welcome();
				a.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(102, 255, 51));
		btnNewButton.setFont(new Font("Traditional Arabic", Font.PLAIN, 21));
		btnNewButton.setBounds(321, 320, 116, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 468, 248);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Student Name", "User Id" ,"Father Name","Email Id / Phone No"
			}
		));
		int h ;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM student");
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
//					v2.add(r.getString("id"));
						//System.out.println(r.getString("id"));
					v2.add(r.getString("name"));
					//System.out.println(r.getString("name"));
				v2.add(r.getString("userid"));
				v2.add(r.getString("father"));
				v2.add(r.getString("email"));
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
