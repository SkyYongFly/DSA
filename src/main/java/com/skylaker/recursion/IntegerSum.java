package com.skylaker.recursion;

/*
 * 递归计算：1到100的之间的整数和
 */
public class IntegerSum {

	public static void main(String[] args) {
		System.out.println(sum2(100));
	}
	
	/*
	 *  计算1到n之间的整数和（递归方式）
	 */
	private static int sum(int n) {
		if(1 == n) {
			return 1;
		}
		return sum(n-1) + n;
	}
	
	/*
	 *  计算1到n之间的整数和（迭代循环方式）
	 */
	private static int sum2(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		return sum;
	}
}
