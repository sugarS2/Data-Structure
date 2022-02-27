package Baekjoon;

import java.util.Scanner;

/**
 * <pre>
 * <b>팩토리얼</b>
 * 문제 : 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 * 예시 : 10입력 → 3628800출력 / 0입력 → 1출력
 * </pre>
 */
public class Baekjoon10872 {
	
	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n*factorial(n-1);
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(factorial(n));
	}
	
}
