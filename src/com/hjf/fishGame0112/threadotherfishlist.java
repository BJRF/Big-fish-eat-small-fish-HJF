package com.hjf.fishGame0112;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class threadotherfishlist implements Runnable {
	// ����
	List<AllFish> otherfish;
	Graphics g;
	AllFish mf;
	JPanel j;

	public threadotherfishlist(Graphics g, JPanel j, List<AllFish> otherfish) {
		this.g = g;
		this.j = j;
		this.otherfish = otherfish;
	}

	// ���������������MyFish�Ķ����Բ��ϵĻ�������С��
	public void run() {
		while (true) {
			try {
				Thread.sleep(666);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			AllFish mf = new AllFish();
			otherfish.add(mf);
		}
	}
}
