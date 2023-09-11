package Ecommerce;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Paint;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.Painter;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class home extends JFrame {

	private JPanel contentPane;
	private JTextField logince;
	private JTextField signcn;
	private JTextField signcp;
	private JTextField signce;
	private JTextField an;
	private JTextField demail;
	JTabbedPane homecontent ;
	private JPasswordField logincp;
	private JPasswordField signcpass;
	private JPasswordField signccpass;
	private JPasswordField ap;
	public String mailpattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";

    public String mobilePattern = "^[0-9]*$";

    public String pwdpattern = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{6,20}$";
    private JPasswordField dpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1304, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new EmptyBorder(0, 0, 0, 0));
		p1.setBackground(new Color(16, 37, 71));
		p1.setBounds(0, 0, 1283, 87);
		contentPane.add(p1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\logo.png"));
		lblNewLabel.setBounds(958, 0, 325, 87);
		p1.add(lblNewLabel);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBorder(new EmptyBorder(0, 0, 0, 0));
		p2.setBackground(new Color(16, 37, 71));
		p2.setBounds(0, 85, 220, 572);
		contentPane.add(p2);
		
		JLabel customerbt = new JLabel("CUSTOMER");
		customerbt.setBounds(20, 140, 156, 60);
		p2.add(customerbt);
		customerbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homecontent.setSelectedIndex(1);
			}
		});
		customerbt.setHorizontalAlignment(SwingConstants.CENTER);
		customerbt.setForeground(new Color(255, 128, 64));
		customerbt.setFont(new Font("Tahoma", Font.BOLD, 16));
		customerbt.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		
		JLabel adminbt = new JLabel("ADMIN");
		adminbt.setBounds(20, 245, 156, 51);
		p2.add(adminbt);
		adminbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				homecontent.setSelectedIndex(3);
			}
		});
		adminbt.setHorizontalAlignment(SwingConstants.CENTER);
		adminbt.setForeground(new Color(255, 128, 64));
		adminbt.setFont(new Font("Tahoma", Font.BOLD, 16));
		adminbt.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		
		JLabel deliverybt = new JLabel("DELIVERY");
		deliverybt.setBounds(20, 335, 156, 60);
		p2.add(deliverybt);
		deliverybt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				homecontent.setSelectedIndex(4);
			}
		});
		deliverybt.setHorizontalAlignment(SwingConstants.CENTER);
		deliverybt.setForeground(new Color(255, 128, 64));
		deliverybt.setFont(new Font("Tahoma", Font.BOLD, 16));
		deliverybt.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(16, 37, 71), new Color(16, 37, 71), new Color(16, 37, 55), new Color(0, 64, 128)));
		
		homecontent = new JTabbedPane(JTabbedPane.TOP);
		homecontent.setBounds(192, 60, 1091, 597);
		contentPane.add(homecontent);
		
		JPanel home = new JPanel();
		homecontent.addTab("New tab", null, home, null);
		home.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\Anna Katrina.jpg"));
		lblNewLabel_1.setBounds(10, 0, 1076, 569);
		home.add(lblNewLabel_1);
		
		JPanel customerl = new JPanel();
		homecontent.addTab("New tab", null, customerl, null);
		customerl.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255,100));
		panel.setBounds(58, 47, 503, 498);
		customerl.add(panel);
		//panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(169, 22, 205, 62);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("EMAIL");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(10, 149, 118, 62);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("PASSWORD");
		lblNewLabel_2_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(10, 271, 118, 62);
		panel.add(lblNewLabel_2_1_1);
		
		logince = new JTextField();
		logince.setBackground(new Color(244, 244, 244));
		logince.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		logince.setBounds(138, 149, 279, 49);
		panel.add(logince);
		logince.setColumns(10);
		
		JLabel signflogin = new JLabel("New User? Sign Up");
		signflogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				homecontent.setSelectedIndex(2);
			}
		});
		signflogin.setHorizontalAlignment(SwingConstants.CENTER);
		signflogin.setForeground(new Color(0, 0, 128));
		signflogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		signflogin.setBounds(309, 399, 205, 62);
		panel.add(signflogin);
		
		JButton loginc = new JButton("LOGIN");
		loginc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					
					String email=logince.getText();
					if(email.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter Email");
					}
					else
					{
					String pass=logincp.getText();
					Connection con = jdbc.getCon();
					Statement st=con.createStatement();
					String query="Select * from customer where cemail='"+email+"' ;";
					ResultSet rs=st.executeQuery(query);
					while(rs.next())
					{
						if(!rs.getString("cpass").equals(pass))
						{
							JOptionPane.showMessageDialog(null, "Invalid Password");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Login Successful");
							//setVisible(false);
							int id=Integer.parseInt(rs.getString("cid"));
							System.out.println(id);
						    new products(rs.getString("cname"),id).setVisible(true);
						    setVisible(false);
						    
						    
						}
					}
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		loginc.setForeground(new Color(0, 0, 128));
		loginc.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginc.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		loginc.setBounds(10, 406, 134, 49);
		panel.add(loginc);
		
		logincp = new JPasswordField();
		logincp.setBackground(new Color(244, 244, 244));
		logincp.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		logincp.setBounds(138, 280, 279, 49);
		panel.add(logincp);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				logincp.setEchoChar((char)0);
			}
		});
		
		
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\pass.png"));
		lblNewLabel_3.setBounds(427, 280, 49, 49);
		panel.add(lblNewLabel_3);
		
		JLabel customerlbl = new JLabel("");
		customerlbl.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\Untitled design.jpg"));
		customerlbl.setBounds(0, 0, 1086, 569);
		customerl.add(customerlbl);
		
		JPanel customerr = new JPanel();
		homecontent.addTab("New tab", null, customerr, null);
		customerr.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 255, 255,100));
		panel_1.setBounds(516, 44, 545, 486);
		customerr.add(panel_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("SIGN UP");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(157, 11, 205, 62);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("PASSWORD");
		lblNewLabel_2_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 252, 109, 62);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JLabel loginfsign = new JLabel("Have an Account? Login");
		loginfsign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				homecontent.setSelectedIndex(1);
			}
		});
		loginfsign.setHorizontalAlignment(SwingConstants.CENTER);
		loginfsign.setForeground(new Color(0, 0, 128));
		loginfsign.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginfsign.setBounds(291, 401, 218, 62);
		panel_1.add(loginfsign);
		
		JButton signupc = new JButton("SIGN UP");
		signupc.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			{
				String name=signcn.getText();
				String ph=signcp.getText();
				String email=signce.getText();
				String pass=signcpass.getText();
				String conpass=signccpass.getText();
				if(!ph.matches(mobilePattern) || ph.length()!=10)
				{
					JOptionPane.showMessageDialog(null, "Enter valid Phone Number");
				}
				else if(!email.matches(mailpattern))
				{
					JOptionPane.showMessageDialog(null, "Enter valid Email ID");
				}
				else if(!pass.equals(conpass))
				{
					JOptionPane.showMessageDialog(null, "Password does not Match");
				}
				else
				{
		
					try
					{
						Connection con = jdbc.getCon();
						Statement st=con.createStatement();
						String query="insert into customer(cname,cemail,cphno,cpass) values('"+name+"','"+email+"','"+ph+"','"+pass+"')";
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Sign Up Successful");
						homecontent.setSelectedIndex(1);
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}
				}
			}
		});
		signupc.setForeground(new Color(0, 0, 128));
		signupc.setFont(new Font("Tahoma", Font.BOLD, 16));
		signupc.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		signupc.setBounds(10, 408, 140, 49);
		panel_1.add(signupc);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("NAME");
		lblNewLabel_2_1_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_3_1.setBounds(10, 84, 88, 62);
		panel_1.add(lblNewLabel_2_1_3_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_2_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1.setBounds(10, 316, 191, 62);
		panel_1.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_3_1_1 = new JLabel("PHONE");
		lblNewLabel_2_1_3_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_3_1_1.setBounds(10, 142, 88, 62);
		panel_1.add(lblNewLabel_2_1_3_1_1);
		
		JLabel lblNewLabel_2_1_3_1_2 = new JLabel("EMAIL");
		lblNewLabel_2_1_3_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_3_1_2.setBounds(10, 198, 88, 62);
		panel_1.add(lblNewLabel_2_1_3_1_2);
		
		signcn = new JTextField();
		signcn.setColumns(10);
		signcn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		signcn.setBackground(new Color(244, 244, 244));
		signcn.setBounds(197, 98, 282, 39);
		panel_1.add(signcn);
		
		signcp = new JTextField();
		signcp.setColumns(10);
		signcp.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		signcp.setBackground(new Color(244, 244, 244));
		signcp.setBounds(197, 156, 282, 39);
		panel_1.add(signcp);
		
		signce = new JTextField();
		signce.setColumns(10);
		signce.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		signce.setBackground(new Color(244, 244, 244));
		signce.setBounds(197, 212, 282, 39);
		panel_1.add(signce);
		
		signcpass = new JPasswordField();
		signcpass.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		signcpass.setBackground(new Color(244, 244, 244));
		signcpass.setBounds(197, 266, 282, 39);
		panel_1.add(signcpass);
		
		signccpass = new JPasswordField();
		signccpass.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		signccpass.setBackground(new Color(244, 244, 244));
		signccpass.setBounds(197, 330, 282, 39);
		panel_1.add(signccpass);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				signcpass.setEchoChar((char)0);
			}
		});
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\pass.png"));
		lblNewLabel_3_1.setBounds(486, 256, 49, 49);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				signccpass.setEchoChar((char)0);
			}
		});
		lblNewLabel_3_2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\pass.png"));
		lblNewLabel_3_2.setBounds(489, 326, 49, 39);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel customerlbl_1 = new JLabel("");
		customerlbl_1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\Untitled design.png"));
		customerlbl_1.setBounds(0, 0, 1086, 569);
		customerr.add(customerlbl_1);
		
		JPanel admin = new JPanel();
		homecontent.addTab("New tab", null, admin, null);
		admin.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255,255,255,100));
		panel_2.setBounds(46, 54, 507, 486);
		admin.add(panel_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("LOGIN");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(156, 11, 205, 62);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("USERNAME");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_2.setBounds(10, 145, 140, 62);
		panel_2.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("PASSWORD");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_2.setBounds(19, 269, 131, 62);
		panel_2.add(lblNewLabel_2_1_1_2);
		
		an = new JTextField();
		an.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		an.setColumns(10);
		an.setBackground(new Color(244, 244, 244));
		an.setBounds(160, 154, 319, 49);
		panel_2.add(an);
		
		JButton loginc_1 = new JButton("LOGIN");
		loginc_1.setBackground(new Color(240, 240, 240));
		loginc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(an.getText().equals("admin") && ap.getText().equals("admin"))
				{
					JOptionPane.showMessageDialog(null, "Login Successful");
					Admin a=new Admin();
					a.setVisible(true);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Admin Login");
				}
			}
		});
		loginc_1.setForeground(new Color(0, 0, 128));
		loginc_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginc_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		loginc_1.setBounds(31, 399, 131, 49);
		panel_2.add(loginc_1);
		
		ap = new JPasswordField();
		ap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ap.setBackground(new Color(244, 244, 244));
		ap.setBounds(160, 278, 319, 49);
		panel_2.add(ap);
		
		JLabel customerlbl_2 = new JLabel("");
		customerlbl_2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\Untitled design.jpg"));
		customerlbl_2.setBounds(0, 0, 1086, 569);
		admin.add(customerlbl_2);
		
		JPanel delivery = new JPanel();
		homecontent.addTab("New tab", null, delivery, null);
		delivery.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(255,255,255,100));
		panel_3.setBounds(47, 50, 500, 486);
		delivery.add(panel_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("LOGIN");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4.setBounds(146, 11, 205, 62);
		panel_3.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("EMAIL");
		lblNewLabel_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_3.setBounds(0, 136, 141, 62);
		panel_3.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("PASSWORD");
		lblNewLabel_2_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_3.setBounds(10, 271, 157, 62);
		panel_3.add(lblNewLabel_2_1_1_3);
		
		demail = new JTextField();
		demail.setColumns(10);
		demail.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		demail.setBackground(new Color(244, 244, 244));
		demail.setBounds(171, 145, 261, 49);
		panel_3.add(demail);
		
		JButton loginc_2 = new JButton("LOGIN");
		loginc_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					
					String email=demail.getText();
					if(email.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter Email");
					}
					else
					{
					String pass=dpass.getText();
					Connection con = jdbc.getCon();
					Statement st=con.createStatement();
					String query="Select * from dpartner where demail='"+email+"' ;";
					ResultSet rs=st.executeQuery(query);
					while(rs.next())
					{
						if(!rs.getString("dpass").equals(pass))
						{
							JOptionPane.showMessageDialog(null, "Invalid Password");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Login Successful");
							int id=Integer.parseInt(rs.getString("delid"));
							String delname=rs.getString(2);
							String delphn=rs.getString(4);
							//System.out.println(id);
						    delivery d=new delivery(id);
						    d.setVisible(true);
						    setVisible(false);
						    d.dname.setText(delname);
						    d.dno.setText(String.valueOf(id));
						    d.demail.setText(email);
						    d.dphn.setText(delphn);
						    
						    
						    
						}
					}
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		loginc_2.setForeground(new Color(0, 0, 128));
		loginc_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginc_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		loginc_2.setBounds(37, 408, 127, 49);
		panel_3.add(loginc_2);
		
		dpass = new JPasswordField();
		dpass.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		dpass.setBackground(new Color(244, 244, 244));
		dpass.setBounds(171, 271, 261, 49);
		panel_3.add(dpass);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dpass.setEchoChar((char)0);
			}
		});
		lblNewLabel_3_3.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\pass.png"));
		lblNewLabel_3_3.setBounds(441, 271, 49, 49);
		panel_3.add(lblNewLabel_3_3);
		
		JLabel customerlbl_3 = new JLabel("");
		customerlbl_3.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\Untitled design.jpg"));
		customerlbl_3.setBounds(0, 0, 1086, 569);
		delivery.add(customerlbl_3);
		setExtendedState(MAXIMIZED_BOTH);
	}
}
