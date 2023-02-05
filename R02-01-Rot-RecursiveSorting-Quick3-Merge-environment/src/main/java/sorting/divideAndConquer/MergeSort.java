package sorting.divideAndConquer;

import sorting.AbstractSorting;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= rightIndex){
			return;
		}
		else{
			int meio = (leftIndex + rightIndex) / 2;
			sort(array,leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int meio, int rightIndex){
		T[] helper = (T[]) new Comparable[array.length];
		for(int i = 0; i < array.length; i++){
			helper[i] = array[i];
		}
		int i = leftIndex;
		int j = meio + 1;
		int k = leftIndex;

		while (i <= meio && j <= rightIndex){
			if(helper[j].compareTo(helper[i]) >= 0){
				array[k++] = helper[i++];
			}else{
				array[k++] = helper[j++];
			}
		}
		while (i <= meio){
			array[k++] = helper[i++];
		}
		while (j <= rightIndex){
			array[k++] = helper[j++];
		}
	}
}
