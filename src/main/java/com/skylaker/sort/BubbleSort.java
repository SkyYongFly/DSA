package com.skylaker.sort;

/**
 * 冒泡排序
 * @author zhuyong
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] a = {99, 80, 36, 21, 15, 8, 1, 89, 109, 23, 17, 2, 23};
//		sort1(a);
		sort2(a);
		print(a);
	}
	
	/**
	 * 冒泡排序算法1：直接有多少元素冒泡几次
	 * @param a
	 */
	public static void sort1(int[] a) {
		if(null == a || a.length < 1) {
			return;
		}
		
		// i 表示第几次（i + 1）冒泡（有多少个元素就冒泡几次）
		for(int i = 0; i < a.length; i++) {
			// j 表示需要几次（j + 1）比较，第 i 次 冒泡 ，则还剩余 length - i 个元素，则两两比较次数为 length - i -1 次
			for(int j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 冒泡排序算法2：记录是否发生交换，没交换直接结束
	 * @param a
	 */
	public static void sort2(int[] a) {
		if(null == a || a.length < 1) {
			return;
		}
		
		// i 表示第几次（i + 1）冒泡（有多少个元素就冒泡几次）
		for(int i = 0; i < a.length; i++) {
			//记录是否发生数据交换
			boolean swap = false;
			// j 表示需要几次（j + 1）比较，第 i 次 冒泡 ，则还剩余 length - i 个元素，则两两比较次数为 length - i -1 次
			for(int j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					// 设置发生了数据交换
					swap = true;
				}
			}
			
			if(!swap) {
				// 没有数据交换说明有序直接退出
				break;
			}
		}
	}
	
	public static void print(int[] a) {
		if(null == a || a.length < 1) {
			System.out.println("数组无内容！");
			return;
		}
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
