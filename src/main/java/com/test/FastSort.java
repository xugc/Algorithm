/**
 * @Title: FastSort.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-2-25 上午10:18:17
 * @version V1.0
 */
package com.test;

/**
 * @ClassName: FastSort
 * @Description: TODO
 * @author 徐故成
 * @date 2016-2-25 上午10:18:17
 * 
 */
public class FastSort {
	public static int quickSort(int data[], int start, int end) {
		int tmp = data[start];
		int i = start, j = end;
		while (i < j) {
			while (i < j && data[j] > tmp)
				j--;
			if (i < j)
				data[i++] = data[j];
			while (i < j && data[i] < tmp)
				i++;
			if (i < j)
				data[j--] = data[i];
		}
		data[i] = tmp;
		return i;
	}
 
	public static void merge(int data[], int start, int end) {
		if (start < end) {
			int center = quickSort(data, start, end);
			merge(data, start, center - 1);
			merge(data, center + 1, end);
		}
	}

	public static void main(String[] args) {
		int[] data = new int[] { 3, 1, 5, 9, 10, 4, 5, 2 };
		merge(data, 0, data.length-1);
		System.out.println(data);
		System.out.println("12212");
	}
}
