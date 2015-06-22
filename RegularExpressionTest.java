import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpressionTest {
	public static void main(String[] args) {
		String str1 = "Yahoo", str2 = "Yaho.";
		Pattern p  = Pattern.compile(str2);
		Matcher m = p.matcher(str1);
		System.out.println(m.matches());
	}
}
