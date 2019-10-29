package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Anagrams {
    private static Map<Character,Integer> map1 = new HashMap<Character,Integer>();
    private static TreeMap<Character,Integer> map2 = new TreeMap<Character,Integer>();
    
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
		

	}

	private static boolean isAnagram(String a, String b) {
		boolean flag = false;
		int count = 0;
		  String c = a.toLowerCase();
	      String d = b.toLowerCase();
	      
	      if (c.length() != d.length())
	    	  return false;
	      
	      for ( int i = 0 ; i<c.length();i++)
	      {
	    	  int a1 = 0;
	    	  if (map1.containsKey(c.charAt(i)))
	    	  {
	    		   a1 = map1.get(c.charAt(i));
	    		  
	    		  map1.put(c.charAt(i),a1+1);  		  
	    		  
	    	  }
	    	  
	    	  else
	    	  {  
	    		  map1.put(c.charAt(i),1); 
	    		  
	    	  }
	    	  
	      }
	      
	      for ( int i = 0 ; i<d.length();i++)
	      {
	    	  int a1 = 0;
	    	  if (map2.containsKey(d.charAt(i)))
	    	  {
	    		   a1 = map2.get(d.charAt(i));
	    		  
	    		  map2.put(d.charAt(i),a1+1);  		  
	    		  
	    	  }
	    	  
	    	  else
	    	  {  
	    		  map2.put(d.charAt(i),1); 
	    		  
	    	  }
	    	  
	      }
	      
	      
	      for (Entry<Character,Integer> entry : map1.entrySet())
	      {
	    	  
	    	  char ch = entry.getKey();
	    	  int frequency1 = entry.getValue();
	    	  int frequency2 = 0;
	    	   
	    	    if( map2.get(ch) != null)
	    	    {
	    	    	frequency2 = map2.get(ch);
	    	    }
	    	   
	    	   if (frequency1==frequency2)
	    	   {
	    		   flag = true;
	    		   count = count + frequency2 ;
	    	   }
	    	  
	      }
	      System.out.print(map1.equals(map2));//shortcut
	      if (count == c.length())
	      {
	    	  return true;
	      }
	      
	      
		return false;
	}

}
