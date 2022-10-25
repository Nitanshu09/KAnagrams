import java.util.*;

public class KAnagrams {
	public static boolean areKAnagrams(String s1, String s2, int k) {
		if (s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int c = 0;
		for (int i = 0; i < s1.length(); i++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
		}
		for (int j = 0; j < s2.length(); j++) {
			if (!map.isEmpty() && map.containsKey(s2.charAt(j))) {
				if (map.get(s2.charAt(j)) == 1) {
					map.remove(s2.charAt(j));
				} else {
					map.put(s2.charAt(j), map.getOrDefault(s2.charAt(j), 0) - 1);
				}
			} else {
				c++;
			}
		}
		if (c > k) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "fodr";
		String str2 = "gork";
		int k = 2;
		System.out.println(areKAnagrams(str1, str2, k));
	}

}
