package Baekjoon.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:2562] 최댓값 </h1>
 * <b>* 문제</b> 
 *  - 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
 *  - 예) 3, 29, 38, 12, 57, 74, 40, 85, 61 ->  이들 중 최댓값은 85이고, 이 값은 8번째 수
 * <b>* 입출력</b>
 *  - 입력 : 첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.
 *  - 출력 : 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
 * </pre>
 */
public class Baekjoon2562 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arr[] = new int[9];
		for (int i=0; i<arr.length; i++) {
			arr[i] = in.nextInt(); // 1~9번째 줄까지 자연수 입력 
		}
		
		int max = 0;
		int index = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i]; 
				index = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(index);
		
	}
	
}
