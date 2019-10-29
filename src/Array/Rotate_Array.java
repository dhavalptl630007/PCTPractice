package Array;

import java.util.Arrays;

public class Rotate_Array {

	public static void main(String[] args) {
		
	int[]a = { 1,2,3,4,5,6,7,0};
	
	int temp = a[0];
	for (int i = 0; i <a.length-1; i++)
	{   
		 
		a[i] = a[i+1];
		
	}
	a[a.length-1] = temp;
	for (int i = 0; i <a.length; i++)
	{
		System.out.println(a[i]);
		
	}
		
	int temp1 = a[a.length-1];
	
	for (int i = a.length-1; i>0;i-- )
	{
		a[i] = a[i-1];
		
	}
   
	a[0] = temp1;
	for (int i = 0; i <a.length; i++)
	{
		System.out.println(a[i]);
		
	}
	// insert 4th at position 10
	for ( int i = a.length-1; i>3;i--)
	{
		a[i]= a[i-1];
	
	}
	
	a[3] = 10;
	
	for (int i = 0; i <a.length; i++)
	{
		System.out.println(a[i]);
		
	}
	
	int arr[] = Arrays.copyOf(a, 8);
	
	System.out.println("copy");
	for (int i = 0; i <a.length; i++)
	{
		System.out.println(arr[i]);
		
	}
	 
	System.out.println(Arrays.equals(arr, a));
	
	}
}
