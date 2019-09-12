package easy;
/**
905. Sort Array By Parity
Given an array A of non-negative integers, return an array consisting of all the even elements of A,
followed by all the odd elements of A.
偶数在前，奇数在后。（答案不固定）

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class Test905 {
	
	public static void main(String[] args) {
		int[] A = {3,1,2,4};
		int[] B = sortArrayByParity1(A);
		for(int i = 0;i < B.length;i ++){
			System.out.print(B[i]);
		}
	}
	
	// 这种思路比较简单粗暴，就是使用一个新的数组去接受想要的值。但是空间复杂度较高
	public static int[] sortArrayByParity1(int[] A) {
		int[] B = new int[A.length];
		int end = A.length - 1;
		int start = 0;
        for (int i = 0;i < A.length;i ++){
        	if(A[i] % 2 == 0){
        		B[start] = A[i];
        		start ++;
        	}
        	if(A[i] % 2 == 1){
        		B[end] = A[i];
        		end --;
        	}
        }
        return B;
    }
	
	// 这种方式就比较巧妙的避免创建新的数组，而且使用双指针可以加快遍历速度。只有在需要替换位置的时候才交换两个指针的值。
	public static int[] sortArrayByParity2(int[] A) {
		int left = 0, right = A.length-1;
		while (left < right) {
            while (left < right && A[left] % 2 == 0) left ++;
            while (right > left && A[right] % 2  == 1) right --;
            if (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }
        return A;
    }
}
