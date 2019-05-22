package assignment4;
 

public class EquationBinaryTree {
 private Node root;

 public EquationBinaryTree()
 {
  root = null;
 }

 //left -> parent -> right
 public void printInfix()
 {
  if(root != null)
  {
   printInfixHelper(root);
   System.out.println();
  }
 }
 //left -> parent -> right
 private void printInfixHelper(Node n)
 {
  if(n.left != null)//know the right also exists
  {
   System.out.print("(");
   printInfixHelper(n.left);
   System.out.print(n.data);
   printInfixHelper(n.right);
   System.out.print(")");
  }
  else
  {
   System.out.print(n.data);
  }
 }

 //left -> right -> parent
 public void printPostfix()
 {
  if(root != null)
  {
   printPostfixHelper(root);
   System.out.println();
  }
 }
 private void printPostfixHelper(Node n)
 {
  if(n.left != null)//know the right also exists
  {
   printPostfixHelper(n.left);
   printPostfixHelper(n.right);
   System.out.print(n.data);
  }
  else
  {
   System.out.print(n.data);
  }
 }

 //parent -> left -> right
 public void printPrefix()
 {
  if(root != null)
  {
   printPrefixHelper(root);
   System.out.println();
  }
 }
 private void printPrefixHelper(Node n)
 {
  if(n.left != null)//know the right also exists
  {
   System.out.print(n.data);
   printPrefixHelper(n.left);
   printPrefixHelper(n.right);
  }
  else
  {
   System.out.print(n.data);
  }
 }

 //abc*+de*f+g*+
 public void populateFromPostfix(String postfix)
 {
   root = populateFromPostfixHelper(postfix);
 }
 private Node populateFromPostfixHelper(String postfix){
 String[] parts = postfixSplitter(postfix);//0 = left, 1 = middle, 2 = right
 Node item = new Node(parts[1]);
 if(parts[0].length() > 0)
  item.left = populateFromPrefixHelper(parts[0]);
 if(parts[2].length() > 0)
  item.right = populateFromPrefixHelper(parts[2]);
 return item;
 }

  private String[] postfixSplitter(String postfix)
  {
   String[] temp = new String[3];
   if(postfix.length() > 1)
   {
	   postfix = postfix.substring(1, postfix.length()-1);//remove outer paren
    int parenCount = 0;
    int i;
    for(i = 0; i < postfix.length(); i++)
    {
     if(postfix.charAt(i) == '(')
      parenCount++;
     else if(postfix.charAt(i) == ')')
      parenCount--;
     if(parenCount == 0)
      break;
    }
    temp[0] = postfix.substring(0, i+1);
    temp[1] = ""+postfix.charAt(i+1);
    temp[2] = postfix.substring(i+2);
    /*
    System.out.println(infix.substring(0, i+1));//left point
    System.out.println(infix.charAt(i+1));//middle point
    System.out.println(infix.substring(i+2));//right point
    System.out.println(infix + ":" + i);
    */
   }
   else
   {
    temp[0] = "";
    temp[1] = postfix;
    temp[2] = "";
   }
   return temp;
  }
 //++a*bc*+*defg
 public void populateFromPrefix(String prefix)
 {
   root = populateFromPrefixHelper(prefix);
 }
 private Node populateFromPrefixHelper(String prefix){
	 String[] parts = prefixSplitter(prefix);//0 = left, 1 = middle, 2 = right
	  Node item = new Node(parts[1]);
	  if(parts[0].length() > 0)
	   item.left = populateFromInfixHelper(parts[0]);
	  if(parts[2].length() > 0)
	   item.right = populateFromInfixHelper(parts[2]);
	  return item;
 }
 private String[] prefixSplitter(String prefix)
 {
  String[] temp = new String[3];
  if(prefix.length() > 1)
  {
    prefix = prefix.substring(1, prefix.length()-1);//remove outer paren
   int parenCount = 0;
   int i;
   for(i = 0; i < prefix.length(); i++)
   {
    if(prefix.charAt(i) == '(')
     parenCount++;
    else if(prefix.charAt(i) == ')')
     parenCount--;
    if(parenCount == 0)
     break;
   }
   temp[0] = prefix.substring(0, i+1);
   temp[1] = ""+prefix.charAt(i+1);
   temp[2] = prefix.substring(i+2);
   /*
   System.out.println(infix.substring(0, i+1));//left point
   System.out.println(infix.charAt(i+1));//middle point
   System.out.println(infix.substring(i+2));//right point
   System.out.println(infix + ":" + i);
   */
  }
  else
  {
   temp[0] = "";
   temp[1] = prefix;
   temp[2] = "";
  }
  return temp;
 }
 //(a+b)
 //((a+b)+c)
 //(a+(b+c))
 //((a+(b*c))+(((d*e)+f)*g))
 public void populateFromInfix(String infix)
 {
  root = populateFromInfixHelper(infix);
 }
 
 private Node populateFromInfixHelper(String infix)
 {
  String[] parts = infixSplitter(infix);//0 = left, 1 = middle, 2 = right
  Node item = new Node(parts[1]);
  if(parts[0].length() > 0)
   item.left = populateFromInfixHelper(parts[0]);
  if(parts[2].length() > 0)
   item.right = populateFromInfixHelper(parts[2]);
  return item;
 }

 private String[] infixSplitter(String infix)
 {
  String[] temp = new String[3];
  if(infix.length() > 1)
  {
   infix = infix.substring(1, infix.length()-1);//remove outer paren
   int parenCount = 0;
   int i;
   for(i = 0; i < infix.length(); i++)
   {
    if(infix.charAt(i) == '(')
     parenCount++;
    else if(infix.charAt(i) == ')')
     parenCount--;
    if(parenCount == 0)
     break;
   }
   temp[0] = infix.substring(0, i+1);
   temp[1] = ""+infix.charAt(i+1);
   temp[2] = infix.substring(i+2);
   /*
   System.out.println(infix.substring(0, i+1));//left point
   System.out.println(infix.charAt(i+1));//middle point
   System.out.println(infix.substring(i+2));//right point
   System.out.println(infix + ":" + i);
   */
  }
  else
  {
   temp[0] = "";
   temp[1] = infix;
   temp[2] = "";
  }
  return temp;
 }

 private class Node
 {
  String data;
  Node left, right;
  public Node(String d)
  {
   data = d;
   left = null;
   right = null;
  }
 }
}
