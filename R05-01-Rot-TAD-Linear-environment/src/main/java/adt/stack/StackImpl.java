package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		if(top == -1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(top == 0){
			return true;
		}
		return false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()){
			throw new StackOverflowException();
		}
		for(int index = array.length - 1; index >= 0; index--){
			if(array[index] == null){
				array[index] = element;
				this.top = index;
				break;
			}else if(index == 0){
				moveRight(array);
				push(element);
			}
		}
	}

	public void moveRight(T[] array){
		for(int index = array.length - 1; index >= 0;index--){
			if(array[index] != null){
				array[index] = array[index - 1];
				this.top = index;
			}
		}
	}



	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		T retonro = array[this.top--];
		return retonro;
	}

}
