package Baekjoon.basic;

import java.io.IOException;
import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:5598] 카이사르 암호 - ★★★ </h1>
 * <b>* 문제 </b> 
 *  - 가이우스 율리우스 카이사르(Gaius Julius Caesar)는 고대 로마 군인이자 정치가였다. 
 *  - 카이사르는 비밀스럽게 편지를 쓸 때, 'A'를 'D로', 'B'를 'E'로, 'C'를 'F'로... 이런 식으로 알파벳 문자를 3개씩 건너뛰어 적었다고 한다.
 *  * 카이사르 변환전/후 문자
 *   변환전    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
 *   변환후    D E F G H I J K L M N O P Q R S T U V W X Y Z A B C
 *  - 26개의 대문자 알파벳으로 이루어진 단어를 카이사르 암호 형식으로 3문자를 옮겨 겹치지 않게 나열하여 얻은 카이사르 단어가 있다. 
 *  - 이 카이사르 단어를 원래 단어로 돌려놓는 프로그램을 작성하시오. 
 *  <b>=> 입력받은 카이사르 단어를 원래 단어로 고친 걸 출력하시면 된다.</b>
 *  * 예시) 
 *    단어 'JOI'를 카이사르 단어 형식으로 변환한다면 'MRL'
 *    얻은 카이사르 단어 'FURDWLD'를 원래 단어로 고치면 'CROATIA'가 된다.
 * </pre>
 */
public class Baekjoon5598 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
		int size = str.length();
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = str.charAt(i); 
			
			if(arr[i]-3 < 'A') {
				System.out.print((char)(arr[i]+23));
			} else {
				System.out.print((char)(arr[i]-3));
			}
		}
	}
	
}
