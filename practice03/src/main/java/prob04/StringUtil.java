package prob04;

import java.util.Arrays;

public class StringUtil {

	public static String concatenate(String[] str) {
//		return str.toString();
//		return String.valueOf(str);
//		return Arrays.toString(str);
		return String.join("", str);
	}
	
}
