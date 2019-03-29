import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private T[] arr;
	private int size;
	private final int DEFAULT_SIZE = 10;
	
	public ArrayList() {
		arr = (T[]) new Object[DEFAULT_SIZE];
		size = 0;
	}

	public void add(T item) {
		if (size == arr.length) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		
		arr[size++] = item;
	}

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

	public T get(int pos) {
		if (pos >= size || pos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return arr[pos];
	}

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

	public int size() {
		return this.size;
	}
}
