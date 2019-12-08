
public class Link <Item>{

	private int key;
	private Item value;
	
	public Link(Item i, int key) {
		value=i;
		this.key=key;
	}
	public Item getvalue() {
		return value;
	}
	public void setValue(Item value) {
		this.value = value;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
}
