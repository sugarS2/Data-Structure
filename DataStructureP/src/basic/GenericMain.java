package basic;

class GeneriClass01<E> {
	private E element; // 제네릭 타입 변수 
	
	void set(E element) { // 제네릭 파라미터 메소드
		this.element = element; 
	}
	
	E get() { // 제네릭 타입 반환 메소드
		return element;
	}
	
	<T> T genericMethod(T o) { // 제네릭 메소드
		// [접근제어자] <제네릭타입> [반환타입] [메소드명] ([제네릭타입] [파라미터]) { .. }
		return o;
	}
	
	
	/*
	 * 잘못된 예시) 
	 * 클래스와 같은 E 타입이더라도, 
	 * static 메소드는 객체가 생성되기 이전 시점에 메모리에 먼저 올라가기 때문에 
	 * E 유형을 클래스로부터 얻어올 방법이 없다. 
	 * 
	 * → 제네릭이 사용되는 메소드를 정적메소드로 두고 싶은 경우, 제네릭 클래스와 별도로 독립적인 제네릭이 사용되어야 한다. 
	 */
	/*
	static E genericErrorMethod(E o) { // error!
		return o;
	}
	
	GenericClass01.genericErrorMethod(3); // GenericClass01 객체가 생성되기 전에 접근은 할 수 있으나, 유형을 지정할 방법이 없어 에러남 
	*/
	
	
	// 아래 메소드의 E 타입은 제네릭클래스의 E타입과 다른 독립적인 타입
	static <E> E genericMethod1(E o) { // 제네릭 메소드
		return o;
	}
	
	static <T> T genericMethod2(T o) { // 제네릭 메소드
		return o;
	}
}

class GenericClass02<K, V> {
	private K first;  // K 타입 (제네릭)
	private V second; // V 타입 (제네릭)
	
	void set(K first, V second) {
		this.first = first;
		this.second = second;
	}
	
	K getFirst() {
		return first;
	}
	
	V getSecond() {
		return second;
	}
}

class GenericMain {
	public static void main(String[] args) {
		
		/** 제네릭 1개 사용 **/
		System.out.println("########## 케이스1 : 제네릭 1개 사용 ##########");
		GeneriClass01<String> a1 = new GeneriClass01<String>();
		GeneriClass01<Integer> b1 = new GeneriClass01<Integer>();
		
		a1.set("10");
		b1.set(10);
		
		System.out.println("a1 data : " + a1.get());
		System.out.println("a1 E Type : " + a1.get().getClass().getName()); // 반환된 변수의 타입 출력
		System.out.println("b1 data : " + b1.get());
		System.out.println("b1 E Type : " + b1.get().getClass().getName()); // 반환된 변수의 타입 출력
		
		System.out.println("<T> returnType : " + a1.genericMethod(3).getClass().getName()); // 제네릭 메소드 Integer
		System.out.println("<T> returnType : " + a1.genericMethod("ABCD").getClass().getName()); // 제네릭 메소드 String
		System.out.println("<T> returnType : " + a1.genericMethod(b1).getClass().getName()); // 제네릭 메소드 ClassName b1
		
		// static 정적 제네릭 메소드 
		System.out.println("<E> returnType : " + GeneriClass01.genericMethod1(3).getClass().getName());      // Integer
		System.out.println("<E> returnType : " + GeneriClass01.genericMethod1("ABCD").getClass().getName()); // String
		System.out.println("<E> returnType : " + GeneriClass01.genericMethod2(a1).getClass().getName());      // ClassName a1
		System.out.println("<E> returnType : " + GeneriClass01.genericMethod2(3.0).getClass().getName());     // Doble
		
		
		/** 제네릭 2개 사용 **/
		System.out.println("\n########## 케이스2 : 제네릭 2개 사용 ##########");
		GenericClass02<String, Integer> a2 = new GenericClass02<String, Integer>();
		
		a2.set("10", 10);
		
		System.out.println("a2 K(first)  data : " + a2.getFirst());
		System.out.println("a2 K(first)  type : " + a2.getFirst().getClass().getName());
		System.out.println("a2 V(second) data : " + a2.getSecond());
		System.out.println("a2 V(second) type : " + a2.getSecond().getClass().getName());
	}
}
