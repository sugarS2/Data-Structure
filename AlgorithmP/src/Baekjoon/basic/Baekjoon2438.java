package Baekjoon.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:2438] 별찍기-1</h1>
 * <b>문제 :</b> 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제 
 * </pre>
 */
public class Baekjoon2438 {
	
	public static void main(String arg[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for(int i=1; i<=n; i++) { // 행
			for(int j=1; j<=i; j++) { // 열
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
