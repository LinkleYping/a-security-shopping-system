package System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Frame4 {

	public JFrame frame;
	public String s;
	private String FPriKey;
	public String FPubKey,Fn,hash,signature;
	//public String date;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame4 window = new Frame4();
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
	private void start(){
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
	public Frame4(String s,String hash) {
		this.s=s;
		this.hash=hash;
		int flag=0;
		String str=new String(); 
		   BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("test.txt"));
			try {
				while((str=in.readLine())!=null)
				  {
				        if(str.indexOf("shop")>=0)
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
				        if(str.indexOf("shop")>=0)
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
			String strr1="shop"+" "+FPubKey+" "+Fn+"\r\n";
			String strr2="shop"+" "+FPriKey+"\r\n";
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("商店签名验证");
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
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 484, 118);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8D2D\u4E70\u7801\u5982\u4E0B");
		label.setFont(new Font("幼圆", Font.BOLD, 16));
		label.setBounds(39, 48, 116, 34);
		panel.add(label);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource().equals(button_1)){
					frame.dispose();
					start();
				}
			}
		});
		button_1.setFont(new Font("幼圆", Font.BOLD, 12));
		button_1.setBackground(new Color(255, 250, 240));
		button_1.setBounds(407, 48, 67, 34);
		panel.add(button_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setForeground(Color.BLACK);
		textArea.setBounds(165, 31, 209, 77);
		//panel.add(textArea);
		textArea.setLineWrap(true);//激活自动换行功能 
		textArea.setWrapStyleWord(true);//激活断行不断字功能
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(165, 31, 209, 73);
		panel.add(scrollPane);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 115, 484, 246);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u5E97\u516C\u94A5");
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 16));
		lblNewLabel_1.setBounds(38, 50, 84, 33);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u8BA4\u8BC1\u7ED3\u679C\u5982\u4E0B");
		label_1.setFont(new Font("幼圆", Font.BOLD, 16));
		label_1.setBounds(38, 150, 127, 33);
		panel_1.add(label_1);
		
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 250, 240));
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setBounds(165, 28, 203, 74);
		//panel_1.add(textArea_1);
		textArea_1.setLineWrap(true);//激活自动换行功能 
		textArea_1.setWrapStyleWord(true);//激活断行不断字功能
		textArea_1.setEditable(false);
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setBounds(165, 28, 203,70);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("幼圆", Font.PLAIN, 13));
		textArea_2.setBackground(new Color(255, 250, 240));
		textArea_2.setForeground(Color.BLACK);
		textArea_2.setBounds(165, 138, 280, 100);
		textArea_2.setLineWrap(true);//激活自动换行功能 
		textArea_2.setWrapStyleWord(true);//激活断行不断字功能
		textArea_2.setEditable(false);
		//panel_1.add(textArea_2);
		JScrollPane scrollPane_2 = new JScrollPane(textArea_2);
		scrollPane_2.setBounds(165, 138, 280,102);
		panel_1.add(scrollPane_2);
		
		//String a = new String("本商店将商品"+s+"卖给顾客");
		//hash=String.valueOf(Math.abs(a.hashCode()));
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String date=df.format(new Date());
		hash=hash+date;
		//System.out.println("2"+hash);
		BigInteger kPriKey=new BigInteger(FPriKey,10);
		BigInteger kn=new BigInteger(Fn,10);
		//BigInteger ndate=new BigInteger(date,10);
		//BigInteger nhash=new BigInteger(hash,10);
		//hash=String.valueOf(ndate.add(nhash));
		
		signature = RSA.Encrypt(hash, kPriKey,kn);
		BigInteger kPubKey=new BigInteger(FPubKey,10);
		String rr=RSA.Encrypt(signature, kPubKey,kn);
		textArea.setText(signature);
		//System.out.println("3"+signature);
		//System.out.println("lll"+hash);
		//System.out.println("woo"+rr);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("2.png"));
		lblNewLabel_2.setBounds(0, 0, 484, 423);
		panel.add(lblNewLabel_2);
		textArea_1.setText(Fn);
		BigInteger kPubKey1=new BigInteger(FPubKey,10);
		//BigInteger kn=new BigInteger(Fn,10);
		
		String rr1=RSA.Encrypt(signature, kPubKey1,kn);
		String strr;
		strr=s+" "+hash+" "+signature+"\r\n";
		 try {
			   // 按读写方式创建一个随机访问文件流
			   RandomAccessFile raf = new RandomAccessFile("2.txt", "rw");
			   long fileLength = raf.length();// 获取文件的长度即字节数
			   // 将写文件指针移到文件尾。
			   raf.seek(fileLength);
			   // 按字节的形式将内容写到随机访问文件流中
			   raf.writeBytes(strr);
			   // 关闭流
			   raf.close();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }

		
		JButton button = new JButton("\u8BA4\u8BC1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//signature=textArea.getText().toString(); 
				//System.out.println("4"+rr);
				//System.out.println("\r\n"+Fn+"\r\n"+FPriKey);
				String out="";
				out="本商店将商品"+s+"卖给顾客"+"\r\n";
				out+="Hashcode=\r\n"+hash+"\r\n";
				//if(rr.length()>hash.length()+5)
					out+="验证出来Hashcode="+"\r\n"+rr1+"\r\n";
				//else
					//out+="验证出来Hashcode="+rr+"\r\n";
				textArea_2.setText(out);
			}
		});
		button.setBackground(new Color(255, 250, 240));
		button.setFont(new Font("幼圆", Font.BOLD, 12));
		button.setBounds(404, 97, 70, 33);
		panel_1.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("2.png"));
		lblNewLabel.setBounds(0, -53, 484, 299);
		panel_1.add(lblNewLabel);
	}

}
