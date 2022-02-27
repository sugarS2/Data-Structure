package Interface_form;

/**
 * 자바 Stack Interface입니다. <br>
 * StackInterface는 Stack에 의해 구현됩니다. <br><br>
 * 
 * <b>* Stack (스택) ? </b><br>
 *  - 후입선출(LIFO)/선입후출(FILO)의 대표적인 자료구조 <br>
 *  - Vector 클래스를 상속받아 구현된다. 
 * @author 김시욱
 * @param <E>
 */
public interface StackInterface<E> {
	
	/**
	 * 스택의 맨 위에 요소를 추가합니다.
	 * @param item 스택에 추가할 요소
	 * @return 스택에 추가된 요소
	 */
	E push(E item);
	
	/**
	 * 스택의 맨 위에 있는 요소를 제거하고 제거된 요소를 반환합니다.
	 * @return 제거된 요소
	 */
	E pop();
	
	/** 
	 * 스택의 맨 위에 있는 요소를 제거하지 않고 반환합니다.
	 * @return 스택의 맨 위에 있는 요소
	 */
	E peek();
	
	/**
	 * 스택의 상반 부터 특정 요소가 몇 번째 위치에 있는지를 반환합니다.<br>
	 * 중복되는 원소가 있을경우 가장 위에 있는 요소의 위치가 반환됩니다.
	 * <br><br>
	 * 찾으려는 데이터가 상단(Top)으로부터 얼마만큼 떨어져 있는 지에 대한 상대적인 위치 값으로, <br>
	 * Top으로부터 떨어져 있는 거리를 의미합니다. (단, 1부터 시작)
	 *
	 * @param value 스택에서 위치를 찾을 요소
	 * @return 스택의 상단부터 처음으로 요소와 일치하는 위치를 반환.
	 *         만약 일치하는 요소가 없을 경우 -1 을 반환 
	 */
	/* 
	 *         ________
	 *         | a    |
	 * idx 3   |______|   search("w")
	 *         | e    |   --> 상단(idx 3)으로 부터 3번 째에 위치 
	 * idx 2   |______|       == return 되는 값 : 3
	 *         | w    |
	 * idx 1   |______| 
	 *         | k    |
	 * idx 0   |______|
	 * 
	 * 
	 * 데이터의 개수 size            = 4
	 * 찾으려는 데이터("w")의 위치 idx = 1
	 * return 되는 값 = size - idx = 3 (상단Top(idx3)에서 부터 3번째에 위치)
	 */ 
	int search(Object value);
	
	/**
	 * 스택의 요소 개수를 반환합니다.
	 * @return 스택에 있는 요소 개수를 반환
	 */
	int size();
	
	/**
	 * 스택에 있는 모든 요소를 삭제합니다.
	 */
	void clear();
	
	/** 
	 * 스택에 요소가 비어있는지를 반환합니다. 
	 * @return 스택에 요소가 없을 경우 {@code true}, 그 외의 경우 {@code false}를 반환
	 */
	boolean isEmpty();

}
