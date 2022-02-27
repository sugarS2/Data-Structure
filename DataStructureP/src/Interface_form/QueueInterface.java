package Interface_form;

/**
 * 자바 Queue Interface 입니다. <br>
 * Queue는 ArrayQueue, LinkedQueue, Deque, PriorityQueue애 의해 구현됩니다. <br>
 * <br>
 * 선입선출 FIFO (= First In First Out) <br> 
 * 큐(Queue)란? 대기열로, 알고리즘에서는 BFS(너비 우선 탐색)에 사용된다. <br>
 * <br>
 * -----------------------------------  <br>
 * front ◀| 1 | 2 | 3 | 4 | 5 |◀ rear  <br>
 * -----------------------------------  <br>
 * 
 * @param <E>
 */
public interface QueueInterface<E> {
	
	/**
	 * 큐의 가장 마지막에 요소를 추가합니다. 
	 * 
	 * @param e 큐에 추가할 요소
	 * @return  큐에 요소가 정상적으로 추가되었을 때 true를 반환 
	 */
	boolean offer(E e); 
	
	/**
	 * 큐의 첫 번째 요소를 제거하고 제거된 요소를 반환합니다. 
	 * 
	 * @return 큐의 제거된 요소 반환 
	 */
	E poll();
	
	/**
	 * 큐의 첫 번째 요소를 제거하지 않고 반환합니다. 
	 * 
	 * @return 큐의 첫 번째 요소 반환 
	 */
	E peek();
}
