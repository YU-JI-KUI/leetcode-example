package easy;

/**
 * 第 771 题：Jewels and Stones 求 S 中含有 J 中字符的个数，区分大小写，保证 J 中不重复，J和S的长度至少是 50。
 * 
 * 核心就是求字符串的包含，主要用到双重 for、chatAt()、indexOf()、contains() 方法。
 */
public class Test771 {

	public static void main(String[] args) {
		System.out.println(numJewelsInStones1("aA","aAAbbbb")); // 3
		System.out.println(numJewelsInStones2("aA","aAAbbbb"));
		System.out.println(numJewelsInStones3("aA","aAAbbbb"));
		System.out.println(numJewelsInStones4("aA","aAAbbbb")); // best one
	}

	public static int numJewelsInStones1(String J, String S) {
		int sum = 0;
		for (int i = 0;i < S.length();i ++) {
			for (int j = 0;j < J.length();j ++) {
				if (J.charAt(j) == S.charAt(i)) {
					sum ++;
				}
			}
		}
		return sum;
	}
	
	public static int numJewelsInStones2(String J, String S) {
		int sum = 0;
		for (int i = 0; i < S.length(); i++) {
			String str = Character.toString(S.charAt(i));
			// 因为 J 是去重的。
			if (J.contains(str)) {
				sum ++;
			}
		}
		return sum;
	}
	
	public static int numJewelsInStones3(String J, String S) {
		int sum = 0;
		for (int i = 0; i < S.length(); i++) {
			String str = Character.toString(S.charAt(i));
			// 因为 J 是去重的。
			if (J.indexOf(str) != -1) {
				sum ++;
			}
		}
		return sum;
	}
	
	//  0 ms, faster than 100.00% 
	public static int numJewelsInStones4(String J, String S) {
        int cnt = 0;
        char[] sArr = S.toCharArray();
        for(char c:sArr){
            if (J.indexOf(c) >= 0) 
            	cnt ++;
        }
        return cnt;
    }
}
