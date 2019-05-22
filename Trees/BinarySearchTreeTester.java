package assignment4;
public class BinarySearchTreeTester{
	

public static void main(String[] args) 
    {
	
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.printInOrder();
        tree.printTree();
        System.out.println("printing tree 1 going horizontal across each level of height, going left to right:");
        tree.printInLevelOrder();
        System.out.println("");
        
        
        
        
        
        
       // tree.remove(val);
       
        
        tree2.insert(5);
        tree2.insert(4);
        tree2.insert(2);
   
      
        
  System.out.println("tree comparison with tree 1 values of  6 4 3 2 7 1, and tree 2 values of 5 4 2 : ");
        if (tree.identicalTrees(tree.getRoot(), tree2.getRoot()))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
       
        
        tree.remove(2);
        tree.remove(7);
        tree.remove(1);
        
        System.out.println("tree comparison with tree 1 values of  6 4 3 , and tree 2 values of 5 4 2 : ");
 
        if (tree.identicalTrees(tree.getRoot(), tree2.getRoot()))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
    
    
    
    
    
    
    }
}


    