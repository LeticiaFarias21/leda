package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	private final Util util;

	public RecursiveSelectionSort(){
		this.util = new Util();
	}
	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		int minIndex = leftIndex;
		for(int j = leftIndex + 1; j < rightIndex + 1; j++){
			if(array[minIndex].compareTo(array[j]) > 0){
				minIndex = j;
			}
		}
		if(rightIndex >= 0){
			util.swap(array, minIndex, leftIndex);
		}
		if(leftIndex + 1 < rightIndex){
			sort(array, leftIndex + 1, rightIndex);
		}
	}
}
