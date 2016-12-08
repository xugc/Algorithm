/**
 * @Title TopNInsertSort.java
 * @Package com.test
 * @Description TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-12-9 下午2:22:23
 * @version V1.0
 */
package com.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName TopNInsertSort
 * @Description TODO
 * 
 */
public class TopNInsertSort {
	public static int[] topNSort(int[] datas, int top) {
		if (datas.length <= top)
			return datas;
		int[] topNArr = new int[top];
		for (int i = 0; i < top; i++) {
			topNArr[i] = datas[i];
		}
		Arrays.sort(topNArr);
		for (int i = top; i < datas.length; i++) {
			int k = 0;
			while (k < top && topNArr[k] < datas[i]) {
				if (k > 0) {
					topNArr[k - 1] = topNArr[k];
				}
				k++;
			}
			if (k > 0)
				topNArr[k - 1] = datas[i];
		}
		return topNArr;
	}

	public static void main(String[] args) {
		// int[] data = new int[] { 3, 1, 5, 9, 10, 4, 5, 2 };
		int[] data = new int[100000000];
		for (int i = 0; i < 100000000; i++) {
			data[i] = new Random().nextInt(100000000);
		}
		int t = 10000;
		System.out.println(System.currentTimeMillis());
		int[] tn = topNSort(data, t);
		// Arrays.sort(data);
		System.out.println(System.currentTimeMillis());
//		for (int i = 0; i < tn.length; i++) {
//			System.out.println(tn[i]);
//		}
	}
}
