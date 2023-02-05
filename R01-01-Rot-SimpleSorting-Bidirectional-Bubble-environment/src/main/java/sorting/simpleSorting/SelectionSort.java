package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private final Util util;

	public SelectionSort(){
		this.util = new Util();
	}
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for(;leftIndex < array.length - 1; leftIndex++){
			int minIndex = leftIndex;
			for(int j = leftIndex + 1; j < array.length;j++){
				if(array[minIndex].compareTo(array[j]) > 0){
					minIndex = j;
				}
			}
			util.swap(array, minIndex, leftIndex);
		}
	}
}
