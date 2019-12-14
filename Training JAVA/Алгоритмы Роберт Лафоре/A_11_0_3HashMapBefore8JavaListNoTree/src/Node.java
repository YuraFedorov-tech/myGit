
public class Node<K, V> {
	private K key;
	private V volume;
	Node<K, V> next;
	private int hash;

	public Node(K key, V volume, int hash) {
		this.hash=hash;
		this.key=key;
		this.volume=volume;
	}

	public K getKey() {
		return key;
	}
	public V getVolume() {
		return volume;
	}

	public void setVolume(V volume) {
		this.volume = volume;
	}

	public int getHash() {
		return hash;
	}

	public String show() {
		// TODO Auto-generated method stub
		return key+" "+volume;
	}
}
