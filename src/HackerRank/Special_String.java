package HackerRank;

import java.util.Scanner;

public class Special_String {

	static boolean flag = true;
//	private static boolean flag2 = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		int total = 0;
		if (input.length() == 0) {
			System.out.print(0);
		}

		else {
			for (int i = 0; i < input.length(); i++) {
				for (int j = i + 1; j <= input.length(); j++) {
					String sub = input.substring(i, j);

					if (sub.length() > 1) {
						int count = checkcountable(sub);
						if (count == 1 && flag == true) {
							System.out.println(sub);
							total = total + count;
						}

					} else {
						System.out.println(sub);
						total = total + 1;
					}

				}

			}

			System.out.println(total);

		}
		sc.close();
	}

	private static int checkcountable(String sub) {

		StringBuffer sb = new StringBuffer(sub);

		String reverse = sb.reverse().toString();

		if (reverse.equals(sub)) {
			removestring(sub);

			return 1;
		}

		return 0;
	}

	private static void removestring(String sub) {

		// check sequence
		for (int i = 0; i < sub.length() - 1; i++) {
			if (sub.charAt(i) != sub.charAt(i + 1)) {
				flag = false;
				break;
			}

		}

		if (flag == true) {
			return;
		} else {
			int sub_len = sub.length();

			if (sub_len % 2 != 0) {
				int centre = sub_len / 2;
				int c = 1;
				StringBuffer sb = new StringBuffer(sub);
				sb.deleteCharAt(centre);
				String s = sb.toString();
				// check sequence
				for (int i = 0; i < s.length() - 1; i++) {
					if (s.charAt(i) != s.charAt(i + 1)) {
						flag = false;
						break;
					} else {
						c++;
					}

				}
				if (c == s.length()) {
					flag = true;
				}
				return;
			} else {
				return;
			}

		}
	}

}
