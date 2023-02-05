package orderStatistic;

import util.Util;

import java.util.Arrays;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {
	private final Util util;

	public QuickSelect(){
		this.util = new Util();
	}
	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento
	 *            este array normalmente nao esta ordenado
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 *
	 */
	public T quickSelect(T[] array, int k) {
		// é executado somente na metade que tem o elemento
		if(validation(array, k) == false){
			return null;
		}
		quickSort(array,0, array.length - 1, k);
		return array[k - 1];

	}
	public void quickSort(T[] array, int leftIndex, int rightIndex, int k) {

		if(rightIndex > leftIndex){
			int pivotIndex = partition(array, leftIndex, rightIndex);
			if(pivotIndex >= k){
				quickSort(array, leftIndex, pivotIndex - 1, k);
			}else{
				quickSort(array, pivotIndex + 1, rightIndex, k);
			}
		}
	}
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int range = rightIndex - leftIndex + 1;
		int rand_pivot_index = (int)(Math.random() * range) + leftIndex;

		util.swap(array, leftIndex, rand_pivot_index);

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

	private boolean validation(T[] array,int k) {
		if(array == null){
			return false;
		}
		if(k > array.length || k < 1){
			return false;
		}
		return true;
	}


}