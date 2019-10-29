package HackerRank;

import java.util.Scanner;

public class Check_IP_Address {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String IP = sc.nextLine();

		if (IP.length() == 0) {
			System.out.println("false");
		}

		else {

			if (IP.contains(".")) {

				if (IP.endsWith(".")) {
					System.out.println("false");
				} else {
					String[] IP_tokens = IP.split("[.]+");
					int c_part = 0;
					if (IP_tokens.length == 4) {

						for (String part : IP_tokens) {
							c_part = c_part + validate(part);
						}

						if (c_part == 4) {
							System.out.println("true");

						} else {
							System.out.println("false");
						}

					} else {
						System.out.println("false");
					}

				}
			}
		}

		sc.close();

	}

	private static int validate(String part) {
         
		int num;
		try
		{
		 num = Integer.parseInt(part);
		}
		catch (Exception e)
		{
			return 0;
		}

		if ((num < 0 || num > 255) || part.matches("[^0-9]+") || part.length() > 3) {
			return 0;

		}

		return 1;
	}

}
