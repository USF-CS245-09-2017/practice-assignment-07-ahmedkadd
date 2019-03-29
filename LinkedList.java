
public class LinkedList<T> implements List<T> {
	private Node head;
	private int size;
	
	/** A node object which represents an entry in the LinkedList */
	private class Node {
		private T data;
		private Node next;
		
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	/* A constructor which creates a dummy-head LinkedList */
	public LinkedList() {
		this.head = new Node(null);
		this.size = 0;
	}

	/** Creates and adds a new node to the end of the LinkedList */
	public void add(T item) {
		Node newNode = new Node(item);
		Node end = head;
		
		while (end.next != null) {
			end = end.next;
		}
		
		end.next = newNode;
		size++;
	}

	/** Creates and adds a new node at the specified position */
	public void add(int pos, T item) {
		if (pos > size || pos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Node newNode = new Node(item);
	
		Node previous = head;
		for (int i = 0; i < pos - 1; i++) {
			previous = previous.next;
		}
		
		newNode.next = previous.next;
		previous.next = newNode;

		size++;
	}

	/** Returns the item in the list at the position */
	public T get(int pos) {
		if (pos >= size || pos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Node node = head;
		
		for (int i = 0; i < pos + 1; i++) {
			node = node.next;
		}
		
		return (T) node.data;
	}

	/** Removes and returns the item at the position */
	public T remove(int pos) {
		if (pos >= size || pos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Node previous = head;
		
		for (int i = 0; i < pos - 1; i++) {
			previous = previous.next;
		}
		
		T item = (T) previous.next.data;
		previous.next = previous.next.next;
		
		size--;
		return item;
	}

	/** Returns the size of the LinkedList */
	public int size() {
		return this.size;
	}
}
