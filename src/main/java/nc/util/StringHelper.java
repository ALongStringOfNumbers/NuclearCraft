package nc.util;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StringHelper {
	
	public static String capitalize(String string) {
		return string.isEmpty() ? string : (string.substring(0, 1).toUpperCase(Locale.ROOT) + string.substring(1));
	}
	
	public static String starting(String string, int length) {
		int fixedLength = Math.min(length, string.length());
		return string.substring(0, fixedLength);
	}
	
	public static String ending(String string, int length) {
		int fixedLength = Math.min(length, string.length());
		return string.substring(string.length() - fixedLength);
	}
	
	public static String removePrefix(String string, int length) {
		//int fixedLength = Math.min(length, string.length());
		return string.substring(length);
	}
	
	public static String removeSuffix(String string, int length) {
		//int fixedLength = Math.min(length, string.length());
		return string.substring(0, string.length() - length);
	}
	
	public static boolean beginsWith(String stringIn, String stringCheck) {
		return starting(stringIn, stringCheck.length()).equals(stringCheck);
	}
	
	public static String stringListConcat(List<String> stringList) {
		return String.join(", ", stringList);
	}
	
	public static String stringListConcat(List<String> firstStringList, List<String>... otherStringLists) {
		return String.join(", ", CollectionHelper.concatenate(firstStringList, otherStringLists));
	}
	
	public static String charLine(char ch, int length) {
		char[] charArray = new char[length];
		Arrays.fill(charArray, ch);
		return new String(charArray);
	}
}
