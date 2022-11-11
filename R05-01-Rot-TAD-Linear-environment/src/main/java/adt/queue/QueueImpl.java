package adt.queue;

public class QueueImpl<T> implements Queue<T> {
	private T[] array;
	private int tail;
	private int head;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
		head = -1;
	}

	@Override
	public T head() {
		if(isEmpty()){
			return null;
		}
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		if(tail == -1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		int count = 0;
		for(T comparador: array){
			if(comparador != null){
				count++;
			}
		}
		boolean isFull = false;
		if(count == array.length){
			isFull = true;
		}
		return isFull;
	}

	private void shiftLeft() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 *  * Inserts a new element in the queue or returns an exception if the queue
	 * 	 * is full. Null elements are not allowed (the queue remains unchanged).
	 *
	 * @param element
	 * @throws QueueOverflowException
	 */
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		if(element != null){

		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
