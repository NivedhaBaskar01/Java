package Ecommerce;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.print.*;
import java.util.ArrayList;

import javax.swing.JTable;
//import javafx.print.Printer;

public class bill extends JFrame {

	JPanel contentPane;
	JPanel b;
	JTextField finalp;
	//protected Object b;
	JPanel panel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill frame = new bill();
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
	public bill(ArrayList<String> n,ArrayList<Integer> q,ArrayList<Double> p,String tot) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel b = new JPanel();
		b.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		b.setBackground(new Color(255, 255, 255));
		b.setBounds(23, 11, 766, 624);
		contentPane.add(b);
		b.setLayout(null);
		
		JLabel l2 = new JLabel("");
		l2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\thankyou1.png"));
		l2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		l2.setBounds(10, 550, 205, 63);
		b.add(l2);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Downloads\\logo1.png"));
		l1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		l1.setBounds(10, 11, 504, 98);
		b.add(l1);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 120, 735, 419);
		b.add(panel);
		panel.setLayout(null);
		
		finalp = new JTextField();
		finalp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		finalp.setFont(new Font("Tahoma", Font.BOLD, 18));
		finalp.setBounds(296, 342, 141, 49);
		panel.add(finalp);
		finalp.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(176, 351, 85, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nivedha.b\\Pictures\\receipt.png"));
		lblNewLabel_2.setBounds(32, 29, 405, 65);
		panel.add(lblNewLabel_2);
		//gb.add(t);
		finalp.setText(tot);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setBounds(35, 128, 562, 197);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Consolas", Font.BOLD, 14));
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"NAME", "QUANTITY", "PRICE"
			}
		));
		scrollPane.setViewportView(table);
		table.setBackground(new Color(235, 235, 235));
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		for(int i=0;i<n.size();i++)
		{
		
			//System.out.println(n.get(i));
			dt.addRow(new Object[] {n.get(i),q.get(i),p.get(i)});
		}
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(235, 235, 235));
		btnNewButton.setBounds(643, 36, 89, 36);
		b.add(btnNewButton);
	}
}
