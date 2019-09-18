package easy;

import java.util.Arrays;

/*
977. Squares of a Sorted Array

Given an array of integers A sorted in non-decreasing order, 
return an array of the squares of each number, also in sorted non-decreasing order.

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */
public class Test977 {
	public static void main(String[] args) {
		int[] A = { -7, -3, 2, 3, 11 };
		int[] is = sortedSquares2(A);
		for (int i = 0; i < is.length; i++) {
			System.out.println(is[i]);
		}
	}

	public static int[] sortedSquares1(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}
		Arrays.sort(A);
		return A;
	}

	public static int[] sortedSquares2(int[] A) {
		int n = A.length;
		int[] result = new int[n];
		int i = 0, j = n - 1;
		for (int p = n - 1; p >= 0; p--) {
			if (Math.abs(A[i]) > Math.abs(A[j])) {
				result[p] = A[i] * A[i];
				i++;
			} else {
				result[p] = A[j] * A[j];
				j--;
			}
		}
		return result;
	}
}
