package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private final Util util;

	public InsertionSort(){
		this.util = new Util();
	}
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for(leftIndex++; leftIndex < array.length; leftIndex++){
			T keep = array[leftIndex];
			int j = leftIndex - 1;
			while (j>= 0 && array[j].compareTo(keep) > 0){
				array[j+1] = array[j];
				--j;
			}
			array[j+1] = keep;
		}
	}
}
