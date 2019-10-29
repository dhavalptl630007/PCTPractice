package HackerRank;

import java.util.Scanner;

public class ArrayHourGlass  {

	public static void main(String[] args) {
		
		int a[][] = new int[6][6];
		int b[][] = new int[6][6];
		int max = Integer.MIN_VALUE;// major logic because of this test case may fail
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0 ; i<6; i++)
		{
			String arr[] = sc.nextLine().split("\\s+");
			
			for (int j=0; j<arr.length;j++)
			{
				//if (arr[j].contains("-"))
				//{
					//String sub = arr[j].substring(1);
				//	a[i][j] = Integer.parseInt(sub)*-1;
				//}
				//else
				//{
					
				a[i][j] = Integer.parseInt(arr[j]);
				
				//}
				
			}
			
		}
		
		
		for (int i = 0 ; i<6; i++)
		{
			
			
			for (int j=0; j<6;j++)
			{
				System.out.print(a[i][j]+" ");		
			}
			System.out.println();
		}
		
		
		for (int i = 1 ; i<5; i++)
		{
			
			
			for (int j=1; j<5;j++)
			{
				//System.out.print(a[i][j]+" ");
				int sum = 0;
				
				 for (int l = -1 ; l<=1; l++)
				 {
					 for(int m = -1; m<=1;m++)
					 {
						 //if(l != -1 && )
						 sum = sum + a[i+l][j+m];
					 }
				 }
				 
				 sum = sum - a[i][j-1]-a[i][j+1];
				 
				 b[i][j] = sum;
				 
				 max = Math.max(max, sum);
				 
			 }
						 
				
			
			//System.out.println();
		}
		
		
		
		for (int i = 1; i<5; i++)
		{
			for (int j = 1; j<5;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
		
      System.out.println(max);
	}

}
