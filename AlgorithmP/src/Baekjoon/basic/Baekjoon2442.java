package Baekjoon.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:2442] 별찍기-5 ★★★</h1>
 * <b>* 문제 </b> 
 *  - 첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제
 *  - 별은 가운데를 기준으로 대칭이어야 한다.
 * </pre>
 */
public class Baekjoon2442 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		for(int i=1; i<=n; i++) { 
			// 1. 별이 시작하는 위치는 전체n에서 i번째 줄 위치를 뺀 곳이므로, n-i만큼 빈칸 출력
			for(int j=1; j<=n-i; j++) {
				System.out.print(" ");
			}
			// 2. 그 후, 별(*)을 2*i-1 개 만큼 찍어준다.
			for(int k=1; k<=2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/*// 틀린 답안 (뒤에 빈칸이 들어오면 안됨)
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		// 총 찍혀야 할 별 개수 
		int totalStarCnt = 2*n-1;
		
		for(int i=1; i<=n; i++) { // 행
			// 현재 행에 찍혀야 할 별 개수 
			int curStarCnt = 2*i-1; 
			// 앞 뒤로 빈 칸 개수 
			int blankCnt = (totalStarCnt-curStarCnt)/2;
			
			for(int j=1; j<=totalStarCnt; j++) {
				// 찍혀야 할 구간(빈칸개수+1 ~ 빈칸개수+현재행총찍힐개수)에만 * 출력, 나머지는 빈칸
				if (j >= (blankCnt+1) && j <= (blankCnt+curStarCnt)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	*/
	
}
