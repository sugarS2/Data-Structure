package Baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * <b>피보나치 수 5</b>
 * 문제 : n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 * 참고. 피보나치 식 : Fn = Fn-1 + Fn-2 (단, n ≥ 2)
 * </pre>
 */
public class Baekjoon10870 {
	
	public static int fib(int n) {
		if (n<2) {
			return (n==0? 0 : 1);
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(fib(n));
	}
}
