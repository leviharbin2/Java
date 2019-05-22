package assignment4;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
public class NumberSix{

public static void main(String[] args) {

 
  Scanner sc = new Scanner(System.in);
  TreeMap<String, String> map1 = new TreeMap<>();
  
  
 String userYN = null;
 Boolean flag = true;
 
  int vowels = 0;
  
  while (flag!=false) {
  System.out.println("Enter a name: ");
  String name = sc.nextLine();
 
  
  
  for (int i = 0; i < name.length(); i++)
  {
      if (name.charAt(i) == 'a' || name.charAt(i) == 'e' || name.charAt(i) == 'i'
              || name.charAt(i) == 'o' || name.charAt(i) == 'u')
      {
          vowels++;
      }
  }
  map1.put(name, vowels+""); 
  vowels = 0;
  
  
  
  
  
  
  
  
  
  
  
  
  System.out.println("Would you like to enter another name? Enter Y or N : ");
  userYN = sc.nextLine();
  if (userYN.equalsIgnoreCase("n")){
    flag = false;
  }

}
System.out.println(map1);  

}



}