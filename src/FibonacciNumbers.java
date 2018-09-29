import java.io.*;

class FibonacciNumbers {
  public static void main (String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    printFibonacciNumbers(input);
  }
  
  static void printFibonacciNumbers(int input) {
	  int x1 = 0;
	  int x2 = 1;

	  if (input < 1) {
		  return;
	  }

	  for (int i = 1; i <= input; i++) {
		  System.out.print(x2 + ", ");
		  int x = x1 + x2;
		  x1 = x2;
		  x2 = x;
	  }
  }  
}