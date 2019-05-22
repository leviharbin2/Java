package lexicalAnalyzerPackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.Reader;
//Levi Harbin
public class LexicalAnalyzer {

			public static void main(String[] args) throws IOException {
				//Setup for scanning a file in, aswell as using scanner to read each line as it is in the file.
				//Scanner scanner = new Scanner("C:\\Users\\L-PC\\Desktop\\lexInput.txt");//change these paths to the file location of testing txt file... make sure to use double slashes
				//File file = new File("C:\\Users\\L-PC\\Desktop\\lexInput.txt");//change these paths to the file location of testing txt file
				Scanner scanner = new Scanner("D:\\other\\eclipse\\assignments\\assignment\\src\\lexicalAnalyzerPackage\\lexInput");//change these paths to the file location of testing txt file... make sure to use double slashes
				File file = new File("D:\\other\\eclipse\\assignments\\assignment\\src\\lexicalAnalyzerPackage\\lexInput");//change these paths to the file location of testing txt file
				Scanner scanner2 = new Scanner(file);
				String inputLine = scanner.nextLine();		
				System.out.println("Levi Harbin, CSCI4200-DB, Fall 2018, Lexical Analyzer");
			      
				
					
				
				
				//try to read in the file and run main method
				try{
			            reader = new FileReader(inputLine);		           
			            getChar();//initial getChar
			      
			            
			          //loop through file as long as there is a next line  
			          for(int i = 0; scanner2.hasNextLine();) {
			       	  System.out.println("********************************************************************************");
			        	  System.out.println(scanner2.nextLine());
			        	  getChar();		        	 
			        	  do{
			        		 
				                lex();
				                
				               
				            }while (nextToken != "END_OF_FILE");
			        	
			          }
			       	  System.out.println("********************************************************************************");

			          System.out.println("Lexical analysis of the program is complete!");

			        	 
			        	//catch filenotfound and exception
			        } catch (FileNotFoundException e) {
			            e.printStackTrace();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }

			        
			    }

			
				
				
		            
			            
			            
			            
			            
			            
			  
//=============================================================================

	
	//tokens
	static int INT_LIT = 10;
	static int IDENT = 11;
	static int ASSIGN_OP = 20;
	static int ADD_OP = 21;
	static int SUB_OP = 22;
	static int MULT_OP = 23;
	static int DIV_OP = 24;
	static int LEFT_PAREN = 25;
	static int RIGHT_PAREN = 26;
	static int END_OF_FILE = 27;
	static int LETTER = 0;	
	static int DIGIT = 1;	
	static int UNKNOWN = 99;	
	static int charClass;
	static char lexeme [] = new char[100];
	static char nextChar;
	static int lexLen;
	int token;
	static String nextToken;
	static FileReader reader;
	static int blankCount=0;
	
	
	
	
	

	

	
	
	
	
//============================================================================	
	
	
public static void addChar() {//adds each character to make up a full lexeme
	if(lexLen <= 98) {
		lexeme[lexLen++] = nextChar;
		lexeme[lexLen] = 0;
	}
	else
		System.out.println("Error - lexeme is too long \n");
	
	
	
	
}
//============================================================================	

public static void getChar() throws IOException {// Categorizes a character  into LETTER,DIGIT,UNKNOWN, and EOF
	
	
	int character;
    if((character = reader.read()) != END_OF_FILE){
        nextChar = (char) character;
       
       if(Character.isLetter(nextChar))
           charClass = LETTER;
       else if (Character.isDigit(nextChar))
           charClass = DIGIT;
       else
           charClass = UNKNOWN;
       
    }else{
        charClass = END_OF_FILE;
        
    }
}
//============================================================================	
public static void getNonBlank() throws IOException {//find a character that isn't a blank
	while(nextChar ==' ') {
		getChar();
	
		
		
	}
	
}
//============================================================================	
public static  String lex() throws IOException {//Main part, gets a nonblank, and then based off LETTER DIGIT UNKNOWN EOF value it does appropriate rules
	lexLen = 0;
	getNonBlank();
	
	switch (charClass) {
	
	
	case 0:
		addChar();
		getChar();
		while(charClass == LETTER || charClass == DIGIT) {
			addChar();
			getChar();
		}
		nextToken = "IDENT";
		break;
		
	case 1:
		addChar();
		getChar();
		while(charClass == DIGIT) {
			addChar();
			getChar();
		}
		nextToken = "INT_LIT";
		break;	
		
	case 99:
		lookup(nextChar);
		getChar();	
		break;
		
	case 27:
		nextToken = "END_OF_FILE";
		lexeme[0] = 'E';
		lexeme[1] = 'O';
		lexeme[2] = 'F';
		break;
		
		
	
	}
	
	System.out.println("Next token is: "+nextToken+"\t"+"Next lexeme is: "+convertLexeme());// print statement in console
	
		
	
	return nextToken;
	
	
	
	
	
	
	
	
	
	}
	
//============================================================================		
	
	


static String lookup(char ch) {//converts operators and symbols to appropriate Token of type String.
	 switch (ch) {
	 	case '(':
	 		addChar();
	 		nextToken = "LEFT_PAREN";
	 		break;
	 		
	 	case ')':
	 		addChar();
	 		nextToken = "RIGHT_PAREN";
	 		break;
	 		
	 	case '+':
	 		addChar();
	 		nextToken = "ADD_OP";
	 		break;
	 		
	 	case '-':
	 		addChar();
	 		nextToken = "SUB_OP";
	 		break;
	 		
	 	case '*':
	 		addChar();
	 		nextToken = "MULT_OP";
	 		break;
	 		
	 	case '/':
	 		addChar();
	 		nextToken = "DIV_OP";
	 		break;
	 
	 	case '=':
	 		addChar();
	 		nextToken = "ASSIGN_OP";
	 		break;
	 
	 	default:
	 		addChar();
	 		nextToken = "END_OF_FILE";	 		
	 		break;
	 }
	 return nextToken;
	}


//============================================================================	
static String convertLexeme() {// takes the character array lexeme[] and returns the character(s) stored in it
	String results = "";
	for (int i = 0; i<lexeme.length; i++) {
		if(lexeme[i] ==0)
			break;
		results+= lexeme[i];
	}
	return results;
	
}
//============================================================================	
			}


