package System;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Frame2 {

	public JFrame frame;
	private String FPriKey;
	public String FPubKey,Fn,Signature,hash;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the application.
	 */
	public Frame2() {
		int flag=0;
		String str=new String(); 
		   BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("test.txt"));
			try {
				while((str=in.readLine())!=null)
				  {
				        if(str.indexOf("factory")>=0)
				        {
				        	flag=1;
				        	int i=str.indexOf(" ");
				        	i=i+1;
				        	int j=str.indexOf(" ",i);
				        	FPubKey=str.substring(i, j);
				        	j=j+1;
				        	i=str.length();
				        	Fn=str.substring(j,i);
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
			in = new BufferedReader(new FileReader("words.txt"));
			try {
				while((str=in.readLine())!=null)
				  {
				        if(str.indexOf("factory")>=0)
				        {
				        	flag=1;
				        	int i=str.indexOf(" ");
				        	i=i+1;
				        	int j=str.length();
				        	FPriKey=str.substring(i,j);
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
			FPriKey=rsa.PriKey.toString();
			FPubKey=rsa.PubKey.toString();
			Fn=rsa.n.toString();
			String strr1="factory"+" "+FPubKey+" "+Fn+"\r\n";
			String strr2="factory"+" "+FPriKey+"\r\n";
			try {
				   // 按读写方式创建一个随机访问文件流
				   RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
				   long fileLength = raf.length();// 获取文件的长度即字节数
				   // 将写文件指针移到文件尾。
				   raf.seek(fileLength);
				   // 按字节的形式将内容写到随机访问文件流中
				   raf.writeBytes(strr1);
				   // 关闭流
				   raf.close();
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			try {
			   // 按读写方式创建一个随机访问文件流
			   RandomAccessFile raf = new RandomAccessFile("words.txt", "rw");
			   long fileLength = raf.length();// 获取文件的长度即字节数
			   // 将写文件指针移到文件尾。
			   raf.seek(fileLength);
			   // 按字节的形式将内容写到随机访问文件流中
			   raf.writeBytes(strr2);
			   // 关闭流
			   raf.close();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
		}
		initialize();
	}
	
	public void nony(String sttr)
	{
		String a="授权时间:2017.06.01-2018.06.01\r\n"+"商品名称:"+sttr+"\r\n"
				+"授权方:徐某\r\n"+"被授权方:北京市中关村某街道王征王店\r\n";
		//String a = new String("将商品"+sttr+"授权给商店");
		hash=String.valueOf(Math.abs(a.hashCode()));
		BigInteger kPriKey=new BigInteger(FPriKey,10);
		BigInteger kn=new BigInteger(Fn,10);
		Signature = RSA.Encrypt(String.valueOf(Math.abs(a.hashCode())), kPriKey,kn);
		String str;
		str=sttr+" "+hash+" "+Signature+"\r\n";
		 try {
			   // 按读写方式创建一个随机访问文件流
			   RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
			   long fileLength = raf.length();// 获取文件的长度即字节数
			   // 将写文件指针移到文件尾。
			   raf.seek(fileLength);
			   // 按字节的形式将内容写到随机访问文件流中
			   raf.writeBytes(str);
			   // 关闭流
			   raf.close();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("工厂授权");
		frame.setBounds(100, 100, 500, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int windowWidth = frame.getWidth();                     
	     int windowHeight = frame.getHeight();                      
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();             
	     int screenWidth = screenSize.width;                     
	     int screenHeight = screenSize.height;                  
	     frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 484, 50);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("\u8BF7\u60A8\u9009\u62E9\u8981\u6388\u6743\u7684\u5546\u54C1");
		label_1.setFont(new Font("幼圆", Font.BOLD, 16));
		label_1.setBounds(158, 36, 197, 35);
		panel_2.add(label_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(255, 250, 240));
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
		btnBack.setFont(new Font("幼圆", Font.BOLD, 14));
		btnBack.setBounds(10, 9, 70, 23);
		panel_2.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_2.add(panel_1);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 258, 484, 119);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u6388\u6743\u7801\u5982\u4E0B");
		label.setBounds(10, 45, 85, 37);
		label.setFont(new Font("幼圆", Font.BOLD, 16));
		panel_1.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(105, 10, 369, 91);
		textArea.setForeground(Color.BLACK);
		textArea.setLineWrap(true);//激活自动换行功能 
		textArea.setWrapStyleWord(true);//激活断行不断字功能
		//panel_1.add(textArea);
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(105, 10, 369, 85);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("2.png"));
		lblNewLabel_2.setBounds(0, -303, 494, 422);
		panel_1.add(lblNewLabel_2);
		//panel_1.add(new   JScrollPane(textArea));
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setBackground(new Color(253, 245, 230));
		panel.setBounds(0, 71, 488, 189);
		
		
		
		JButton btnNewButton_1 = new JButton("A");
		btnNewButton_1.setBackground(new Color(255, 250, 240));
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_1)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("A");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		panel.setLayout(null);
		btnNewButton_1.setBounds(30, 33, 63, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("B");
		btnNewButton.setBackground(new Color(255, 250, 240));
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("B");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton.setBounds(122, 33, 63, 50);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("C");
		btnNewButton_2.setBackground(new Color(255, 250, 240));
		btnNewButton_2.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_2)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("C");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton_2.setBounds(208, 33, 63, 50);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("D");
		btnNewButton_3.setBackground(new Color(255, 250, 240));
		btnNewButton_3.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_3)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("D");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton_3.setBounds(296, 33, 63, 50);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("E");
		btnNewButton_4.setBackground(new Color(255, 250, 240));
		btnNewButton_4.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_4)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("E");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton_4.setBounds(387, 33, 63, 50);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("J");
		btnNewButton_5.setBackground(new Color(255, 250, 240));
		btnNewButton_5.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_5)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("J");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton_5.setBounds(387, 128, 63, 50);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("F");
		btnNewButton_6.setBackground(new Color(255, 250, 240));
		btnNewButton_6.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_6)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("F");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton_6.setBounds(30, 128, 63, 50);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("G");
		btnNewButton_7.setBackground(new Color(255, 250, 240));
		btnNewButton_7.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_7)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("G");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton_7.setBounds(122, 128, 63, 50);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("H");
		btnNewButton_8.setBackground(new Color(255, 250, 240));
		btnNewButton_8.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_8)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("H");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton_8.setBounds(208, 128, 63, 50);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("I");
		btnNewButton_9.setBackground(new Color(255, 250, 240));
		btnNewButton_9.setFont(new Font("幼圆", Font.BOLD, 12));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(btnNewButton_9)){
					int n= JOptionPane.showConfirmDialog(null,
						       "是否将该商品授权给商店", "授权确认", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nony("I");
						 textArea.setText(Signature);
					}
					else if(n==JOptionPane.NO_OPTION){
						return;
					}
				}
			}
		});
		btnNewButton_9.setBounds(296, 128, 63, 50);
		panel.add(btnNewButton_9);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("2.png"));
		lblNewLabel_1.setBounds(0, 0, 488, 189);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("2.png"));
		lblNewLabel.setBounds(0, 0, 484, 332);
		panel_2.add(lblNewLabel);
	}
}
