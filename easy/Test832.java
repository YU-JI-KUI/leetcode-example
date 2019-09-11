package easy;
/**
Given a binary matrix A, we want to flip the image horizontally, 
then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  
For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. 
For example, inverting [0, 1, 1] results in [1, 0, 0].

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Notes:
	1 <= A.length = A[0].length <= 20
	0 <= A[i][j] <= 1

 */
public class Test832 {
	public static void main(String[] args) {
		
		int [][] A = {{1,1,0},{1,0,1},{0,0,0}};
		int [][] B = flipAndInvertImage1(A);
		for (int i = 0;i < B.length;i ++){
			for (int j = 0;j < B[i].length;j ++) {
				System.out.print(B[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] flipAndInvertImage1(int[][] A) {
		for(int i  = 0;i < A.length;i ++) {
			int[] holder = new int[A[i].length];
			for(int j = 0;j < A[i].length;j ++){
				int index = A[i].length - j - 1;
				holder[index] = A[i][j] == 0 ? 1 : 0;
			}
			A[i] = holder;
		}
		return A;
	}
	
	// 看不懂
    public static int[][] flipAndInvertImage2(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
	
    
    public static int[][] flipAndInvertImage3(int[][] A) {
    	for(int i = 0;i < A.length;i ++){
    		int left = 0 , right = A[0].length - 1;
    		while (A[i][left] == A[i][right]) {
    			A[i][left] = 1 - A[i][left];
    			A[i][right] = A[i][left];
    		}
    		left ++;
    		right ++;
    	}
    	return A;
    }
}
