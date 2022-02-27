package Interface_form.List;

public class Node<E> {
	E data;
	Node<E> next; // 다음 노드객체를 가리키는 래퍼런스 변수 ('노드 자체'를 가리키기 때문에 따입 또한 Node<E>타입으로 지정해야 함)
	
	Node(E data) { 
		this.data = data;
		this.next = null; 
	}
}
