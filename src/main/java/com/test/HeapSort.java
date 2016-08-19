/**
 * @Title: HeapSort.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-2-25 上午10:49:26
 * @version V1.0
 */
package com.test;

/**
 * @ClassName: HeapSort
 * @Description: TODO
 * @author 徐故成
 * @date 2016-2-25 上午10:49:26
 * 
 */
public class HeapSort {
	public static void buildMaxHeap(int[] data, int len) {
		if (data == null || len < 1)
			return;
		int center = (len - 1) / 2;
		for (int i = center; i >= 0; i--) {
			maxHeap(data, len, i);
		}
	}

	public static void maxHeap(int[] data, int heapSize, int index) {
		int left = 2 * index + 1;
		int right = (index + 1) * 2;
		int largest = index;
		if (left < heapSize && data[left] > data[largest])
			largest = left;
		if (right < heapSize && data[right] > data[largest])
			largest = right;
		if (largest != index) {
			int tmp = data[index];
			data[index] = data[largest];
			data[largest] = tmp;
			maxHeap(data, heapSize, largest);
		}
	}

	public static void main(String[] args) {
		int[] data = new int[] { 3, 1, 5, 9, 10, 4, 5, 2 };
		int len = data.length;
		while (len > 0) {
			buildMaxHeap(data, len);
			int tmp = data[0];
			data[0] = data[len-1];
			data[len-1] = tmp;
			len--;
		}
		System.out.println(data);
	}
}
