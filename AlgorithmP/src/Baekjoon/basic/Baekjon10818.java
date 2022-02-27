package Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/** 
 * <pre>
 * <h1>[백준:10818] 평균 </h1>
 * <b>* 문제</b> 
 *  - N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 * <b>* 입출력</b>
 *  ▶ 입력
 *   - 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
 *   - 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
 *  ▶ 출력
 *   - 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 * </pre>
 */
public class Baekjon10818 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			min = num < min ? num : min;
			max = num > max ? num : max;
		}
		
		System.out.println(min + " " + max);
	}

}
