package easy;
/*
 * 709. To Lower Case
 * Implement function ToLowerCase() that has a string parameter str, 
 * and returns the same string in lowercase.
 * 
Input: "Hello"
Output: "hello"

Input: "LOVELY"
Output: "lovely"
 */
public class Test709 {
	
	public static void main(String[] args) {
		System.out.println(toLowerCase1("ABCKris"));
		System.out.println(toLowerCase2("ABCKris"));
		System.out.println(toUpperCase("ABCKris"));
	}
	
	// 26个字母大写及小写对应的 ASCII 码值
	// a:97 ... z:122
	// A:65 ... Z:90
	public static String toLowerCase1(String str) {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
        	if (65 <= ch[i] && ch[i] <= 90) {
        		sb.append((char) (ch[i] + 32));
        	} else {
        		sb.append(ch[i]);
        	}
        }
        return sb.toString();
    }
	
	public static String toLowerCase2(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }
	
	// 这种方法空间复杂度低一点，从提交的记录来看，比自己使用  String.toLowerCase() 还要低。
	public static String toUpperCase(String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++)
			if ('a' <= a[i] && a[i] <= 'z')
				a[i] = (char) (a[i] - 'a' + 'A');
		return new String(a);
	}
}
