import java.util.*;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int numberOfCases = reader.nextInt();
		int[] allResults = new int[numberOfCases];
		for (int i = 0; i < numberOfCases; i++) {
			String inputString = reader.next();
			int result = sherlockAndAnagrams(inputString);
			allResults[i] = result;
		}
		for (int i = 0; i < numberOfCases; i++) {
			System.out.println(allResults[i]);
		}
	}

	static int sherlockAndAnagrams(String inputString) {

		int totalAnagrams = 0;

		HashMap<String, Integer> uniqueSubstrings = new HashMap<String, Integer>();

		for (int from = 0; from < inputString.length(); from++) {
			for (int to = from + 1; to <= inputString.length(); to++) {
				inputString.substring(from, to).toCharArray();
				char[] subtringToArray = inputString.substring(from, to).toCharArray();
				Arrays.sort(subtringToArray);

				String clearString = Arrays.toString(subtringToArray).replaceAll("\\[", "").replaceAll("\\]", "")
						.replaceAll(",", "").replaceAll(" ", "");

				if (uniqueSubstrings.keySet().contains(clearString)) {
					int newGroupValue = uniqueSubstrings.get(clearString) + 1;
					uniqueSubstrings.put(clearString, newGroupValue);
				} else {
					uniqueSubstrings.put(clearString, 1);
				}
			}
		}
	
		for (String str : uniqueSubstrings.keySet()) {
			int numberOfCombinations = combinationsUniqueCharsGroup(uniqueSubstrings.get(str));
			totalAnagrams += numberOfCombinations;
		}
		return totalAnagrams;
	}

	public static int combinationsUniqueCharsGroup(int sameCharlength) {
		int result = ((1 + (sameCharlength - 1)) * (sameCharlength - 1)) / 2;
		return result;
	}
}
