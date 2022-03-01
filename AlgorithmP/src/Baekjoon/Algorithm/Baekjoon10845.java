package Baekjoon.Algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 
 * <pre>
 * <h1>[백준:10845] 큐 </h1>
 * <b>* 문제</b> 
 *  - 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오. 
 *  - 명령은 총 여섯 가지이다. 
 *   1) push X : 정수 X를 큐에 넣는 연산이다. 
 *   2) pop    : 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우 -1을 출력한다.
 *   3) size   : 큐에 들어있는 정수의 개수를 출력한다. 
 *   4) empty  : 큐에 비어있으면 1, 아니면 0을 출력한다. 
 *   5) front  : 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다. 
 *   6) back   : 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다. 
 * <b>* 입출력</b>
 *  ▶ 입력
 *   - 첫째 줄에 주어지는 명령의 수 N이 주어진다. 
 *   - 둘째 줄부터 N의 줄에는 명령이 하나씩 주어진다. 
 *  ▶ 출력
 *   - 출력해야 하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다. 
 * </pre>
 */
public class Baekjoon10845 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); // 출력용 
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int back = -1;
		
		int N = Integer.parseInt(br.readLine()); 
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
				case "push":
					back = Integer.parseInt(st.nextToken());
					queue.offer(back);
					break;
				case "pop":
					if(queue.isEmpty()) {
						sb.append("-1").append("\n");
						break;
					}
					sb.append(queue.poll()).append("\n");
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					sb.append(queue.isEmpty()?1:0).append("\n");
					break;
				case "front":
					sb.append(queue.isEmpty()? -1: queue.peek()).append("\n");
					break;
				case "back":
					sb.append(queue.isEmpty()? -1: back).append("\n");
					break;
			}
				
		}
		
		System.out.println(sb);
	}
	
}
