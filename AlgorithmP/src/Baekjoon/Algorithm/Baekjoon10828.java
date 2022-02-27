package Baekjoon.Algorithm;

import java.util.Scanner;

/** 
 * <pre>
 * <h1>[백준:10828] 스택 </h1>
 * <b>* 문제</b> 
 *  - 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오. 
 *  - 명령은 총 다섯 가지이다. 
 *   1) push X : 정수 X를 스택에 넣는 연산이다. 
 *   2) pop    : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우 -1을 출력한다.
 *   3) size   : 스택에 들어있는 정수의 개수를 출력한다. 
 *   4) empty  : 스택에 비어있으면 1, 아니면 0을 출력한다. 
 *   5) top    : 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없을 경우에는 -1을 출력한다.  
 * <b>* 입출력</b>
 *  ▶ 입력
 *   - 첫째 줄에 주어지는 명령의 수 N이 주어진다. 
 *   - 둘째 줄부터 N의 줄에는 명령이 하나씩 주어진다. 
 *  ▶ 출력
 *   - 출력해야 하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다. 
 * </pre>
 */
public class Baekjoon10828 {
	
	public static int[] array; 
	public static int size = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		array = new int[N];
		
		for(int i=0; i<N; i++) {
			String command = in.next();
			if(command.indexOf("push") > -1) {
				push(in.nextInt());
			} else if ("pop".equals(command)) {
				System.out.println(pop());
			} else if ("size".equals(command)) {
				System.out.println(size());
			} else if ("empty".equals(command)) {
				System.out.println(empty());
			} else if ("top".equals(command)) {
				System.out.println(top());
			}
		}
	}
	
	/* --------------------------------------------------------------------- */
	
	public static void push(int X) {
		array[size] = X;
		size++; 
	}
	
	public static int pop() {
		if(size == 0) {
			return -1;
		}
		int element = array[size-1];
		array[size-1] = 0;
		size--;
		return element;
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		return size==0 ? 1 : 0;
	}
	
	public static int top() {
		if(size == 0) {
			return -1;
		}
		return array[size-1];
	}

}
