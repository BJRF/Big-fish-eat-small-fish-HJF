package com.hjf.fishGame0112;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ThreadFish implements Runnable {
	Graphics g;
	JPanel j;
	ImageIcon imgi1;
	threadotherfishlist todl;
	List<AllFish> otherfish;
	AllFish mf;
	collision cl = new collision();
	int score = 0;
	public int myfishsize;
	boolean bo = false;
	int n,i=0,date;
	File f;
	private int jilu;
	String str;
	String name;
//	HashMap<String, Integer> DataMap = new HashMap<>(); 
	
	public ThreadFish(Graphics g, JPanel j, List<AllFish> otherfish, AllFish mf) {
		this.g = g;
		this.j = j;
		this.otherfish = otherfish;
		this.mf = mf;
		imgi1 = new ImageIcon(this.getClass().getResource("����.png"));
		f = new File("F:\\Java\\io\\top.txt");
	}

	// ���Ʋ��ϻ�������ͻ��Լ�������߳�
	public void run() {
		while (true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ����������
			BufferedImage bf = new BufferedImage(j.getWidth(), j.getHeight(),
					BufferedImage.TYPE_3BYTE_BGR);
			// �ӻ�������ȡ����
			Graphics bg = bf.getGraphics();
			// ������
			bg.drawImage(imgi1.getImage(), 0, 0, j.getWidth(), j.getHeight(),
					null);
			// �ڻ������ﻭ�Լ�����
			mf.drawmyfish(bg);
			bg.setFont(new Font("����", 50, 50));
			bg.setColor(Color.black);
			bg.drawString("�÷�:" + score, 50, 50);
			// ����ͣ��ʱ��ͣ�߳�
			if (bo) {
				continue;
			}
			// ������Ե���ʱ��ֹͣ�߳�
			if (n == 1) {
				continue;
			}
			for (int i = 0; i < otherfish.size(); i++) {
				// �ڻ������ﻭ��������
				otherfish.get(i).drawotherfish(bg);
			}
			for (int i = 0; i < otherfish.size(); i++) {
				// �Ƴ��Ѿ��������
				if (otherfish.get(i).getX1() < 0
						|| otherfish.get(i).getX2() > 1400) {
					otherfish.remove(i);
				}
				if (otherfish.get(i).getFish() % 2 == 1) {
					// ������ж�
					if ((mf.getY() + mf.getMyfishsize() >= otherfish.get(i)
							.getPosition() && mf.getY() <= otherfish.get(i)
							.getPosition())
							&& (mf.getX() + mf.getMyfishsize() > otherfish.get(
									i).getX1() && (mf.getX() < otherfish.get(i)
									.getX1()))) {
						// �����Ƿ����е���һ��
						// System.out.println("������");
						if (cl.cillisionfish(otherfish, mf.getMyfishsize(), i) == 1) {
							mf.setMyfishsize(mf.getMyfishsize() + 10);
							score++;
							otherfish.remove(i);
							break;
						}
					}
					// ����Ե��ж�
					if ((mf.getY() <= otherfish.get(i).getPosition()
							+ otherfish.get(i).getfishh() && mf.getY() >= otherfish
							.get(i).getPosition())
							&& (mf.getX() <= otherfish.get(i).getX1()
									+ otherfish.get(i).getfishw() && mf.getX() >= otherfish
									.get(i).getX1())) {
						// �����Ƿ����е���һ��
						// System.out.println("������");
						if (cl.cillisionfish(otherfish, mf.getMyfishsize(), i) == 2) {
							// ֹͣ�̲߳�gameover
							jilu = JOptionPane.showConfirmDialog(null,
									"������Ҫ�����¼��", "����",
									JOptionPane.YES_NO_OPTION);
							n = 1;
							if (jilu == 0) {
								name=JOptionPane.showInputDialog(null,"������������֣�\n","�������",JOptionPane.PLAIN_MESSAGE);
								if(i<2){
								i++;
								}
								try {
									fileOutput(f);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							bg.setFont(new Font("����", 250, 250));
							bg.setColor(new Color(255, 215, 0));
							bg.drawString("GAME  OVER", 50, 400);
						}
					}
				}
				if (otherfish.get(i).getFish() % 2 == 0) {
					// ������ж�
					if ((mf.getY() + mf.getMyfishsize() >= otherfish.get(i)
							.getPosition() && mf.getY() <= otherfish.get(i)
							.getPosition())
							&& (mf.getX() + mf.getMyfishsize() > otherfish.get(
									i).getX2() && (mf.getX() < otherfish.get(i)
									.getX2()))) {
						// �����Ƿ����е���һ��
						// System.out.println("������");
						if (cl.cillisionfish(otherfish, mf.getMyfishsize(), i) == 1) {
							mf.setMyfishsize(mf.getMyfishsize() + 10);
							score++;
							otherfish.remove(i);
							break;
						}
					}
					// ����Ե��ж�
					if ((mf.getY() <= otherfish.get(i).getPosition()
							+ otherfish.get(i).getfishh() && mf.getY() >= otherfish
							.get(i).getPosition())
							&& (mf.getX() <= otherfish.get(i).getX2()
									+ otherfish.get(i).getfishw() && mf.getX() >= otherfish
									.get(i).getX2())) {
						if (cl.cillisionfish(otherfish, mf.getMyfishsize(), i) == 2) {
							// ֹͣ�̲߳�gameover
							jilu = JOptionPane.showConfirmDialog(null,
									"������Ҫ�����¼��", "����",
									JOptionPane.YES_NO_OPTION);
							n = 1;
							if (jilu == 0) {
								name=JOptionPane.showInputDialog(null,"������������֣�\n","�������",JOptionPane.PLAIN_MESSAGE); 
								if(i<2){
									i++;
									}
									try {
										fileOutput(f);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}								
							}
							bg.setFont(new Font("����", 250, 250));
							bg.setColor(new Color(255, 215, 0));
							bg.drawString("GAME  OVER", 50, 400);
						}
					}
				}
			}
			// �ѻ���ͼƬ���������
			g.drawImage(bf, 0, 0, null);
		}
	}

	//���а�Ľ���
	public void phb(String name,int score){
		javax.swing.JFrame jf = new javax.swing.JFrame();
		jf.setSize(400, 800);
		jf.setTitle("���а�");
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(2);
		FlowLayout fl = new FlowLayout();
		jf.setLayout(fl);
		Dimension di=new Dimension(300,200);
//		if(score>score1&&score1>score2){
//			javax.swing.JLabel jlb1=new javax.swing.JLabel(name+":   "+score);
//			jlb1.setPreferredSize(di);
//			jf.add(jlb1);
//			javax.swing.JLabel jlb2=new javax.swing.JLabel(name1+":   "+score1);
//			jlb2.setPreferredSize(di);
//			jf.add(jlb2);
//			javax.swing.JLabel jlb3=new javax.swing.JLabel(name2+":   "+score2);
//			jlb3.setPreferredSize(di);
//			jf.add(jlb3);
//		}
//		if(score1>score&&score>score2){
//			javax.swing.JLabel jlb2=new javax.swing.JLabel(name1+":   "+score1);
//			jlb2.setPreferredSize(di);
//			jf.add(jlb2);
//			javax.swing.JLabel jlb1=new javax.swing.JLabel(name+":   "+score);
//			jlb1.setPreferredSize(di);
//			jf.add(jlb1);
//			javax.swing.JLabel jlb3=new javax.swing.JLabel(name2+":   "+score2);
//			jlb3.setPreferredSize(di);
//			jf.add(jlb3);
//		}
//		if(score2>score&&score>score1){
//			javax.swing.JLabel jlb3=new javax.swing.JLabel(name2+":   "+score2);
//			jlb3.setPreferredSize(di);
//			jf.add(jlb3);
//			javax.swing.JLabel jlb1=new javax.swing.JLabel(name+":   "+score);
//			jlb1.setPreferredSize(di);
//			jf.add(jlb1);	
//			javax.swing.JLabel jlb2=new javax.swing.JLabel(name1+":   "+score1);
//			jlb2.setPreferredSize(di);
//			jf.add(jlb2);
//		}
//		if(score>score1&&score2>score1&&score>score2){
//			javax.swing.JLabel jlb1=new javax.swing.JLabel(name+":   "+score);
//			jlb1.setPreferredSize(di);
//			jf.add(jlb1);
//			javax.swing.JLabel jlb3=new javax.swing.JLabel(name2+":   "+score2);
//			jlb3.setPreferredSize(di);
//			jf.add(jlb3);
//			javax.swing.JLabel jlb2=new javax.swing.JLabel(name1+":   "+score1);
//			jlb2.setPreferredSize(di);
//			jf.add(jlb2);
//		}
//		if(score1>score&&score2>score&&score1>score2){
//			javax.swing.JLabel jlb2=new javax.swing.JLabel(name1+":   "+score1);
//			jlb2.setPreferredSize(di);
//			jf.add(jlb2);
//			javax.swing.JLabel jlb1=new javax.swing.JLabel(name+":   "+score);
//			jlb1.setPreferredSize(di);
//			jf.add(jlb1);
//			javax.swing.JLabel jlb3=new javax.swing.JLabel(name2+":   "+score2);
//			jlb3.setPreferredSize(di);
//			jf.add(jlb3);
//		}
//		if(score2>score&&score1>score&&score2>score1){
//			javax.swing.JLabel jlb3=new javax.swing.JLabel(name2+":   "+score2);
//			jlb3.setPreferredSize(di);
//			jf.add(jlb3);
//			javax.swing.JLabel jlb2=new javax.swing.JLabel(name1+":   "+score1);
//			jlb2.setPreferredSize(di);
//			jf.add(jlb2);
//			javax.swing.JLabel jlb1=new javax.swing.JLabel(name+":   "+score);
//			jlb1.setPreferredSize(di);
//			jf.add(jlb1);	
//		}
		javax.swing.JLabel jlb1=new javax.swing.JLabel(name+":   "+score);
		jlb1.setPreferredSize(di);
		jf.add(jlb1);	
		jf.setVisible(true);
	}
	// io���������
	public void fileOutput(File file) throws IOException{
//		FileOutputStream fos=new FileOutputStream(file,true);
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream dos=new DataOutputStream(fos);
		int length=name.length();
		dos.writeByte(length);
		for(int i=0;i<length;i++){
		    dos.writeChar(name.charAt(i));
		}
		dos.writeInt(score);
	    fos.flush();
	    fos.close();
	}

	// io����������
	public void fileInput(File file) throws IOException{
		FileInputStream fis=new FileInputStream(file);
		DataInputStream dis=new DataInputStream(fis);
			int length=dis.readByte();
			StringBuffer strB=new StringBuffer();
			for(int i=0;i<length;i++){
				strB.append(dis.readChar());
	        }
			String name=new String(strB);
			int score=dis.readInt();
			phb(name,score);
			fis.close();
//			int length1=dis.readByte();
//			StringBuffer strB1=new StringBuffer();
//			for(int i=0;i<length1;i++){
//				strB1.append(dis.readChar());
//	        }
//			String name1=new String(strB);
//			int score1=dis.readInt();
//			
//			int length2=dis.readByte();
//			StringBuffer strB2=new StringBuffer();
//			for(int i=0;i<length2;i++){
//				strB2.append(dis.readChar());
//	        }
//			String name2=new String(strB);
//			int score2=dis.readInt();
//			phb(name,score,name1,score1,name2,score2);
//			fis.close();
		
			
			
//		byte[] Allstring = new byte[fis.available()];
//		fis.read(Allstring);
//		String Data = new String(Allstring);
//		
//		String[] IndexString = Data.split("#");
//		for (int i = 0; i < IndexString.length; i+=2) {
//			DataMap.put(IndexString[i], Integer.parseInt(IndexString[i+1]));
//		}
//		
//		Set s = DataMap.entrySet();
//		
//        Iterator ite = 	s.iterator();
//        while(ite.hasNext()){
//        	System.out.println(ite.next());
//        }
		
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void setBo(boolean bo) {
		this.bo = bo;
	}
}