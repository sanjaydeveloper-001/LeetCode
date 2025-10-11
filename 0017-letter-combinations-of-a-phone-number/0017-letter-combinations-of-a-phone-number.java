import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    private List<String> combinations = new ArrayList<>();
    // Using a Map is cleaner than a large if/else or switch
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );
    private String phoneDigits;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combinations;
        }
        this.phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as the input digits, we found a combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return;
        }

        // Get the letters that correspond to the current digit
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            // Add the letter and move to the next digit
            path.append(letter);
            backtrack(index + 1, path);
            // Backtrack by removing the letter to try other options
            path.deleteCharAt(path.length() - 1);
        }
    }
}