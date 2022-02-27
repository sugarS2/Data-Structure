package Baekjoon.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:2576] 홀수 </h1>
 * <b>* 문제</b> 
 *  - 7개의 자연수가 주어질 때, 이들 중 홀수인 자연수들을 모두 골라 그 합을 구하고, 고른 홀수들 중 최솟값을 찾는 프로그램을 작성하시오.
 *  - 예) 7개의 자연수(12, 77, 38, 41, 53, 92, 85) -> 합 : 256 / 최솟값 : 41
 * <b>* 입출력</b>
 *  - 입력 : 입력의 첫째 줄부터 일곱 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100보다 작다.
 *  - 출력 : 홀수가 존재하지 않는 경우에는 첫째 줄에 -1을 출력한다. 
 *          홀수가 존재하는 경우 첫째 줄에 홀수들의 합을 출력하고, 둘째 줄에 홀수들 중 최솟값을 출력한다.
 * </pre>
 */
public class Baekjon2576 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arr[] = new int[7];
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<7; i++) {
			arr[i] = in.nextInt();
			
			if(arr[i]%2 == 1) {
				sum += arr[i];
				min = arr[i] < min ? arr[i] : min;
			}
		}
		in.close();
		
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
