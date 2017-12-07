package System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Frame3 {
	public String s;
	public JFrame frame;
	public String hash,Signature,PubKey,n;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 window = new Frame3(null);
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
	private void start(String s){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//System.out.println("1"+Signature);
					//String.valueOf(Math.abs(Signature.hashCode()))
					Frame4 window = new Frame4(s,String.valueOf(Math.abs(Signature.hashCode())));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	
	private void start0(){
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
	public Frame3(String s) {
		this.s=s;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("授权书验证");
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
		panel.setBounds(0, 0, 484, 277);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6388\u6743\u7801");
		lblNewLabel.setBounds(42, 56, 77, 39);
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5DE5\u5382\u516C\u94A5");
		lblNewLabel_1.setBounds(37, 141, 82, 29);
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 16));
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u8BA4\u8BC1\u7ED3\u679C");
		label.setBounds(44, 216, 87, 21);
		label.setFont(new Font("幼圆", Font.BOLD, 16));
		panel.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setForeground(Color.BLACK);
		textArea.setBounds(143, 43, 314, 66);
		//panel.add(textArea);
		textArea.setLineWrap(true);//激活自动换行功能 
		textArea.setWrapStyleWord(true);//激活断行不断字功能
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(143, 43, 314, 63);
		panel.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 250, 240));
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setBounds(143, 116, 216, 74);
		//panel.add(textArea_1);
		textArea_1.setLineWrap(true);//激活自动换行功能 
		textArea_1.setWrapStyleWord(true);//激活断行不断字功能
		textArea_1.setEditable(false);
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setBounds(143, 116, 216, 70);
		panel.add(scrollPane_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("幼圆", Font.PLAIN, 13));
		textArea_2.setBackground(new Color(255, 250, 240));
		textArea_2.setForeground(Color.BLACK);
		textArea_2.setBounds(141, 200, 333, 67);
		//panel.add(textArea_2);
		textArea_2.setLineWrap(true);//激活自动换行功能 
		textArea_2.setWrapStyleWord(true);//激活断行不断字功能
		textArea_2.setEditable(false);
		JScrollPane scrollPane_2 = new JScrollPane(textArea_2);
		scrollPane_2.setBounds(141, 200, 333, 65);
		panel.add(scrollPane_2);
		
		 String str=new String(); 
	   BufferedReader in;
	   int flag=0;
	try {
		in = new BufferedReader(new FileReader("1.txt"));
		try {
			while((str=in.readLine())!=null)
			  {
			        if(str.indexOf(s)>=0)
			        {
			        	flag=1;
			        	int i=str.indexOf(" ");
			        	i=i+1;
			        	int j=str.indexOf(" ",i);
			        	hash=str.substring(i, j);
			        	j=j+1;
			        	i=str.length();
			        	Signature=str.substring(j,i);
			        }
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	try {
		in = new BufferedReader(new FileReader("test.txt"));
		try {
			while((str=in.readLine())!=null)
			  {
			        if(str.indexOf("factory")>=0)
			        {
			        	//flag=1;
			        	int i=str.indexOf(" ");
			        	i=i+1;
			        	int j=str.indexOf(" ",i);
			        	PubKey=str.substring(i, j);
			        	j=j+1;
			        	i=str.length();
			        	n=str.substring(j,i);
			        }
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	if(flag==0)
	{
		RSA rsa = new RSA();
		rsa.CreateKey();//创建一个新密钥对
		String a = new String("将商品"+s+"授权给商店");
		hash=String.valueOf(Math.abs(a.hashCode()));
		Signature = RSA.Encrypt(String.valueOf(Math.abs(a.hashCode())), rsa.PriKey,rsa.n);
	}
	  textArea.setText(Signature);
	  textArea_1.setText(n);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 276, 484, 85);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton btnNewButton = new JButton("认证");
		btnNewButton.setBounds(380, 137, 77, 39);
		btnNewButton.setBackground(new Color(255, 250, 240));
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton))
				{
					BigInteger kPubKey=new BigInteger(PubKey,10);
					BigInteger kn=new BigInteger(n,10);
					String out="";
					String rr=RSA.Encrypt(Signature, kPubKey,kn);
						out="授权时间:2017.06.01-2018.06.01\r\n"+"商品名称:"+s+"\r\n"
								+"授权方:徐某\r\n"+"被授权方:北京市中关村某街道王征王店\r\n";
						out+="Hashcode="+hash+"\r\n";
						if(rr.length()>hash.length()+5)
							out+="验证出来Hashcode="+"\r\n"+rr+"\r\n";
						else
							out+="验证出来Hashcode="+rr+"\r\n";
					textArea_2.setText(out);
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("购买");
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(255, 250, 240));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_1)){
					frame.dispose();
					start(s);
				}
			}
		});
		btnNewButton_1.setBounds(79, 25, 93, 42);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("2.png"));
		lblNewLabel_2.setBounds(0, -10, 484, 287);
		panel.add(lblNewLabel_2);
		
		
		JButton btnNewButton_2 = new JButton("放弃购买");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				start0();
			}
		});
		btnNewButton_2.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(255, 250, 240));
		btnNewButton_2.setBounds(295, 25, 93, 42);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("2.png"));
		lblNewLabel_3.setBounds(0, -402, 484, 518);
		panel_1.add(lblNewLabel_3);
	}
}
