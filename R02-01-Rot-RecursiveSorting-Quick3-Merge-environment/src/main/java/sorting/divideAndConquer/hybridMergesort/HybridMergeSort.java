package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	private final Util util;
	private final MergeSort<T> mergeSort;

	public HybridMergeSort(){
		this.util = new Util();
		this.mergeSort = new MergeSort<>();
	}
	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;

		if(array.length > SIZE_LIMIT){
			mergeSort.sort(array,leftIndex,rightIndex);
			MERGESORT_APPLICATIONS++;
		}else{
			insertionSort(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS++;
		}
	}

	public void insertionSort(T[] array, int leftIndex, int rightIndex){

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
