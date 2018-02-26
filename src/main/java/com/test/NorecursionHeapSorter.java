/**    
* @Title NorecursionHeapSorter.java  
* @Package com.test  
* @author 徐故成   
* @date 2018年2月24日 下午6:00:09  
* @version V1.0    
*/
package com.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName NorecursionHeapSorter
 * @author 徐故成
 * @date 2018年2月24日 下午6:00:09
 * 
 */
public class NorecursionHeapSorter extends BaseHeapSorter {
	private int nextIndex = -1;

	public NorecursionHeapSorter(int[] d) {
		super(d);
	}

	public NorecursionHeapSorter(int[] d, int len) {
		super(d, len);
	}

	@Override
	protected void nodeSwap(int heapSize, int index) {
		nextIndex = index;
		while (nextIndex >= 0) {
			int tmpIndex = nextIndex;
			nextIndex = -1;
			int left = 2 * tmpIndex + 1;
			int right = 2 * (tmpIndex + 1);
			int largestIndex = tmpIndex;
			if (left < heapSize && data[left] > data[largestIndex]) {
				largestIndex = left;
			}
			if (right < heapSize && data[right] > data[largestIndex]) {
				largestIndex = right;
			}
			if (largestIndex != tmpIndex) {
				int tmp = data[tmpIndex];
				data[tmpIndex] = data[largestIndex];
				data[largestIndex] = tmp;
				nextIndex = largestIndex;
			}
		}
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
		BaseHeapSorter sorter = new NorecursionHeapSorter(data);
		System.out.println(System.currentTimeMillis());
		// System.out.println(Arrays.toString(sorter.sort()));
		System.out.println(Arrays.toString(sorter.topN(4)));
		System.out.println(System.currentTimeMillis());
	}

}
