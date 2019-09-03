package easy;
/**
 * 第 1108 题：解密 IP 地址 (保证输入IP的有效性)
 * 输入 【1.1.1.1】，输出【1[.]1[.]1[.]1】
 */
public class Test1108 {
	public static void main(String[] args) {
		String address1 = defangIPaddr1("1.1.1.1");
		System.out.println(address1);
		
		String address2 = defangIPaddr2("1.1.1.1");
		System.out.println(address2);
	}
	
	/**
	 * 这里就不使用 String, 而使用 StringBUilder , 因为 String 不可变。
	 */
	public static String defangIPaddr2(String address){
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i < address.length();i ++){
			char c = address.charAt(i);
			if (c == '.') {
				sb.append("[.]");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * replace 方法本质上还是正则表达式
	 */
	public static String defangIPaddr1(String address) {
		return address.replace(".", "[.]");
	}
}
