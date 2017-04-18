package reservationSystem;

import java.io.Serializable;

public interface LinkedList<T> extends Serializable {

	public void add(T acc);

	public Node<T> findByIndex(int index);

	public Node<T> findById(T id);

	public void removeByIndex(int index);

	public void removeById(T id);

	public String toString();

}
