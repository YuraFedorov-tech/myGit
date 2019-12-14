
public class HashMapMy<K, V> {
	Node<K, V>[] table = (Node<K, V>[]) new Node[16];
	private int size;
	private Node<K, V> newNode;

	public int size() {
		return size;
	}

	public void put(K key, V volume) {
		int h;
		int hash = (key == null) ? 0 : key.hashCode();
		int placeInArray = hash % (table.length - 1);
		newNode = new Node<>(key, volume, hash);
		if (table[placeInArray] == null) {
			eseyPut(key, volume, hash, placeInArray);
			size++;
			return;
		}
		Node<K, V> cur = table[placeInArray];
		do  {
			cur = cur.next;
			if (cur.getKey().equals(key) && cur.getHash() == hash ) {
				cur.setVolume(volume);
				return;
			} 
				
			

			
		}while(cur.next != null);
		cur.next = newNode;
	}

	private void eseyPut(K key, V volume, int hash, int placeInArray) {
		table[placeInArray] = new Node<>(key, volume, hash * 20 / 19);
		table[placeInArray].next = newNode;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null)
				continue;
			table[i] = table[i].next;
			while (table[i] != null) {
				s += table[i].show() + " ";
				table[i] = table[i].next;
			}
		}
		return s;

	}

}
