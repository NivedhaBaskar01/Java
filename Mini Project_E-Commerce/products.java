package Ecommerce;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

//import frames.bill;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SpinnerNumberModel;

public class products extends JFrame {

	private JPanel contentPane;
	private JTable table,t;
	private JTextField total;
	static int f=0;
	String tot;
	JTabbedPane content ;
	JLabel namelbl;
	ArrayList<String> itemname = new ArrayList<String>(); 
	ArrayList<Integer> itemquantity = new ArrayList<Integer>(); 
	ArrayList<Double> itemprice = new ArrayList<Double>(); 
	ArrayList<Integer> avail = new ArrayList<Integer>();
	 
	private JTable gtable;
	private JTable ftable;
	private JTable gatable;
	private JTable stable;
	final JSpinner gqn ;
	final JSpinner fqn ;
	final JSpinner gaqn ;
	final JSpinner sqn ;
	String oid;

	/**
	 * Launch the application.
	 */
	public void addtable(int id,String Name,int Qty,Double Price)
	{
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		DecimalFormat df=new DecimalFormat("00.00");
		String totPrice = df.format(Price);
		Vector v=new Vector();
		v.add(Name);
		v.add(Qty);
		v.add(totPrice);
		dt.addRow(v);
		Connection con;
		try {
			con = jdbc.getCon();
			Statement st = con.createStatement();
			String q="insert into cart(cid,itemname,quantity,price) values('"+id+"','"+Name+"','"+Qty+"','"+Price+"');";
			st.executeUpdate(q);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void cal()
	{
		
		int numRow=table.getRowCount();
		double tot=0.0;
		for(int j=1;j<numRow;j++)
		{
			double value=Double.valueOf(table.getValueAt(j, 2).toString());
			tot+=value;
		}
		
		DecimalFormat df=new DecimalFormat("00.00");
		total.setText(df.format(tot));
	}
	

	public void cart(int cusid)
	{
		
		try {
			DefaultTableModel dt = (DefaultTableModel) table.getModel();
			Connection con = jdbc.getCon();
			Statement st = con.createStatement();
			String q="select * from cart where cid='"+cusid+"';";
			ResultSet rs=st.executeQuery(q);
			while(rs.next())
			{
				String query1="select * from items where itemname='"+rs.getString("itemname")+"'";
				Statement st1 = con.createStatement();
				ResultSet rs1=st1.executeQuery(query1);
				rs1.next();
				//System.out.println(rs1);
				if(rs1.getInt(2)>0)
				dt.addRow(new Object[] {rs.getString("itemname"),rs.getInt("quantity"),rs.getDouble("price")});
				cal();
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	
	
	public products(final String n, final int cusid) {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1298, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBorder(new EmptyBorder(0, 0, 0, 0));
		p1.setBackground(new Color(16, 37, 71));
		p1.setBounds(158, 0, 1125, 87);
		contentPane.add(p1);
		p1.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\logo.png"));
		lblNewLabel.setBounds(795, 0, 325, 83);
		p1.add(lblNewLabel);
		
		content = new JTabbedPane(JTabbedPane.TOP);
		content.setBounds(159, 47, 564, 606);
		contentPane.add(content);
		JLabel lblNewLabel_6 = new JLabel("GROCERIES");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				content.setSelectedIndex(0);
				
			}
		});
		lblNewLabel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6.setForeground(new Color(255, 128, 64));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(0, 51, 131, 32);
		p1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("FASHION");
		lblNewLabel_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				content.setSelectedIndex(1);
			}
		});
		lblNewLabel_6_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_1.setBounds(142, 51, 131, 32);
		p1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("GADGETS");
		lblNewLabel_6_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				content.setSelectedIndex(2);
			}
		});
		lblNewLabel_6_2.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_2.setBounds(283, 51, 131, 32);
		p1.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("SPORTS");
		lblNewLabel_6_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				content.setSelectedIndex(3);
			}
		});
		lblNewLabel_6_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_3.setBounds(429, 51, 131, 32);
		p1.add(lblNewLabel_6_3);
		
		JPanel p2 = new JPanel();
		p2.setBorder(new EmptyBorder(0, 0, 0, 0));
		p2.setBackground(new Color(16, 37, 71));
		p2.setBounds(0, 0, 160, 653);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JLabel lblNewLabel_6_4 = new JLabel("SHOP");
		lblNewLabel_6_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4.setBounds(10, 262, 131, 46);
		p2.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_4_1 = new JLabel("TRACK");
		lblNewLabel_6_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				new track(cusid,n).setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_6_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4_1.setBounds(10, 349, 131, 46);
		p2.add(lblNewLabel_6_4_1);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\customerlogo.jpg"));
		lblNewLabel_7.setBounds(21, 11, 120, 127);
		p2.add(lblNewLabel_7);
		
		JLabel namelbl = new JLabel(n);
		namelbl.setHorizontalAlignment(SwingConstants.CENTER);
		namelbl.setForeground(new Color(255, 128, 64));
		namelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		namelbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		namelbl.setBounds(10, 141, 131, 32);
		p2.add(namelbl);
		
		JLabel lblNewLabel_6_4_2 = new JLabel("MY CART");
		lblNewLabel_6_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				cart(cusid);
			}
		});
		lblNewLabel_6_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4_2.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4_2.setBounds(10, 437, 131, 46);
		p2.add(lblNewLabel_6_4_2);
		
		JLabel lblNewLabel_6_4_2_1 = new JLabel("LOGOUT");
		lblNewLabel_6_4_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				home home = new home();
				home.setVisible(true);
			    dispose();
				//setVisible(false);
			}
		});
		lblNewLabel_6_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4_2_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4_2_1.setBounds(10, 575, 131, 46);
		p2.add(lblNewLabel_6_4_2_1);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(255, 255, 255));
		//ImageIcon icon = new ImageIcon("icon.gif");
		content.addTab("GROCERIES",null, panel, null);
		//tabbedPane.addTab(getTitle(), null, panel, getTitle());;
		panel.setLayout(null);
		
		try
		{
			Connection con = jdbc.getCon();
			Statement st = con.createStatement();
			String query1="select available from items where id=1 or id=2 or id=3 or id=4 or id=9 or id=10 "
					+ "or id=11 or id=12 or id=14 or id=15 or id=16 or id=17 or id=18 or id=19 or id=20 or id=21";
			ResultSet rs=st.executeQuery(query1);
			while(rs.next())
			{
				avail.add(rs.getInt(1));
			}
			
		}
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(avail);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\sugar.jpg"));
		lblNewLabel_1.setBounds(10, 11, 176, 117);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("SUGAR 1KG");
		lblNewLabel_3.setBackground(new Color(192, 192, 192));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(20, 139, 99, 25);
		panel.add(lblNewLabel_3);
		
		final JSpinner sugarqn = new JSpinner();
		sugarqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(0), Integer.valueOf(1)));
		sugarqn.setBounds(119, 139, 66, 27);
		panel.add(sugarqn);
		
		final JButton sugarbt = new JButton("ADD TO CART");
		sugarbt.setBackground(new Color(240, 240, 240));
		sugarbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		if(avail.get(0)<=0)
			{
				sugarbt.setText("OUT OF STOCK");
				sugarbt.setEnabled(false);
				
			}
		else
			{
				sugarbt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						int i=(Integer)sugarqn.getValue();
						
						
						if(i!=0)
						{
						addtable(cusid,"SUGAR 1KG",i,50.00*i);
						cal();
						sugarqn.setValue(0);
						}
						else
						{
							JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
						}
					}
				});
			}
		
		
	
		sugarbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		sugarbt.setBounds(30, 185, 131, 23);
		panel.add(sugarbt);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\apples.jpg"));
		lblNewLabel_2.setBounds(342, 11, 158, 117);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("APPLE 1KG");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(343, 139, 74, 25);
		panel.add(lblNewLabel_3_1);
		
		final JSpinner appleqn = new JSpinner();
		appleqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(1), Integer.valueOf(1)));
		appleqn.setBounds(419, 139, 66, 27);
		panel.add(appleqn);
		
		final JButton applebt = new JButton("ADD TO CART");
		applebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		applebt.setBackground(new Color(240, 240, 240));
		applebt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		if(avail.get(1)<=0)
		{
			applebt.setText("OUT OF STOCK");
			applebt.setEnabled(false);
			
		}
		else
		{
		applebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)appleqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"APPLE 1KG",i,100.00*i);
				cal();
				appleqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		applebt.setFont(new Font("Tahoma", Font.BOLD, 13));
		applebt.setBounds(352, 185, 131, 23);
		panel.add(applebt);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\onion.jpg"));
		lblNewLabel_4.setBounds(20, 282, 176, 117);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_2 = new JLabel("ONION 1KG");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(30, 410, 89, 25);
		panel.add(lblNewLabel_3_2);
		
		final JSpinner onionqn = new JSpinner();
		onionqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(2), Integer.valueOf(1)));
		onionqn.setBounds(119, 408, 66, 27);
		panel.add(onionqn);
		
		final JButton onionbt = new JButton("ADD TO CART");
		onionbt.setBackground(new Color(240, 240, 240));
		
			
		onionbt.setBorder(new LineBorder(new Color(0, 0, 0)));
		if(avail.get(2)<=0)
		{
			onionbt.setText("OUT OF STOCK");
			onionbt.setEnabled(false);
			
		}
		else
		{
		onionbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)onionqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"ONION 1KG",i,30.00*i);
				cal();
				onionqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		onionbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		onionbt.setBounds(40, 456, 131, 27);
		panel.add(onionbt);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\rice.jpg"));
		lblNewLabel_5.setBounds(340, 282, 158, 117);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_3 = new JLabel("RICE 1KG");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(342, 410, 75, 25);
		panel.add(lblNewLabel_3_3);
		
		final JSpinner riceqn = new JSpinner();
		riceqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(3), Integer.valueOf(1)));
		riceqn.setBounds(431, 408, 66, 27);
		panel.add(riceqn);
		
		final JButton ricebt = new JButton("ADD TO CART");
		ricebt.setBackground(new Color(240, 240, 240));
		ricebt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		if(avail.get(3)<=0)
		{
			ricebt.setText("OUT OF STOCK");
			ricebt.setEnabled(false);
			
		}
		else
		{
		ricebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				int i=(Integer)riceqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"RICE 1KG",i,150.00*i);
				cal();
				riceqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		ricebt.setFont(new Font("Tahoma", Font.BOLD, 13));
		ricebt.setBounds(352, 456, 131, 23);
		panel.add(ricebt);
		
		JButton btnViewSimilarProducts = new JButton("VIEW SIMILAR PRODUCTS ->");
		btnViewSimilarProducts.setBackground(new Color(240, 240, 240));
		btnViewSimilarProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				content.setSelectedIndex(4);
				String t= "Groceries";
				DefaultTableModel dt=(DefaultTableModel) gtable.getModel();
				try {
					dt.setRowCount(1);
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="select * from items where type='"+t+"'";
					ResultSet rs=st.executeQuery(q);
					//st.executeUpdate(q);
					//dt.setRowCount(1);
					while(rs.next())
					{
						gqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(rs.getInt(2)), Integer.valueOf(1)));
						
						if(rs.getInt(2)>0)
						{
						dt.addRow(new Object[] {rs.getString(1),rs.getDouble(3)});
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewSimilarProducts.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewSimilarProducts.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnViewSimilarProducts.setBounds(340, 516, 203, 32);
		panel.add(btnViewSimilarProducts);
		
		JLabel lblNewLabel_3_16 = new JLabel("₹50");
		lblNewLabel_3_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_16.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_16.setBounds(20, 159, 74, 25);
		panel.add(lblNewLabel_3_16);
		
		JLabel lblNewLabel_3_16_1 = new JLabel("₹100");
		lblNewLabel_3_16_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_16_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_16_1.setBounds(343, 159, 74, 25);
		panel.add(lblNewLabel_3_16_1);
		
		JLabel lblNewLabel_3_16_2 = new JLabel("₹30");
		lblNewLabel_3_16_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_16_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_16_2.setBounds(30, 428, 74, 25);
		panel.add(lblNewLabel_3_16_2);
		
		JLabel lblNewLabel_3_16_3 = new JLabel("₹150");
		lblNewLabel_3_16_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_16_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_16_3.setBounds(342, 428, 74, 25);
		panel.add(lblNewLabel_3_16_3);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		content.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\bag.png"));
		lblNewLabel_1_1.setBounds(10, 32, 168, 117);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_4 = new JLabel("BAG  ₹555");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_4.setBounds(20, 160, 79, 25);
		panel_1.add(lblNewLabel_3_4);
		
		final JSpinner bagqn = new JSpinner();
		bagqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(4), Integer.valueOf(1)));
		bagqn.setBounds(101, 160, 66, 27);
		panel_1.add(bagqn);
		
		final JButton bagbt = new JButton("ADD TO CART");
		bagbt.setBackground(new Color(240, 240, 240));
		if(avail.get(4)<=0)
		{
			bagbt.setText("OUT OF STOCK");
			bagbt.setEnabled(false);
			
		}
		bagbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)bagqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"BAG",i,555.00*i);
				cal();
				bagqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		bagbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		bagbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bagbt.setBounds(10, 206, 131, 23);
		panel_1.add(bagbt);
		
		JLabel glass = new JLabel("New label");
		glass.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\glass.png"));
		glass.setBounds(333, 32, 176, 117);
		panel_1.add(glass);
		
		JLabel lblNewLabel_3_5 = new JLabel("SUNGLASS ₹425");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_5.setBounds(332, 160, 111, 25);
		panel_1.add(lblNewLabel_3_5);
		
		final JSpinner glassqn = new JSpinner();
		glassqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(5), Integer.valueOf(1)));
		glassqn.setBounds(453, 160, 66, 27);
		panel_1.add(glassqn);
		
		final JButton glassbt = new JButton("ADD TO CART");
		glassbt.setBackground(new Color(240, 240, 240));
		if(avail.get(5)<=0)
		{
			glassbt.setText("OUT OF STOCK");
			glassbt.setEnabled(false);
			
		}
		else
		{
		glassbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)glassqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"SUNGLASS",i,425.00*i);
				cal();
				glassqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		glassbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		glassbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		glassbt.setBounds(353, 206, 131, 23);
		panel_1.add(glassbt);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\watch.png"));
		lblNewLabel_1_3.setBounds(10, 275, 176, 117);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_3_6 = new JLabel("WATCH ₹600");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_6.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_6.setBounds(10, 413, 89, 25);
		panel_1.add(lblNewLabel_3_6);
		
		final JSpinner watchqn = new JSpinner();
		watchqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(6), Integer.valueOf(1)));
		watchqn.setBounds(109, 413, 66, 27);
		panel_1.add(watchqn);
		
		final JButton watchbt = new JButton("ADD TO CART");
		watchbt.setBackground(new Color(240, 240, 240));
		if(avail.get(6)<=0)
		{
			watchbt.setText("OUT OF STOCK");
			watchbt.setEnabled(false);
			
		}
		else
		{
		watchbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)watchqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"WATCH",i,600.00*i);
				cal();
				watchqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		watchbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		watchbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		watchbt.setBounds(10, 455, 131, 23);
		panel_1.add(watchbt);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\pendent.png"));
		lblNewLabel_1_4.setBounds(323, 264, 176, 117);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_3_7 = new JLabel("PENDANT ₹225");
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_7.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_7.setBounds(323, 413, 120, 25);
		panel_1.add(lblNewLabel_3_7);
		
		final JSpinner penqn = new JSpinner();
		penqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(7), Integer.valueOf(1)));
		penqn.setBounds(440, 413, 66, 27);
		panel_1.add(penqn);
		
		final JButton penbt = new JButton("ADD TO CART");
		penbt.setBackground(new Color(240, 240, 240));
		if(avail.get(7)<=0)
		{
			penbt.setText("OUT OF STOCK");
			penbt.setEnabled(false);
			
		}
		else
		{
		penbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)penqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"PENDANT",i,225.00*i);
				cal();
				penqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		penbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		penbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		penbt.setBounds(333, 455, 131, 23);
		panel_1.add(penbt);
		
		JButton btnViewSimilarProducts_1 = new JButton("VIEW SIMILAR PRODUCTS ->");
		btnViewSimilarProducts_1.setBackground(new Color(240, 240, 240));
		btnViewSimilarProducts_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				content.setSelectedIndex(5);
				String t= "Fashion";
				DefaultTableModel dt=(DefaultTableModel) ftable.getModel();
				try {
					dt.setRowCount(1);
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="select * from items where type='"+t+"'";
					ResultSet rs=st.executeQuery(q);
					//st.executeUpdate(q);
					//dt.setRowCount(1);
					while(rs.next())
					{
						fqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(rs.getInt(2)), Integer.valueOf(1)));
						if(rs.getInt(2)>0)
						{
						dt.addRow(new Object[] {rs.getString(1),rs.getDouble(3)});
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewSimilarProducts_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewSimilarProducts_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnViewSimilarProducts_1.setBounds(315, 508, 203, 32);
		panel_1.add(btnViewSimilarProducts_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		content.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\charger.png"));
		lblNewLabel_1_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_2.setBounds(10, 30, 176, 117);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3_8 = new JLabel("ADAPTER ₹400");
		lblNewLabel_3_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_8.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_8.setBounds(10, 156, 102, 25);
		panel_2.add(lblNewLabel_3_8);
		
		final JSpinner adapterqn = new JSpinner();
		adapterqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(8), Integer.valueOf(1)));
		adapterqn.setBounds(120, 158, 66, 27);
		panel_2.add(adapterqn);
		
		final JButton adapterbt = new JButton("ADD TO CART");
		adapterbt.setBackground(new Color(240, 240, 240));
		if(avail.get(8)<=0)
		{
			adapterbt.setText("OUT OF STOCK");
			adapterbt.setEnabled(false);
			
		}
		else
		{
		adapterbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)adapterqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"ADAPTER",i,400.00*i);
				cal();
				adapterqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		adapterbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		adapterbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		adapterbt.setBounds(20, 196, 131, 23);
		panel_2.add(adapterbt);
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		lblNewLabel_1_5.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\buds.png"));
		lblNewLabel_1_5.setBounds(340, 30, 176, 117);
		panel_2.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_3_9 = new JLabel("AIRBUDS ₹950 ");
		lblNewLabel_3_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_9.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_9.setBounds(350, 156, 115, 25);
		panel_2.add(lblNewLabel_3_9);
		
		final JSpinner budsqn = new JSpinner();
		budsqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(9), Integer.valueOf(1)));
		budsqn.setBounds(462, 156, 66, 27);
		panel_2.add(budsqn);
		
		final JButton budsbt = new JButton("ADD TO CART");
		budsbt.setBackground(new Color(240, 240, 240));
		if(avail.get(9)<=0)
		{
			budsbt.setText("OUT OF STOCK");
			budsbt.setEnabled(false);
			
		}
		else
		{
		budsbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)budsqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"AIRBUDS",i,950.00*i);
				cal();
				budsqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		budsbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		budsbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		budsbt.setBounds(360, 196, 131, 23);
		panel_2.add(budsbt);
		
		JLabel lblNewLabel_1_6 = new JLabel("New label");
		lblNewLabel_1_6.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\powerbank.png"));
		lblNewLabel_1_6.setBounds(10, 250, 160, 117);
		panel_2.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_3_10 = new JLabel("POWERBANK ₹889");
		lblNewLabel_3_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_10.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_10.setBounds(10, 391, 141, 25);
		panel_2.add(lblNewLabel_3_10);
		
		final JSpinner powerqn = new JSpinner();
		powerqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(10), Integer.valueOf(1)));
		powerqn.setBounds(142, 391, 66, 27);
		panel_2.add(powerqn);
		
		final JButton powerbt = new JButton("ADD TO CART");
		powerbt.setBackground(new Color(240, 240, 240));
		if(avail.get(10)<=0)
		{
			adapterbt.setText("OUT OF STOCK");
			adapterbt.setEnabled(false);
			
		}
		else
		{
		powerbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)powerqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"POWERBANK",i,889.00*i);
				cal();
				powerqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		powerbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		powerbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		powerbt.setBounds(20, 427, 131, 23);
		panel_2.add(powerbt);
		
		JLabel lblNewLabel_1_7 = new JLabel("New label");
		lblNewLabel_1_7.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\keyboard.png"));
		lblNewLabel_1_7.setBounds(340, 250, 176, 117);
		panel_2.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_3_11 = new JLabel("KEYBOARD ₹680");
		lblNewLabel_3_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_11.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_11.setBounds(334, 391, 115, 25);
		panel_2.add(lblNewLabel_3_11);
		
		final JSpinner keyqn = new JSpinner();
		keyqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(11), Integer.valueOf(1)));
		keyqn.setBounds(450, 391, 66, 27);
		panel_2.add(keyqn);
		
		final JButton keybt = new JButton("ADD TO CART");
		keybt.setBackground(new Color(240, 240, 240));
		if(avail.get(11)<=0)
		{
			adapterbt.setText("OUT OF STOCK");
			adapterbt.setEnabled(false);
			
		}
		else
		{
		keybt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)keyqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"KEYBOARD",i,680.00*i);
				cal();
				keyqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		keybt.setFont(new Font("Tahoma", Font.BOLD, 13));
		keybt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		keybt.setBounds(340, 427, 131, 23);
		panel_2.add(keybt);
		
		JButton btnViewSimilarProducts_1_1 = new JButton("VIEW SIMILAR PRODUCTS ->");
		btnViewSimilarProducts_1_1.setBackground(new Color(240, 240, 240));
		btnViewSimilarProducts_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				content.setSelectedIndex(6);
				String t= "Gadgets";
				DefaultTableModel dt=(DefaultTableModel) gatable.getModel();
				try {
					dt.setRowCount(1);
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="select * from items where type='"+t+"'";
					ResultSet rs=st.executeQuery(q);
					//st.executeUpdate(q);
					//dt.setRowCount(1);
					while(rs.next())
					{
						gaqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(rs.getInt(2)), Integer.valueOf(1)));
						if(rs.getInt(2)>0)
						{
						dt.addRow(new Object[] {rs.getString(1),rs.getDouble(3)});
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewSimilarProducts_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewSimilarProducts_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnViewSimilarProducts_1_1.setBounds(334, 482, 215, 32);
		panel_2.add(btnViewSimilarProducts_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		content.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_8 = new JLabel("New label");
		lblNewLabel_1_8.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\ckit.png"));
		lblNewLabel_1_8.setBounds(30, 32, 166, 117);
		panel_3.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_3_12 = new JLabel("<html>CRICKET KIT<br> ₹1550</html>");
		lblNewLabel_3_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_12.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_12.setBounds(10, 160, 141, 35);
		panel_3.add(lblNewLabel_3_12);
		
		final JSpinner cricketqn = new JSpinner();
		cricketqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(12), Integer.valueOf(1)));
		cricketqn.setBounds(140, 160, 66, 27);
		panel_3.add(cricketqn);
		
		final JButton cricketbt = new JButton("ADD TO CART");
		cricketbt.setBackground(new Color(240, 240, 240));
		if(avail.get(12)<=0)
		{
			cricketbt.setText("OUT OF STOCK");
			cricketbt.setEnabled(false);
			
		}
		else
		{
		cricketbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)cricketqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"CRICKET KIT",i,1550.00*i);
				cal();
				cricketqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		cricketbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		cricketbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		cricketbt.setBounds(50, 206, 131, 23);
		panel_3.add(cricketbt);
		
		JLabel lblNewLabel_1_9 = new JLabel("New label");
		lblNewLabel_1_9.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\football.png"));
		lblNewLabel_1_9.setBounds(321, 32, 176, 117);
		panel_3.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_3_13 = new JLabel("<html>FOOTBALL<br> ₹750</html>");
		lblNewLabel_3_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_13.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_13.setBounds(331, 160, 113, 25);
		panel_3.add(lblNewLabel_3_13);
		
		final JSpinner footballqn = new JSpinner();
		footballqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(13), Integer.valueOf(1)));
		footballqn.setBounds(442, 160, 66, 27);
		panel_3.add(footballqn);
		
		final JButton footballbt = new JButton("ADD TO CART");
		footballbt.setBackground(new Color(240, 240, 240));
		if(avail.get(13)<=0)
		{
			footballbt.setText("OUT OF STOCK");
			footballbt.setEnabled(false);
			
		}
		else
		{
		footballbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)footballqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"FOOTBALL",i,750.00*i);
				cal();
				footballqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		}
		footballbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		footballbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		footballbt.setBounds(341, 206, 131, 23);
		panel_3.add(footballbt);
		
		JLabel lblNewLabel_1_10 = new JLabel("New label");
		lblNewLabel_1_10.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\hkit.png"));
		lblNewLabel_1_10.setBounds(30, 272, 176, 117);
		panel_3.add(lblNewLabel_1_10);
		
		JLabel lblNewLabel_3_14 = new JLabel("<html>HOCKEY KIT<br> ₹1100</html>");
		lblNewLabel_3_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_14.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_14.setBounds(20, 400, 131, 25);
		panel_3.add(lblNewLabel_3_14);
		
		final JSpinner hockeyqn = new JSpinner();
		hockeyqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(14), Integer.valueOf(1)));
		hockeyqn.setBounds(144, 400, 66, 27);
		panel_3.add(hockeyqn);
		
		final JButton hockeybt = new JButton("ADD TO CART");
		hockeybt.setBackground(new Color(240, 240, 240));
		if(avail.get(14)<=0)
		{
			hockeybt.setText("OUT OF STOCK");
			hockeybt.setEnabled(false);
			
		}
		hockeybt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)hockeyqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"HOCKEY KIT",i,1100.00*i);
				cal();
				hockeyqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		hockeybt.setFont(new Font("Tahoma", Font.BOLD, 13));
		hockeybt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		hockeybt.setBounds(50, 453, 131, 23);
		panel_3.add(hockeybt);
		
		JLabel lblNewLabel_1_11 = new JLabel("New label");
		lblNewLabel_1_11.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\tkit.png"));
		lblNewLabel_1_11.setBounds(338, 272, 159, 117);
		panel_3.add(lblNewLabel_1_11);
		
		JLabel lblNewLabel_3_15 = new JLabel("<html>TENNIS KIT <br>₹1025</html>");
		lblNewLabel_3_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_15.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_15.setBounds(321, 400, 141, 25);
		panel_3.add(lblNewLabel_3_15);
		
		final JSpinner tennisqn = new JSpinner();
		tennisqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), avail.get(15), Integer.valueOf(1)));
		tennisqn.setBounds(442, 400, 66, 27);
		panel_3.add(tennisqn);
		
		final JButton tennisbt = new JButton("ADD TO CART");
		tennisbt.setBackground(new Color(240, 240, 240));
		if(avail.get(15)<=0)
		{
			tennisbt.setText("OUT OF STOCK");
			tennisbt.setEnabled(false);
			
		}
		tennisbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=(Integer)tennisqn.getValue();
				if(i!=0)
				{
				addtable(cusid,"TENNIS KIT",i,1025.00*i);
				cal();
				tennisqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		tennisbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		tennisbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tennisbt.setBounds(331, 453, 131, 23);
		panel_3.add(tennisbt);
		
		JButton btnViewSimilarProducts_1_2 = new JButton("VIEW SIMILAR PRODUCTS ->");
		btnViewSimilarProducts_1_2.setBackground(new Color(240, 240, 240));
		btnViewSimilarProducts_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				content.setSelectedIndex(7);
				String t= "Sports";
				DefaultTableModel dt=(DefaultTableModel) stable.getModel();
				try {
					dt.setRowCount(1);
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String q="select * from items where type='"+t+"'";
					ResultSet rs=st.executeQuery(q);
					//st.executeUpdate(q);
					//dt.setRowCount(1);
					while(rs.next())
					{
						sqn.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(rs.getInt(2)), Integer.valueOf(1)));
						dt.addRow(new Object[] {rs.getString(1),rs.getDouble(3)});
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewSimilarProducts_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewSimilarProducts_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnViewSimilarProducts_1_2.setBounds(324, 502, 203, 32);
		panel_3.add(btnViewSimilarProducts_1_2);
		
		JPanel gpanel = new JPanel();
		gpanel.setBackground(new Color(255, 255, 255));
		content.addTab("New tab", null, gpanel, null);
		gpanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 28, 518, 404);
		gpanel.add(scrollPane_1);
		
		gtable = new JTable();
		gtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		gtable.setShowVerticalLines(false);
		gtable.setShowHorizontalLines(false);
		gtable.setShowGrid(false);
		gtable.setFont(new Font("Consolas", Font.BOLD, 13));
		scrollPane_1.setViewportView(gtable);
		gtable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"ITEMNAME", "PRICE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		gtable.getColumnModel().getColumn(0).setResizable(false);
		gtable.getColumnModel().getColumn(1).setResizable(false);
		
		gqn = new JSpinner();
		gqn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gqn.setBounds(440, 471, 88, 32);
		gpanel.add(gqn);
		
		JButton gbt = new JButton("ADD TO CART");
		gbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int index=gtable.getSelectedRow();
				int i=(Integer)gqn.getValue();
				if(i!=0)
				{
				addtable(cusid,gtable.getValueAt(index, 0).toString(),i,(Double.valueOf(gtable.getValueAt(index, 1).toString())*i));
				cal();
				gqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		gbt.setFont(new Font("Tahoma", Font.BOLD, 18));
		gbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		gbt.setBounds(354, 514, 174, 42);
		gpanel.add(gbt);
		
		JPanel fpanel = new JPanel();
		fpanel.setBackground(new Color(255, 255, 255));
		content.addTab("New tab", null, fpanel, null);
		fpanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 29, 539, 388);
		fpanel.add(scrollPane_2);
		
		ftable = new JTable();
		ftable.setFont(new Font("Consolas", Font.BOLD, 13));
		ftable.setShowVerticalLines(false);
		ftable.setShowHorizontalLines(false);
		ftable.setShowGrid(false);
		ftable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"ITEMNAME", "PRICE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ftable.getColumnModel().getColumn(0).setResizable(false);
		ftable.getColumnModel().getColumn(1).setResizable(false);
		scrollPane_2.setViewportView(ftable);
		
		fqn = new JSpinner();
		fqn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fqn.setBounds(461, 466, 88, 32);
		fpanel.add(fqn);
		
		JButton fbt = new JButton("ADD TO CART");
		fbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int index=ftable.getSelectedRow();
				int i=(Integer)fqn.getValue();
				if(i!=0)
				{
				addtable(cusid,ftable.getValueAt(index, 0).toString(),i,(Double.valueOf(ftable.getValueAt(index, 1).toString())*i));
				cal();
				fqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		fbt.setFont(new Font("Tahoma", Font.BOLD, 18));
		fbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fbt.setBounds(375, 509, 174, 42);
		fpanel.add(fbt);
		
		JPanel gapanel = new JPanel();
		gapanel.setBackground(new Color(255, 255, 255));
		content.addTab("New tab", null, gapanel, null);
		gapanel.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(24, 40, 512, 386);
		gapanel.add(scrollPane_3);
		
		gatable = new JTable();
		gatable.setShowVerticalLines(false);
		gatable.setShowGrid(false);
		gatable.setShowHorizontalLines(false);
		gatable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"ITEMNAME", "PRICE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		gatable.getColumnModel().getColumn(0).setResizable(false);
		gatable.getColumnModel().getColumn(1).setResizable(false);
		gatable.setFont(new Font("Consolas", Font.BOLD, 13));
		scrollPane_3.setViewportView(gatable);
		
		gaqn = new JSpinner();
		gaqn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gaqn.setBounds(448, 468, 88, 32);
		gapanel.add(gaqn);
		
		JButton gabt = new JButton("ADD TO CART");
		gabt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int index=gatable.getSelectedRow();
				int i=(Integer)gaqn.getValue();
				if(i!=0)
				{
				addtable(cusid,gatable.getValueAt(index, 0).toString(),i,(Double.valueOf(gatable.getValueAt(index, 1).toString())*i));
				cal();
				gaqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		gabt.setFont(new Font("Tahoma", Font.BOLD, 18));
		gabt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		gabt.setBounds(362, 511, 174, 42);
		gapanel.add(gabt);
		
		JPanel spanel = new JPanel();
		spanel.setBackground(new Color(255, 255, 255));
		content.addTab("New tab", null, spanel, null);
		spanel.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 32, 522, 395);
		spanel.add(scrollPane_4);
		
		stable = new JTable();
		stable.setShowVerticalLines(false);
		stable.setShowHorizontalLines(false);
		stable.setShowGrid(false);
		scrollPane_4.setViewportView(stable);
		stable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"ITEMANME", "PRICE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		stable.getColumnModel().getColumn(0).setResizable(false);
		stable.setFont(new Font("Consolas", Font.BOLD, 13));
		
		sqn = new JSpinner();
		sqn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sqn.setBounds(444, 463, 88, 32);
		spanel.add(sqn);
		
		JButton sbt = new JButton("ADD TO CART");
		sbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int index=stable.getSelectedRow();
				int i=(Integer)sqn.getValue();
				if(i!=0)
				{
				addtable(cusid,stable.getValueAt(index, 0).toString(),i,(Double.valueOf(stable.getValueAt(index, 1).toString())*i));
				cal();
				sqn.setValue(0);
				}
				else
				{
					JOptionPane.showMessageDialog(getRootPane(), "Please increase the Quantity");
				}
			}
		});
		sbt.setFont(new Font("Tahoma", Font.BOLD, 18));
		sbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sbt.setBounds(358, 506, 174, 42);
		spanel.add(sbt);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(744, 106, 518, 410);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("CART");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\cart.png"));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4_1.setBackground(Color.WHITE);
		lblNewLabel_4_1.setBounds(73, 11, 308, 68);
		panel_1_1.add(lblNewLabel_4_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 90, 460, 275);
		panel_1_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"NAME", "QUANTITY", "PRICE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setShowGrid(false);
		table.setFont(new Font("Consolas", Font.BOLD, 13));
		table.setBorder(new CompoundBorder());
		table.setBackground(new Color(239, 239, 239));
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
                DefaultTableModel dt = (DefaultTableModel) table.getModel();
				
				int rw=table.getSelectedRow();
				
				String n=table.getValueAt(rw, 0).toString();
				int q=Integer.valueOf(table.getValueAt(rw, 1).toString());
				double p=Double.valueOf(table.getValueAt(rw, 2).toString());
				
				try {
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String query="delete from cart where cid='"+cusid+"'and itemname='"+n+"'and quantity='"+q+"'and price='"+p+"';";
					st.executeUpdate(query);
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dt.removeRow(rw);
				cal();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\del.jpg"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_3.setBounds(754, 527, 122, 43);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("PAYABLE ₹");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1.setBackground(Color.WHITE);
		lblNewLabel_5_1.setBounds(920, 527, 135, 52);
		contentPane.add(lblNewLabel_5_1);
		
		total = new JTextField();
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setFont(new Font("Tahoma", Font.BOLD, 16));
		total.setColumns(10);
		total.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		total.setBounds(1057, 529, 177, 36);
		contentPane.add(total);
		
		JButton pay = new JButton("PLACE ORDER");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Connection con = jdbc.getCon();
					Statement st = con.createStatement();
					String pass="1234567890ABCDEFGHIJKLMNOPQRSTUVQXYZ1234567890";
					Random rndm_method = new Random();
					char[] orderid = new char[5];
			        for (int j = 0; j < 5; j++)
			        {
			            
			            orderid[j] =pass.charAt(rndm_method.nextInt(pass.length()));
			  
			        }
			        //System.out.println(orderid);
			         oid=new String(orderid);
					
				for(int i = 1;i<table.getRowCount();i++)
				{
					String item=table.getValueAt(i, 0).toString();
					int quantity=Integer.valueOf(table.getValueAt(i, 1).toString());
					Double price=Double.valueOf(table.getValueAt(i, 2).toString());
					String cusname=n;
					
					String q="insert into purchase(cid,cname,item,quantity,price,orderid) values('"+cusid+"','"+cusname+"','"+item+"','"+quantity+"','"+price+"','"+oid+"');";
					st.executeUpdate(q);
					String query ="update items set available = available-'"+quantity+"' where itemname='"+item+"'";
					st.executeUpdate(query);
					String query1="select * from items where itemname='"+item+"'";
					ResultSet rs=st.executeQuery(query1);
					if(rs.next())
					{
					if(item.equals("SUGAR 1KG") && rs.getInt(2)<=0)
					{
						sugarbt.setText("OUT OF STOCK");
						sugarbt.setEnabled(false);
						
					}
					if(item.equals("APPLE 1KG") && rs.getInt(2)<=0)
					{
						applebt.setText("OUT OF STOCK");
						applebt.setEnabled(false);
						
					}
					if(item.equals("ONION 1KG") && rs.getInt(2)<=0)
					{
						onionbt.setText("OUT OF STOCK");
						onionbt.setEnabled(false);
						
					}
					if(item.equals("RICE 1KG") && rs.getInt(2)<=0)
					{
						ricebt.setText("OUT OF STOCK");
						ricebt.setEnabled(false);
						
					}
					if(item.equals("BAG") && rs.getInt(2)<=0)
					{
						bagbt.setText("OUT OF STOCK");
						bagbt.setEnabled(false);
						
					}
					if(item.equals("SUNGLASS") && rs.getInt(2)<=0)
					{
						glassbt.setText("OUT OF STOCK");
						glassbt.setEnabled(false);
						
					}
					if(item.equals("WATCH") && rs.getInt(2)<=0)
					{
						watchbt.setText("OUT OF STOCK");
						watchbt.setEnabled(false);
						
					}
					if(item.equals("PENDANT") && rs.getInt(2)<=0)
					{
						penbt.setText("OUT OF STOCK");
						penbt.setEnabled(false);
						
					}
					if(item.equals("ADAPTER") && rs.getInt(2)<=0)
					{
						adapterbt.setText("OUT OF STOCK");
						adapterbt.setEnabled(false);
						
					}
					if(item.equals("AIRBUDS") && rs.getInt(2)<=0)
					{
						budsbt.setText("OUT OF STOCK");
						budsbt.setEnabled(false);
						
					}
					if(item.equals("POWERBANK") && rs.getInt(2)<=0)
					{
						powerbt.setText("OUT OF STOCK");
						powerbt.setEnabled(false);
						
					}
					if(item.equals("KEYBOARD") && rs.getInt(2)<=0)
					{
						keybt.setText("OUT OF STOCK");
						keybt.setEnabled(false);
						
					}
					if(item.equals("CRICKET KIT") && rs.getInt(2)<=0)
					{
						cricketbt.setText("OUT OF STOCK");
						cricketbt.setEnabled(false);
						
					}
					if(item.equals("FOOTBALL") && rs.getInt(2)<=0)
					{
						footballbt.setText("OUT OF STOCK");
						footballbt.setEnabled(false);
						
					}
					if(item.equals("HOCKEY KIT") && rs.getInt(2)<=0)
					{
						hockeybt.setText("OUT OF STOCK");
						hockeybt.setEnabled(false);
						
					}
					if(item.equals("TENNIS KIT") && rs.getInt(2)<=0)
					{
						tennisbt.setText("OUT OF STOCK");
						tennisbt.setEnabled(false);
						
					}
					}
					
						
		
					
				}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				Connection con;
				try 
				{
					con = jdbc.getCon();
					Statement st = con.createStatement();
					String q1 = "select * from cart where cid = '"+cusid+"';";
					ResultSet rs = st.executeQuery(q1);
					while(rs.next())
					{
						itemname.add(rs.getString("itemname"));
						itemquantity.add(rs.getInt("quantity"));
						itemprice.add(rs.getDouble("price"));
					}
					
					String q="delete from cart where cid='"+cusid+"';";
					st.executeUpdate(q);
					
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//JOptionPane.showMessageDialog(getRootPane(), "Order Placed Successfully");
				DefaultTableModel dt = (DefaultTableModel) table.getModel();
				dt.setNumRows(1);
				tot=total.getText();
				receipt b = new receipt(cusid,n,oid,itemname,itemquantity,itemprice,tot);
				b.setVisible(true);
				setVisible(false);
				itemname.clear();
				itemquantity.clear();
				itemprice.clear();
		        total.setText(""); 
				
				
				
			}
		});
		pay.setFont(new Font("Tahoma", Font.BOLD, 12));
		pay.setBorder(new LineBorder(new Color(0, 0, 0)));
		pay.setBounds(1112, 576, 122, 43);
		contentPane.add(pay);;
		setExtendedState(MAXIMIZED_BOTH);
	}
}
