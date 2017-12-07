package System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Frame {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Welcome");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setFont(new Font("Ó×Ô²", Font.PLAIN, 16));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	     int windowWidth = frame.getWidth();                     
	     int windowHeight = frame.getHeight();                      
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();             
	     int screenWidth = screenSize.width;                     
	     int screenHeight = screenSize.height;                  
	     frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
		JButton btnNewButton_1 = new JButton("¹Ë¿Í¹ºÎï");
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setFont(new Font("Ó×Ô²", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_1)){
			     frame.setVisible(false);
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
				}
			}
		});
		
		JButton btnNewButton = new JButton("¹¤³§ÊÚÈ¨");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("Ó×Ô²", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		  if(arg0.getSource().equals(btnNewButton)){
		    frame.dispose();
		    EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Frame2 window = new Frame2();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
					}
			}
		});
		JButton btnNewButton_2 = new JButton("¹Ë¿ÍÍË»õ");
		
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setFont(new Font("Ó×Ô²", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		  if(arg0.getSource().equals(btnNewButton_2)){
		    frame.dispose();
		    EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Frame5 window = new Frame5();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
					}
			}
		});
	
		btnNewButton.setBounds(160, 79, 114, 39);
		frame.getContentPane().add(btnNewButton);
		btnNewButton_1.setBounds(160, 149, 114, 39);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_2.setBounds(160, 213, 114, 39);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("2.png"));
		lblNewLabel.setBounds(0, 0, 484, 361);
		frame.getContentPane().add(lblNewLabel);
		
	}	
}

