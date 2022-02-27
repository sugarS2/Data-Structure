package Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/** 
 * <pre>
 * <h1>[백준:10809] 알파벳찾기 - ★★★ </h1>
 * <b>* 문제</b> 
 *  - 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 *  - 각각의 알파벳에 대해서, 
 *    단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 
 *    포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 * <b>* 입출력</b>
 *  ▶ 입력
 *   - 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
 *  ▶ 출력
 *   - 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
 *   - 만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 
 *   - 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
 * <b>* 예시</b>
 *  ▶ 입력 : baekjoon
 *  ▶ 출력 : 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 *  
 * <b style="color:blue;">* 참고*</b>
 *  - 알파벳 대문자 A ~ Z : (char) 65 ~  90 (26개)
 *  - 알파벳 소문자 a ~ z : (char) 97 ~ 122 (26개)
 * </pre>
 */
public class Baekjon10809 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[26]; // 소문자 갯수 26개 만큼 배열arr 생성
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1; // 배열 초기값 모두 -1 로 설정 
		}
		
		String S = br.readLine(); // 단어 S 입력 (소문자) 
		
		/* 
		 * ch : 추출한 문자 
		 * index : arr[] 배열에 위치할 문자 위치 (예. a는 0, b는 1...)
		 * i : 추출한 문자 위치 (추출한 문자가 몇 번째 위치하는지)
		 */
		for(int i=0; i<S.length(); i++) {
			char ch = S.charAt(i); 
			int index = ch - 'a';
			
			// System.out.println("## 추출한 문자 : " + ch);
			// System.out.println("## 배열에 넣어야 할 index 위치 : " + index);
			// System.out.println("## 단어 S 에서 추출한 문자가 몇 번째 위치하는지 : " + i);
			
			if (arr[index] == -1) { // 단, 처음 등장한 경우에만 ★
				arr[index] = i; // 추출한 문자가 몇 번째 위치하는 지 배열에 저장
			}
		}
		
		/* 출력방법1. 
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		*/
		
		/* 출력방법2. */
		for(int val : arr) {
			System.out.print(val + " ");
		}
		
	}

}
