package Interface_form.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

import Interface_form.StackInterface;


/**
 * 
 * <b>* 스택(Stack) 기본 용어</b><br>
 *  Bottom   : 가장 밑에 있는 데이터 또는 그 데이터의 인덱스 <br>
 *  Top      : 가장 위에 있는 데이터 또는 그 데이터의 인덱스 <br>
 *  Capacity : 데이터를 담기 위한 용적 <br>
 *  size     : 데이터의 개수 <br>
 *  <br>
 *  push     : 데이터를 추가하는 작업 (리스트에서는 add와 같은 역할)
 *  pop      : '가장 마지막 데이터'를 삭제하는 작업 (리스트에서는 remove와 같은 역할)
 * @author 김시욱
 *
 * @param <E>
 */
public class Stack<E> implements StackInterface<E>, Cloneable {
	
	private static final int DEFAULT_CAPACITY = 10; // 배열이 생성될 때의 최소(기본) 용적(할당) 크기로, 기본값은 10으로 설정 
	private static final Object[] EMPTY_ARRAY = {}; // 빈 배열 (용적이 0인 배열)
	
	private Object[] array; // 요소를 담을 배열
	private int size;       // 배열에 담긴 요소(원소) 개수 (용적 크기가 아님!) 
	
	// 생성자1 (초기 공간 할당 X)
	public Stack() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	
	// 생성자2 (초기 공간 할당)
	public Stack(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}
	
	/** 
	 * 동적할당을 위한 resize 메소드입니다. <br>
	 * 
	 * <b>* 케이스별 동적할당 방법</b><br>
	 * 1. 빈 배열일 경우 (capacity = 0), 기본 용적 크기(DEFAULT_CAPACITY)로 변경합니다.<br> 
	 * 2. 용적이 가득 찰 경우, 현재 용적 크기의 2배로 늘립니다.<br>
	 * 3. 용적의 절반 미만으로 요소가 차지하고 있을 경우, 현재 용적 크기의 1/2로 변경합니다.<br>
	 */
	private void resize() {
		
		// 1. 빈 배열일 경우 (capacity = 0)
		if(Arrays.equals(array, EMPTY_ARRAY)) { // 주소가 아닌 값을 비교해야 하기 때문에 Arrays.equals() 메소드 이용 
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		
		int arrayCapacity = array.length; // 현재 용적 크기 
		
		// 2. 용적이 가득 찰 경우
		if(arrayCapacity == size) {
			int newCapacity = arrayCapacity*2; 
			
			array = Arrays.copyOf(array, newCapacity); // 배열 복사
			return;
		}
		
		// 3. 용적의 절반 미만으로 요소가 차지하고 있을 경우
		if(size < (arrayCapacity/2)) {
			int newCapacity = arrayCapacity/2;
			
			array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity)); // 배열 복사 
			return;
		}
		
	}
	
	@Override
	public E push(E item) {
		// 용적이 꽉 차있다면 용적을 재 할당 해준다. 
		if(size == array.length) {
			resize();
		}
		
		array[size] = item; // 마지막 위치에 요소 추가 
		size++; // 사이즈 1 증가 
		
		return item;
	}
	
	@Override 
	public E pop() {
		// 삭제할 요소가 없는 경우 Stack이 비어있다는 의미로 예외 발생시키기
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		@SuppressWarnings("unchecked")
		E item = (E) array[size-1]; // 삭제될 요소를 반환하기 위한 임시변수 
		
		array[size-1] = null; // 요소 삭제
		size--; // 사이즈 1 감소
		resize(); // 용적 재할당 
		
		return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		// Stack이 비어있는 의미로 예외 발생시키기
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		return (E) array[size-1];
	}
	
	@Override
	public int search(Object value) { // ★
		
		for(int i=size-1; i>=0; i--) {
			// 같은 객체를 찾았을 경우 size-i 값을 반환 (찾으려는 데이터가 '상단의 데이터로부터 얼마만큼 떨어져 있는 지'에 대한 상대적 위치 값을 구하는 거이기 때문)
			// 즉, Top 으로부터 떨어져 있는 거리를 의미 (단, 1부터 시작)
			if(value.equals(array[i])) {
				return size-i;
			}
		}
		
		return -1;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void clear() {
		// 저장되어있던 모든 요소를 null 처리해준다. 
		for(int i=0; i<size; i++) {
			array[i] = null;
		}
		
		size = 0;
		resize();
	}
	
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	/* -------------------- 부가 메소드(clone, toArray, sort) -------------------- */
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 새로운 스택 객체 생성
		Stack<?> cloneStack = (Stack<?>) super.clone();
		
		// 새로운 스택의 배열도 생성해줘야 함 (내부 객체는 깊은 복사가 되지 않기 때문)
		cloneStack.array = new Object[size];
		
		// 현재 배열을 새로운 스택의 배열에 값을 복사함 
		System.arraycopy(array, 0, cloneStack.array, 0, size);
		return cloneStack;
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if(a.length < size) {
			return (T[]) Arrays.copyOf(array, size, a.getClass()); 
		}
		
		System.arraycopy(array, 0, a, 0, size);
		
		return a;
	}
	
}
