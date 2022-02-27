package Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/** 
 * <pre>
 * <h1>[백준:1037] 약수 </h1>
 * <b>* 문제</b> 
 *  - 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 
 *  - 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
 * <b>* 풀이방법 </b>
 *  - 입력 값에서 1과 자기자신 N은 입력받지 않기 때문에, 약수에서 최소값*최대값을 곱하면 된다.
 *  -> N의 약수 중, 최솟값, 최댓값을 곱하면 N이다. 
 * </pre>
 */
public class Baekjoon1037 {
	
	public static void main(String[] args) throws IOException {
		
		//Solution1();
		Solution2();
		
	}
	
	/** 
	 * 방법 1 - Scanner+Array 이용 
	 */
	public static void Solution1 () {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		
		Arrays.sort(arr); // 오름차순으로 정렬
		int min = arr[0]; // 최솟값
		int max = arr[n-1]; // 최댓값
		
		System.out.println(min*max);
	}
	
	/** 
	 * 방법 2 - BufferedReader + StringTokenizer 이용
	 */
	public static void Solution2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = num>max ? num : max;
			min = num<min ? num : min;
		}
		
		System.out.println(min*max);
	}
	
}