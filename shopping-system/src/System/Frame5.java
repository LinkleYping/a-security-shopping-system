package System;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame5 {

     public JFrame frame;
     public String hash,signature;
     public String SPkey,SPn;//�̵깫Կ
     public String FPkey,FPn;//������Կ
     //public String date;

	/**
	 * Launch the application.
	 */
	
	public Frame5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("�˻�");
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
		
		JLabel label_1 = new JLabel("\u8BF7\u60A8\u9009\u62E9\u8981\u9000\u56DE\u7684\u5546\u54C1");
		label_1.setFont(new Font("��Բ", Font.BOLD, 16));
		label_1.setBounds(45, 76, 197, 35);
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
		btnBack.setFont(new Font("��Բ", Font.BOLD, 14));
		btnBack.setBounds(10, 9, 70, 23);
		panel_2.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_2.add(panel_1);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 156, 484, 221);
		panel_1.setLayout(null);
		
		JComboBox selectBox = new JComboBox();
		selectBox.setFont(new Font("��Բ", Font.BOLD, 12));
		selectBox.setBackground(new Color(255, 239, 213));
		selectBox.setBounds(265, 76, 115, 35);
		panel_2.add(selectBox);
		selectBox.addItem("A");
		selectBox.addItem("B");
		selectBox.addItem("C");
		selectBox.addItem("D");
		selectBox.addItem("E");
		selectBox.addItem("F");
		selectBox.addItem("G");
		selectBox.addItem("H");
		selectBox.addItem("I");
		selectBox.addItem("J");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("2.png"));
		lblNewLabel.setBounds(-16, -25, 543, 305);
		panel_2.add(lblNewLabel);
		selectBox.setVisible(true);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("��Բ", Font.BOLD, 12));
		textArea.setBackground(new Color(255, 239, 213));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBounds(159, 48, 321, 151);
		//panel_1.add(textArea);
		textArea.setLineWrap(true);//�����Զ����й��� 
		textArea.setWrapStyleWord(true);//������в����ֹ���
		textArea.setEditable(false);
		//panel_1.add(textArea_2);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(159, 48, 321,153);
		panel_1.add(scrollPane);
		
		JButton btnNewButton_10 = new JButton("ȷ���˻�");
		btnNewButton_10.setBackground(new Color(255, 239, 213));
		btnNewButton_10.setFont(new Font("��Բ", Font.BOLD, 12));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String Str_A = selectBox.getSelectItem().toString();
				String s1 = selectBox.getItemAt( selectBox.getSelectedIndex() ).toString();
				String str=new String(); 
				   BufferedReader in;
				   int flag=0;
				try {
					in = new BufferedReader(new FileReader("2.txt"));
					try {
						while((str=in.readLine())!=null)
						  {
						        if(str.indexOf(s1)>=0)
						        {
						        	flag=1;
						        	int i=str.indexOf(" ");
						        	i=i+1;
						        	int j=str.indexOf(" ",i);
						        	hash=str.substring(i, j);
						        	j=j+1;
						        	i=str.length();
						        	signature=str.substring(j,i);
						        }
						        if(flag==1)
						        	break;
						  }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				if(flag==0)
				{
					RSA rsa = new RSA();
					rsa.CreateKey();//����һ������Կ��
					String a="��Ȩʱ��:2017.06.01-2018.06.01\r\n"+"��Ʒ����:"+s1+"\r\n"
							+"��Ȩ��:��ĳ\r\n"+"����Ȩ��:�������йش�ĳ�ֵ���������\r\n";
					//SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					//String date=df.format(new Date());
					hash=String.valueOf(Math.abs(a.hashCode()));
					signature = RSA.Encrypt(String.valueOf(Math.abs(a.hashCode())), rsa.PriKey,rsa.n);
				}
				if(flag==1)
				{
				        File file = new File("2.txt");
				        BufferedReader br;
				        int flag1=0;
						try {
							br = new BufferedReader(new FileReader(file));
							StringBuilder sb = new StringBuilder();
					        String temp;
					        while((temp=br.readLine())!=null){
					            if(temp.startsWith(s1)&&flag1==0){
					            	flag1=1;
					                continue;
					            }
					            sb.append(temp+"\r\n");
					        }
					        br.close();
					        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					        bw.write(sb.toString());
					        bw.close();
					        //System.out.println("ɾ�� ���  OK!");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
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
						        	SPkey=str.substring(i, j);
						        	j=j+1;
						        	i=str.length();
						        	SPn=str.substring(j,i);
						        }
						  }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				BigInteger kPubKey=new BigInteger(SPkey,10);
				BigInteger kn=new BigInteger(SPn,10);
				String out="";
				String rr=RSA.Encrypt(signature, kPubKey,kn);
				//out+="Hashcode=\r\n"+hash+"\r\n";
				//out+="��֤����Hashcode="+"\r\n"+signature+"\r\n";
				String a="��Ȩʱ��:2017.06.01-2018.06.01\r\n"+"��Ʒ����:"+s1+"\r\n"
						+"��Ȩ��:��ĳ\r\n"+"����Ȩ��:�������йش�ĳ�ֵ���������\r\n";
				out+=a+"\r\nHashcode=\r\n"+hash+"\r\n";
				out+="��֤����Hashcode="+"\r\n"+rr+"\r\n";
				if(hash.equals(rr)==true)
					out+="\r\n�ðɣ������˻����´�����Ŷ~";
				else
					out+="\r\nƭ�ӣ�����ͥ��~";
				textArea.setText(out);
				//textArea.setText(out);
			}
		});
		btnNewButton_10.setBounds(10, 100, 139, 30);
		panel_1.add(btnNewButton_10);
		
		/*JButton btnNewButton_11 = new JButton("������Կ���ܽ��");
		btnNewButton_11.setBackground(new Color(255, 239, 213));
		btnNewButton_11.setFont(new Font("��Բ", Font.BOLD, 12));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = selectBox.getItemAt( selectBox.getSelectedIndex() ).toString();
				if(hash==null||signature==null)
				{
					String str="�ԣ������̵깫Կ�⿪��һ��ǩ��������";
					textArea.setText(str);
				}
				else
				{
					BufferedReader in;
					String str=new String(); 
					try {
						in = new BufferedReader(new FileReader("test.txt"));
						try {
							while((str=in.readLine())!=null)
							  {
							        if(str.indexOf("factory")>=0)
							        {
							        	int i=str.indexOf(" ");
							        	i=i+1;
							        	int j=str.indexOf(" ",i);
							        	FPkey=str.substring(i, j);
							        	j=j+1;
							        	i=str.length();
							        	FPn=str.substring(j,i);
							        }
							  }
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					BigInteger nsignature=new BigInteger(signature,10);
					BigInteger ndate=new BigInteger(date,10);
					
					String signature1=String.valueOf(nsignature.add(ndate.multiply(new BigInteger("-1"))));
					BigInteger FPubKey=new BigInteger(FPkey,10);
					BigInteger Fn=new BigInteger(FPn,10);
					String out="";
					String rr=RSA.Encrypt(signature1, FPubKey,Fn);
					String a="��Ȩʱ��:2017.06.01-2018.06.01\r\n"+"��Ʒ����:"+s1+"\r\n"
							+"��Ȩ��:��ĳ\r\n"+"����Ȩ��:�������йش�ĳ�ֵ���������\r\n";
					//hash=String.valueOf(Math.abs(a.hashCode()));
					out+=a+"\r\nHashcode=\r\n"+hash+"\r\n";
					out+="��֤����Hashcode="+"\r\n"+rr+"\r\n";
					textArea.setText(out);
				}
			}
		});
		btnNewButton_11.setBounds(10, 148, 139, 30);
		panel_1.add(btnNewButton_11);*/
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("2.png"));
		lblNewLabel_2.setBounds(0, -303, 494, 524);
		panel_1.add(lblNewLabel_2);
		
	}
}



