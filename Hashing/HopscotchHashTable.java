package bonus2;
import java.math.BigInteger;
import java.util.Arrays;

public class HopscotchHashTable<E> {


	
		private E[] table;
		private int defaultSize = 13;
		private int currentCount;
		private double loadFactor = 0.5;
		private int count = 0;
		private String[] binary;
		private String a = "0000";
		private String b = "0001";
		private String c = "0010";
		private String d = "0011";
		private String e = "0100";
		private String f = "0101";
		private String g = "0110";
		private String h = "1000";
		private String i = "1001";
		private String j = "1010";
		private String k = "1100";
		private String l = "1011";
		private String m = "1101";
		private String n = "1110";
		private String o = "1111";

		 
		
		
		public HopscotchHashTable() {
			buildTable(defaultSize);
		}
		public HopscotchHashTable(int size) {
			buildTable(nextPrime(size));
		}
		private void buildTable(int size)
		{
			table = (E[])new Object[size];
			currentCount = 0;
			binary = new String[size];
			 Arrays.fill(binary, "0000");
		}
		private int nextPrime(int size)
		{
			BigInteger bi = new BigInteger(""+size);
			return bi.nextProbablePrime().intValue();
		}
		public void makeEmpty()
		{
			buildTable(table.length);
		}
		private int hash(E val)
		{
			return Math.abs(val.hashCode()) % table.length;
		}
		private int findPos(E val)//search through cluster for item or null position
		{
			
			int pos = hash(val);
			 
			while(table[pos] != null && !table[pos].equals(val) )
			  
			{
				pos++;
				count++;
			
				if(pos == table.length)
					pos = 0;
			}
	
			//System.out.println(count);
			
			return pos;
		}
		
		
		
		
		
		
		
		
		public void insert(E val)
		{
			
			int pos = findPos(val);//where does item belong in table
	
			if(table[pos] == null && count<=4) {
			
			
				currentCount++;
		    
			table[pos] = val;
		
			
			}
			
			if(currentCount / (double)table.length >= loadFactor)
			{
				rehash();
			}
			if(count> 4)
			{
				rehash();
			}
			count = 0;
			
			
		   
			
			if(pos == hash(val)) {
				binary[pos] = "1000";
			}
			
		
			if(pos != hash(val)) {
				binary[hash(val)] = "1100";
			}
			
			
		
		}
		
		
		
		
		
		public boolean contains(E val)
		{
			int pos = findPos(val);//where does item belong in table

			return (table[pos] != null);
		}
		public E get(E val)
		{
			int pos = findPos(val);//where does item belong in table

			return table[pos];
		}
		public void printHashTable()
		{
			for(int i = 0; i < table.length; i++)
			{
				if(table[i] != null)
					System.out.println("position:" +i+":Data:"+table[i].toString()+":hash:"+hash(table[i])+" Hop:"+ binary[i]);
			}
			System.out.println("Table Size:"+table.length+"\n");
		}

	
		public E delete(E val)
		{
			int pos = findPos(val);
			E temp = table[pos];
			int currentVacant = pos;
			table[pos] = null;
			pos++;
			while(table[pos] != null && !table[pos].equals(val))
			{
				if(hash(table[pos]) <= currentVacant)
				{
					table[currentVacant] = table[pos];
					table[pos] = null;
					currentVacant = pos;
				}
				pos++;
			}
			if(temp != null)
				currentCount--;
			return temp;
		}

		private void rehash()
		{
			System.out.println("rehash was needed");
				}
			
		}



	