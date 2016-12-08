/**
 * @Title TopNHeapSort.java
 * @Package com.test
 * @Description TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-12-7 下午3:29:41
 * @version V1.0
 */
package com.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName TopNHeapSort
 * @Description TODO
 * 
 */
public class TopNHeapSort {

	public static void buildMaxHeap(int[] datas, int len, int top) {
		if (len <= top)
			return;
		if (datas == null || len < 1)
			return;
		int topNLen = len % top == 0 ? len / top : len / top + 1;
		int center = topNLen / 2 - 1;
		for (int i = center; i >= 0; i--) {
			maxHeap(datas, topNLen, i, top);
		}
	}

	private static void maxHeap(int[] datas, int heapSize, int index, int top) {
		int left = 2 * index + 1;
		int right = (index + 1) * 2;
		TopNNode parentN = new TopNNode(top, index, datas);
		if (right < heapSize) {
			TopNNode leftN = new TopNNode(top, left, datas);
			TopNNode rightN = new TopNNode(top, right, datas);
			int[] tmp = mergeSort(leftN.getDatas(), rightN.getDatas(), top);
			int[] tmp2 = mergeSort(tmp, parentN.getDatas(), top);
			for (int i = 0; i < top; i++) {
				parentN.getDatas()[i] = tmp2[i];
			}
		} else {
			if (left <= heapSize) {
				TopNNode leftN = new TopNNode(top, left, datas);
				int[] tmp = mergeSort(leftN.getDatas(), parentN.getDatas(), top);
				for (int i = 0; i < top; i++) {
					parentN.getDatas()[i] = tmp[i];
				}
			}
		}
		for (int i = 0; i < top; i++) {
			datas[index * top + i] = parentN.getDatas()[i];
		}
	}

	private static int[] mergeSort(int[] ldata, int[] rdata, int top) {
		int[] mdata = new int[top];
		int i = ldata.length - 1, j = rdata.length - 1, k = top - 1;
		while (k >= 0) {
			if (ldata[i] >= rdata[j]) {
				mdata[k--] = ldata[i];
				i--;
			} else if (ldata[i] < rdata[j]) {
				mdata[k--] = rdata[j];
				j--;
			}
		}
		return mdata;
	}

	public static void main(String[] args) {
		// int[] data = new int[] { 3, 1, 5, 9, 10, 4, 5, 2 };
		int[] data = new int[100000000];
		for (int i = 0; i < 100000000; i++) {
			data[i] = new Random().nextInt(100000000);
		}
		int len = data.length;
		int t = 1000;
		System.out.println(System.currentTimeMillis());
		buildMaxHeap(data, len, t);
//		Arrays.sort(data);
		System.out.println(System.currentTimeMillis());
//		for (int i = 0; i < t; i++) {
//			System.out.println(data[i]);
//		}
	}
}
