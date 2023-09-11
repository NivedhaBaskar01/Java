package Ecommerce;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;


import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class track extends JFrame {

	private JPanel contentPane;
	private JTextField cname;
	private JTextArea cadd;
	private JTextField cphn;
	private JTable table;
	JLabel l1,l2,l3,l4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					track frame = new track(6);
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
	public track(final int cusid,final String cusname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setExtendedState(MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new EmptyBorder(0, 0, 0, 0));
		p1.setBackground(new Color(16, 37, 71));
		p1.setBounds(158, 0, 1125, 87);
		contentPane.add(p1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\logo.png"));
		lblNewLabel.setBounds(795, 0, 325, 83);
		p1.add(lblNewLabel);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBorder(new EmptyBorder(0, 0, 0, 0));
		p2.setBackground(new Color(16, 37, 71));
		p2.setBounds(0, 0, 160, 653);
		contentPane.add(p2);
		
		JLabel lblNewLabel_6_4 = new JLabel("SHOP");
		lblNewLabel_6_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				new products(cusname,cusid).setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_4.setForeground(new Color(255, 128, 64));
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		lblNewLabel_6_4.setBounds(10, 520, 131, 46);
		p2.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\customerlogo.jpg"));
		lblNewLabel_7.setBounds(21, 11, 120, 127);
		p2.add(lblNewLabel_7);
		
		JLabel namelbl = new JLabel("<dynamic>");
		namelbl.setHorizontalAlignment(SwingConstants.CENTER);
		namelbl.setForeground(new Color(255, 128, 64));
		namelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		namelbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		namelbl.setBounds(10, 141, 131, 32);
		p2.add(namelbl);
		namelbl.setText(cusname);
		
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
		lblNewLabel_6_4_2_1.setBounds(10, 596, 131, 46);
		p2.add(lblNewLabel_6_4_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("ORDER ID");
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_1.setBounds(168, 98, 130, 36);
		contentPane.add(lblNewLabel_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 128, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Order ID"}));
		comboBox.setBackground(new Color(16, 31, 71));
		comboBox.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		comboBox.setBounds(294, 98, 329, 46);
		contentPane.add(comboBox);
		   try {
	        	Connection con=jdbc.getCon();

	            Statement st= con.createStatement();

	            String query= "select * from delivery where cusid='"+cusid+"';";

	            ResultSet rs=st.executeQuery(query);

	            while(rs.next()) 
	            {
	            	System.out.println(rs.getString("orderid"));
	            	comboBox.addItem(rs.getString("orderid"));
	            }    

	        }
		   catch(Exception e1) {

	            JOptionPane.showMessageDialog(getRootPane(), e1);

	        }
	        
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				String oid=comboBox.getSelectedItem().toString();
				try {
					l1.setVisible(false);
					l2.setVisible(false);
					l3.setVisible(false);
					l4.setVisible(false);
		        	Connection con=jdbc.getCon();

		            Statement st= con.createStatement();

		            String query= "select * from delivery where orderid='"+oid+"'";

		            ResultSet rs=st.executeQuery(query);

		            while(rs.next()) 
		            {
		            	cname.setText(rs.getString(2));
		            	cadd.setText(rs.getString(3));
		            	cphn.setText(rs.getString(4));
		            	if(rs.getString(7).equals("Ordered"))
		            	{
		            		l1.setVisible(true);
		            	}
		            	else if(rs.getString(7).equals("PickedUp"))
		            	{
		            		l1.setVisible(true);
		            		l2.setVisible(true);
		            		l3.setVisible(true);
		            	}
		            	else
		            	{
		            		l1.setVisible(true);
		            		l2.setVisible(true);
		            		l3.setVisible(true);
		            		l4.setVisible(true);
		            	}
		            	
		            }    
		            
		            Statement st1= con.createStatement();

		            String query1= "select * from purchase where orderid='"+oid+"'";

		            ResultSet rs1=st1.executeQuery(query1);
		            
		            DefaultTableModel dt = (DefaultTableModel) table.getModel();
		            dt.setRowCount(1);
		            while(rs1.next())
					{
		       
					dt.addRow(new Object[] {rs1.getString(3),rs1.getInt(4),rs1.getDouble(5)});
					
					}

		        }
			   catch(Exception e1) {

		            JOptionPane.showMessageDialog(getRootPane(), e1);

		        }
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSelect.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSelect.setBounds(655, 98, 122, 43);
		contentPane.add(btnSelect);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Algerian", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(152, 177, 128, 57);
		contentPane.add(lblNewLabel_2);
		
		cname = new JTextField();
		cname.setFont(new Font("KareliaWeb Bold", Font.BOLD, 15));
		cname.setEditable(false);
		cname.setColumns(10);
		cname.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		cname.setBackground(new Color(244, 244, 244));
		cname.setBounds(292, 179, 319, 49);
		contentPane.add(cname);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setFont(new Font("Algerian", Font.PLAIN, 20));
		lblAddress.setBounds(180, 264, 100, 57);
		contentPane.add(lblAddress);
		
		cadd = new JTextArea();
		cadd.setLineWrap(true);
		cadd.setFont(new Font("KareliaWeb Bold", Font.BOLD, 15));
		cadd.setEditable(false);
		cadd.setColumns(10);
		cadd.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		cadd.setBackground(new Color(244, 244, 244));
		cadd.setBounds(294, 266, 319, 49);
		contentPane.add(cadd);
		
		JLabel lblPhome = new JLabel("PHONE");
		lblPhome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhome.setFont(new Font("Algerian", Font.PLAIN, 20));
		lblPhome.setBounds(185, 353, 100, 57);
		contentPane.add(lblPhome);
		
		cphn = new JTextField();
		cphn.setFont(new Font("KareliaWeb Bold", Font.BOLD, 15));
		cphn.setEditable(false);
		cphn.setColumns(10);
		cphn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		cphn.setBackground(new Color(244, 244, 244));
		cphn.setBounds(294, 355, 319, 49);
		contentPane.add(cphn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(661, 177, 561, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ITEMNAME", "QUANTITY", "PRICE"
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
		scrollPane.setViewportView(table);
		table.setFont(new Font("Consolas", Font.BOLD, 13));
		
		l1 = new JLabel("");
		l1.setBorder(null);
		l1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\MicrosoftTeams-image (2).png"));
		l1.setBounds(202, 529, 30, 36);
		contentPane.add(l1);
		l1.setVisible(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(321, 544, 150, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("ORDERED");
		lblNewLabel_1_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(242, 529, 100, 36);
		contentPane.add(lblNewLabel_1_1);
		
	    l2 = new JLabel("");
		l2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\MicrosoftTeams-image (2).png"));
		l2.setBorder(null);
		l2.setBounds(496, 529, 30, 36);
		contentPane.add(l2);
		l2.setVisible(false);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PICKED UP");
		lblNewLabel_1_1_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(536, 529, 111, 36);
		contentPane.add(lblNewLabel_1_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(641, 544, 136, 2);
		contentPane.add(separator_1);
		
		l3 = new JLabel("");
		l3.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\MicrosoftTeams-image (2).png"));
		l3.setBorder(null);
		l3.setBounds(795, 529, 30, 36);
		contentPane.add(l3);
		l3.setVisible(false);
		
		JLabel lblNewLabel_1_1_2 = new JLabel(" IN-TRANSIT");
		lblNewLabel_1_1_2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_2.setBounds(835, 529, 130, 36);
		contentPane.add(lblNewLabel_1_1_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(965, 544, 100, 2);
		contentPane.add(separator_2);
		
		l4 = new JLabel("");
		l4.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\MicrosoftTeams-image (2).png"));
		l4.setBorder(null);
		l4.setBounds(1086, 529, 30, 36);
		contentPane.add(l4);
		l4.setVisible(false);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel(" DELIVERED");
		lblNewLabel_1_1_2_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_2_1.setBounds(1126, 529, 130, 36);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_3.setBounds(185, 529, 51, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_3_1.setBounds(480, 529, 51, 36);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_3_2.setBounds(785, 529, 51, 36);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_3_3.setBounds(1075, 529, 51, 36);
		contentPane.add(lblNewLabel_3_3);
     

        
	}
}
