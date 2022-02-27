package Interface_form.List;

import java.util.NoSuchElementException;

import Interface_form.ListInterface;

/**
 * 
 * <b>* 메인클래스에서 객체생성 방법</b> <br>
 *  SLinkedList<Integer> list = new SLinkedList<>();
 *  
 * @param <E>
 */
public class SLinkedList<E> implements ListInterface<E>, Cloneable {
	
	private Node<E> head; // 노드의 첫 부분
	private Node<E> tail; // 노드의 마지막 부분
	private int size;     // 리스트에 있는 요소 개수 (= 연결된 노드 개수)  
	
	// 생성자
	public SLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	/**
	 * 특정 위치의 노드를 반환합니다.
	 * 단일연결리스트는 특정 위치의 데이터를 삽입,삭제,검색하기 위해 처음노드(head)부터 다음변수(next)를 통해 특정 위치까지 찾아가야 하기 때문입니다.
	 * 
	 * @param index 리스트에서 찾으려고 하는 위치 변수
	 * @return 특정 위치의 노드를 반환
	 */
	private Node<E> search(int index) {
		
		// 범위 밖(잘못된 위치)일 경우, 예외 던지기
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> x = head; // head가 가리키는 노드부터 시작
		
		for(int i=0; i<index; i++) {
			x = x.next; // x 노드의 다음 노드를 x에 저장한다. 
		}
		
		return x;
	}
	
	/* ------------------------------------------------------------ add ------------------------------------------------------------*/
	
	/**
	 * 리스트에 요소를 가장 앞 부분에 추가합니다. 
	 * 
	 * @param value 리스트에 추가할 요소
	 */
	public void addFirst(E value) {
		
		Node<E> newNode = new Node<E>(value); // 새 노드 생성
		newNode.next = head; // 새 노드의 다음 노드로 head 노드를 연결 
		head = newNode; // head가 가리키는 노드를 새 노드로 변경
		size++; 
		
		/*
		 * 다음에 가리킬 노드가 없는 경우 (= 데이터가 새 노드밖에 없는 경우) 
		 * 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자 마지막 노드다. 
		 * 즉, tail = head 이다. 
		 */
		if(head.next == null) {
			tail = head;
		}
		
	}
	
	/**
	 * 리스트에 요소를 가장 마지막 부분에 추가합니다. 
	 * 
	 * @param value 리스트에 추가할 요소
	 */
	public void addLast(E value) {
		Node<E> newNode = new Node<E>(value); // 새 노드 생성
		
		if(size == 0) { // 처음 넣는 노드일 경우, addFirst로 추가 
			addFirst(value);
			return;
		}
		
		/* 
		 * 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 하고 
		 * tail이 가리키는 노드를 새 노드를 바꿔준다. 
		 */
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}
	
	@Override
	public void add(int index, E value) {
		
		// 잘못된 인덱스를 참조할 경우 예외 발생
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		// 추가하려는 index가 가장 앞에 추가하려는 경우 addFirst 호출 
		if(index == 0) {
			addFirst(value);
			return; 
		}
		
		// 추가하려는 index가 마지막 위치일 경우 addLast 호출 
		if(index == size) {
			addLast(value);
			return;
		}
		
		Node<E> prev_node = search(index-1); // 추가하려는 위치의 이전 노드
		Node<E> next_node = prev_node.next; // 추가하려는 위치의 노드 
		Node<E> newNode = new Node<E>(value);
		
		/*
		 * 이전 노드가 가리키는 노드를 끊은 뒤 새 노드로 변경해준다. 
		 * 또한 새 노드가 가리키는 노드는 next_node로 설정해준다.
		 */
		prev_node.next = null;
		prev_node.next = newNode;
		newNode.next = next_node;
		size++;
		
	}
	
	/* ------------------------------------------------------------ remove ------------------------------------------------------------*/
	
	/**
	 * 리스트의 가장 앞에 있는 요소를 제거합니다. <b>
	 * 즉, head가 가리키는 요소만 없애주면 됩니다. 
	 * 
	 * @return 리스트에서 삭제한 요소(= 가장 앞에 있는 요소)
	 */
	public E remove() {
		
		Node<E> headNode = head;
		
		if(headNode == null) {
			throw new NoSuchElementException();
		}
		
		E element = headNode.data; // 삭제된 노드를 반환하기 위한 임시 변수
		
		Node<E> nextNode = head.next; // head의 다음 노드
		
		// head의 노드의 데이터들을 모두 삭제
		head.data = null;
		head.next = null;
		
		// head가 다음 노드를 가리키도록 업데이트
		head = nextNode;
		size--; 
		
		/*
		 * 삭제된 요소가 리스트의 유일한 요소였을 경우, 
		 * 그 요소는 head이자 tail이었으므로 삭제되면서 tail도 가리킬 요소가 없기 때문에
		 * size가 0일 경우 tail도 null로 변환
		 */
		if(size == 0) {
			tail = null;
		}
		
		return element;
	}
	
	@Override
	public E remove(int index) {
		// 잘못된 범위에 대한 예외 
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		// 삭제하려는 노드가 첫 번째 원소일 경우 
		if(index == 0) {
			return remove();
		}
		
		Node<E> prevNode = search(index-1); // 삭제할 노드의 이전 노드
		Node<E> removeNode = search(index); // 삭제할 노드
		Node<E> nextNode = search(index+1); // 삭제할 노드의 다음 노드 
		
		E element = removeNode.data; // 삭제되는 노드의 데이터를 반환하기 위한 임시변수 
		
		// 데이터 삭제
		removeNode.data = null;
		removeNode.next = null;
		
		prevNode.next = nextNode; // 이전 노드가 가리키는 노드를 삭제하려는 노드의 다음노드로 변경
		
		// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
		if(prevNode.next == null) {
			tail = prevNode;
		}
		
		size--;
		
		return element;
	}
	
	@Override
	public boolean remove(Object value) {
		
		int index = -1;
		
		// 삭제할 요소가 몇 번째에 위치하는 지 확인 
		for(int i=0; i<size; i++) {
			if(value.equals(search(i).data)) {
				index = i;
				break;
			}
		}
		
		// 삭제하려고 하는 요소가 리스트에 존재하지 않으면 false 반환 
		if(index == -1) {
			return false;
		} 
		
		remove(index);
		
		return true;
	}
	
	@Override
	public E get(int index) {
		return search(index).data;
	}
	
	@Override
	public void set(int index, E value) {
		Node<E> replaceNode = search(index);
		replaceNode.data = null;
		replaceNode.data = value;
	}
	
	@Override
	public int indexOf(Object value) {
		int index = 0;
		for(Node<E> x = head; x != null; x = x.next) {
			if(value.equals(x.data)) {
				return index;
			}
			index++;
		}
		/*
		for(int i=0; i<size; i++) {
			if(value.equals(search(i).data)) {
				return i;
			}
		}
		*/
		return -1;
	}
	
	@Override
	public boolean contains(Object value) {
		return (indexOf(value) == -1 ? false : true);
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public void clear() {
		for(Node<E> x = head; x != null;) {
			Node<E> nextNode = x.next;
			x.data = null;
			x.next = null;
			x = nextNode;
		}
		
		head = tail = null;
		size = 0;
	}
	
	/* ------------------------------------------------------------ 부록 ------------------------------------------------------------*/
	
	/**
	 * 사용하고 있던 LinkedList를 새로 하나 복제하고 싶은 경우 사용합니다. <br><br>
	 * 
	 * <b>* 주의점! </b><br>
	 * '=연산자'로 객체를 복사하게 되면 '주소'를 복사하는 것이기 때문에, 
	 * 복사한 객체를 데이터를 조작할 경우 원본 객체까지 영향을 미칩니다. (즉, 얕은 복사(shallow copy)가 된다.)<br><br> 
	 * 
	 * <b>* 구현 방법</b><br>
	 * Cloneable 인터페이스를 implement 해서, <br>
	 * (1) super.clone() 후, <br>
	 * (2) 새로 만들어진 객체의 내부에 데이터를 새로 설정해야 합니다. <br>
	 * 
	 * @return 복제된 LinkedList 반환 
	 */
	public Object clone() throws CloneNotSupportedException {
		
		@SuppressWarnings("unchecked")
		SLinkedList<? super E> clone = (SLinkedList<? super E>) super.clone();
		
		clone.head = null;
		clone.tail = null;
		clone.size = 0; 
		
		for(Node<E> x = head; x != null; x = x.next) {
			clone.addLast(x.data);
		}
		
		return clone;
	}
	
	
	/**
	 * SLinkedList에 있는 요소의 수만큼 정확하게 배열의 크기가 할당됩니다. <br><br>
	 * 
	 * <b>* 사용법</b><br>
	 * {@code SLinkedList<Integer> list = new SLinkedList<>(); } <br>
	 * {@code Object[] array = list.toArray(); }
	 * 
	 * @return 현재 있는 리스트를 객체배열(Object[])로 반환
	 */
	public Object[] toArray() {
		Object[] array = new Object[size];
		
		int index = 0;
		for(Node<E> x = head; x != null; x = x.next) {
			array[index] = (E) x.data;
			index++;
		}
		
		return array;
	}
	
	/**
	 * 복사하려고 하는 리스트(SLinkedList)를 이미 생성된 배열에 복사해주고자 할 때 사용합니다. <br>
	 * 객체 클래스로, 상속관계에 있는 타입이거나 Wrapper(Integer -> Number) 같이 데이터타입을 유연하게 캐스팅할 수 있다. <br><br>
	 * 
	 * <b>* 사용법</b><br>
	 * {@code SLinkedList<Integer> list = new SLinkedList<>(); } <br>
	 * {@code Integer[] array = new Integer[10] } <br>
	 * {@code array = list.toArray(array); }
	 * 
	 * @return 
	 *  - 들어오는 배열(a)가 현재 array의 요소 개수(size)보다 작으면, size에 맞게 a의 공간을 재할당하면서 array에 있던 모든 요소를 복사합니다. <br>
	 *  - 들어오는 배열(a)의 크기가 현재 array의 요소 개수(size)보다 크면, 앞 부분부터 array에 있던 요소만 복사해서 a배열에 넣고 반환해줍니다. <br>
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		
		if(a.length < size) {
			// Array.newInstance(컴포넌트 타입, 생성할 크기)
			a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
		}
		
		int i=0;
		Object[] result = a;
		for(Node<E> x = head; x != null; x = x.next) {
			result[i++] = x.data;
		}
		
		return a;
	}

}
