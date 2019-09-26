package easy;
/**
461. Hamming Distance

The Hamming distance between two integers is the number of positions at 
which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

异或运算：相同为 0，不同为 1。有多少个 1 就可以。
 */
public class Test461 {
	
	public static void main(String[] args) {
		System.out.println(hammingDistance1(1,4));
		System.out.println(hammingDistance2(1,4));
		System.out.println(hammingDistance3(1,4));
	}
	
	// 最硬核的解决方案，关键速度也快
    public static int hammingDistance1(int x, int y) {
    	return Integer.bitCount(x ^ y);
    }
    
    // 这种实现方式真的太巧妙了，想来好久才明白过来。
    public static int hammingDistance2(int x, int y) {
    	int xor = x ^ y, count = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }
    
    // 这种方式较慢…… 但是好理解
    public static int hammingDistance3(int x, int y) {
    	int xor = x ^ y, count = 0;
        String str = Integer.toBinaryString(xor);
        for (int i = 0;i < str.length();i ++){
        	if (str.charAt(i) == '1') count ++;
        }
        return count;
    }
}
