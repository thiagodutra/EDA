package ds.ht;

public class App {

	public static void main(String[] args) throws Exception{
		
		HashTable ht = new HashTable();
		
		ht.insert(10);
		ht.insert(11);
		ht.insert(15);
		ht.insert(9);
		ht.insert(13);
		ht.insert(5);
		ht.insert(3);
		ht.insert(1);
		ht.insert(2);
		ht.insert(20);
//		System.out.println(ht.search(21));
		System.out.println(ht.print());

	}

}
