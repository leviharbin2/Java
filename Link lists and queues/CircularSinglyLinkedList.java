package assignment3;


 

class Node
{
    protected int data;
    protected Node link;
 
    
    public Node()
    {
        link = null;
        data = 0;
    }    
  
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }    
    
    public void setLink(Node n)
    {
        link = n;
    }    
    
    public void setData(int d)
    {
        data = d;
    }    
    
    public Node getLink()
    {
        return link;
    }    
  
    public int getData()
    {
        return data;
    }
}
 

class linkedList
{
    protected Node start ;
    protected Node end ;
    public int size ;
 
   
    public linkedList(int numberOfPlayers, int numberOfPasses)
    {
        start = null;
        end = null;
        size = numberOfPlayers;
     
        
    }
    
    public boolean isEmpty()
    {
        return start == null;
    }
    
    public int getSize()
    {
        return size;
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void insertAtEnd(int val)
    {
        Node node = new Node(val,null);    
        node.setLink(start);
        if(start == null)
        {            
            start = node;
            node.setLink(start);
            end = start;            
        }
        else
        {
            end.setLink(node);
            end = node;            
        }
        size++ ;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   public void pass(int moves){
    	
	   
	      
	        if (size == 1 && moves == 1)
	        {
	            start = null;
	            end = null;
	            size = 0;
	            return ;
	        }        
	        if (moves == 1) 
	        {
	            start = start.getLink();
	            end.setLink(start);
	            size--; 
	            return ;
	        }
	        if (moves == size) 
	        {
	            Node s = start;
	            Node t = start;
	            while (s != end)
	            {
	                t = s;
	                s = s.getLink();
	            }
	            end = t;
	            end.setLink(start);
	            size --;
	            return;
	        }
	        Node star = start;
	        moves = moves - 1 ;
	        for (int i = 1; i < size - 1; i++) 
	        {
	            if (i == moves) 
	            {
	                Node temp = star.getLink();
	                temp = temp.getLink();
	                star.setLink(temp);
	                break;
	            }
	            star = star.getLink();
	        }
	        size-- ;
	    }
	   
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void display()
    {
        System.out.print("\nList = ");
        Node nd = start;
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if(size ==10) {
        	System.out.print("the winner is "+start.getData());
        return;
        }
        if (start.getLink() == start) 
        {
            System.out.print(start.getData()+ "->"+nd.getData()+ "\n");
            return;
        }
        System.out.print(start.getData()+ "->");
        nd = start.getLink();
        while (nd.getLink() != start) 
        {
            System.out.print(nd.getData()+ "->");
            nd = nd.getLink();
        }
        System.out.print(nd.getData()+ "->");
          nd = nd.getLink();
        System.out.print(nd.getData()+ "\n");
    }
}
 


