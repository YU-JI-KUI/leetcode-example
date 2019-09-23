package easy;

import java.util.ArrayList;
import java.util.List;
/**
728. Self Dividing Numbers

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every 
possible self dividing number, including the bounds if possible.

Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

Note:
The boundaries of each input argument are 1 <= left <= right <= 10000.

 */
public class Test728 {
	
	public static void main(String[] args) {
		Test728 test728 = new Test728();
		List<Integer> list = test728.selfDividingNumbers(1, 20);
		for (Integer l: list){
			System.out.println(l);
		}
	}
	
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int n = left; n <= right; ++n) {
            if (selfDividing2(n)) ans.add(n);
        }
        return ans;
    }
    
    public boolean selfDividing1(int n) {
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }
    
    public boolean selfDividing2(int n){
        int original = n;
        while(n>0){
            int r = n%10;
            if(r == 0)            return false;
            if(original%r !=0)   return false;
            n /= 10;
        }
        return true;
    }
}
