package easy;
/**
657. Robot Return to Origin

Valid moves are R (right), L (left), U (up), and D (down). 
If the robot returns to the origin after it finishes all of its moves, 
return true. Otherwise, return false.

Input: "UD"
Output: true

Input: "LL"
Output: false

本题重点：灵活使用 if else 和 switch case 分支结构。
 */
public class Test657 {
	
	public static void main(String[] args) {
		System.out.println(judgeCircle1("RRRLLLUUUDDD"));
		System.out.println(judgeCircle2("RRRLLLUUUDDD"));
	}
	
	public static boolean judgeCircle1(String moves) {
		if(moves.equals("") || moves.length() % 2 != 0) return false;
		int countR = 0,countL = 0,countU = 0,countD = 0;
		for (int i = 0;i < moves.length();i ++){
			char c = moves.charAt(i);
			if (c == 'R') countR ++;
			else if (c == 'L') countL ++;
			else if (c == 'U') countU ++;
			else if (c == 'D') countD ++;
		}
		if (countR == countL && countU == countD){
			return true;
		} else {
			return false;			
		}
    }
	
	// 在多个分支的时候，switch 优于 if else , 因为 switch 中维护了一个分支表，可以直接定位到分支，而 if else 需要一个一个的
	// 遍历， switch 的缺点就是支持的数据类型不多（可以支持 string,char,byte...），且不能使用复合条件,如：x > 0 && x < 10。
	public static boolean judgeCircle2(String moves) {
		int x = 0,y = 0;
		for (char c : moves.toCharArray()){
			switch (c) {
				case 'R': x ++; break;
				case 'L': x --; break;
				case 'U': y ++; break;
				default : y --; break;
			}
		}
		return x == 0 && y == 0;
	}
}
