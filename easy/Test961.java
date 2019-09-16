package easy;

import java.util.Arrays;

/**
961. N-Repeated Element in Size 2N Array

In a array A of size 2N, there are N+1 unique elements, 
and exactly one of these elements is repeated N times.
Return the element repeated N times.

Input: [1,2,3,3]
Output: 3

Input: [5,1,5,2,5,3,5,4]
Output: 5

Note:
4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even

 */
public class Test961 {
	
	public static void main(String[] args) {
		int[] A = {5,1,5,2,5,3,5,4};
		System.out.println(repeatedNTimes1(A));
		System.out.println(repeatedNTimes2(A));
		System.out.println(repeatedNTimes3(A));
	}
	
	// 相同的那个数即为所求。
	public static int repeatedNTimes1(int[] A) {
		for (int i = 0;i < A.length;i ++){
			for (int j = i + 1;j < A.length;j ++){
				if (A[i] == A[j]) return A[i];
			}
		}
		return -1;
    }
	
	// 若 A 为有序数组，则只需要一次遍历即可。
	public static int repeatedNTimes2(int[] A) {
		Arrays.sort(A);
		for (int i = 0;i < A.length;i ++){
			if (A[i] == A[i+1]) return A[i];
		}
		return -1;
    }
	
	// 这种方式时间和空间复杂度最佳，先创建一个已经存在的数组，来一个存一个，若是来的这个已经存在，则为所求
	public static int repeatedNTimes3(int[] A) {
        int[] count = new int[10000];
        for (int i = 0; i < A.length; i++){
            if(count[A[i]] == 1)
                return A[i];
            else
                count[A[i]]++;
        }
        return -1;
    }
}
