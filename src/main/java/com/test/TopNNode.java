/**
 * @Title TopNNode.java
 * @Package com.test
 * @Description TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-12-7 下午3:13:36
 * @version V1.0
 */
package com.test;

import java.util.Arrays;

/**
 * @ClassName TopNNode
 * @Description TODO
 * 
 */
public class TopNNode {
	private int[] datas;
	private int top;
	private int index;

	public TopNNode(int index, int[] odatas) {
		this.top = 10;
		datas = new int[10];
		this.index = index;
		int realIndex = index * 10;
		for (int i = 0; i < 10; i++) {
			if (realIndex + i < odatas.length)
				datas[i] = odatas[realIndex + i];
		}
	}

	public TopNNode(int top, int index, int[] odatas) {
		this.top = top;
		datas = new int[top];
		this.index = index;
		int realIndex = index * top;
		for (int i = 0; i < top; i++) {
			if (realIndex + i < odatas.length)
				datas[i] = odatas[realIndex + i];
		}
		Arrays.sort(datas);
	}

	public int[] getDatas() {
		return datas;
	}

	public void setDatas(int[] datas) {
		this.datas = datas;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
