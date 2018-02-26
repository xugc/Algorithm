/**    
* @Title BaseHeapSorter.java  
* @Package com.test  
* @author 徐故成   
* @date 2018年2月24日 下午6:15:26  
* @version V1.0    
*/
package com.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName BaseHeapSorter
 * @author 徐故成
 * @date 2018年2月24日 下午6:15:26
 * 
 */
public class BaseHeapSorter {

	protected int[] data;
	protected int len;

	public BaseHeapSorter(int[] d) {
		this.data = d;
		this.len = d.length;
	}

	public BaseHeapSorter(int[] d, int len) {
		this.data = d;
		this.len = len;
	}

	protected void buildMaxHeap(int heapSize, int index) {
		int left = 2 * index + 1;
		int right = 2 * (index + 1);
		int largestIndex = index;
		if (left < heapSize && data[left] > data[largestIndex]) {
			largestIndex = left;
		}
		if (right < heapSize && data[right] > data[largestIndex]) {
			largestIndex = right;
		}
		if (largestIndex != index) {
			int tmp = data[index];
			data[index] = data[largestIndex];
			data[largestIndex] = tmp;
			buildMaxHeap(heapSize, largestIndex);
		}
	}

	private void buildHeap(int heapSize) {
		int index = len / 2 - 1;
		for (int k = index; k >= 0; k--) {// 建堆
			buildMaxHeap(heapSize, k);
		}
	}

	private int rebuildHeap(int heapSize, int maxData) {
		int tmp = heapSize;
		data[0] = data[heapSize - 1];
		data[heapSize - 1] = maxData;
		buildMaxHeap(--tmp, 0);
		return tmp;
	}

	public int[] sort() throws Exception {
		if (data == null || data.length <= 0)
			throw new Exception("data is empty.");
		int heapSize = len;
		buildHeap(heapSize);
		/** 排序 **/
		while (heapSize > 0) {
			int maxData = data[0];
			heapSize = rebuildHeap(heapSize, maxData);
		}
		return data;
	}

	public int[] topN(int k) throws Exception {
		if (data == null || data.length <= 0)
			throw new Exception("data is empty.");
		if (k < 0)
			throw new Exception("n cannot less than 0.");
		if (k > len)
			return data;
		int heapSize = len;
		int[] topn = new int[k];
		buildHeap(len);
		int tmp = k;
		int i = 0;
		while (tmp > 0) {
			int maxData = data[0];
			topn[i++] = maxData;
			heapSize = rebuildHeap(heapSize, maxData);
			tmp--;
		}
		return topn;
	}

	/**
	 * @Title main
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// int[] data = { 8, 1, 9, 3, 6, 0, 3, 4, 6 };
		int[] data = new int[100000000];
		for (int i = 0; i < 100000000; i++) {
			data[i] = new Random().nextInt(100000000);
		}
		BaseHeapSorter sorter = new BaseHeapSorter(data);
		// System.out.println(Arrays.toString(sorter.sort()));
		System.out.println(System.currentTimeMillis());
		System.out.println(Arrays.toString(sorter.topN(100)));
		System.out.println(System.currentTimeMillis());
	}
}