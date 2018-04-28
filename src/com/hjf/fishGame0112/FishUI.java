package com.hjf.fishGame0112;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class FishUI implements ActionListener, KeyListener {
	private ThreadFish tf;
	Graphics g;
	JPanel j;
	AllFish mf = new AllFish();
	private int mfSpeed = 6;
	List<AllFish> otherfish = new ArrayList<AllFish>();
	boolean bo=false;
	int n=0;
	File f=new File("F:\\Java\\io\\top.txt");

	public FishUI() {
		javax.swing.JFrame jf = new javax.swing.JFrame();
		jf.setSize(1500, 900);
		jf.setTitle("�����С��1.0");
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 200, 5);
		jf.setLayout(fl);
		javax.swing.JButton jbu1 = new javax.swing.JButton("��ʼ��Ϸ");
		Dimension d1 = new Dimension(100, 40);
		jbu1.setPreferredSize(d1);
		jf.add(jbu1);
		javax.swing.JButton jbu2 = new javax.swing.JButton("��ͣ��Ϸ");
		Dimension d2 = new Dimension(100, 40);
		jbu2.setPreferredSize(d2);
		jf.add(jbu2);
		javax.swing.JButton jbu3 = new javax.swing.JButton("���¿�ʼ");
		Dimension d3 = new Dimension(100, 40);
		jbu3.setPreferredSize(d3);
		jf.add(jbu3);
		javax.swing.JButton jbu4 = new javax.swing.JButton("���а�");
		Dimension d4 = new Dimension(100, 40);
		jbu4.setPreferredSize(d4);
		jf.add(jbu4);
		j = new JPanel();
		j.setBackground(new Color(255, 255, 255));
		Dimension d = new Dimension(1500, 800);
		j.setPreferredSize(d);
		jf.add(j);
		jf.setVisible(true);
		g = j.getGraphics();
		jbu1.addActionListener(this);
		jbu2.addActionListener(this);
		jbu3.addActionListener(this);
		jbu4.addActionListener(this);
		j.addKeyListener(this);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ��ȡ����
		j.requestFocus();
	}
	public void keyTyped(KeyEvent e) {
	}

	// ������ͷ�ʱС���ٶȱ��0
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_A:
			mf.setVx(0);
			break;
		case KeyEvent.VK_S:
			mf.setVy(0);
			break;
		case KeyEvent.VK_D:
			mf.setVx(0);
			break;
		case KeyEvent.VK_W:
			mf.setVy(0);
			break;
		}
	}

	// ��갴��ʱС����ƶ�
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// ���԰��������Ƿ���Ч
		// System.out.println("����");
		switch (key) {
		case KeyEvent.VK_A:
			mf.setVx(-mfSpeed);
			mf.setdirect(1);
			break;
		case KeyEvent.VK_S:
			mf.setVy(mfSpeed);
			break;
		case KeyEvent.VK_D:
			mf.setVx(mfSpeed);
			mf.setdirect(2);
			break;
		case KeyEvent.VK_W:
			mf.setVy(-mfSpeed);
			break;
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("��ʼ��Ϸ")) {
			// ����С��
			mf = new AllFish();
			// �����߳�
			if (tf == null) {
				tf = new ThreadFish(g, j, otherfish, mf);
				new Thread(tf).start();
				new Thread(new threadotherfishlist(g, j, otherfish)).start();
			}
		}
		if (e.getActionCommand().equals("��ͣ��Ϸ")) {
			n++;
			if(n%2==1){
				tf.setBo(true);
			}
			if(n%2==0){
				tf.setBo(false);
			}
		}
		if (e.getActionCommand().equals("���¿�ʼ")) {
			tf.setN(0);
			mf.setX(900);
			mf.setY(400);
			mf.setMyfishsize(100);
			tf.setScore(0);
			for(int i=0;i<tf.otherfish.size();i++){
				tf.otherfish.remove(i);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int i=0;i<tf.otherfish.size();i++){
				tf.otherfish.remove(i);
			}
			
		}
		if (e.getActionCommand().equals("���а�")) {
			try {
				tf.fileInput(f);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		j.requestFocus();
	}

	public static void main(String[] args) {
		new FishUI();
	}
}