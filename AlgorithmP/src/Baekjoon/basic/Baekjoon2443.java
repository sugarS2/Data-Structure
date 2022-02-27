package Baekjoon.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:2443] 별찍기-6</h1>
 * <b>* 문제 </b> 
 *  - 첫째 줄에는 별 2×N-1개, 둘째 줄에는 별 2×N-3개, ..., N번째 줄에는 별 1개를 찍는 문제
 *  - 별은 가운데를 기준으로 대칭이어야 한다.
 * </pre>
 */
public class Baekjoon2443 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=1; k<=(2*n-2*i+1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
