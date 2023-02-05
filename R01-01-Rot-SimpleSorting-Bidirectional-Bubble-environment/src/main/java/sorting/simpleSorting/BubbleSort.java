package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private final Util util;

	public BubbleSort(){
		this.util = new Util();
	}
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		for(int index = leftIndex; index < rightIndex; index++){
			for(int indexComparação = 0; indexComparação < array.length - index - 1; indexComparação++){
				if(array[indexComparação].compareTo(array[indexComparação+1]) > 0){
					util.swap(array, indexComparação,indexComparação + 1);
				}
			}
		}
	}

}


