package assignment5;

public class GenericMapTester {

	public static void main(String[] args) {

		Map<String, String> map1 = new Map<String, String>();	
		map1.put("1", "levi");
		map1.put("2", "john");
	   // map1.put("0", "carl");
		
		System.out.println(map1);
		System.out.println();
		
		System.out.println(map1.get("1"));
		
		
		
		
		System.out.println(map1.isEmpty());
		
		
		
		map1.makeEmpty();
		System.out.println();
		System.out.println(map1);
		System.out.println(map1.isEmpty());
		
		
	}

}
