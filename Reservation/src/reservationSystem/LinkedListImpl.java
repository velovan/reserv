package reservationSystem;

public class LinkedListImpl<T> implements LinkedList<T> {

	Node<T> head;
	Node<T> tail;
	int size = 0;

	public LinkedListImpl() {
		this.size = 0;
	}

	@Override
	public void add(T acc) {
		if (tail == null) {
			Node<T> newNode = new Node<T>(acc);
			head = newNode;
			tail = newNode;
			size++;
		} else {
			Node<T> newNode = new Node<T>(acc);
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
		System.out.println("Added");
	}

	@Override
	public Node<T> findByIndex(int index) {
		Node<T> currentNode = head;
		if (index >= size)
			throw new HotelException("Index inputed greatest tha size");
		while (index-- != 0) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	@Override
	public Node<T> findById(T id) {
		Node<T> currentNode = head;
		for (int i = 0; i < size; i++) {
			if (currentNode.data.equals(id))
				return currentNode;
			else
				currentNode = currentNode.next;
		}
		return null;
	}

	@Override
	public void removeByIndex(int index) {
		Node<T> currentNode = findByIndex(index);
		Node<T> before = currentNode.prev;
		Node<T> after = currentNode.next;
		if (before != null)
			before.next = after;
		else
			head = after;
		if (after != null)
			after.prev = before;
		else
			tail = before;
		size--;
		currentNode = null;
	}

	@Override
	public void removeById(T id) {
		Node<T> currentNode = findById(id);
		try {
			Node<T> before = currentNode.prev;
			Node<T> after = currentNode.next;
			if (before != null)
				before.next = after;
			else
				head = after;
			if (after != null)
				after.prev = before;
			else
				tail = before;
			size--;
			currentNode = null;
			System.out.println("Removed");
		} catch (Exception e) {
			System.out.println("Invalid id");
		}
	}

	@Override
	public String toString() {
		Node<T> currentNode = head;
		String a = "";
		int id = 0;
		while (currentNode != null) {
			a = a + (++id) + currentNode.data;
			currentNode = currentNode.next;
		}
		return a;
	}

}
