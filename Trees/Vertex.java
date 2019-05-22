package assignment8;

import java.util.Map;
import java.util.TreeMap;

public class Vertex implements Comparable<Vertex> {
	private String name;
	public TreeMap<String, Integer> adjacent;
	public Integer dist;
	public Vertex path;
	public boolean known;

	public Vertex(String n)
	{
		name = n;
		adjacent = new TreeMap<>();
	}
	public void addEdge(String e, Integer i)
	{
		adjacent.put(e, i);//will overwrite existing edge with same name
	}
	public void addEdge(String e)
	{
		addEdge(e, 1);//use weight of 1 for unweighted
	}


	public String getName() {
		return name;
	}
	public TreeMap<String, Integer> getAdjacent() {
		return adjacent;
	}
	public String toString()
	{
		String output = "Name:"+name+"  Dist:"+dist;
		output += "  Adjacent List:";
		
		for(Map.Entry<String,Integer> e :adjacent.entrySet())
		{
			output += ","+e.getKey()+":"+e.getValue();
		}
		output += " Edge count:"+adjacent.size();
		return output;
	}
	@Override
	public int compareTo(Vertex arg0) {

		return dist.compareTo(arg0.dist);
	}
	public void printMax() {
		
		System.out.println("hi");
	}
	public void topologicalHelper() {
		
	
	}
	}

