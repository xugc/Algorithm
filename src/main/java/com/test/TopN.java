/**
 * @Title: TopN.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-3-8 下午5:00:42
 * @version V1.0
 */
package com.test;

/**
 * @ClassName: TopN
 * @Description: TODO
 * @author 徐故成
 * @date 2016-3-8 下午5:00:42
 * 
 */
public class TopN {

	private int top;
	private int[] data;

	public TopN(int top, int[] data) {
		this.top = top;
		this.data = data;
	}

	public int[] sort() {
		int[] sortDatas = new int[10];
		if(data.length<10)
			return data;
		else{
			for(int i=0;i<10;i++){
				sortDatas[i]=data[i];
			}
			for(int i=10;i<data.length;i++){
				for(int j=0;j<10;j++){
				}
			}
		}
		return sortDatas;
	}

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
