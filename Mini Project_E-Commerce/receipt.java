package Ecommerce;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;



public class receipt extends JFrame {

	private JPanel contentPane;
	private JTextField a1;
	private JComboBox a3;
	private JTextField a4;
	private JTextField a5;
	JTable table;
	private JTextField finalp;
	private JTextField orderp;
	JPanel rpanel ;
	JButton btnPrint ;
	JPanel dpanel;
	private JTextField textField;
	private JTextField textField_1;
	JPanel paypanel ;
	JButton btnPay;
	JButton btnBack;
	JPanel cardpanel;
	JLabel codlabel ;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					receipt frame = new receipt();
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
	
	private void saveImage(JPanel panel) {
	    BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
	    panel.paint(img.getGraphics());
	    try {
	        ImageIO.write(img, "png", new File("D://Receipt.png"));
	        System.out.println("panel saved as image");

	    } catch (Exception e) {
	        System.out.println("panel not saved" + e.getMessage());
	    }
	}
	
	private void printRecord(final JPanel panel)
	{
		PrinterJob pj=PrinterJob.getPrinterJob();
		pj.setJobName("Print");
		pj.setPrintable(new Printable()
				{

					@Override
					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
						
						if(pageIndex>0)
						{
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D g=(Graphics2D)graphics;
						g.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
						g.scale(0.5, 0.5);
						panel.paint(g);
						
						return Printable.PAGE_EXISTS;
					}
			
				});
		
		boolean r=pj.printDialog();
		if(r)
		{
			try
			{
				pj.print();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}

					
	}
	public receipt(final int cusid,final String name,final String oid,ArrayList<String> n,ArrayList<Integer> q,ArrayList<Double> p,String tot) {
		System.out.println(n);
		System.out.println(q);
		System.out.println(p);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup bg=new ButtonGroup();
		
		paypanel = new JPanel();
		paypanel.setVisible(false);
		paypanel.setBounds(10, 96, 596, 547);
		contentPane.add(paypanel);
		paypanel.setBackground(new Color(255, 255, 255));
		paypanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("SELECT PAYMENT MODE");
		lblNewLabel_5.setFont(new Font("Consolas", Font.BOLD, 26));
		lblNewLabel_5.setIcon(null);
		lblNewLabel_5.setBounds(10, 11, 370, 67);
		paypanel.add(lblNewLabel_5);
		
		final JRadioButton rb1 = new JRadioButton("CASH ON DELIVERY");
		rb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				cardpanel.setVisible(false);
				codlabel.setVisible(true);
	 			btnPay.setEnabled(true);
			}
		});
		rb1.setFont(new Font("Consolas", Font.BOLD, 18));
		rb1.setBounds(217, 104, 222, 37);
		paypanel.add(rb1);
		
		final JRadioButton rb2 = new JRadioButton("CARD");
		rb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				codlabel.setVisible(false);
				cardpanel.setVisible(true);
	 			btnPay.setEnabled(true);
			}
		});
		rb2.setFont(new Font("Consolas", Font.BOLD, 18));
		rb2.setBounds(217, 224, 222, 37);
		paypanel.add(rb2);
		bg.add(rb1);
		bg.add(rb2);
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\cash.jpg"));
		lblNewLabel_6.setBounds(10, 77, 190, 102);
		paypanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\card.png"));
		lblNewLabel_6_1.setBounds(10, 197, 190, 102);
		paypanel.add(lblNewLabel_6_1);
		
		 btnPay = new JButton("PLACE ORDER");
		 btnPay.setEnabled(false);
		 btnPay.setBounds(23, 493, 122, 43);
		 paypanel.add(btnPay);
		 btnPay.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		
		 		
		 		
		 		JOptionPane.showMessageDialog(getRootPane(), "Order Placed Successfully");
		 		
		 		dpanel.setVisible(false);
		 		rpanel.setVisible(true);
		 		btnPrint.setEnabled(true);
		 		btnBack.setEnabled(true);
		 		String address=a1.getText()+","+a3.getSelectedItem().toString()+","+a4.getText()+","+a5.getText();
		 		
		 		try
		 		{
		 			Connection con = jdbc.getCon();
		 			Statement st = con.createStatement();
		 			String q="select * from customer where cid='"+cusid+"'";
		 			ResultSet rs=st.executeQuery(q);
		 			rs.next();
		 			String phnno=rs.getString(3);
		 			String q1="insert into delivery(cusid,orderid,address,cname,phnno,status) values('"+cusid+"','"+oid+"','"+address+"','"+name+"','"+phnno+"','Ordered');";
		 			Statement st1 = con.createStatement();
		 			st1.executeUpdate(q1);
		 			saveImage(rpanel);
		 			String customeremail="Order id : "+oid+"\nName : "+name+"\n"+"Phone : "+phnno+"\n"+"User Email : "+rs.getString(2)+"\nAddress : "+address+"\n"+"Status : Order Placed";
					String sub="Order Confirmation";
					sendMail s=new sendMail(rs.getString(2),sub,customeremail);
					
		 		}
		 		catch(Exception e1)
		 		{
		 			System.out.println(e1);
		 		}
		 		a1.setText("");a3.removeAllItems();a4.setText("");a5.setText("");
		 		}
		 		
		 	
		 	
		 	
		 });
		 btnPay.setFont(new Font("Tahoma", Font.BOLD, 12));
		 btnPay.setBorder(new LineBorder(new Color(0, 0, 0)));
		 
		 cardpanel = new JPanel();
		 cardpanel.setVisible(false);
		 cardpanel.setBackground(new Color(255, 255, 255));
		 cardpanel.setBounds(10, 322, 555, 147);
		 paypanel.add(cardpanel);
		 cardpanel.setLayout(null);
		 
		 JLabel lblNewLabel_7 = new JLabel("ENTER CARD NUMBER");
		 lblNewLabel_7.setFont(new Font("Consolas", Font.BOLD, 18));
		 lblNewLabel_7.setBounds(10, 21, 170, 33);
		 cardpanel.add(lblNewLabel_7);
		 
		 JLabel lblNewLabel_7_1 = new JLabel("ENTER CVV");
		 lblNewLabel_7_1.setFont(new Font("Consolas", Font.BOLD, 18));
		 lblNewLabel_7_1.setBounds(10, 84, 170, 33);
		 cardpanel.add(lblNewLabel_7_1);
		 
		 textField = new JTextField();
		 textField.setBounds(201, 21, 230, 33);
		 cardpanel.add(textField);
		 textField.setColumns(10);
		 
		 textField_1 = new JTextField();
		 textField_1.setColumns(10);
		 textField_1.setBounds(201, 84, 230, 33);
		 cardpanel.add(textField_1);
		 
		 codlabel = new JLabel(" PAY WHEN YOU GET THE ORDER!!");
		 codlabel.setVisible(false);
		 codlabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 25));
		 codlabel.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\placed.png"));
		 codlabel.setBounds(10, 326, 544, 143);
		 paypanel.add(codlabel);
		 
		
		 
		
		 
		
		 
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new EmptyBorder(0, 0, 0, 0));
		p1.setBackground(new Color(16, 37, 71));
		p1.setBounds(0, 0, 1280, 87);
		contentPane.add(p1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\logo.png"));
		lblNewLabel.setBounds(10, 0, 325, 83);
		p1.add(lblNewLabel);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new products(name,cusid).setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(1148, 33, 122, 43);
		p1.add(btnBack);
		btnBack.setEnabled(false);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(251, 251, 251));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 96, 596, 497);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADDRESS ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 48, 201, 31);
		panel.add(lblNewLabel_1);
		
		a1 = new JTextField();
		a1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		a1.setBackground(new Color(245, 245, 245));
		a1.setFont(new Font("Tahoma", Font.BOLD, 14));
		a1.setBounds(221, 42, 335, 43);
		panel.add(a1);
		a1.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PINCODE ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 139, 151, 31);
		panel.add(lblNewLabel_1_1_1);
		
		a3 = new JComboBox();
		a3.setBackground(new Color(245, 245, 245));
		a3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		a3.setFont(new Font("Tahoma", Font.BOLD, 14));
		a3.setBounds(221, 222, 282, 41);
		panel.add(a3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("AREA/CITY ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 227, 151, 31);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("STATE ");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_2.setBounds(10, 311, 151, 31);
		panel.add(lblNewLabel_1_1_1_2);
		
		a4 = new JTextField();
		a4.setFont(new Font("Tahoma", Font.BOLD, 14));
		a4.setColumns(10);
		a4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		a4.setBackground(new Color(245, 245, 245));
		a4.setBounds(221, 306, 282, 41);
		panel.add(a4);
		
		a5 = new JTextField();
		a5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				a3.removeAllItems();
				a4.setText("");
				Connection con;
				try {
					con = jdbc.getCon();
					Statement st = con.createStatement();
					String query1="select * from pincodes where Pincode='"+a5.getText()+"'";
					ResultSet rs=st.executeQuery(query1);
					while(rs.next())
					{
						a3.addItem(rs.getString(1)+","+rs.getString(4));
						a4.setText(rs.getString(3));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		a5.setFont(new Font("Tahoma", Font.BOLD, 14));
		a5.setColumns(10);
		a5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		a5.setBackground(new Color(245, 245, 245));
		a5.setBounds(221, 134, 282, 41);
		panel.add(a5);
		
		JButton btnPlaceOrder = new JButton("CONTINUE");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(a1.getText().equals(""))
		 		    JOptionPane.showMessageDialog(getRootPane(), "Enter Address");
		 		else if(a3.getSelectedItem().toString().equals(""))
		 			JOptionPane.showMessageDialog(getRootPane(), "Enter City");
		 		else if(a4.getText().equals(""))
		 			JOptionPane.showMessageDialog(getRootPane(), "Enter State");
		 		else if(a5.getText().equals(""))
		 			JOptionPane.showMessageDialog(getRootPane(), "Enter Pincode");
		 		else
		 		{
		 			panel.setVisible(false);
		 			paypanel.setVisible(true);
		 		}
			}
		});
		
		btnPlaceOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPlaceOrder.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPlaceOrder.setBounds(10, 441, 122, 43);
		panel.add(btnPlaceOrder);
		
		JLabel lblNewLabel_1_1 = new JLabel("(House no,Street)");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 71, 201, 31);
		panel.add(lblNewLabel_1_1);
		
		
		btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				/*try
				{
					BufferedImage bi= new BufferedImage(rpanel.getWidth(),rpanel.getHeight(),BufferedImage.TYPE_INT_RGB);
					rpanel.paint(bi.getGraphics());
					String path="D:\\images";
					ImageIO.write(bi, "jpg", new File(path));
					Desktop.getDesktop().print(new File(path));
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}*/
				printRecord(rpanel);
				dpanel.setVisible(true);
				rpanel.setVisible(false);
				btnPrint.setEnabled(false);
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrint.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPrint.setBounds(1148, 604, 122, 43);
		contentPane.add(btnPrint);
		btnPrint.setEnabled(false);
		
		dpanel = new JPanel();
		dpanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		dpanel.setBackground(new Color(255, 255, 255));
		dpanel.setBounds(725, 98, 545, 495);
		contentPane.add(dpanel);
		dpanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\receipt.png"));
		lblNewLabel_4.setBounds(10, 11, 372, 91);
		dpanel.add(lblNewLabel_4);
		
		rpanel = new JPanel();
		rpanel.setVisible(false);
		rpanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rpanel.setBackground(new Color(255, 255, 255));
		rpanel.setBounds(725, 98, 545, 495);
		contentPane.add(rpanel);
		rpanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\receipt.png"));
		lblNewLabel_3.setBounds(10, 11, 307, 77);
		rpanel.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 96, 503, 275);
		rpanel.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"NAME", "QUANTITY", "PRICE"
			}
		));
		table.setFont(new Font("Consolas", Font.BOLD, 14));
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		for(int i=0;i<n.size();i++)
		{
		
			System.out.println(n.get(i));
			dt.addRow(new Object[] {n.get(i),q.get(i),p.get(i)});
		}
		
		JLabel lblNewLabel_1_2 = new JLabel("TOTAL");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(263, 402, 85, 32);
		rpanel.add(lblNewLabel_1_2);
		
		finalp = new JTextField();
		finalp.setText("<dynamic>");
		finalp.setFont(new Font("Tahoma", Font.BOLD, 18));
		finalp.setColumns(10);
		finalp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		finalp.setBounds(383, 393, 141, 49);
		rpanel.add(finalp);
		finalp.setText(tot);
		
		JLabel l2 = new JLabel("");
		l2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\thankyou1.png"));
		l2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		l2.setBounds(20, 397, 205, 63);
		rpanel.add(l2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("ORDER ID");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(305, 32, 85, 32);
		rpanel.add(lblNewLabel_1_2_1);
		
		orderp = new JTextField();
		orderp.setText("<dynamic>");
		orderp.setFont(new Font("Tahoma", Font.BOLD, 18));
		orderp.setColumns(10);
		orderp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		orderp.setBounds(400, 23, 123, 49);
		rpanel.add(orderp);
		orderp.setText(oid);
		 
		 JLabel lblNewLabel_2 = new JLabel("");
		 lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\BG.jpg"));
		 lblNewLabel_2.setBounds(0, 87, 1280, 567);
		 contentPane.add(lblNewLabel_2);
		setExtendedState(MAXIMIZED_BOTH);
	}
}
