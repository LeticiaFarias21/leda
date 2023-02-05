package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	private Util util;

	public KLargestOrderStatisticsImpl(){
		this.util = new Util();
	}

	@Override
	public T[] getKLargest(T[] array, int k) {
		//este metodo deve obrigatoriamente usar o orderStatistics abaixo.
		// pegar todas as estatisticas maiores que K
		if(validation(array, k) == false){
			return (T[]) new Comparable[]{};
		}
		T[] retorno = (T[]) new Comparable[k];
		sort(array);
		int count = 0;
		for(int i = k; i <= array.length; i++){
			retorno[count] = orderStatistics(array, i);
			count++;
		}
		return retorno;
	}


	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k) {
		T menorElemento = null;

		if (k > array.length || k < 1) {
			return menorElemento;
		} else {
			int indexMenorElemento = selectionMenorElemento(array, 0, array.length - 1);
			menorElemento = array[indexMenorElemento];

			for (int h = 1; h <= k - 1; h++) {
				menorElemento = elementoFinal(array, menorElemento);
			}
		}
		return menorElemento;
	}

	private int selectionMenorElemento(T[] array, int leftIndex, int rightIndex) {

		int indexMenorElemento = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(array[indexMenorElemento]) < 0) {
				indexMenorElemento = j;
			}
		}
		return indexMenorElemento;
	}

	private T elementoFinal(T[] array, T elemento) {

		int diferencaAnterior = 9999;
		T elementoFinal = array[0];

		for (T comparador : array) {
			if (comparador.compareTo(elemento) > 0) {
				int diferencaAtual = comparador.hashCode() - elemento.hashCode();
				if (diferencaAtual < diferencaAnterior) {
					diferencaAnterior = diferencaAtual;
					elementoFinal = comparador;
				}
			}
		}
		return elementoFinal;
	}

	public void sort(T[] array){
		for(int leftIndex = 0 ;leftIndex < array.length - 1; leftIndex++){
			int minIndex = leftIndex;
			for(int j = leftIndex + 1; j < array.length;j++){
				if(array[minIndex].compareTo(array[j]) > 0){
					minIndex = j;
				}
			}
			util.swap(array, minIndex, leftIndex);
		}
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
