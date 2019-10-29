package String;

public class Test {

	public static void main(String[] args) {
		String s= "           YES      leading spaces        are valid,    problemsetters are         evillllll";
		//String sub = s.replaceAll("\\s"," ");
		s.trim();
		String mytext = s.replaceAll("( )+", " ");
		mytext.trim();
		String [] arr = mytext.split("\\s+");
		String f = "" ;
		 
		for (int i = 0 ; i<arr.length;i++) 
		{
			
			String[] arr1 = arr[i].split("[!,?._'@]+");
			
			for (int j =0; j<arr1.length;j++)
			{
//				if(!arr1[j].equals(""))
//			f = f+" "+arr1[j];
				
			}
			
			
		}
				
		f.trim();
		
		String arr5[] = f.split("\\s+");
		
	
		
	}

}
