package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}
	private int hash(T element, int probe){
		return ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
	}
	@Override
	public void insert(T element) {
		if(element != null && !this.isFull()){
			int probe = 0;
			while(table[hash(element,probe)] != null){
				if(probe == this.capacity()){
					throw new HashtableOverflowException();
				}
				probe++;
				COLLISIONS++;
			}
			table[hash(element,probe)] = element;
			elements++;
		}else if(this.isFull()){
			throw new HashtableOverflowException();
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && this.indexOf(element) != -1){
			table[this.indexOf(element)] = deletedElement;
			elements--;
		}
	}

	@Override
	public T search(T element) {
		T search = null;
		if(element != null && indexOf(element) != -1){
			search = (T) table[this.indexOf(element)];
		}
		return search;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		if(element != null && !this.isEmpty()){
			for(int probe = 0; probe < this.capacity(); probe++){
				if(table[hash(element,probe)] != null){
					if(table[hash(element,probe)].equals(element)){
						index = hash(element,probe);
					}
				}
			}
		}
		return index;
	}
}
