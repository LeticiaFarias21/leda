package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	private final Util util;

	public QuickSortMedianOfThree(){
		this.util = new Util();
	}

	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(rightIndex > leftIndex){
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int range = rightIndex - leftIndex + 1;
		int pivot_index = pickMedianOfThreePivot(array, leftIndex, rightIndex);

		util.swap(array, leftIndex, pivot_index);

		T pivot = array[leftIndex];
		int i = leftIndex;

		for(int j = leftIndex + 1; j <= rightIndex; j++){
			if(array[j].compareTo(pivot) <= 0){
				i++;
				util.swap(array, i, j);
			}
		}
		util.swap(array, leftIndex, i);

		return i;
	}

	private int pickMedianOfThreePivot(T[] array, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;
		T[] sorted = (T[]) new Comparable[3];
		sorted[0] =  array[leftIndex];
		sorted[1] =  array[meio];
		sorted[2] =  array[rightIndex];
		Arrays.sort(sorted);

		if(sorted[1].compareTo(array[leftIndex]) == 0) return leftIndex;
		else if (sorted[1].compareTo(array[meio]) == 0) return meio;
		else return rightIndex;
	}
}
