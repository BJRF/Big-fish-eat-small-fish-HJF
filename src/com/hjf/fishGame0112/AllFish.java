package com.hjf.fishGame0112;

import java.awt.Graphics;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class AllFish {
	private int x = 900, y = 400, vx, vy, w = 100, h = 80, direct = 0, fish,
			position, fishw, fishh, myfishsize = 100;
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int x1 = 1500, x2 = 0;
	private ImageIcon imgl, imgr, img1l, img1r, img2l, img2r, img3r, img3l;
	Random ra = new Random();
	private int sp=ra.nextInt(10)+3;

	public AllFish() {
		fish = ra.nextInt(11)+1;
		position = ra.nextInt(700) + 30;
		imgl = new ImageIcon(this.getClass().getResource("Myfish.png"));
		imgr = new ImageIcon(this.getClass().getResource("Myfish2.png"));
		// 导入其他鱼的图片
		img1r = new ImageIcon(this.getClass().getResource("otherfishi1.png"));
		img1l = new ImageIcon(this.getClass().getResource("otherfishi1_副本.png"));
		img2r = new ImageIcon(this.getClass().getResource("otherfish2.png"));
		img2l = new ImageIcon(this.getClass().getResource("otherfish2_副本.png"));
		img3r = new ImageIcon(this.getClass().getResource("otherfish3.png"));
		img3l = new ImageIcon(this.getClass().getResource("otherfish3_副本.png"));
	}

	// 画我的鱼的方法
	public void drawmyfish(Graphics g) {
		// 测试x坐标的值是否变动
		// System.out.println(x);
		// 测试vx的值是否成功传入
		// System.out.println("direct="+direct);

		if (direct == 0) {
			g.drawImage(imgl.getImage(), x, y, myfishsize, myfishsize, null);
		}
		if (direct == 1) {
			g.drawImage(imgl.getImage(), x, y, myfishsize, myfishsize, null);
			x += vx;
			y += vy;
		}
		if (direct == 2) {
			g.drawImage(imgr.getImage(), x, y, myfishsize, myfishsize, null);
			x += vx;
			y += vy;
		}
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	// 画其他鱼的方法
	public void drawotherfish(Graphics g) {
		if (fish == 1) {
			fishw = 3 * w;
			fishh = 2 * h;
			g.drawImage(img1l.getImage(), x1, position, fishw, fishh, null);
			x1 -= sp;
		}
		if (fish == 2) {
			fishw = 3 * w;
			fishh = 2 * h;
			g.drawImage(img1r.getImage(), x2, position, fishw, fishh, null);
			x2 += sp;
		}
		if (fish == 3) {
			fishw = w / 2;
			fishh = h / 2;
			g.drawImage(img2l.getImage(), x1, position, fishw, fishh, null);
			x1 -= sp;
		}
		if (fish == 4) {
			fishw = w / 2;
			fishh = h / 2;
			g.drawImage(img2r.getImage(), x2, position, fishw, fishh, null);
			x2 += sp;
		}
		if (fish == 5) {
			fishw = w + 50;
			fishh = h + 40;
			g.drawImage(img3l.getImage(), x1, position, fishw, fishh, null);
			x1 -= sp;
		}
		if (fish == 6) {
			fishw = w + 50;
			fishh = h + 40;
			g.drawImage(img3r.getImage(), x2, position, fishw, fishh, null);
			x2 += sp;
		}
		if (fish == 7) {
			fishw = w / 2;
			fishh = h / 2;
			g.drawImage(imgl.getImage(), x1, position, fishw, fishh, null);
			x1 -= sp;
		}
		if (fish == 8) {
			fishw = w / 2;
			fishh = h / 2;
			g.drawImage(imgr.getImage(), x2, position, fishw, fishh, null);
			x2 += sp;
		}
		if (fish == 9) {
			fishw = w * 2;
			fishh = h * 2;
			g.drawImage(img3l.getImage(), x1, position, fishw, fishh, null);
			x1 -= sp;
		}
		if (fish == 10) {
			fishw = w * 2;
			fishh = h * 2;
			g.drawImage(img3r.getImage(), x2, position, fishw, fishh, null);
			x2 += sp;
		}
	}

	public int getPosition() {
		return position;
	}

	public int getMyfishsize() {
		return myfishsize;
	}

	public void setMyfishsize(int myfishsize) {
		this.myfishsize = myfishsize;
	}

	public int getFish() {
		return fish;
	}

	public int getfishw() {
		return fishw;
	}

	public int getfishh() {
		return fishh;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public void setdirect(int direct) {
		this.direct = direct;
	}
}
