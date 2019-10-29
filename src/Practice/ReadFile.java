package Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadFile {

	private static HashMap<String,ArrayList<String>> Graph = new HashMap<String,ArrayList<String>>();
	public static void main(String[] args) throws FileNotFoundException {
		
	 File file = new File("C:\\MS\\map.txt");
	 Scanner sc = new Scanner(file);
	 
	 while(sc.hasNextLine())
	 {
	  String [] line = sc.nextLine().split(","); 
	//  System.out.println(sc.nextLine());
	  
	  ArrayList<String> list = new ArrayList<String>(); 
	 
	  
	  for (int i = 3; i< line.length; i++)
	  {
		  list.add(line[i]);
	  }
	  
	
	  Graph.put(line[0],list);
	  
	 }

	 System.out.print(Graph);
	 sc.close();
	}

}
