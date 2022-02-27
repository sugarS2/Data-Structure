package programmers.basic;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[프로그래머스] 신규 아이디 추천</h1>
 * 
 * <b>* 신규아이디 변경 단계</b>
 *   1단계: new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 *   2단계: new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 *   3단계: new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 *   4단계: new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 *   5단계: new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 *   6단계: new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
           만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 *   7단계: new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 *   
 * <b>* 예시</b>
 * 1) ...!@BaT#*..y.abcdefghijklm
 * </pre>
 */
public class Solution72410 {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		String new_id = in.next();
		*/
		//String new_id = "...!@BaT#*..y.abcdefghijklm"; // 케이스1 : bat.y.abcdefghi
		String new_id = "z-+.^."; // 케이스2 : z--
		//String new_id = "=.="; // 케이스3 : aaa
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
		String answer = "";
		
		System.out.println("## 기존 문자열 : " + new_id);
		
		// 1단계: new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		answer = new_id.toLowerCase();
		System.out.println("## 1단계 결과 : " + answer);
		
		// 2단계: new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		answer = answer.replaceAll("[^a-z0-9-_.]", "");
		System.out.println("## 2단계 결과 : " + answer);
		
		// 3단계: new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		answer = answer.replaceAll("[.]{2,}", ".");
		System.out.println("## 3단계 결과 : " + answer);
		
		// 4단계: new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		answer = answer.replaceAll("^[.]|[.]$", "");
		System.out.println("## 4단계 결과 : " + answer);
		
		// 5단계: new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		answer = answer.equals("") ? "a" : answer;
		System.out.println("## 5단계 결과 : " + answer);
		
		// 6단계: new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		answer = answer.length() >= 16 ? answer.substring(0, 15).replaceAll("[.]$", "") : answer;
		System.out.println("## 6단계 결과 : " + answer);
		
		// 7단계: new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		if(answer.length() <= 2) {
			while(answer.length() != 3) {
				answer += answer.charAt(answer.length()-1);
			}
		}
		System.out.println("## 7단계 결과 : " + answer);
		
		return answer;
	}
	
}
