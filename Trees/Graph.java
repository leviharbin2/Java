package assignment8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

public class Graph {
	private TreeMap<String, Vertex> graph;
	 private int V;   // No. of vertices

	public Graph()
	{
		graph = new TreeMap<>();
	}

	public void addEdge(String v1, String v2, Integer w)
	{
		//ensure vertex exist in graph
		addVertex(v1);
		addVertex(v2);

		//get vertex object from graph for v1, add an adjacent edge to v2
		graph.get(v1).addEdge(v2, w);
	}
	public void addEdge(String v1, String v2)
	{
		addEdge(v1, v2, 1);
	}
	public void addEdgeUndirected(String v1, String v2, Integer w)
	{
		//ensure vertex exist in graph
		addVertex(v1);
		addVertex(v2);

		//get vertex object from graph for v1, add an adjacent edge to v2
		graph.get(v1).addEdge(v2, w);
		graph.get(v2).addEdge(v1, w);
	}
	public void addEdgeUndirected(String v1, String v2)
	{
		addEdgeUndirected(v1, v2, 1);
	}

	private void addVertex(String v)
	{
		if(!graph.containsKey(v))
		{
			graph.put(v, new Vertex(v));
		}
	}

	public String toString()
	{
		String output = "";

		for(Map.Entry<String,Vertex> e : graph.entrySet())
		{
			output += e.getValue()+"\n";
		}
		return output;
	}

	public void printPath(String vs, String ve, String type)
	{
		if(graph.containsKey(vs) && graph.containsKey(ve))
		{
			System.out.println(type.toUpperCase());
			Vertex s = graph.get(vs);
			if(type.toLowerCase().equals("unweighted"))
			{
				unweighted(s);
			}
			else if(type.toLowerCase().equals("weighted"))
			{
				weighted(s);
			}
			else if(type.toLowerCase().equals("negative"))
			{
				negative(s);
			}
			Vertex e = graph.get(ve);
			/*
			 * Pseudocode
			if(e.dist != INFINITY){
				String path = "";
				Vertex curr = e;
				while(curr.path != null){
					path += curr;
					curr = curr.path;
				}
				path = s + path;
				print(path)
				print(dist)
			}else{
				print("can not reach end");
			}
			 */
			if(e.dist != Integer.MAX_VALUE)
			{
				String path = "";
				Vertex curr = e;
				while(curr.path != null){
					path = curr.getName()+", " + path;
					curr = curr.path;
				}
				path = s.getName()+", " + path;
				System.out.println(path);
				System.out.println(e.dist);
			}
			else
			{
				System.out.println("can not reach end");
			}
		}
	}
	public void unweighted(Vertex s)
	{
		/*
		 * Pseudocode from textbook PG 372
		Queue<Vertex> q = new Queue<Vertex>();
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();
			for each Vertex w adjacent to v{
				if(w.dist == INFINITY){
					w.dist = v.dist + 1;
					w.path = v;
					q.enqueue(w);
				}
			}
		}
		 */
		Queue<Vertex> q = new LinkedList<>();
		for(Map.Entry<String,Vertex> e : graph.entrySet())
		{
			Vertex v = e.getValue();
			v.dist = Integer.MAX_VALUE;//max int is around 2 billion, basically Infinity
			v.path = null;
		}
		s.dist = 0;
		q.offer(s);
		while(!q.isEmpty())
		{
			Vertex v = q.poll();
			for(Map.Entry<String, Integer> temp : v.adjacent.entrySet())
			{
				Vertex w = graph.get(temp.getKey());
				if(w.dist == Integer.MAX_VALUE){
					w.dist = v.dist + 1;
					w.path = v;
					q.offer(w);
				}
			}
		}
	}
	public void weighted(Vertex s)
	{
		/*
		 * Pseudocode
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		//implement Comparable<Vertex> based on distance for PriorityQueue
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
			v.known = false;
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();//smallest distance in queue
			v.known = true;
			for each Vertex w adjacent to v{
				if(w.dist > v.dist + w.weight){
					w.dist = v.dist + w.weight;
					w.path = v;
				}
				if(!w.known){
					q.enqueue(w);
				}
			}
		}
		 */
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		for(Map.Entry<String,Vertex> e : graph.entrySet())
		{
			Vertex v = e.getValue();
			v.dist = Integer.MAX_VALUE;//max int is around 2 billion, basically Infinity
			v.path = null;
			v.known = false;
		}
		s.dist = 0;
		q.offer(s);
		while(!q.isEmpty())
		{
			Vertex v = q.poll();
			v.known = true;
			for(Map.Entry<String, Integer> temp : v.adjacent.entrySet())
			{
				Vertex w = graph.get(temp.getKey());
				Integer weight = temp.getValue();
				if(w.dist > v.dist + weight){
					w.dist = v.dist + weight;
					w.path = v;
				}
				if(!w.known){
					q.offer(w);
				}
			}
		}
	}
	public void negative(Vertex s)
	{
		/*
		 * Pseudocode
		Queue<Vertex> q = new Queue<Vertex>();
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();
			for each Vertex w adjacent to v{
				if(w.dist > v.dist + w.weight){
					w.dist = v.dist + w.weight;
					w.path = v;
					if(!q.contains(w)){
						q.enqueue(w);
					}
				}
			}
		}
		 */
		Queue<Vertex> q = new LinkedList<>();
		for(Map.Entry<String,Vertex> e : graph.entrySet())
		{
			Vertex v = e.getValue();
			v.dist = Integer.MAX_VALUE;//max int is around 2 billion, basically Infinity
			v.path = null;
		}
		s.dist = 0;
		q.offer(s);
		while(!q.isEmpty())
		{
			Vertex v = q.poll();
			for(Map.Entry<String, Integer> temp : v.adjacent.entrySet())
			{
				Vertex w = graph.get(temp.getKey());
				Integer weight = temp.getValue();
				if(w.dist > v.dist + weight){
					w.dist = v.dist + weight;
					w.path = v;
					if(!q.contains(w)){
						q.offer(w);
					}
				}
			}
		}
	}


	public void printMaxDistance()
	{
		int maxDist = 0;
		String vert = "";
		for(Map.Entry<String, Vertex> vertex : graph.entrySet())
			if(vertex.getValue().dist != Integer.MAX_VALUE && vertex.getValue().dist > maxDist)
			{
				maxDist = vertex.getValue().dist;
				vert = vertex.getKey();
			}
		System.out.println("MAX:"+vert+":"+maxDist);
	}
		

public void printTopologicalSort() {
	System.out.println("Topological Sort:");
	int degree[] = new int[V];// array to store the values of vertices
	for(int i = 0; i < V; i++)
    {
        ArrayList<Integer> temp = (ArrayList<Integer>) graph.clone();
       
        for(int node : temp)// traverse the array list that is cloned off the graph
        {
        	degree[node]++;
        }
    }
	
	
	
	
	
	// create a queue that will hold the actual values from the graph at each value of number of vertices
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < V; i++)
        {
            if(degree[i]==0)
                q.add(i);
        }
        
        
        
        int count = 0;
        
    // Vector that will keep the final sorted list
        Vector <String> topOrder=new Vector<String>();
        while(!q.isEmpty())
        {
            // grab front of queue 
            // and add it to topological order
        
             
            // Go through all the neighboring nodes
            
            ArrayList<Integer> temp = (ArrayList<Integer>) graph.clone();
             for(int node : temp);
            {
                // If in-degree becomes zero, add it to queue
               
            }
            count++;
        }
        
     
        
}

}
