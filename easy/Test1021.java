package easy;
/**
A valid parentheses string S is primitive if it is nonempty, and there does not exist 
a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the 
primitive decomposition of S.

Input: "(()())(())"
Output: "()()()"

Input: "(()())(())(()(()))"
Output: "()()()()(())"

S.length <= 10000
S[i] is "(" or ")"
S is a valid parentheses string
 */
public class Test1021 {
	
	public static void main(String[] args) {
		System.out.println(removeOuterParentheses1("(()())(())(()(()))"));
		System.out.println(removeOuterParentheses2("(()())(())(()(()))"));
		System.out.println(removeOuterParentheses3("(()())(())(()(()))"));
	}
	
	// 有点难理解
	public static String removeOuterParentheses3(String S) {
		StringBuilder sb = new StringBuilder();
		int opened = 0;
		for (char c : S.toCharArray()){
			if (c == '(' && opened ++ > 0) sb.append(c);
			if (c == ')' && opened -- > 1 ) sb.append(c);
		}
		return sb.toString();
	}
	
	public static String removeOuterParentheses2(String S) {
		StringBuilder sb = new StringBuilder();
		char[] c = S.toCharArray();
		int stack = 0;
		for (int i = 0; i < c.length; i ++) {
			if (c[i] == '('){
				stack ++;
				if (stack > 1){
					sb.append(c[i]);
				}
			}
			if (c[i] == ')'){
				stack --;
				if (stack > 0){
					sb.append(c[i]);
				}
			}
		}
		return sb.toString();
	}
	
	
	// () 是成对出现的，使用 start 记录 ( 使用 end 记录 ), 当 start = end 时，将两端去掉截出字符串拼接起来
	// 记录此时相等位置的索引，下一次截取继续该索引。
	public static String removeOuterParentheses1(String S) {
		StringBuilder sb = new StringBuilder();
		char[] cs = S.toCharArray();
		int start = 0,end = 0,index = 0;
		for (int i = 0;i < cs.length; i++){
			if (cs[i] == '('){
				start ++;
			}
			if (cs[i] == ')'){
				end ++;
			}
			if (start == end){
				sb.append(S.substring(index + 1, i));
				index = i + 1;
			}
		}
		return sb.toString();
	}
}
