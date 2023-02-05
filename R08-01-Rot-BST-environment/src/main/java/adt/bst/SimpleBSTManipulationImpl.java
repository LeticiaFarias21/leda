package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equalsRecursico(tree1.getRoot(), tree2.getRoot());
	}

	private boolean equalsRecursico(BTNode<T> root, BTNode<T> root1) {
		if(!root.isEmpty() && !root.isEmpty()){
			if(root.equals(root1)){
				return equalsRecursico(root.getLeft(),root1.getLeft())
						&& equalsRecursico(root.getRight(), root1.getRight());
			}
			return true;
		}
		return false;
	}


	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilarRecursivo(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilarRecursivo(BTNode<T> root, BTNode<T> root1) {
		if(!root.isEmpty() && !root.isEmpty()){
			return isSimilarRecursivo(root.getLeft(), root1.getLeft())
					&& isSimilarRecursivo(root.getRight(), root1.getRight());
		}else{
			return (!root.isEmpty() || root1.isEmpty())
					&& (root.isEmpty() || !root1.isEmpty());
		}
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		int treeSize = tree.size();
		if(k >= 1 && k <= treeSize){

			if(k == 1){
				return tree.minimum().getData();
			}else if(k == treeSize){
				return tree.maximum().getData();
			}else{
				return orderStatisticRecursivo(tree, tree.minimum(), k);
			}
		}
		return null;
	}

	private T orderStatisticRecursivo(BST<T> tree, BSTNode<T> minimum, int k) {
		return k == 1
				? minimum.getData()
				: orderStatisticRecursivo(tree, tree.sucessor(minimum.getData()), --k);

	}
}
