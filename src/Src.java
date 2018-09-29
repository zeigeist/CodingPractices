import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Src
{
	// Read multi-line input from console in Java by using Scanner class
	public static void main(String[] args)
	{
		List<String> tokens = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			tokens.add(scanner.next());
		}

		scanner.close();
		System.out.println(tokens);
	}
}
