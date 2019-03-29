import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private T[] arr;
	private int size;
	private final int DEFAULT_SIZE = 10;
	
	/** Creates an ArrayList with an internal array of size 10 */
	public ArrayList() {
		arr = (T[]) new Object[DEFAULT_SIZE];
		size = 0;
	}

	/** Adds the item to the end of the ArrayList */
	public void add(T item) {
		if (size == arr.length) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		
		arr[size++] = item;
	}

	/** Adds the item at the specified position */
	public void add(int pos, T item) {
		if (pos > size || pos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if (size == arr.length) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		
		for (int i = size - 1; i >= pos; i--) {
			arr[i + 1] = arr[i];
		}
		
		arr[pos] = item;
		size++;
	}

	/** Returns the item at the specified position */
	public T get(int pos) {
		if (pos >= size || pos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return arr[pos];
	}

	/** Removes and returns the item at the position */
	public T remove(int pos) {
		if (pos >= size|| pos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		T item = arr[pos];
		
		for (int i = pos + 1; i < size; i++) {
			arr[i - 1] = arr[i];
		}
		
		size--;
		return item;
		
	}

	/** Returns the size of the ArrayList */
	public int size() {
		return this.size;
	}
}
