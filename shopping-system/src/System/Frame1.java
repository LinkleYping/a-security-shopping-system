package System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class Frame1 {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void start(String s){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 window = new Frame3(s);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ÉÌÆ·¹ºÂò");
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		int windowWidth = frame.getWidth();                     
	     int windowHeight = frame.getHeight();                      
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();             
	     int screenWidth = screenSize.width;                     
	     int screenHeight = screenSize.height;                  
	     frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(253, 245, 230));
		panel.setBounds(0, 81, 484, 280);
		frame.getContentPane().add(panel);
	    JButton btnNewButton_1 = new JButton("A");
		btnNewButton_1.setBackground(new Color(255, 250, 240));
		btnNewButton_1.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_1)){
					
						frame.dispose();
						start("A");}
				}
			});
		panel.setLayout(null);
		btnNewButton_1.setBounds(30, 62, 63, 50);
		panel.add(btnNewButton_1);
		JButton btnNewButton = new JButton("B");
		btnNewButton.setBackground(new Color(255, 250, 240));
		btnNewButton.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton)){
					    frame.dispose();
						start("B");}
			}
		});
		btnNewButton.setBounds(122, 62, 63, 50);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("C");
		btnNewButton_2.setBackground(new Color(255, 250, 240));
		btnNewButton_2.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_2)){
				frame.dispose();
				start("C");
				}
			}
		});
		btnNewButton_2.setBounds(210, 62, 63, 50);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("D");
		btnNewButton_3.setBackground(new Color(255, 250, 240));
		btnNewButton_3.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_3)){
					    frame.dispose();
						start("D");}
			}
		});
		btnNewButton_3.setBounds(297, 62, 63, 50);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("E");
		btnNewButton_4.setBackground(new Color(255, 250, 240));
		btnNewButton_4.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_4)){
					frame.dispose();
					start("E");}
			}
		});
		btnNewButton_4.setBounds(383, 62, 63, 50);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("J");
		btnNewButton_5.setBackground(new Color(255, 250, 240));
		btnNewButton_5.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_5)){
					frame.dispose();
					start("J");
	     }
	    }
		});
		btnNewButton_5.setBounds(383, 183, 63, 50);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("F");
		btnNewButton_6.setBackground(new Color(255, 250, 240));
		btnNewButton_6.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_6)){
					frame.dispose();
					start("F");
				}
			}
		});
		btnNewButton_6.setBounds(30, 183, 63, 50);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("G");
		btnNewButton_7.setBackground(new Color(255, 250, 240));
		btnNewButton_7.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_7)){
					frame.dispose();
					start("G");
				}
			}
		});
		btnNewButton_7.setBounds(122, 183, 63, 50);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("H");
		btnNewButton_8.setBackground(new Color(255, 250, 240));
		btnNewButton_8.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_8)){
					frame.dispose();
					start("H");
				}
				
			}
		});
		btnNewButton_8.setBounds(210, 183, 63, 50);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("I");
		btnNewButton_9.setBackground(new Color(255, 250, 240));
		btnNewButton_9.setFont(new Font("Ó×Ô²", Font.BOLD, 12));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_9)){
					frame.dispose();
					start("I");
				}
			}
		});
		btnNewButton_9.setBounds(297, 183, 63, 50);
		panel.add(btnNewButton_9);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("2.png"));
		lblNewLabel.setBounds(0, -306, 484, 586);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(0, 0, 484, 83);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("\u8BF7\u60A8\u6311\u9009\u9700\u8981\u7684\u5546\u54C1");
		label_1.setFont(new Font("Ó×Ô²", Font.BOLD, 16));
		label_1.setBounds(155, 52, 213, 31);
		panel_2.add(label_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnBack)){
					frame.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Frame window = new Frame();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnBack.setBackground(new Color(255, 235, 205));
		btnBack.setFont(new Font("Ó×Ô²", Font.BOLD, 14));
		btnBack.setBounds(10, 9, 70, 23);
		panel_2.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("2.png"));
		label.setBounds(0, 0, 484, 137);
		panel_2.add(label);
	}
}
			
