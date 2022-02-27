package Interface_form.List;

import java.util.Arrays;

import Interface_form.ListInterface;

public class ArrayList<E> implements ListInterface<E>, Cloneable {
	
	private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기
	private static final Object[] EMPTY_ARRAY = {}; //빈 배열
	
	private int size; // 배열에 담긴 요소 개수
	
	Object[] array; // 요소를 담을 배열
	
	// 생성자1 (초기 공간 할당 x) - 공간할당은 안하고, 객체만 생성하고 싶은 경우
	public ArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	
	// 생성자2 (초기 공강 할당 o) - 공간할당을 해놓고 싶은 경우 
	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}
	
	/**
	 * <b>동적할당을 위한 resize 메소드 구현<b><br>
	 * size(요소의 개수)가 용적(capacity)에 얼마만큼 차있는지를 확인하고, 적절한 크기에 맞게 배열의 용적을 변경해야 한다.
	 * 또한 용적은 외부에서 마음대로 접근하면 데이터의 손상을 야기할 수 있기 때문에, private로 접근을 제한한다.
	 */
	private void resize() {
		int array_capacity = array.length;
		
		// 배열의 용적이 비어있는 경우
		if (Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		
		// 배열의 용적이 꽉 찰 경우
		if(size == array_capacity) {
			int new_capacity = array_capacity*2;
			array = Arrays.copyOf(array, new_capacity); // 기존에 담긴 요소들도 복사 
			return;
		}
		
		// 용적의 절반 미만으로 요소가 차지하고 있는 경우
		if(size < (array_capacity/2)) {
			int new_capacity = array_capacity / 2;
			array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
		}
	}
	
	/*
	 --------------------------------------------------------------------------------------
	 add 메소드 - add(E value), addLast(E value), add(int index, E value), addFirst(E value)
	 --------------------------------------------------------------------------------------
	 */
	
	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}
	
	public void addLast(E value) {
		// 꽉 차있는 상태라면 용적 재할당
		if(size == array.length) {
			resize();
		}
		array[size] = value; // 마지막 위치에 요소 추가
		size++; // 사이즈 1 증가 
	}
	
	@Override 
	public void add(int index, E value) {
		if(index > size || index < 0) { // 영역을 벗어날 경우 예외 발생 
			throw new IndexOutOfBoundsException();
		}
		if(index == size) { // 추가할 특정 위치 index가 마지막 위치(size)라면 addLast 메소드로 요소 추가 
			addLast(value);
		} else {
			if(size == array.length) { // 꽉 차있다면 용적 재할당
				resize();
			}
			
			for(int i=size; i>index; i--) { // index 기준 후자에 있는 모든 요소들 한 칸씩 뒤로 밀기
				array[i] = array[i-1];
			}
			
			array[index] = value; // index 위치에 요소 할당 
			size++;
		}
	}
	
	public void addFirst(E value) {
		add(0, value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index >= size || index <0) { // 범위 벗어나면 예외 발생  
			throw new IndexOutOfBoundsException();
		}
		
		// Object 타입에서 E타입으로 캐스팅 후 변환 
		return (E) array[index];
	}
	
	@Override
	public void set(int index, E value) {
		if(index > size || index < 0) { // 범위를 벗어나면 예외 발생 
			throw new IndexOutOfBoundsException();
		} else {
			// 해당 위치의 요소를 교체
			array[index] = value; 
		}
	}
	
	@Override
	public int indexOf(Object value) {
		
		// value와 같은 객체(요소 값)일 경우 i(위치) 반환 
		for(int i=0; i<size; i++) {
			// 객체끼리 비교할 때, 동등연산자(==)가 아닌 반드시 '.equals()'로 비교해야 한다. 
			// 동등연산자는 주소를 비교, 'equals()'는 값을 비교 
			if(array[i].equals(value)) {
				return 1;
			}
		}
		
		// 일치하는 것이 없을 경우 -1을 반환
		return -1;
	}
	
	/**
	 * 리스트에 특정 요소가 뒤에서 부터 몇 번째에 위치하는 지 반환 (indexOf와 반대로 거꾸로 탐색)
	 * 
	 * @param value 리스트에서 위치를 찾을 요소 변수
	 * @return 리스트에서 뒤에서 시작해서, 처음으로 요소와 일치하는 위치를 반환. 만약 일치하는 요소가 없는 경우 -1 반환 
	 */
	public int lastIndexOf(Object value) {
		for(int i=size-1; i>=0; i--) {
			if(array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public boolean contains(Object value) {
		if (indexOf(value) == -1) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} 
		
		E element = (E) array[index]; // 삭제할 요소를 반환하기 위해 임시로 담아둠
		array[index] = null; 
		
		// 삭제한 요소의 뒤에 있는 요소들을 한 칸씩 당겨옴 
		for(int i=index; i<size; i++) {
			array[i] = array[i+1];
			array[i+1] = null;
		}
		size--;
		resize();
		
		return element;
	}

	@Override
	public boolean remove(Object value) {
		// 삭제하고자 하는 요소의 첫번째 인덱스 찾기
		int index = indexOf(value);
		
		// -1이면 array에 요소가 없다는 의미로 false 반환
		if(index == -1) {
			return false;
		}
		
		// index 위치에 있는 요소를 삭제
		remove(index);
		return true;
	}

	@Override
	public int size() {
		/* 
		 * ArrayList가 동적으로 할당되면서 요소들을 삽입,삭제가 많아지면 사용자가 리스트에 담긴 요소의 개수가 몇 개인지 기억하기 힘들다. 
		 * ArrayList에서 size변수는 private 접근제한자를 갖고 있기 때문에, 외부에서 직접 참조를 할 수 없다. 
		 * (외부에서 size변수를 접근할 수 있게 될 경우, size에 사용자가 고의적으로 데이터를 조작할 수 있기 때문이다.)
		 * 
		 * 그렇기때문에, size변수의 값을 반환해주는 size() 메소드를 만들어줄 필요가 있다. 
		 */
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0); // 요소가 0개일 경우, 비어있다는 의미이므로 true 반환 
	}

	@Override
	public void clear() {
		// 모든 공간을 null 처리 해준다. 
		for(int i=0; i<size; i++) {
			array[i] = null;
		}
		
		size = 0;
		resize();
	}
	
	/*
	 ------------------------------------------------------------------------------------------------------------------------------------------------------
	 부록
	 ------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * 기존에 있는 객체를 파괴하지 않고 요소들이 동일한 객체를 새로 하나 만듭니다.<br>
	 * 사용하고 있던 ArrayList를 새로 하나 복제하고 싶은 경우 사용합니다. <br><br>
	 * <b>※ 주의점</b><br>
	 *  단순히 = 연산자로 객체를 복사하게 되면 '주소'를 복사하는 것이기 때문에, <br>
	 *  복사한 객체에서 데이터를 조작할 경우 원본 객체까지 영향을 미칩니다. <br>
	 *  즉, 얕은 복사(shallow copy)가 됩니다. 
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 새로운 객체 생성 
		ArrayList<?> cloneList = (ArrayList<?>) super.clone();
		
		// 새로운 객체의 배열로 생성해줘야 함 (객체는 얕은 복사가 되기 때문)
		cloneList.array = new Object[size];
		
		// 배열의 값을 복사함 
		System.arraycopy(array, 0, cloneList.array, 0, size);
		
		return cloneList;
	}
	
	/**
	 * 아무런 인자 없이 현재 있는 ArrayList의 리스트를 객체배열(Object[])로 반환해줍니다. <br>
	 * ArrayList에 있는 요소의 수큼 정확하게 배열의 크기가 할당되어 반환됩니다. 
	 * 
	 * @return 원본배열(array)을 요소개수(size)만큼 복사하여 Object[] 배열을 반환 
	 */
	public Object[] toArray() {
		
		// Arrays.copyOf(array, size) : 원본배열(array)을 요소개수(size)만큼 복사하여 Object[] 배열을 반환 
		return Arrays.copyOf(array, size);
	}
	
	/**
	 * - 들어오는 배열(a)가 현재 array의 요소 개수(size)보다 작으면, size에 맞게 a의 공간을 재할당하면서 array에 있던 모든 요소를 복사합니다. <br>
	 * - 들어오는 배열(a)의 크기가 현재 array의 요소 개수(size)보다 크면, 앞 부분부터 array에 있던 요소만 복사해서 a배열에 넣고 반환해줍니다. <br>
	 * <br>
	 * 객체 클래스로 상속관계에 있는 타입이거나 Wrapper(Integer → int)같이 데이터 타입을 유연하게 캐스팅할 수 있습니다. <br>
	 * 예) 원본배열의 원소가 5개 있고, 복사할배열에 10개의 원소가 있다면 복사할배열의 0~4 index에 있던 원소가 복사되고, 그 외의 원소는 기존 배열에 초기화 되어있던 원소가 그대로 남습니다. <br>
	 * 
	 * @param <T>
	 * @param a
	 * @return 원본배열을 복사한 배열 
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if(a.length < size) {
			// Arrays.copyOf(array, size, Class<? extends T[]>타입) 
			return (T[]) Arrays.copyOf(array, size, a.getClass());
		}
		
		// 원본배열, 원본배열 시작위치, 복사할배열, 복사할배열의 시작위치, 복사할 요소 수 
		System.arraycopy(array, 0, a, 0, size);
		return a;
	}
	
}
