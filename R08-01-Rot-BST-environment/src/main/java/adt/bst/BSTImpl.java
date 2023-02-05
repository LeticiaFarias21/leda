package adt.bst;

import adt.bt.BTNode;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BSTNode<T> node) {
		if(node.isEmpty()) return -1;
		else return 1 + Math.max(height((BSTNode<T>) node.getRight()), height((BSTNode<T>) node.getLeft()));
	}

	@Override
	public BSTNode<T> search(T element) {
		return recursiveSearch(this.root, element);
	}

	private BSTNode<T>  recursiveSearch(BSTNode<T> node, T element) {
		if(node == null || node.isEmpty()) {
			return node;
		}
		else if(node.getData().compareTo(element) == 0){
			return (BSTNode<T>) node;
		}
		else if(element.compareTo(node.getData()) > 0){
			return recursiveSearch((BSTNode<T>) node.getRight(), element);
		}else{
			return recursiveSearch((BSTNode<T>) node.getLeft(), element);
		}
	}

	@Override
	public void insert(T element) {
		if(element != null){
			recursiveInsert(this.root, element);
		}
	}

	private void recursiveInsert(BSTNode<T> node, T element) {
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
			node.setRight(new BSTNode.Builder<T>().parent(node).build());
		}else{
			if(element.compareTo(node.getData()) < 0){
				recursiveInsert((BSTNode<T>) node.getLeft(), element);
			}else{
				recursiveInsert((BSTNode<T>) node.getRight(), element);
			}
		}
	}
	@Override
	public BSTNode<T> maximum() {
		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if(node.isEmpty()) return null;
		if(!node.getRight().isEmpty()){
			return maximum((BSTNode<T>) node.getRight());
		}else{
			return node;
		}
	}
	@Override
	public BSTNode<T> minimum() {
		return minimum(this.root);
	}
	private BSTNode<T> minimum(BSTNode<T> node) {
		if(node.isEmpty()) return null;
		if(!node.getLeft().isEmpty()){
			return minimum((BSTNode<T>) node.getLeft());
		}else{
			return node;
		}
	}
	@Override
	public BSTNode<T> sucessor(T element) {
		// Node a direreita mais a esquerda
		BSTNode<T> node = search(element);
		if(!node.isEmpty()){
			if(!node.getRight().isEmpty()){
				return minimum((BSTNode<T>) node.getRight());
			}else{
				BSTNode<T> parent = (BSTNode<T>) node.getParent();
				while (parent != null && parent.getData().compareTo(node.getData()) < 0) {
					node = parent;
					parent = (BSTNode<T>) node.getParent();
				}
				return parent;
			}
		}
		return null;
	}
	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if(!node.isEmpty()){
			if(!node.getLeft().isEmpty()){
				return maximum((BSTNode<T>) node.getLeft());
			}else{
				BSTNode<T> parent = (BSTNode<T>) node.getParent();
				while (parent != null && parent.getData().compareTo(node.getData()) > 0) {
					node = parent;
					parent = (BSTNode<T>) node.getParent();
				}
				return parent;
			}
		}
		return null;
	}
	@Override
	public void remove(T element) {
		if(element != null) {
			// caso Folha
			BSTNode<T> node = this.search(element);
			if(!node.isEmpty()){
				if(node.isLeaf()){
					node.setData(null);
					node.setRight(null);
					node.setLeft(null);
				// caso 1 filho
				}else if(node.getRight().isEmpty() || node.getLeft().isEmpty()){
					BSTNode<T> filho = node.getRight().isEmpty() ?
							(BSTNode<T>) node.getLeft() : (BSTNode<T>) node.getRight();
					if(this.root.equals(node)){
						filho.setParent(null);
						this.root = filho;
					}else{
						filho.setParent(node.getParent());
						if(node.getParent().getLeft().equals(node)){
							node.getParent().setLeft(filho);
						}else{
							node.getParent().setRight(filho);
						}
					}
				}else{
					T proximo = sucessor(node.getData()).getData();
					remove(proximo);
					node.setData(proximo);
				}
			}
		}
	}
	@Override
	public T[] preOrder() {
		ArrayList<T> elements = new ArrayList<>();
		if(!this.isEmpty()){
			preOrderRecursivo(this.root, elements);
		}
		return (T[]) elements.toArray(new Comparable[size()]);
	}

	private void preOrderRecursivo(BSTNode<T> node, ArrayList<T> elements) {
		if(!node.isEmpty()){
			elements.add(node.getData());
			preOrderRecursivo((BSTNode<T>)node.getLeft(), elements);
			preOrderRecursivo((BSTNode<T>)node.getRight(), elements);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> elements = new ArrayList<>();
		if(!this.isEmpty()){
			orderRecursivo(this.root, elements);
		}
		return (T[]) elements.toArray(new Comparable[this.size()]);
	}

	private void orderRecursivo(BSTNode<T> node, ArrayList<T> elements) {
		if(!node.isEmpty()){
			orderRecursivo((BSTNode<T>)node.getLeft(), elements);
			elements.add(node.getData());
			orderRecursivo((BSTNode<T>)node.getRight(), elements);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> elements = new ArrayList<>();
		if(!this.isEmpty()){
			postOrderRecursivo(this.root, elements);
		}
		return (T[]) elements.toArray(new Comparable[this.size()]);
	}

	private void postOrderRecursivo(BSTNode<T> node, ArrayList<T> elements) {
		if(!node.isEmpty()){
			postOrderRecursivo((BSTNode<T>)node.getLeft(), elements);
			postOrderRecursivo((BSTNode<T>)node.getRight(), elements);
			elements.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
