package Baekjoon.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:2444] 별찍기-7</h1>
 * <b>* 문제 </b> 
 *  - 최종 응용 문제 
 * </pre>
 */
public class Baekjoon2444 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for (int i=1; i<=2*n-1; i++) {
			
			if(i <= n) { // 1 ~ n 행까지
				for(int j=1; j<=n-i; j++) {// n-1열까지는 빈칸 찍기
					System.out.print(" ");
				}
				for(int k=1; k<=2*i-1; k++) {
					System.out.print("*");
				}
			} else { // n+1 행부터 역순 
				for(int j=1; j<=i-n; j++) {
					System.out.print(" ");
				}
				for(int k=1; k<=(2*n-i)*2-1; k++) {
					System.out.print("*");
				}
			}
			
			System.out.println();
			
		}
	}
	
}
