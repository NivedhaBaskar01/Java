package Ecommerce;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField n;
	private JTextField q;
	private JTextField p;
	private JTable table;
	private JTextField n1;
	private JTextField q1;
	private JTextField price1;
	private JTable uptable;
	private JTextField id;
	JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBorder(new EmptyBorder(0, 0, 0, 0));
		p2.setBackground(new Color(16, 37, 71));
		p2.setBounds(0, 0, 160, 653);
		contentPane.add(p2);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\customerlogo.jpg"));
		lblNewLabel_7.setBounds(21, 11, 120, 127);
		p2.add(lblNewLabel_7);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setForeground(new Color(255, 128, 64));
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdmin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblAdmin.setBounds(10, 138, 131, 32);
		p2.add(lblAdmin);
		
		JLabel lblNewLabel_6_4_2_1 = new JLabel("LOGOUT");
		lblNewLabel_6_4_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				home h=new home();
				h.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_6_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4_2_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4_2_1.setBounds(10, 575, 131, 46);
		p2.add(lblNewLabel_6_4_2_1);
		
		JLabel lblNewLabel_6_4_1 = new JLabel("UPDATE");
		lblNewLabel_6_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tabbedPane.setSelectedIndex(1);
			}
		});
		lblNewLabel_6_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4_1.setBounds(10, 337, 131, 46);
		p2.add(lblNewLabel_6_4_1);
		
		JLabel lblNewLabel_6_4 = new JLabel("ADD");
		lblNewLabel_6_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		lblNewLabel_6_4.setBounds(10, 263, 131, 46);
		p2.add(lblNewLabel_6_4);
		lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new EmptyBorder(0, 0, 0, 0));
		p1.setBackground(new Color(16, 37, 71));
		p1.setBounds(156, 0, 1125, 87);
		contentPane.add(p1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\logo.png"));
		lblNewLabel.setBounds(795, 0, 325, 83);
		p1.add(lblNewLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(156, 57, 1125, 596);
		contentPane.add(tabbedPane);
		
		JPanel add = new JPanel();
		add.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, add, null);
		add.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(16, 37, 71));
		comboBox.setForeground(new Color(255, 128, 0));
		comboBox.setFont(new Font("Consolas", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Groceries", "Fashion", "Gadgets", "Sports"}));
		comboBox.setBounds(10, 22, 301, 53);
		add.add(comboBox);
		
		JButton btnSlect = new JButton("SELECT");
		btnSlect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String t= comboBox.getSelectedItem().toString();
				DefaultTableModel dt=(DefaultTableModel) table.getModel();
				try {
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="select * from items where type='"+t+"'";
					ResultSet rs=st.executeQuery(q);
					//st.executeUpdate(q);
					dt.setRowCount(1);
					while(rs.next())
					{
						dt.addRow(new Object[] {rs.getString(1),rs.getInt(2),rs.getDouble(3)});
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSlect.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSlect.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSlect.setBounds(336, 24, 122, 43);
		add.add(btnSlect);
		
		n = new JTextField();
		n.setFont(new Font("Consolas", Font.BOLD, 16));
		n.setColumns(10);
		n.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		n.setBackground(new Color(244, 244, 244));
		n.setBounds(181, 122, 319, 49);
		add.add(n);
		
		q = new JTextField();
		q.setFont(new Font("Consolas", Font.BOLD, 16));
		q.setColumns(10);
		q.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		q.setBackground(new Color(244, 244, 244));
		q.setBounds(181, 227, 319, 49);
		add.add(q);
		
		p = new JTextField();
		p.setFont(new Font("Consolas", Font.BOLD, 16));
		p.setColumns(10);
		p.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		p.setBackground(new Color(244, 244, 244));
		p.setBounds(181, 332, 319, 49);
		add.add(p);
		
		JLabel lblNewLabel_2_1 = new JLabel("NAME");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(21, 122, 156, 62);
		add.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("QUANTITY");
		lblNewLabel_2_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(21, 218, 156, 62);
		add.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("PRICE");
		lblNewLabel_2_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_2.setBounds(21, 323, 156, 62);
		add.add(lblNewLabel_2_1_2);
		
		JButton btnSelect = new JButton("ADD");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String t= comboBox.getSelectedItem().toString();
				DefaultTableModel dt=(DefaultTableModel) table.getModel();
				try {
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String query="insert into items(itemname,available,price,type) values('"+n.getText()+"','"+Integer.parseInt(q.getText())+"','"+Double.parseDouble(p.getText())+"','"+t+"');";
					st.executeUpdate(query);
					dt.addRow(new Object[] {n.getText(),q.getText(),p.getText()});
					
					n.setText("");
					q.setText("");
					p.setText("");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSelect.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSelect.setBounds(23, 445, 122, 43);
		add.add(btnSelect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Consolas", Font.BOLD, 14));
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setBounds(568, 28, 542, 479);
		add.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//table
			}
		});
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setFont(new Font("Consolas", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ITEMNAME", "QUANTITY", "PRICE"
			}
		));
		table.setBackground(new Color(255, 255, 255));
		
		JPanel update = new JPanel();
		update.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, update, null);
		update.setLayout(null);
		
		final JComboBox combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"Groceries", "Fashion", "Gadgets", "Sports"}));
		combo.setForeground(new Color(255, 128, 0));
		combo.setFont(new Font("Consolas", Font.BOLD, 20));
		combo.setBackground(new Color(16, 37, 71));
		combo.setBounds(10, 11, 301, 53);
		update.add(combo);
		
		JButton select = new JButton("SELECT");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String t= combo.getSelectedItem().toString();
				DefaultTableModel dt=(DefaultTableModel) uptable.getModel();
				try {
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="select * from items where type='"+t+"'";
					ResultSet rs=st.executeQuery(q);
					//st.executeUpdate(q);
					dt.setRowCount(1);
					while(rs.next())
					{
						dt.addRow(new Object[] {rs.getInt(5),rs.getString(1),rs.getInt(2),rs.getDouble(3)});
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		select.setFont(new Font("Tahoma", Font.BOLD, 14));
		select.setBorder(new LineBorder(new Color(0, 0, 0)));
		select.setBounds(336, 13, 122, 43);
		update.add(select);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("NAME");
		lblNewLabel_2_1_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_3.setBounds(10, 204, 156, 62);
		update.add(lblNewLabel_2_1_3);
		
		n1 = new JTextField();
		n1.setFont(new Font("Consolas", Font.BOLD, 16));
		n1.setColumns(10);
		n1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		n1.setBackground(new Color(244, 244, 244));
		n1.setBounds(181, 213, 319, 49);
		update.add(n1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("QUANTITY");
		lblNewLabel_2_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 287, 156, 62);
		update.add(lblNewLabel_2_1_1_1);
		
		q1 = new JTextField();
		q1.setFont(new Font("Consolas", Font.BOLD, 16));
		q1.setColumns(10);
		q1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		q1.setBackground(new Color(244, 244, 244));
		q1.setBounds(181, 296, 319, 49);
		update.add(q1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("PRICE");
		lblNewLabel_2_1_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_2_1.setBounds(10, 360, 156, 62);
		update.add(lblNewLabel_2_1_2_1);
		
		price1 = new JTextField();
		price1.setFont(new Font("Consolas", Font.BOLD, 16));
		price1.setColumns(10);
		price1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		price1.setBackground(new Color(244, 244, 244));
		price1.setBounds(181, 364, 319, 49);
		update.add(price1);
		
		JButton Update = new JButton("UPDATE");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					
					String n=n1.getText();
					int q=Integer.parseInt(q1.getText());
					double p=Double.parseDouble(price1.getText());
					int i=Integer.parseInt(id.getText());
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String query="update items set itemname='"+n+"',available='"+q+"',price='"+p+"' where id='"+i+"'";
					st.executeUpdate(query);
					DefaultTableModel dt=(DefaultTableModel) uptable.getModel();
					dt.setRowCount(1);
					String t= combo.getSelectedItem().toString();
					
					String query1="select * from items where type='"+t+"'";
					ResultSet rs=st.executeQuery(query1);
						//st.executeUpdate(q);
						while(rs.next())
						{
							dt.addRow(new Object[] {rs.getInt(5),rs.getString(1),rs.getInt(2),rs.getDouble(3)});
						}
						
						
					id.setText("");
					n1.setText("");
					price1.setText("");
					q1.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		Update.setFont(new Font("Tahoma", Font.BOLD, 14));
		Update.setBorder(new LineBorder(new Color(0, 0, 0)));
		Update.setBounds(10, 442, 122, 43);
		update.add(Update);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(567, 44, 470, 441);
		update.add(scrollPane_1);
		
		uptable = new JTable();
		uptable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DefaultTableModel dt = (DefaultTableModel) uptable.getModel();
				int index=uptable.getSelectedRow();
				id.setText(uptable.getValueAt(index, 0).toString());
				n1.setText((String) uptable.getValueAt(index, 1));
				q1.setText(uptable.getValueAt(index, 2).toString());
				price1.setText(uptable.getValueAt(index, 3).toString());
				//System.out.println((String) uptable.getValueAt(index, 0));
			}
		});
		uptable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ITEMID", "NAME", "QUANTITY", "PRICE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		uptable.getColumnModel().getColumn(0).setResizable(false);
		uptable.getColumnModel().getColumn(0).setPreferredWidth(35);
		uptable.getColumnModel().getColumn(0).setMinWidth(14);
		uptable.getColumnModel().getColumn(1).setResizable(false);
		uptable.getColumnModel().getColumn(1).setPreferredWidth(100);
		uptable.getColumnModel().getColumn(1).setMinWidth(50);
		uptable.getColumnModel().getColumn(2).setResizable(false);
		uptable.getColumnModel().getColumn(3).setResizable(false);
		scrollPane_1.setViewportView(uptable);
		uptable.setShowVerticalLines(false);
		uptable.setShowHorizontalLines(false);
		uptable.setShowGrid(false);
		uptable.setFont(new Font("Consolas", Font.BOLD, 14));
		uptable.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("ITEM ID");
		lblNewLabel_2_1_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_3_1.setBounds(10, 113, 156, 62);
		update.add(lblNewLabel_2_1_3_1);
		
		id = new JTextField();
		id.setFont(new Font("Consolas", Font.BOLD, 16));
		id.setEnabled(false);
		id.setEditable(false);
		id.setColumns(10);
		id.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		id.setBackground(new Color(244, 244, 244));
		id.setBounds(181, 122, 319, 49);
		update.add(id);
		setExtendedState(MAXIMIZED_BOTH);
	}
}
