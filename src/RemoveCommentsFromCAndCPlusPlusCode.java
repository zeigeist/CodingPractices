import java.util.Scanner;

class RemoveCommentsFromCAndCPlusPlusCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder inputBuilder = new StringBuilder();
		while (sc.hasNextLine()) {
			inputBuilder.append(sc.nextLine());
		}
		System.out.println(removeCommentsFromSourceCode(inputBuilder.toString()));
		sc.close();		
	}

	private static String removeCommentsFromSourceCode(String sourceCode) {
		StringBuilder sb = new StringBuilder();
		char[] chars = sourceCode.toCharArray(); // convert to char array

		boolean singleLineComment = false; // that's //
		boolean doubleLineComment = false; // that's /*

		for (int i = 0; i < sourceCode.length(); i++) {
			if (chars[i] == '*' && chars[i + 1] == '/') {
				doubleLineComment = false;
				i++;
			} else if (singleLineComment || doubleLineComment) {
				continue;
			} else if (chars[i] == '/' && chars[i + 1] == '*') {
				doubleLineComment = true;
				i++;
			} else if (chars[i] == '/' && chars[i + 1] == '/') {
				singleLineComment = true;
				i++;
			} else {
				sb.append(chars[i]);
			}
		}
		return sb.toString();
	}
}
