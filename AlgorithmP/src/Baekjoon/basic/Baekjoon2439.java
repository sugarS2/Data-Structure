package Baekjoon.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:2439] 별찍기-2</h1>
 * <b>* 문제 </b> 
 *  - 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제 
 *  - 단, 오른쪽 정렬을 기준으로 출력 
 * </pre>
 */
public class Baekjoon2439 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for(int i=1; i<=n; i++) { // 행
			for(int j=n; j>=1; j--) { // 열
				if (j<=i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
