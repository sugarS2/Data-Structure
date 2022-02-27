package Baekjoon.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:3460] 이진수 - ★★★</h1>
 * <b>* 문제</b>
 *  - 양의 정수 n이 주어졌을 때, 이를 이진수로 나타냈을 떄, 1의 위치를 모두 찾는 프로그램을 작성하시오. 
 *  - 최하위 비트의 위치는 0이다. 
 * <b>* 입출력</b>
 *  ▶ 입력 : 첫째 줄에 테스트케이스의 개수 T 가 주어진다. 각 테스트케이스는 한 줄로 이루어져있고, n이 주어진다. (1 ≤ T ≤ 10, 1 ≤ n ≤ 10^6)
 *  ▶ 출력 : 각 테스트케이스에 대해서, 1의 위치를 공백으로 구분해서 하나에 출력한다. 위치가 낮은 것 부터 출력한다. 
 * <b>* 예시 ( '/' 은 ENTER 와 같음) </b>
 *  예1) 
 *   입력 : 1 / 13
 *   출력 : 0 2 3   
 *   풀이 :
 *    - 정수 13을 이진수로 표현하면 '1101'
 *    - 1의 위치 출력 (낮은 것 부터) : 0 2 3
 * <b style="color:blue;">* 풀이방법</b>
 *  java.lang 패키지에 있는 Integer클래스는 10진수 ↔ 2진수로 바꿔주는 함수를 지원한다. 
 *  10진수 → 2진수 String : Integer.toBinaryString(int 13); // 1101
 *  2진수 → 10진수 int    : Integer.parseInt("1101", 2);    // 13
 * </pre>
 */
public class Baekjoon3460 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(); // 테스트케이스 개수 T
		for (int i=0; i<T; i++) { 
			int num = in.nextInt(); // 양의 정수 (10진수)
			String binary = Integer.toBinaryString(num); // 10진수 → 2진수 
			String binArr[] = binary.split("");
			
			//System.out.println("## num : " + num + " / binary : " + binary);
			for(int j=binArr.length-1; j>=0; j--) {
				//System.out.print(binArr[j]); // 역순으로 변경 
				
				if("1".equals(binArr[j])) {
					System.out.print(binArr.length-1-j + " ");
				}
				
			}
		}
	}
}
