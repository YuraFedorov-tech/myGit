
public class Link<T,V> {

private int keyHash;
private T key;
private V value;

public Link(T key, V value, int keyHash) {
	this.key=key;
	this.value=value;
	this.keyHash=keyHash;
}

public V getValue() {
	return value;
}

public T getKey() {
	return key;
}

public int getKeyHash() {
	return keyHash;
}

}
