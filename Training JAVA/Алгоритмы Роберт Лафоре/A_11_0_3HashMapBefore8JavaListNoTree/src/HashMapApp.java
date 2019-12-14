
public class HashMapApp {

	public static void main(String[] args) {
		HashMapMy <String,Integer>myHashMap=new HashMapMy<>();
	//	for(int i=0;i<10;i++)
	//	myHashMap.put(Integer.toString(i),i);
		
		myHashMap.put("KING",100);
		myHashMap.put("CLARK",90);
		myHashMap.put("BLAKE",0);
		myHashMap.put("FORD",110);
		myHashMap.put("SMITH",10);
		myHashMap.put("KING",140);
		
		//myHashMap.display();
		System.out.print(myHashMap);
		
		
	}

}
