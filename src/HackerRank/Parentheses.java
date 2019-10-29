package HackerRank;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Parentheses extends Exception {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		try
		{
		Pattern.compile(s);
		System.out.print("YES");
		}
		catch(Exception e)
		{
			System.out.print("NO");
		}
	}

	}


