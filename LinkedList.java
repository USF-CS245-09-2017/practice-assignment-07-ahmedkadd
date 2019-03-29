
public class LinkedList<T> implements List<T> {
	private Node head;
	private int size;
	
	private class Node<T> {
		private T data;
		private Node next;
		
		Node(T data) {
			this.data = data;
			next = null;
		}
	}
	
	public LinkedList() {
		this.head = new Node(null);
		size = 0;
	}

	public void add(T item) {
		Node newNode = new Node(item);
		
		Node end = head;
		
		while (end.next != null) {
			end = end.next;
		}
		
		end.next = newNode;
		size++;
	}

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

	public int size() {
		return this.size;
	}
}
