package com.hjf.fishGame0112;

import java.util.List;

public class collision {
	//小鱼碰撞的方法
	public int cillisionfish(List<AllFish> a, int myfishsize,int i) {
		int judge = 0;
			if (a.get(i).getfishw() < myfishsize) {
				judge = 1;
			}
			if (a.get(i).getfishw() > myfishsize) {
				judge = 2;
			}
			if (myfishsize == 0) {
				judge = 0;
			}
		return judge;
	}
}
