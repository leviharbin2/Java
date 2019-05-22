package assignment5;

import java.util.Arrays;

public class Map<KeyType, ValueType> {
	
	private Entry<KeyType, ValueType> entries[];
	private final static int DEFAULT_CAPACITY = 10;
	private int size;
	private int numberOfEntries;
	
	
	// map with no parameters
	public Map() {
		
		size = DEFAULT_CAPACITY;
		entries = new Entry[size];
		numberOfEntries = 0;	
	}
	
	
	// map with defined size
	public Map(int size) {
		this.size = size;
		entries = new Entry[size];
		numberOfEntries = 0;
	}
	
	// hash to determine where to place value 
	private int getHash(KeyType key) {
		
		 int hashVal = key.hashCode();
		 

	        hashVal %= entries.length;
	        if( hashVal < 0 )
	            hashVal += entries.length;

	        return hashVal;
	
	}
	
	
	//put method to insert value into map, uses hash
	public void put(KeyType key, ValueType val) {
		
		
		int hashcode = getHash(key);
		Entry<KeyType, ValueType> tmp = entries[hashcode];
		
		Entry<KeyType, ValueType> newEntry = new Entry<KeyType, ValueType>(key,
				val);
		entries[hashcode] = newEntry;
		numberOfEntries++;	
		
		
		
		
		
		
		
		
		
	}
	
	
	//get value based off key, return null if key = null etc.
	public ValueType get(KeyType key) {
		
		
		
		if (key == null) {
			return null;
		}

		int hc = getHash(key);
		Entry<KeyType, ValueType> tmp = entries[hc];

		while (tmp != null) {
			if (tmp.getKey().equals(key)) {
				return tmp.getValue();
			}
			tmp = tmp.getNext();
		}
		return null;
		
		
		
		
		
	}
	//check if map is empty
	public boolean isEmpty() {

		for(int i = 0; i<entries.length;i++) {
			if (entries[i] != null) {
				return false;
			}
			
			
		}
	
		
		return true;
		
	}
	
	//re-make array but empty
	public void makeEmpty() {
		entries = new Entry[size];
		numberOfEntries = 0;
		
	}
	
	public String toString() {
		return "Map [size=" + size + ", numEntries=" + numberOfEntries
				+ "], entries=" + Arrays.toString(entries) + "]";

	}
	
	
	private static class Entry<KeyType, ValueType>
	{
		private KeyType key;
		private ValueType value;
		private Entry<KeyType, ValueType> next;


		Entry(KeyType k , ValueType v){
			this.key = k;
			this.value = v;
		
			
		}
		
		public KeyType getKey() {
			
			return key;
			
		}
		


		public void setKey(KeyType key) {
				
			this.key = key;
			
		}

			
		public ValueType getValue() {
				
				return value;
			}

			
			
			
			
		
		public void setValue(ValueType value) {
			
				this.value = value;
			
		}

			
		
		
		public Entry<KeyType, ValueType> getNext() {
				
			return next;
			
			
		}

			
		public void setNext(Entry<KeyType, ValueType> next) {
				
			this.next = next;
			
		}

			
			public String toString() {
				
				return " key = "+key+" value = "+value;
				
				}
			
			
			
			
			
			}

		}	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
