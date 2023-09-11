package Ecommerce;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

public class delivery extends JFrame {

	private JPanel contentPane;
	JTextField dno;
	JTextField dname;
	JTextField demail;
	JTextField dphn;
	JTabbedPane delpane;
	private JTable table;
	private JTable t;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delivery frame = new delivery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public delivery(final int did) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 693);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new EmptyBorder(0, 0, 0, 0));
		p1.setBackground(new Color(16, 37, 71));
		p1.setBounds(171, 0, 1112, 87);
		contentPane.add(p1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\logo.png"));
		lblNewLabel.setBounds(787, 0, 325, 83);
		p1.add(lblNewLabel);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBorder(new EmptyBorder(0, 0, 0, 0));
		p2.setBackground(new Color(16, 37, 71));
		p2.setBounds(0, 0, 172, 653);
		contentPane.add(p2);
		
		JLabel lblNewLabel_6_4 = new JLabel("PROFILE");
		lblNewLabel_6_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				delpane.setSelectedIndex(0);
			}
		});
		lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4.setBounds(10, 205, 152, 46);
		p2.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_4_1 = new JLabel("PICK ORDERS");
		lblNewLabel_6_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				delpane.setSelectedIndex(1);
				try {
					DefaultTableModel dt = (DefaultTableModel) table.getModel();
					dt.setRowCount(1);
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="select * from delivery where status='Ordered';";
					ResultSet rs=st.executeQuery(q);
					
						while(rs.next())
						{
						dt.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7)});
						
						}
						
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_6_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4_1.setBounds(0, 296, 162, 46);
		p2.add(lblNewLabel_6_4_1);
		
		JLabel lblNewLabel_6_4_2 = new JLabel("UPDATE STATUS");
		lblNewLabel_6_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				delpane.setSelectedIndex(2);
				try {
					DefaultTableModel dt = (DefaultTableModel) t.getModel();
					dt.setRowCount(1);
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="select * from delivery where delid='"+did+"' and status='PickedUp'";
					ResultSet rs=st.executeQuery(q);
					
						while(rs.next())
						{
						dt.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7)});
						
						}
						
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_6_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4_2.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4_2.setBounds(10, 380, 152, 46);
		p2.add(lblNewLabel_6_4_2);
		
		JLabel lblNewLabel_6_4_2_1 = new JLabel("LOGOUT");
		lblNewLabel_6_4_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				new home().setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_6_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4_2_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4_2_1.setBounds(10, 575, 131, 46);
		p2.add(lblNewLabel_6_4_2_1);
		
	    delpane = new JTabbedPane(JTabbedPane.TOP);
		delpane.setBounds(171, 60, 1112, 596);
		contentPane.add(delpane);
		
		JPanel profile = new JPanel();
		profile.setBackground(new Color(255, 255, 255));
		delpane.addTab("New tab", null, profile, null);
		profile.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(10, 7, 120, 115);
		profile.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\customerlogo.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel("PROFILE");
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(193, 21, 286, 70);
		profile.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID NUMBER");
		lblNewLabel_2.setFont(new Font("Algerian", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(25, 157, 128, 57);
		profile.add(lblNewLabel_2);
		
		JLabel l2 = new JLabel("NAME");
		l2.setHorizontalAlignment(SwingConstants.TRAILING);
		l2.setFont(new Font("Algerian", Font.PLAIN, 20));
		l2.setBounds(25, 255, 100, 57);
		profile.add(l2);
		
		JLabel l3 = new JLabel("EMAIL");
		l3.setHorizontalAlignment(SwingConstants.TRAILING);
		l3.setFont(new Font("Algerian", Font.PLAIN, 20));
		l3.setBounds(30, 344, 100, 57);
		profile.add(l3);
		
		JLabel l4 = new JLabel("PHONE");
		l4.setHorizontalAlignment(SwingConstants.TRAILING);
		l4.setFont(new Font("Algerian", Font.PLAIN, 20));
		l4.setBounds(25, 438, 100, 57);
		profile.add(l4);
		
		dno = new JTextField();
		dno.setFont(new Font("KareliaWeb Bold", Font.BOLD, 15));
		dno.setEditable(false);
		dno.setColumns(10);
		dno.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		dno.setBackground(new Color(244, 244, 244));
		dno.setBounds(193, 157, 319, 49);
		profile.add(dno);
		
		dname = new JTextField();
		dname.setFont(new Font("KareliaWeb Bold", Font.BOLD, 15));
		dname.setEditable(false);
		dname.setColumns(10);
		dname.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		dname.setBackground(new Color(244, 244, 244));
		dname.setBounds(193, 255, 319, 49);
		profile.add(dname);
		
		demail = new JTextField();
		demail.setFont(new Font("KareliaWeb Bold", Font.BOLD, 15));
		demail.setEditable(false);
		demail.setColumns(10);
		demail.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		demail.setBackground(new Color(244, 244, 244));
		demail.setBounds(193, 352, 319, 49);
		profile.add(demail);
		
		dphn = new JTextField();
		dphn.setFont(new Font("KareliaWeb Bold", Font.BOLD, 15));
		dphn.setEditable(false);
		dphn.setColumns(10);
		dphn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		dphn.setBackground(new Color(244, 244, 244));
		dphn.setBounds(193, 438, 319, 49);
		profile.add(dphn);
		
		JButton btnNewButton = new JButton("CHANGE PASSWORD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String pass;
				pass = JOptionPane.showInputDialog("Enter the new password");
				Connection con;
				try {
					con = jdbc.getCon();
					Statement st = con.createStatement();
					String query ="update dpartner set dpass = '"+pass+"' where delid='"+did+"'";
					st.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"New Password Updated");
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 13));
		btnNewButton.setBounds(593, 155, 134, 43);
		profile.add(btnNewButton);
		
		JPanel view = new JPanel();
		view.setBackground(new Color(255, 255, 255));
		delpane.addTab("New tab", null, view, null);
		view.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ORDERS AVAILABLE FOR PICKUP");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_3.setBackground(new Color(245, 245, 245));
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_3.setBounds(21, 11, 332, 52);
		view.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 74, 983, 355);
		view.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ORDER ID", "NAME", "ADDRESS", "PHONE", "STATUS"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		
		JButton btnPickOrder = new JButton("PICK ORDER");
		btnPickOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int s=table.getSelectedRow();
				String oid=table.getValueAt(s, 0).toString();
				try
				{
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="update delivery set delid='"+did+"' where orderid='"+oid+"'";
					st.executeUpdate(q);
					Statement st1 = con.createStatement();
					String query="update delivery set status='PickedUp' where orderid='"+oid+"'";
					st1.executeUpdate(query);
					DefaultTableModel dt = (DefaultTableModel) table.getModel();
					dt.removeRow(s);
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnPickOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPickOrder.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPickOrder.setBounds(21, 453, 122, 43);
		view.add(btnPickOrder);
		
		JPanel update = new JPanel();
		update.setBackground(new Color(255, 255, 255));
		delpane.addTab("New tab", null, update, null);
		update.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("YOUR ORDERS");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_3_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_3_1.setBackground(new Color(245, 245, 245));
		lblNewLabel_3_1.setBounds(10, 11, 169, 52);
		update.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 86, 1048, 344);
		update.add(scrollPane_1);
		
		t = new JTable();
		scrollPane_1.setViewportView(t);
		t.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ORDER ID", "NAME", "ADDRESS", "PHONE", "STATUS"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		t.getColumnModel().getColumn(0).setResizable(false);
		t.getColumnModel().getColumn(0).setPreferredWidth(50);
		t.getColumnModel().getColumn(1).setResizable(false);
		t.getColumnModel().getColumn(2).setResizable(false);
		t.getColumnModel().getColumn(2).setPreferredWidth(300);
		t.getColumnModel().getColumn(3).setResizable(false);
		t.getColumnModel().getColumn(4).setResizable(false);
		t.setShowVerticalLines(false);
		t.setShowHorizontalLines(false);
		t.setShowGrid(false);
		t.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		
		JButton btnDeliverOrder = new JButton("DELIVER ORDER");
		btnDeliverOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int s=t.getSelectedRow();
				String oid=t.getValueAt(s, 0).toString();
				try
				{
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
				    String query="update delivery set status='Delivered' where orderid='"+oid+"'";
					st.executeUpdate(query);
					DefaultTableModel dt = (DefaultTableModel) t.getModel();
					dt.removeRow(s);
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnDeliverOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeliverOrder.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDeliverOrder.setBounds(10, 459, 122, 43);
		update.add(btnDeliverOrder);
		
	}
}
