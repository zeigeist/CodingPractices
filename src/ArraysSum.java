import java.io.*;

class ArraysSum {

	public static void main (String[] args) throws java.lang.Exception {
		int arr1[] =    {2, 4};
		int arr2[] = {9, 5, 4, 9};
		//int result [] = computeSum(arr1, arr2);
		int result [] = sum(arr1, arr2);
		for (int i=0; i<result.length; i++) {
			if (i == 0 && result[i] == 0) {
				continue;
			}			
			System.out.print(result[i] + " "); // 9763
		}						
	}

	static int[] computeSum (int[] arr1, int[] arr2) {
		int length1 = arr1.length;
		int length2 = arr2.length;
		int result[] = new int[0];
		
		if (length1 == length2) {
			result = new int[length1];
		} else {
			result = new int[Math.max(length1, length2) + 1];
			int diff = Math.abs(length1 - length2);
			if (length2 < length1) {
				arr2 = preProcessArray(length2, arr2, diff);
			} else {
				arr1 = preProcessArray(length1, arr1, diff);
			}
		}
		
		int carry = 0, value = 0;
		int i = result.length-1;
		
		while (i > 0) {
			value = carry + arr1[i-1] + arr2[i-1];
			result[i] = value % 10;
			
			while (true) {
				int k = value/10;
				if (k <= 1) {
					carry = k;
					break;
				}
				value = k;
			}			
			i--;
		}

		result[0] = carry;		
		
		return result;
	}  
	
	static int[] preProcessArray(int length, int arr[], int diff) {
		int tempArr[] = new int[length + diff];		
		for (int d = 0; d<arr.length; d++) {
			int b = diff + d;
			tempArr[b] = arr[d];					
		}
		return tempArr;
	}
	
	public static int[] sum(int[] arr1, int[] arr2){
	    int carry = 0;
	    int sum = 0;

	    int len1 = arr1.length;
	    int len2 = arr2.length;
	    int len = Math.max(len1, len2);

	    int arr3[] = new int[len + 1];

	    for (int i = 1; i <= len; i++) {
	        sum = (len1 - i >= 0 ? arr1[len1-i] : 0)
	        		+ (len2 - i >= 0 ? arr2[len2-i] : 0)
	        		+ carry;

	        arr3[len-i+1] = sum%10;
	        carry = sum/10;
	    }
	    arr3[0] = carry;

	    return arr3;
	}
}