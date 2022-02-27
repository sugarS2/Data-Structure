package Interface_form.Stack;

import java.util.EmptyStackException;

import Interface_form.StackInterface;
import Interface_form.List.ArrayList;

public class StackExtendArrayList<E> extends ArrayList<E> implements StackInterface<E> {
	
	public StackExtendArrayList() {
		super();
	}
	
	public StackExtendArrayList(int capacity) {
		super(capacity);
	}

	@Override
	public E push(E item) {
		addLast(item); // ArrayList의 addLast()
		return item;
	}

	@Override
	public E pop() {
		int length = size();
		E obj = remove(length-1); // ArrayList의 remove()
		return obj;
	}

	@Override
	public E peek() {
		int length = size();
		if(length == 0) {
			throw new EmptyStackException();
		}
		
		return get(size()-1); // ArrayList의 get()
	}

	@Override
	public int search(Object value) {
		
		int idx = lastIndexOf(value); // ArrayList의 lastIndexOf()
		
		if(idx >= 0) {
			return size() - idx;
		}
		return -1;
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	

}
