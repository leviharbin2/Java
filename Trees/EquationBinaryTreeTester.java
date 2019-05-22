package assignment4;

 
public class EquationBinaryTreeTester {

 public static void main(String[] args) {
  EquationBinaryTree ebt = new EquationBinaryTree();
 
  ebt.populateFromInfix("(a+b)");
  ebt.printInfix();
  ebt.printPostfix();
  ebt.printPrefix();

  System.out.println();
  ebt.populateFromInfix("((a+b)+c)");
  ebt.printInfix();
  ebt.printPostfix();
  ebt.printPrefix();

  System.out.println();
  ebt.populateFromInfix("(a+(b+c))");
  ebt.printInfix();
  ebt.printPostfix();
  ebt.printPrefix();

  System.out.println();
  ebt.populateFromInfix("((a+(b*c))+(((d*e)+f)*g))");
  ebt.printInfix();
  ebt.printPostfix();
  ebt.printPrefix();
  
  System.out.println();
  ebt.populateFromPrefix("(+ab)");
  ebt.printInfix();
  ebt.printPostfix();
  ebt.printPrefix();
 
  System.out.println();
  ebt.populateFromPostfix("(ab+)");
  ebt.printInfix();
  ebt.printPostfix();
  ebt.printPrefix();
 }

}
