package classes;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<E> {
	// Data fields
	private ArrayList<E> data;
	Comparator<E> comp;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue() {
		data = new ArrayList<>();
		comp = (left, right) -> ((Comparable<E>) left).compareTo(right);
	}
	
	public PriorityQueue(Comparator<E> comp) {
		data = new ArrayList<>();
		this.comp = comp;
	}
	
	public boolean offer(E item) {
		data.add(item);
		int child = data.size() -1;
		int parent = (child-1)/2;
		while (parent>=0 && comp.compare(data.get(parent), data.get(child)) > 0) {
			swap(parent, child);
			child = parent;
			parent = (child - 1)/2;
		}
		return true;
	}
	
	public void swap(int first, int second) {
		E temp = data.get(first);
		data.set(first, data.get(second));
		data.set(second, temp);
	}
	
	public E peek() {
		return data.get(0);
	}
	
	public E poll() {
		if(data.isEmpty()) {
			return null;
		}
		E result = data.get(0);
		if (data.size()==1) {
			data.remove(0);
			return result;
		}
		data.set(0, data.remove(data.size()-1));
		int parent = 0;
		while(true) {
			int leftChild = 2*parent + 1;
			if(leftChild >= data.size()) {
				break;
			}
			int rightChild = leftChild + 1;
			int minChild = leftChild;
			if (rightChild < data.size() && comp.compare(data.get(leftChild), data.get(rightChild)) > 0) {
				minChild = rightChild;
			}
			if (comp.compare(data.get(parent), data.get(minChild)) > 0) {
				swap(parent, minChild);
				parent = minChild;
			} else {
				break;
			}
		}
		return result;
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public Iterator<E> iterator() {
		return data.iterator();
	}

	//public E peek() {
		// TODO Auto-generated method stub
		
	
	
	
}
